package org.qualitune.evolution.cods.ui;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.qualitune.evolution.megamodel.architecture.InstanceModel;
import org.qualitune.evolution.megamodel.architecture.Model;
import org.qualitune.evolution.megamodel.architecture.TransformationModel;

/**
 * @author jreimann
 *
 */
public class ObservableModelMapLabelProvider extends ObservableMapLabelProvider {

	public ObservableModelMapLabelProvider(IObservableMap attributeMap) {
		super(attributeMap);
	}

	/**
	 * @param observeMaps
	 */
	public ObservableModelMapLabelProvider(IObservableMap[] observeMaps) {
		super(observeMaps);
	}

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
		EObject model = null;
		if(element instanceof InstanceModel){
			model = ((InstanceModel) element).getModel();
		} else if(element instanceof TransformationModel){
			model = ((TransformationModel) element).getTransformation();
		}
		if(model != null && columnIndex == 0){
			URI uri = model.eResource().getURI();
			IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true));
			if((member != null) && (member instanceof IFile)){
				return PlatformUI.getWorkbench().getEditorRegistry().getImageDescriptor(uri.lastSegment()).createImage();
			}
		}
		if(element instanceof Model && columnIndex == 1){
			element = ((Model) element).getConformsTo().getPackage();
		}
		return labelProvider.getColumnImage(element, columnIndex);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		EObject model = null;
		if(element instanceof InstanceModel){
			model = ((InstanceModel) element).getModel();
		} else if(element instanceof TransformationModel){
			model = ((TransformationModel) element).getTransformation();
		}
		if(model != null && columnIndex == 0){
			return model.eResource().getURI().toString();
		}
		if(element instanceof Model && columnIndex == 1){
			EPackage ePackage = ((Model) element).getConformsTo().getPackage();
			return ePackage.getNsURI();
		}
		return labelProvider.getColumnText(element, columnIndex);
	}
}
