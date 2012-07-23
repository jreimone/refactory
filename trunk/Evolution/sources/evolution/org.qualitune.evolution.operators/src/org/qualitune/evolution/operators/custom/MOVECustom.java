package org.qualitune.evolution.operators.custom;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.impl.MOVEImpl;
import org.qualitune.evolution.operators.util.OperatorsUtil;


public class MOVECustom extends MOVEImpl {

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		Referrable moveeReferrable = getMovee();
		List<Diagnostic> errors = new BasicEList<Diagnostic>();
		EObject movee = OperatorsUtil.getEObjectFromReferrable(moveeReferrable, errors);
		if(movee == null){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "Object intended to be moved is null");
			return;
		}
		Referrable newParentReferrable = getNewParent();
		EObject newParent = OperatorsUtil.getEObjectFromReferrable(newParentReferrable, errors);
		if(newParent == null){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "Object intended to be moved is null");
			return;
		}
		EReference reference = getParentReference();
		if(!reference.getEReferenceType().isInstance(movee)){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "Types of reference '" + reference.getName() + "' and element '" + movee + "' don't match.");
			return;
		}
		if(reference.isMany()){
			((List<EObject>) newParent.eGet(reference, true)).add(movee);
		} else {
			newParent.eSet(reference, movee);
		}
		super.execute();
	}
}



