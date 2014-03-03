package org.corefactoring.rolemappingregistry;

import static org.ontomore.util.modelProvider.EcoreRoleMappingProvider.DUPLICATE_CLASS;
import static org.ontomore.util.modelProvider.EcoreRoleMappingProvider.EXTRACT_SUPERCLASS;
import static org.ontomore.util.modelProvider.EcoreRoleMappingProvider.INTRODUCE_INVERSE_REFERENCE;
import static org.ontomore.util.modelProvider.EcoreRoleMappingProvider.PULL_UP_FEATURE;
import static org.ontomore.util.modelProvider.EcoreRoleMappingProvider.RENAME;
import static org.ontomore.util.modelProvider.EcoreRoleMappingProvider.REPLACE_DATAVALUE_WITH_OBJECT;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.ontomore.util.modelProvider.OWLRoleMappingProvider;

/**
 * Maps Ecore RoleMappings to OWL RoleMappings. In some cases the mapping
 * depends on the input element.
 * 
 * @author Erik Tittel
 */
public class Ecore2OWLRoleMappingMapper implements RoleMappingMapper {

	private Map<String, OWLRoleMappingProvider> roleMappingMap;

	public Ecore2OWLRoleMappingMapper() {
		roleMappingMap = new HashMap<String, OWLRoleMappingProvider>();
		fillRoleMappingMap();
	}

	private void fillRoleMappingMap() {
		roleMappingMap.put(DUPLICATE_CLASS.toString(), OWLRoleMappingProvider.DUPLICATE_CLASS);
		roleMappingMap.put(REPLACE_DATAVALUE_WITH_OBJECT.toString(), OWLRoleMappingProvider.CONVERT_DATAPROPERTY_TO_OBJECTPROPERTY);
		roleMappingMap.put(EXTRACT_SUPERCLASS.toString(), OWLRoleMappingProvider.EXTRACT_SUPERCLASS);
		roleMappingMap.put(PULL_UP_FEATURE.toString(), OWLRoleMappingProvider.PULL_UP_PROPERTY);
		roleMappingMap.put(INTRODUCE_INVERSE_REFERENCE.toString(), OWLRoleMappingProvider.INTRODUCE_INVERSE_PROPERTY);
	}

	public RoleMapping getCorrespondingRoleMapping(RoleMapping roleMapping, EObject inputElement) {
		RoleMapping correspondingRoleMapping = getSpecialRoleMapping(roleMapping, inputElement);
		if (correspondingRoleMapping == null) {
			correspondingRoleMapping = getOrdinaryRoleMapping(roleMapping);
		}
		return correspondingRoleMapping;
	}

	private RoleMapping getSpecialRoleMapping(RoleMapping roleMapping, EObject inputElement) {
		String roleMappingName = roleMapping.getName();
		if (roleMappingName.equals(RENAME.toString())) {
			return getOWLRenameDependingOnInput(inputElement);
		}
		return null;
	}

	private RoleMapping getOWLRenameDependingOnInput(EObject inputElement) {
		if (inputElement instanceof EClass) {
			return OWLRoleMappingProvider.RENAME_ELEMENT.toRoleMapping();
		}
		if (inputElement instanceof EPackage) {
			return OWLRoleMappingProvider.RENAME_ONTOLOGY.toRoleMapping();
		}
		throw new RuntimeException("Unexpected input element: " + inputElement);
	}

	private RoleMapping getOrdinaryRoleMapping(RoleMapping roleMapping) {
		String roleMappingName = roleMapping.getName();
		OWLRoleMappingProvider owlRoleMappingProvider = roleMappingMap.get(roleMappingName);
		if (owlRoleMappingProvider == null) {
			throw new RuntimeException("No corresponding OWL-RoleMapping found for "
					+ roleMappingName);
		}
		return owlRoleMappingProvider.toRoleMapping();
	}

}
