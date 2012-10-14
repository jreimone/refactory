package org.emftext.refactoring.smell.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class Test_TestSuite extends TestSuite{
	
	public static Test suite() {
	    TestSuite suite = new TestSuite("Test Suite for Model Smell Plugins");
	    suite.addTestSuite(Test_CheckInterfaceSpecifications.class);
	    suite.addTestSuite(Test_CompareNamesOfClasses.class);
	    suite.addTestSuite(Test_CountParametersOfMethods.class);
	    suite.addTestSuite(Test_ModelSmellModel.class);
	    suite.addTestSuite(Test_ModelSmellResult.class);
	    suite.addTestSuite(Test_SearchEmptyClasses.class);
	    suite.addTestSuite(Test_View_Quickfixer.class);
	    return suite;
	}
}
