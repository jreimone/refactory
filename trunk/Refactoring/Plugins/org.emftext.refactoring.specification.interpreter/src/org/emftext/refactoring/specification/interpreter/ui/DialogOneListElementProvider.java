/**
 * 
 */
package org.emftext.refactoring.specification.interpreter.ui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
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
			public Image getImage(Object element) {
				EObject object = (EObject) element;
				EcoreItemProviderAdapterFactory factory = new EcoreItemProviderAdapterFactory();
				if(factory.isFactoryForType(IItemLabelProvider.class)){
					IItemLabelProvider labelProvider = (IItemLabelProvider) factory.adapt(object, IItemLabelProvider.class);
					if(labelProvider != null){
						Object image = labelProvider.getImage(object);
						if(image instanceof Image){
							return (Image) image;
						}
						if(image instanceof URL){
							URL imageUrl = null;
							try {
								imageUrl = (URL) image;
								InputStream stream;
								stream = imageUrl.openStream();
								ImageLoader loader = new ImageLoader();
								ImageData[] imgData = loader.load(stream);
								stream.close();
								Display display = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay();
								Image newImage = new Image(display, imgData[0]);
								return newImage;
							} catch (IOException e) {
								System.out.println("couldn't load the image " + imageUrl);
							}
						}
					}
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
