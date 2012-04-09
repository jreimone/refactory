/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.ltk;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;

public class RefactoringMatchEngine extends GenericMatchEngine {

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
