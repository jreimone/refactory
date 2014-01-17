/**
 * 
 */
package org.qualitune.evolution.cods.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.qualitune.evolution.megamodel.architecture.ArchitecturePackage;
import org.qualitune.evolution.megamodel.architecture.InstanceModel;
import org.qualitune.evolution.megamodel.architecture.TransformationModel;
import org.qualitune.evolution.megamodel.cods.CODS;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author jreimann
 *
 */
public class AbstractModelView extends ViewPart {
	private static class Sorter extends ViewerSorter {
		public int compare(Viewer viewer, Object e1, Object e2) {
			Object item1 = e1;
			Object item2 = e2;
			if(item1 instanceof InstanceModel && item2 instanceof InstanceModel){
				String string1 = ((InstanceModel) item1).getModel().eResource().getURI().toString();
				String string2 = ((InstanceModel) item2).getModel().eResource().getURI().toString();
				return string1.compareTo(string2);
			}
			return 0;
		}
	}
	private DataBindingContext m_bindingContext;
	
	private CODS megaModel;
	
	public static final String ID = "org.qualitune.evolution.cods.ui.MegaModelView"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table instanceModelTable;
	private TableViewer instanceModelTableViewer;
	private TableColumn tableColumnLocation;
	private Composite composite;
	private ScrolledComposite scrolledComposite;
	private TableColumn tableColumnMetamodel;
	
	public AbstractModelView() {
		super();
//		getMegaModel();
	}

	public EObject getObservableParent(){
		return null;
	}

	public EReference getObservableParentToObservableFeature() {
		return null;
	}

	public EReference getObservableDisplayFeature(){
		return null;
	}
	
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		
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
		instanceModelTableViewer.setSorter(new Sorter());
		instanceModelTable = instanceModelTableViewer.getTable();
		instanceModelTable.setLinesVisible(true);
		instanceModelTable.setHeaderVisible(true);
		toolkit.paintBordersFor(instanceModelTable);
		
		
		tableColumnLocation = new TableColumn(instanceModelTable, SWT.NONE);
		tableColumnLocation.setWidth(500);
		tableColumnLocation.setText("Location");
		new TableSortSelectionListener(instanceModelTableViewer, tableColumnLocation, new MegamodelSorter(), SWT.DOWN, true).chooseColumnForSorting();
		
		tableColumnMetamodel = new TableColumn(instanceModelTable, SWT.NONE);
		tableColumnMetamodel.setWidth(300);
		tableColumnMetamodel.setText("Metamodel");
		new TableSortSelectionListener(instanceModelTableViewer, tableColumnMetamodel, new MegamodelSorter(), SWT.DOWN, true);

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
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
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

	public CODS getMegaModel() {
		if(megaModel == null){
			URI createURI = URI.createURI("http://qualitune.org/megamodel.cods");
			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.getResource(createURI, true);
			megaModel = (CODS) resource.getContents().get(0);
		}
		return megaModel;
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{getObservableDisplayFeature()});
		instanceModelTableViewer.setLabelProvider(new ObservableModelMapLabelProvider(observeMaps));
		instanceModelTableViewer.setContentProvider(listContentProvider);
		//
		IObservableList megaModelInstanceModelsObserveList = EMFObservables.observeList(Realm.getDefault(), getObservableParent(), getObservableParentToObservableFeature());
		instanceModelTableViewer.setInput(megaModelInstanceModelsObserveList);
		//
		return bindingContext;
	}
	
	// TODO comment out when intended to open in Window Builder
//	protected DataBindingContext initDataBindings() {
//		DataBindingContext bindingContext = new DataBindingContext();
//		//
//		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
//		IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{ArchitecturePackage.Literals.INSTANCE_MODEL__MODEL});
//		instanceModelTableViewer.setLabelProvider(new ObservableModelMapLabelProvider(observeMaps));
//		instanceModelTableViewer.setContentProvider(listContentProvider);
//		//
//		IObservableList megaModelInstanceModelsObserveList = EMFObservables.observeList(Realm.getDefault(), megaModel, ArchitecturePackage.Literals.MEGA_MODEL__INSTANCE_MODELS);
//		instanceModelTableViewer.setInput(megaModelInstanceModelsObserveList);
//		//
//		return bindingContext;
//	}
}
