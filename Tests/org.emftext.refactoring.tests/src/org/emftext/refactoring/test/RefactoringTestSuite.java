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
package org.emftext.refactoring.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.emftext.language.conference.ConferencePackage;
import org.emftext.language.conference.resource.conference.mopp.ConferenceResourceFactory;
import org.emftext.language.java.JavaPackage;
import org.emftext.language.java.containers.ContainersPackage;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.postprocessing.EmptyOutgoingRelationTestFragment;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.language.refactoring.specification.resource.mopp.RefspecResourceFactory;
import org.emftext.language.textadventure.TextadventurePackage;
import org.emftext.language.textadventure.resource.tas.mopp.TasResourceFactory;
import org.emftext.refactoring.continued_testing.ContinuedRefactoringTestFragment;
import org.emftext.refactoring.graph.GraphTestFragment;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;
import org.emftext.refactoring.roleconstraintchecker.RoleConstraintCheckerTestFragment;
import org.emftext.refactoring.specification.interpreter.RefactoringInterpreterTestFragment;
import org.emftext.refactoring.tests.properties.Category;
import org.emftext.refactoring.tests.properties.EObjectReferenceValue;
import org.emftext.refactoring.tests.properties.KeyValuePair;
import org.emftext.refactoring.tests.properties.PropertiesPackage;
import org.emftext.refactoring.tests.properties.PropertyModel;
import org.emftext.refactoring.tests.properties.StringValue;
import org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation;
import org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResourceFactory;
import org.emftext.refactoring.util.UtilTestFragment;
import org.emftext.test.core.AbstractRefactoringTestCase;
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
import org.junit.Ignore;

/**
 * Runs all tests.
 * 
 * @author Jan Reimann
 *
 */
public class RefactoringTestSuite extends TestCase {

	//	private static final String PLUGIN_ID 						= "org.emftext.refactoring.tests";
	public static final String INPUT_FOLDER = "testInput";
	public static final String EXPECTED_DATA_FILE_NAME_INSERT = ".expected";

	// paths for files which will be inserted into registries
	public static final String REGISTRY_FOLDER = INPUT_FOLDER + File.separator + "registry";
	public static final String MODELS_TO_REGISTER = REGISTRY_FOLDER + File.separator + "referenced_models.testproperties";

	@SuppressWarnings("unchecked")
	private static final List<Class<? extends TestClass>> testClasses = new ArrayList<Class<? extends TestClass>>(Arrays.asList(
			TestTestFragment.class,
			EmptyOutgoingRelationTestFragment.class,
			RefactoringInterpreterTestFragment.class,
			//			IndexConnectorTestFragment.class,
			RoleConstraintCheckerTestFragment.class,
			UtilTestFragment.class,
			GraphTestFragment.class,
			ContinuedRefactoringTestFragment.class));

	private static final Logger LOG = Logger.getLogger(RefactoringTestSuite.class.getSimpleName());

	private static void registerTestingRootAsPlatformRoot() {
		Map<String, URI> resourceMap = EcorePlugin.getPlatformResourceMap();
		File root = new File(".");
		assertTrue(root.exists());

		root = root.getAbsoluteFile();
		assertTrue(root.exists());
		root = root.getParentFile().getParentFile();
		assertTrue(root.exists());
		File[] subDirs = root.listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.exists() && pathname.isDirectory() && !pathname.isHidden() && pathname.canRead() && !pathname.getName().startsWith(
						".");
			}
		});
		for (File subDir : subDirs) {
			String rootPath = subDir.getAbsolutePath() + File.separator + ".";
			URI rootUri = URI.createFileURI(rootPath);
			rootUri = rootUri.trimSegments(1);
			String testProjectRoot = rootUri.lastSegment();
			assertNotNull(testProjectRoot);
			rootUri = URI.createFileURI(rootPath);
			resourceMap.put(testProjectRoot, rootUri);
		}
	}

	private static void registerModelsForRefactorings() {
		Resource models2Register = TestUtil.getResourceFromFile(TestUtil.getFileByPath(MODELS_TO_REGISTER));
		EObject root = models2Register.getContents().get(0);
		if (root instanceof PropertyModel) {
			List<Category> categories = ((PropertyModel) root).getCategories();
			for (Category category : categories) {
				if ("rolemodels".equals(category.getName())) {
					List<KeyValuePair> pairs = category.getPairs();
					for (KeyValuePair pair : pairs) {
						EObjectReferenceValue value = (EObjectReferenceValue) pair.getValue();
						EObject objectReference = value.getObjectReference();
						failIfProxy(objectReference);
						RoleModel roleModel = (RoleModel) objectReference;
						try {
							IRoleModelRegistry.INSTANCE.registerRoleModel(roleModel);
						} catch (RoleModelAlreadyRegisteredException e) {
							e.printStackTrace();
						}
					}
				} else if ("refspecs".equals(category.getName())) {
					List<KeyValuePair> pairs = category.getPairs();
					for (KeyValuePair pair : pairs) {
						EObjectReferenceValue value = (EObjectReferenceValue) pair.getValue();
						EObject objectReference = value.getObjectReference();
						failIfProxy(objectReference);
						RefactoringSpecification refSpec = (RefactoringSpecification) objectReference;
						try {
							IRefactoringSpecificationRegistry.INSTANCE.registerRefSpec(refSpec);
						} catch (RefSpecAlreadyRegisteredException e) {
							e.printStackTrace();
						}
					}
				} else if ("mappings".equals(category.getName())) {
					List<KeyValuePair> pairs = category.getPairs();
					for (KeyValuePair pair : pairs) {
						EObjectReferenceValue value = (EObjectReferenceValue) pair.getValue();
						EObject objectReference = value.getObjectReference();
						failIfProxy(objectReference);
						RoleMappingModel mapping = (RoleMappingModel) objectReference;
						EcoreUtil.resolveAll(mapping);
						IRoleMappingRegistry.INSTANCE.registerRoleMappingModel(mapping);
					}
				}
			}
		}
	}

	private static void failIfProxy(EObject objectReference) {
		if (objectReference.eIsProxy()) {
			InternalEObject proxy = (InternalEObject) objectReference;
			String message = "RefactoringTestSuite.registerModelsForRefactorings() Can't resolve reference " + proxy.eProxyURI();
			System.err.println(message);
			fail(message);
		}
	}

	public static Test suite() {
		registerEPackages();
		registerResourceFactories();
		registerTestingRootAsPlatformRoot();
		registerModelsForRefactorings();
		registerPostProcessors();
		TestSuite suite = new TestSuite("All Refactoring Tests") {};
		for (Class<? extends TestClass> testClass : testClasses) {
			try {
				suite.addTest(createTests(testClass));
			} catch (final Exception e) {
				suite.addTest(new TestCase(testClass.getSimpleName()) {

					@Override
					protected void runTest() throws Throwable {
						Assert.fail(e.getMessage());
					}

				});
			}
		}
		return suite;
	}

	private static void registerPostProcessors() {
		Resource models2Register = TestUtil.getResourceFromFile(TestUtil.getFileByPath(MODELS_TO_REGISTER));
		EObject root = models2Register.getContents().get(0);
		if (root instanceof PropertyModel) {
			List<Category> categories = ((PropertyModel) root).getCategories();
			for (Category category : categories) {
				if ("postprocessor".equals(category.getName())) {
					String nsUri = null;
					String mappingName = null;
					String qualifiedClass = null;
					for (KeyValuePair pair : category.getPairs()) {
						if ("nsUri".equals(pair.getKey().getName()) && pair.getValue() instanceof StringValue) {
							nsUri = ((StringValue) pair.getValue()).getValue();
						} else if ("mappingName".equals(pair.getKey().getName()) && pair.getValue() instanceof StringValue) {
							mappingName = ((StringValue) pair.getValue()).getValue();
						} else if ("class".equals(pair.getKey().getName()) && pair.getValue() instanceof StringValue) {
							qualifiedClass = ((StringValue) pair.getValue()).getValue();
						}
					}
					if (nsUri != null && mappingName != null && qualifiedClass != null) {
						try {
							Class<?> postProcessorClass = Class.forName(qualifiedClass);
							if (IRefactoringPostProcessor.class.isAssignableFrom(postProcessorClass)) {
								IRefactoringPostProcessor postProcessor = (IRefactoringPostProcessor) postProcessorClass.newInstance();
								Map<String, RoleMapping> mappings = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(nsUri);
								if (mappings != null) {
									RoleMapping mapping = mappings.get(mappingName);
									if (mapping != null) {
										IRoleMappingRegistry.INSTANCE.registerPostProcessor(
												mapping, postProcessor);
									}
								}
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
							Assert.fail(e.getMessage());
						} catch (InstantiationException e) {
							e.printStackTrace();
							Assert.fail(e.getMessage());
						} catch (IllegalAccessException e) {
							e.printStackTrace();
							Assert.fail(e.getMessage());
						}
					}
				}
			}
		}
	}

	private static List<TestDataPairSet> getTestDataPairs(String classFolder, String[] filePatterns) {
		List<List<TestDataPair>> pairSets = new LinkedList<List<TestDataPair>>();
		int greatestList = 0;
		for (String filePattern : filePatterns) {
			List<TestDataPair> dataPairs = getTestDataPairs(classFolder,
					filePattern);
			pairSets.add(dataPairs);
			if (dataPairs.size() > greatestList) {
				greatestList = dataPairs.size();
			}
		}
		List<TestDataPairSet> result = new LinkedList<TestDataPairSet>();
		for (int i = 0; i < greatestList; i++) {
			TestDataPairSet newPairSet = new TestDataPairSet();
			for (int j = 0; j < pairSets.size(); j++) {
				if (pairSets.get(j).size() - 1 >= i) {
					newPairSet.addDataPair(pairSets.get(j).get(i));
				}
			}
			if (newPairSet.getDataPairs().size() > 0) {
				result.add(newPairSet);
			}
		}
		return result;
	}

	private static List<File> getTestFiles(String classFolder, String filePattern, boolean includeExpectExtension, String... exclusionPatterns) {
		try {
			File rootFolder = new File(INPUT_FOLDER);
			checkFolder(rootFolder);
			File folder = new File(rootFolder.getAbsolutePath() + File.separator + classFolder);
			checkFolder(folder);
			File[] files = folder.listFiles(new DataSetTestFileFilter(filePattern, includeExpectExtension, exclusionPatterns));
			List<File> fileList = new ArrayList<File>();
			for (File file : files) {
				fileList.add(file);
			}
			Collections.sort(fileList, new Comparator<File>() {
				public int compare(File o1, File o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			return fileList;
		} catch (FileNotFoundException e) {
			LOG.severe(e.getMessage());
			return null;
		}
	}

	private static String[] getOthers(String[] inputValue, String base) {
		List<String> values = new ArrayList<String>();
		for (String string : inputValue) {
			if (string.length() > base.length()) {
				values.add(string);
			}
		}
		values.remove(base);
		return values.toArray(new String[0]);
	}

	private static List<TestDataSet> getTestFiles(String classFolder, String[] inputValue, String[] expectedValue) throws FileNotFoundException {
		List<List<File>> inputFiles = new LinkedList<List<File>>();
		List<List<File>> expectedFiles = new LinkedList<List<File>>();
		int setCount = -1;
		if (inputValue != null) {
			for (String filePattern : inputValue) {
				String[] otherInputValues = getOthers(inputValue, filePattern);
				List<File> files = getTestFiles(classFolder, filePattern, true,
						otherInputValues);
				if (setCount == -1) {
					setCount = files.size();
				} else {
					if (setCount != files.size()) {
						throw new FileNotFoundException("Some input files were not found. For TestDataSet all sets for one test method must have the same size.");
					}
				}
				inputFiles.add(files);
			}
		}
		if (expectedValue != null) {
			for (String filePattern : expectedValue) {
				String[] otherExpectedValues = getOthers(expectedValue,
						filePattern);
				List<File> files = getTestFiles(classFolder, filePattern,
						false, otherExpectedValues);
				for (List<File> list : inputFiles) {
					files.removeAll(list);
				}
				if (setCount == -1) {
					setCount = files.size();
				} else {
					if (setCount != files.size()) {
						throw new FileNotFoundException("Some expected files were not found. For TestDataSet all sets for one test method must have the same size.");
					}
				}
				expectedFiles.add(files);
			}
		}
		List<TestDataSet> result = new LinkedList<TestDataSet>();
		// TODO order of collected files is not the same -> alphabetical order? edit distance to determine corresponding files?
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

	private static List<TestDataPair> getTestDataPairs(String classFolder, String filePattern) {
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
					if (file2.getName().contains(EXPECTED_DATA_FILE_NAME_INSERT)) {
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
		if (!rootFolder.exists()) {
			String message = "Input folder '" + INPUT_FOLDER + "' doesn't exist";
			throw new FileNotFoundException(message);
		}
		if (!rootFolder.isDirectory()) {
			String message = "Input folder '" + INPUT_FOLDER + "' is not a directory";
			throw new FileNotFoundException(message);
		}
	}

	private static Test handleDataPairAnnotation(Class<? extends TestClass> testClass, Method method, String folder) throws InstantiationException, IllegalAccessException {
		DataPairs dataPairsAnnotation = method.getAnnotation(DataPairs.class);
		List<TestDataPairSet> testData = null;
		if (dataPairsAnnotation != null) {
			testData = getTestDataPairs(folder, dataPairsAnnotation.value());
		} 
		Test methodSuite = null;
		if (testData == null || testData.size() == 0) {
			AbstractRefactoringTestCase newTest = createTest(testClass, method,
					null, method.getName());
			methodSuite = newTest;
			LOG.info("Adding test " + testClass.getSimpleName() + " for method " + method.getName());
			if (newTest != null) {
				LOG.info("Created Test " + newTest.getName());
			}
		} else {
			methodSuite = new TestSuite(method.getName() + " Data:Pairs");
			for (TestDataPairSet testPairSet : testData) {
				String dataString = "";
				for (TestDataPair testDataPair : testPairSet.getDataPairs()) {
					dataString += " " + testDataPair.getInput().getName();
				}
				AbstractRefactoringTestCase newTest = createTest(testClass, method,
						testPairSet, method.getName() + " -> DATA:" + dataString);
				if (newTest != null) {
					((TestSuite) methodSuite).addTest(newTest);
					LOG.info("Adding test " + testClass.getSimpleName() + " for method " + method.getName() + " and files" + dataString);
					LOG.info("Created Test " + newTest.getName());
				}
			}
		}
		return methodSuite;
	}

	private static Test handleInputExpectedDataAnnotation(Class<? extends TestClass> testClass, Method method, String folder) throws InstantiationException, IllegalAccessException, FileNotFoundException {
		InputData inputDataAnnotation = method.getAnnotation(InputData.class);
		ExpectedData expectedDataAnnotation = method.getAnnotation(ExpectedData.class);
		if (inputDataAnnotation == null && expectedDataAnnotation == null) {
			return null;
		}
		List<TestDataSet> dataFiles = null;
		String[] inputValue = null;
		String[] expectedValue = null;
		if (inputDataAnnotation != null) {
			inputValue = inputDataAnnotation.value();
		}
		if (expectedDataAnnotation != null) {
			expectedValue = expectedDataAnnotation.value();
		}
		dataFiles = getTestFiles(folder, inputValue, expectedValue);
		Test methodSuite = null;
		if (dataFiles == null || dataFiles.size() == 0) {
			AbstractRefactoringTestCase newTest = createTest(testClass, method,
					null, method.getName());
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
				AbstractRefactoringTestCase newTest = createTest(testClass, method,
						testData,
						method.getName() + " -> INPUT:" + inputFiles + " EXPECTED:" + expectedFiles);
				if (newTest != null) {
					((TestSuite) methodSuite).addTest(newTest);
					LOG.info("Adding test " + testClass.getSimpleName() + " for method " + method.getName() + " with input files" + inputFiles + " and expected files " + expectedFiles);
					LOG.info("Created Test " + newTest.getName());
				}
			}
		}
		return methodSuite;
	}

	private static TestSuite createTests(Class<? extends TestClass> testClass) throws FileNotFoundException {
		TestSuite newSuite = new TestSuite(testClass.getSimpleName());
		String folder = null;
		TestData classAnnotation = testClass.getAnnotation(TestData.class);
		if (classAnnotation != null) {
			folder = classAnnotation.value();
		} else {
			folder = testClass.getSimpleName();
		}
		Method[] methods = testClass.getMethods();
		for (final Method method : methods) {
			//			TestSuite methodSuite = new TestSuite(method.getName());
			try {
				org.junit.Test testAnnotation = method.getAnnotation(org.junit.Test.class);
				if (testAnnotation == null) {
					continue;
				}
				Ignore  ignoreAnnotation = method.getAnnotation(Ignore.class);
				if(ignoreAnnotation != null){
					// method won't be added to test suite if @ignore is set
					continue;
				} 
				Test inputExpectedDataTest = handleInputExpectedDataAnnotation(testClass, method, folder);
				if (inputExpectedDataTest != null && inputExpectedDataTest.countTestCases() > 0) {
					newSuite.addTest(inputExpectedDataTest);
				} else {
					Test dataPairTest = handleDataPairAnnotation(testClass,
							method, folder);
					if (dataPairTest != null && dataPairTest.countTestCases() > 0) {
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

	private static AbstractRefactoringTestCase createTest(Class<? extends TestClass> testClass, final Method method, final TestDataSet testData, String name) throws InstantiationException, IllegalAccessException {
		final TestClass instance = testClass.newInstance();
		AbstractRefactoringTestCase newTest = new AbstractRefactoringTestCase() {

			@Override
			public void runRefactoringTest() throws Throwable {
				try {
					instance.setTestDataSet(testData);
					method.invoke(instance);
				} catch (IllegalArgumentException e) {
					LOG.severe("Could not invoke method " + method.getName());
					throw e;
				} catch (IllegalAccessException e) {
					throw e;
				} catch (InvocationTargetException e) {
					if (!(e.getTargetException() instanceof AssertionError)) {
						LOG.severe("Method " + method.getName() + " threw an exception");
					}
					throw e.getTargetException();
				}
			}
		};
		newTest.setName(name + " " + UUID.randomUUID().toString());
		return newTest;
	}

	private static void registerEPackages() {
		// needed for refactorings
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI,
				RolesPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(RolemappingPackage.eNS_URI,
				RolemappingPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(RefactoringSpecificationPackage.eNS_URI,
				RefactoringSpecificationPackage.eINSTANCE);
		// properties package
		EPackage.Registry.INSTANCE.put(PropertiesPackage.eNS_URI,
				PropertiesPackage.eINSTANCE);
		// arbitrary metamodels
		EPackage.Registry.INSTANCE.put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ConferencePackage.eNS_URI,
				ConferencePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(TextadventurePackage.eNS_URI,
				TextadventurePackage.eINSTANCE);
		// all java packages
		EPackage.Registry.INSTANCE.put(JavaPackage.eNS_URI,
				JavaPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/2.0.0/UML",
				UMLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/2.1.0/UML",
				UMLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/3.0.0/UML",
				UMLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ContainersPackage.eNS_URI,
				ContainersPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(MembersPackage.eNS_URI,
				MembersPackage.eINSTANCE);
	}

	private static void registerResourceFactories() {
		// needed for refactorings
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put("rolestext", new RolestextResourceFactory());
		extensionToFactoryMap.put("rolemapping",
				new RolemappingResourceFactory());
		extensionToFactoryMap.put("refspec", new RefspecResourceFactory());
		// properties
		extensionToFactoryMap.put(new TestpropertiesMetaInformation().getSyntaxName(), new TestpropertiesResourceFactory());
		// arbitrary metamodels
		extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl());
		extensionToFactoryMap.put("pl0", new Pl0ResourceFactory());
		extensionToFactoryMap.put("conference", new ConferenceResourceFactory());
		extensionToFactoryMap.put("java",
				new JavaSourceOrClassFileResourceFactoryImpl());
		extensionToFactoryMap.put("tas", new TasResourceFactory());
		extensionToFactoryMap.put("uml", new UMLResourceFactoryImpl());
//		UMLPackage.eINSTANCE.getAbstraction();
//		extensionToFactoryMap.put("uml", new UML302UMLResourceFactoryImpl());
	}
}
