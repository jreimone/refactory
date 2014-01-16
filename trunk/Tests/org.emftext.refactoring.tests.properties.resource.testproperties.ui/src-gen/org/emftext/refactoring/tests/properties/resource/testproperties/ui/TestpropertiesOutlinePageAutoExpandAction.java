/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

import org.eclipse.jface.action.IAction;

public class TestpropertiesOutlinePageAutoExpandAction extends org.emftext.refactoring.tests.properties.resource.testproperties.ui.AbstractTestpropertiesOutlinePageAction {
	
	public TestpropertiesOutlinePageAutoExpandAction(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
