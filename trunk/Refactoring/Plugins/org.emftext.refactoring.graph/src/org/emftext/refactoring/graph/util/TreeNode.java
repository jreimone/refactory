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
	public void setReferenceFromParent(EReference reference) {
		this.reference = reference;
	}

	@Override
	public boolean equals(Object obj) {
		return eClass.equals(((TreeNode) obj).getEClass());
	}
}
