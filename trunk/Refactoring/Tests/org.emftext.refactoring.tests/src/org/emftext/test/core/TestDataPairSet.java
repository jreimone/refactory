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

public class TestDataPairSet extends TestDataSet {

	private List<TestDataPair> dataPairs;

	public TestDataPairSet(){
		dataPairs = new LinkedList<TestDataPair>();
	}
	
	public List<TestDataPair> getDataPairs() {
		return dataPairs;
	}
	
	public boolean addDataPair(TestDataPair dataPair){
		return dataPairs.add(dataPair);
	}

	@Override
	public List<File> getExpectedDataFiles() {
		List<File> files = new LinkedList<File>();
		for (TestDataPair dataPair : dataPairs) {
			files.add(dataPair.getExpected());
		}
		return files;
	}

	@Override
	public List<File> getInputDataFiles() {
		List<File> files = new LinkedList<File>();
		for (TestDataPair dataPair : dataPairs) {
			files.add(dataPair.getInput());
		}
		return files;
	}

	/**
	 * Just does nothing because data pairs must be kept synchron with {@link TestDataPairSet#addDataPair(TestDataPair)}.
	 */
	@Override
	public void setExpectedDataFiles(List<File> expectedDataFiles) {
		// just do nothing because data pairs must be kept synchron with
	}

	/**
	 * Just does nothing because data pairs must be kept synchron with {@link TestDataPairSet#addDataPair(TestDataPair)}.
	 */
	@Override
	public void setInputDataFiles(List<File> inputDataFiles) {
		// do nothing
	}

	public void setDataPairs(List<TestDataPair> dataPairs) {
		this.dataPairs = dataPairs;
	}
	
	
}
