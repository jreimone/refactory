package org.corefactoring.test.util;

import org.eclipse.emf.common.util.URI;

public class TestFileName {

	private URI fileName;
	
	public TestFileName(String fileName) {
		this.fileName = URI.createURI(fileName);;
	}

	public String getInputFileName() {
		return appendToFileName("_IN");
	}

	public String getExpectedFileName() {
		return appendToFileName("_EXP");
	}

	public String getRefactoredFileName() {
		return appendToFileName("_REF");
	}

	private String appendToFileName(String appendix) {
		String fileNameWithoutExtension = fileName.trimFileExtension().toString();
		String extension = fileName.fileExtension();
		URI uriWithAppendix = URI.createURI(fileNameWithoutExtension + appendix);
		uriWithAppendix = uriWithAppendix.appendFileExtension(extension);
		return uriWithAppendix.toString();
	}

}
