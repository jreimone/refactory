/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

public class XwpfOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
