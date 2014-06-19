package org.emftext.refactoring.smell.test;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IMarkerResolution;

import org.emftext.refactoring.smell.smell_model.ui.View_Quickfixer;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class Test_View_Quickfixer extends TestCase {
	
	View_Quickfixer test;
	IMarker mk;
	
	public Test_View_Quickfixer(String name){
		super(name);
	}

	protected void setUp(){
		test = new View_Quickfixer();
	}
	
	protected void tearDown(){
		
	}
	
	public void testCreation(){
		assertNotNull(test);
	}
	
	public void testResolutions() throws CoreException {
		assertEquals(test.getResolutions(null).length, new IMarkerResolution[0].length);
	}
	
	public static void main(String[] args) {
		TestSuite suite = new TestSuite(Test_View_Quickfixer.class);
		TestResult result = new TestResult();
		suite.run(result);
	}
}
