/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.ui;

public class GueryOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.modelrefactoring.guery.resource.guery.ui.GueryOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.modelrefactoring.guery.resource.guery.ui.GueryOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.guery.resource.guery.ui.GueryOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.guery.resource.guery.ui.GueryOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.guery.resource.guery.ui.GueryOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.guery.resource.guery.ui.GueryOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.modelrefactoring.guery.resource.guery.ui.GueryOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
