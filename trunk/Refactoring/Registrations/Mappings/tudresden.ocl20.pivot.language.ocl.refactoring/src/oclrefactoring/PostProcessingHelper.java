/**
 * 
 */
package oclrefactoring;

import java.util.List;

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
