/**
 * 
 */
package org.qualitune.evolution.cods.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.qualitune.evolution.megamodel.architecture.InstanceModel;
import org.qualitune.evolution.megamodel.architecture.TransformationModel;

/**
 * @author jreimann
 *
 */
public class ObservableModelLabelProvider extends LabelProvider implements ITableLabelProvider {

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
		if(model != null){
			URI uri = model.eResource().getURI();
			IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true));
			if((member != null) && (member instanceof IFile)){
				return PlatformUI.getWorkbench().getEditorRegistry().getImageDescriptor(uri.lastSegment()).createImage();
			}
		}
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
}
