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
