/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

import org.eclipse.jface.action.IAction;

public class TestpropertiesOutlinePageLexicalSortingAction extends org.emftext.refactoring.tests.properties.resource.testproperties.ui.AbstractTestpropertiesOutlinePageAction {
	
	public TestpropertiesOutlinePageLexicalSortingAction(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
