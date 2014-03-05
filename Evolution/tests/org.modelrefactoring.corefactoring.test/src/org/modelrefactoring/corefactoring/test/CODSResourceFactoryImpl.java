package org.modelrefactoring.corefactoring.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.modelrefactoring.evolution.megamodel.cods.CODS;

import static org.junit.Assert.*;

public class CODSResourceFactoryImpl extends XMIResourceFactoryImpl {

	private CODS cods;

	public CODSResourceFactoryImpl(Resource resource) {
		assertNotNull("resource mustn't be null", resource);
		assertTrue("resource mustn't be empty", resource.getContents().size() > 0);
		EObject model = resource.getContents().get(0);
		assertTrue("resource must contain the CODS", model instanceof CODS);
		cods = (CODS) model;
	}

	public CODSResourceFactoryImpl(CODS cods) {
		this.cods = cods;
	}

	@Override
	public Resource createResource(URI uri) {
		return cods.eResource();
	}

}
