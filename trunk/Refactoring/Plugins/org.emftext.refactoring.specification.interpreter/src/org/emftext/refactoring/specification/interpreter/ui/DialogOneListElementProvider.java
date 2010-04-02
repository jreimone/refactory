/**
 * 
 */
package org.emftext.refactoring.specification.interpreter.ui;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.util.StringUtil;

/**
 * This {@link IValueProvider value provider} provides one element of a list within a dialog.
 * 
 * @author Jan Reimann
 *
 */
public class DialogOneListElementProvider implements IValueProvider<List<EObject>, EObject> {

	private EObject owner;
	private Mapping mapping;
	private int returnCode;

	public DialogOneListElementProvider(EObject owner, Mapping mapping){
		this.owner = owner;
		this.mapping = mapping;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IStructuralFeatureValueProvider#provideValue(java.util.List)
	 */
	public EObject provideValue(List<EObject> elements) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		FilteredEObjectsSelectionDialog dialog = new FilteredEObjectsSelectionDialog(shell, elements, mapping);
		ILabelProvider provider = new LabelProvider() {
			
			@Override
			public Image getImage(Object object) {
				EObject element = (EObject) object;
				ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
				adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
				adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
				adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
				AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
				Image image = labelProvider.getImage(element);
				if (image != null) {
					return image;
				}
				return super.getImage(object);
			}

			@Override
			public String getText(Object element) {
				EObject object = (EObject) element;
				ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
				adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
				adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
				adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
				AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
				String label = labelProvider.getText(object);
				if(label != null){
					return label;
				}
				return super.getText(element);
			}

		};
		dialog.setListLabelProvider(provider);
		dialog.setDetailsLabelProvider(provider);
		dialog.setTitle(StringUtil.convertCamelCaseToWords(mapping.getName()));
		dialog.setInitialPattern("**");
		returnCode = dialog.open();
		if(returnCode == FilteredItemsSelectionDialog.CANCEL) {
			return null;
		}
		EObject selectedElement = (EObject) dialog.getFirstResult();
		return selectedElement;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IValueProvider#getReturnCode()
	 */
	public int getReturnCode() {
		return returnCode;
	}

}
