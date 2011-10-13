/**
 * 
 */
package org.emftext.refactoring.graph.util;

import org.eclipse.emf.ecore.EClass;

/**
 * @author Jan Reimann
 *
 */
public class TreeNodeReferenceLeaf extends TreeLeaf {

	private TreeNode referencedNode;
	
	/**
	 * @param eClass
	 */
	public TreeNodeReferenceLeaf(EClass eClass, TreeNode referencedNode) {
		super(eClass);
		this.referencedNode = referencedNode;
	}

	/**
	 * @return the referencedNode
	 */
	public TreeNode getReferencedNode() {
		return referencedNode;
	}

}
