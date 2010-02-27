package org.emftext.test.test;

import java.io.File;
import java.io.FilenameFilter;

import org.emftext.refactoring.test.TestTests;

public class TestFileFilter implements FilenameFilter {

	private String nameFilter;
	private boolean filterExpectExtension;
	
	public TestFileFilter(String nameFilter, boolean includeExpectExtension){
		this.nameFilter = nameFilter;
		this.filterExpectExtension = includeExpectExtension;
	}

	public boolean accept(File dir, String name) {
		if(filterExpectExtension){
			String replacedFileName = name.replace(TestTests.EXPECTED_DATA_FILE_NAME_INSERT, "");
			return replacedFileName.equals(nameFilter);
		}
		return name.startsWith(nameFilter) && !name.contains(TestTests.EXPECTED_DATA_FILE_NAME_INSERT);
	}

}
