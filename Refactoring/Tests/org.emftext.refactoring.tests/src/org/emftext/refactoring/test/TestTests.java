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
import java.util.Collection;
import java.util.Collections;
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
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.language.refactoring.specification.resource.mopp.RefspecResourceFactory;
import org.emftext.test.test.TestDataPair;
import org.emftext.test.test.TestFileFilter;
import org.emftext.test.test.TestTest;

/**
 * Runs all tests.
 * 
 * @author Jan Reimann
 *
 */
public class TestTests extends TestCase{

	public static final String INPUT_FOLDER 	= "testInput";
	public static final String EXPECT_EXTENSION = "expected";

	@SuppressWarnings("unchecked")
	private static final ArrayList<Class<? extends TestClass>> testClasses = new ArrayList<Class<? extends TestClass>>(Arrays.asList(
			TestTest.class
		));


	private static final Logger LOG = Logger.getLogger(TestTests.class.getSimpleName());

	public static Test suite(){
		registerEPackages();
		registerResourceFactories();
		TestSuite suite = new TestSuite("All Refactoring Tests"){};
		for (Class<? extends TestClass> testClass : testClasses) {
			suite.addTest(createTests(testClass));
		}
		return suite;
	}

	private static List<TestDataPair> getTestDataPairs(String classFolder, String filePattern){
		List<TestDataPair> testData = new LinkedList<TestDataPair>();
		try {
			File rootFolder = new File(INPUT_FOLDER);
			checkFolder(rootFolder);
			File folder = new File(rootFolder.getAbsolutePath() + File.separator + classFolder);
			checkFolder(folder);
			File[] files = folder.listFiles(new TestFileFilter(filePattern, false));
			for (File file : files) {
				File[] filePair = folder.listFiles(new TestFileFilter(file.getName(), true));
				File input = null;
				File expected = null;
				for (File file2 : filePair) {
					if(file2.getName().endsWith(EXPECT_EXTENSION)){
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

	private static TestSuite createTests(Class<? extends TestClass> testClass){
		TestSuite newSuite = new TestSuite(testClass.getSimpleName());
		String folder = null;
		TestData classAnnotation = testClass.getAnnotation(TestData.class);
		if(classAnnotation != null){
			folder = classAnnotation.pattern();
		} else {
			folder = testClass.getSimpleName();
		}
		Method[] methods = testClass.getMethods();
		for (final Method method : methods) {
			org.junit.Test testAnnotation = method.getAnnotation(org.junit.Test.class);
			TestData testDataAnnotation = method.getAnnotation(TestData.class);
			List<TestDataPair> testData = null;
			if(testDataAnnotation != null && testAnnotation != null){
				testData = getTestDataPairs(folder, testDataAnnotation.pattern());
			} else if (testAnnotation != null){
				testData = getTestDataPairs(folder, method.getName());
			} else {
				continue;
			}
			try {
				for (TestDataPair testDataPair : testData) {
					AbstractRefactoringTest newTest = createTest(testClass
							, method
							, testDataPair
							, "METHOD: " + method.getName() + " DATA: " + testDataPair.getInput().getName());
					newSuite.addTest(newTest);
					LOG.info("Adding test " + testClass.getSimpleName() + " for method " + method.getName() + " and file " + testDataPair.getInput().getName());
				}
				if(testData == null || testData.size() == 0){
					AbstractRefactoringTest newTest = createTest(testClass
							, method
							, null
							, "Test in class " + testClass.getSimpleName() + " for method " + method.getName());
					newSuite.addTest(newTest);
					LOG.info("Adding test " + testClass.getSimpleName() + " for method " + method.getName());
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

	private static AbstractRefactoringTest createTest(Class<? extends TestClass> testClass, final Method method, TestDataPair testDataPair, String name) throws InstantiationException, IllegalAccessException{
		final TestClass instance = (TestClass) testClass.newInstance();
		AbstractRefactoringTest newTest = new AbstractRefactoringTest() {
			@Override
			public void runRefactoringTest() {
				try {
					method.invoke(instance);
				} catch (IllegalArgumentException e) {
					LOG.severe("Could not invoke method " + method.getName());
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					LOG.severe("Method " + method.getName() + " threw an exception");
					e.printStackTrace();
				}
			}
		};
		newTest.setTestData(testDataPair);
		newTest.setName(name);
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
