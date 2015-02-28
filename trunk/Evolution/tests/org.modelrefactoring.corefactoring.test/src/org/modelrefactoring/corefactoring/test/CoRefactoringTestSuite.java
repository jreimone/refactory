package org.modelrefactoring.corefactoring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
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
import org.emftext.refactoring.tests.properties.Category;
import org.emftext.refactoring.tests.properties.KeyValuePair;
import org.emftext.refactoring.tests.properties.PropertiesPackage;
import org.emftext.refactoring.tests.properties.PropertyModel;
import org.emftext.refactoring.tests.properties.StringValue;
import org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation;
import org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResourceFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.modelrefactoring.corefactoring.CoRefactorer;
import org.modelrefactoring.corefactoring.CoRefactorerFactory;
import org.modelrefactoring.evolution.coed.Action;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.CoedPackage;
import org.modelrefactoring.evolution.coed.Event;
import org.modelrefactoring.evolution.coed.RoleMappingAction;
import org.modelrefactoring.evolution.coed.RoleMappingEvent;
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

@RunWith(Parameterized.class)
public class CoRefactoringTestSuite {

	private static final String OUT						= "_OUT";
	private static final String IN 						= "_IN";
	private static final String EXP 					= "_EXP";

	private static final String TESTDATA_DIR			= "testdata";
	private static final String FILE_CONFIG				= "config.testproperties";

	private static final String CATEGORY_INPUTS			= "inputs";
	private static final String CATEGORY_DEPENDENCY		= "dependency";
	private static final String CATEGORY_REFACTORING	= "refactoring";
	private static final String CATEGORY_ROLEMAPPING	= "rolemapping";

	private static final String KEY_SOURCE				= "source";
	private static final String KEY_SOURCE_EXPECTED		= "sourceExpected";
	private static final String KEY_TARGET				= "target";
	private static final String KEY_TARGET_EXPECTED		= "targetExpected";
	private static final String KEY_COED				= "coed";
	private static final String KEY_VALUE				= "value";
	private static final String KEY_INPUTFOLDER			= "inputFolder";
	private static final String KEY_ROLEMODEL			= "rolemodel";
	private static final String KEY_REFSPEC				= "refspec";
	private static final String KEY_ROLEMAPPING			= CATEGORY_ROLEMAPPING;
	private static final String KEY_NAME				= "name";
	private static final String KEY_SOURCE_INPUT 		= "sourceInput";

	private static MetaMetaModel ecoreMetaMetaModel;
	private static CODS cods;
	private ModelRefactoringDescriptor descriptor;

	@Parameter(0)
	public File testDataFolder;
	@Parameter(1)
	public EObject sourceModel;
	@Parameter(2)
	public EObject targetModel;
	@Parameter(3)
	public String value;
	@Parameter(4)
	public List<EObject> selectedElements;
	@Parameter(5)
	public String sourceFileName;
	@Parameter(6)
	public String targetFileName;
	@Parameter(7)
	public CoEvolutionDefinition coed;
	@Parameter(8)
	public String sourceMetamodelName;
	@Parameter(9)
	public String targetMetamodelName;
	@Parameter(10)
	public String sourceRoleMappingName;
	@Parameter(11)
	public String targetRoleMappingName;
	@Parameter(12)
	public EObject expectedSourceRefactoredModel;
	@Parameter(13)
	public EObject expectedTargetCoRefactoredModel;

	@Before
	public void init(){
		createAndExecuteInitialRefactoring();
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
		saveModel(coRefactoredModel, testDataFolder.getAbsolutePath() + "/" + targetFileName.replace(IN, OUT));
		// compare expected and (co-)refactored models
		if(expectedSourceRefactoredModel != null){
			List<Diff> differences = analyseComparison(sourceModel, expectedSourceRefactoredModel);
			assertEquals("models have differences", 0, differences.size());
		} else {
			System.out.println("no expected source refactored model available");
		}
		if(expectedTargetCoRefactoredModel != null){
			List<Diff> differences = analyseComparison(targetModel, expectedTargetCoRefactoredModel);
			assertEquals("models have differences", 0, differences.size());
		} else {
			System.out.println("no expected target refactored model available");
		}
	}

	private List<Diff> analyseComparison(EObject compareModel, EObject expectedModel) {
		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);
		EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();
		// Compare the two models
//		IComparisonScope scope = EMFCompare.createDefaultScope(compareModel, expectedModel);
		DefaultComparisonScope scope = new DefaultComparisonScope(compareModel, expectedModel, null);
		Comparison comparison = comparator.compare(scope);
		List<Diff> differences = comparison.getDifferences();
		for (Diff diff : differences) {
			if(diff instanceof AttributeChange){
				AttributeChange attributeChange = (AttributeChange) diff;
				EAttribute attribute = attributeChange.getAttribute();
				Match match = attributeChange.getMatch();
				EObject left = match.getLeft();
				EObject right = match.getRight();
				Object expectedValue = right.eGet(attribute);
				Object realValue = left.eGet(attribute);
				assertEquals("attribute '" + attribute.getName() + "' wasn't equal", expectedValue, realValue);
			}
		}
		return differences;
	}

	protected static void registerAdditionalLanguages() {
		// OWL
		EPackage.Registry.INSTANCE.put(OwlPackage.eNS_URI, OwlPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new OwlMetaInformation().getSyntaxName(), new OwlResourceFactory());
	}

	@Parameters(name = "{8} -> {9} : {10} -> {11}")
	public static Collection<Object[]> initParameterData(){
		registerLanguages();
		registerCODS();
		registerKnowledgeBase();
		List<Object[]> readData = new ArrayList<Object[]>();
		File testDataFolder = new File(TESTDATA_DIR);
		assertTrue("TestData folder " + TESTDATA_DIR + " must exist and must be a folder", testDataFolder.exists() && testDataFolder.isDirectory());
		File[] files = testDataFolder.listFiles();
		for (File file : files) {
			if(file.exists() && file.isDirectory()){
				PropertyModel propertyModel = loadModelByType(file.getAbsolutePath() + "/" + FILE_CONFIG, PropertyModel.class);
				List<Category> categories = propertyModel.getCategories();
				// Refactorings
				List<Category> refactoringCategories = getCategoriesWithName(categories, CATEGORY_REFACTORING);
				for (Category category : refactoringCategories) {
					String inputFolder = getValueByKey(category, KEY_INPUTFOLDER);
					String roleModelPath = getValueByKey(category, KEY_ROLEMODEL);
					String refspecPath = getValueByKey(category, KEY_REFSPEC);
					RoleModel roleModel = loadModelByType(inputFolder + "/" + roleModelPath, RoleModel.class);
					RefactoringSpecification refspec = loadModelByType(inputFolder + "/" + refspecPath, RefactoringSpecification.class);
					registerRefactoring(roleModel, refspec);
				}
				// RoleMappings
				List<Category> rolemappingCategories = getCategoriesWithName(categories, CATEGORY_ROLEMAPPING);
				for (Category category : rolemappingCategories) {
					String inputFolder = getValueByKey(category, KEY_INPUTFOLDER);
					String rolemappingPath = getValueByKey(category, KEY_ROLEMAPPING);
					String rolemappingName = getValueByKey(category, KEY_NAME);
					RoleMappingModel roleMappingModel = loadModelByType(inputFolder + "/" + rolemappingPath, RoleMappingModel.class);
					RoleMapping roleMapping = findFirstElementWithPropertyAndValue(roleMappingModel, "name", rolemappingName, RoleMapping.class);
					IRoleMappingRegistry.INSTANCE.registerRoleMapping(roleMapping);
				}
				// Inputs
				Category inputsCategory = getFirstCategoryWithName(categories, CATEGORY_INPUTS);
				String sourcePath = getValueByKey(inputsCategory, KEY_SOURCE);
				EObject sourceModel = loadModelByType(file.getAbsolutePath() + "/" + sourcePath, EObject.class);
				String targetPath = getValueByKey(inputsCategory, KEY_TARGET);
				EObject targetModel = loadModelByType(file.getAbsolutePath() + "/" + targetPath, EObject.class);
				// Expected Models
				EObject expectedSourceModel = null;
				String expectedFileName = getValueByKey(inputsCategory, KEY_SOURCE_EXPECTED);
				if(expectedFileName == null){
					File expectedFile = new File(file.getAbsolutePath() + "/" + sourcePath.replace(IN, EXP));
					if(expectedFile.exists()){
						expectedSourceModel = loadModelByType(expectedFile.getAbsolutePath(), EObject.class);
					}
				} else {
					expectedSourceModel = loadModelByType(file.getAbsolutePath() + "/" + expectedFileName, EObject.class);
				}
				EObject expectedTargetModel = null;
				expectedFileName = getValueByKey(inputsCategory, KEY_TARGET_EXPECTED);
				if(expectedFileName == null){
					File expectedFile = new File(file.getAbsolutePath() + "/" + targetPath.replace(IN, EXP));
					if(expectedFile.exists()){
						expectedTargetModel = loadModelByType(expectedFile.getAbsolutePath(), EObject.class);
					}
				} else {
					expectedTargetModel = loadModelByType(file.getAbsolutePath() + "/" + expectedFileName, EObject.class);
				}
				// CoED
				String coedPath = getValueByKey(inputsCategory, KEY_COED);
				CoEvolutionDefinition coed = loadModelByType(file.getAbsolutePath() + "/" + coedPath, CoEvolutionDefinition.class);
				DomainSpecificEvolutionSpecification evolutionSpecification = CodsFactory.eINSTANCE.createDomainSpecificEvolutionSpecification();
				evolutionSpecification.setCoEvolutionDefinition(coed);
				evolutionSpecification.setReferenceModel(ecoreMetaMetaModel);
				cods.getDSES().add(evolutionSpecification);
				String value = getValueByKey(inputsCategory, KEY_VALUE);
				String selectedElementsQuery = getValueByKey(inputsCategory, KEY_SOURCE_INPUT);
				List<EObject> selectedElements = QueryUtil.queryModel(sourceModel, selectedElementsQuery);
				assertNotNull("no elements could be queried", selectedElements);
				assertTrue("at least 1 element must be contained", selectedElements.size() > 0);
				// Dependencies
				List<Category> dependencyCategories = getCategoriesWithName(categories, CATEGORY_DEPENDENCY);
				for (Category category : dependencyCategories) {
					String sourceQuery = getValueByKey(category, KEY_SOURCE);
					String targetQuery = getValueByKey(category, KEY_TARGET);
					List<EObject> sourceElements = QueryUtil.queryModel(sourceModel, sourceQuery);
					assertNotNull("no source elements could be queried", sourceElements);
					assertEquals("only 1 element must be contained in the source", 1, sourceElements.size());
					EObject sourceElement = sourceElements.get(0);
					List<EObject> targetElements = QueryUtil.queryModel(targetModel, targetQuery);
					assertNotNull("no target elements could be queried", targetElements);
					IKnowledgeBaseRegistry registry = IKnowledgeBaseRegistry.INSTANCE;
					List<IKnowledgeBase> knowledgeBases = registry.getKnowledgeBases();
					for (IKnowledgeBase knowledgeBase : knowledgeBases) {
						if(knowledgeBase instanceof TestKnowledgeBase){
							TestKnowledgeBase testBase = (TestKnowledgeBase) knowledgeBase;
							for (EObject targetElement : targetElements) {
								testBase.addDependency(sourceElement, targetElement);
							}
						}
					}
				}
				Event event = coed.getEvent();
				assertTrue("event must be an instance of " + RoleMappingEvent.class.getSimpleName(), event instanceof RoleMappingEvent);
				RoleMapping sourceRoleMapping = ((RoleMappingEvent) event).getConcreteRefactoring();
				String sourceMetamodelName = sourceRoleMapping.getOwningMappingModel().getTargetMetamodel().getName();
				String sourceRolemappingName = sourceRoleMapping.getName();
				Action action = coed.getAction();
				assertTrue("action must be an instance of " + RoleMappingAction.class.getSimpleName(), action instanceof RoleMappingAction);
				RoleMapping targetRoleMapping = ((RoleMappingAction) action).getConcreteRefactoring();
				String targetMetamodelName = targetRoleMapping.getOwningMappingModel().getTargetMetamodel().getName();
				String targetRolemappingName = targetRoleMapping.getName();
				readData.add(new Object[]{file, sourceModel, targetModel, value, selectedElements, sourcePath, targetPath, coed, sourceMetamodelName, targetMetamodelName, sourceRolemappingName, targetRolemappingName, expectedSourceModel, expectedTargetModel});
			}
		}
		return readData;
	}

	protected void createAndExecuteInitialRefactoring() {
		Event event = coed.getEvent();
		assertTrue("event must be an instance of " + RoleMappingEvent.class.getSimpleName(), event instanceof RoleMappingEvent);
		RoleMappingEvent roleMappingEvent = (RoleMappingEvent) event;
		RoleMapping sourceRoleMapping = roleMappingEvent.getConcreteRefactoring();
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(sourceModel.eResource(), sourceRoleMapping);
		assertNotNull("refactorer couldn't be created", refactorer);
		refactorer.setInput(selectedElements);
		IValueProviderFactory factory = new TestValueProviderFactory(value);
		refactorer.setValueProviderFactory(factory);
		EObject refactoredModel = refactorer.refactor();
		assertNotNull("refactored model mustn't be null", refactoredModel);
		saveModel(refactoredModel, testDataFolder.getAbsolutePath() + "/" + sourceFileName.replace(IN, OUT));
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

	protected static String getValueByKey(Category category, String key) {
		List<KeyValuePair> pairs = category.getPairs();
		for (KeyValuePair keyValuePair : pairs) {
			if(keyValuePair.getKey().getName().equals(key)){
				return ((StringValue) keyValuePair.getValue()).getValue();
			}
		}
		return null;
	}

	protected static Category getFirstCategoryWithName(List<Category> categories, String categoryName) {
		for (Category category : categories) {
			if(category.getName().equals(categoryName)){
				return category;
			}
		}
		fail("Category '" + categoryName + "' wasn't found");
		return null;
	}

	protected static List<Category> getCategoriesWithName(List<Category> categories, String categoryName) {
		List<Category> namedCategories = new ArrayList<>();
		for (Category category : categories) {
			if(category.getName().equals(categoryName)){
				namedCategories.add(category);
			}
		}
		return namedCategories;
	}

	protected static <T extends EObject> T loadModelByType(String path, Class<T> clazz) {
		File file = new File(path);
		assertTrue("file " + path + " doesn't exist", file.exists());
		boolean convert = false;
		if(file.getName().endsWith(".ecore") && !file.getName().endsWith(".text.ecore")){
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
			convert = true;
		}
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		assertNotNull("resource " + path + " couldn't be loaded", resource);
		EObject model = resource.getContents().get(0);
		assertTrue("model in file " + path + " must be an instance of " + clazz.getSimpleName(), clazz.isInstance(model));
		if(convert){
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new TextEcoreResourceFactory());
			file = new File(file.getAbsolutePath().replace(".ecore", ".text.ecore"));
			if(file.exists()){
				assertTrue("file " + file.getName() + " couldn't be deleted", file.delete());
			}
			uri = URI.createFileURI(file.getAbsolutePath());
			//			rs = new ResourceSetImpl();
			resource = rs.createResource(uri);
			resource.getContents().add(model);
			try {
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return clazz.cast(model);
	}

	protected static void registerLanguages() {
		// Ecore
		//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		// Properties
		EPackage.Registry.INSTANCE.put(PropertiesPackage.eNS_URI, PropertiesPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new TestpropertiesMetaInformation().getSyntaxName(), new TestpropertiesResourceFactory());
		// Ecore Text
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new TextEcoreResourceFactory());
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
		registerAdditionalLanguages();
	}

	protected static void registerCODS() {
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
	}

	protected static void registerRefactoring(RoleModel roleModel, RefactoringSpecification refSpec) {
		try {
			RoleModel registeredRolemodel = IRoleModelRegistry.INSTANCE.getRoleModelByName(roleModel.getName());
			if(registeredRolemodel == null){
				IRoleModelRegistry.INSTANCE.registerRoleModel(roleModel);
				registeredRolemodel = roleModel;
			}
			RefactoringSpecification registeredRefspec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(registeredRolemodel);
			if(registeredRefspec == null){
				IRefactoringSpecificationRegistry.INSTANCE.registerRefSpec(refSpec);
			}
		} catch (RoleModelAlreadyRegisteredException | RefSpecAlreadyRegisteredException e) {
			e.printStackTrace();
		}
	}

	protected static <T extends EObject> T findFirstElementWithPropertyAndValue(EObject model, String propertyName, Object propertyValue, Class<T> clazz) {
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

	protected static void registerKnowledgeBase() {
		IKnowledgeBaseRegistry registry = IKnowledgeBaseRegistry.INSTANCE;
		TestKnowledgeBase knowledgeBase = new TestKnowledgeBase();
		registry.registerKnowledgeBase(knowledgeBase);
	}
}
