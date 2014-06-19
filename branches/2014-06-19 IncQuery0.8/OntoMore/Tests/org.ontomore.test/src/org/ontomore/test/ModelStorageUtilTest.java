package org.ontomore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.owl.OntologyDocument;
import org.emftext.language.refactoring.roles.RoleModel;
import org.junit.Test;
import org.ontomore.util.ModelComparator;
import org.ontomore.util.ModelStorageUtil;

import static org.ontomore.util.CoRefactoryConstants.*;

public class ModelStorageUtilTest {

	private static final String workspaceDirectory = ModelStorageUtil.WORKSPACE_DIRECTORY;

	private String base = ModelStorageUtil.getBase("org.ontomore.test");

	@Test
	public void testFilePath() {
		URI fileURI = URI.createFileURI(base + "testdata/simpleModel.ecore");

		File file = new File(fileURI.toFileString());

		assertTrue(file.exists());
	}

	@Test
	public void testAbsoluteFilePath() {
		URI fileURI = URI.createFileURI(workspaceDirectory + "TestProject/simpleModel.ecore");

		File file = new File(fileURI.toFileString());

		assertTrue(file.exists());
	}

	@Test
	public void testLoadEcoreModel() {
		EPackage ecoreModel = (EPackage) ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/EcoreModel.ecore");
		assertEquals("classes", ecoreModel.getName());
	}

	@Test
	public void testLoadOWLModel() {
		OntologyDocument owlModel = (OntologyDocument) ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/OWLModel.owl");
		assertEquals("http://www.ontomore.org/test/transformation/classes.owl", owlModel
				.getOntology().getUri());
	}

	@Test
	public void testLoadEcoreModelTwice() {
		EPackage ecoreModel1 = (EPackage) ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/EcoreModel.ecore");
		assertEquals("classes", ecoreModel1.getName());
		EPackage ecoreModel2 = (EPackage) ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/EcoreModel.ecore");
		assertEquals("classes", ecoreModel2.getName());
	}

	@Test
	public void testGetRoleModelFromFile() {
		String roleModelFileName = ModelStorageUtil.WORKSPACE_DIRECTORY
				+ "org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext";
		Object expectedRoleModelName = "RenameX";
		EObject eObject = ModelStorageUtil.loadModelFromFileName(roleModelFileName);

		RoleModel roleModel = (RoleModel) eObject;
		String actualRoleModelName = roleModel.getName();

		assertEquals(expectedRoleModelName, actualRoleModelName);
	}
	
	@Test
	public void testGetResourceFromModel() {
		EObject model = ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/EcoreModel.ecore");
		Resource resource = model.eResource();
		String absoluteResourceFileName = resource.getURI().toFileString();
		assertTrue(absoluteResourceFileName.contains("EcoreModel.ecore"));
	}

	@Test
	public void testSaveEcoreModel() {
		EPackage ecoreModel = (EPackage) ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/EcoreModelToSave.ecore");
		ModelStorageUtil.saveModelInResource(ecoreModel, base + "testdata/savedEcoreModel.ecore");
		EPackage savedEcoreModel = (EPackage) ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/savedEcoreModel.ecore");
		assertTrue(new ModelComparator().areModelsEqual(ecoreModel, savedEcoreModel));
	}

	@Test
	public void testSaveOWLModel() {
		OntologyDocument owlModel = (OntologyDocument) ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/OWLModelToSave.owl");
		ModelStorageUtil.saveModelInResource(owlModel, base + "testdata/savedOWLModel.owl");
		OntologyDocument savedOwlModel = (OntologyDocument) ModelStorageUtil
				.loadModelFromFileName(base + "testdata/savedOWLModel.owl");
		assertTrue(new ModelComparator().areModelsEqual(owlModel, savedOwlModel));
	}

	@Test
	public void testGetMetaModelEcore() {
		EPackage ecoreModel = (EPackage) ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/EcoreModel.ecore");
		String expectedMetaModel = ECORE_METAMODEL;

		String metaModel = ModelStorageUtil.getMetaModelAsString(ecoreModel);
		assertEquals(expectedMetaModel, metaModel);
	}

	@Test
	public void testGetMetaModelOWL() {
		OntologyDocument owlModel = (OntologyDocument) ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/OWLModel.owl");
		String expectedMetaModel = OWL_METAMODEL;

		String metaModel = ModelStorageUtil.getMetaModelAsString(owlModel);
		assertEquals(expectedMetaModel, metaModel);
	}

	@Test
	public void testGetWorkspaceDirectory() {
		String absolutFileString = getAbsolutFileString("..") + "/";
		String workspaceDirectory = ModelStorageUtil.WORKSPACE_DIRECTORY;
		assertEquals(absolutFileString, workspaceDirectory);
	}

	@Test
	public void testGetBase() {
		try {
			java.net.URI resolve = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().resolve("..");
			File file = new File(resolve);
			String absolutePath = file.getAbsolutePath();
			String filePath = getAbsolutFileString(absolutePath) + "/";
			String basePath = ModelStorageUtil.getBase("org.ontomore.test");
			assertEquals(filePath, basePath);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	private String getAbsolutFileString(String path) {
		File file = new File(path);
		assertTrue("file " + file.getPath() + " doesn't exist", file.exists());
		String filePath = null;
		try {
			filePath = file.getAbsoluteFile().getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
}
