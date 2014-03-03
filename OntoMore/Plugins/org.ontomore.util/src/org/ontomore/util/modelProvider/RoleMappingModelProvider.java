package org.ontomore.util.modelProvider;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.ontomore.util.ModelStorageUtil;

/**
 * Represents a RoleMappingModel, knows its file path, and can give its model.
 * 
 * @author Erik Tittel
 */
public enum RoleMappingModelProvider {

	OWL_RENAME("org.ontomore.refactoring/rolemappings/rename.rolemapping"),
	OWL_DUPLICATE_CLASS("org.ontomore.refactoring/rolemappings/duplicateClass.rolemapping"),
	OWL_CONVERT_DATAPROPERTY_TO_OBJECTPROPERTY("org.ontomore.refactoring/rolemappings/convertDataProperty.rolemapping"),
	OWL_EXTRACT_SUPERCLASS("org.ontomore.refactoring/rolemappings/extractSuperClass.rolemapping"),
	OWL_PULL_UP_PROPERTY("org.ontomore.refactoring/rolemappings/pullUpProperty.rolemapping"),
	OWL_INTRODUCE_INVERSE_PROPERTY("org.ontomore.refactoring/rolemappings/introduceInverseProperty.rolemapping"),
	OWL_REMOVE_INVERSE_PROPERTY("org.ontomore.refactoring/rolemappings/removeInverseProperty.rolemapping"),

	ECORE_RENAME("org.emftext.refactoring.mappings.ecore/rolemappings/renameElement.rolemapping"),
	ECORE_DUPLICATE_CLASS("org.emftext.refactoring.mappings.ecore.extended/rolemappings/duplicateClass.rolemapping"),
	ECORE_REPLACE_DATAVALUE_WITH_OBJECT("org.emftext.refactoring.mappings.ecore.extended/rolemappings/replaceDataValueWithObject.rolemapping"),
	ECORE_EXTRACT_SUPERCLASS("org.emftext.refactoring.mappings.ecore/rolemappings/extractSuperClass.rolemapping"),
	ECORE_PULL_UP_FEATURE("org.emftext.refactoring.mappings.ecore/rolemappings/pullUp.rolemapping"), 
	ECORE_INTRODUCE_INVERSE_REFERENCE("org.emftext.refactoring.mappings.ecore.extended/rolemappings/introduceInverseReference.rolemapping"),
	ECORE_REMOVE_INVERSE_REFERENCE("org.emftext.refactoring.mappings.ecore.extended/rolemappings/removeInverseReference.rolemapping");

	private String base = ModelStorageUtil.WORKSPACE_DIRECTORY;
	private final String fileName;

	RoleMappingModelProvider(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return fileName;
	}

	public RoleMappingModel toModel() {
		// Caution: RoleMappingModels have to be REloaded to remove markers. The
		// RoleMappingModel might otherwise contain errors if the RoleModel
		// wasn't loaded previously.
		EObject eObject = ModelStorageUtil.reloadModelFromFileName(base + fileName);
		return (RoleMappingModel) eObject;
	}
}
