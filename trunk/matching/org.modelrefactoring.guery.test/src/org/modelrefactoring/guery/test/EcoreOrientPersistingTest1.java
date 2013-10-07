package org.modelrefactoring.guery.test;

import nz.ac.massey.cs.guery.ResultListener;

import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;

public class EcoreOrientPersistingTest1 extends EcoreSpecificMotifSolvingTest {

	private static final String GUERY_FILE			= "queries/ExtractXwithReferenceClass_ecore_MPL2_specific.guery";
	
	private AdditionalResultListener orientListener;
	private AdditionalListenerInvocator resultListener;
	
	@SuppressWarnings("unchecked")
	@Override
	protected ResultListener<MetamodelVertex, EReferenceEdge> getResultListener(int queryCycleCount) {
		if(resultListener == null){
			resultListener = new CountAndPrintResultListener2(getRoleModel(), getMaxResults(), queryCycleCount);
			orientListener = new OrientPersistResultListener(getTargetMetamodel());
			resultListener.addListener(orientListener);
		}
		return (ResultListener<MetamodelVertex, EReferenceEdge>) resultListener;
	}

	@Override
	protected String getGUERYFileName() {
		return GUERY_FILE;
	}
}