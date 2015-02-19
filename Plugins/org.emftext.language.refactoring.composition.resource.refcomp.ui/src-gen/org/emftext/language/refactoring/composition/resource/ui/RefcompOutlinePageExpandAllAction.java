/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import org.eclipse.jface.action.IAction;

public class RefcompOutlinePageExpandAllAction extends org.emftext.language.refactoring.composition.resource.ui.AbstractRefcompOutlinePageAction {
	
	public RefcompOutlinePageExpandAllAction(org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", IAction.AS_PUSH_BUTTON);
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
