package org.emftext.refactoring.matching.incquery;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue;
import org.eclipse.xtext.resource.IResourceFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CopyOfIncQueryTest {
	
	private static final String[] NAMES 	= new String[]{"OrigContainer","ContainerContainer", "Extract", "NewContainer", "MovedReference"};
	private static final String[] relations = new String[]{
		"extracts:OrigContainer:Extract"
		,"source:ContainerContainer:OrigContainer"
		, "target:ContainerContainer:NewContainer"
		, "referer:OrigContainer:MovedReference"
		, "moved:NewContainer:Extract"
		, "containerRef:MovedReference:NewContainer->"};

	private static final String TEMPLATE_FILE				= "template/base.eiq";
	private static final String OUTPUT_FOLDER				= "output";

	private static final String CONTAINMENT_PATTERN_NAME	= "containment";
	private static final String REFERENCE_PATTERN_NAME		= "reference";
	
	private static Resource patternResource;
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
		pattern.setName("ExtractXWithRefClass");
		PatternBody patternBody = factory.createPatternBody();
		pattern.getBodies().add(patternBody);
		Map<String, Variable> variableNameMap = new HashMap<>();
		for (String name : NAMES) {
			Variable variable = factory.createVariable();
			variable.setName(name);
			ClassType classType = EMFPatternLanguageFactory.eINSTANCE.createClassType();
			classType.setTypename(EClass.class.getSimpleName());
			variable.setType(classType);
			variableNameMap.put(variable.getName(), variable);
			pattern.getParameters().add(variable);
		}
		for (String coll : relations) {
				String[] parts = coll.split(":");
				String name = parts[0];
				String source = parts[1];
				String target = parts[2];
				boolean isReference = target.endsWith("->");
				if(isReference){
					target = target.substring(0, target.length() - 2);
				}
				Variable variable = factory.createVariable();
				variable.setName(name);
				ClassType classType = EMFPatternLanguageFactory.eINSTANCE.createClassType();
				classType.setTypename(EReference.class.getSimpleName());
				variable.setType(classType);
				pattern.getParameters().add(variable);
				PatternCall patternCall = factory.createPatternCall();
				Pattern calledPattern = null;
				if(isReference){
					calledPattern = referencePattern;
				} else {
					calledPattern = containmentPattern;
				}
				assertNotNull("calledPattern mustn't be null", calledPattern);
				patternCall.setPatternRef(calledPattern);
				VariableValue sourceValue = factory.createVariableValue();
				VariableValue targetValue = factory.createVariableValue();
				VariableReference sourceVariableReference = factory.createVariableReference();
				VariableReference targetVariableReference = factory.createVariableReference();
				ParameterRef sourceParameterRef = factory.createParameterRef();
				sourceParameterRef.setReferredParam(variableNameMap.get(source));
				sourceVariableReference.setVariable(sourceParameterRef);
				ParameterRef targetParameterRef = factory.createParameterRef();
				targetParameterRef.setReferredParam(variableNameMap.get(target));
				targetVariableReference.setVariable(targetParameterRef);
				sourceVariableReference.setVar(sourceParameterRef.getReferredParam().getName());
				targetVariableReference.setVar(targetParameterRef.getReferredParam().getName());
				sourceValue.setValue(sourceVariableReference);
				targetValue.setValue(targetVariableReference);
				patternCall.getParameters().add(sourceValue);
				if(isReference){
					VariableValue referenceValue = factory.createVariableValue();
					VariableReference referenceVariableReference = factory.createVariableReference();
					sourceVariableReference.setVariable(variable);
					referenceVariableReference.setVar(variable.getName());
					referenceValue.setValue(referenceVariableReference);
					patternCall.getParameters().add(referenceValue);
				}
				patternCall.getParameters().add(targetValue);
				PatternCompositionConstraint constraint = factory.createPatternCompositionConstraint();
				constraint.setCall(patternCall);
				patternBody.getConstraints().add(constraint);
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

		// template file which will be extended by generated pattern
		File file = new File(TEMPLATE_FILE);
		assertTrue("template file " + file.getAbsolutePath() + " must exist", file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		EObject model = rs.getResource(uri, true).getContents().get(0);
		assertTrue("must be a PatternModel", model instanceof PatternModel);
		patternModel = (PatternModel) model;
		
		// output model
		file = new File(OUTPUT_FOLDER + "/ExtractXWithRefClass." + uri.fileExtension());
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
		// XMI
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		// Pattern language
		EPackage.Registry.INSTANCE.put(EMFPatternLanguagePackage.eNS_URI, EMFPatternLanguagePackage.eINSTANCE);
		Injector injector = Guice.createInjector(new EMFPatternLanguageRuntimeModule());
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("eiq", resourceFactory);
	}
	
	
}
