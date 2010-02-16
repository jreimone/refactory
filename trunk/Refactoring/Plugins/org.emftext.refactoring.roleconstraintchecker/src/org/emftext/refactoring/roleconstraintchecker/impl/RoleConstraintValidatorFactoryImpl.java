/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker.impl;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.roleconstraintchecker.IRoleConstraintValidator;
import org.emftext.refactoring.roleconstraintchecker.RoleConstraintValidatorFactory;

/**
 * @author Jan Reimann
 *
 */
public class RoleConstraintValidatorFactoryImpl implements
		RoleConstraintValidatorFactory {

	private Map<String, IRoleConstraintValidator> validatorMap = new HashMap<String, IRoleConstraintValidator>();
	
	public RoleConstraintValidatorFactoryImpl(){
		// TODO initialize map from extension points or preferences?
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.roleconstraintchecker.RoleConstraintValidatorFactory#getValidator(org.emftext.language.refactoring.rolemapping.RoleMappingModel)
	 */
	public IRoleConstraintValidator getValidator(RoleMappingModel mappingModel) {
		IRoleConstraintValidator validator = validatorMap.get(mappingModel.getTargetMetamodel().getNsURI());
		if(validator == null){
			validator = new BasicRoleConstraintValidator(mappingModel);
			validatorMap.put(mappingModel.getTargetMetamodel().getNsURI(), validator);
		}
		return validator;
	}

}
