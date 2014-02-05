/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.ui;

import org.eclipse.jface.action.IAction;

public class OperatorsOutlinePageExpandAllAction extends org.modelrefactoring.evolution.operators.resource.operators.ui.AbstractOperatorsOutlinePageAction {
	
	public OperatorsOutlinePageExpandAllAction(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageTreeViewer treeViewer) {
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
