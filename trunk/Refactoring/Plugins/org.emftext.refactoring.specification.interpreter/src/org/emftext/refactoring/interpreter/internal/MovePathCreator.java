package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;

public class MovePathCreator extends AbstractPathCreator {

	@SuppressWarnings("unchecked")
	protected void onePairLeftUnaryReference(EObject targetParent,
			Object children,
			ReferenceMetaClassPair referencePair) {
		EReference reference = referencePair.getReference();
		if(reference.getEReferenceType().isSuperTypeOf(((List<? extends EObject>) children).get(0).eClass())){
			targetParent.eSet(referencePair.getReference(), ((List<? extends EObject>) children).get(0));
		}
	}

	@SuppressWarnings("unchecked")
	protected boolean onePairLeftIndexNotNull(Object children,
			Integer index, ReferenceMetaClassPair referencePair, Object feature) {
		for (EObject child : (List<? extends EObject>)children) {
			EObject oldParent = child.eContainer();
			EcoreUtil.remove(oldParent, referencePair.getReference(), child);
		}
		if(((List<EObject>) feature).size() <= index){
			return ((List<EObject>) feature).addAll((List<? extends EObject>) children);
		}
		((List<EObject>) feature).addAll(index, (List<? extends EObject>) children);
		return true;
	}

	@SuppressWarnings("unchecked")
	protected boolean onePairLeftIndexNull(Object children, ReferenceMetaClassPair referencePair, Object feature) {
		for (EObject child : (List<? extends EObject>) children) {
			EObject oldParent = child.eContainer();
			EcoreUtil.remove(oldParent, referencePair.getReference(), child);
		}
		return ((List<EObject>) feature).addAll((List<? extends EObject>) children);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected EObject getTargetObjectForPathCalculation(Object target) {
		return ((List<? extends EObject>) target).get(0);
	}
}
