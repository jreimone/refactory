package org.emftext.refactoring.smell.ui.preferences;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage.Literals;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellPackage;
import org.emftext.refactoring.smell.wizard.CalculationsWithRolemappingPage;
import org.emftext.refactoring.smell.wizard.NewConcreteSmellWizard;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class ConcreteSmellPreferencePage extends PreferencePage implements
IWorkbenchPreferencePage {
	private DataBindingContext m_bindingContext;

	private Table tableMetamodels;
	private TableViewer tableViewerMetamodels;

	@Inject
	private QualitySmellModel smellModel;

	private Table tableSmells;

	private EPackage selectedMetamodel;
	private List<ConcreteQualitySmell> concreteSmells;
	private TableViewer tableViewerSmells;

	/**
	 * Create the preference page.
	 */
	public ConcreteSmellPreferencePage() {
		setDescription(getDescription());
		setTitle(getTitle());
		concreteSmells = new ArrayList<ConcreteQualitySmell>();
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
		tableViewerMetamodels.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection() instanceof IStructuredSelection){
					Object firstElement = ((IStructuredSelection) event.getSelection()).getFirstElement();
					if(firstElement instanceof EPackage){
						selectedMetamodel = (EPackage) firstElement;
						concreteSmells.clear();
						concreteSmells.addAll(smellModel.getSmellsForMetamodel(selectedMetamodel));
						tableViewerSmells.refresh();
					}
				}
			}
		});
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
				ISelection selection2 = tableViewerSmells.getSelection();
				if(selection2 != null && !selection2.isEmpty()){
					if(selection2 instanceof StructuredSelection){
						List<?> selectedElements = ((StructuredSelection) selection2).toList();
						for (Object object : selectedElements) {
							if(object instanceof ConcreteQualitySmell){
								smellModel.getConcreteSmells().remove((ConcreteQualitySmell) object);
							}
						}
					}
				} else if(selection != null && !selection.isEmpty()){
					if(selection instanceof StructuredSelection){
						List<?> selectedElements = ((StructuredSelection) selection).toList();
						for (Object object : selectedElements) {
							if(object instanceof EPackage){
								List<ConcreteQualitySmell> smellsForMetamodel = smellModel.getSmellsForMetamodel((EPackage) object);
								smellModel.getConcreteSmells().removeAll(smellsForMetamodel);
							}
						}
					}
				}
			}
		});
		btnRemoveQualitySmell.setText("Remove Concrete Smell");

		tableViewerSmells = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		tableSmells = tableViewerSmells.getTable();
		tableSmells.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				ISelection selection = tableViewerSmells.getSelection();
				if(selection instanceof IStructuredSelection){
					Object firstElement = ((IStructuredSelection) selection).getFirstElement();
					if(firstElement instanceof ConcreteQualitySmell){
						ConcreteQualitySmell smell = (ConcreteQualitySmell) firstElement;
						CalculationsWithRolemappingPage page = new CalculationsWithRolemappingPage(smell);
						Wizard wizard = new Wizard() {
							@Override
							public boolean performFinish() {
								return true;
							}
						};
						wizard.setWindowTitle("Edit Concrete Quality Smell");
						wizard.addPage(page);
						WizardDialog dialog = new WizardDialog(getShell(), wizard);
						dialog.open();
					}
				}
			}
		});
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
		ServiceTracker<QualitySmellModel,QualitySmellModel> tracker = new ServiceTracker<QualitySmellModel,QualitySmellModel>(bundleContext, QualitySmellModel.class, null);
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
		ObservableListContentProvider listContentProvider_1 = new ObservableListContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(listContentProvider_1.getKnownElements(), ConcreteQualitySmell.class, "concreteName");
		tableViewerSmells.setLabelProvider(new ObservableMapLabelProvider(observeMap));
		tableViewerSmells.setContentProvider(listContentProvider_1);
		//
		IObservableList selfList = Properties.selfList(ConcreteQualitySmell.class).observe(concreteSmells);
		tableViewerSmells.setInput(selfList);
		//
		return bindingContext;
	}
}
