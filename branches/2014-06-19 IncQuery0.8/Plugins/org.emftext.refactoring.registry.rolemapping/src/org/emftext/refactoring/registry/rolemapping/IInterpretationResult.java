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

/**
 * Interface for providing interpretation results.
 * 
 * @author jreimann
 *
 */
public interface IInterpretationResult {

	/**
	 * Returns <code>true</code> in case of successful interpretation.
	 * 
	 * @return
	 */
	public boolean wasSuccessful();
	
	/**
	 * Returns the error message to display.
	 * @return
	 */
	public String getErrorMessage();
}