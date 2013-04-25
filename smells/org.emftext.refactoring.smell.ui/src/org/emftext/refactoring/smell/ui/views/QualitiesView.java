package org.emftext.refactoring.smell.ui.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.emftext.refactoring.smell.QualitySmellModel;
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
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.refactoring.smell.SmellPackage.Literals;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.ResourceManager;

public class QualitiesView extends ViewPart {
	private DataBindingContext m_bindingContext;

	public static final String ID = "org.emftext.refactoring.smell.ui.views.QualitiesView"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Table table_1;
	
	private QualitySmellModel smellModel;
	private TableViewer tableViewer_1;

	public QualitiesView() {
		init();
	}

	private void init() {
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceTracker<QualitySmellModel,QualitySmellModel> tracker = new ServiceTracker<QualitySmellModel,QualitySmellModel>(bundleContext, QualitySmellModel.class, null);
		tracker.open();
		smellModel = tracker.getService();
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
				table = tableViewer_1.getTable();
				table.setLinesVisible(true);
				table.setHeaderVisible(true);
				toolkit.paintBordersFor(table);
				{
					TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer_1, SWT.NONE);
//					tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
//						public Image getImage(Object element) {
//							if(element instanceof Quality){
//								Quality quality = (Quality) element;
//								if(quality.isActive()){
//									return ResourceManager.getPluginImage("org.emftext.refactoring.smell.ui", "icons/smartmode_co.gif");
//								}
//								return ResourceManager.getPluginImage("org.emftext.refactoring.smell.ui", "icons/th_horizontal.gif");
//							}
//							return null;
//						}
//						public String getText(Object element) {
//							return null;
//						}
//					});
					TableColumn tblclmnActive = tableViewerColumn.getColumn();
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
				TableViewer tableViewer = new TableViewer(sashForm, SWT.BORDER | SWT.FULL_SELECTION);
				table_1 = tableViewer.getTable();
				table_1.setLinesVisible(true);
				table_1.setHeaderVisible(true);
				toolkit.paintBordersFor(table_1);
			}
			sashForm.setWeights(new int[] {1, 2});
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
		tableViewer_1.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewer_1.setContentProvider(listContentProvider);
		//
		IObservableList smellModelQualitiesObserveList = EMFObservables.observeList(Realm.getDefault(), smellModel, Literals.QUALITY_SMELL_MODEL__QUALITIES);
		tableViewer_1.setInput(smellModelQualitiesObserveList);
		//
		return bindingContext;
	}
}
