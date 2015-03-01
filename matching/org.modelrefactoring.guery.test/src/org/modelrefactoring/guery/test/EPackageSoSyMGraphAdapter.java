package org.modelrefactoring.guery.test;

import org.eclipse.emf.ecore.EPackage;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;

public class EPackageSoSyMGraphAdapter extends EPackageGraphAdapter {

	public EPackageSoSyMGraphAdapter(EPackage metamodel) {
		super(metamodel);
	}

	@Override
	public boolean useOnlySuperClasses() {
		return true;
	}
}
