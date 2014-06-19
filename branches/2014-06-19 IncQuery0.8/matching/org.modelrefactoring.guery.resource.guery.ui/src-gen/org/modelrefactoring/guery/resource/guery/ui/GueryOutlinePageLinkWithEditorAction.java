/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.ui;

public class GueryOutlinePageLinkWithEditorAction extends org.modelrefactoring.guery.resource.guery.ui.AbstractGueryOutlinePageAction {
	
	public GueryOutlinePageLinkWithEditorAction(org.modelrefactoring.guery.resource.guery.ui.GueryOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
