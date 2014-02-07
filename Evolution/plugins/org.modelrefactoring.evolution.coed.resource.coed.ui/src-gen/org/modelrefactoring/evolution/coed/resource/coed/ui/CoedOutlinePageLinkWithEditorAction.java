/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import org.eclipse.jface.action.IAction;

public class CoedOutlinePageLinkWithEditorAction extends org.modelrefactoring.evolution.coed.resource.coed.ui.AbstractCoedOutlinePageAction {
	
	public CoedOutlinePageLinkWithEditorAction(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
