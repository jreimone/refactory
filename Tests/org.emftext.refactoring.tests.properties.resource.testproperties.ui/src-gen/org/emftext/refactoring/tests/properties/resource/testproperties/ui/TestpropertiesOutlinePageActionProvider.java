/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

public class TestpropertiesOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
