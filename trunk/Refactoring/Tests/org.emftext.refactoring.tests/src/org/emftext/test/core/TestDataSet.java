package org.emftext.test.core;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.test.TestUtil;

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
		return getFileByPattern(getInputDataFiles(), pattern);
	}
	
	public File getExpectedFileByPattern(String pattern){
		return getFileByPattern(getExpectedDataFiles(), pattern);
	}

	private File getFileByPattern(List<File> source, String pattern) {
		for (File file : source) {
			if(file.getName().contains(pattern)){
				return file;
			}
		}
		return null;
	}
	
	public Resource getResourceByPattern(String pattern, boolean expected) {
		File file = null;
		if(expected){
			file = getExpectedFileByPattern(pattern);
		} else {
			file = getInputFileByPattern(pattern);
		}
		Resource resource = TestUtil.getResourceFromFile(file);
		return resource;
	}
}
