/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

public class TestpropertiesOutlinePageLinkWithEditorAction extends org.emftext.refactoring.tests.properties.resource.testproperties.ui.AbstractTestpropertiesOutlinePageAction {
	
	public TestpropertiesOutlinePageLinkWithEditorAction(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
