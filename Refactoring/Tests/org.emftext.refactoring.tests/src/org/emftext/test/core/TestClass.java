package org.emftext.test.core;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.test.TestUtil;



public class TestClass {

//	private List<TestDataPair> testDataPairs;
	private TestDataSet testDataSet;

//	public List<TestDataPair> getTestDataPairs() {
//		if(testDataPairs == null){
//			testDataPairs = new LinkedList<TestDataPair>();
//		}
//		return testDataPairs;
//	}
//
//	public void setTestDataPairs(List<TestDataPair> testDataPairs) {
//		this.testDataPairs = testDataPairs;
//	}

	public TestDataSet getTestDataSet() {
		if(testDataSet == null){
			testDataSet = new TestDataSet();
		}
		return testDataSet;
	}

	public void setTestDataSet(TestDataSet testDataSet) {
		this.testDataSet = testDataSet;
	}
}
