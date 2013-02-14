package org.emftext.refactoring.smell.wizard;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.Quality;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.QualitySmell;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellFactory;
import org.emftext.refactoring.smell.SmellPackage.Literals;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class CalculationsPage extends WizardPage {
	private DataBindingContext m_bindingContext;

	private QualitySmellModel smellModel;

	private QualitySmell selectedSmell;
	private ConcreteQualitySmell concreteSmell;
	private Text text;
	private ComboViewer comboViewer;
	
	private RoleMapping selectedRoleMapping;
	private QualityCalculation currentSelectedCalculation;
	
	private Table table;
	private TableViewer tableViewer;
	
	private ComboBoxViewerCellEditor comboBoxCellEditor;
	/**
	 * Create the wizard.
	 */
	public CalculationsPage() {
		super("Quality Specification Page");
		setTitle("Specify Qualities");
		setDescription("Select the qualities for the smell to be registered");
		init();
	}

	private void init() {
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceTracker<QualitySmellModel,QualitySmellModel> tracker = new ServiceTracker<>(bundleContext, QualitySmellModel.class, null);
		tracker.open();
		smellModel = tracker.getService();
		concreteSmell = SmellFactory.eINSTANCE.createConcreteQualitySmell();
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		GridLayout gl_container = new GridLayout(2, false);
		container.setLayout(gl_container);
		
		Label lblNameOfConcrete = new Label(container, SWT.NONE);
		lblNameOfConcrete.setText("Name of concrete Smell:");
		
		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		comboViewer = new ComboViewer(container, SWT.READ_ONLY);
		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if(selection instanceof IStructuredSelection){
					Object firstElement = ((IStructuredSelection) selection).getFirstElement();
					if(firstElement instanceof QualitySmell){
						selectedSmell = (QualitySmell) firstElement;
						concreteSmell.setGenericSmell(selectedSmell);
						setPageComplete();
					}
				}
			}
		});
		Combo combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblWhichQualitiesAre = new Label(container, SWT.WRAP);
		lblWhichQualitiesAre.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 2, 1));
		lblWhichQualitiesAre.setText("Which qualities are influenced by this concrete smell? \r\nThe sum of all influence factors must always amount 1.0.");
		
		Composite composite = new Composite(container, SWT.NONE);
		GridLayout gl_composite = new GridLayout(2, false);
		composite.setLayout(gl_composite);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection() instanceof IStructuredSelection){
					Object firstElement = ((IStructuredSelection) event.getSelection()).getFirstElement();
					if(firstElement instanceof QualityCalculation){
						currentSelectedCalculation = (QualityCalculation) firstElement;
					}
				}
			}
		});
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setBounds(0, 0, 85, 85);
		
		
		comboBoxCellEditor = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				if(element instanceof Quality){
					return ((Quality) element).getName();
				}
				return element == null ? "" : element.toString();
			}
		});
		tableViewerColumn.setEditingSupport(new EditingSupport(tableViewer){

			@Override
			protected CellEditor getCellEditor(Object element) {
				return comboBoxCellEditor;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}

			@Override
			protected Object getValue(Object element) {
				if(element instanceof QualityCalculation){
					if(((QualityCalculation) element).getQuality() != null){
						return ((QualityCalculation) element).getQuality().getName();
					}
				}
				return null;
			}

			@Override
			protected void setValue(Object element, Object value) {
				if(element instanceof QualityCalculation && value instanceof Quality){
					((QualityCalculation) element).setQuality((Quality) value);
				}
			}
		});
		TableColumn tblclmnGenericSmell = tableViewerColumn.getColumn();
		tblclmnGenericSmell.setWidth(250);
		tblclmnGenericSmell.setText("Generic Smell");
		
		final TextCellEditor textEditor = new TextCellEditor(table);
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_1.setEditingSupport(new EditingSupport(tableViewer){

			@Override
			protected CellEditor getCellEditor(Object element) {
				return textEditor;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}

			@Override
			protected Object getValue(Object element) {
				if(element instanceof QualityCalculation){
					return Float.toString(((QualityCalculation) element).getInfluence());
				}
				return element.toString();
			}

			@Override
			protected void setValue(Object element, Object value) {
				if(element instanceof QualityCalculation && value != null && value instanceof String){
					try {
						float parseFloat = Float.parseFloat((String) value);
						((QualityCalculation) element).setInfluence(parseFloat);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		TableColumn tblclmnInfluence = tableViewerColumn_1.getColumn();
		tblclmnInfluence.setWidth(100);
		tblclmnInfluence.setText("Influence");
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.marginHeight = 0;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		
		Button btnAddQuality = new Button(composite_1, SWT.NONE);
		btnAddQuality.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				currentSelectedCalculation = SmellFactory.eINSTANCE.createQualityCalculation();
				concreteSmell.getQualityCalculations().add(currentSelectedCalculation);
				tableViewer.editElement(currentSelectedCalculation, 0);
			}
		});
		btnAddQuality.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnAddQuality.setBounds(0, 0, 75, 25);
		btnAddQuality.setText("Add quality");
		
		Button btnRemoveQuality = new Button(composite_1, SWT.NONE);
		btnRemoveQuality.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tableViewer.getSelection();
				if(selection != null){
					if(selection instanceof IStructuredSelection){
						List<?> selectedElements = ((IStructuredSelection) selection).toList();
						for (Object object : selectedElements) {
							if(object instanceof QualityCalculation){
								concreteSmell.getQualityCalculations().remove((QualityCalculation) object);
								currentSelectedCalculation = null;
							}
						}
					}
				}
			}
		});
		btnRemoveQuality.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnRemoveQuality.setText("Remove quality");
		m_bindingContext = initDataBindings();
		// comment this out to let the design be parsed appropriately
		initDataBindingsForTableCombo();
		setPageComplete(false);
	}
	
	private void setPageComplete() {
		boolean complete = selectedSmell != null;
		setPageComplete(complete);
	}

	protected void setRoleMapping(RoleMapping roleMapping) {
		this.selectedRoleMapping = roleMapping;
		concreteSmell.setRefactoring(roleMapping);
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{Literals.QUALITY_SMELL__NAME});
		comboViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		comboViewer.setContentProvider(listContentProvider);
		//
		IObservableList smellModelSmellsObserveList = EMFObservables.observeList(Realm.getDefault(), smellModel, Literals.QUALITY_SMELL_MODEL__SMELLS);
		comboViewer.setInput(smellModelSmellsObserveList);
		//
		IObservableValue observeTextTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(text);
		IObservableValue concreteSmellConcreteNameObserveValue = EMFObservables.observeValue(concreteSmell, Literals.CONCRETE_QUALITY_SMELL__CONCRETE_NAME);
		bindingContext.bindValue(observeTextTextObserveWidget, concreteSmellConcreteNameObserveValue, null, null);
		//
		ObservableListContentProvider listContentProvider_1 = new ObservableListContentProvider();
		IObservableMap[] observeMaps_1 = EMFObservables.observeMaps(listContentProvider_1.getKnownElements(), new EStructuralFeature[]{Literals.QUALITY_CALCULATION__QUALITY, Literals.QUALITY_CALCULATION__INFLUENCE});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps_1){
			@Override
			public String getColumnText(Object element, int columnIndex) {
				if(element instanceof QualityCalculation){
					QualityCalculation qualityCalculation = (QualityCalculation) element;
					if(columnIndex == 0){
						Quality quality = qualityCalculation.getQuality();
						if(quality != null){
							return quality.getName();
						}
					} else {
						return String.valueOf(qualityCalculation.getInfluence());
					}
				}
				return "";
			}
			
		});
		tableViewer.setContentProvider(listContentProvider_1);
		//
		IObservableList concreteSmellQualityCalculationsObserveList = EMFObservables.observeList(Realm.getDefault(), concreteSmell, Literals.CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS);
		tableViewer.setInput(concreteSmellQualityCalculationsObserveList);
		//
		return bindingContext;
	}

	public void initDataBindingsForTableCombo() {
		ObservableListContentProvider listContentProvider_2 = new ObservableListContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(listContentProvider_2.getKnownElements(), Quality.class, "name");
		comboBoxCellEditor.setLabelProvider(new ObservableMapLabelProvider(observeMap));
		comboBoxCellEditor.setContentProvider(listContentProvider_2);
		IObservableList selfList = Properties.selfList(Quality.class).observe(smellModel.getQualities());
		comboBoxCellEditor.setInput(selfList);
	}
}
