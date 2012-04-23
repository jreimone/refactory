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
package org.emftext.refactoring.ui.views.registry;


import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.ui.views.registry.actions.ComplexLatexTableGenAction;
import org.emftext.refactoring.ui.views.registry.actions.ComplexWikiTableGenAction;
import org.emftext.refactoring.ui.views.registry.actions.MakeRefactoringDocGenAction;
import org.emftext.refactoring.ui.views.registry.actions.SimpleLatexTableGenAction;
import org.emftext.refactoring.ui.views.registry.actions.UnregisterAction;

/**
 * This class is used to visualise the Refactory registry.
 */

public class RefactoringRegistryView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.emftext.refactoring.ui.views.registry.RefactoringRegistryView";

	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action refactoringDocGenAction;
	private Action complexLatexTableGenAction;
	private Action complexWikiTableGenAction;
	private Action simpleLatexTableGenAction;
	private RegistryViewContentProvider contentProvider;
	private ViewLabelProvider labelProvider;

	private Action unregisterAction;

	class NameSorter extends ViewerComparator {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent,
				SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);

		Tree tree = viewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
		column1.setWidth(300);
		column1.setText("Refactoring mapped to Metamodel");
		TreeColumn column2 = new TreeColumn(tree, SWT.LEFT);
		column2.setWidth(200);
		column2.setText("Specific Refactoring");
		TreeColumn column3 = new TreeColumn(tree, SWT.CENTER);
		column3.setWidth(40);
		column3.setText("PP");
		TreeColumn column4 = new TreeColumn(tree, SWT.CENTER);
		column4.setWidth(40);
		column4.setText("MC");
		TreeColumn column5 = new TreeColumn(tree, SWT.CENTER);
		column5.setWidth(40);
		column5.setText("SF");
		TreeColumn column6 = new TreeColumn(tree, SWT.CENTER);
		column6.setWidth(40);
		column6.setText("SUM");

		drillDownAdapter = new DrillDownAdapter(viewer);
		contentProvider = new RegistryViewContentProvider(this);
		contentProvider.setViewer(viewer);
		viewer.setContentProvider(contentProvider);
		labelProvider = new ViewLabelProvider();
		viewer.setLabelProvider(labelProvider);
		viewer.setComparator(new NameSorter());
		viewer.setInput(getViewSite());
		RefactoringViewRegistryListener listener = new RefactoringViewRegistryListener(contentProvider);
		IRoleModelRegistry.INSTANCE.addRegistryListener(listener);
		IRefactoringSpecificationRegistry.INSTANCE.addRegistryListener(listener);
		IRoleMappingRegistry.INSTANCE.addRegistryListener(listener);
		makeActions();
		hookContextMenu();
		contributeToActionBars();
		viewer.expandToLevel(2);
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				RefactoringRegistryView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(refactoringDocGenAction);
		manager.add(complexLatexTableGenAction);
		manager.add(complexWikiTableGenAction);
		manager.add(simpleLatexTableGenAction);
		manager.add(unregisterAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(refactoringDocGenAction);
		manager.add(unregisterAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(refactoringDocGenAction);
		manager.add(complexLatexTableGenAction);
		manager.add(complexWikiTableGenAction);
		manager.add(simpleLatexTableGenAction);
		manager.add(unregisterAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		makeRefactoringDocGenAction();
		makeComplexLatexTableGenAction();
		makeComplexWikiTableGenAction();
		makeSimpleLatexTableGenAction();
		makeUnregisterAction();
	}

	private void makeComplexWikiTableGenAction() {
		complexWikiTableGenAction = new ComplexWikiTableGenAction(contentProvider);
		complexWikiTableGenAction.setText("Generate complex Wiki table");
		complexWikiTableGenAction.setToolTipText("Generate complex Wiki table");
		complexWikiTableGenAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
	}

	private void makeSimpleLatexTableGenAction() {
		simpleLatexTableGenAction = new SimpleLatexTableGenAction(contentProvider);
		simpleLatexTableGenAction.setText("Generate simple LaTeX table");
		simpleLatexTableGenAction.setToolTipText("Generate simple LaTeX table");
		simpleLatexTableGenAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_FILE));
	}

	private void makeComplexLatexTableGenAction() {
		complexLatexTableGenAction = new ComplexLatexTableGenAction(contentProvider);
		complexLatexTableGenAction.setText("Generate complex LaTeX table");
		complexLatexTableGenAction.setToolTipText("Generate complex LaTeX table");
		complexLatexTableGenAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));
	}

	private void makeRefactoringDocGenAction() {
		refactoringDocGenAction = new MakeRefactoringDocGenAction(viewer);
		refactoringDocGenAction.setText("Generate Documentation of selected Refactoring");
		refactoringDocGenAction.setToolTipText("Generate Documentation of selected Refactoring");
		refactoringDocGenAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}
	
	private void makeUnregisterAction() {
		unregisterAction = new UnregisterAction(viewer);
		unregisterAction.setText("Unregister");
		unregisterAction.setToolTipText("Unregisters the selected element");
		unregisterAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

}
