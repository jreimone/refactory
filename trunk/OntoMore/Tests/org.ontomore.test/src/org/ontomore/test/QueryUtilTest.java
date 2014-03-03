package org.ontomore.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.junit.Test;
import org.ontomore.util.ModelStorageUtil;
import org.ontomore.util.QueryUtil;

public class QueryUtilTest {


	private String base = ModelStorageUtil.getBase("org.ontomore.test");
	
	@Test
	public void testGetInputElements() {
		EPackage model = (EPackage) ModelStorageUtil.loadModelFromFileName(base
				+ "testdata/IN_rename.ecore");
		EClass firstInputElement = QueryUtil.queryFirstEClass(model);

		String nameOfFirstElement = "Person";
		assertEquals(nameOfFirstElement, firstInputElement.getName());

		EObject actualElementFromModel = getFirstEClass(model);
		assertEquals(actualElementFromModel, firstInputElement);
	}

	private EClass getFirstEClass(EObject model) {
		EPackage ePackage = (EPackage) model;
		return (EClass) ePackage.getEClassifiers().get(0);
	}

}
