package org.ontomore.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.ontomore.util.ModelComparator;
import org.ontomore.util.ModelStorageUtil;

public class EcoreModelComparatorTest {


	private String base = ModelStorageUtil.getBase("org.ontomore.test");
	
	@Test
	public void testEmptyModelsAreEqual() {
		assertTrue(checkIfEqual("empty_1.ecore", "empty_2.ecore"));
	}
	
	@Test
	public void testEqualModelsAreEqual() {
		assertTrue(checkIfEqual("equal_1.ecore", "equal_2.ecore"));
	}
	
	@Test
	public void testDifferentModelsAreDifferent() {
		assertFalse(checkIfEqual("different_1.ecore","different_2.ecore"));
	}

	private boolean checkIfEqual(String fileName1, String fileName2) {
		ModelComparator modelComparator = new ModelComparator();
		return modelComparator.areModelsEqual(
				base + "EcoreModelComperatorTest/" + fileName1,
				base + "EcoreModelComperatorTest/" + fileName2);
	}
}
