/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import java.util.List;
import org.eclipse.jface.action.IAction;

public class CoedOutlinePageActionProvider {
	
	public List<IAction> getActions(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<IAction> defaultActions = new java.util.ArrayList<IAction>();
		defaultActions.add(new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
