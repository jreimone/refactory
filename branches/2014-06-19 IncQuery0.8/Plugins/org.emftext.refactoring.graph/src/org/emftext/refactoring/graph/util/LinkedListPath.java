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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Jan Reimann
 *
 */
public class LinkedListPath extends LinkedList<TreeNode> implements IPath {

	private static final long serialVersionUID = -6308692673257748635L;

	public LinkedListPath(){
		super(Collections.synchronizedList(new LinkedList<TreeNode>()));
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.graph.util.IPath#removeAbstractEClasses()
	 */
	public boolean removeAbstractEClasses() {
		List<TreeNode> classes = new ArrayList<TreeNode>();
		for (TreeNode eClass : this) {
			if(eClass.getEClass().isAbstract() || eClass.getEClass().isInterface()){
				classes.add(eClass);
			}
		}
		return this.removeAll(classes);
	}
}
