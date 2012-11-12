/**
 * 
 */
package org.qualitune.evolution.cods.creation;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.qualitune.evolution.megamodel.cods.CODS;
import org.qualitune.evolution.registry.IKnowledgeBase;
import org.qualitune.evolution.registry.IKnowledgeBaseRegistry;

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
		IResource resource = event.getResource();
		switch (event.getType()) {
		case IResourceChangeEvent.PRE_CLOSE:
			System.out.println("close");
			break;

		case IResourceChangeEvent.PRE_DELETE:
			System.out.println("delete");
			break;

		case IResourceChangeEvent.POST_CHANGE:
			System.out.println("Resources have changed.");
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
		IResource res = delta.getResource();
		switch (delta.getKind()) {
		case IResourceDelta.ADDED:
			System.out.print("Resource ");
			System.out.print(res.getFullPath());
			System.out.println(" was added.");
			IFile file = (IFile) res.getAdapter(IFile.class);
			boolean newModelRegistered = MegamodelRegistrationProcessor.registerModelInFile(megamodel, file);
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
			break;
		case IResourceDelta.REMOVED:
			System.out.print("Resource ");
			System.out.print(res.getFullPath());
			System.out.println(" was removed.");
			break;
		case IResourceDelta.CHANGED:
			System.out.print("Resource ");
			System.out.print(delta.getFullPath());
			System.out.println(" has changed.");
			int flags = delta.getFlags();
			if ((flags & IResourceDelta.CONTENT) != 0) {
				System.out.println("--> Content Change");
			}
			if ((flags & IResourceDelta.REPLACED) != 0) {
				System.out.println("--> Content Replaced");
			}
			if ((flags & IResourceDelta.MARKERS) != 0) {
				System.out.println("--> Marker Change");
				IMarkerDelta[] markers = delta.getMarkerDeltas();
				// if interested in markers, check these deltas
			}
			break;
		}
		return true; // visit the children
	}
}