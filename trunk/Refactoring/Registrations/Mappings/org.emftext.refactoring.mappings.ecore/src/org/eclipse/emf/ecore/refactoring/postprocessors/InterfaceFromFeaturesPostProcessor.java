package org.eclipse.emf.ecore.refactoring.postprocessors;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

public class InterfaceFromFeaturesPostProcessor implements
		IRefactoringPostProcessor {

	public InterfaceFromFeaturesPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		EClass interfaceClass = null;
		for (Role role : roleRuntimeInstanceMap.keySet()) {
			if(role.getName().equals("NewContainer")){
				interfaceClass = (EClass) roleRuntimeInstanceMap.get(role).get(0);
			}
		}
		interfaceClass.setAbstract(true);
		interfaceClass.setInterface(true);
		return Status.OK_STATUS;
	}

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec) {
		return process(roleRuntimeInstanceMap, resourceSet, change);
	}

}
