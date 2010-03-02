package org.emftext.test.core;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class TestDataPairSet extends TestDataSet {

	private List<TestDataPair> dataPairs;

	public TestDataPairSet(){
		dataPairs = new LinkedList<TestDataPair>();
	}
	
	public List<TestDataPair> getDataPairs() {
		return dataPairs;
	}
	
	public boolean addDataPair(TestDataPair dataPair){
		return dataPairs.add(dataPair);
	}

	@Override
	public List<File> getExpectedDataFiles() {
		List<File> files = new LinkedList<File>();
		for (TestDataPair dataPair : dataPairs) {
			files.add(dataPair.getExpected());
		}
		return files;
	}

	@Override
	public List<File> getInputDataFiles() {
		List<File> files = new LinkedList<File>();
		for (TestDataPair dataPair : dataPairs) {
			files.add(dataPair.getInput());
		}
		return files;
	}

	/**
	 * Just does nothing because data pairs must be kept synchron with {@link TestDataPairSet#addDataPair(TestDataPair)}.
	 */
	@Override
	public void setExpectedDataFiles(List<File> expectedDataFiles) {
		// just do nothing because data pairs must be kept synchron with
	}

	/**
	 * Just does nothing because data pairs must be kept synchron with {@link TestDataPairSet#addDataPair(TestDataPair)}.
	 */
	@Override
	public void setInputDataFiles(List<File> inputDataFiles) {
		// do nothing
	}

	public void setDataPairs(List<TestDataPair> dataPairs) {
		this.dataPairs = dataPairs;
	}
	
	
}
