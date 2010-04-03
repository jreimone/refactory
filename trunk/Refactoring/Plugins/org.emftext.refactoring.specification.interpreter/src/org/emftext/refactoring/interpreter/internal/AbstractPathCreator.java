/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RolemappingFactory;
import org.emftext.refactoring.graph.IShortestPathAlgorithm;
import org.emftext.refactoring.graph.util.IPath;
import org.emftext.refactoring.graph.util.PathAlgorithmFactory;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.RefactoringStatus;
import org.emftext.refactoring.util.ModelUtil;

/**
 * @author Jan Reimann
 *
 */
public abstract class AbstractPathCreator {

	public IRefactoringStatus createPath(EObject parent, List<ReferenceMetaClassPair> remainingReferences, EObject child){
		return createPath(parent, remainingReferences, child, null);
	}

	abstract protected IRefactoringStatus onePairLeftUnaryReference(EObject targetParent, Object children, ReferenceMetaClassPair referencePair);

	abstract protected IRefactoringStatus onePairLeftIndexNotNull(Object children, Integer index, ReferenceMetaClassPair referencePair, Object feature);

	abstract protected IRefactoringStatus onePairLeftIndexNull(Object children, ReferenceMetaClassPair referencePair, Object feature);

	abstract protected EObject getTargetObjectForPathCalculation(Object target);

	@SuppressWarnings("unchecked")
	public IRefactoringStatus createPath(EObject parent, List<ReferenceMetaClassPair> remainingReferences, Object child, Integer index){
		if(remainingReferences == null){
			IShortestPathAlgorithm algo = (new PathAlgorithmFactory()).getAlgorithm();
			EObject target = getTargetObjectForPathCalculation(child);
			List<IPath> paths = algo.calculatePaths(parent, target);
			if(paths != null && paths.size() > 0){
				IPath path = paths.get(0);
				path.removeAbstractEClasses();
				List<ReferenceMetaClassPair> references = new LinkedList<ReferenceMetaClassPair>();
				for (int i = 1; i < path.size(); i++) {
					ReferenceMetaClassPair referencePair = RolemappingFactory.eINSTANCE.createReferenceMetaClassPair();
					referencePair.setMetaClass(path.get(i).getEClass());
					referencePair.setReference(path.get(i).getReference());
					references.add(referencePair);
				}
				return createPath(parent, references, child,index);
			} else {
				String message = "Couldn't find a shortest path between " + child + " and " + parent;
				IRefactoringStatus status = new RefactoringStatus(IRefactoringStatus.ERROR, message);
				return status;
			}
		} else if(remainingReferences.size() == 1){
			ReferenceMetaClassPair referencePair = remainingReferences.get(0);
			try{
				if(referencePair.getReference().isMany()){
					Object feature = parent.eGet(referencePair.getReference());
					if(index == null){
						return onePairLeftIndexNull(child, referencePair, feature);
					} else {
						return onePairLeftIndexNotNull(child, index, referencePair, feature);
					}
				} else {
					if(child != null && referencePair.getReference() != null){
						return onePairLeftUnaryReference(parent, child, referencePair);
					}
					return new RefactoringStatus(IRefactoringStatus.ERROR);
				}
			} catch (Exception e) {
				String message = "Couldn't set feature " + child + " for " + parent;
				IRefactoringStatus status = new RefactoringStatus(IRefactoringStatus.ERROR, message, e);
				return status;
			}
		} else {
			// must work on a copy because otherwise all operations to the list will be reflected in the model
			List<ReferenceMetaClassPair> tempRemainingList = new LinkedList<ReferenceMetaClassPair>();
			for (ReferenceMetaClassPair referenceMetaClassPair : remainingReferences) {
				tempRemainingList.add(referenceMetaClassPair);
			}

			ReferenceMetaClassPair referencePair = tempRemainingList.get(0);
			tempRemainingList.remove(referencePair);
			Object feature = parent.eGet(referencePair.getReference());
			EClass featureClass = referencePair.getMetaClass();
			if(featureClass == null){
				featureClass = referencePair.getReference().getEReferenceType();
			}
			if(featureClass.isAbstract()){
				// TODO ask user or use MissingInformationProvider
				return new RefactoringStatus(IRefactoringStatus.WARNING, "THIS CASE MUST BE IMPLEMENTED!");
			}
			//			EObject featureObject = ModelUtil.create(featureClass);
			EObject featureObject = null;
			if(feature != null && !referencePair.getReference().isMany()){
				featureObject = (EObject) feature;
			} else {
				featureObject = ModelUtil.create(featureClass);
				if(referencePair.getReference().isMany()){
					if(index == null){
						((List<EObject>) feature).add(featureObject);
					} else {
						if(((List<EObject>) feature).size() <= index){
							((List<EObject>) feature).add(featureObject);
						}
						if(!((List<EObject>) feature).contains(featureObject)){
							((List<EObject>) feature).add(index, featureObject);
						}
					}
				} else {
					parent.eSet(referencePair.getReference(), featureObject);
				}
			}
			//			((List<EObject>) feature).add(featureObject);
			//			EObject featureObject = null;
			return createPath(featureObject, tempRemainingList, child, index);
		}
	}
}
