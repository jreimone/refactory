package org.emftext.refactoring.smell.ui.views;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellPackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.emftext.refactoring.smell.Quality;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.refactoring.smell.SmellPackage.Literals;
import org.emftext.refactoring.smell.registry.IQualitySmellRegistry;
import org.emftext.refactoring.smell.ui.util.ResourceManager;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.emftext.refactoring.smell.calculation.CalculationPackage;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.property.Properties;

public class QualitiesView extends ViewPart {
	private DataBindingContext m_bindingContext;

	public static final String ID = "org.emftext.refactoring.smell.ui.views.QualitiesView"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Table table_1;
	
	private QualitySmellModel smellModel;
	private TableViewer tableViewer_1;
	private TableViewer tableViewer;
	private Table table_2;
	
	private Set<EPackage> smellingMetamodels;
	private List<ConcreteQualitySmell> concreteSmellsForSelectedQualityAndMetamodel;

	protected Quality selectedQuality;

	protected EPackage selectedMetamodel;
	private TableViewer tableViewer_2;

	public QualitiesView() {
		init();
	}

	private void init() {
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceTracker<QualitySmellModel,QualitySmellModel> tracker = new ServiceTracker<QualitySmellModel,QualitySmellModel>(bundleContext, QualitySmellModel.class, null);
		tracker.open();
		smellModel = tracker.getService();
		
		smellingMetamodels = new HashSet<EPackage>();
		concreteSmellsForSelectedQualityAndMetamodel = new ArrayList<ConcreteQualitySmell>();
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
		{
			SashForm sashForm = new SashForm(container, SWT.NONE);
			toolkit.adapt(sashForm);
			toolkit.paintBordersFor(sashForm);
			{
				tableViewer_1 = new TableViewer(sashForm, SWT.BORDER | SWT.FULL_SELECTION);
				tableViewer_1.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						ISelection selection = event.getSelection();
						if(selection instanceof IStructuredSelection){
							Object firstElement = ((IStructuredSelection) selection).getFirstElement();
							if(firstElement instanceof Quality){
								selectedQuality = (Quality) firstElement;
								smellingMetamodels.clear();
								concreteSmellsForSelectedQualityAndMetamodel.clear();
								List<QualityCalculation> calculations = selectedQuality.getCalculations();
								for (QualityCalculation calculation : calculations) {
									EPackage metamodel = calculation.getConcreteSmell().getMetamodel();
									smellingMetamodels.add(metamodel);
								}
								tableViewer.refresh();
								tableViewer_2.refresh();
							}
						}
					}
				});
				table = tableViewer_1.getTable();
				table.setLinesVisible(true);
				table.setHeaderVisible(true);
				toolkit.paintBordersFor(table);
				{
					TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer_1, SWT.NONE);
					TableColumn tblclmnActive = tableViewerColumn.getColumn();
					tblclmnActive.setResizable(false);
					tblclmnActive.setWidth(25);
					tableViewerColumn.setEditingSupport(new IsActiveEditingSupport(tableViewer_1));
				}
				{
					TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer_1, SWT.NONE);
					TableColumn tblclmnQuality = tableViewerColumn.getColumn();
					tblclmnQuality.setWidth(100);
					tblclmnQuality.setText("Quality");
				}
			}
			{
				tableViewer = new TableViewer(sashForm, SWT.BORDER | SWT.FULL_SELECTION);
				tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						ISelection selection = event.getSelection();
						if(selection instanceof IStructuredSelection){
							Object firstElement = ((IStructuredSelection) selection).getFirstElement();
							if(firstElement instanceof EPackage){
								selectedMetamodel = (EPackage) firstElement;
								concreteSmellsForSelectedQualityAndMetamodel.clear();
								List<ConcreteQualitySmell> smellsForMetamodel = smellModel.getSmellsForMetamodel(selectedMetamodel);
								for (ConcreteQualitySmell concreteQualitySmell : smellsForMetamodel) {
									List<QualityCalculation> qualityCalculations = concreteQualitySmell.getQualityCalculations();
									for (QualityCalculation qualityCalculation : qualityCalculations) {
										if(qualityCalculation.getQuality().equals(selectedQuality)){
											concreteSmellsForSelectedQualityAndMetamodel.add(concreteQualitySmell);
										}
									}
								}
								tableViewer_2.refresh();
							}
						}
					}
				});
				table_1 = tableViewer.getTable();
				table_1.setLinesVisible(true);
				table_1.setHeaderVisible(true);
				toolkit.paintBordersFor(table_1);
				{
					TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
					TableColumn tblclmnMetamodelsWithDefined = tableViewerColumn.getColumn();
					tblclmnMetamodelsWithDefined.setWidth(100);
					tblclmnMetamodelsWithDefined.setText("Metamodels with defined quality smells");
				}
			}
			{
				tableViewer_2 = new TableViewer(sashForm, SWT.BORDER | SWT.FULL_SELECTION);
				table_2 = tableViewer_2.getTable();
				table_2.setLinesVisible(true);
				table_2.setHeaderVisible(true);
				toolkit.paintBordersFor(table_2);
				{
					TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer_2, SWT.NONE);
					TableColumn tblclmnConcreteQualitySmells = tableViewerColumn.getColumn();
					tblclmnConcreteQualitySmells.setWidth(100);
					tblclmnConcreteQualitySmells.setText("Concrete Quality Smells for selected Metamodel");
				}
			}
			sashForm.setWeights(new int[] {1, 1, 1});
		}

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
		IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager manager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{Literals.QUALITY__ACTIVE, Literals.QUALITY__NAME});
		tableViewer_1.setLabelProvider(new ObservableMapLabelProviderWithCheckboxes(observeMaps));
		tableViewer_1.setContentProvider(listContentProvider);
		//
		IObservableList smellModelQualitiesObserveList = EMFObservables.observeList(Realm.getDefault(), smellModel, Literals.QUALITY_SMELL_MODEL__QUALITIES);
		tableViewer_1.setInput(smellModelQualitiesObserveList);
		//
		ObservableSetContentProvider setContentProvider = new ObservableSetContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(setContentProvider.getKnownElements(), EPackage.class, "nsURI");
		tableViewer.setLabelProvider(new ObservableMapLabelProviderWithIcon(observeMap));
		tableViewer.setContentProvider(setContentProvider);
		//
		IObservableSet selfSet = Properties.selfSet(EPackage.class).observe(smellingMetamodels);
		tableViewer.setInput(selfSet);
		//
		ObservableListContentProvider listContentProvider_1 = new ObservableListContentProvider();
		IObservableMap observeMap_1 = PojoObservables.observeMap(listContentProvider_1.getKnownElements(), ConcreteQualitySmell.class, "concreteName");
		tableViewer_2.setLabelProvider(new ObservableMapLabelProviderWithIcon(observeMap_1));
		tableViewer_2.setContentProvider(listContentProvider_1);
		//
		IObservableList selfList = Properties.selfList(ConcreteQualitySmell.class).observe(concreteSmellsForSelectedQualityAndMetamodel);
		tableViewer_2.setInput(selfList);
		//
		return bindingContext;
	}
}
