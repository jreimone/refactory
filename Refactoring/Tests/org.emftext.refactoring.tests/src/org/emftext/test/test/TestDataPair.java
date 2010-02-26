package org.emftext.test.test;

import java.io.File;

public class TestDataPair {

	private File input;
	private File expected;
	
	public TestDataPair(File input, File expected){
		this.input = input;
		this.expected = expected;
	}

	public File getInput() {
		return input;
	}

	public File getExpected() {
		return expected;
	}
}
