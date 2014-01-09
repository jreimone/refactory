package org.qualitune.evolution.operators.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.qualitune.evolution.operators.EObjectReference;
import org.qualitune.evolution.operators.OperatorsFactory;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.impl.SETImpl;
import org.qualitune.evolution.operators.util.OperatorsUtil;


public class SETCustom extends SETImpl {

	@Override
	public void execute() {
		Referrable referenceOwner = getReferenceOwner();
		List<Diagnostic> errors = new ArrayList<Diagnostic>();
		EObject owner = OperatorsUtil.getEObjectFromReferrable(referenceOwner, errors);
		if(owner == null){
			OperatorsUtil.addErrorsToResourceOf(this, errors);
			return;
		}
		Referrable valueReferrable = getValue();
		EObject value = OperatorsUtil.getEObjectFromReferrable(valueReferrable, errors);
		if(value == null){
			OperatorsUtil.addErrorsToResourceOf(this, errors);
			return;
		}
		EReference reference = getReference();
		if(reference == null){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "The reference mustn't be null");
			return;
		}
		EClassifier type = reference.getEReferenceType();
		if(type.isInstance(value)){
			owner.eSet(reference, value);
		} else {
			OperatorsUtil.createDiagnosticAndAddToResource(this, "The type '" + type.getName() + "' is not compatible with the value '" + value + "'");
			return;
		}
		EObjectReference result = OperatorsFactory.eINSTANCE.createEObjectReference();
		result.getElement().add(reference);
		setResult(result);
		super.execute();
	}
}



