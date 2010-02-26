package org.emftext.test.test;

import org.emftext.refactoring.test.TestClass;
import org.emftext.refactoring.test.TestData;
import org.junit.Test;

@TestData(pattern = "TestTest")
public class TestTest extends TestClass{

	@Test
	@TestData(pattern = "testMethod")
	public void someMethod(){
		System.err.println("sdfsdfsd");
	}
}
