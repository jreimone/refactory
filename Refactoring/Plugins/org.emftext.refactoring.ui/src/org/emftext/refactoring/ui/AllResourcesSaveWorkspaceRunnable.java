/**
 * 
 */
package org.emftext.refactoring.ui;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.emftext.language.refactoring.rolemapping.Mapping;

class AllResourcesSaveWorkspaceRunnable implements IWorkspaceRunnable {

	private ResourceSet resourceSet;
	private Resource refactoredModel;
	private Mapping mapping;
	private IEditorPart activeEditor;
	private Resource gmfResource;

	public AllResourcesSaveWorkspaceRunnable(ResourceSet resourceSet,
			Resource refactoredModel, Mapping mapping, IEditorPart activeEditor) {
		this.resourceSet = resourceSet;
		this.refactoredModel = refactoredModel;
		this.mapping = mapping;
		this.activeEditor = activeEditor;
		initGmfResource();
	}

	private void initGmfResource(){
		if(activeEditor != null){
			IEditorInput input = activeEditor.getEditorInput();
			if(input instanceof FileEditorInput){
				IFile file = ((FileEditorInput) input).getFile();
				URI gmfUri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				gmfResource = resourceSet.getResource(gmfUri, true);
			}
		}
	}

	public void run(IProgressMonitor monitor) throws CoreException {
		try {
			EcoreUtil.resolveAll(resourceSet);
			// resource.getContents().set(0, refactoredModel);
			refactoredModel.save(null);
			for (Resource externalResource : resourceSet.getResources()) {
				if (!externalResource.equals(refactoredModel) && !externalResource.equals(gmfResource)) {
					URI uri = externalResource.getURI();
					if (uri.isPlatformResource()) {
						EcoreUtil.resolveAll(externalResource);
						externalResource.save(null);
						System.out.println("Saved resource " + externalResource
								+ " after refactoring '" + mapping.getName()
								+ "'");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}