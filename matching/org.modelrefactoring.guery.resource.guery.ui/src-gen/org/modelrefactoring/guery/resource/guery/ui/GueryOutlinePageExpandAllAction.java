/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.ui;

public class GueryOutlinePageExpandAllAction extends org.modelrefactoring.guery.resource.guery.ui.AbstractGueryOutlinePageAction {
	
	public GueryOutlinePageExpandAllAction(org.modelrefactoring.guery.resource.guery.ui.GueryOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
