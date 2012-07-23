package org.qualitune.evolution.operators.custom;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.impl.DELETEImpl;
import org.qualitune.evolution.operators.util.OperatorsUtil;


public class DELETECustom extends DELETEImpl {

	@Override
	public void execute() {
		Referrable referrable = getDeletion();
		List<Diagnostic> errors = new BasicEList<Diagnostic>();
		EObject deletion = OperatorsUtil.getEObjectFromReferrable(referrable, errors);
		if(deletion == null){
			for (Diagnostic error : errors) {
				OperatorsUtil.addErrorToResourceOf(this, error);
				return;
			}
		} else {
			EcoreUtil.delete(deletion, true);
		}
		super.execute();
	}
}



