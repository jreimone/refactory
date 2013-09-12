package org.modelrefactoring.guery.test;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

public class EcoreSpecificMotifSolvingTest extends AbstractSpecificMotifSolvingTestFragment {

	private static final String GUERY_FILE			= "queries/ExtractXwithReferenceClass_ecore_MPL2_specific.guery";
	private static final String ROLEMODEL_FILE_NAME	= "rolemodels/ExtractXwithReferenceClass.rolestext";
	private static final int MAX_RESULTS 				= 30000;
	
	@Override
	protected String getGUERYFileName() {
		return GUERY_FILE;
	}

	@Override
	protected String getRoleModelFileName() {
		return ROLEMODEL_FILE_NAME;
	}

	@Override
	protected int getMaxResults() {
		return MAX_RESULTS;
	}

	@Override
	protected EPackage getTargetMetamodel() {
		return EcorePackage.eINSTANCE;
	}

	@Override
	protected void initAdditionalLanguages() { 	}
}
