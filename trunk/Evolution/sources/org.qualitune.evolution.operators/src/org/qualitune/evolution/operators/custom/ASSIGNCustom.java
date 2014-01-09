package org.qualitune.evolution.operators.custom;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.impl.ASSIGNImpl;
import org.qualitune.evolution.operators.util.OperatorsUtil;


public class ASSIGNCustom extends ASSIGNImpl {

	@Override
	public void execute() {
		Referrable attributeOwner = getAttributeOwner();
		List<Diagnostic> errors = new BasicEList<Diagnostic>();
		EObject owner = OperatorsUtil.getEObjectFromReferrable(attributeOwner, errors);
		if(owner == null){
			OperatorsUtil.addErrorsToResourceOf(this, errors);
			return;
		}
		Object value = getValue();
		EAttribute attribute = getAttribute();
		EClassifier type = attribute.getEType();
		if(type.isInstance(value)){
			owner.eSet(attribute, value);
		} else {
			Diagnostic diagnostic = OperatorsUtil.createDiagnostic(this, "The type '" + type.getName() + "' is not compatible with the value '" + value + "'");
			OperatorsUtil.addErrorToResourceOf(this, diagnostic);
		}
		super.execute();
	}
}
