package org.emftext.refactoring.continued_testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.interpreter.internal.ASSIGNInterpreter;
import org.emftext.refactoring.test.QueryUtil;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.junit.Test;

public class ContinuedRefactoringTest extends TestClass {

	/****************************************************************************
	 * ATTENTION! 																*
	 * The following patterns are only the prefixes of the files to be tested.	*
	 * Files belonging together, i.e. the input file, the expected file,		*
	 * the file containing the path through the model, etc.						*
	 * must only differ in its prefixes! If not they won't be recognized		*
	 * as a belonging together.													*
	 * 																			*
	*****************************************************************************/
	
	// name all input models with this pattern at the beginning 
	private static final String INPUT_PATTERN = "IN_";
	// name all expected models with this pattern at the beginning
	private static final String EXPECTED_PATTERN = "EXP_";
	// name all files containing the path to the desired elements with this pattern at the beginning
	private static final String PATH_PATTERN = "PATH_";
	// name all files containing the values, needed while refactoring from the user, at the beginning
	private static final String VALUE_PATTERN = "VAL_";
	// name all files containing the name of the mapping, which is intended to be used, at the beginning 
	private static final String MAPPING_PATTERN = "MAP_";
	
	private void init(){
		TestAttributeValueProvider.setTestDataSet(getTestDataSet());
		TestAttributeValueProvider.setValuePattern(VALUE_PATTERN);
		ASSIGNInterpreter.setValueProvider(TestAttributeValueProvider.class);
	}
	
	@Test
	@InputData({INPUT_PATTERN, EXPECTED_PATTERN, PATH_PATTERN, VALUE_PATTERN, MAPPING_PATTERN})
	public void continuedRefactoring(){
		init();
		
		EObject inputModel = TestUtil.getModelFromResource(getTestDataSet().getResourceByPattern(INPUT_PATTERN, false));
		Resource inputResource = inputModel.eResource();
		
		File path = getTestDataSet().getInputFileByPattern(PATH_PATTERN);
		assertNotNull(path);
		String query = QueryUtil.getLineInFile(path, 1);
		List<EObject> elements = QueryUtil.queryModel(inputModel, query);
		assertNotNull(elements);
		assertTrue(elements.size() > 0);
		
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(inputResource);
		assertNotNull(refactorer);
		
		refactorer.setInput(elements);
		List<Mapping> mappings = refactorer.getPossibleMappings(1.0);
		assertNotNull(mappings);
		assertTrue(mappings.size() > 0);
		File mappingFile = getTestDataSet().getInputFileByPattern(MAPPING_PATTERN);
		String mappingName = QueryUtil.getLineInFile(mappingFile, 1).trim();
		Mapping mappingToUse = null;
		for (Mapping mapping : mappings) {
			if(mapping.getName().equals(mappingName)){
				mappingToUse = mapping;
			}
		}
		assertNotNull(mappingToUse);
	}
}
