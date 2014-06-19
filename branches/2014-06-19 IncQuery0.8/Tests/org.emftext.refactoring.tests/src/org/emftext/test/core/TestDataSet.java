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
