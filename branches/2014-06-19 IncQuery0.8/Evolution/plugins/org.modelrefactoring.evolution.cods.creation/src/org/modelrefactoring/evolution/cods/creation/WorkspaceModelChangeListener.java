/**
 * 
 */
package org.modelrefactoring.evolution.cods.creation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.modelrefactoring.evolution.megamodel.architecture.InstanceModel;
import org.modelrefactoring.evolution.megamodel.cods.CODS;
import org.modelrefactoring.evolution.registry.IKnowledgeBase;
import org.modelrefactoring.evolution.registry.IKnowledgeBaseRegistry;

/**
 * @author jreimann
 *
 */
public class WorkspaceModelChangeListener implements IResourceChangeListener, IResourceDeltaVisitor {

	private CODS megamodel;

	public WorkspaceModelChangeListener(CODS megaModel) {
		this.megamodel = megaModel;
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		//		IResource resource = event.getResource();
		switch (event.getType()) {
		case IResourceChangeEvent.PRE_CLOSE:
			//			System.out.println("close");
			break;

		case IResourceChangeEvent.PRE_DELETE:
			//			System.out.println("delete");
			break;

		case IResourceChangeEvent.POST_CHANGE:
			//			System.out.println("Resources have changed.");
			try {
				event.getDelta().accept(this);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource modifiedResource = delta.getResource();
		if(modifiedResource.isAccessible() && !CODSUtil.isResourceHidden(modifiedResource)){
			switch (modifiedResource.getType()) {
			case IResource.FILE:
				IFile file = (IFile) modifiedResource.getAdapter(IFile.class);
				switch (delta.getKind()) {
				case IResourceDelta.ADDED:
					handleFileAdded(file);
					break;
				case IResourceDelta.REMOVED:
					handleFileRemoved(file);
					break;
				case IResourceDelta.CHANGED:
					handleFileChanged(delta);
					break;
				}
				return false;

			default:
				System.out.println("traverse children of " + modifiedResource);
				return true;
			}
		}
		return false;
	}

	private void handleFileChanged(IResourceDelta resourceDelta) {
		int flags = resourceDelta.getFlags();
		if ((flags & IResourceDelta.CONTENT) != 0) {
			// TODO implement
		}
		if ((flags & IResourceDelta.REPLACED) != 0) {
			// TODO implement
		}
		if ((flags & IResourceDelta.MARKERS) != 0) {
			// TODO implement
		}
	}

	private void handleFileRemoved(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		uri = uri.trimFragment();
		List<InstanceModel> instanceModels = new ArrayList<InstanceModel>(megamodel.getInstanceModels());
		for (InstanceModel instanceModel : instanceModels) {
			EObject model = instanceModel.getModel();
			if(model.eIsProxy()){
				megamodel.getModels().remove(instanceModel);
			} else {
				URI uri2 = model.eResource().getURI();
				if(uri.equals(uri2)){
					megamodel.getModels().remove(instanceModel);
				}
			}
			try {
				megamodel.eResource().save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleFileAdded(IFile file) {
		System.out.println("Processing... " + file);
		boolean newModelRegistered = CODSUtil.registerModelInFile(megamodel, file);
		if(newModelRegistered){
			try {
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				ResourceSet resourceSet = megamodel.eResource().getResourceSet();
				Resource resource = resourceSet.getResource(uri, true);
				List<IKnowledgeBase> knowledgeBases = IKnowledgeBaseRegistry.INSTANCE.getKnowledgeBases();
				for (IKnowledgeBase knowledgeBase : knowledgeBases) {
					knowledgeBase.generateKnowledge(resource);
				}
				megamodel.eResource().save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}