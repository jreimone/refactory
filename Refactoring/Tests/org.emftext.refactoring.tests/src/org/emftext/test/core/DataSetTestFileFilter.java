package org.emftext.test.core;

import java.io.File;
import java.io.FilenameFilter;

public class DataSetTestFileFilter implements FilenameFilter {

	private String nameFilter;
	
	public DataSetTestFileFilter(String nameFilter){
		this.nameFilter = nameFilter;
	}
	
	public boolean accept(File dir, String name) {
		return name.startsWith(nameFilter);
	}

}
