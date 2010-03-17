package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;

public class CreatePathCreator extends AbstractPathCreator {

	@SuppressWarnings("unchecked")
	@Override
	protected boolean onePairLeftIndexNotNull(Object children,
			Integer index, ReferenceMetaClassPair referencePair, Object feature) {
		if(((List<EObject>) feature).size() <= index){
			return ((List<EObject>) feature).add((EObject) children);
		}
		((List<EObject>) feature).add(index, (EObject) children);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected boolean onePairLeftIndexNull(Object children,
			ReferenceMetaClassPair referencePair, Object feature) {
		return ((List<EObject>) feature).add((EObject) children);
	}

	@Override
	protected void onePairLeftUnaryReference(EObject targetParent,
			Object children,
			ReferenceMetaClassPair referencePair) {
		EReference reference = referencePair.getReference();
		if(reference.getEReferenceType().isSuperTypeOf(((EObject) children).eClass())){
			targetParent.eSet(referencePair.getReference(), children);
		}
	}

	@Override
	protected EObject getTargetObjectForPathCalculation(Object target) {
		return (EObject) target;
	}

}
