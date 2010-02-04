/**
 * 
 */
package org.emftext.refactoring.graph.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

/**
 * @author Jan Reimann
 *
 */
public class TreeParent extends TreeNode {

	private List<TreeNode> children;
	
	/**
	 * @param eClass
	 */
	public TreeParent(EClass eClass) {
		super(eClass);
		children = new ArrayList<TreeNode>();
	}

	public void addChild(TreeNode child){
		children.add(child);
		child.setParent(this);
	}
	
	public boolean removeChild(TreeNode child){
		return children.remove(child);
	}
}
