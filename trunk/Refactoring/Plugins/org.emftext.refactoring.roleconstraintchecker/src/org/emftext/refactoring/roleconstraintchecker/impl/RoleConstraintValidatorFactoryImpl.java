/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker.impl;

import org.emftext.refactoring.roleconstraintchecker.IRoleConstraintValidator;
import org.emftext.refactoring.roleconstraintchecker.RoleConstraintValidatorFactory;

/**
 * @author Jan Reimann
 *
 */
public class RoleConstraintValidatorFactoryImpl implements
		RoleConstraintValidatorFactory {

//	private Map<String, IRoleConstraintValidator> validatorMap = new HashMap<String, IRoleConstraintValidator>();
	
	public RoleConstraintValidatorFactoryImpl(){
		// TODO initialize map from extension points or preferences?
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.roleconstraintchecker.RoleConstraintValidatorFactory#getValidator(org.emftext.language.refactoring.rolemapping.RoleMappingModel)
	 */
	public IRoleConstraintValidator createValidator() {
		return new CompositeRoleConstraintValidator();
	}

}
