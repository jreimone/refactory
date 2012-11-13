/**
 * 
 */
package org.qualitune.evolution.cods.creation;

import java.io.IOException;
import java.util.Collections;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IPathVariableManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.framework.Bundle;
import org.qualitune.evolution.cods.kinds.IKindsExtensionPoint;
import org.qualitune.evolution.megamodel.MegamodelPackage;
import org.qualitune.evolution.megamodel.architecture.ArchitectureFactory;
import org.qualitune.evolution.megamodel.architecture.InstanceModel;
import org.qualitune.evolution.megamodel.architecture.MegaModel;
import org.qualitune.evolution.megamodel.architecture.MetaMetaModel;
import org.qualitune.evolution.megamodel.architecture.MetaModel;
import org.qualitune.evolution.megamodel.architecture.Model;
import org.qualitune.evolution.megamodel.architecture.ReferenceModel;
import org.qualitune.evolution.megamodel.architecture.TransformationModel;
import org.qualitune.evolution.megamodel.cods.CODS;
import org.qualitune.evolution.megamodel.cods.CodsFactory;

/**
 * @author jreimann
 *
 */
@SuppressWarnings("restriction")
public class MegamodelRegistrationProcessor extends XMIResourceFactoryImpl{

	private static final String MEGAMODEL_FILE	= "megamodel.cods";
	public static final String MEGAMODEL_STRING	= "http://qualitune.org/" + MEGAMODEL_FILE;
	public static final URI MEGAMODEL_URI		= URI.createURI(MEGAMODEL_STRING);

	@Inject
	private IWorkspace workspace;

	private Resource codsResource;

	@Override
	public Resource createResource(URI uri) {
		if(uri.equals(MEGAMODEL_URI)){
			return codsResource;
		}
		return super.createResource(uri);
	}

	@Execute
	public void register(IEclipseContext context) {
		CODS megaModel = loadMegaModel();
		codsResource = megaModel.eResource();
		context.set(MegaModel.class, megaModel);
		context.set(CODS.class, megaModel);
		registerInEMF();
		workspace.addResourceChangeListener(new WorkspaceModelChangeListener(megaModel));
	}

	private void registerInEMF() {
		URIConverter.URI_MAP.put(MEGAMODEL_URI, codsResource.getURI());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(MEGAMODEL_URI.fileExtension(), this);
	}

	/**
	 * Loads an existing mega model or creates a new one.
	 * @return
	 */
	private CODS loadMegaModel() {
		ResourceSet rs = new ResourceSetImpl();
		Bundle bundle = Platform.getBundle("org.qualitune.evolution.cods");
		CODS cods = null;
		if(bundle != null){
			IPath stateLocation = Platform.getStateLocation(bundle);
			IPath megamodelFilePath = stateLocation.append("/" + MEGAMODEL_FILE);
			Resource resource = null;
			if(!megamodelFilePath.toFile().exists()){
				URI uri = URI.createFileURI(megamodelFilePath.toString());
				resource = rs.createResource(uri);
				cods = createMegaModel(resource);
				try {
					resource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				URI uri = URI.createFileURI(megamodelFilePath.toString());
				resource = rs.getResource(uri, true);
				cods = (CODS) resource.getContents().get(0);
			}
		}
		cods.eAdapters().add(new MegaModelContentAdapter());
		return cods;
	}

	/**
	 * This is a first implementation for creating the megamodel. In future, this has to be persisted in a database.
	 * @param megaModel
	 */
	private CODS createMegaModel(Resource resource) {
		CODS cods = CodsFactory.eINSTANCE.createCODS();
		resource.getContents().add(cods);
		registerExistingModels(cods);
		return cods;
	}

	/**
	 * Traverses the workspace and registers existing models.
	 * @param megaModel
	 */
	private void registerExistingModels(final CODS megaModel) {
		MetaMetaModel ecoreMetaMetaModel = ArchitectureFactory.eINSTANCE.createMetaMetaModel();
		ecoreMetaMetaModel.setPackage(EcorePackage.eINSTANCE);
		ecoreMetaMetaModel.setConformsTo(ecoreMetaMetaModel);
		megaModel.getModels().add(ecoreMetaMetaModel);
		MetaModel codsMetaModel = ArchitectureFactory.eINSTANCE.createMetaModel();
		codsMetaModel.setConformsTo(ecoreMetaMetaModel);
		codsMetaModel.setPackage(MegamodelPackage.eINSTANCE);
		megaModel.setConformsTo(codsMetaModel);
		megaModel.getModels().add(codsMetaModel);
		IWorkspaceRoot root = workspace.getRoot();
		final IPathVariableManager pathVariableManager = workspace.getPathVariableManager();
		try {
			IProject[] projects = root.getProjects();
			for (IProject project : projects) {
				if(project.isOpen()){
					project.accept(new IResourceVisitor() {
						@Override
						public boolean visit(IResource resource) throws CoreException {
							IFile file = (IFile) resource.getAdapter(IFile.class);
							if(file != null){
								java.net.URI locationURI = file.getLocationURI();
								IPath rawLocation = file.getRawLocation();
								java.net.URI rawLocationURI = file.getRawLocationURI();
								java.net.URI uri = pathVariableManager.resolveURI(locationURI);
								registerModelInFile(megaModel, file);
							}
							return true;
						}
					});
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param megaModel
	 * @param ecoreMetaMetaModel
	 * @param file
	 * @return returns <code>true</code> when a new model was registered in the megamodel and <code>false</code> otherwise.
	 */
	protected static boolean registerModelInFile(CODS megaModel, IFile file) {
		if(megaModel == null || file == null){
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
//			Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(uri);
			Object factory = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(uri.fileExtension());
			if(factory != null){
				try {
					Resource resource = rs.getResource(uri, true);
					if(resource != null){
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
							Model newModel = createModelForEObject(model);
							newModel.setConformsTo(existentMetamodel);
							megaModel.getModels().add(newModel);
							modified = true;
						}
					}
				} catch (Exception e) {
					// no model found, just don't include it in the megamodel
					e.printStackTrace();
					System.out.println();
				}
			}
		}
		return modified;
	}

	private static Model createModelForEObject(EObject model){
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