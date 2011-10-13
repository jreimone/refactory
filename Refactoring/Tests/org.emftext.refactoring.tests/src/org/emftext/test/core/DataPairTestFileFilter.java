package org.emftext.test.core;

import java.io.File;
import java.io.FilenameFilter;

import org.emftext.refactoring.test.RefactoringTestSuite;

public class DataPairTestFileFilter implements FilenameFilter {

	private String nameFilter;
	private boolean filterExpectExtension;
	
	public DataPairTestFileFilter(String nameFilter, boolean includeExpectExtension){
		this.nameFilter = nameFilter;
		this.filterExpectExtension = includeExpectExtension;
	}

	public boolean accept(File dir, String name) {
		if(filterExpectExtension){
			String replacedFileName = name.replace(RefactoringTestSuite.EXPECTED_DATA_FILE_NAME_INSERT, "");
			return replacedFileName.equals(nameFilter);
		}
		return name.startsWith(nameFilter) && !name.contains(RefactoringTestSuite.EXPECTED_DATA_FILE_NAME_INSERT);
	}

}
