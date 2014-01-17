package org.modelrefactoring.evolution.operators.custom;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelrefactoring.evolution.operators.Referrable;
import org.modelrefactoring.evolution.operators.impl.DELETEImpl;
import org.modelrefactoring.evolution.operators.util.OperatorsUtil;


public class DELETECustom extends DELETEImpl {

	/**
	 * @model
	 */
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



