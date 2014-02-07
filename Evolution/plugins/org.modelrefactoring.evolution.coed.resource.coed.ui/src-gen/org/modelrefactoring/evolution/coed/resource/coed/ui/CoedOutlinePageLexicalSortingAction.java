/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import org.eclipse.jface.action.IAction;

public class CoedOutlinePageLexicalSortingAction extends org.modelrefactoring.evolution.coed.resource.coed.ui.AbstractCoedOutlinePageAction {
	
	public CoedOutlinePageLexicalSortingAction(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
