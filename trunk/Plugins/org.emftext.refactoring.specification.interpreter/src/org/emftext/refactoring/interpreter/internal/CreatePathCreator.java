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
	protected IRefactoringStatus onePairLeftUnaryReference(EObject targetParent, Object children, ReferenceMetaClassPair referencePair) {
		try {
			EReference reference = referencePair.getReference();
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

	@Override
	protected EObject getTargetObjectForPathCalculation(Object target) {
		return (EObject) target;
	}

}
