/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.emftext.language.refactoring.rolemapping.Mapping;

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
	public IStatus validate();
	
	/**
	 * Validates the given mapping
	 * @param mapping the mapping to validate
	 * @return
	 */
	public List<IStatus> validateMapping(Mapping mapping);
}
