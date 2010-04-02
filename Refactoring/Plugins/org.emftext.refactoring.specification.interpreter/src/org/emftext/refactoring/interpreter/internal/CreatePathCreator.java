package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.RefactoringStatus;

public class CreatePathCreator extends AbstractPathCreator {

	@SuppressWarnings("unchecked")
	@Override
	protected IRefactoringStatus onePairLeftIndexNotNull(Object children, Integer index, ReferenceMetaClassPair referencePair, Object feature) {
		if(((List<EObject>) feature).size() <= index){
			boolean result = ((List<EObject>) feature).add((EObject) children);
			return new RefactoringStatus(IRefactoringStatus.OK);
		}
		((List<EObject>) feature).add(index, (EObject) children);
		return new RefactoringStatus(IRefactoringStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected IRefactoringStatus onePairLeftIndexNull(Object children, ReferenceMetaClassPair referencePair, Object feature) {
		((List<EObject>) feature).add((EObject) children);
		return new RefactoringStatus(IRefactoringStatus.OK);
	}

	@Override
	protected void onePairLeftUnaryReference(EObject targetParent, Object children, ReferenceMetaClassPair referencePair) {
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
