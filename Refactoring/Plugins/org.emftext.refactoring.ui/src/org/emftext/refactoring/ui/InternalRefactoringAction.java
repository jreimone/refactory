package org.emftext.refactoring.ui;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorPart;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringStatus;

public class InternalRefactoringAction {

	public EObject refactorInternal(IRefactorer refactorer, Mapping mapping, IEditorPart activeEditor) throws CoreException{
		EObject refactoredModel = refactorer.refactor(mapping, false);
		Resource resource = refactorer.getResource();
		if(refactorer.getStatus().getSeverity() == IRefactoringStatus.OK){
			ResourceSet resourceSet = resource.getResourceSet();
			for (Resource externalReferer : refactorer.getResourcesToSave()) {
				URI uri = externalReferer.getURI();
				Resource temp = resourceSet.getResource(uri, true);
			}
			Map<EObject, Collection<Setting>> externalReferences = EcoreUtil.ExternalCrossReferencer.find(resource);
			for (EObject object : externalReferences.keySet()) {
				Resource externalReference = object.eResource();
				if(externalReference != null && externalReference.getURI().isPlatformResource()){
					resourceSet.getResource(externalReference.getURI(), true);
				}
			}
			
			IWorkspaceRunnable runnable = new SaveAllResourcesWorkspaceRunnable(refactorer.getResourcesToSave(), resource, mapping, activeEditor, refactoredModel);
			ResourcesPlugin.getWorkspace().run(runnable, null);
			
		} else {
			refactoredModel = null;
		}
		return refactoredModel;
	}

}
