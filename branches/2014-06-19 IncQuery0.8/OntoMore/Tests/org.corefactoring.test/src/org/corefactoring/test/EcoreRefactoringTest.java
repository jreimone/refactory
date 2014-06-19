package org.corefactoring.test;

import static org.corefactoring.test.util.RefactoringTestUtil.testRefactoringExecution;
import static org.ontomore.util.modelProvider.EcoreRoleMappingProvider.*;

import org.corefactoring.test.util.TestInputData;
import org.junit.Ignore;
import org.junit.Test;
import org.ontomore.util.RefactoryUtil;

public class EcoreRefactoringTest {
	
	private static RefactoryUtil refactoryUtil = RefactoryUtil.getInstance();
	
	@Test
	public void testEcoreRename() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "EcoreRename/RenameEElement.ecore";
		testInput.inputElementQuery = "eClassifiers[0]";
		testInput.mapping = RENAME.toRoleMapping();
		testInput.inputValue = "Human";
		testRefactoringExecution(testInput, refactoryUtil);
	}
	
	@Test
	public void testEcoreDuplicateClass() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "EcoreDuplicateClass/DuplicateClass.ecore";
		testInput.inputElementQuery = "eClassifiers[1]";
		testInput.mapping = DUPLICATE_CLASS.toRoleMapping();
		testInput.inputValue = "Manager";
		testRefactoringExecution(testInput, refactoryUtil);
	}
	
	@Test
	public void testEcoreReplaceDataValueWithObject() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "EcoreReplaceDataValueWithObject/ReplaceDataValueWithObject.ecore";
		testInput.inputElementQuery = "eClassifiers[0]/eStructuralFeatures[0]";
		testInput.mapping = REPLACE_DATAVALUE_WITH_OBJECT.toRoleMapping();
		testInput.inputValue = "Address";
		// FIXME allow for several input values. Now the single input value is
		// used for all necessary inputs.
		testRefactoringExecution(testInput, refactoryUtil);
	}
	
	@Test
	public void testEcorePullUpFeature() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "EcorePullUpFeature/PullUpFeature.ecore";
		testInput.inputElementQuery = "eClassifiers[1]/eStructuralFeatures[0]";
		testInput.mapping = PULL_UP_FEATURE.toRoleMapping();
		testInput.inputValue = "";
		testRefactoringExecution(testInput, refactoryUtil);
	}
	
	@Test
	public void testEcoreExtractSuperclass() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "EcoreExtractSuperclass/ExtractSuperclass.ecore";
		testInput.inputElementQuery = "eClassifiers[0]/eStructuralFeatures[0]";
		testInput.mapping = EXTRACT_SUPERCLASS.toRoleMapping();
		testInput.inputValue = "Person";
		testRefactoringExecution(testInput, refactoryUtil);
	}
	
	@Test
	public void testEcoreIntroduceInverseReference() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "EcoreIntroduceInverseReference/IntroduceInverseReference.ecore";
		testInput.inputElementQuery = "eClassifiers[0]/eStructuralFeatures[0]";
		testInput.mapping = INTRODUCE_INVERSE_REFERENCE.toRoleMapping();
		testInput.inputValue = "hasEmployee";
		testRefactoringExecution(testInput, refactoryUtil);
	}
	
	@Test
	@Ignore
	// reference to inverse reference can't be removed. Thus saving or comparing
	// the model fails because of a dangling reference problem.
	public void testEcoreRemoveInverseReference() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "EcoreRemoveInverseReference/RemoveInverseReference.ecore";
		testInput.inputElementQuery = "eClassifiers[0]/eStructuralFeatures[0]";
		testInput.mapping = REMOVE_INVERSE_REFERENCE.toRoleMapping();
		testInput.inputValue = "";
		testRefactoringExecution(testInput, refactoryUtil);
	}
}
