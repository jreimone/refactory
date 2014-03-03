package org.corefactoring.rolemappingregistry;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.ontomore.util.modelProvider.EcoreRoleMappingProvider;
import static org.ontomore.util.modelProvider.OWLRoleMappingProvider.*;

/**
 * Maps OWL RoleMappings to Ecore RoleMappings using an ordinary map.
 * 
 * @author Erik Tittel
 */
public class OWL2EcoreRoleMappingMapper implements RoleMappingMapper {

	private Map<String, EcoreRoleMappingProvider> roleMappingMap;

	public OWL2EcoreRoleMappingMapper() {
		roleMappingMap = new HashMap<String, EcoreRoleMappingProvider>();
		fillRoleMappingMap();
	}

	private void fillRoleMappingMap() {
		roleMappingMap.put(RENAME_ELEMENT.toString(), EcoreRoleMappingProvider.RENAME);
		roleMappingMap.put(RENAME_ONTOLOGY.toString(), EcoreRoleMappingProvider.RENAME);
		roleMappingMap.put(DUPLICATE_CLASS.toString(), EcoreRoleMappingProvider.DUPLICATE_CLASS);
		roleMappingMap.put(CONVERT_DATAPROPERTY_TO_OBJECTPROPERTY.toString(), EcoreRoleMappingProvider.REPLACE_DATAVALUE_WITH_OBJECT);
		roleMappingMap.put(EXTRACT_SUPERCLASS.toString(), EcoreRoleMappingProvider.EXTRACT_SUPERCLASS);
		roleMappingMap.put(PULL_UP_PROPERTY.toString(), EcoreRoleMappingProvider.PULL_UP_FEATURE);
		roleMappingMap.put(INTRODUCE_INVERSE_PROPERTY.toString(), EcoreRoleMappingProvider.INTRODUCE_INVERSE_REFERENCE);
	}

	public RoleMapping getCorrespondingRoleMapping(RoleMapping roleMapping, EObject inputElement) {
		String roleMappingName = roleMapping.getName();
		EcoreRoleMappingProvider ecoreRoleMappingProvider = roleMappingMap.get(roleMappingName);
		if (ecoreRoleMappingProvider == null) {
			throw new RuntimeException("No corresponding Ecore-RoleMapping found for "
					+ roleMappingName);
		}
		return ecoreRoleMappingProvider.toRoleMapping();
	}

}
