package org.emftext.test.test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class TestDataSet {

	private List<File> inputDataFiles;
	private List<File> expectedDataFiles;
	
	public TestDataSet(){
		inputDataFiles = new LinkedList<File>();
		expectedDataFiles = new LinkedList<File>();
	}
	
	public List<File> getInputDataFiles() {
		return inputDataFiles;
	}
	public void setInputDataFiles(List<File> inputDataFiles) {
		this.inputDataFiles = inputDataFiles;
	}
	public List<File> getExpectedDataFiles() {
		return expectedDataFiles;
	}
	public void setExpectedDataFiles(List<File> expectedDataFiles) {
		this.expectedDataFiles = expectedDataFiles;
	}
}
