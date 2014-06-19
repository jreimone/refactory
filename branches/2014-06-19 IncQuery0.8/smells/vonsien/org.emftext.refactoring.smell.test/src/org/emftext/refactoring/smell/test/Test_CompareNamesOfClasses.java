package org.emftext.refactoring.smell.test;

import java.util.HashMap;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.emftext.refactoring.smell.ecore_extension.CompareNamesOfClasses;

public class Test_CompareNamesOfClasses extends TestCase {
	
	CompareNamesOfClasses test;
	
	public Test_CompareNamesOfClasses(String name){
		super(name);
	}

	protected void setUp(){
		test = new CompareNamesOfClasses();
	}
	
	protected void tearDown(){
		
	}
	
	public void testCreate(){
		assertNotNull(test);
		assertNotNull(test.getList());
	}
	
	public void testCalculate(){
		assertEquals(test.calculate(null), new HashMap<EObject, Float>());
		Resource testResource = new ResourceImpl();
		assertEquals(test.calculate(testResource), new HashMap<EObject, Float>());
	}

	public static void main(String[] args) {
		TestSuite suite = new TestSuite(Test_CompareNamesOfClasses.class);
		TestResult result = new TestResult();
		suite.run(result);
	}
}
