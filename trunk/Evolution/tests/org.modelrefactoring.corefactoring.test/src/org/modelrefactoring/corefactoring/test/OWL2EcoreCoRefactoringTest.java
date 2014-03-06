package org.modelrefactoring.corefactoring.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
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
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.ltk.ModelRefactoringDescriptor;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelrefactoring.corefactoring.CoRefactorer;
import org.modelrefactoring.corefactoring.CoRefactorerFactory;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.CoedPackage;
import org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMetaInformation;
import org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResourceFactory;
import org.modelrefactoring.evolution.megamodel.MegamodelPackage;
import org.modelrefactoring.evolution.megamodel.architecture.ArchitectureFactory;
import org.modelrefactoring.evolution.megamodel.architecture.MetaMetaModel;
import org.modelrefactoring.evolution.megamodel.architecture.MetaModel;
import org.modelrefactoring.evolution.megamodel.cods.CODS;
import org.modelrefactoring.evolution.megamodel.cods.CodsFactory;
import org.modelrefactoring.evolution.megamodel.cods.CodsPackage;
import org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification;
import org.modelrefactoring.evolution.registry.IKnowledgeBase;
import org.modelrefactoring.evolution.registry.IKnowledgeBaseRegistry;

public class OWL2EcoreCoRefactoringTest {

	private static final String OUT								= "_OUT";
	private static final String IN 								= "_IN";

	private static final String INPUT_FOLDER					= "input";
	private static final String INPUT_FILE_ECORE				= "RenameElement_IN.text.ecore";
	private static final String INPUT_FILE_OWL					= "RenameElement_IN.owl";

	private static final String INPUT_RENAMEX					= "org.emftext.refactoring.renameX";
	private static final String INPUT_ROLEMODEL					= "rolemodel/RenameX.rolestext";
	private static final String INPUT_REFSPEC					= "refspec/RenameX.refspec";

	private static final String INPUT_RENAME_OWL				= "org.ontomore.refactoring";
	private static final String INPUT_RENAME_OWL_MAPPING		= "rolemappings/rename.rolemapping";
	private static final String INPUT_RENAME_OWL_REFACTORING	= "Rename Element";
	private static final String INPUT_RENAME_ECORE				= "org.emftext.refactoring.mappings.ecore";
	private static final String INPUT_RENAME_ECORE_MAPPING		= "rolemappings/renameElement.rolemapping";

	private static final String INPUT_COED						= "ecore_owl2.coed";
	private static final String INPUT_NEW_NAME					= "Human";
	
	private static MetaMetaModel ecoreMetaMetaModel;
	private static CODS cods;

	// input
	private OntologyDocument ontology;
	private org.emftext.language.owl.Class owlClass;
	private RoleMapping roleMappingOwl;

	// output
	private EPackage metamodel;
	private EClass ecoreClass;
	private ModelRefactoringDescriptor descriptor;

	@BeforeClass
	public static void staticInit(){
		registerLanguages();
		registerCODS();
		registerRefactorings();
		registerKnowledgeBase();
	}

	@Before
	public void init(){
		loadModels();
		registerDependencies();
		createAndExecuteRefactoring();
	}

	@Test
	public void testCoRefactorerAPI(){
		CoRefactorerFactory factory = new CoRefactorerFactory();
		IRefactorer refactorer = descriptor.getRefactorer();
		List<CoRefactorer> coRefactorers = factory.getCoRefactorers(refactorer);
		assertNotNull("at least one co-refactorer has to be determined", coRefactorers);
		assertEquals("one co-refactorer has to be determined", 1, coRefactorers.size());
		CoRefactorer coRefactorer = coRefactorers.get(0);
		IRefactorer initialRefactorer = coRefactorer.getInitialRefactorer();
		assertNotNull("the initial refactorer mustn't be null", initialRefactorer);
		EObject dependentModel = coRefactorer.getDependentModel();
		assertNotNull("the dependent model mustn't be null", dependentModel);
		List<EObject> dependentElements = coRefactorer.getDependentElements();
		assertTrue("there must be at least 1 dependent element", dependentElements != null && dependentElements.size() > 0);
		RoleMapping initialRoleMapping = coRefactorer.getInitialRoleMapping();
		assertNotNull("the initial rolemapping mustn't be null", initialRoleMapping);
		RoleMapping dependentRoleMapping = coRefactorer.getDependentRoleMapping();
		assertNotNull("the dependent rolemapping mustn't be null", dependentRoleMapping);
	}

	@Test
	public void testCoRefactoring(){
		CoRefactorerFactory factory = new CoRefactorerFactory();
		List<CoRefactorer> coRefactorers = factory.getCoRefactorers(descriptor.getRefactorer());
		assertTrue("one co-refactorer has to be determined", coRefactorers != null && coRefactorers.size() == 1);
		CoRefactorer coRefactorer = coRefactorers.get(0);
		EObject coRefactoredModel = coRefactorer.coRefactor();
		assertNotNull("the co-refactored model mustn't be null", coRefactoredModel);
		assertTrue("co-refactored model must be an EPackage", coRefactoredModel instanceof EPackage);
		saveModel(coRefactoredModel, INPUT_FOLDER + "/" + INPUT_FILE_ECORE.replace(IN, OUT));
	}

	private void createAndExecuteRefactoring() {
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(ontology.eResource(), roleMappingOwl);
		assertNotNull("refactorer couldn't be created", refactorer);
		List<org.emftext.language.owl.Class> selection = Arrays.asList(new org.emftext.language.owl.Class[]{owlClass});
		refactorer.setInput(selection);
		IValueProviderFactory factory = new TestValueProviderFactory(INPUT_NEW_NAME);
		refactorer.setValueProviderFactory(factory);
		EObject refactoredModel = refactorer.refactor();
		assertNotNull("refactored model mustn't be null", refactoredModel);
		saveModel(refactoredModel, INPUT_FOLDER + "/" + INPUT_FILE_OWL.replace(IN, OUT));
		descriptor = new ModelRefactoringDescriptor(refactorer);
	}

	protected void saveModel(EObject model, String fileName) {
		ResourceSet rs = new ResourceSetImpl();
		File file = new File(fileName);
		if(file.exists()){
			assertTrue("existing file " + fileName + " couldn't be deleted", file.delete());
		}
		URI uri = URI.createFileURI(file.getAbsolutePath());
		Resource resource = rs.createResource(uri);
		resource.getContents().add(model);
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void registerRefactorings() {
		try {
			RoleModel roleModel = loadModelByType("../" + INPUT_RENAMEX + "/" + INPUT_ROLEMODEL, RoleModel.class);
			IRoleModelRegistry.INSTANCE.registerRoleModel(roleModel);
			RefactoringSpecification refSpec = loadModelByType("../" + INPUT_RENAMEX + "/" + INPUT_REFSPEC, RefactoringSpecification.class);
			IRefactoringSpecificationRegistry.INSTANCE.registerRefSpec(refSpec);
			RoleMappingModel roleMappingModel = loadModelByType("../" + INPUT_RENAME_OWL + "/" + INPUT_RENAME_OWL_MAPPING, RoleMappingModel.class);
			RoleMapping roleMappingOwl = findFirstElementWithPropertyAndValue(roleMappingModel, "name", "Rename Element", RoleMapping.class);
			roleMappingModel = loadModelByType("../" + INPUT_RENAME_ECORE + "/" + INPUT_RENAME_ECORE_MAPPING, RoleMappingModel.class);
			RoleMapping roleMappingEcore = findFirstElementWithPropertyAndValue(roleMappingModel, "name", "Rename EElement", RoleMapping.class);
			IRoleMappingRegistry.INSTANCE.registerRoleMapping(roleMappingOwl);
			IRoleMappingRegistry.INSTANCE.registerRoleMapping(roleMappingEcore);
		} catch (RoleModelAlreadyRegisteredException | RefSpecAlreadyRegisteredException e) {
		}
	}

	private void registerDependencies() {
		owlClass = findFirstElementWithPropertyAndValue(ontology, "iri", "Person", org.emftext.language.owl.Class.class);
		ecoreClass = findFirstElementWithPropertyAndValue(metamodel, "name", "Person", EClass.class);
		IKnowledgeBaseRegistry registry = IKnowledgeBaseRegistry.INSTANCE;
		List<IKnowledgeBase> knowledgeBases = registry.getKnowledgeBases();
		for (IKnowledgeBase knowledgeBase : knowledgeBases) {
			if(knowledgeBase instanceof TestKnowledgeBase){
				((TestKnowledgeBase) knowledgeBase).addDependency(owlClass, ecoreClass);
			}
		}
	}
	
	private static void registerKnowledgeBase() {
		IKnowledgeBaseRegistry registry = IKnowledgeBaseRegistry.INSTANCE;
		TestKnowledgeBase knowledgeBase = new TestKnowledgeBase();
		registry.registerKnowledgeBase(knowledgeBase);
	}

	private static <T extends EObject> T findFirstElementWithPropertyAndValue(EObject model, String propertyName, Object propertyValue, Class<T> clazz) {
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
		MetaModel codsMetaModel = ArchitectureFactory.eINSTANCE.createMetaModel();
		codsMetaModel.setConformsTo(ecoreMetaMetaModel);
		codsMetaModel.setPackage(OwlPackage.eINSTANCE);
		cods.getModels().add(codsMetaModel);
		metamodel = loadModelByType(INPUT_FOLDER + "/" + INPUT_FILE_ECORE, EPackage.class);
		roleMappingOwl = IRoleMappingRegistry.INSTANCE.getRoleMappingByName(OwlPackage.eINSTANCE, INPUT_RENAME_OWL_REFACTORING);
		assertNotNull("rolemapping '" + INPUT_RENAME_OWL_REFACTORING + "' couldn't be found", roleMappingOwl);
		CoEvolutionDefinition coed = loadModelByType(INPUT_FOLDER + "/" + INPUT_COED, CoEvolutionDefinition.class);
		DomainSpecificEvolutionSpecification evolutionSpecification = CodsFactory.eINSTANCE.createDomainSpecificEvolutionSpecification();
		evolutionSpecification.setCoEvolutionDefinition(coed);
		evolutionSpecification.setReferenceModel(ecoreMetaMetaModel);
		cods.getDSES().add(evolutionSpecification);
	}

	private static <T extends EObject> T loadModelByType(String path, Class<T> clazz) {
		File file = new File(path);
		assertTrue("file " + path + " doesn't exist", file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		assertNotNull("resource " + path + " couldn't be loaded", resource);
		EObject model = resource.getContents().get(0);
		assertTrue("model in file " + path + " must be an instance of " + clazz.getSimpleName(), clazz.isInstance(model));
		return clazz.cast(model);
	}

	private static void registerLanguages() {
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
		// CODS, CoED
		EPackage.Registry.INSTANCE.put(CodsPackage.eNS_URI, CodsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(CoedPackage.eNS_URI, CoedPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new CoedMetaInformation().getSyntaxName(), new CoedResourceFactory());
	}
	
	private static void registerCODS() {
		cods = CodsFactory.eINSTANCE.createCODS();
		ecoreMetaMetaModel = ArchitectureFactory.eINSTANCE.createMetaMetaModel();
		ecoreMetaMetaModel.setPackage(EcorePackage.eINSTANCE);
		ecoreMetaMetaModel.setConformsTo(ecoreMetaMetaModel);
		cods.getModels().add(ecoreMetaMetaModel);
		MetaModel codsMetaModel = ArchitectureFactory.eINSTANCE.createMetaModel();
		codsMetaModel.setConformsTo(ecoreMetaMetaModel);
		codsMetaModel.setPackage(MegamodelPackage.eINSTANCE);
		cods.setConformsTo(codsMetaModel);
		cods.getModels().add(codsMetaModel);
		String codsString = "megamodel.cods";
		String uriString = "http://modelrefactoring.org/" + codsString;
		URI uri = URI.createURI(uriString);
		Resource resource = new ResourceImpl(uri);
		resource.getContents().add(cods);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("cods", new CODSResourceFactoryImpl(resource));
//		uri = URI.createURI(uriString);
//		URIConverter.URI_MAP.put(uri, resource.getURI());
	}
}
