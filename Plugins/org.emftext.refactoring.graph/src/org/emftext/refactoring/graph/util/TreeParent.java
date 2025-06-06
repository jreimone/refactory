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
