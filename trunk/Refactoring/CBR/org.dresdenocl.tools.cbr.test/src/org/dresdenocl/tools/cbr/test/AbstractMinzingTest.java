package org.dresdenocl.tools.cbr.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import tudresden.ocl20.pivot.essentialocl.expressions.ExpressionInOcl;
import tudresden.ocl20.pivot.facade.Ocl2ForEclipseFacade;
import tudresden.ocl20.pivot.metamodels.ecore.EcoreMetamodelPlugin;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;
import tudresden.ocl20.pivot.pivotmodel.Constraint;

/**
 * Abstract test case for the Minzinc Generator.
 * 
 * @author Claas Wilke
 * 
 */
public class AbstractMinzingTest {

	/** The location of the {@link IModel} used for testing. */
	protected static final String MODEL_NAME = "resources/model/UML.ecore";

	/** The location of the {@link IModel} used for testing. */
	protected static final String MODEL_INSTANCE01_NAME = "resources/instances/sequence01.uml";
	
	protected static final String CONSTRAINT_FILE = "resources/instances/wfr_sequence.ocl";

	protected static IModel testModel;
	
	protected static List<ExpressionInOcl> oclExpressions;

	/**
	 * <p>
	 * Initializes the test cases.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {

		File modelFile;
		modelFile = getFile(MODEL_NAME);

		testModel = ModelBusPlugin.getMetamodelRegistry()
				.getMetamodel(EcoreMetamodelPlugin.ID).getModelProvider()
				.getModel(modelFile);
		
		// loading constraint file
		File contraintFile = getFile(CONSTRAINT_FILE);
		List<Constraint> constraints = Ocl2ForEclipseFacade.parseConstraints(contraintFile, testModel, false);
		oclExpressions = new LinkedList<ExpressionInOcl>();
		for (Constraint constraint : constraints) {
			assertTrue("constraint must be instanceof ExpressionInOcl", constraint.getSpecification() instanceof ExpressionInOcl);
			oclExpressions.add((ExpressionInOcl) constraint.getSpecification());
		}
//		ExpressionInOcl.getBodyExpression
	}

	/**
	 * <p>
	 * Tears down the test cases.
	 * </p>
	 * 
	 * @throws ModelAccessException
	 * @throws IllegalArgumentException
	 */
	@AfterClass
	public static void tearDown() throws IllegalArgumentException,
			ModelAccessException {

		ModelBusPlugin.getModelRegistry().removeModel(testModel);
	}

	/**
	 * <p>
	 * Returns the file object for a given path relative to the plug-in's
	 * directory.
	 * </p>
	 * 
	 * @param path
	 *            The path of the resource.
	 * @return The found {@link File} object.
	 * @throws Exception
	 *             Thrown, if the opening fails.
	 */
	protected static File getFile(String path) throws Exception {

		File file;
		file = new File("./../org.dresdenocl.tools.cbr.test/" + path);

		assertTrue(file.exists());

		return file;
	}

	/**
	 * <p>
	 * Compares a given <code>String</code> with a given expected
	 * <code>String</code> (as a path to a file) and lets the test fail if both
	 * codes don't match. <strong>Leading and tailing white spaces in each line
	 * of the <code>String</code>s will be ignored!</strong>.
	 * </p>
	 * 
	 * @param expectedFilePath
	 *            The path of the String file used for the difference test. The
	 *            path should be relative to the resource folder to avoid
	 *            errors.
	 * @param givenString
	 *            The String which shall be checked.
	 * @throws Exception
	 *             Thrown, if a difference test fails.
	 */
	public void compareStringAndFile(String expectedFilePath, String givenString)
			throws Exception {

		File expectedCodeFile = getFile(expectedFilePath);

		/* Compare String lines with expected lines from text file. */
		BufferedReader diffReader;
		String expectedString;

		/* Open expected String file. */
		diffReader = new BufferedReader(new FileReader(expectedCodeFile));

		expectedString = "";

		/* Read the expected code from file. */
		while (diffReader.ready()) {

			expectedString += diffReader.readLine();

			if (diffReader.ready()) {
				expectedString += "\n";
			}
			// no else.
		}
		// end while.

		String[] expectedLines;
		String[] givenLines;

		/* Split both strings into lines. */
		expectedLines = expectedString.split("\n");
		givenLines = givenString.split("\n");

		/* Both arrays must have the same length. */
		if (expectedLines.length != givenLines.length) {
			/*
			 * If two lines are not equal compare the whole file again to show
			 * the right error message with comparison failure.
			 */
			assertEquals(expectedString, givenString);
		}

		/* Else compare them line by line by trimming the lines.. */
		else {

			for (int index = 0; index < expectedLines.length; index++) {

				if (!expectedLines[index].trim().equals(
						givenLines[index].trim())) {
					/*
					 * If two lines are not equal compare the whole file again
					 * to show the right error message with comparison failure.
					 */
					assertEquals(expectedString, givenString);
				}
				// no else.
			}
			// end for.
		}
		// end else.
	}
}
