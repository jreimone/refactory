package org.emftext.refactoring.ltk;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;

public class RefactoringMatchEngine extends GenericMatchEngine {

	@Override
	protected void setModelRoots(MatchModel modelRoot, EObject left, EObject right, EObject ancestor) {
		// Sets values of left, right and ancestor model roots
		setRoots(left, modelRoot.getLeftRoots());
		setRoots(right, modelRoot.getRightRoots());
		setRoots(ancestor, modelRoot.getAncestorRoots());
	}
	
	private void setRoots(EObject model, EList<EObject> rootList){
		if(model != null){
			if(model.eResource() != null){
				rootList.addAll(model.eResource().getContents());
			} else {
				rootList.add(model);
			}
		}
	}
}
