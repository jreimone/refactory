package org.emftext.refactoring.continued_testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
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
	
	private static final String REFACTORED_PATTERN = "REF_";
	
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
		assertNotNull("No elements found in given selection path.", elements);
		assertTrue(elements.size() > 0);
		
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(inputResource);
		assertNotNull("No refactoring found.", refactorer);
		
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
		refactorer.fakeRefactor(mappingToUse);
		EObject refactoredModel = refactorer.refactor();
		assertNotNull(refactoredModel);
	
		File inputFile = getTestDataSet().getInputFileByPattern(INPUT_PATTERN);
		File parent = inputFile.getParentFile();
		assertTrue(parent.exists());
		int index = inputFile.getName().indexOf(".");
		String folderName = inputFile.getName().substring(0, index).replace(INPUT_PATTERN, "");
		File folder = new File(parent + File.separator + folderName);
		boolean created;
		if(!folder.exists()){
			created = folder.mkdir();
			assertTrue(created);
			
		}
		File subfolder = new File(folder.getAbsolutePath() + File.separator + System.currentTimeMillis());
		created = subfolder.mkdir();
		assertTrue(created);
		File movedInputFile = new File(subfolder.getAbsolutePath() + File.separator + inputFile.getName().replace(INPUT_PATTERN, ""));
		File expectedFile = getTestDataSet().getInputFileByPattern(EXPECTED_PATTERN);
		String expectedName = expectedFile.getName();
		File movedExpectedFile = new File(subfolder.getAbsolutePath() + File.separator + expectedName);
		String refactoredName = REFACTORED_PATTERN + expectedName.replace(EXPECTED_PATTERN, "");
		File refactoredFile = new File(subfolder.getAbsolutePath() + File.separator + refactoredName);
		ResourceSet rs = inputResource.getResourceSet();
		assertNotNull(rs);
//		Resource movedInputResource = rs.createResource(URI.createFileURI(movedInputFile.getAbsolutePath()));
//		assertNotNull(movedInputResource);
		Resource movedExpectedResource = rs.createResource(URI.createFileURI(movedExpectedFile.getAbsolutePath()));
		assertNotNull(movedExpectedResource);
		Resource refactoredResource = rs.createResource(URI.createFileURI(refactoredFile.getAbsolutePath()));
		assertNotNull(refactoredResource);
//		movedInputResource.getContents().add(refactorer.inputModel);
		EObject expectedModel = TestUtil.getModelFromResource(getTestDataSet().getResourceByPattern(EXPECTED_PATTERN, false));
		movedExpectedResource.getContents().add(expectedModel);
		refactoredResource.getContents().add(refactoredModel);
		try {
			created = movedInputFile.createNewFile();
			assertTrue(created);
			FileChannel inChannel = new FileInputStream(inputFile).getChannel();
			FileChannel outChannel = new FileOutputStream(movedInputFile).getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
			inChannel.close();
			outChannel.close();
//			movedInputResource.save(null);
			movedExpectedResource.save(null);
			refactoredResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Exception occurred");
		}
		try {
			MatchModel matchModel = MatchService.doMatch(expectedModel, refactoredModel, Collections.<String, Object>emptyMap());			
			List<MatchElement> matchedElements = matchModel.getMatchedElements();
			double similarity = sumSimilarity(matchedElements);
			int count = sumMatches(matchedElements);
			double ratio = similarity / count;
			assertTrue("Similarity must be 1.0 but is " + ratio, ratio == 1.0);
			
//			DiffModel inputDiff = DiffService.doDiff(matchModel);
//
//			DiffGroup diffGroup = (DiffGroup) inputDiff.getOwnedElements().get(0);
//			if (diffGroup.getSubchanges() != 0) {
//				Assert.fail("Refactored model does not match expected result.");
//			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail("Exception occurred");
		}
	}

	private double sumSimilarity(List<MatchElement> matchedElements) {
		double similarity = 0.0;
		for (MatchElement matchElement : matchedElements) {
			similarity += matchElement.getSimilarity();
			List<MatchElement> subMatches = matchElement.getSubMatchElements();
			similarity += sumSimilarity(subMatches);
		}
		return similarity;
	}
	
	private int sumMatches(List<MatchElement> matchedElements) {
		int matches = 0;
		for (MatchElement matchElement : matchedElements) {
			matches++;
			List<MatchElement> subMatches = matchElement.getSubMatchElements();
			matches += sumMatches(subMatches);
		}
		return matches;
	}
}
