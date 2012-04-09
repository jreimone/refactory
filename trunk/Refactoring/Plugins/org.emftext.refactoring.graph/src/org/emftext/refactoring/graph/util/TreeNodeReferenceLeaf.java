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
