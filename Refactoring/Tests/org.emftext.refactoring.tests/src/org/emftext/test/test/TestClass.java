package org.emftext.test.test;

import java.util.LinkedList;
import java.util.List;


public class TestClass {

	private List<TestDataPair> testDataPairs;

	public List<TestDataPair> getTestDataPairs() {
		if(testDataPairs == null){
			return new LinkedList<TestDataPair>();
		}
		return testDataPairs;
	}

	public void setTestDataPairs(List<TestDataPair> testDataPairs) {
		this.testDataPairs = testDataPairs;
	}
}
