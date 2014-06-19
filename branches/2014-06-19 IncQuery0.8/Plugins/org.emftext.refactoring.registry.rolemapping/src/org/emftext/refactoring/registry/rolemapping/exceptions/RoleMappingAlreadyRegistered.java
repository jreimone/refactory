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
package org.emftext.refactoring.registry.rolemapping.exceptions;

import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

public class RoleMappingAlreadyRegistered extends Exception {

	private static final long serialVersionUID = -1973291825550213552L;
	private static final String MESSAGE = "RoleMapping for namespace URI '%1$s' already registered";

	private RoleMappingModel roleMapping;
	
	public RoleMappingAlreadyRegistered(RoleMappingModel roleMapping){
		super(String.format(MESSAGE, roleMapping.getTargetMetamodel().getNsURI()));
		this.roleMapping = roleMapping;
	}

	public RoleMappingModel getRoleMapping() {
		return roleMapping;
	}
	
}
