/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker;

import org.emftext.refactoring.roleconstraintchecker.impl.RoleConstraintValidatorFactoryImpl;

/**
 * Interface for factories for creation of role constraint validators.
 * 
 * @author Jan Reimann
 *
 */
public interface RoleConstraintValidatorFactory {

	/**
	 * The default instance.
	 */
	public static RoleConstraintValidatorFactory eINSTANCE = new RoleConstraintValidatorFactoryImpl();
	
	/**
	 * Returns or creates the role constraint validator for the given role mapping model.
	 * @param mappingModel 
	 * @return
	 */
	public IRoleConstraintValidator createValidator();
}
