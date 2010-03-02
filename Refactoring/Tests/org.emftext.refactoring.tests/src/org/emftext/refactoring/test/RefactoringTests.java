/**
 * 
 */
package org.emftext.refactoring.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.postprocessing.EmptyOutgoingRelationTest;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.language.refactoring.specification.resource.mopp.RefspecResourceFactory;
import org.emftext.refactoring.specification.interpreter.RefactoringInterpreterTest;
import org.emftext.test.core.AbstractRefactoringTest;
import org.emftext.test.core.DataPairTestFileFilter;
import org.emftext.test.core.DataPairs;
import org.emftext.test.core.DataSetTestFileFilter;
import org.emftext.test.core.ExpectedData;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.emftext.test.core.TestData;
import org.emftext.test.core.TestDataPair;
import org.emftext.test.core.TestDataPairSet;
import org.emftext.test.core.TestDataSet;

/**
 * Runs all tests.
 * 
 * @author Jan Reimann
 *
 */
public class RefactoringTests extends TestCase{

	public static final String INPUT_FOLDER 					= "testInput";
	public static final String EXPECTED_DATA_FILE_NAME_INSERT 	= ".expected";

	@SuppressWarnings("unchecked")
	private static final List<Class<? extends TestClass>> testClasses = new ArrayList<Class<? extends TestClass>>(Arrays.asList(
			TestTest.class,
			EmptyOutgoingRelationTest.class,
			RefactoringInterpreterTest.class
	));


	private static final Logger LOG = Logger.getLogger(RefactoringTests.class.getSimpleName());

	public static Test suite(){
		registerEPackages();
		registerResourceFactories();
		TestSuite suite = new TestSuite("All Refactoring Tests"){};
		for (Class<? extends TestClass> testClass : testClasses) {
			try {
				suite.addTest(createTests(testClass));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return suite;
	}

	private static List<TestDataPairSet> getTestDataPairs(String classFolder, String[] filePatterns){
		List<List<TestDataPair>> pairSets = new LinkedList<List<TestDataPair>>();
		int greatestList = 0;
		for (String filePattern : filePatterns) {
			List<TestDataPair> dataPairs = getTestDataPairs(classFolder, filePattern);
			pairSets.add(dataPairs);
			if(dataPairs.size() > greatestList){
				greatestList = dataPairs.size();
			}
		}
		List<TestDataPairSet> result = new LinkedList<TestDataPairSet>();
		for (int i = 0; i < greatestList; i++) {
			TestDataPairSet newPairSet = new TestDataPairSet();
			for (int j = 0; j < pairSets.size(); j++) {
				if(pairSets.get(j).size() - 1 >= i){
					newPairSet.addDataPair(pairSets.get(j).get(i));
				}
			}
			if(newPairSet.getDataPairs().size() > 0){
				result.add(newPairSet);
			}
		}	
		return result;
	}

	private static List<File> getTestFiles(String classFolder, String filePattern, boolean includeExpectExtension){
		try {
			File rootFolder = new File(INPUT_FOLDER);
			checkFolder(rootFolder);
			File folder = new File(rootFolder.getAbsolutePath() + File.separator + classFolder);
			checkFolder(folder);
			File[] files = folder.listFiles(new DataSetTestFileFilter(filePattern));
			return Arrays.asList(files);
		} catch (FileNotFoundException e) {
			LOG.severe(e.getMessage());
			return null;
		}
	}

	private static List<TestDataSet> getTestFiles(String classFolder, String[] inputValue, String[] expectedValue) throws FileNotFoundException{
		List<List<File>> inputFiles = new LinkedList<List<File>>();
		List<List<File>> expectedFiles = new LinkedList<List<File>>();
		int setCount = -1;
		if(inputValue != null){
			for (String filePattern : inputValue) {
				List<File> files = getTestFiles(classFolder, filePattern, false);
				if(setCount == -1){
					setCount = files.size();
				} else {
					if(setCount != files.size()){
						throw new FileNotFoundException("Some input files were not found. For TestDataSet all sets for one test method must have the same size.");
					}
				}
				inputFiles.add(files);
			}
		}
		if(expectedValue != null){
			for (String filePattern : expectedValue) {
				List<File> files = getTestFiles(classFolder, filePattern, false);
				if(setCount == -1){
					setCount = files.size();
				} else {
					if(setCount != files.size()){
						throw new FileNotFoundException("Some expected files were not found. For TestDataSet all sets for one test method must have the same size.");
					}
				}
				expectedFiles.add(files);
			}
		}
		List<TestDataSet> result = new LinkedList<TestDataSet>();
		for (int i = 0; i < setCount; i++) {
			TestDataSet dataSet = new TestDataSet();
			for (List<File> list : inputFiles) {
				dataSet.getInputDataFiles().add(list.get(i));
			}
			for (List<File> list : expectedFiles) {
				dataSet.getExpectedDataFiles().add(list.get(i));
			}
			result.add(dataSet);
		}
		return result;
	}

	private static List<TestDataPair> getTestDataPairs(String classFolder, String filePattern){
		List<TestDataPair> testData = new LinkedList<TestDataPair>();
		try {
			File rootFolder = new File(INPUT_FOLDER);
			checkFolder(rootFolder);
			File folder = new File(rootFolder.getAbsolutePath() + File.separator + classFolder);
			checkFolder(folder);
			File[] files = folder.listFiles(new DataPairTestFileFilter(filePattern, false));
			for (File file : files) {
				File[] filePair = folder.listFiles(new DataPairTestFileFilter(file.getName(), true));
				File input = null;
				File expected = null;
				for (File file2 : filePair) {
					if(file2.getName().contains(EXPECTED_DATA_FILE_NAME_INSERT)){
						expected = file2;
						LOG.info("Found expected data in file " + expected.getName());
					} else {
						input = file2;
						LOG.info("Found input data in file " + input.getName());
					}
				}
				TestDataPair pair = new TestDataPair(input, expected);
				testData.add(pair);
			}
		} catch (FileNotFoundException e) {
			LOG.severe(e.getMessage());
			return null;
		}
		return testData;
	}

	private static void checkFolder(File rootFolder) throws FileNotFoundException {
		if(!rootFolder.exists()){
			String message = "Input folder '" + INPUT_FOLDER + "' doesn't exist";
			throw new FileNotFoundException(message);
		}
		if(!rootFolder.isDirectory()){
			String message = "Input folder '" + INPUT_FOLDER + "' is not a directory";
			throw new FileNotFoundException(message);
		}
	}

	private static Test handleDataPairAnnotation(Class<? extends TestClass> testClass, Method method, String folder) throws InstantiationException, IllegalAccessException{
		DataPairs dataPairsAnnotation = method.getAnnotation(DataPairs.class);
		List<TestDataPairSet> testData = null;
		if(dataPairsAnnotation != null){
			testData = getTestDataPairs(folder, dataPairsAnnotation.value());
		} else {
			testData = getTestDataPairs(folder, new String[]{method.getName()});
		} 
		Test methodSuite = null;
		if(testData == null || testData.size() == 0){
			AbstractRefactoringTest newTest = createTest(testClass
					, method
					, null
					, method.getName());
			methodSuite = newTest;
			LOG.info("Adding test " + testClass.getSimpleName() + " for method " + method.getName());
			if(newTest != null){
				LOG.info("Created Test " + newTest.getName());
			}
		} else {
			methodSuite = new TestSuite(method.getName() + " Data:Pairs");
			for (TestDataPairSet testPairSet : testData) {
				String dataString = "";
				for (TestDataPair testDataPair : testPairSet.getDataPairs()) {
					dataString += " " + testDataPair.getInput().getName(); 
				}
				AbstractRefactoringTest newTest = createTest(testClass
						, method
						, testPairSet
						, "DATA:" + dataString);
				if(newTest != null){
					((TestSuite) methodSuite).addTest(newTest);
					LOG.info("Adding test " + testClass.getSimpleName() + " for method " + method.getName() + " and files" + dataString);
					LOG.info("Created Test " + newTest.getName());
				}
			}
		}
		return methodSuite;
	}

	private static Test handleInputExpectedDataAnnotation(Class<? extends TestClass> testClass, Method method, String folder) throws InstantiationException, IllegalAccessException, FileNotFoundException{
		InputData inputDataAnnotation = method.getAnnotation(InputData.class);
		ExpectedData expectedDataAnnotation = method.getAnnotation(ExpectedData.class);
		if(inputDataAnnotation == null && expectedDataAnnotation == null){
			return null;
		}
		List<TestDataSet> dataFiles = null;
		String[] inputValue = null;
		String[] expectedValue = null;
		if(inputDataAnnotation != null){
			inputValue = inputDataAnnotation.value();
		}
		if(expectedDataAnnotation != null){
			expectedValue = expectedDataAnnotation.value();
		}
		dataFiles = getTestFiles(folder, inputValue, expectedValue);
		Test methodSuite = null;
		if(dataFiles == null || dataFiles.size() == 0){
			AbstractRefactoringTest newTest = createTest(testClass
					, method
					, null
					, method.getName());
			methodSuite = newTest;
			LOG.info("Adding test " + testClass.getSimpleName() + " for method " + method.getName());
			LOG.info("Created Test " + newTest.getName());
		} else {
			methodSuite = new TestSuite(method.getName() + " Data:IE");
			for (TestDataSet testData : dataFiles) {
				String inputFiles = "";
				for (File inputFile : testData.getInputDataFiles()) {
					inputFiles += " " + inputFile.getName(); 
				}
				String expectedFiles = "";
				for (File expectedFile : testData.getExpectedDataFiles()) {
					expectedFiles += " " + expectedFile.getName(); 
				}
				AbstractRefactoringTest newTest = createTest(testClass
						, method
						, testData
						, "INPUT:" + inputFiles + " EXPECTED:" + expectedFiles);
				if(newTest != null){
					((TestSuite) methodSuite).addTest(newTest);
					LOG.info("Adding test " + testClass.getSimpleName() + " for method " + method.getName() + " with input files" + inputFiles + " and expected files " + expectedFiles);
					LOG.info("Created Test " + newTest.getName());
				}				
			}
		}
		return methodSuite;
	}

	private static TestSuite createTests(Class<? extends TestClass> testClass) throws FileNotFoundException{
		TestSuite newSuite = new TestSuite(testClass.getSimpleName());
		String folder = null;
		TestData classAnnotation = testClass.getAnnotation(TestData.class);
		if(classAnnotation != null){
			folder = classAnnotation.value();
		} else {
			folder = testClass.getSimpleName();
		}
		Method[] methods = testClass.getMethods();
		for (final Method method : methods) {
			//			TestSuite methodSuite = new TestSuite(method.getName());
			try {
				org.junit.Test testAnnotation = method.getAnnotation(org.junit.Test.class);
				if(testAnnotation == null){
					continue;
				}
				Test inputExpectedDataTest = handleInputExpectedDataAnnotation(testClass, method, folder); 
				if(inputExpectedDataTest != null && inputExpectedDataTest.countTestCases() > 0){
					newSuite.addTest(inputExpectedDataTest);
				} else {
					Test dataPairTest = handleDataPairAnnotation(testClass, method, folder);
					if(dataPairTest != null && dataPairTest.countTestCases() > 0){
						newSuite.addTest(dataPairTest);
					}
				}
			} catch (InstantiationException e) {
				LOG.severe("Could not instantiate TestClass " + testClass.getSimpleName());
				e.printStackTrace();
				continue;
			} catch (IllegalAccessException e) {
				LOG.severe("Could not invoke constructor of TestClass " + testClass.getSimpleName());
				e.printStackTrace();
				continue;
			}
		}
		return newSuite;
	}

	private static AbstractRefactoringTest createTest(Class<? extends TestClass> testClass, final Method method, final TestDataSet testData, String name) throws InstantiationException, IllegalAccessException{
		final TestClass instance = testClass.newInstance();
		AbstractRefactoringTest newTest = new AbstractRefactoringTest() {
			@Override
			public void runRefactoringTest() throws Throwable{
				try {
					instance.setTestDataSet(testData);
					method.invoke(instance);
				} catch (IllegalArgumentException e) {
					LOG.severe("Could not invoke method " + method.getName());
					throw e;
				} catch (IllegalAccessException e) {
					throw e;
				} catch (InvocationTargetException e) {
					LOG.severe("Method " + method.getName() + " threw an exception");
					throw e.getTargetException();
				}
			}
		};
		newTest.setName(name + " " + System.currentTimeMillis());
		return newTest;
	}

	private static void registerEPackages(){
		// needed for refactorings
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(RolemappingPackage.eNS_URI, RolemappingPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(RefactoringSpecificationPackage.eNS_URI, RefactoringSpecificationPackage.eINSTANCE);
		// arbitrary metamodels
		EPackage.Registry.INSTANCE.put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
	}

	private static void registerResourceFactories(){
		// needed for refactorings
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("rolestext", new RolestextResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("rolemapping", new RolemappingResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("refspec", new RefspecResourceFactory());
		// arbitrary metamodels
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("pl0", new Pl0ResourceFactory());
	}

}
