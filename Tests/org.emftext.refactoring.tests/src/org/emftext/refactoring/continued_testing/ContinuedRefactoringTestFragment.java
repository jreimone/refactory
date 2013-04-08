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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.test.QueryUtil;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.emftext.test.core.TestData;
import org.emftext.test.core.TestDataSet;
import org.junit.Test;

@TestData("ContinuedRefactoringTest")
public class ContinuedRefactoringTestFragment extends TestClass {

	/****************************************************************************
	 * ATTENTION! 																*
	 * The following patterns are only the prefixes of the files to be tested.	*
	 * Files belonging together, i.e. the input file, the expected file,		*
	 * the file containing the path through the model, etc.						*
	 * must only differ in its prefixes! If not they won't be recognized		*
	 * as belonging together.													*
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
	}
	
	@Test
	@InputData({INPUT_PATTERN, EXPECTED_PATTERN, PATH_PATTERN, VALUE_PATTERN, MAPPING_PATTERN})
	public void continuedRefactoring(){
		TestDataSet testDataSet = getTestDataSet();
		List<File> dataFiles = testDataSet.getInputDataFiles();
		System.out.println("Input data files:");
		for (File file : dataFiles) {
			System.out.println(file.getPath());
		}
		
		init();
		
		EObject inputModel = TestUtil.getModelFromResource(getTestDataSet().getResourceByPattern(INPUT_PATTERN, false));
		assertNotNull("input model mustn't be null", inputModel);
		Resource inputResource = inputModel.eResource();
		
		File path = getTestDataSet().getInputFileByPattern(PATH_PATTERN);
		assertNotNull("no path file could be found", path);
		String query = QueryUtil.getLineInFile(path, 1);
		List<EObject> elements = QueryUtil.queryModel(inputModel, query);
		assertNotNull("No elements found for:\n" +
				"model: " + inputModel
				+ "\nquery: " + query, elements);
		assertTrue("query must result at least in 1 element", elements.size() > 0);
		
		
		List<RoleMapping> mappings = IRoleMappingRegistry.INSTANCE.getPossibleRoleMappingsForResource(inputResource, elements, 1.0);
		assertNotNull("Some mappings must be registered for " + inputModel.eClass().getEPackage().getNsURI(), mappings);
		assertTrue("At least one mapping must be registered for " + inputModel.eClass().getEPackage().getNsURI(), mappings.size() > 0);
		File mappingFile = getTestDataSet().getInputFileByPattern(MAPPING_PATTERN);
		String mappingName = QueryUtil.getLineInFile(mappingFile, 1).trim();
		assertNotNull("A mapping name must be contained in " + mappingFile.getName(), mappingName);		
		RoleMapping mappingToUse = null;
		for (RoleMapping mapping : mappings) {
			if(mapping.getName().equals(mappingName)){
				mappingToUse = mapping;
			}
		}
		assertNotNull("Mapping '" + mappingName + "' was not found in registry", mappingToUse);
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(inputResource, mappingToUse);
		assertNotNull("No refactorings exist for metamodel " + inputResource.getContents().get(0).eClass().getEPackage().getNsURI(), refactorer);
		refactorer.setInput(elements);
		IValueProviderFactory factory = new TestValueProviderFactory();
		refactorer.setValueProviderFactory(factory);
		EObject refactoredModel = refactorer.refactor();
		assertNotNull("refactored model mustn't be null", refactoredModel);
	
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
			FileInputStream fileInputStream = new FileInputStream(inputFile);
			FileChannel inChannel = fileInputStream.getChannel();
			FileOutputStream fileOutputStream = new FileOutputStream(movedInputFile);
			FileChannel outChannel = fileOutputStream.getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
			inChannel.close();
			outChannel.close();
			fileInputStream.close();
			fileOutputStream.close();
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
