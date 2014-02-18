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
	public void registerResourcesInCODS(CODS megaModel /* this parameter is injected */){
		Set<IFile> filesToAdd = collectFilesToAdd();
		for (IFile file : filesToAdd) {
			CODSUtil.registerModelInFile(megaModel, file);
		}
		try {
			megaModel.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
