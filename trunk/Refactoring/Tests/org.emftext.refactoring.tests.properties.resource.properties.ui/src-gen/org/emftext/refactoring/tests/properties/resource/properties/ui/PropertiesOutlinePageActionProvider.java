/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

public class PropertiesOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
