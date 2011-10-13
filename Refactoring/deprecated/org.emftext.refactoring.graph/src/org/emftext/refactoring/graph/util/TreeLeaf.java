/**
 * 
 */
package org.emftext.refactoring.graph.util;

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
