/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
