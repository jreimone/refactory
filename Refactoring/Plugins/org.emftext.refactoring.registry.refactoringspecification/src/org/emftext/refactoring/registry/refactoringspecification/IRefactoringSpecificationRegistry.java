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
package org.emftext.refactoring.registry.refactoringspecification;

import java.util.Collection;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;
import org.emftext.refactoring.registry.refactoringspecification.impl.BasicRefactoringSpecificationRegistry;

public interface IRefactoringSpecificationRegistry {

	public static final IRefactoringSpecificationRegistry INSTANCE = new BasicRefactoringSpecificationRegistry();
	
	/**
	 * Returns the {@link RefactoringSpecification refspec} for the given {@link RoleModel}
	 * @param roleModel
	 * @return
	 */
	public RefactoringSpecification getRefSpec(RoleModel roleModel);
	
	/**
	 * Returns all registered {@link RefactoringSpecification refspecs}.
	 * @return
	 */
	public Collection<RefactoringSpecification> getAllRefSpecs();
	
	/**
	 * Invoke this method if you want to register a new {@link RefactoringSpecification refspec} at runtime.
	 * @param refSpec
	 * @return the role model for which the refSpec is registered or <code>null</code> if no role model exists for this refSpec
	 */
	public RoleModel registerRefSpec(RefactoringSpecification refSpec) throws RefSpecAlreadyRegisteredException;
	
	/**
	 * Use this method to unregister an already registered refspec
	 * @param refSpec
	 * @return the unregistered refSpec or <code>null</code> if no refSpec was registered
	 */
	public RefactoringSpecification unregisterRefSpec(RefactoringSpecification refSpec);
	
}
