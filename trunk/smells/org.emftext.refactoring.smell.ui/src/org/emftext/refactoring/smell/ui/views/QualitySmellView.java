package org.emftext.refactoring.smell.ui.views;

import javax.inject.Inject;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.refactoring.smell.SmellPackage.Literals;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.jface.action.MenuManager;

public class QualitySmellView extends ViewPart {
	private DataBindingContext m_bindingContext;

	@Inject
	private QualitySmellModel smellModel;
	
	public static final String ID = "org.emftext.refactoring.smell.ui.views.QualitySmellView"; //$NON-NLS-1$
	private Table table;
	private TableViewer tableViewer;

	public QualitySmellView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnQualitySmell = tableViewerColumn.getColumn();
		tblclmnQualitySmell.setWidth(400);
		tblclmnQualitySmell.setText("Quality Smell");

		createActions();
		initializeToolBar();
		initializeMenu();
		m_bindingContext = initDataBindings();
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
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{Literals.QUALITY_SMELL__NAME});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableList smellModelSmellsObserveList = EMFObservables.observeList(Realm.getDefault(), smellModel, Literals.QUALITY_SMELL_MODEL__SMELLS);
		tableViewer.setInput(smellModelSmellsObserveList);
		//
		return bindingContext;
	}
}
