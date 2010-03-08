/**
 * 
 */
package org.emftext.refactoring.graph.util;

import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;


/**
 * @author Jan Reimann
 *
 */
public abstract class TreeNode{

	private EClass eClass;
	private TreeNode parent;
	private EReference reference;

	public TreeNode(EClass eClass){
		this.eClass = eClass;
	}
	
	/**
	 * @return the parent
	 */
	public TreeNode getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public void addChild(TreeNode child){
		// do nothing default
	}
	
	public boolean removeChild(TreeNode child){
		return false;
	}

	/**
	 * @return the eClass
	 */
	public EClass getEClass() {
		return eClass;
	}
	
	public boolean pathContainsEClass(EClass clazz){
		TreeNode parent = this.getParent();
		while (parent != null) {
			if(parent.getEClass().equals(clazz)){
				return true;
			} else {
				parent = parent.getParent();
			}
		}
		return false;
	}
	
	public IPath getPathFromRoot(){
		IPath path = new LinkedListPath();
		path.add(this);
		TreeNode parent = this.getParent();
		while (parent != null) {
			path.add(parent);
			parent = parent.getParent();
		}
		Collections.reverse(path);
		return path;
	}

	/**
	 * @return the reference
	 */
	public EReference getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(EReference reference) {
		this.reference = reference;
	}
}
