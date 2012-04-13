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
/**
 * 
 */
package oclrefactoring;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.PrePostOrBodyDeclarationCS;

/**
 * @author Michael Muck
 *
 */
public class PostProcessingHelper {
	
	public EObject getConstraintRoot(EObject source) {
		EObject constraintRoot = source.eContainer();
		while (	!(constraintRoot instanceof InvariantExpCS) && 
				!(constraintRoot instanceof PrePostOrBodyDeclarationCS)) 
		{
			constraintRoot = constraintRoot.eContainer();
		}
		System.out.println("found constraint-root as: "+constraintRoot.toString());
		return constraintRoot;
	}
	
	public void removeObjectFromParent(EObject removee) {
		EObject parent = removee.eContainer();
		//System.out.println("parent to remove item from: "+parent);
		//System.out.println("removees containing feature: "+parent.eGet(removee.eContainingFeature()));
		
		if (parent.eGet(removee.eContainingFeature()) instanceof EList) {
			System.out.println("removing object from elist ");
			((EList<?>)parent.eGet(removee.eContainingFeature())).remove(removee);
		} else {
			System.out.println("removing object from eobject");
			parent.eUnset(removee.eContainingFeature());
		}
	}
	
	//checking if an parent container is now empty an can be removed
	//should be called after removing objects from a tree
	public void cleanEmptyParentContainer(EObject parent) {
		
	}

}
