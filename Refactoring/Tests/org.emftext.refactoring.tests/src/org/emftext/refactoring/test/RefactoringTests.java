/**
 * 
 */
package org.emftext.refactoring.test;

import org.emftext.language.refactoring.roles.postprocessing.EmptyOutgoingRelationTest;
import org.emftext.refactoring.graph.GraphTest;
import org.emftext.refactoring.roleconstraintchecker.RoleConstraintCheckerTest;
import org.emftext.refactoring.specification.interpreter.RefactoringInterpreterTest;
import org.emftext.refactoring.util.UtilTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs all tests.
 * 
 * @author Jan Reimann
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	EmptyOutgoingRelationTest.class,
	UtilTest.class,
	RoleConstraintCheckerTest.class,
	RefactoringInterpreterTest.class,
	GraphTest.class
})
public class RefactoringTests{

}
