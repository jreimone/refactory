/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IAction;

public class RefcompOutlinePageActionProvider {
	
	public List<IAction> getActions(org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.language.refactoring.composition.resource.ui.RefcompOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
