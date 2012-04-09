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
package org.emftext.refactoring.registry.refactoringspecification.exceptions;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;

public class RefSpecAlreadyRegisteredException extends Exception {

	private static final long serialVersionUID = 6760747409240262340L;

	private static final String MESSAGE = "RefSpec for RoleModel '%1$s' already registered";

	private RefactoringSpecification refSpec;
	
	public RefSpecAlreadyRegisteredException(RefactoringSpecification refSpec){
		super(String.format(MESSAGE, refSpec.getUsedRoleModel().getName()));
		this.refSpec = refSpec;
	}

	public RefactoringSpecification getRefSpec() {
		return refSpec;
	}
}
