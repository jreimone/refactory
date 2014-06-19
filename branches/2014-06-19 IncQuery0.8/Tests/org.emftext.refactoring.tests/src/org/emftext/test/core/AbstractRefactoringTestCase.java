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
package org.emftext.test.core;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

/**
 * An abstract TestCase class for setting up the needed metamodels in the registry.
 * 
 * @author Jan Reimann
 *
 */
public abstract class AbstractRefactoringTestCase extends TestCase {

	private boolean failed = false;
	
	public abstract void runRefactoringTest() throws Throwable;

	@Override
	protected void runTest() throws Throwable {
		try {
			runRefactoringTest();
		} catch (AssertionFailedError e) {
			this.failed = true;
			throw e;
		}
	}
}
