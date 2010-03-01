package org.emftext.refactoring.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Random;

import org.emftext.test.test.DataPairs;
import org.emftext.test.test.ExpectedData;
import org.emftext.test.test.InputData;
import org.emftext.test.test.TestClass;
import org.emftext.test.test.TestData;
import org.emftext.test.test.TestDataPair;
import org.junit.Test;

@TestData("TestTest")
public class TestTest extends TestClass{

	@Test
	@DataPairs({"testMethod","anotherTestMethod"})
	public void someMethod(){
		System.out.println("TestTest.someMethod() with test data pairs: ");
		for (TestDataPair dataPair : getTestDataPairs()) {
			System.out.println(dataPair.getInput().getName() + " " + dataPair.getExpected().getName());
			assertTrue("Should be true", true);
		}
	}
	
	@Test
	@InputData({"inputOne", "inputTwo"})
	@ExpectedData({"dataOnly"})
	public void arbitraryInputExpectedDataTest(){
		System.out.println("TestTest.arbitraryInputExpectedDataTest() with following data:");
		System.out.println("INPUT:");
		for (File file : getTestDataSet().getInputDataFiles()) {
			System.out.print(file.getName() + " ");
		}
		System.out.println("EXPECTED:");
		for (File file : getTestDataSet().getExpectedDataFiles()) {
			System.out.print(file.getName() + " ");
		}
		assertTrue("Should be true", new Random(System.currentTimeMillis()).nextBoolean());
	}
}
