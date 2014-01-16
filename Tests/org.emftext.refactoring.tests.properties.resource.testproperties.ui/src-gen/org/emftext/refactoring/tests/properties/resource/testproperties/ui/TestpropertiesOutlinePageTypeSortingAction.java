/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

import org.eclipse.jface.action.IAction;

public class TestpropertiesOutlinePageTypeSortingAction extends org.emftext.refactoring.tests.properties.resource.testproperties.ui.AbstractTestpropertiesOutlinePageAction {
	
	public TestpropertiesOutlinePageTypeSortingAction(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
