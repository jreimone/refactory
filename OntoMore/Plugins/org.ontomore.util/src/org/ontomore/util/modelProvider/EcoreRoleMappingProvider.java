package org.ontomore.util.modelProvider;

import static org.ontomore.util.modelProvider.RoleMappingModelProvider.*;

import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

/**
 * Represents an Ecore RoleMapping and knows to which RoleMappingModel it belongs.
 * 
 * @author Erik Tittel
 */
public enum EcoreRoleMappingProvider {

	RENAME ("Rename EElement"),
	DUPLICATE_CLASS ("Duplicate Class"),
	REPLACE_DATAVALUE_WITH_OBJECT ("Replace Data Value with Object"),
	EXTRACT_SUPERCLASS ("Extract Super Class"),
	PULL_UP_FEATURE ("Pull Up Feature"),
	INTRODUCE_INVERSE_REFERENCE ("Introduce Inverse Reference"),
	REMOVE_INVERSE_REFERENCE ("Remove Inverse Reference");
	
	private final String roleMappingName;

	EcoreRoleMappingProvider(String roleMappingName) {
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
		case RENAME:
			return ECORE_RENAME.toModel();
		case DUPLICATE_CLASS:
			return ECORE_DUPLICATE_CLASS.toModel();
		case REPLACE_DATAVALUE_WITH_OBJECT:
			return ECORE_REPLACE_DATAVALUE_WITH_OBJECT.toModel();
		case EXTRACT_SUPERCLASS:
			return ECORE_EXTRACT_SUPERCLASS.toModel();
		case PULL_UP_FEATURE:
			return ECORE_PULL_UP_FEATURE.toModel();
		case INTRODUCE_INVERSE_REFERENCE:
			return ECORE_INTRODUCE_INVERSE_REFERENCE.toModel();
		case REMOVE_INVERSE_REFERENCE:
			return ECORE_REMOVE_INVERSE_REFERENCE.toModel();
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
