/**
 * Copyright 2012 
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
