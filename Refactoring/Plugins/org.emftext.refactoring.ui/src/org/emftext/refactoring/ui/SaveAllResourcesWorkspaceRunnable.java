/**
 * 
 */
package org.emftext.refactoring.ui;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;

class SaveAllResourcesWorkspaceRunnable implements IWorkspaceRunnable {

	private List<Resource> resourcesToSave;
	private Resource refactoredResource;
//	private Mapping mapping;
	private IEditorPart activeEditor;
	private Resource gmfResource;
	private EObject refactoredModel;
	private ResourceSet resourceSet;

	public SaveAllResourcesWorkspaceRunnable(List<Resource> resourcesToSave, Resource refactoredResource, IEditorPart activeEditor, EObject refactoredModel) {
		this.resourcesToSave = resourcesToSave;
		this.refactoredResource = refactoredResource;
		this.resourceSet = refactoredResource.getResourceSet();
//		this.mapping = mapping;
		this.activeEditor = activeEditor;
		this.refactoredModel = refactoredModel;
		initGmfResource();
	}

	private void initGmfResource() {
		if (activeEditor != null) {
			IEditorInput input = activeEditor.getEditorInput();
			if (input instanceof FileEditorInput) {
				IFile file = ((FileEditorInput) input).getFile();
				URI gmfUri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				gmfResource = resourceSet.getResource(gmfUri, true);
			}
		}
	}

	public void run(IProgressMonitor monitor) throws CoreException {
		EcoreUtil.resolveAll(resourceSet);
//			refactoredResource.getContents().set(0, refactoredModel);
		try {
			Map<Object, Object> options = new LinkedHashMap<Object, Object>();
			options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
			EcoreUtil.resolveAll(refactoredResource);
			refactoredResource.save(options);
		} catch (Exception e) {
			e.printStackTrace();
			refactoredResource.getErrors().clear();
		}
		for (Resource externalResource : resourcesToSave) {
			if (!externalResource.equals(gmfResource)) {
				URI uri = externalResource.getURI();
				if (uri.isPlatformResource()) {
					EcoreUtil.resolveAll(externalResource);
					try {
						externalResource.save(null);
					} catch (Exception e) {
						e.printStackTrace();
						externalResource.getErrors().clear();
					}
					System.out.println("Saved resource " + externalResource);
				}
			}
		}
//			refactoredResource.save(null);
	}

}