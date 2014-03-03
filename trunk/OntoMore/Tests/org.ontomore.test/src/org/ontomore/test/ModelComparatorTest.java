package org.ontomore.test;

import static org.junit.Assert.assertFalse;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.ontomore.util.ModelComparator;
import org.ontomore.util.ModelStorageUtil;

public class ModelComparatorTest {


	private String base = ModelStorageUtil.getBase("org.ontomore.test");
	
	@Test
	public void testCompareModelsWithDifferentMetaModels() {
		EObject ecoreModel = ModelStorageUtil
				.loadModelFromFileName(base + "EcoreModelComperatorTest/equal_1.ecore");
		EObject owlModel = ModelStorageUtil
				.loadModelFromFileName(base + "OWLModelComparatorTest/simpleOntology_1.owl");

		assertFalse(new ModelComparator().areModelsEqual(ecoreModel, owlModel));
	}

}
