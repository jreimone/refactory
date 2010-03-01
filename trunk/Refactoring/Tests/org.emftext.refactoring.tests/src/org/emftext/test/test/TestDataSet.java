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
	
	public File getInputFileByPattern(String pattern){
		return getFileByPattern(inputDataFiles, pattern);
	}
	
	public File getExpectedFileByPattern(String pattern){
		return getFileByPattern(expectedDataFiles, pattern);
	}

	private File getFileByPattern(List<File> source, String pattern) {
		for (File file : source) {
			if(file.getName().startsWith(pattern)){
				return file;
			}
		}
		return null;
	}
}
