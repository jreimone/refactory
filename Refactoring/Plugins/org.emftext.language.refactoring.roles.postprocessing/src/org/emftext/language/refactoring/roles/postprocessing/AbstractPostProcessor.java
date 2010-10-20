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
		resource.addProblem(new RolestextProblem(message, problemType.getProblemType()), cause);
	}
	
	protected void addProblem(RolestextResource resource, ERoleModelProblemType problemType, String message, EObject cause, IRolestextQuickFix quickfix){
		resource.addProblem(new RolestextProblem(message, problemType.getProblemType(), quickfix), cause);
	}
	
	public abstract void analyse(RolestextResource resource, RoleModel model);
}
