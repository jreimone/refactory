package org.emftext.refactoring.smell.wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.smell.ConcreteQualitySmell;

public class CalculationsWithRolemappingPage extends CalculationsPage {

	public CalculationsWithRolemappingPage(ConcreteQualitySmell concreteSmell) {
		super(concreteSmell);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		Composite calculationPageComposite = (Composite) getControl();
		ConcreteQualitySmell concreteSmell = getConcreteSmell();
		EPackage metamodel = concreteSmell.getMetamodel();
		Map<String, RoleMapping> roleMappings = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(metamodel.getNsURI());
		List<RoleMapping> rolemappingsForMetamodel = new ArrayList<RoleMapping>(roleMappings.values());
		
		Label lblRefactoringToResolve = new Label(calculationPageComposite, SWT.NONE);
		lblRefactoringToResolve.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRefactoringToResolve.setText("Refactoring to resolve Smell:");

		ComboViewer comboViewer_1 = new ComboViewer(calculationPageComposite, SWT.READ_ONLY);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewer_1.setContentProvider(new IStructuredContentProvider() {
			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof List<?>){
					List<?> elements = (List<?>) inputElement;
					if(elements != null && elements.size() > 0){
						if(elements.get(0) instanceof RoleMapping){
							@SuppressWarnings("unchecked")
							List<RoleMapping> rolemappings = (List<RoleMapping>) elements;
							return rolemappings.toArray(new RoleMapping[]{});
						}
					}
				}
				return new Object[0];
			}
			public void dispose() {
			}
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				viewer.refresh();
			}
		});
		comboViewer_1.setLabelProvider(new LabelProvider(){
			@Override
			public Image getImage(Object element) {
				if(element instanceof RoleMapping){
					ImageDescriptor descriptor = IRoleMappingRegistry.INSTANCE.getImageForMapping((RoleMapping) element);
					return descriptor.createImage();
				}
				return super.getImage(element);
			}
			@Override
			public String getText(Object element) {
				if(element instanceof RoleMapping){
					return ((RoleMapping) element).getName();
				}
				return super.getText(element);
			}
			
		});
		comboViewer_1.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if(selection instanceof IStructuredSelection){
					Object firstElement = ((IStructuredSelection) selection).getFirstElement();
					if(firstElement instanceof RoleMapping){
						getConcreteSmell().setRefactoring((RoleMapping) firstElement);
					}
				}
			}
		});
		comboViewer_1.setInput(rolemappingsForMetamodel);
		final RoleMapping rolemapping = getConcreteSmell().getRefactoring();
		if(rolemapping != null){
			RoleMapping temp = roleMappings.get(rolemapping.getName());
			int index = rolemappingsForMetamodel.indexOf(temp);
			combo_1.select(index);
		}
	}
}
