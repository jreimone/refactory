package org.corefactoring.test;

import static org.junit.Assert.assertTrue;
import static org.ontomore.util.modelProvider.OWLRoleMappingProvider.CONVERT_DATAPROPERTY_TO_OBJECTPROPERTY;
import static org.ontomore.util.modelProvider.OWLRoleMappingProvider.DUPLICATE_CLASS;
import static org.ontomore.util.modelProvider.OWLRoleMappingProvider.EXTRACT_SUPERCLASS;
import static org.ontomore.util.modelProvider.OWLRoleMappingProvider.INTRODUCE_INVERSE_PROPERTY;
import static org.ontomore.util.modelProvider.OWLRoleMappingProvider.PULL_UP_PROPERTY;
import static org.ontomore.util.modelProvider.OWLRoleMappingProvider.RENAME_ELEMENT;

import java.util.List;

import org.corefactoring.core.CoRefactorer;
import org.corefactoring.modelelementmapper.ModelElementInitializer;
import org.corefactoring.modelregistry.ModelRegistry;
import org.corefactoring.modelregistry.ModelRegistryImpl;
import org.corefactoring.rolemappingregistry.RoleMappingInitializer;
import org.corefactoring.test.util.TestFileName;
import org.corefactoring.test.util.TestInputData;
import org.eclipse.emf.ecore.EObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ontomore.util.InputData;
import org.ontomore.util.ModelComparator;
import org.ontomore.util.ModelStorageUtil;
import org.ontomore.util.QueryUtil;
import org.ontomore.util.modelProvider.EcoreRoleMappingProvider;

public class CoRefactoringTest {

	private static final String base = ModelStorageUtil.getBase("org.corefactoring.test")
			+ "corefactoring/";
	private static ModelRegistry modelRegistry;
	private static CoRefactorer coRefactorer;

	private EObject model;
	private EObject coModel;
	private TestFileName testFileName;
	private TestFileName coTestFileName;

	@BeforeClass
	public static void singleSetUp() {
		coRefactorer = new CoRefactorer();
		modelRegistry = ModelRegistryImpl.getInstance();
		RoleMappingInitializer.registerRoleMappingMapper();
		ModelElementInitializer.registerModelElementMapper();
	}

	@Test
	public void testRename() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "RenameElement/RenameElement.owl";
		testInput.coModelFileName = "RenameElement/RenameElement.ecore";
		testInput.inputElementQuery = "ontology[0]/frames[0]";
		testInput.mapping = RENAME_ELEMENT.toRoleMapping();
		testInput.inputValue = "Human";
		testCoRefactoringExecution(testInput);
	}
	
	@Test
	public void testDuplicateClass() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "DuplicateClass/DuplicateClass.owl";
		testInput.coModelFileName = "DuplicateClass/DuplicateClass.ecore";
		testInput.inputElementQuery = "ontology[0]/frames[1]";
		testInput.mapping = DUPLICATE_CLASS.toRoleMapping();
		testInput.inputValue = "Manager";
		testCoRefactoringExecution(testInput);
	}
	
	@Test
	public void testConvertDataPropertyToObjectProperty() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "ConvertDataPropertyToObjectProperty/ConvertDataPropertyToObjectProperty.owl";
		testInput.coModelFileName = "ConvertDataPropertyToObjectProperty/ReplaceDataValueWithObject.ecore";
		testInput.inputElementQuery = "ontology[0]/frames[1]";
		testInput.mapping = CONVERT_DATAPROPERTY_TO_OBJECTPROPERTY.toRoleMapping();
		testInput.inputValue = "Address";
		testCoRefactoringExecution(testInput);
	}
	
	@Test
	public void testOwlPullUpProperty() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "PullUpProperty/PullUpProperty.owl";
		testInput.coModelFileName = "PullUpProperty/PullUpFeature.ecore";
		testInput.inputElementQuery = "ontology[0]/frames[3]";
		testInput.mapping = PULL_UP_PROPERTY.toRoleMapping();
		testInput.inputValue = "";
		testCoRefactoringExecution(testInput);
	}

	@Test
	public void testExtractSuperclass() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "ExtractSuperclass/ExtractSuperclass.owl";
		testInput.coModelFileName = "ExtractSuperclass/ExtractSuperclass.ecore";
		testInput.inputElementQuery = "ontology[0]/frames[2]";
		testInput.mapping = EXTRACT_SUPERCLASS.toRoleMapping();
		testInput.inputValue = "Person";
		testCoRefactoringExecution(testInput);
	}

	@Test
	public void testIntroduceInverseProperty() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "IntroduceInverseProperty/IntroduceInverseProperty.owl";
		testInput.coModelFileName = "IntroduceInverseProperty/IntroduceInverseReference.ecore";
		testInput.inputElementQuery = "ontology[0]/frames[2]";
		testInput.mapping = INTRODUCE_INVERSE_PROPERTY.toRoleMapping();
		testInput.inputValue = "hasEmployee";
		testCoRefactoringExecution(testInput);
	}
	
	/**
	 * Co-Refactoring in Ecore-->OWL direction.
	 */
	@Test
	public void testReplaceDataValueWithObject() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "ReplaceDataValueWithObject/ReplaceDataValueWithObject.ecore";
		testInput.coModelFileName = "ReplaceDataValueWithObject/ConvertDataPropertyToObjectProperty.owl";
		testInput.inputElementQuery = "eClassifiers[0]/eStructuralFeatures[0]";
		testInput.mapping = EcoreRoleMappingProvider.REPLACE_DATAVALUE_WITH_OBJECT.toRoleMapping();
		testInput.inputValue = "Address";
		testCoRefactoringExecution(testInput);
	}
	
	private void testCoRefactoringExecution(TestInputData testInput) {
		loadAndRegisterModels(testInput);
		InputData input = getInputData(testInput);

		List<EObject> result = coRefactorer.coRefactorModel(input);

		saveRefactoredModels(result);
		compareExpectedAndRefactoredModels(result);
	}

	private void loadAndRegisterModels(TestInputData testInput) {
		testFileName = new TestFileName(base + testInput.modelFileName);
		model = ModelStorageUtil.loadModelFromFileName(testFileName.getInputFileName());
		coTestFileName = new TestFileName(base + testInput.coModelFileName);
		coModel = ModelStorageUtil.loadModelFromFileName(coTestFileName.getInputFileName());
		modelRegistry.addEntry(model, coModel);
	}

	private InputData getInputData(TestInputData testInput) {
		InputData input = new InputData();
		input.model = model;
		EObject singleInputElement = QueryUtil.queryModel(model, testInput.inputElementQuery);
		input.inputElements = QueryUtil.getEObjectListOfSingleElement(singleInputElement);
		input.mapping = testInput.mapping;
		input.inputValues = QueryUtil.getStringListOfSingleElement(testInput.inputValue);
		return input;
	}

	private void saveRefactoredModels(List<EObject> result) {
		ModelStorageUtil.saveModelInResource(result.get(0),
				testFileName.getRefactoredFileName());
		ModelStorageUtil.saveModelInResource(result.get(1),
				coTestFileName.getRefactoredFileName());
	}

	private void compareExpectedAndRefactoredModels(List<EObject> result) {
		EObject expectedOwlModel = ModelStorageUtil.loadModelFromFileName(testFileName
				.getExpectedFileName());
		assertTrue(new ModelComparator().areModelsEqual(expectedOwlModel, result.get(0)));

		EObject expectedEcoreModel = ModelStorageUtil.loadModelFromFileName(coTestFileName
				.getExpectedFileName());
		assertTrue(new ModelComparator().areModelsEqual(expectedEcoreModel,
				result.get(1)));
	}
}
