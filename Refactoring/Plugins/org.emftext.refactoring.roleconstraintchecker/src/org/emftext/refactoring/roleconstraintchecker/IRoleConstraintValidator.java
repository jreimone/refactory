/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

/**
 * Interface for role constraint validators.
 * 
 * @author Jan Reimann
 *
 */
public interface IRoleConstraintValidator {

	/**
	 * Validates the whole RoleMappingModel
	 * @return
	 */
	public IStatus validate(RoleMappingModel mappingModel);
	
	/**
	 * Validates the given mapping
	 * @param mapping the mapping to validate
	 * @return
	 */
	public List<IStatus> validateMapping(RoleMapping mapping);
}
