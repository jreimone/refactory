package org.modelrefactoring.guery.test;

import nz.ac.massey.cs.guery.ResultListener;

import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.pl0.PL0Package;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;

public class PL0OrientPersistingTest1 extends AbstractSpecificMotifSolvingTestFragment {

	private static final String GUERY_FILE				= "queries/ExtractXwithReferenceClass_pl0_MPL4_specific.guery";
	private static final String ROLEMODEL_FILE_NAME		= "rolemodels/ExtractXwithReferenceClass.rolestext";
	private static final int MAX_RESULTS 					= 10000;
	
	private AdditionalResultListener orientListener;
	private CountAndPrintResultListener2 resultListener;
	
	@Override
	protected ResultListener<MetamodelVertex, EReferenceEdge> getResultListener(int queryCycleCount) {
		System.out.println("PL0OrientPersistingTest1.getResultListener()");
		if(resultListener == null){
			resultListener = new CountAndPrintResultListener2(getRoleModel(), getMaxResults(), queryCycleCount);
			orientListener = new OrientPersistResultListener(getTargetMetamodel());
			resultListener.addListener(orientListener);
		}
		return resultListener;
	}
	
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
