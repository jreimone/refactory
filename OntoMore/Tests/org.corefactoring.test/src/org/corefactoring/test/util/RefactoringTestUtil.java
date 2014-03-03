package org.corefactoring.test.util;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EObject;
import org.ontomore.util.ModelComparator;
import org.ontomore.util.ModelStorageUtil;
import org.ontomore.util.QueryUtil;
import org.ontomore.util.InputData;
import org.ontomore.util.RefactoryUtil;

public class RefactoringTestUtil {

	private static final String base = ModelStorageUtil.getBase("org.corefactoring.test")
			+ "refactoring/";

	public static void testRefactoringExecution(TestInputData testInput, RefactoryUtil refactoryUtil) {
		TestFileName testFileName = new TestFileName(base + testInput.modelFileName);
		InputData input = getInputData(testInput, testFileName);

		EObject refactoredModel = refactoryUtil.refactorModel(input);

		String refactoredModelFileName = testFileName.getRefactoredFileName();
		ModelStorageUtil.saveModelInResource(refactoredModel, refactoredModelFileName);

		String expectedModelFileName = testFileName.getExpectedFileName();
		EObject expectedModel = ModelStorageUtil.loadModelFromFileName(expectedModelFileName);
		assertTrue(new ModelComparator().areModelsEqual(expectedModel, refactoredModel));
	}

	private static InputData getInputData(TestInputData testInput,
			TestFileName testFileName) {
		String inputModelFileName = testFileName.getInputFileName();
		InputData input = new InputData();
		input.model = ModelStorageUtil.loadModelFromFileName(inputModelFileName);
		EObject singleInputElement = QueryUtil.queryModel(input.model, testInput.inputElementQuery);
		input.inputElements = QueryUtil.getEObjectListOfSingleElement(singleInputElement);
		input.mapping = testInput.mapping;
		input.inputValues = QueryUtil.getStringListOfSingleElement(testInput.inputValue);
		return input;
	}

	public static void testRefactoringExecutionTwice(TestInputData testInput, RefactoryUtil refactoryUtil) {
		// 1. run
		TestFileName intermediateTestFileName = new TestFileName(base + testInput.coModelFileName);
		String inputModelFileName = intermediateTestFileName.getInputFileName();

		InputData input = new InputData();
		input.model = ModelStorageUtil.loadModelFromFileName(inputModelFileName);
		EObject singleInputElement = QueryUtil.queryModel(input.model, testInput.inputElementQuery);
		input.inputElements = QueryUtil.getEObjectListOfSingleElement(singleInputElement);
		input.mapping = testInput.mapping;
		input.inputValues = QueryUtil.getStringListOfSingleElement(testInput.inputValue + "_intermediate");

		EObject refactoredModel = refactoryUtil.refactorModel(input);

		String refactoredModelFileName = intermediateTestFileName.getRefactoredFileName();
		ModelStorageUtil.saveModelInResource(refactoredModel, refactoredModelFileName);

		String expectedModelFileName = intermediateTestFileName.getExpectedFileName();
		EObject expectedModel = ModelStorageUtil.loadModelFromFileName(expectedModelFileName);
		assertTrue(new ModelComparator().areModelsEqual(expectedModel, refactoredModel));

		// 2. run
		inputModelFileName = intermediateTestFileName.getRefactoredFileName();
		input.model = ModelStorageUtil.loadModelFromFileName(inputModelFileName);
		singleInputElement = QueryUtil.queryModel(input.model, testInput.inputElementQuery);
		input.inputElements = QueryUtil.getEObjectListOfSingleElement(singleInputElement);
		input.inputValues = QueryUtil.getStringListOfSingleElement(testInput.inputValue);

		refactoredModel = refactoryUtil.refactorModel(input);

		TestFileName testFileName = new TestFileName(base + testInput.modelFileName);
		refactoredModelFileName = testFileName.getRefactoredFileName();
		ModelStorageUtil.saveModelInResource(refactoredModel, refactoredModelFileName);

		expectedModelFileName = testFileName.getExpectedFileName();
		expectedModel = ModelStorageUtil.loadModelFromFileName(expectedModelFileName);
		assertTrue(new ModelComparator().areModelsEqual(expectedModel, refactoredModel));
	}
}
