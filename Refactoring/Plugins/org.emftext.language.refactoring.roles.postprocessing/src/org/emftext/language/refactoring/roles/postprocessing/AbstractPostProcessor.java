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
package org.emftext.language.refactoring.roles.postprocessing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextQuickFix;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextResourcePostProcessor;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextResourcePostProcessorProvider;
import org.emftext.language.refactoring.roles.resource.rolestext.RolestextEProblemType;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextProblem;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource;

/**
 * An abstract super class for all post processors. 
 * 
 * @author Jan Reimann
 *
 */
public abstract class AbstractPostProcessor implements IRolestextResourcePostProcessorProvider, IRolestextResourcePostProcessor{

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.roles.resource.rolestext.IRolestextResourcePostProcessorProvider#getResourcePostProcessor()
	 */
	public IRolestextResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.roles.resource.rolestext.IRolestextResourcePostProcessor#process(org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource)
	 */
	public void process(RolestextResource resource) {
		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if(eObject instanceof RoleModel){
				analyse(resource, (RoleModel) eObject);
			}
		}
	}

	protected void addProblem(RolestextResource resource, ERoleModelProblemType problemType, String message, EObject cause){
		resource.addProblem(new RolestextProblem(message, RolestextEProblemType.ANALYSIS_PROBLEM, problemType.getProblemSeverity()), cause);
	}
	
	protected void addProblem(RolestextResource resource, ERoleModelProblemType problemType, String message, EObject cause, IRolestextQuickFix quickfix){
		resource.addProblem(new RolestextProblem(message, RolestextEProblemType.ANALYSIS_PROBLEM, problemType.getProblemSeverity(), quickfix), cause);
	}
	
	public abstract void analyse(RolestextResource resource, RoleModel model);
}
