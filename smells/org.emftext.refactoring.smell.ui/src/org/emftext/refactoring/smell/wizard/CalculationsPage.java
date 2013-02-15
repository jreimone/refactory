package org.emftext.refactoring.smell.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.CellEditor;
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
import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationModel;
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

	private QualityCalculation currentSelectedCalculation;

	private Table table;
	private TableViewer tableViewer;

	private ComboBoxViewerCellEditor comboBoxCellEditor;

	private CalculationModel calculationModel;

	private ComboBoxViewerCellEditor comboBoxCellEditor2;

	private List<String> inappropriateValues;
	
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
		ServiceTracker<CalculationModel,CalculationModel> tracker2 = new ServiceTracker<>(bundleContext, CalculationModel.class, null);
		tracker2.open();
		calculationModel = tracker2.getService();
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
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.horizontalIndent = 5;
		text.setLayoutData(gd_text);

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
		//		tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
		//			public Image getImage(Object element) {
		//				return null;
		//			}
		//			public String getText(Object element) {
		//				if(element instanceof Quality){
		//					return ((Quality) element).getName();
		//				}
		//				return element == null ? "" : element.toString();
		//			}
		//		});
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
				setPageComplete();
			}
		});
		TableColumn tblclmnGenericSmell = tableViewerColumn.getColumn();
		tblclmnGenericSmell.setWidth(100);
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
				setPageComplete();
			}

		});
		TableColumn tblclmnInfluence = tableViewerColumn_1.getColumn();
		tblclmnInfluence.setWidth(70);
		tblclmnInfluence.setText("Influence");

		comboBoxCellEditor2 = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_2.setEditingSupport(new EditingSupport(tableViewer) {
			@Override
			protected void setValue(Object element, Object value) {
				if(element instanceof QualityCalculation && value instanceof Calculation){
					QualityCalculation qCalculation = (QualityCalculation) element;
					Calculation referenceCalculation = (Calculation) value;
					try {
						Calculation concreteCalculation = referenceCalculation.getClass().newInstance();
						qCalculation.setCalculation(concreteCalculation);
						// take over the specified threshold value
						Calculation oldCalculation = qCalculation.getCalculation();
						Float threshold = oldCalculation.getThreshold();
						if(threshold != null){
							concreteCalculation.setThreshold(threshold);
						}
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				setPageComplete();
			}

			@Override
			protected Object getValue(Object element) {
				if(element instanceof QualityCalculation){
					QualityCalculation qCalculation = (QualityCalculation) element;
					Calculation calculation = qCalculation.getCalculation();
					if(calculation != null){
						return calculation.getName();
					}
				}
				return null;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return comboBoxCellEditor2;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		TableColumn tblclmnCalculation = tableViewerColumn_2.getColumn();
		tblclmnCalculation.setWidth(200);
		tblclmnCalculation.setText("Calculation");

		final TextCellEditor textEditor2 = new TextCellEditor(table);
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_3.setEditingSupport(new EditingSupport(tableViewer) {

			@Override
			protected void setValue(Object element, Object value) {
				if(element instanceof QualityCalculation && value != null && value instanceof String){
					try {
						float parseFloat = Float.parseFloat((String) value);
						QualityCalculation qualityCalculation = (QualityCalculation) element;
						Calculation calculation = qualityCalculation.getCalculation();
						calculation.setThreshold(parseFloat);
						// to notify label provider
						qualityCalculation.setCalculation(null);
						qualityCalculation.setCalculation(calculation);
					} catch (NumberFormatException e) {
						// do nothing
					}
				}
				setPageComplete();
			}

			@Override
			protected Object getValue(Object element) {
				if(element instanceof QualityCalculation){
					QualityCalculation qCalculation = (QualityCalculation) element;
					Calculation calculation = qCalculation.getCalculation();
					if(calculation != null){
						return String.valueOf(calculation.getThreshold());
					}
				}
				return null;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return textEditor2;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		TableColumn tblclmnThreshold = tableViewerColumn_3.getColumn();
		tblclmnThreshold.setWidth(70);
		tblclmnThreshold.setText("Threshold");

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
				setPageComplete();
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
				setPageComplete();
			}
		});
		btnRemoveQuality.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnRemoveQuality.setText("Remove quality");
		m_bindingContext = initDataBindings();
		// all the databindings for the combos contained in the table
		initDataBindingsForTableQualityCombo();
		initDataBindingsForTableCalculationCombo();
		setPageComplete();
	}

	private void setPageComplete() {
		inappropriateValues = new ArrayList<>();
		boolean smellNotNull = selectedSmell != null;
		checkInappropriateValue(smellNotNull, "a generic smell must be selected");
		boolean nameSet = concreteSmell.getConcreteName() != null && concreteSmell.getConcreteName().trim().length() > 0;
		checkInappropriateValue(nameSet, "a name must be specified");
		boolean atLeast1QualityCalc = concreteSmell.getQualityCalculations().size() > 0;
		checkInappropriateValue(atLeast1QualityCalc, "at least one quality must be referenced");
		boolean complete = smellNotNull && nameSet && atLeast1QualityCalc;
		if(complete){
			float sum = 0;
			List<QualityCalculation> qualityCalculations = concreteSmell.getQualityCalculations();
			for (QualityCalculation qualityCalculation : qualityCalculations) {
				sum += qualityCalculation.getInfluence();
			}
			boolean sumEquals1 = sum == 1.0;
			checkInappropriateValue(sumEquals1, "the sum of the influence values must amount 1.0");
			complete &= sumEquals1;
		}
		setPageComplete(complete);
		if(!complete){
			String errorMessage = "The following errors occurred: ";
			errorMessage += inappropriateValues.get(0);
			for (int i = 1; i < inappropriateValues.size(); i++) {
				errorMessage += ", " + inappropriateValues.get(i);
			}
			setErrorMessage(errorMessage);
		} else {
			setErrorMessage(null);
			
		}
	}

	public void checkInappropriateValue(boolean complete, String value) {
		if(!complete){
			inappropriateValues.add(value);
		}
	}

	protected void setRoleMapping(RoleMapping roleMapping) {
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
		IValidator validator = new IValidator() {
			@Override
			public IStatus validate(Object value) {
				if (value != null && value.toString().trim().length() > 0) {
					setPageComplete();
					return ValidationStatus.ok();
				}
				setPageComplete();
				return ValidationStatus.error("Name must not be empty");
			}
		};
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setBeforeSetValidator(validator);
		Binding bindValue = bindingContext.bindValue(observeTextTextObserveWidget, concreteSmellConcreteNameObserveValue, strategy, null);
		ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.LEFT);
		//
		ObservableListContentProvider listContentProvider_1 = new ObservableListContentProvider();
		IObservableMap[] observeMaps_1 = EMFObservables.observeMaps(listContentProvider_1.getKnownElements(), new EStructuralFeature[]{Literals.QUALITY_CALCULATION__QUALITY, Literals.QUALITY_CALCULATION__INFLUENCE, Literals.QUALITY_CALCULATION__CALCULATION});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps_1){
			@Override
			public String getColumnText(Object element, int columnIndex) {
				if(element instanceof QualityCalculation){
					QualityCalculation qualityCalculation = (QualityCalculation) element;
					Calculation calculation = qualityCalculation.getCalculation();
					switch (columnIndex) {
					case 0: // generic quality
						Quality quality = qualityCalculation.getQuality();
						if(quality != null){
							return quality.getName();
						}
						break;
					case 1: // influence
						return String.valueOf(qualityCalculation.getInfluence());
					case 2: // calculation
						if(calculation != null){
							return calculation.getName();
						}
						break;
					case 3: // threshold
						if(calculation != null){
							return String.valueOf(calculation.getThreshold());
						}
						break;
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

	private void initDataBindingsForTableQualityCombo() {
		initDataBindingsForTableCombo(comboBoxCellEditor, Quality.class, "name", smellModel.getQualities());
	}

	private void initDataBindingsForTableCalculationCombo() {
		initDataBindingsForTableCombo(comboBoxCellEditor2, Calculation.class, "name", calculationModel.getCalculations());
	}

	private void initDataBindingsForTableCombo(ComboBoxViewerCellEditor cellEditor, Class<?> listElementsType, String propertyToDisplay, List<?> listToObserve) {
		if(cellEditor == null || listElementsType == null || propertyToDisplay == null || propertyToDisplay.length() == 0 || listToObserve == null){
			return;
		}
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(listContentProvider.getKnownElements(), listElementsType, propertyToDisplay);
		cellEditor.setLabelProvider(new ObservableMapLabelProvider(observeMap));
		cellEditor.setContentProvider(listContentProvider);
		IObservableList selfList = Properties.selfList(listElementsType).observe(listToObserve);
		cellEditor.setInput(selfList);
	}

	public ConcreteQualitySmell getConcreteSmell() {
		return concreteSmell;
	}
}
