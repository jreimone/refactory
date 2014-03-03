package org.corefactoring.modelregistry.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.corefactoring.modelregistry.ModelRegistry;
import org.corefactoring.modelregistry.ModelRegistryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ontomore.util.ModelComparator;
import org.ontomore.util.ModelStorageUtil;

public class ModelRegistryTest {

	private ModelRegistry modelRegistry;
	private String base = ModelStorageUtil.getBase("org.corefactoring.modelregistry");

	@Before
	public void setUp() {
		modelRegistry = ModelRegistryImpl.getInstance();
	}
	
	@After
	public void tearDown() {
		modelRegistry = null;
	}
	
	@Test
	public void testAddEntryAndGetCorrespondingModel() {
		EObject leftModel = ModelStorageUtil.loadModelFromFileName(base + "testdata/ecore_2.ecore");
		EObject rightModel = ModelStorageUtil.loadModelFromFileName(base + "testdata/owl_2.owl");
		modelRegistry.addEntry(leftModel, rightModel);
		
		EObject rightModelFromRegistry = modelRegistry.getCorrespondingModels(leftModel).get(0);
		EObject leftModelFromRegistry = modelRegistry.getCorrespondingModels(rightModel).get(0);
		
		assertTrue(new ModelComparator().areModelsEqual(rightModel, rightModelFromRegistry));
		assertTrue(new ModelComparator().areModelsEqual(leftModel, leftModelFromRegistry));
	}
	
	@Test
	public void testNoCorrespondingEntry() {
		modelRegistry.clearRegistry();
		EObject leftModel = ModelStorageUtil.loadModelFromFileName(base + "testdata/ecore_2.ecore");
		try {
			modelRegistry.getCorrespondingModels(leftModel);
			fail();
		} catch (RuntimeException e) {
			assertTrue(e.getMessage().contains("not associated with another model"));
		}
	}
	
	@Test
	public void testGetCorrespondentToBadModel() {
		EObject inMemoryModel = EcoreFactory.eINSTANCE.createEClass();
		try {
			modelRegistry.getCorrespondingModels(inMemoryModel);
			fail();
		} catch (RuntimeException e) {
			assertTrue(e.getMessage().contains("Given model is not stored in a file"));
		}
	}
	
	@Test
	public void testAddBadEntry() {
		EObject inMemoryModelLeft = EcoreFactory.eINSTANCE.createEClass();
		EObject inMemoryModelRight = EcoreFactory.eINSTANCE.createEPackage();
		try {
			modelRegistry.addEntry(inMemoryModelLeft, inMemoryModelRight);
			fail();
		} catch (RuntimeException e) {
			assertTrue(e.getMessage().contains("Given model is not stored in a file"));
		}
	}
	
}
