/*******************************************************************************
 * Copyright 2005, 2000 CHISEL Group, University of Victoria, Victoria, BC,
 * Canada. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The Chisel Group, University of Victoria IBM CAS, IBM Toronto
 * Lab
 ******************************************************************************/
package org.eclipse.pde.internal.visualization.dependency.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.ui.dialogs.PluginSelectionDialog;
import org.eclipse.pde.internal.visualization.dependency.Activator;
import org.eclipse.pde.internal.visualization.dependency.PDEVizImages;
import org.eclipse.pde.internal.visualization.dependency.analysis.ErrorReporting;
import org.eclipse.pde.internal.visualization.dependency.analysis.UnresolvedError;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.viewers.ZoomContributionViewItem;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.Filter;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutItem;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.DirectedGraphLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalShift;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */
public class PluginVisualizationView extends ViewPart implements IZoomableWorkbenchPart {

	public static final int BACKSPACE = 8;
	public static final int ENTER = 13;

	private FormToolkit toolKit = null;
	private ScrolledForm form = null;
	private ManagedForm managedForm = null;
	private GraphViewer viewer;
	private Action focusDialogAction;
	private Action focusDialogActionToolbar;
	private Action showCalleesAction;
	private Action showCallersAction;
	private Action focusAction;
	private Action pinAction;
	private Action unPinAction;
	private Action historyAction;
	private Action forwardAction;
	private Action screenshotAction;
	private Stack historyStack;
	private Stack forwardStack;
	private Object currentNode = null;
	private VisualizationLabelProvider currentLabelProvider;
	private GraphContentProvider contentProvider;
	private Object pinnedNode = null;
	private ZoomContributionViewItem contextZoomContributionViewItem;
	private ZoomContributionViewItem toolbarZoomContributionViewItem;
	private VisualizationForm visualizationForm;
	private Font searchFont;

	private Action filterAction;
	private Action resetFilterAction;
	private Filter filter;


	class ShowCalleesAction extends Action {

		public ShowCalleesAction() {
			super("", AS_RADIO_BUTTON); //$NON-NLS-1$
			setText("Callees");
			setDescription("Show Callees");
			setToolTipText("Show Callees");
			setImageDescriptor(PDEVizImages.DESC_CALLEES);
		}

		/*
		 * @see Action#actionPerformed
		 */
		public void run() {
			if (isChecked()) {
				showDependendBundles(false);
				// disable detailed analysis for reverse dependencies
				visualizationForm.getDependencyAnalysis().setEnabled(true);
			}
		}
	}

	class ShowCallersAction extends Action {
		public ShowCallersAction() {
			super("", AS_RADIO_BUTTON); //$NON-NLS-1$
			setText("Show Callers");
			setDescription("Show Callers");
			setToolTipText("Show Callers");
			setImageDescriptor(PDEVizImages.DESC_CALLERS);
		}

		/*
		 * @see Action#actionPerformed
		 */
		public void run() {
			if (isChecked()) {
				showDependendBundles(true);
				// disable detailed analysis for reverse dependencies
				visualizationForm.getDependencyAnalysis().setEnabled(false);
			}
		}
	}	

	/**
	 * The constructor.
	 */
	public PluginVisualizationView() {
		historyStack = new Stack();
		forwardStack = new Stack();
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {

		toolKit = new FormToolkit(parent.getDisplay());
		visualizationForm = new VisualizationForm(parent, toolKit, this);
		viewer = visualizationForm.getGraphViewer();
		form = visualizationForm.getForm();
		managedForm = visualizationForm.getManagedForm();

		this.contentProvider = new GraphContentProvider();
		this.currentLabelProvider = new HighlightDependencyLableProvider(this.viewer, null);
		viewer.setContentProvider(this.contentProvider);
		viewer.setLabelProvider(this.currentLabelProvider);
		viewer.setInput(null);
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		viewer.setLayoutAlgorithm(new CompositeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING, new LayoutAlgorithm[] { new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING) }));

		FontData fontData = Display.getCurrent().getSystemFont().getFontData()[0];
		fontData.height = 42;

		searchFont = new Font(Display.getCurrent(), fontData);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object selectedElement = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (selectedElement instanceof EntityConnectionData) {
					return;
				}
				PluginVisualizationView.this.selectionChanged(selectedElement);
			}
		});

		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				// On a double click we now focus on that node.
				// See bug: 172627: [pde viz] double-clicking on a node should implicitly focus on it.
				//    https://bugs.eclipse.org/bugs/show_bug.cgi?id=172627

				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection.size() < 1) {
					return;
				}
				Object selectedElement = selection.getFirstElement();
				if (selectedElement instanceof BundleDescription || selectedElement instanceof BundleSpecification) {
					focusOn(selectedElement, true, null);
					// When a new plug-in is selected, disable the forward action.
					// The forward action only stores history when the back button was used (much like a browser)
					forwardStack.clear();
					forwardAction.setEnabled(false);
				}
			}

		});

		visualizationForm.getSearchBox().addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				String textString = visualizationForm.getSearchBox().getText();

				HashMap figureListing = new HashMap();
				ArrayList list = new ArrayList();
				Iterator iterator = viewer.getGraphControl().getNodes().iterator();
				while (iterator.hasNext()) {
					GraphItem item = (GraphItem) iterator.next();
					figureListing.put(item.getText(), item);
				}
				iterator = figureListing.keySet().iterator();
				if (textString.length() > 0) {
					while (iterator.hasNext()) {
						String string = (String) iterator.next();
						if (string.toLowerCase().indexOf(textString.toLowerCase()) >= 0) {
							list.add(figureListing.get(string));
						}
					}
				}
				viewer.getGraphControl().setSelection((GraphItem[]) list.toArray(new GraphItem[list.size()]));
			}

		});

		toolbarZoomContributionViewItem = new ZoomContributionViewItem(this);
		contextZoomContributionViewItem = new ZoomContributionViewItem(this);

		makeActions();
		hookContextMenu();
		fillToolBar();
	}

	/**
	 * If true, the version number of the bundles will be displayed at the end
	 * the name. If false, this information will be hidden
	 * @param enable
	 */
	void showVersionNumber(boolean enable) {
		this.currentLabelProvider.showVersionNumber(enable);
		viewer.update(contentProvider.getElements(currentNode), null);
		viewer.applyLayout();
	}

	void showDependendBundles(boolean enable) {
		StructuredSelection selection = ((StructuredSelection) viewer.getSelection());
		if (selection != null) {
			viewer.setSelection(new StructuredSelection());
			this.selectionChanged(null);
		}

		this.contentProvider.setReverseBundleDependencies(enable);
		this.currentLabelProvider.setReverseBundleDependencies(enable);

		viewer.refresh();
		viewer.applyLayout();
	}


	/**
	 * Enable dependency path in the view. This will highlight all the nodes
	 * from the selected node to the root.
	 * 
	 * @param dependencyPath
	 */
	void setDependencyPath(boolean dependencyPath, String dependencyPathType) {
		// If the viewer has not been created, return
		if (viewer == null) {
			return;
		}

		StructuredSelection selection = ((StructuredSelection) viewer.getSelection());
		if (selection != null) {
			viewer.setSelection(new StructuredSelection());
			this.selectionChanged(null);
		}

		if (dependencyPath) {
			// If dependencyPath is set to true set the
			// ShortestPathDependencyAnalyis label provider

			if (dependencyPathType == VisualizationForm.Show_Smart_Path) {
				this.currentLabelProvider = new SmartPathDependencyAnalysis(this.viewer, (AbstractVisualizationLabelProvider) this.currentLabelProvider);
			}
			if (dependencyPathType == VisualizationForm.Show_All_Paths) {
				this.currentLabelProvider = new PathDependencyAnalysis(this.viewer, (AbstractVisualizationLabelProvider) this.currentLabelProvider);
			}
			if (dependencyPathType == VisualizationForm.Show_Shortest_Path) {
				this.currentLabelProvider = new ShortestPathDependencyAnalysis(this.viewer, (AbstractVisualizationLabelProvider) this.currentLabelProvider);
			}

			viewer.setLabelProvider(this.currentLabelProvider);
			//viewer.refresh();
			//viewer.setInput(this.currentBundle);

		} else if (!dependencyPath && !(currentLabelProvider instanceof HighlightDependencyLableProvider)) {
			this.currentLabelProvider = new HighlightDependencyLableProvider(this.viewer, (AbstractVisualizationLabelProvider) this.currentLabelProvider);
			viewer.setLabelProvider(this.currentLabelProvider);

		}

		if (selection != null) {
			viewer.setSelection(selection);
		}

		// Set the pinned node in case we have one from the previous content
		// provider
		this.currentLabelProvider.setPinnedNode(pinnedNode);
		if (viewer.getSelection() != null) {
			viewer.setSelection(viewer.getSelection());
			this.selectionChanged(((IStructuredSelection) viewer.getSelection()).getFirstElement());
			//	this.currentLabelProvider.setCurrentSelection(currentNode, ((IStructuredSelection) viewer.getSelection()).getFirstElement());
		}

	}

	/**
	 * Handle the select changed. This will update the view whenever a selection
	 * occurs.
	 * 
	 * @param selectedItem
	 */
	private void selectionChanged(Object selectedItem) {
		currentLabelProvider.setCurrentSelection(currentNode, selectedItem);
		viewer.update(contentProvider.getElements(currentNode), null);
	}

	/**
	 * Set the toolbar
	 */
	private void fillToolBar() {
		IActionBars bars = getViewSite().getActionBars();
		bars.getMenuManager().add(toolbarZoomContributionViewItem);

		fillLocalToolBar(bars.getToolBarManager());

	}

	/**
	 * Add the actions to the tool bar
	 * 
	 * @param toolBarManager
	 */
	private void fillLocalToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(focusDialogActionToolbar);
		toolBarManager.add(new Separator());
		toolBarManager.add(showCalleesAction);
		toolBarManager.add(showCallersAction);
		toolBarManager.add(new Separator());
		toolBarManager.add(historyAction);
		toolBarManager.add(forwardAction);
		toolBarManager.add(new Separator());
		toolBarManager.add(screenshotAction);
	}

	/**
	 * Update the view to focus on a particular bundle. If record history is set
	 * to true, and bundle does not equal the current bundle, then the current
	 * bundle will be saved on the history stack
	 * 
	 * @param bundle
	 * @param recordHistory
	 */
	private void focusOn(Object bundle, boolean recordHistory, final ErrorReporting errorReporting) {
		viewer.setSelection(new StructuredSelection());
		this.selectionChanged(null);
		viewer.setFilters(new ViewerFilter[] {});

		if (errorReporting != null) {
			if (errorReporting.getClass() == UnresolvedError.class) {
				viewer.addFilter(new ViewerFilter() {
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EntityConnectionData) {
							return true;
						}
						Object[] allCallers = AnalysisUtil.getAllCallers(errorReporting.getBundle(), contentProvider.getElements(currentNode));
						if (Arrays.asList(allCallers).contains(element)) {
							return true;
						}
						return false;
					}
				});
			}
			ErrorReporting.showCurrentError(this, errorReporting, managedForm.getMessageManager());
		}

		viewer.setInput(bundle);
		visualizationForm.setFocusedNodeName(getName(bundle));
		Iterator nodes = viewer.getGraphControl().getNodes().iterator();
		if (viewer.getGraphControl().getNodes().size() > 0) {
			visualizationForm.enableSearchBox(true);
		} else {
			visualizationForm.enableSearchBox(false);
		}
		visualizationForm.enableSearchBox(true);
		Graph graph = viewer.getGraphControl();
		Dimension centre = new Dimension(graph.getBounds().width / 2, graph.getBounds().height / 2);
		while (nodes.hasNext()) {
			GraphNode node = (GraphNode) nodes.next();
			if (node.getLocation().x <= 1 && node.getLocation().y <= 1) {
				node.setLocation(centre.width, centre.height);
			}
		}
		if (currentNode != null && recordHistory && currentNode != bundle) {
			historyStack.push(currentNode);
			historyAction.setEnabled(true);
		}
		currentNode = bundle;
		viewer.setSelection(new StructuredSelection(bundle));
		this.selectionChanged(bundle);

		// When we load a new model, remove any pinnedNode;
		this.currentLabelProvider.setPinnedNode(null);
		this.pinnedNode = null;

		// Check for errors in the graph
		Object[] elements = contentProvider.getElements(currentNode);
		if (errorReporting == null) {
			// Don't report errors while error reporting
			ErrorReporting.createErrorReports(elements, this, managedForm.getMessageManager());
		}
	}

	public void handleUnresolvedDependencyError(UnresolvedError unresolvedError) {
		this.focusOn(currentNode, false, unresolvedError);
	}

	public void handleSuppressError() {
		this.focusOn(currentNode, false, null);
	}

	/**
	 * Make the actions that can be called on this viewer. This currently
	 * includes: - Focus on ... - Focus on Selected Node - History action
	 */
	private void makeActions() {
		focusDialogAction = new Action() {
			public void run() {
				PluginSelectionDialog dialog = new PluginSelectionDialog(viewer.getControl().getShell(), true, false);
				dialog.create();
				if (dialog.open() == Window.OK) {
					IPluginModelBase pluginModelBase = (IPluginModelBase) dialog.getFirstResult();
					focusOn(pluginModelBase.getBundleDescription(), true, null);

					// When a new plug-in is selected, disable the forward action			
					// The forward action only stores history when the back button was used (much like a browser)
					forwardStack.clear();
					forwardAction.setEnabled(false);
				}
			}
		};
		// @tag action : Focus on ... Action
		focusDialogAction.setText("Focus On ...");
		focusDialogAction.setToolTipText("Focus on a plug-in");

		focusDialogActionToolbar = new Action() {
			public void run() {
				focusDialogAction.run();
			}
		};
		focusDialogActionToolbar.setToolTipText("Focus on a plug-in...");
		focusDialogActionToolbar.setImageDescriptor(PDEVizImages.DESC_FOCUS);

		historyAction = new Action() {
			public void run() {
				if (historyStack.size() > 0) {
					Object o = historyStack.pop();
					forwardStack.push(currentNode);
					forwardAction.setEnabled(true);
					focusOn(o, false, null);
					if (historyStack.size() <= 0) {
						historyAction.setEnabled(false);
					}
				}
			}
		};
		// @tag action : History action
		historyAction.setText("Back");
		historyAction.setToolTipText("Previous plugin");
		historyAction.setEnabled(false);
		historyAction.setImageDescriptor(PDEVizImages.DESC_BACKWARD_ENABLED);

		forwardAction = new Action() {
			public void run() {
				if (forwardStack.size() > 0) {
					Object o = forwardStack.pop();
					focusOn(o, true, null);
					if (forwardStack.size() <= 0) {
						forwardAction.setEnabled(false);
					}
				}
			}
		};

		forwardAction.setText("Forward");
		forwardAction.setToolTipText("Go forward one plugin");
		forwardAction.setEnabled(false);
		forwardAction.setImageDescriptor(PDEVizImages.DESC_FORWARD_ENABLED);

		screenshotAction = new Action() {
			public void run() {

				Shell shell = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
				Graph g = (Graph) viewer.getControl();
				Rectangle bounds = g.getContents().getBounds();
				Point size = new Point(g.getContents().getSize().width, g.getContents().getSize().height);
				org.eclipse.draw2d.geometry.Point viewLocation = g.getViewport().getViewLocation();
				final Image image = new Image(null, size.x, size.y);
				GC gc = new GC(image);
				SWTGraphics swtGraphics = new SWTGraphics(gc);

				swtGraphics.translate(-1 * bounds.x + viewLocation.x, -1 * bounds.y + viewLocation.y);
				g.getViewport().paint(swtGraphics);
				gc.copyArea(image, 0, 0);
				gc.dispose();

				ImagePreviewPane previewPane = new ImagePreviewPane(shell);
				previewPane.setText("Image Preview");
				previewPane.open(image, size);
			}
		};

		screenshotAction.setText("Take A Screenshot");
		screenshotAction.setImageDescriptor(PDEVizImages.DESC_SNAPSHOT);
		screenshotAction.setToolTipText("Take screenshot");
		screenshotAction.setEnabled(true);

		showCalleesAction = new ShowCalleesAction();
		showCalleesAction.setChecked(true);
		showCallersAction = new ShowCallersAction();
		showCallersAction.setChecked(false);
	}

	/**
	 * Create the make focus on current selection action
	 * 
	 * @param objectToFocusOn
	 */
	private void makeFocusAction(final Object objectToFocusOn) {
		// @tag action : Focus on Current Selection action
		focusAction = new Action() {
			public void run() {
				focusOn(objectToFocusOn, true, null);

				// When a new plug-in is selected, disable the forward action
				// The forward action only stores history when the back button was used (much like a browser)
				forwardStack.clear();
				forwardAction.setEnabled(false);
			}
		};
		if (objectToFocusOn instanceof BundleDescription) {
			focusAction.setText("Focus On \'" + ((BundleDescription) objectToFocusOn).getName() + "\'");
		} else if (objectToFocusOn instanceof BundleSpecification) {
			focusAction.setText("Focus On \'" + ((BundleSpecification) objectToFocusOn).getName() + "\'");

		}
		focusAction.setToolTipText("Focus on a plugin");
		focusAction.setImageDescriptor(PDEVizImages.DESC_FOCUS);
	}

	private void makeUnPinAction() {
		unPinAction = new Action() {
			public void run() {
				unPin();
			}
		};
		unPinAction.setText("Deselect pinned node");
		unPinAction.setToolTipText("Deselect: " + this.pinnedNode);
		unPinAction.setChecked(true);
	}

	private String getName(Object o) {
		if (o instanceof BundleDescription) {
			return ((BundleDescription) o).getName();
		} else if (o instanceof BundleSpecification) {
			return ((BundleSpecification) o).getName();
		}
		return null;
	}

	private void makePinAction(final Object objectToPin) {
		pinAction = new Action() {
			public void run() {
				pinNode(objectToPin);
			}
		};
		pinAction.setText("Pin selection of " + getName(objectToPin));
		pinAction.setToolTipText("Toggle pin selected node");
	}

	private void unPin() {
		pinNode(null);
	}

	private void pinNode(Object objectToPin) {
		this.currentLabelProvider.setPinnedNode(objectToPin);
		this.pinnedNode = objectToPin;
		this.currentLabelProvider.setCurrentSelection(this.currentNode, ((IStructuredSelection) viewer.getSelection()).getFirstElement());
		this.viewer.update(contentProvider.getElements(currentNode), null);
	}

	/**
	 * Creates the context menu for this view.
	 */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		fillContextMenu(menuMgr);

		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				PluginVisualizationView.this.fillContextMenu(manager);

			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);

	}

	/**
	 * Add the items to the context menu
	 * 
	 * @param manager
	 */
	private void fillContextMenu(IMenuManager manager) {
		manager.add(new Separator());
		if (((IStructuredSelection) viewer.getSelection()).size() > 0) {
			makeFilterAction((IStructuredSelection) viewer.getSelection());
			manager.add(filterAction);
		}
		makeResetFilterAction();
		manager.add(resetFilterAction);
		manager.add(new Separator());
		if (((IStructuredSelection) viewer.getSelection()).size() > 0) {
			makeFocusAction(((IStructuredSelection) viewer.getSelection()).getFirstElement());
			manager.add(focusAction);

		}
		manager.add(focusDialogAction);
		// Other plug-ins can contribute there actions here
		if (((IStructuredSelection) viewer.getSelection()).size() > 0 || this.pinnedNode != null) {
			manager.add(new Separator());
		}
		if (this.pinnedNode != null) {
			makeUnPinAction();
			manager.add(unPinAction);
		}
		if (((IStructuredSelection) viewer.getSelection()).size() > 0) {
			makePinAction(((IStructuredSelection) viewer.getSelection()).getFirstElement());
			manager.add(pinAction);
		}

		manager.add(new Separator());
		manager.add(historyAction);
		manager.add(forwardAction);
		manager.add(new Separator());
		manager.add(screenshotAction);
		manager.add(new Separator());
		manager.add(contextZoomContributionViewItem);
	}

	private void makeResetFilterAction() {
		resetFilterAction = new Action() {
			public void run() {
				filterBundles(null);
			}
		};
		resetFilterAction.setText("Reset the current filter");
	}

	private void makeFilterAction(IStructuredSelection selection) {
		final List bundles = new ArrayList();
		Iterator it = selection.iterator();
		while (it.hasNext()) {
			Object object = (Object) it.next();
			if(object instanceof BundleDescription || object instanceof BundleSpecification){
				bundles.add(object);
			}
		}
		filterAction = new Action() {

			public void run() {
				filterBundles(bundles);
			}

		};
		filterAction.setText("Filter selected nodes");
	}

	private void filterBundles(List bundles){
		if(bundles == null){
			bundles= new ArrayList();
		}
		Map bundleMap = new HashMap();
		for (int i = 0; i < bundles.size(); i++) {
			if(bundles.get(i) instanceof BundleDescription){
				bundleMap.put(((BundleDescription) bundles.get(i)).getName(), bundles.get(i));
			}
			if(bundles.get(i) instanceof BundleSpecification){
				bundleMap.put(((BundleSpecification) bundles.get(i)).getName(), bundles.get(i));
			}
		}
		Graph graph = visualizationForm.getGraphViewer().getGraphControl();
		final String key = "FILTER";
		if(filter == null){
			LayoutAlgorithm algo = graph.getLayoutAlgorithm();
			filter = new Filter() {

				public boolean isObjectFiltered(LayoutItem item) {
					Object object = item.getGraphData();
					if  (object instanceof GraphItem ) {
						GraphItem graphItem = (GraphItem) object;
						Object data = graphItem.getData(key);
						if(data != null && data instanceof Boolean){
							graphItem.setVisible(!((Boolean) data).booleanValue());
							return ((Boolean) data).booleanValue();
						}
						graphItem.setVisible(true);
					}
					return false;
				}
			};
			algo.setFilter(filter);
		}
		if(bundles.size() == 0){
			List graphItems = graph.getNodes();
			for (int i = 0; i < graphItems.size(); i++) {
				GraphItem item = (GraphItem) graphItems.get(i);
				if(item instanceof GraphNode || item instanceof GraphConnection){
					item.setData(key, Boolean.FALSE);
				}
			}
			graphItems = graph.getConnections();
			for (int i = 0; i < graphItems.size(); i++) {
				GraphItem item = (GraphItem) graphItems.get(i);
				if(item instanceof GraphNode || item instanceof GraphConnection){
					item.setData(key, Boolean.FALSE);
				}
			}
		} else {
			List nodes = graph.getNodes();
			for (int i = 0; i < nodes.size(); i++) {
				GraphNode node = (GraphNode) nodes.get(i);
				String text = node.getText();
				Object selectedBundle = bundleMap.get(text);
				if(selectedBundle != null){
					node.setData(key, Boolean.TRUE);
				} else {
					Object value = node.getData(key);
					if(value == null){
						node.setData(key, Boolean.FALSE);
					}
				}
			}
			List connections = graph.getConnections();
			for (int i = 0; i < connections.size(); i++) {
				GraphConnection connection = (GraphConnection) connections.get(i);
				GraphNode source = connection.getSource();
				GraphNode target = connection.getDestination();
				Boolean sourceFilter = (Boolean) source.getData(key);
				Boolean targetFilter = (Boolean) target.getData(key);
				if(Boolean.TRUE.equals(sourceFilter) || Boolean.TRUE.equals(targetFilter)){
					connection.setData(key, Boolean.TRUE);
				} else {
					Object value = connection.getData(key);
					if(value == null){
						connection.setData(key, Boolean.FALSE);
					}
				}
			}
		}
		graph.applyLayout();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		form.setFocus();
	}

	/**
	 * Dispose the form
	 */
	public void dispose() {
		form.dispose();
		searchFont.dispose();
		super.dispose();
	}

	public AbstractZoomableViewer getZoomableViewer() {
		return viewer;
	}

}