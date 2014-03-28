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
package org.emftext.refactoring.interpreter;


/**
 * This interface represents a fake interpreter for a fake refactoring run. It can be used to
 * collect all values which have to be provided by the user before the real refactoring starts.
 * 
 * @author jreimann
 *
 */
public interface IRefactoringFakeInterpreter extends IRefactoringInterpreter {
	
	/**
	 * Returns the real interpreter of this fake interpreter
	 * @return
	 */
	public IRefactoringInterpreter getRealInterpreter();
	
}
