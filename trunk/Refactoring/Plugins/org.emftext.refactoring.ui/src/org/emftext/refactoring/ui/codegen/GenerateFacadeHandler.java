package org.emftext.refactoring.ui.codegen;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

public class GenerateFacadeHandler extends AbstractHandler {

	private List<RoleMapping> foundMappings;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("GenerateFacadeHandler.execute()");
		return null;
	}

	@Override
	public boolean isEnabled() {
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();
		if(selection instanceof IStructuredSelection){
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();
			if(firstElement instanceof IFolder){
				IFolder folder = (IFolder) firstElement;
				try {
					IResource[] members = folder.members();
					ResourceSet rs = new ResourceSetImpl();
					foundMappings = new LinkedList<RoleMapping>();
					for (IResource resource : members) {
						try {
							IPath path = resource.getLocation();
							URI uri = URI.createFileURI(path.toFile().getAbsolutePath());
							Resource modelResource = rs.getResource(uri, true);
							if(modelResource != null){
								List<EObject> contents = modelResource.getContents();
								for (EObject eObject : contents) {
									if(eObject instanceof RoleMappingModel){
										foundMappings.addAll(((RoleMappingModel) eObject).getMappings());
									}
								}
							}
						} catch (Exception e) {
							// just do nothing
						}
					}
					if(foundMappings.size() > 0){
						return true;
					}
				} catch (CoreException e) {
					return false;
				}
			}
		}
		return false;
	}
}
