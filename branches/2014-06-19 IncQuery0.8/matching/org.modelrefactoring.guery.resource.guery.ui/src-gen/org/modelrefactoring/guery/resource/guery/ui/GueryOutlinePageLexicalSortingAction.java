/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.ui;

public class GueryOutlinePageLexicalSortingAction extends org.modelrefactoring.guery.resource.guery.ui.AbstractGueryOutlinePageAction {
	
	public GueryOutlinePageLexicalSortingAction(org.modelrefactoring.guery.resource.guery.ui.GueryOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
