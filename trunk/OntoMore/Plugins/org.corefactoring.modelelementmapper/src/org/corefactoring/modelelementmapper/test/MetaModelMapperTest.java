package org.corefactoring.modelelementmapper.test;

import static org.junit.Assert.assertEquals;

import org.corefactoring.modelelementmapper.ModelElementInitializer;
import org.corefactoring.modelelementmapper.ModelElementMapperRegistry;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.owl.Class;
import org.emftext.language.owl.OntologyDocument;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ontomore.util.ModelStorageUtil;
import org.ontomore.util.QueryUtil;

public class MetaModelMapperTest {

	private ModelElementMapperRegistry registry;
	private String base = ModelStorageUtil.getBase("org.corefactoring.modelelementmapper");

	@Before
	public void setUp() {
		registry = ModelElementMapperRegistry.INSTANCE;
		ModelElementInitializer.registerModelElementMapper();
	}

	@After
	public void tearDown() {
		registry = null;
	}

	@Test
	public void testSimpleElementMapping() {
		String fileName = base + "testdata/IN_rename.owl";
		OntologyDocument owlModel = (OntologyDocument) ModelStorageUtil
				.loadModelFromFileName(fileName);
		EObject ecoreModel = ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/IN_rename.ecore");
		Class owlInputElement = QueryUtil.queryFirstOwlClass(owlModel);
		EClass ecoreInputElement = (EClass) registry.getCorrespondingElement(owlInputElement,
				ecoreModel);
		assertEquals("Person", ecoreInputElement.getName());
	}

}
