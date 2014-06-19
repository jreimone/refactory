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
package org.emftext.refactoring.registry.rolemodel.exceptions;

import org.emftext.language.refactoring.roles.RoleModel;

public class RoleModelAlreadyRegisteredException extends Exception {

	private static final long serialVersionUID = 3564300797985782107L;
	private static final String MESSAGE = "RoleModel with name '%1$s' already registered";

	private RoleModel roleModel;
	
	public RoleModelAlreadyRegisteredException(RoleModel roleModel){
		super(String.format(MESSAGE, roleModel.getName()));
		this.roleModel = roleModel;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}
}
