package org.modelrefactoring.guery.test;

import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.pl0.PL0Package;

public class PL0SpecificMotifSolvingTest extends AbstractSpecificMotifSolvingTestFragment {

	private static final String GUERY_FILE			= "queries/ExtractXwithReferenceClass_pl0_MPL4_specific.guery";
	private static final String ROLEMODEL_FILE_NAME	= "rolemodels/ExtractXwithReferenceClass.rolestext";
	private static final int MAX_RESULTS 				= 10000;
	
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
		return PL0Package.eINSTANCE;
	}

	@Override
	protected void initAdditionalLanguages() {
		EPackage.Registry.INSTANCE.put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
	}
}
