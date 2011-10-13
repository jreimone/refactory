package org.emftext.test.core;




public class TestClass {

	private TestDataSet testDataSet;

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
