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
/**
 * 
 */
package org.emftext.refactoring.ui;

import java.util.LinkedHashMap;
import java.util.LinkedList;
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
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;

class SaveAllResourcesWorkspaceRunnable implements IWorkspaceRunnable {

	private List<Resource> resourcesToSave;
	private Resource refactoredResource;
	private IEditorPart activeEditor;
	private Resource gmfResource;
	private ResourceSet resourceSet;
	private IRefactorer refactorer;

	private Map<Role, List<URI>> runtimeInstancePathMap = new LinkedHashMap<Role, List<URI>>(); 
	
	public SaveAllResourcesWorkspaceRunnable(IRefactorer refactorer, IEditorPart activeEditor) {
		this.resourcesToSave = refactorer.getResourcesToSave();
		this.refactoredResource = refactorer.getResource();
		this.resourceSet = refactoredResource.getResourceSet();
		this.refactorer = refactorer;
		this.activeEditor = activeEditor;
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
		preSaveRuntimeInstanceHandling(refactorer);
		EcoreUtil.resolveAll(resourceSet);
		try {
			Map<Object, Object> options = new LinkedHashMap<Object, Object>();
			options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
			EcoreUtil.resolveAll(refactoredResource);
			refactoredResource.save(options);
//			System.out.println("Saved resource " + refactoredResource);
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
//						System.out.println("Saved resource " + externalResource);
					} catch (Exception e) {
						e.printStackTrace();
						externalResource.getErrors().clear();
					}
				}
			}
		}
	}

	private void preSaveRuntimeInstanceHandling(IRefactorer refactorer){
		IRefactoringInterpreter interpreter = refactorer.getInterpreter();
		Map<Role, List<EObject>> roleInstanceMap = interpreter.getRoleRuntimeInstances();
//		System.out.println("~~~~~~~~~~~~~~~");
		for (Role role : roleInstanceMap.keySet()) {
//			System.out.println(role.getName() + ":");
			List<EObject> instances = roleInstanceMap.get(role);
			for (EObject eObject : instances) {
				createPath(role, eObject);
			}
		}
//		System.out.println("~~~~~~~~~~~~~~~");
		interpreter.setRoleRuntimeInstanceURIs(runtimeInstancePathMap);
	}

	private void createPath(Role role, EObject object) {
		URI uri = EcoreUtil.getURI(object);
//		System.out.println("path: " + uri.toString());
		List<URI> uriList = runtimeInstancePathMap.get(role);
		if(uriList == null){
			uriList = new LinkedList<URI>();
			runtimeInstancePathMap.put(role, uriList);
		}
		uriList.add(uri);
	}
}
