/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
