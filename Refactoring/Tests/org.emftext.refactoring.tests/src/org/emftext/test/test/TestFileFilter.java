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
			return name.startsWith(nameFilter);
		}
		return name.startsWith(nameFilter) && !name.endsWith(TestTests.EXPECT_EXTENSION);
	}

}
