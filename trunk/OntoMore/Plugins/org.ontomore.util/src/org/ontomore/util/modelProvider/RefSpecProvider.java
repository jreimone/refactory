package org.ontomore.util.modelProvider;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.ontomore.util.ModelStorageUtil;

/**
 * Represents a RefactoringSpecification, knows its file path, and can give its model.
 * 
 * @author Erik Tittel
 */
public enum RefSpecProvider {

	RENAME_X (
			"org.emftext.refactoring.renameX/refspec/RenameX.refspec"),
	DUPLICATE_WITH_REFERENCE (
			"org.emftext.refactoring.duplicateWithReference/refspec/duplicateWithReference.refspec"),
	REPLACE_FEATURE (
			"org.emftext.refactoring.replaceFeature/refspec/replaceFeature.refspec"),
	REPLACE_FEATURE_IN_CONTAINER (
			"org.emftext.refactoring.replaceFeatureInContainer/refspec/replaceFeatureInContainer.refspec"),
	EXTRACT_LOOSELY_X (
			"org.emftext.refactoring.extractLooselyX/refspec/extractLooselyX.refspec"),
	EXTRACT_X (
			"org.emftext.refactoring.extractX/refspec/ExtractX.refspec"),
	REREFERENCE_X (
			"org.emftext.refactoring.rereferenceX/refspec/RereferenceX.refspec"),
	MOVE_X (
			"org.emftext.refactoring.moveX/refspec/moveX.refspec"),
	INTRODUCE_INVERSE_REFERENCE_IN_CONTAINER (
			"org.emftext.refactoring.introduceInverseReferenceInContainer/refspec/introduceInverseReferenceInContainer.refspec"),
	INTRODUCE_INVERSE_REFERENCE (
			"org.emftext.refactoring.introduceInverseReference/refspec/introduceInverseReference.refspec"),
	REMOVE_CONTAINED_X (
			"org.emftext.refactoring.removeContainedX/refspec/removeContainedX.refspec");
	
	private String base = ModelStorageUtil.WORKSPACE_DIRECTORY;
	private final String fileName;

	RefSpecProvider(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return fileName;
	}

	public RefactoringSpecification toModel() {
		EObject eObject = ModelStorageUtil.loadModelFromFileName(base + fileName);
		return (RefactoringSpecification) eObject;
	}
}
