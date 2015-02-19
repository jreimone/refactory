/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import org.eclipse.jface.action.IAction;

public class RefcompOutlinePageCollapseAllAction extends org.emftext.language.refactoring.composition.resource.ui.AbstractRefcompOutlinePageAction {
	
	public RefcompOutlinePageCollapseAllAction(org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", IAction.AS_PUSH_BUTTON);
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
