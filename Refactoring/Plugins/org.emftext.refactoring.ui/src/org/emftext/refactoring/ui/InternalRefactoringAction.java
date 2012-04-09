/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringStatus;

public class InternalRefactoringAction {

	public EObject refactorInternal(IRefactorer refactorer, IEditorPart activeEditor) throws CoreException{
		EObject refactoredModel = refactorer.refactor();
		Resource resource = refactorer.getResource();
		if(refactorer.getStatus().getSeverity() == IRefactoringStatus.OK){
			ResourceSet resourceSet = resource.getResourceSet();
			for (Resource externalReferer : refactorer.getResourcesToSave()) {
				URI uri = externalReferer.getURI();
				resourceSet.getResource(uri, true);
			}
			Map<EObject, Collection<Setting>> externalReferences = EcoreUtil.ExternalCrossReferencer.find(resource);
			for (EObject object : externalReferences.keySet()) {
				Resource externalReference = object.eResource();
				if(externalReference != null && externalReference.getURI().isPlatformResource()){
					resourceSet.getResource(externalReference.getURI(), true);
				}
			}
			
			IWorkspaceRunnable runnable = new SaveAllResourcesWorkspaceRunnable(refactorer, activeEditor);
			ResourcesPlugin.getWorkspace().run(runnable, null);
			
		} else {
			refactoredModel = null;
		}
		return refactoredModel;
	}

}
