package org.emftext.refactoring.smell.ui.preferences;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public abstract class AbstractPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {
	private DataBindingContext m_bindingContext;

	private Table table;
	private TableViewer tableViewer;
	
	/**
	 * Create the preference page.
	 */
	public AbstractPreferencePage() {
		setDescription(getDescription());
		setTitle(getTitle());
	}
	
	public abstract EObject getModel();
	
	public abstract EAttribute getExposedAttribute();
	
	public abstract EReference getListReference();
	
	public abstract EList<EObject> getList();
	
	public abstract EObject createNewListElement();
	
	public abstract void setNewValue(Object element, Object value);
	
	public abstract Object getCurrentValue(Object element);
	
	public abstract String getDescription();
	
	public abstract String getTitle();
	
	public abstract String getColumnTitle();
	
	public abstract String getAddButtonText();
	
	public abstract String getRemoveButtonText();

	/**
	 * Create contents of the preference page.
	 * @param parent
	 */
	@Override
	public Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout gl_container = new GridLayout(2, false);
		container.setLayout(gl_container);
		
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		final TextCellEditor textEditor = new TextCellEditor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn.setEditingSupport(new EditingSupport(tableViewer) {
			
			@Override
			protected void setValue(Object element, Object value) {
				setNewValue(element, value);
			}
			
			@Override
			protected Object getValue(Object element) {
				return getCurrentValue(element);
			}
			
			@Override
			protected CellEditor getCellEditor(Object element) {
				return textEditor;
			}
			
			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		TableColumn tblclmnGenericQualitySmell = tableViewerColumn.getColumn();
		tblclmnGenericQualitySmell.setWidth(280);
		tblclmnGenericQualitySmell.setText(getColumnTitle());
		
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
				EObject newElement = createNewListElement();
				getList().add(newElement);
				tableViewer.editElement(newElement, 0);
			}
		});
		btnAddQualitySmell.setText(getAddButtonText());
		
		Button btnRemoveQualitySmell = new Button(composite, SWT.NONE);
		btnRemoveQualitySmell.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tableViewer.getSelection();
				if(selection != null){
					if(selection instanceof StructuredSelection){
						List<?> selectedElements = ((StructuredSelection) selection).toList();
						for (Object object : selectedElements) {
							if(object instanceof EObject){
								getList().remove((EObject) object);
							}
						}
					}
				}
			}
		});
		btnRemoveQualitySmell.setText(getRemoveButtonText());
		m_bindingContext = initDataBindings();

		return container;
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {
//		if(smellModel == null){
//			smellModel = ModelRegistration.getDefault().getSmellmodel();
//		}
	}
	
	protected DataBindingContext initDataBindings() {
//		Bundle bundle = FrameworkUtil.getBundle(getClass());
//		BundleContext bundleContext = bundle.getBundleContext();
//		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(bundleContext);
//		QualitySmellModel qualitySmellModel = serviceContext.get(QualitySmellModel.class);
		
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{getExposedAttribute()});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableList smellModelSmellsObserveList = EMFObservables.observeList(Realm.getDefault(), getModel(), getListReference());
		tableViewer.setInput(smellModelSmellsObserveList);
		//
		return bindingContext;
	}
}
