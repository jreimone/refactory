package org.ontomore.util.modelProvider;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.roles.RoleModel;
import org.ontomore.util.ModelStorageUtil;

/**
 * Represents a RoleModel, knows its file path, and can give its model.
 * 
 * @author Erik Tittel
 */
public enum RoleModelProvider {

	RENAME_X (
			"org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext"),
	DUPLICATE_WITH_REFERENCE (
			"org.emftext.refactoring.duplicateWithReference/rolemodel/duplicateWithReference.rolestext"),
	REPLACE_FEATURE (
			"org.emftext.refactoring.replaceFeature/rolemodel/replaceFeature.rolestext"),
	REPLACE_FEATURE_IN_CONTAINER (
			"org.emftext.refactoring.replaceFeatureInContainer/rolemodel/replaceFeatureInContainer.rolestext"),
	EXTRACT_LOOSELY_X (
			"org.emftext.refactoring.extractLooselyX/rolemodel/extracLooselyX.rolestext"),
	EXTRACT_X (
			"org.emftext.refactoring.extractX/rolemodel/ExtractX.rolestext"),
	REREFERENCE_X (
			"org.emftext.refactoring.rereferenceX/rolemodel/RereferenceX.rolestext"),
	MOVE_X (
			"org.emftext.refactoring.moveX/rolemodel/moveX.rolestext"),
	INTRODUCE_INVERSE_REFERENCE_IN_CONTAINER (
			"org.emftext.refactoring.introduceInverseReferenceInContainer/rolemodel/introduceInverseReferenceInContainer.rolestext"),
	INTRODUCE_INVERSE_REFERENCE (
			"org.emftext.refactoring.introduceInverseReference/rolemodel/introduceInverseReference.rolestext"),
	REMOVE_CONTAINED_X (
			"org.emftext.refactoring.removeContainedX/rolemodel/removeContainedX.rolestext");
	
	private String base = ModelStorageUtil.WORKSPACE_DIRECTORY;
	private final String fileName;

	RoleModelProvider(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return fileName;
	}

	public RoleModel toModel() {
		EObject eObject = ModelStorageUtil.loadModelFromFileName(base + fileName);
		return (RoleModel) eObject;
	}
}
