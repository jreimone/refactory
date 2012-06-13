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
package org.emftext.refactoring.registry.rolemapping;

import java.util.Set;

import org.emftext.refactoring.registry.rolemapping.impl.ConstraintInterpreterRegistry;

/**
 * @author jreimann
 *
 */
public interface IConstraintInterpreterRegistry {

	public static IConstraintInterpreterRegistry INSTANCE = new ConstraintInterpreterRegistry();
	
	/**
	 * Returns an interpreter for the given <code>constraint</code> or <code>null</code> if none is registered.
	 * 
	 * @param constraint
	 * @return
	 */
	public IConstraintInterpreter getInterpreterForConstraint(Object constraint);

	/**
	 * Registers a new interpreter.
	 * 
	 * @param interpreter
	 */
	public void registerInterpreter(IConstraintInterpreter interpreter);
	
	/**
	 * Returns all registered interpreters.
	 * 
	 * @return
	 */
	public Set<IConstraintInterpreter> getAllInterpreters();
}