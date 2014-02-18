package org.modelrefactoring.evolution.cods.creation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.modelrefactoring.evolution.cods.kinds.IKindsExtensionPoint;
import org.modelrefactoring.evolution.megamodel.architecture.ArchitectureFactory;
import org.modelrefactoring.evolution.megamodel.architecture.InstanceModel;
import org.modelrefactoring.evolution.megamodel.architecture.MetaModel;
import org.modelrefactoring.evolution.megamodel.architecture.Model;
import org.modelrefactoring.evolution.megamodel.architecture.ReferenceModel;
import org.modelrefactoring.evolution.megamodel.architecture.TransformationModel;
import org.modelrefactoring.evolution.megamodel.cods.CODS;

public abstract class CODSUtil {

	public static boolean isResourceHidden(IResource resource) {
		// exclude all folders being hidden in the workspace or in the file system
		ResourceAttributes attributes = resource.getResourceAttributes();
		boolean hiddenInWorkspace = resource.isHidden();
		boolean semanticallyHiddenInFilesystem = resource.getName().startsWith(".");
		if(resource instanceof IFolder){
			semanticallyHiddenInFilesystem = semanticallyHiddenInFilesystem || resource.getName().equals("bin");
		}
		boolean hiddenInFilesystem = attributes != null && attributes.isHidden();
		return hiddenInWorkspace || semanticallyHiddenInFilesystem || hiddenInFilesystem;
	}

	/**
	 * @param megaModel
	 * @param ecoreMetaMetaModel
	 * @param file
	 * @return returns <code>true</code> when a new model was registered in the megamodel and <code>false</code> otherwise.
	 */
	public static boolean registerModelInFile(CODS megaModel, IFile file) {
		if(megaModel == null || file == null || isResourceHidden(file)){
			return false;
		}
		ResourceSet rs = megaModel.eResource().getResourceSet();
		boolean modified = false;
		if(file != null){
			URI uri = null;
			if(file.isLinked()){
				uri = URI.createFileURI(file.getLocation().toString());
			} else {
				uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			}
			//			Factory factory2 = Resource.Factory.Registry.INSTANCE.getFactory(uri);
			//			Object factory = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(uri.fileExtension());
			try {
				Resource resource = rs.getResource(uri, true);
				if(resource != null){
					//					if(resource != null){
					EObject model = resource.getContents().get(0);
					EPackage metamodel = model.eClass().getEPackage();
					ReferenceModel existentMetamodel = megaModel.getReferenceModelByEPackage(metamodel);
					if(existentMetamodel == null){
						existentMetamodel = ArchitectureFactory.eINSTANCE.createMetaModel();
						existentMetamodel.setConformsTo(megaModel.getMetaMetaModel());
						if(model instanceof EPackage){
							existentMetamodel.setPackage((EPackage) model);
						} else {
							existentMetamodel.setPackage(metamodel);
						}
						megaModel.getModels().add(existentMetamodel);
						modified = true;
					}
					if(megaModel.getTerminalModelByEObject(model) == null){
						Model newModel = CODSUtil.createModelForEObject(model);
						newModel.setConformsTo(existentMetamodel);
						megaModel.getModels().add(newModel);
						modified = true;
					}
					//					}
				}
			} catch (Exception e) {
				// no model found, just don't include it in the megamodel
				//				ILog log = Platform.getLog(Platform.getBundle("org.modelrefactoring.evolution.cods"));
				//				if(log != null){
				//					log.log(new Status(IStatus.WARNING, "org.modelrefactoring.evolution.cods", "no model: " + uri.toString(), e));
				//				}
				System.err.println("no model: " + uri.toString());
			}
		}
		return modified;
	}

	public static Model createModelForEObject(EObject model){
		if(model instanceof EPackage){
			MetaModel metaModel = ArchitectureFactory.eINSTANCE.createMetaModel();
			metaModel.setPackage((EPackage) model);
			return metaModel;
		}
		String nsURI = model.eClass().getEPackage().getNsURI();
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(IKindsExtensionPoint.ID);
		for (IConfigurationElement configurationElement : configurationElements) {
			String nsUriAttrib = configurationElement.getAttribute(IKindsExtensionPoint.ATTRIB_NS_URI);
			if(nsUriAttrib != null){
				if(nsUriAttrib.equals(nsURI)){
					String instanceAttrib = configurationElement.getAttribute(IKindsExtensionPoint.ATTRIB_MODEL_INSTANCE);
					String transformationAttrib = configurationElement.getAttribute(IKindsExtensionPoint.ATTRIB_MODEL_TRANSFORMATION);
					if(transformationAttrib != null){
						TransformationModel transformationModel = ArchitectureFactory.eINSTANCE.createTransformationModel();
						transformationModel.setTransformation(model);
						return transformationModel;
					}
				}
			}
		}
		InstanceModel instanceModel = ArchitectureFactory.eINSTANCE.createInstanceModel();
		instanceModel.setModel(model);
		return instanceModel;
	}

}
