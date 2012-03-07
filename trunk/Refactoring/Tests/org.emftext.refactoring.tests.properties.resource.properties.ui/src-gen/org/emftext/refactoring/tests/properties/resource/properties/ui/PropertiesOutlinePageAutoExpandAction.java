/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

public class PropertiesOutlinePageAutoExpandAction extends org.emftext.refactoring.tests.properties.resource.properties.ui.AbstractPropertiesOutlinePageAction {
	
	public PropertiesOutlinePageAutoExpandAction(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
