package org.emftext.test.test;

import org.emftext.refactoring.test.DataPairs;
import org.emftext.refactoring.test.TestClass;
import org.emftext.refactoring.test.TestData;
import org.junit.Test;

@TestData("TestTest")
public class TestTest extends TestClass{

	@Test
	@DataPairs("testMethod")
	public void someMethod(){
		System.out.println("TestTest.someMethod() with test data pairs: ");
		for (TestDataPair dataPair : getTestDataPairs()) {
			System.out.println(dataPair.getInput().getName() + " " + dataPair.getExpected().getName());
		}
	}
}
