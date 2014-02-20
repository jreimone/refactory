package org.modelrefactoring.evolution.ui.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.handlers.HandlerUtil;
import org.modelrefactoring.evolution.cods.creation.CODSUtil;
import org.modelrefactoring.evolution.registry.IKnowledgeBase;
import org.modelrefactoring.evolution.registry.IKnowledgeBaseRegistry;

public class GenerateKnowledgeHandler extends AbstractHandler {

	private class ResourceWorkingsetVisitor implements IResourceVisitor {
		private final List<IFile> files;

		private ResourceWorkingsetVisitor(List<IFile> files) {
			this.files = files;
		}

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
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		if(selection != null && !selection.isEmpty()){
			Job job = new Job("Generate knowledge of models") {
				
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					int workUnits = 100;
					int collectUnits = 10;
					monitor.beginTask(getName() + "...", workUnits);
					// 1. collect files
					monitor.subTask("Collect all files to know");
					List<IFile> filesToKnow = collectFilesFromSelection(selection);
					monitor.worked(collectUnits);
					// 2. learn them to know
					int fileCount = filesToKnow.size();
					int knowUnits = (int) ((workUnits - collectUnits) / fileCount);
					monitor.subTask("Get to know " + fileCount + " files");
					ResourceSet rs = new ResourceSetImpl();
					for (IFile file : filesToKnow) {
						URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
						if(!uri.isPlatformResource()){
							uri = URI.createPlatformResourceURI(uri.toString(), true);
						}
						Resource resource = rs.getResource(uri, true);
						IKnowledgeBaseRegistry registry = IKnowledgeBaseRegistry.INSTANCE;
						List<IKnowledgeBase> knowledgeBases = registry.getKnowledgeBases();
						for (IKnowledgeBase knowledgeBase : knowledgeBases) {
							knowledgeBase.generateKnowledge(resource);
						}
						monitor.worked(knowUnits);
					}
					monitor.done();
					return Status.OK_STATUS;
				}
			};
			job.schedule();
		}
		return null;
	}

	protected List<IFile> collectFilesFromSelection(IStructuredSelection selection) {
		final List<IFile> files = new ArrayList<IFile>();
		@SuppressWarnings("rawtypes")
		Iterator iterator = selection.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			if(object instanceof IAdaptable){
				IAdaptable adaptable = (IAdaptable) object;
				IResource resource = (IResource) adaptable.getAdapter(IResource.class);
				if(resource != null){
					try {
						resource.accept(new ResourceWorkingsetVisitor(files));
					} catch (CoreException e) {
						e.printStackTrace();
					}				
				} else {
					IWorkingSet workingSet = (IWorkingSet) adaptable.getAdapter(IWorkingSet.class);
					IAdaptable[] elements = workingSet.getElements();
					for (IAdaptable element : elements) {
						resource = (IResource) element.getAdapter(IResource.class);
						if(resource != null){
							try {
								resource.accept(new ResourceWorkingsetVisitor(files));
							} catch (CoreException e) {
								e.printStackTrace();
							}				
						}
					}
				}
			}
		}
		return files;
	}

}
