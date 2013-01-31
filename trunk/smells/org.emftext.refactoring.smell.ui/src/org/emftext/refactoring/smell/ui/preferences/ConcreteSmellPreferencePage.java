package org.emftext.refactoring.smell.ui.preferences;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage.Literals;
import org.eclipse.core.databinding.observable.Realm;
import org.emftext.refactoring.smell.SmellPackage;
import org.emftext.refactoring.smell.wizard.NewConcreteSmellWizard;

public class ConcreteSmellPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {
	private DataBindingContext m_bindingContext;

	private Table tableMetamodels;
	private TableViewer tableViewerMetamodels;

	@Inject
	private QualitySmellModel smellModel;
	
	private Table tableSmells;
	
	/**
	 * Create the preference page.
	 */
	public ConcreteSmellPreferencePage() {
		setDescription(getDescription());
		setTitle(getTitle());
	}
	
	/**
	 * Create contents of the preference page.
	 * @param parent
	 */
	@Override
	public Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout gl_container = new GridLayout(2, false);
		container.setLayout(gl_container);
		
		tableViewerMetamodels = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		tableMetamodels = tableViewerMetamodels.getTable();
		tableMetamodels.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableMetamodels.setHeaderVisible(true);
		tableMetamodels.setLinesVisible(true);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewerMetamodels, SWT.NONE);
		TableColumn tblclmnMetamodel = tableViewerColumn.getColumn();
		tblclmnMetamodel.setWidth(280);
		tblclmnMetamodel.setText("Metamodel");
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		RowLayout rl_composite = new RowLayout(SWT.VERTICAL);
		rl_composite.marginTop = 0;
		rl_composite.fill = true;
		composite.setLayout(rl_composite);
		
		Button btnAddQualitySmell = new Button(composite, SWT.NONE);
		btnAddQualitySmell.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WizardDialog dialog = new WizardDialog(getShell(), new NewConcreteSmellWizard());
				dialog.open();
			}
		});
		btnAddQualitySmell.setText("Add Concrete Smell");
		
		Button btnRemoveQualitySmell = new Button(composite, SWT.NONE);
		btnRemoveQualitySmell.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tableViewerMetamodels.getSelection();
				if(selection != null){
					if(selection instanceof StructuredSelection){
						List<?> selectedElements = ((StructuredSelection) selection).toList();
						for (Object object : selectedElements) {
							if(object instanceof EObject){
								//TODO implement
							}
						}
					}
				}
			}
		});
		btnRemoveQualitySmell.setText("Remove Concrete Smell");
		
		TableViewer tableViewerSmells = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		tableSmells = tableViewerSmells.getTable();
		tableSmells.setLinesVisible(true);
		tableSmells.setHeaderVisible(true);
		tableSmells.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewerSmells, SWT.NONE);
		TableColumn tblclmnConcreteSmells = tableViewerColumn_1.getColumn();
		tblclmnConcreteSmells.setWidth(280);
		tblclmnConcreteSmells.setText("Concrete Smells");
		new Label(container, SWT.NONE);
		m_bindingContext = initDataBindings();

		return container;
	}

	/**
	 * Initialize the preference page.
	 */
	@Override
	public void init(IWorkbench workbench) {
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceTracker<QualitySmellModel,QualitySmellModel> tracker = new ServiceTracker<>(bundleContext, QualitySmellModel.class, null);
		tracker.open();
		smellModel = tracker.getService();
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{Literals.EPACKAGE__NS_URI});
		tableViewerMetamodels.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewerMetamodels.setContentProvider(listContentProvider);
		//
		IObservableList smellModelSmellingMetamodelsObserveList = EMFObservables.observeList(Realm.getDefault(), smellModel, SmellPackage.Literals.QUALITY_SMELL_MODEL__SMELLING_METAMODELS);
		tableViewerMetamodels.setInput(smellModelSmellingMetamodelsObserveList);
		//
		return bindingContext;
	}
}
