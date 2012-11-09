/**
 * 
 */
package org.qualitune.evolution.cods.ui;

import javax.inject.Inject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.qualitune.evolution.megamodel.architecture.InstanceModel;
import org.qualitune.evolution.megamodel.architecture.TransformationModel;
import org.qualitune.evolution.megamodel.cods.CODS;
import org.eclipse.swt.custom.ScrolledComposite;

/**
 * @author jreimann
 *
 */
public class TerminalModelView extends ViewPart {
	private DataBindingContext m_bindingContext;

	@Inject
	private CODS megaModel;
	
	public static final String ID = "org.qualitune.evolution.cods.ui.MegaModelView"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private ExpandBar terminalModelExpandBar;
	private ExpandItem expandItemInstanceModels;
	private ExpandItem expandItemTransformationModels;
	private Table instanceModelTable;
	private TableViewer instanceModelTableViewer;
	private TableColumn tableColumnModelElement;
	private Table transformationModelTable;
	private TableViewer transformationModelTableViewer;
	private TableColumn tableColumnModelElement_1;
	private Composite composite;
	private ScrolledComposite scrolledComposite;

	public TerminalModelView() {
		super();
		URI createURI = URI.createURI("http://qualitune.org/megamodel.cods");
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(createURI, true);
		megaModel = (CODS) resource.getContents().get(0);
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = toolkit.createComposite(parent, SWT.NONE);
		toolkit.paintBordersFor(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		terminalModelExpandBar = new ExpandBar(container, SWT.NONE);
		toolkit.adapt(terminalModelExpandBar);
		toolkit.paintBordersFor(terminalModelExpandBar);
		
		expandItemInstanceModels = new ExpandItem(terminalModelExpandBar, SWT.NONE);
		expandItemInstanceModels.setExpanded(true);
		expandItemInstanceModels.setText("Instance Models");
		
		scrolledComposite = new ScrolledComposite(terminalModelExpandBar, SWT.BORDER | SWT.V_SCROLL);
		expandItemInstanceModels.setControl(scrolledComposite);
		
		composite = new Composite(scrolledComposite, SWT.NONE);
		scrolledComposite.setContent(composite);
		
		toolkit.adapt(scrolledComposite);
		toolkit.paintBordersFor(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		toolkit.adapt(composite);
		toolkit.paintBordersFor(composite);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		instanceModelTableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		instanceModelTable = instanceModelTableViewer.getTable();
		instanceModelTable.setLinesVisible(true);
		instanceModelTable.setHeaderVisible(true);
		toolkit.paintBordersFor(instanceModelTable);
		
		tableColumnModelElement = new TableColumn(instanceModelTable, SWT.NONE);
		tableColumnModelElement.setWidth(500);
		tableColumnModelElement.setText("Location");
		expandItemInstanceModels.setHeight(150);
		
		expandItemTransformationModels = new ExpandItem(terminalModelExpandBar, SWT.NONE);
		expandItemTransformationModels.setText("Transformation Models");
		
		transformationModelTableViewer = new TableViewer(terminalModelExpandBar, SWT.BORDER | SWT.FULL_SELECTION);
		transformationModelTable = transformationModelTableViewer.getTable();
		transformationModelTable.setLinesVisible(true);
		transformationModelTable.setHeaderVisible(true);
		expandItemTransformationModels.setControl(transformationModelTable);
		toolkit.paintBordersFor(transformationModelTable);
		expandItemTransformationModels.setHeight(150);
		
		tableColumnModelElement_1 = new TableColumn(transformationModelTable, SWT.NONE);
		tableColumnModelElement_1.setWidth(500);
		tableColumnModelElement_1.setText("Location");

		createActions();
		initializeToolBar();
		initializeMenu();
		m_bindingContext = initDataBindings();
	}

	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager tollbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(listContentProvider.getKnownElements(), InstanceModel.class, "model");
		instanceModelTableViewer.setLabelProvider(new ObservableModelLabelProvider(observeMap));
		instanceModelTableViewer.setContentProvider(listContentProvider);
		//
		IObservableList instanceModelsMegaModelObserveList = PojoProperties.list("instanceModels").observe(megaModel);
		instanceModelTableViewer.setInput(instanceModelsMegaModelObserveList);
		//
		ObservableListContentProvider listContentProvider_1 = new ObservableListContentProvider();
		IObservableMap observeMap_1 = PojoObservables.observeMap(listContentProvider_1.getKnownElements(), TransformationModel.class, "transformation");
		transformationModelTableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMap_1));
		transformationModelTableViewer.setContentProvider(listContentProvider_1);
		//
		IObservableList transformationModelsMegaModelObserveList = PojoProperties.list("transformationModels").observe(megaModel);
		transformationModelTableViewer.setInput(transformationModelsMegaModelObserveList);
		//
		return bindingContext;
	}
}
