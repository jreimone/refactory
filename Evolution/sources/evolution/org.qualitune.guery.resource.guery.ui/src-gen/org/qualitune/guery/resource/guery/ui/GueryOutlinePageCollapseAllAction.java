/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.ui;

public class GueryOutlinePageCollapseAllAction extends org.qualitune.guery.resource.guery.ui.AbstractGueryOutlinePageAction {
	
	public GueryOutlinePageCollapseAllAction(org.qualitune.guery.resource.guery.ui.GueryOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
