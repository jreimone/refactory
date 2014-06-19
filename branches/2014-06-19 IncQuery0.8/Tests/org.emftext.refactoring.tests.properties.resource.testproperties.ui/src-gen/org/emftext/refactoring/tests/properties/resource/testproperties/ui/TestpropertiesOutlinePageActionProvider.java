/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

import java.util.List;
import org.eclipse.jface.action.IAction;

public class TestpropertiesOutlinePageActionProvider {
	
	public List<IAction> getActions(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<IAction> defaultActions = new java.util.ArrayList<IAction>();
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
