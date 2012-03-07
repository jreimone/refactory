/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

public class PropertiesOutlinePageTypeSortingAction extends org.emftext.refactoring.tests.properties.resource.properties.ui.AbstractPropertiesOutlinePageAction {
	
	public PropertiesOutlinePageTypeSortingAction(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
