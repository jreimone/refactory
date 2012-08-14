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
package org.emftext.refactoring.roleconstraintchecker.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.roleconstraintchecker.Activator;
import org.emftext.refactoring.roleconstraintchecker.IRoleConstraintValidator;

public class CompositeRoleConstraintValidator implements
		IRoleConstraintValidator {
	
	private List<IRoleConstraintValidator> validators = new LinkedList<IRoleConstraintValidator>();
	
	protected CompositeRoleConstraintValidator(){
		validators.add(new BasicRoleConstraintValidator());
	}

	public IStatus validate(RoleMappingModel mappingModel) {
		List<IStatus> results = new LinkedList<IStatus>();
		for (IRoleConstraintValidator validator : validators) {
			 results.add(validator.validate(mappingModel));
		}
		IStatus result = new MultiStatus(Activator.PLUGIN_ID, IStatus.ERROR, results.toArray(new IStatus[]{}), "RoleMapping errors", null);
		return result;
	}

	public List<IStatus> validateMapping(RoleMapping mapping) {
		List<IStatus> results = new LinkedList<IStatus>();
		for (IRoleConstraintValidator validator : validators) {
			 results.addAll(validator.validateMapping(mapping));
		}
		return results;
	}

}

