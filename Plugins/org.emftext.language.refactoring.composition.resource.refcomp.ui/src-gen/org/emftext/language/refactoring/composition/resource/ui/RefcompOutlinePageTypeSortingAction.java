/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import org.eclipse.jface.action.IAction;

public class RefcompOutlinePageTypeSortingAction extends org.emftext.language.refactoring.composition.resource.ui.AbstractRefcompOutlinePageAction {
	
	public RefcompOutlinePageTypeSortingAction(org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
