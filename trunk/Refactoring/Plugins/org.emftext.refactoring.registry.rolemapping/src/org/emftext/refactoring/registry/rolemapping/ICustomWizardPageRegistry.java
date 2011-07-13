package org.emftext.refactoring.registry.rolemapping;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.ModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.impl.BasicCustomWizardPageRegistry;

public interface ICustomWizardPageRegistry {

	public static final ICustomWizardPageRegistry INSTANCE = new BasicCustomWizardPageRegistry();
	
	public List<ModelRefactoringWizardPage> getFreshCustomWizardPages(RoleMapping mapping, Map<Role, List<EObject>> roleRuntimeInstanceMap);
	public List<ModelRefactoringWizardPage> getCustomWizardPages(RoleMapping mapping);
}
