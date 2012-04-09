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
