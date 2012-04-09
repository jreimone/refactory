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

public class DataSetTestFileFilter implements FilenameFilter {

	private String nameFilter;
	private boolean includeExpectExtension = false;
	private String[] exclusionPatterns;

	public DataSetTestFileFilter(String nameFilter, boolean includeExpectExtension, String... exclusionPatterns){
		this.nameFilter = nameFilter;
		this.includeExpectExtension = includeExpectExtension;
		this.exclusionPatterns = exclusionPatterns;
	}
	
	private boolean startsNotWithExclusions(String name){
		if(exclusionPatterns == null){
			return true;
		}
		for (String exclusion : exclusionPatterns) {
			if(name.startsWith(exclusion)){
				return false;
			}
		}
		return true;
	}
	
	public boolean accept(File dir, String name) {
		if(includeExpectExtension){
			return name.startsWith(nameFilter) && !name.contains(RefactoringTestSuite.EXPECTED_DATA_FILE_NAME_INSERT) && startsNotWithExclusions(name);
		}
		return name.startsWith(nameFilter) && startsNotWithExclusions(name);
	}

}
