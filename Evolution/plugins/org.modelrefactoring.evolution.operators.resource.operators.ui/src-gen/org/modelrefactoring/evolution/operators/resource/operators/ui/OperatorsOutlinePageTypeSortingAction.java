/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.ui;

import org.eclipse.jface.action.IAction;

public class OperatorsOutlinePageTypeSortingAction extends org.modelrefactoring.evolution.operators.resource.operators.ui.AbstractOperatorsOutlinePageAction {
	
	public OperatorsOutlinePageTypeSortingAction(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
