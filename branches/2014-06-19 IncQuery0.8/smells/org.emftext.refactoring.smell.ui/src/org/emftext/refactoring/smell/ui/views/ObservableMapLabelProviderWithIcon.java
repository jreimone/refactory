package org.emftext.refactoring.smell.ui.views;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.swt.graphics.Image;

public class ObservableMapLabelProviderWithIcon extends ObservableMapLabelProvider {

	public ObservableMapLabelProviderWithIcon(IObservableMap[] attributeMaps) {
		super(attributeMaps);
	}
	
	public ObservableMapLabelProviderWithIcon(IObservableMap attributeMap) {
		super(attributeMap);
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);
		Image image = labelProvider.getImage(element);
		if(image != null){
			return image;
		}
		return super.getColumnImage(element, columnIndex);
	}
}
