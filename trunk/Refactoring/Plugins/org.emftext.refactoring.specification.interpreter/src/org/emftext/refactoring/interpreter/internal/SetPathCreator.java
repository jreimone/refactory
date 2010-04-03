package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.RefactoringStatus;

public class SetPathCreator extends AbstractPathCreator {

	@Override
	protected EObject getTargetObjectForPathCalculation(Object target) {
		if(target instanceof EObject){
			return (EObject) target;
		}
		if(target instanceof List<?>){
			return (EObject)((List<?>) target).get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected IRefactoringStatus onePairLeftIndexNotNull(Object children, Integer index, ReferenceMetaClassPair referencePair, Object feature) {
		List<EObject> featureList = (List<EObject>) feature;
		if(children instanceof EObject){
			if(index >= featureList.size()){
				featureList.add((EObject) children);
			} else {
				featureList.add(index, (EObject) children);
			}
		} else {
			List<EObject> objects = (List<EObject>) children;
			if(index >= featureList.size()){
				featureList.addAll(objects);
			} else {
				featureList.addAll(index, objects);
			}
		}
		return new RefactoringStatus(IRefactoringStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected IRefactoringStatus onePairLeftIndexNull(Object children, ReferenceMetaClassPair referencePair, Object feature) {
		List<EObject> featureList = (List<EObject>) feature;
		if(children instanceof EObject){
			featureList.add((EObject) children);
		} else {
			List<EObject> objects = (List<EObject>) children;
			featureList.addAll(objects);
		}
		return new RefactoringStatus(IRefactoringStatus.OK);
	}

	@Override
	protected IRefactoringStatus onePairLeftUnaryReference(EObject targetParent, Object children, ReferenceMetaClassPair referencePair) {
		try {
			EReference reference = referencePair.getReference();
			if(children instanceof List<?>){
				return new RefactoringStatus(IRefactoringStatus.ERROR
						, "The specified elements couldn't be added to " + targetParent + " because the feature only" +
						  " allows single values");
			}
			if(reference.getEReferenceType().isSuperTypeOf(((EObject) children).eClass())){
				targetParent.eSet(referencePair.getReference(), children);
			}
			return new RefactoringStatus(IRefactoringStatus.OK);
		} catch (Exception e) {
			return new RefactoringStatus(IRefactoringStatus.ERROR
					,"Couldn't set " + children + " in " + targetParent
					,e);
		}
	}

}
