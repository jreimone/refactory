package org.corefactoring.test.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ontomore.util.ModelStorageUtil;

public class TestFileNameTest {
	
	private static final String base = ModelStorageUtil.getBase("org.corefactoring.test");
	private TestFileName testFileName;
	
	@Before
	public void setUp() {
		testFileName = new TestFileName(base + "test/file.txt");
	}
	
	@After
	public void tearDown() {
		testFileName = null;
	}
	
	@Test
	public void testGetInputFileName() {
		assertEquals(base + "test/file_IN.txt", testFileName.getInputFileName());
	}
	
	@Test
	public void testGetExpectedFileName() {
		assertEquals(base + "test/file_EXP.txt", testFileName.getExpectedFileName());
	}
	
	@Test
	public void testGetRefactoringFileName() {
		assertEquals(base + "test/file_REF.txt", testFileName.getRefactoredFileName());
	}
}
