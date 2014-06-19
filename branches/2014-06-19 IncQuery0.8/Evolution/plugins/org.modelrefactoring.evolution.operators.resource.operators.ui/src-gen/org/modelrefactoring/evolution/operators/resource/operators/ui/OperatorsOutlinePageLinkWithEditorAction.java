/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.ui;

import org.eclipse.jface.action.IAction;

public class OperatorsOutlinePageLinkWithEditorAction extends org.modelrefactoring.evolution.operators.resource.operators.ui.AbstractOperatorsOutlinePageAction {
	
	public OperatorsOutlinePageLinkWithEditorAction(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
