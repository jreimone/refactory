package org.emftext.refactoring.smell.wizard;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
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
		container.setLayout(new GridLayout(2, false));
		
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
						setPageComplete();
					}
				}
			}
		});
		Combo combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		m_bindingContext = initDataBindings();
		setPageComplete(false);
	}
	
	private void setPageComplete() {
		boolean complete = selectedSmell != null;
		setPageComplete(complete);
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
		return bindingContext;
	}
}
