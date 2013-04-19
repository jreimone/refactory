package org.emftext.refactoring.smell.wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class RoleMappingPage extends WizardPage {
	private DataBindingContext m_bindingContext;

	private EPackage metamodel;
	private List<RoleMapping> roleMappings;
	private Table table;
	private TableViewer tableViewer;

	protected RoleMapping selectedRoleMapping;

	/**
	 * Create the wizard.
	 */
	public RoleMappingPage() {
		super("Refactoring Selection Page");
		setDescription("...or don't select anything for just specifying a concrete quality smell without providing the opportunity to resolve the smell by a refactoring.");
		setTitle("Select a Refactoring");
		roleMappings = new ArrayList<RoleMapping>();
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
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if(selection instanceof IStructuredSelection){
					Object firstElement = ((IStructuredSelection) selection).getFirstElement();
					if(firstElement instanceof RoleMapping){
						selectedRoleMapping = (RoleMapping) firstElement;
						setPageComplete(true);
						IWizardPage nextPage = getNextPage();
						if(nextPage instanceof CalculationsPage){
							((CalculationsPage) nextPage).setRoleMapping(selectedRoleMapping);
						}
					}
				}
			}
		});
		table = tableViewer.getTable();
		m_bindingContext = initDataBindings();
		setPageComplete(true);
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(listContentProvider.getKnownElements(), RoleMapping.class, "name");
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMap){
			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				if(element instanceof RoleMapping){
					ImageDescriptor descriptor = IRoleMappingRegistry.INSTANCE.getImageForMapping((RoleMapping) element);
					if(descriptor != null){
						return descriptor.createImage();
					}
				}
				return super.getColumnImage(element, columnIndex);
			}
			
		});
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableList selfList = Properties.selfList(RoleMapping.class).observe(roleMappings);
		tableViewer.setInput(selfList);
		//
		return bindingContext;
	}

	protected void setMetamodel(EPackage metamodel){
		if(!metamodel.equals(this.metamodel)){
			this.metamodel = metamodel;
			setDescription("Select a registered " + metamodel.getName() + " refactoring for which a smell should be defined...or don't select anything for just specifying a concrete quality smell without providing the opportunity to resolve the smell by a refactoring.");
			initRoleMappings();
		} 
	}

	private void initRoleMappings() {
		roleMappings.clear();
		Map<String, RoleMapping> roleMappingsForUri = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(metamodel.getNsURI());
		if(roleMappingsForUri != null){
			Collection<RoleMapping> values = roleMappingsForUri.values();
			if(values != null){
				roleMappings.addAll(values);
				table.update();
				tableViewer.refresh();
			}
		}
	}
}
