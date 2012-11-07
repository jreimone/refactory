/**
 * 
 */
package org.qualitune.evolution.cods.creation;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;
import org.qualitune.evolution.megamodel.MegamodelPackage;
import org.qualitune.evolution.megamodel.architecture.ArchitectureFactory;
import org.qualitune.evolution.megamodel.architecture.InstanceModel;
import org.qualitune.evolution.megamodel.architecture.MegaModel;
import org.qualitune.evolution.megamodel.architecture.MetaMetaModel;
import org.qualitune.evolution.megamodel.architecture.MetaModel;
import org.qualitune.evolution.megamodel.architecture.ReferenceModel;
import org.qualitune.evolution.megamodel.architecture.TerminalModel;
import org.qualitune.evolution.megamodel.cods.CODS;
import org.qualitune.evolution.megamodel.cods.CodsFactory;

/**
 * @author jreimann
 *
 */
@SuppressWarnings("restriction")
public class MegamodelRegistrationProcessor {

	private static final String MEGAMODEL_FILE	= "megamodel.cods";

	@Inject
	private IWorkspace workspace;

	private ResourceSet rs;

	@Execute
	public void register(IEclipseContext context) {
		CODS megaModel = loadMegaModel();
		context.set(MegaModel.class, megaModel);
		context.set(CODS.class, megaModel);
	}

	/**
	 * Loads an existing mega model or creates a new one.
	 * @return
	 */
	private CODS loadMegaModel() {
		rs = new ResourceSetImpl();
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
	private void registerExistingModels(CODS megaModel) {
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
		try {
			IProject[] projects = root.getProjects();
			for (IProject project : projects) {
				if(project.isOpen()){
					IResource[] members = project.members();
					for (IResource iResource : members) {
						IFile ifile = (IFile) iResource.getAdapter(IFile.class);
						if(ifile != null){
							URI uri = URI.createPlatformResourceURI(ifile.getFullPath().toString(), true);
							Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(uri);
							if(factory != null){
								try {

									Resource resource = rs.getResource(uri, true);
									if(resource != null){
										EObject model = resource.getContents().get(0);
										EPackage metamodel = model.eClass().getEPackage();
										ReferenceModel existentMetamodel = megaModel.getReferenceModelByEPackage(metamodel);
										if(existentMetamodel == null){
											existentMetamodel = ArchitectureFactory.eINSTANCE.createMetaModel();
											megaModel.getModels().add(existentMetamodel);
											existentMetamodel.setConformsTo(ecoreMetaMetaModel);
											if(model instanceof EPackage){
												existentMetamodel.setPackage((EPackage) model);
											} else {
												existentMetamodel.setPackage(metamodel);
											}
										}
										TerminalModel existentTerminalModel = megaModel.getTerminalModelByEObject(model);
										if(existentTerminalModel == null){
											// TODO Art des TerminalModels unterscheiden
											existentTerminalModel = ArchitectureFactory.eINSTANCE.createInstanceModel();
											((InstanceModel) existentTerminalModel).setModel(model);
											megaModel.getModels().add(existentTerminalModel);
											existentTerminalModel.setConformsTo(existentMetamodel);
										}
									}
								} catch (Exception e) {
									// no model found, just don't include it in the megamodel
									//									e.printStackTrace();
									//									System.out.println();
								}
							}
						}
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
