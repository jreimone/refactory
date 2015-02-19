/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import org.eclipse.jface.action.IAction;

public class RefcompOutlinePageAutoExpandAction extends org.emftext.language.refactoring.composition.resource.ui.AbstractRefcompOutlinePageAction {
	
	public RefcompOutlinePageAutoExpandAction(org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
