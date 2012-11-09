/**
 * 
 */
package org.qualitune.evolution.cods.ui;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.qualitune.evolution.megamodel.architecture.InstanceModel;

/**
 * @author jreimann
 *
 */
public class ObservableModelLabelProvider extends ObservableMapLabelProvider {

	private static AdapterFactoryLabelProvider labelProvider;
	
	static{
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}
	
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return labelProvider.getColumnImage(element, columnIndex);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof InstanceModel){
			EObject realModel = ((InstanceModel) element).getModel();
			return realModel.eResource().getURI().toString();
		}
		return labelProvider.getColumnText(element, columnIndex);
	}

	/**
	 * @param attributeMap
	 */
	public ObservableModelLabelProvider(IObservableMap attributeMap) {
		super(attributeMap);
	}

}
