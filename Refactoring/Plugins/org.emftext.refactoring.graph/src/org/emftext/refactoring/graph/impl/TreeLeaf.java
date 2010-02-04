/**
 * 
 */
package org.emftext.refactoring.graph.impl;

import org.eclipse.emf.ecore.EClass;

/**
 * @author Jan Reimann
 *
 */
public class TreeLeaf extends TreeNode {

	/**
	 * @param eClass
	 */
	public TreeLeaf(EClass eClass) {
		super(eClass);
	}

}
