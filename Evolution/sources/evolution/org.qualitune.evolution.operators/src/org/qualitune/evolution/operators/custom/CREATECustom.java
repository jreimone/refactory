package org.qualitune.evolution.operators.custom;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.qualitune.evolution.operators.EObjectReference;
import org.qualitune.evolution.operators.OperatorsFactory;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.TypeVariable;
import org.qualitune.evolution.operators.impl.CREATEImpl;
import org.qualitune.evolution.operators.util.OperatorsUtil;


public class CREATECustom extends CREATEImpl {
	
	@Override
	public void execute(){
		TypeVariable variable = getNewInstanceVariable();
		final EClass metaclass = variable.getType();
		EObjectReference result = OperatorsFactory.eINSTANCE.createEObjectReference();
		if(metaclass.isAbstract() || metaclass.isInterface()){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "Metaclass " + metaclass.getName() + " must not be abstract");
			return;
		}
		EObject instance = EcoreUtil.create(metaclass);
		result.getElement().add(instance);
		variable.setValue(instance);
		EReference containmentReference = getParentCompositeReference();
		if(!containmentReference.isContainment()){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "Reference " + containmentReference.getName() + " must be a containment reference");
			return;
		}
		if(!containmentReference.getEReferenceType().isInstance(instance)){
			OperatorsUtil.createDiagnosticAndAddToResource(this, "The type of reference '" + containmentReference.getName() + "' doesn't correspond to the referenced metaclass '" + metaclass.getName() + "'.");
			return;
		}
		Referrable parentReferrable = getParent();
		List<Resource.Diagnostic> errors = new BasicEList<Resource.Diagnostic>();
		EObject parent = OperatorsUtil.getEObjectFromReferrable(parentReferrable, errors);
		if(parent == null){
			for (Resource.Diagnostic error : errors) {
				OperatorsUtil.addErrorToResourceOf(this, error);
			}
			return;
		}
		if(containmentReference.isMany()){
			@SuppressWarnings("unchecked")
			List<EObject> referenceValueList = (List<EObject>) parent.eGet(containmentReference, true);
			referenceValueList.add(instance);
		} else {
			parent.eSet(containmentReference, instance);
		}
		super.execute();
	}
}
