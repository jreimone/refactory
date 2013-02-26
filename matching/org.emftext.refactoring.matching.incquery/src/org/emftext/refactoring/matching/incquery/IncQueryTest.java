/**
 * 
 */
package org.emftext.refactoring.matching.incquery;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.patternlanguage.emf.EMFPatternLanguageRuntimeModule;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ClassType;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguageFactory;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguageFactory;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.xbase.XbasePackage;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAssociation;
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author jreimann
 *
 */
public class IncQueryTest {

	private static final String INPUT_FILE					= "../org.emftext.refactoring.extractXwithReferenceClass/rolemodel/ExtractXwithReferenceClass.rolestext";
	//	private static final String INPUT_FILE					= "../org.emftext.refactoring.extractX/rolemodel/ExtractX.rolestext";
	private static final String TEMPLATE_FILE				= "template/base.eiq";
	private static final String OUTPUT_FOLDER				= "output";

	private static final String CONTAINMENT_PATTERN_NAME	= "containment";
	private static final String REFERENCE_PATTERN_NAME		= "reference";

	private static Resource patternResource;
	private static RoleModel roleModel;
	// a template will be loaded first which then can be extended
	private static PatternModel patternModel;
	// patterns to be referenced in generated pattern
	private static Pattern containmentPattern;
	private static Pattern referencePattern;

	@BeforeClass
	public static void init(){
		initLanguages();
		initModels();
		initReferencedPatterns();
	}

	@Test
	public void generatePatternTest(){
		PatternLanguageFactory factory = PatternLanguageFactory.eINSTANCE;
		Pattern pattern = factory.createPattern();
		pattern.setName(roleModel.getName());
		PatternBody patternBody = factory.createPatternBody();
		pattern.getBodies().add(patternBody);
		Map<String, Variable> variableNameMap = new HashMap<>();
		for (Role role : roleModel.getRoles()) {
			Variable variable = factory.createVariable();
			variable.setName(role.getName());
			ClassType classType = EMFPatternLanguageFactory.eINSTANCE.createClassType();
			classType.setClassname(EcorePackage.Literals.ECLASS);
			variable.setType(classType);
			variableNameMap.put(variable.getName(), variable);
			pattern.getParameters().add(variable);
		}
		for (Collaboration collaboration : roleModel.getCollaborations()) {
			if(collaboration instanceof MultiplicityCollaboration){
				MultiplicityCollaboration coll = (MultiplicityCollaboration) collaboration;
				Variable variable = factory.createVariable();
				variable.setName(coll.getTargetName());
				ClassType classType = EMFPatternLanguageFactory.eINSTANCE.createClassType();
				classType.setClassname(EcorePackage.Literals.EREFERENCE);
				variable.setType(classType);
				pattern.getParameters().add(variable);
				PatternCall patternCall = factory.createPatternCall();
				Pattern calledPattern = null;
				if(coll instanceof RoleComposition){
					calledPattern = containmentPattern;
				} else if(coll instanceof RoleAssociation){
					calledPattern = referencePattern;
				}
				assertNotNull("calledPattern mustn't be null", calledPattern);
				patternCall.setPatternRef(calledPattern);
				VariableValue sourceValue = factory.createVariableValue();
				VariableValue targetValue = factory.createVariableValue();
				VariableReference sourceVariableReference = factory.createVariableReference();
				VariableReference targetVariableReference = factory.createVariableReference();
				//				sourceVariableReference.setVariable(variableNameMap.get(coll.getSource().getName()));
				ParameterRef sourceParameterRef = factory.createParameterRef();
				sourceParameterRef.setReferredParam(variableNameMap.get(coll.getSource().getName()));
				sourceVariableReference.setVariable(sourceParameterRef);
				//				targetVariableReference.setVariable(variableNameMap.get(coll.getTarget().getName()));
				ParameterRef targetParameterRef = factory.createParameterRef();
				targetParameterRef.setReferredParam(variableNameMap.get(coll.getTarget().getName()));
				targetVariableReference.setVariable(targetParameterRef);
				sourceVariableReference.setVar(sourceParameterRef.getReferredParam().getName());
				targetVariableReference.setVar(targetParameterRef.getReferredParam().getName());
				sourceValue.setValue(sourceVariableReference);
				targetValue.setValue(targetVariableReference);
				patternCall.getParameters().add(sourceValue);
				// add parameter for relation
				VariableValue referenceValue = factory.createVariableValue();
				VariableReference referenceVariableReference = factory.createVariableReference();
				sourceVariableReference.setVariable(variable);
				referenceVariableReference.setVar(variable.getName());
				referenceValue.setValue(referenceVariableReference);
				patternCall.getParameters().add(referenceValue);
				// until here
				patternCall.getParameters().add(targetValue);
				PatternCompositionConstraint constraint = factory.createPatternCompositionConstraint();
				constraint.setCall(patternCall);
				patternBody.getConstraints().add(constraint);
			}
		}
		patternModel.getPatterns().add(pattern);
		try {
			patternResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void initReferencedPatterns() {
		List<Pattern> patterns = patternModel.getPatterns();
		for (Pattern pattern : patterns) {
			if(pattern.getName().equals(CONTAINMENT_PATTERN_NAME)){
				containmentPattern = pattern;
			} 
			if(pattern.getName().equals(REFERENCE_PATTERN_NAME)){
				referencePattern = pattern;
			}
			if(referencePattern != null && containmentPattern != null){
				break;
			}
		}
		assertNotNull("containment pattern mustn't be null", containmentPattern);
		assertNotNull("reference pattern mustn't be null", referencePattern);
	}

	public static void initModels() {
		ResourceSet rs = new ResourceSetImpl();
		// input model
		File file = new File(INPUT_FILE);
		assertTrue("file " + file.getAbsolutePath() + " must exist", file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		EObject model = rs.getResource(uri, true).getContents().get(0);
		assertTrue("must be a RoleModel", model instanceof RoleModel);
		roleModel = (RoleModel) model;
		assertNotNull("Role model mustn't be null", roleModel);

		// template file which will be extended by generated pattern
		file = new File(TEMPLATE_FILE);
		assertTrue("template file " + file.getAbsolutePath() + " must exist", file.exists());
		uri = URI.createFileURI(file.getAbsolutePath());
		model = rs.getResource(uri, true).getContents().get(0);
		assertTrue("must be a PatternModel", model instanceof PatternModel);
		patternModel = EcoreUtil.copy((PatternModel) model);

		// output model
		file = new File(OUTPUT_FOLDER + "/" + roleModel.getName() + "." + uri.fileExtension());
		if(file.exists()){
			file.delete();
		}
		assertFalse("File " + file.getName() + " must not exist", file.exists());
		uri = URI.createFileURI(file.getAbsolutePath());
		patternResource = rs.createResource(uri);
		assertNotNull("Pattern resource mustn't be null", patternResource);
		patternResource.getContents().add(patternModel);
	}

	private static void initLanguages(){
		// Ecore
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		// role models
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolestextMetaInformation().getSyntaxName(), new RolestextResourceFactory());
		// XMI
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		// Pattern language
		EPackage.Registry.INSTANCE.put(XbasePackage.eNS_URI, XbasePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(PatternLanguagePackage.eNS_URI, PatternLanguagePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(EMFPatternLanguagePackage.eNS_URI, EMFPatternLanguagePackage.eINSTANCE);
		Injector injector = Guice.createInjector(new EMFPatternLanguageRuntimeModule());
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("eiq", resourceFactory);
	}


}
