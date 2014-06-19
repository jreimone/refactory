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
package org.emftext.refactoring.registry.rolemapping.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.IMenuManager;

public class SubMenuNode {

	private SubMenuNode parent;
	private IMenuManager menu;
	private List<SubMenuNode> children;
	
	public SubMenuNode(SubMenuNode parent, IMenuManager menu){
		this.parent = parent;
		this.menu = menu;
		children = new LinkedList<SubMenuNode>();
		if(parent != null){
			this.parent.addChild(this);
		}
	}

	public SubMenuNode getParent() {
		return parent;
	}

	public IMenuManager getMenu() {
		return menu;
	}

	public List<SubMenuNode> getChildren() {
		return children;
	}
	
	public void addChild(SubMenuNode child){
		children.add(child);
	}
}
