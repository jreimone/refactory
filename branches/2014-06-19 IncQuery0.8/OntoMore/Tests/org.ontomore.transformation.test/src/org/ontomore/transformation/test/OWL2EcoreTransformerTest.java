package org.ontomore.transformation.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ontomore.transformation.OWL2EcoreTransformer;
import org.ontomore.util.ModelComparator;

public class OWL2EcoreTransformerTest {

	private static final String EXPECTED_FOLDER_NAME = "expected/";
	private final String ACTUAL_FOLDER_NAME = "actual/";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOntologyToEPackage() {
		transformOntologyToEcore("container.owl");
		assertTrue(checkIfEqual("container.ecore"));
	}

	@Test
	public void testSimpleClassToEClass() {
		transformOntologyToEcore("classes_1.owl");
		assertTrue(checkIfEqual("classes_1.ecore"));
	}

	@Test
	public void testSubClassOfToESuperTypes() {
		transformOntologyToEcore("classes_2.owl");
		assertTrue(checkIfEqual("classes_2.ecore"));
	}

	@Test
	public void testMultipleInheritance() {
		transformOntologyToEcore("classes_4.owl");
		assertTrue(checkIfEqual("classes_4.ecore"));
	}

	@Test
	public void testObjectPropertyToEReference() {
		transformOntologyToEcore("ObjectProperty_2.owl");
		assertTrue(checkIfEqual("ObjectProperty_2.ecore"));
	}

	@Test
	public void testInverseObjectProperty() {
		transformOntologyToEcore("ObjectProperty_3.owl");
		assertTrue(checkIfEqual("ObjectProperty_3.ecore"));
	}

	@Test
	public void testDefaultValueObjectProperty() {
		transformOntologyToEcore("ObjectProperty_4.owl");
		assertTrue(checkIfEqual("ObjectProperty_4.ecore"));
	}

	@Test
	public void testDataPropertyToEAttribute() {
		transformOntologyToEcore("DataProperty_1.owl");
		assertTrue(checkIfEqual("DataProperty_1.ecore"));
	}

	@Test
	public void testDatatypeToEDataType() {
		transformOntologyToEcore("Datatype_1.owl");
		assertTrue(checkIfEqual("Datatype_1.ecore"));
	}

	@Test
	public void testComplexExample() {
		transformOntologyToEcore("ComplexExample.owl");
		assertTrue(checkIfEqual("ComplexExample.ecore"));
	}

	@Test
	public void testIndividualToInstance() {
		transformOntologyToEcore("Individuals_2.owl");
		assertTrue(checkIfEqual("Individuals_2.ecore"));
		// TODO check model, not only meta model. This doesn't work because a
		// resource factory for the model need to be registered.
		// assertTrue(checkIfEqual("Individuals_2.xmi"));
	}

	private void transformOntologyToEcore(String fileName) {
		try {
			String absolutPath = getAbsolutPath(ACTUAL_FOLDER_NAME + fileName);
//			fileName = ACTUAL_FOLDER_NAME + fileName;
			OWL2EcoreTransformer transformer = new OWL2EcoreTransformer();
			System.out.println("Transform: " + fileName);
			transformer.runTransformation(absolutPath);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private boolean checkIfEqual(String fileName) {
		ModelComparator modelComparator = new ModelComparator();
		try {
			String expectedFile = getAbsolutPath(EXPECTED_FOLDER_NAME + fileName);
			String actualFile = getAbsolutPath(ACTUAL_FOLDER_NAME + fileName);
			return modelComparator.areModelsEqual(expectedFile, actualFile);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

	protected String getAbsolutPath(String fileName) throws URISyntaxException {
		java.net.URI resolve = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().resolve("..");
		File file = new File(resolve);
		String absolutePath = file.getAbsolutePath() + "/" + fileName;
		return new File(absolutePath).getAbsolutePath();
	}
}
