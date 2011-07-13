package org.emftext.refactoring.ltk;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.roles.Role;

public interface IModelRefactoringWizardPage {
	public void setRoleRuntimeInstanceMap(Map<Role, List<EObject>> roleRuntimeInstanceMap);
}
