package org.modelrefactoring.evolution.operators.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.modelrefactoring.evolution.operators.EObjectReference;
import org.modelrefactoring.evolution.operators.OperatorsFactory;
import org.modelrefactoring.evolution.operators.Referrable;
import org.modelrefactoring.evolution.operators.impl.SETImpl;
import org.modelrefactoring.evolution.operators.util.OperatorsUtil;


public class SETCustom extends SETImpl {

	/**
	 * @model
	 */
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
		List<EObject> values = OperatorsUtil.getEObjectsFromReferrable(valueReferrable, errors);
		if(values == null){
			OperatorsUtil.addErrorsToResourceOf(this, errors);
			return;
		}
		EReference reference = getReference();
		if(reference == null){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "The reference mustn't be null");
			return;
		}
		EClass type = reference.getEReferenceType();
		if(type.isInstance(values)){
			owner.eSet(reference, values);
		} else {
			OperatorsUtil.createDiagnosticAndAddToResource(this, "The type '" + type.getName() + "' is not compatible with the value '" + values + "'");
			return;
		}
		EObjectReference result = OperatorsFactory.eINSTANCE.createEObjectReference();
		result.getElements().add(reference);
		setResult(result);
		super.execute();
	}
}



