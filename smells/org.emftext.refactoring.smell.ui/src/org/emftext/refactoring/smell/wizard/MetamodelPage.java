package org.emftext.refactoring.smell.wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;

public class MetamodelPage extends WizardPage {
	private DataBindingContext m_bindingContext;

	private List<EPackage> availableMetamodels;
	
	private static AdapterFactoryLabelProvider labelProvider;
	private Table table;
	private TableViewer tableViewer;

	/**
	 * Create the wizard.
	 */
	public MetamodelPage() {
		super("wizardPage");
		setTitle("Select Metamodel");
		setDescription("Select a metamodel for which a smeel should be registered");
		initLabelProvider();
		initMetamodels();
	}

	private void initLabelProvider() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	@SuppressWarnings("unchecked")
	private void initMetamodels() {
		availableMetamodels = new ArrayList<>();
//		availableMetamodels.addAll((Collection<? extends EPackage>) EPackage.Registry.INSTANCE.values());
		Collection<Object> values = EPackage.Registry.INSTANCE.values();
		for (Object object : values) {
			if(object instanceof EPackage){
				availableMetamodels.add((EPackage) object);
			}
		}
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		m_bindingContext = initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider_1 = new ObservableListContentProvider();
		IObservableMap observeMap_1 = PojoObservables.observeMap(listContentProvider_1.getKnownElements(), EPackage.class, "nsURI");
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMap_1){
			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				return labelProvider.getColumnImage(element, columnIndex);
			}
		});
		tableViewer.setContentProvider(listContentProvider_1);
		//
		IObservableList selfList = Properties.selfList(EPackage.class).observe(availableMetamodels);
		tableViewer.setInput(selfList);
		//
		return bindingContext;
	}
}
