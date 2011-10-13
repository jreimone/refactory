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
