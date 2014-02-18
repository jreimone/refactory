/**
 * 
 */
package org.modelrefactoring.evolution.cods.creation;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.modelrefactoring.evolution.megamodel.MegamodelPackage;
import org.modelrefactoring.evolution.megamodel.architecture.ArchitectureFactory;
import org.modelrefactoring.evolution.megamodel.architecture.MegaModel;
import org.modelrefactoring.evolution.megamodel.architecture.MetaMetaModel;
import org.modelrefactoring.evolution.megamodel.architecture.MetaModel;
import org.modelrefactoring.evolution.megamodel.cods.CODS;
import org.modelrefactoring.evolution.megamodel.cods.CodsFactory;
import org.osgi.framework.Bundle;

/**
 * @author jreimann
 *
 */
public class MegamodelRegistrationProcessor extends XMIResourceFactoryImpl{

	private static final String MEGAMODEL_FILE	= "megamodel.cods";
	public static final String MEGAMODEL_STRING	= "http://modelrefactoring.org/" + MEGAMODEL_FILE;
	public static final URI MEGAMODEL_URI		= URI.createURI(MEGAMODEL_STRING);

	//	@Inject
	private IWorkspace workspace;

	private Resource codsResource;

	@Override
	public Resource createResource(URI uri) {
		if(uri.equals(MEGAMODEL_URI)){
			return codsResource;
		}
		return super.createResource(uri);
	}

	// @Execute is needed because this class is registered as a processor and not in a fragment.e4xmi
	@Execute
	public void register(IEclipseContext context, IWorkspace workspace) {
		this.workspace = workspace;
		CODS megaModel = loadMegaModel();
		codsResource = megaModel.eResource();
		context.set(MegaModel.class, megaModel);
		context.set(CODS.class, megaModel);
		registerInEMF();
		//		workspace.addResourceChangeListener(new WorkspaceModelChangeListener(megaModel));
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
		Bundle bundle = Platform.getBundle("org.modelrefactoring.evolution.cods");
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
		//		cods.eAdapters().add(new MegaModelContentAdapter());
		return cods;
	}

	/**
	 * This is a first implementation for creating the megamodel. In future, this has to be persisted in a database.
	 * @param megaModel
	 */
	private CODS createMegaModel(Resource resource) {
		CODS cods = CodsFactory.eINSTANCE.createCODS();
		resource.getContents().add(cods);
		initialise(cods);
//		registerExistingModels(cods);
		return cods;
	}

	/**
	 * Traverses the workspace and registers existing models.
	 * @param megaModel
	 */
	private void registerExistingModels(final CODS megaModel) {
		IWorkspaceRoot root = workspace.getRoot();
		//		final IPathVariableManager pathVariableManager = workspace.getPathVariableManager();
		try {
			IProject[] projects = root.getProjects();
			for (IProject project : projects) {
				if(project.isAccessible()){
					project.accept(new IResourceVisitor() {
						@Override
						public boolean visit(IResource resource) throws CoreException {
							switch (resource.getType()) {
							case IResource.PROJECT:
								return true;
							case IResource.FOLDER:
								IFolder folder = (IFolder) resource.getAdapter(IFolder.class);
								if(folder != null){
									if(!CODSUtil.isResourceHidden(folder)){
										return true;
									}
								}
								break;
							case IResource.FILE:
								CODSUtil.registerModelInFile(megaModel, (IFile) resource);
								break;
							}
							return false;
						}
					});
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	protected void initialise(CODS megaModel) {
		MetaMetaModel ecoreMetaMetaModel = ArchitectureFactory.eINSTANCE.createMetaMetaModel();
		ecoreMetaMetaModel.setPackage(EcorePackage.eINSTANCE);
		ecoreMetaMetaModel.setConformsTo(ecoreMetaMetaModel);
		megaModel.getModels().add(ecoreMetaMetaModel);
		MetaModel codsMetaModel = ArchitectureFactory.eINSTANCE.createMetaModel();
		codsMetaModel.setConformsTo(ecoreMetaMetaModel);
		codsMetaModel.setPackage(MegamodelPackage.eINSTANCE);
		megaModel.setConformsTo(codsMetaModel);
		megaModel.getModels().add(codsMetaModel);
	}
}