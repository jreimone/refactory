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
package org.emftext.refactoring.test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.emftext.test.core.DataPairs;
import org.emftext.test.core.ExpectedData;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.emftext.test.core.TestData;
import org.emftext.test.core.TestDataPair;
import org.emftext.test.core.TestDataPairSet;
import org.emftext.test.core.TestDataSet;
import org.junit.Test;

@TestData("TestTest")
public class TestTestFragment extends TestClass{

	@Test
	@DataPairs({"testMethod","anotherTestMethod"})
	public void someMethod(){
		System.out.println("TestTest.someMethod() with test data pairs: ");
		TestDataSet dataSet = getTestDataSet();
		if(dataSet instanceof TestDataPairSet){
			for (TestDataPair dataPair : ((TestDataPairSet) dataSet).getDataPairs()) {
				System.out.println(dataPair.getInput().getName() + " " + dataPair.getExpected().getName());
				assertTrue("Should be true", true);
			}
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
		assertTrue("Should be true", true);
	}
}
