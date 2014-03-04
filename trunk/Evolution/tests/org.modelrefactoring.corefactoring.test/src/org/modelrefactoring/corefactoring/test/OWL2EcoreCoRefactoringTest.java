package org.modelrefactoring.corefactoring.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
import org.emftext.language.owl.OntologyDocument;
import org.emftext.language.owl.OwlPackage;
import org.emftext.language.owl.resource.owl.mopp.OwlMetaInformation;
import org.emftext.language.owl.resource.owl.mopp.OwlResourceFactory;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.language.refactoring.specification.resource.mopp.RefspecMetaInformation;
import org.emftext.language.refactoring.specification.resource.mopp.RefspecResourceFactory;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;
import org.junit.Before;
import org.junit.Test;
import org.modelrefactoring.evolution.registry.IKnowledgeBase;
import org.modelrefactoring.evolution.registry.IKnowledgeBaseRegistry;

public class OWL2EcoreCoRefactoringTest {

	private static final String INPUT_FOLDER		= "input";
	private static final String INPUT_FILE_ECORE	= "RenameElement_IN.text.ecore";
	private static final String INPUT_FILE_OWL		= "RenameElement_IN.owl";
	
	private static final String INPUT_RENAMEX		= "org.emftext.refactoring.renameX";
	private static final String INPUT_ROLEMODEL		= "rolemodel/RenameX.rolestext";
	private static final String INPUT_REFSPEC		= "refspec/RenameX.refspec";
	
	private static final String INPUT_RENAME_OWL			= "org.ontomore.refactoring";
	private static final String INPUT_RENAME_OWL_MAPPING	= "rolemappings/rename.rolemapping";
	private static final String INPUT_RENAME_ECORE			= "org.emftext.refactoring.mappings.ecore";
	private static final String INPUT_RENAME_ECORE_MAPPING	= "rolemappings/renameElement.rolemapping";
	
	// input
	private OntologyDocument ontology;
	private org.emftext.language.owl.Class owlClass;
	private RoleMapping roleMappingOwl;
	
	// output
	private EPackage metamodel;
	private EClass ecoreClass;
	
	@Before
	public void init(){
		registerLanguages();
		registerRefactorings();
		loadModels();
		registerDependencies();
	}


	@Test
	public void testCoRefactoring(){
		List<IKnowledgeBase> knowledgeBases = IKnowledgeBaseRegistry.INSTANCE.getKnowledgeBases();
		assertTrue("no knowledgbases registered", knowledgeBases != null && knowledgeBases.size() == 1);
		IKnowledgeBase knowledgeBase = knowledgeBases.get(0);
		Resource resource = ontology.eResource();
		Map<EObject, Collection<EObject>> dependencies = knowledgeBase.getDependencies(resource.getURI(), resource.getResourceSet());
		assertTrue("no dependencies found for " + resource, dependencies != null && dependencies.size() > 0);
	}
	
	private void registerRefactorings() {
		RoleModel roleModel = loadModelByType("../" + INPUT_RENAMEX + "/" + INPUT_ROLEMODEL, RoleModel.class);
		RefactoringSpecification refSpec = loadModelByType("../" + INPUT_RENAMEX + "/" + INPUT_REFSPEC, RefactoringSpecification.class);
		RoleMappingModel roleMappingModel = loadModelByType("../" + INPUT_RENAME_OWL + "/" + INPUT_RENAME_OWL_MAPPING, RoleMappingModel.class);
		roleMappingOwl = findFirstElementWithPropertyAndValue(roleMappingModel, "name", "Rename Element", RoleMapping.class);
		roleMappingModel = loadModelByType("../" + INPUT_RENAME_ECORE + "/" + INPUT_RENAME_ECORE_MAPPING, RoleMappingModel.class);
		RoleMapping roleMappingEcore = findFirstElementWithPropertyAndValue(roleMappingModel, "name", "Rename EElement", RoleMapping.class);
		try {
			IRoleModelRegistry.INSTANCE.registerRoleModel(roleModel);
			IRefactoringSpecificationRegistry.INSTANCE.registerRefSpec(refSpec);
			IRoleMappingRegistry.INSTANCE.registerRoleMapping(roleMappingOwl);
			IRoleMappingRegistry.INSTANCE.registerRoleMapping(roleMappingEcore);
		} catch (RoleModelAlreadyRegisteredException | RefSpecAlreadyRegisteredException e) {
			e.printStackTrace();
		}
	}
	
	private void registerDependencies() {
		owlClass = findFirstElementWithPropertyAndValue(ontology, "iri", "Person", org.emftext.language.owl.Class.class);
		ecoreClass = findFirstElementWithPropertyAndValue(metamodel, "name", "Person", EClass.class);
		IKnowledgeBaseRegistry registry = IKnowledgeBaseRegistry.INSTANCE;
		TestKnowledgeBase knowledgeBase = new TestKnowledgeBase(owlClass, ecoreClass);
		registry.registerKnowledgeBase(knowledgeBase);
	}

	private <T extends EObject> T findFirstElementWithPropertyAndValue(EObject model, String propertyName, Object propertyValue, Class<T> clazz) {
		assertNotNull("model mustn't be null", model);
		assertNotNull("property name mustn't be null", propertyName);
		assertNotNull("property value mustn't be null", propertyValue);
		TreeIterator<EObject> treeIterator = model.eAllContents();
		while (treeIterator.hasNext()) {
			EObject element = (EObject) treeIterator.next();
			EClass metaclass = element.eClass();
			List<EAttribute> attributes = metaclass.getEAllAttributes();
			for (EAttribute attribute : attributes) {
				if(attribute.getName().equals(propertyName)){
					Object realValue = element.eGet(attribute);
					if(realValue.equals(propertyValue) && clazz.isInstance(element)){
						return clazz.cast(element);
					}
				}
			}
		}
		fail("model doesn't contain an element having a property called " + propertyName + " and a value " + propertyValue);
		return null;
	}

	private void loadModels() {
		ontology = loadModelByType(INPUT_FOLDER + "/" + INPUT_FILE_OWL, OntologyDocument.class);
		metamodel = loadModelByType(INPUT_FOLDER + "/" + INPUT_FILE_ECORE, EPackage.class);
	}

	private <T extends EObject> T loadModelByType(String path, Class<T> clazz) {
		File file = new File(path);
		assertTrue("file " + path + " doesn't exist", file.exists());
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI(file.getAbsolutePath());
		Resource resource = rs.getResource(uri, true);
		assertNotNull("resource " + path + " couldn't be loaded", resource);
		EObject model = resource.getContents().get(0);
		assertTrue("model in file " + path + " must be an instance of " + clazz.getSimpleName(), clazz.isInstance(model));
		return clazz.cast(model);
	}

	private void registerLanguages() {
		// Ecore
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		// Ecore Text
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new TextEcoreResourceFactory());
		// OWL
		EPackage.Registry.INSTANCE.put(OwlPackage.eNS_URI, OwlPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new OwlMetaInformation().getSyntaxName(), new OwlResourceFactory());
		// Refactoring
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolestextMetaInformation().getSyntaxName(), new RolestextResourceFactory());
		EPackage.Registry.INSTANCE.put(RefactoringSpecificationPackage.eNS_URI, RefactoringSpecificationPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RefspecMetaInformation().getSyntaxName(), new RefspecResourceFactory());
		EPackage.Registry.INSTANCE.put(RolemappingPackage.eNS_URI, RolemappingPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolemappingMetaInformation().getSyntaxName(), new RolemappingResourceFactory());
	}
}
