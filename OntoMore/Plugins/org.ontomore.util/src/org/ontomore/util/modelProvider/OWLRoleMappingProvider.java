package org.ontomore.util.modelProvider;

import static org.ontomore.util.modelProvider.RoleMappingModelProvider.*;

import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

/**
 * Represents an OWL RoleMapping and knows to which RoleMappingModel it belongs.
 * 
 * @author Erik Tittel
 */
public enum OWLRoleMappingProvider {

	RENAME_ELEMENT("Rename Element"),
	RENAME_ONTOLOGY("Rename Ontology"),
	DUPLICATE_CLASS("Duplicate Class"),
	CONVERT_DATAPROPERTY_TO_OBJECTPROPERTY("Convert Data Property To Object Property"),
	EXTRACT_SUPERCLASS("Extract Superclass"),
	PULL_UP_PROPERTY("Pull Up Property"),
	INTRODUCE_INVERSE_PROPERTY("Introduce Inverse Property"),
	REMOVE_INVERSE_PROPERTY("Remove Inverse Property");

	private final String roleMappingName;

	OWLRoleMappingProvider(String roleMappingName) {
		this.roleMappingName = roleMappingName;
	}

	@Override
	public String toString() {
		return roleMappingName;
	}

	public RoleMapping toRoleMapping() {
		RoleMappingModel roleMappingModel = getRoleMappingModel();
		return getRoleMappingFromModel(roleMappingModel);
	}

	private RoleMappingModel getRoleMappingModel() {
		switch (this) {
		case RENAME_ELEMENT:
			return OWL_RENAME.toModel();
		case RENAME_ONTOLOGY:
			return OWL_RENAME.toModel();
		case DUPLICATE_CLASS:
			return OWL_DUPLICATE_CLASS.toModel();
		case CONVERT_DATAPROPERTY_TO_OBJECTPROPERTY:
			return OWL_CONVERT_DATAPROPERTY_TO_OBJECTPROPERTY.toModel();
		case EXTRACT_SUPERCLASS:
			return OWL_EXTRACT_SUPERCLASS.toModel();
		case PULL_UP_PROPERTY:
			return OWL_PULL_UP_PROPERTY.toModel();
		case INTRODUCE_INVERSE_PROPERTY:
			return OWL_INTRODUCE_INVERSE_PROPERTY.toModel();
		case REMOVE_INVERSE_PROPERTY:
			return OWL_REMOVE_INVERSE_PROPERTY.toModel();
		default:
			throw new RuntimeException("The RoleMapping " + this
					+ " is not associated to a RoleMappingModel");
		}
	}

	private RoleMapping getRoleMappingFromModel(RoleMappingModel roleMappingModel) {
		RoleMapping result = null;
		for (RoleMapping roleMapping : roleMappingModel.getMappings()) {
			if (roleMappingName.equals(roleMapping.getName())) {
				result = roleMapping;
				break;
			}
		}
		if (result == null) {
			throw new RuntimeException("The RoleMappingModel \"" + roleMappingModel
					+ "\" does not have a RoleMapping with the name \"" + roleMappingName + "\".");
		}
		return result;
	}
}
