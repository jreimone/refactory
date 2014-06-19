/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.ui;

import java.util.List;
import org.eclipse.jface.action.IAction;

public class OperatorsOutlinePageActionProvider {
	
	public List<IAction> getActions(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<IAction> defaultActions = new java.util.ArrayList<IAction>();
		defaultActions.add(new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
