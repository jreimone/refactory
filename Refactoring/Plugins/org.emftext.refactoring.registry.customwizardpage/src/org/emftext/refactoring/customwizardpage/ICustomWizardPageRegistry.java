package org.emftext.refactoring.customwizardpage;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.customwizardpage.impl.BasicCustomWizardPageRegistry;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;

public interface ICustomWizardPageRegistry {

	public static final ICustomWizardPageRegistry INSTANCE = new BasicCustomWizardPageRegistry();
	
	public List<IModelRefactoringWizardPage> getFreshCustomWizardPages(RoleMapping mapping, Map<Role, List<EObject>> roleRuntimeInstanceMap);
	public List<IModelRefactoringWizardPage> getCustomWizardPages(RoleMapping mapping);
}
