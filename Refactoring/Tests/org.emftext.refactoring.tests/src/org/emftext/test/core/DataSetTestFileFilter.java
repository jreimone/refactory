package org.emftext.test.core;

import java.io.File;
import java.io.FilenameFilter;

import org.emftext.refactoring.test.RefactoringTests;

public class DataSetTestFileFilter implements FilenameFilter {

	private String nameFilter;
	private boolean includeExpectExtension = false;

	public DataSetTestFileFilter(String nameFilter, boolean includeExpectExtension){
		this.nameFilter = nameFilter;
		this.includeExpectExtension = includeExpectExtension;
	}
	
	public boolean accept(File dir, String name) {
		if(includeExpectExtension){
			return name.startsWith(nameFilter) && !name.contains(RefactoringTests.EXPECTED_DATA_FILE_NAME_INSERT);
		}
		return name.startsWith(nameFilter);
	}

}
