/**
 * 
 */
package org.emftext.refactoring.specification.interpreter.ui;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IStructuralFeatureValueProvider;
import org.emftext.refactoring.util.StringUtil;

/**
 * This {@link IStructuralFeatureValueProvider value provider} provides one element of a list within a dialog.
 * 
 * @author Jan Reimann
 *
 */
public class DialogOneListElementProvider implements IStructuralFeatureValueProvider {

	private EObject owner;
	private Mapping mapping;

	public DialogOneListElementProvider(EObject owner, Mapping mapping){
		this.owner = owner;
		this.mapping = mapping;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IStructuralFeatureValueProvider#provideValue(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@SuppressWarnings("unchecked")
	public Object provideValue(EStructuralFeature structuralFeature) {
		Object value = owner.eGet(structuralFeature);
		if(value instanceof List<?>){
			return provideValue((List<EObject>) value);
		}
		if(value instanceof EObject){
			return Arrays.asList(new EObject[]{(EObject) value});
		}
		return null;
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
				org.eclipse.emf.edit.provider.ComposedAdapterFactory adapterFactory = new org.eclipse.emf.edit.provider.ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
				adapterFactory.addAdapterFactory(new org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory());
				adapterFactory.addAdapterFactory(new org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory());
				adapterFactory.addAdapterFactory(new org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory());
				org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider labelProvider = new org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider(adapterFactory);
				Image image = labelProvider.getImage(element);
				if (image != null) {
					return image;
				}
				return super.getImage(object);
			}

			@Override
			public String getText(Object element) {
				EObject object = (EObject) element;
				EcoreItemProviderAdapterFactory factory = new EcoreItemProviderAdapterFactory();
				if(factory.isFactoryForType(IItemLabelProvider.class)){
					IItemLabelProvider labelProvider = (IItemLabelProvider) factory.adapt(object, IItemLabelProvider.class);
					if(labelProvider != null){
						return labelProvider.getText(object);
					}
				}
				return super.getText(element);
			}

		};
		dialog.setListLabelProvider(provider);
		dialog.setDetailsLabelProvider(provider);
		dialog.setTitle(StringUtil.convertCamelCaseToWords(mapping.getName()));
		dialog.setInitialPattern("**");
		int returnCode = dialog.open();
		while (returnCode == FilteredItemsSelectionDialog.CANCEL) {
			returnCode = dialog.open();
		}
		EObject selectedElement = (EObject) dialog.getFirstResult();
		return selectedElement;
	}

}
