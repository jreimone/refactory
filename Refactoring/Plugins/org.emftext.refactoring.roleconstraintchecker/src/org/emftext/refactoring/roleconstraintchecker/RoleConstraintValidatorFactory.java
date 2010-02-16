/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker;

import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
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
	public static RoleConstraintValidatorFactory eInstance = new RoleConstraintValidatorFactoryImpl();
	
	/**
	 * Returns or creates the role constraint validator for the given role mapping model.
	 * @param mappingModel 
	 * @return
	 */
	public IRoleConstraintValidator getValidator(RoleMappingModel mappingModel);
}
