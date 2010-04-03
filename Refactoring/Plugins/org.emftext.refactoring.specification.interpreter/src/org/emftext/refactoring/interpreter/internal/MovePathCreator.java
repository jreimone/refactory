package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.RefactoringStatus;

public class MovePathCreator extends AbstractPathCreator {

	@SuppressWarnings("unchecked")
	protected IRefactoringStatus onePairLeftUnaryReference(EObject targetParent, Object children, ReferenceMetaClassPair referencePair) {
		try {
			EReference reference = referencePair.getReference();
			if(reference.getEReferenceType().isSuperTypeOf(((List<? extends EObject>) children).get(0).eClass())){
				targetParent.eSet(referencePair.getReference(), ((List<? extends EObject>) children).get(0));
			}
			return new RefactoringStatus(IRefactoringStatus.OK);
		} catch (Exception e) {
			return new RefactoringStatus(IRefactoringStatus.ERROR
					,"Couldn't set " + children + " in " + targetParent
					,e);
		}
	}

	@SuppressWarnings("unchecked")
	protected IRefactoringStatus onePairLeftIndexNotNull(Object children, Integer index, ReferenceMetaClassPair referencePair, Object feature) {
		for (EObject child : (List<? extends EObject>)children) {
			EObject oldParent = child.eContainer();
			EcoreUtil.remove(oldParent, referencePair.getReference(), child);
		}
		if(((List<EObject>) feature).size() <= index){
			boolean result = ((List<EObject>) feature).addAll((List<? extends EObject>) children);
			return new RefactoringStatus(IRefactoringStatus.OK);
		}
		((List<EObject>) feature).addAll(index, (List<? extends EObject>) children);
		return new RefactoringStatus(IRefactoringStatus.OK);
	}

	@SuppressWarnings("unchecked")
	protected IRefactoringStatus onePairLeftIndexNull(Object children, ReferenceMetaClassPair referencePair, Object feature) {
		for (EObject child : (List<? extends EObject>) children) {
			EObject oldParent = child.eContainer();
			EcoreUtil.remove(oldParent, referencePair.getReference(), child);
		}
		boolean result = ((List<EObject>) feature).addAll((List<? extends EObject>) children);
		return new RefactoringStatus(IRefactoringStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected EObject getTargetObjectForPathCalculation(Object target) {
		return ((List<? extends EObject>) target).get(0);
	}
}
