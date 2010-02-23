/**
 * 
 */
package org.emftext.refactoring.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.emftext.language.refactoring.roles.postprocessing.EmptyOutgoingRelationTest;
import org.emftext.refactoring.roleconstraintchecker.RoleConstraintCheckerTest;
import org.emftext.refactoring.roleconstraintchecker.RoleConstraintCheckerTestXMI;
import org.emftext.refactoring.specification.interpreter.RefactoringInterpreterTest;
import org.emftext.refactoring.util.UtilTest;

/**
 * Runs all tests.
 * 
 * @author Jan Reimann
 *
 */
public class AllTests extends TestSuite {

	/**
	 * @param string
	 */
	public AllTests(String string) {
		super(string);
	}

	public static Test suite(){
        TestSuite suite = new AllTests("Refactoring Tests");
        suite.addTestSuite(EmptyOutgoingRelationTest.class);
        suite.addTestSuite(UtilTest.class);
        suite.addTestSuite(RoleConstraintCheckerTest.class);
        suite.addTestSuite(RoleConstraintCheckerTestXMI.class);
        suite.addTestSuite(RefactoringInterpreterTest.class);
        return suite;
	}
	
	public static void main(String[] args)
    {
        TestRunner.run(suite());
    }
}
