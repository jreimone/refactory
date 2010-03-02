package org.emftext.test.core;



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
