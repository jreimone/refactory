/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

public class PropertiesOutlinePageLinkWithEditorAction extends org.emftext.refactoring.tests.properties.resource.properties.ui.AbstractPropertiesOutlinePageAction {
	
	public PropertiesOutlinePageLinkWithEditorAction(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
