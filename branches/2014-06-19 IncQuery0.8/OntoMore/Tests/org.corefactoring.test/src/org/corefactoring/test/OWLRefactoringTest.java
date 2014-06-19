package org.corefactoring.test;

import static org.corefactoring.test.util.RefactoringTestUtil.*;
import static org.ontomore.util.modelProvider.OWLRoleMappingProvider.*;

import org.corefactoring.test.util.TestInputData;
import org.junit.Ignore;
import org.junit.Test;
import org.ontomore.util.RefactoryUtil;

public class OWLRefactoringTest {

	private static RefactoryUtil refactoryUtil = RefactoryUtil.getInstance();
	
	@Test
	public void testOwlRenameElement() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "OwlRenameElement/RenameElement.owl";
		testInput.inputElementQuery = "ontology[0]/frames[0]";
		testInput.mapping = RENAME_ELEMENT.toRoleMapping();
		testInput.inputValue = "Human";
		testRefactoringExecution(testInput, refactoryUtil);
	}
	
	@Test
	public void testOwlRenameElementTwice() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "OwlRenameElementTwice/RenameElement.owl";
		testInput.coModelFileName = "OwlRenameElementTwice/RenameElement_i.owl";
		testInput.inputElementQuery = "ontology[0]/frames[0]";
		testInput.mapping = RENAME_ELEMENT.toRoleMapping();
		testInput.inputValue = "Human";
		testRefactoringExecutionTwice(testInput, refactoryUtil);
	}

	@Test
	public void testOwlRenameOntology() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "OwlRenameOntology/RenameOntology.owl";
		testInput.inputElementQuery = "ontology[0]";
		testInput.mapping = RENAME_ONTOLOGY.toRoleMapping();
		testInput.inputValue = "http://ontomore.org/test/newName.owl";
		testRefactoringExecution(testInput, refactoryUtil);
	}
	
	@Test
	public void testOwlDuplicateClass() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "OwlDuplicateClass/DuplicateClass.owl";
		testInput.inputElementQuery = "ontology[0]/frames[1]";
		testInput.mapping = DUPLICATE_CLASS.toRoleMapping();
		testInput.inputValue = "Manager";
		testRefactoringExecution(testInput, refactoryUtil);
	}
	
	@Test
	public void testOwlConvertDataPropertyToObjectProperty() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "OwlConvertDataPropertyToObjectProperty/ConvertDataPropertyToObjectProperty.owl";
		testInput.inputElementQuery = "ontology[0]/frames[1]";
		testInput.mapping = CONVERT_DATAPROPERTY_TO_OBJECTPROPERTY.toRoleMapping();
		testInput.inputValue = "Address";
		testRefactoringExecution(testInput, refactoryUtil);
	}
	
	@Test
	public void testOwlPullUpProperty() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "OwlPullUpProperty/PullUpProperty.owl";
		testInput.inputElementQuery = "ontology[0]/frames[3]";
		testInput.mapping = PULL_UP_PROPERTY.toRoleMapping();
		testInput.inputValue = "";
		testRefactoringExecution(testInput, refactoryUtil);
	}

	@Test
	public void testOwlExtractSuperclass() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "OwlExtractSuperclass/ExtractSuperclass.owl";
		testInput.inputElementQuery = "ontology[0]/frames[2]";
		testInput.mapping = EXTRACT_SUPERCLASS.toRoleMapping();
		testInput.inputValue = "Person";
		testRefactoringExecution(testInput, refactoryUtil);
	}

	@Test
	public void testOwlIntroduceInverseProperty() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "OwlIntroduceInverseProperty/IntroduceInverseProperty.owl";
		testInput.inputElementQuery = "ontology[0]/frames[2]";
		testInput.mapping = INTRODUCE_INVERSE_PROPERTY.toRoleMapping();
		testInput.inputValue = "hasEmployee";
		testRefactoringExecution(testInput, refactoryUtil);
	}

	@Test
	@Ignore
	// reference to inverse property can't be removed. Thus a comparison of
	// expected and refactored ontology is not possible, as refactored ontology
	// is inconsistent.
	public void testOwlRemoveInverseProperty() {
		TestInputData testInput = new TestInputData();
		testInput.modelFileName = "OwlRemoveInverseProperty/RemoveInverseProperty.owl";
		testInput.inputElementQuery = "ontology[0]/frames[2]";
		testInput.mapping = REMOVE_INVERSE_PROPERTY.toRoleMapping();
		testInput.inputValue = "";
		testRefactoringExecution(testInput, refactoryUtil);
	}
}
