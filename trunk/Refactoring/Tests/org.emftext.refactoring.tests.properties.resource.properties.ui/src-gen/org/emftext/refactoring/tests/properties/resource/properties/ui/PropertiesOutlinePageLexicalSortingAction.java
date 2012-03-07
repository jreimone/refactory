/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

public class PropertiesOutlinePageLexicalSortingAction extends org.emftext.refactoring.tests.properties.resource.properties.ui.AbstractPropertiesOutlinePageAction {
	
	public PropertiesOutlinePageLexicalSortingAction(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
