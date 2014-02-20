package org.modelrefactoring.evolution.cods.creation.ui.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.modelrefactoring.evolution.cods.creation.CODSUtil;
import org.modelrefactoring.evolution.megamodel.cods.CODS;

public class RegisterResourceInCODSHandler {

	private List<IResource> currentSelection;

	@CanExecute
	public boolean isValidResource(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection){
		if(selection != null){
			currentSelection = new ArrayList<IResource>();
			@SuppressWarnings("rawtypes")
			Iterator iterator = selection.iterator();
			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				if(object instanceof IAdaptable){
					IAdaptable adaptable = (IAdaptable) object;
					IResource resource = (IResource) adaptable.getAdapter(IResource.class);
					if(resource != null){
						currentSelection.add(resource);
					}
				}
			}
		}
		return true;
	}

	@Execute
	public void registerResourcesInCODS(final CODS megaModel /* this parameter is injected */){
		Job job = new Job("Register resources in the CODS") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				int workUnits = 100;
				int collectUnits = 10;
				monitor.beginTask(getName() + "...", workUnits);
				// 1. collect files
				monitor.subTask("Collect all files to register");
				Set<IFile> filesToAdd = collectFilesToAdd();
				monitor.worked(collectUnits);
				// 2. register them
				int filesToRegister = filesToAdd.size();
				int registerUnits = (int) ((workUnits - collectUnits) / filesToRegister);
				monitor.subTask("Register " + filesToRegister + " files");
				for (IFile file : filesToAdd) {
					CODSUtil.registerModelInFile(megaModel, file);
					monitor.worked(registerUnits);
				}
				try {
					monitor.subTask("Save the CODS");
					megaModel.eResource().save(Collections.EMPTY_MAP);
					int saveUnits = workUnits - collectUnits - filesToRegister * registerUnits;
					monitor.worked(saveUnits);
				} catch (IOException e) {
					e.printStackTrace();
					monitor.done();
					return Status.CANCEL_STATUS;
				}
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}

	protected Set<IFile> collectFilesToAdd() {
		final Set<IFile> files = new HashSet<IFile>();
		if(currentSelection != null && currentSelection.size() > 0){
			for (IResource resource : currentSelection) {
				try {
					resource.accept(new IResourceVisitor(){
						@Override
						public boolean visit(IResource resource) throws CoreException {
							if(!CODSUtil.isResourceHidden(resource)){
								if(resource.getType() == IResource.FILE){
									files.add((IFile) resource);
									return false;
								}
								return true;
							}
							return false;
						}
					});
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		return files;
	}
}
