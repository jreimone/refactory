package org.corefactoring.rolemappingregistry;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * Provides means to get corresponding RoleMappings. Which represents
 * essentially a mapping of refactorings as far as the change operations are
 * concerned.
 * 
 * @author Erik Tittel
 */
public interface RoleMappingMapper {

	public RoleMapping getCorrespondingRoleMapping(RoleMapping roleMapping, EObject inputElement);

}