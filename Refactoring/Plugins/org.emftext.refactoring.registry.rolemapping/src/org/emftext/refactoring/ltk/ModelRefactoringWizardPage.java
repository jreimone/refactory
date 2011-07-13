package org.emftext.refactoring.ltk;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.util.RoleUtil;

public abstract class ModelRefactoringWizardPage extends UserInputWizardPage implements IModelRefactoringWizardPage
{
	private Map<Role, List<EObject>> roleRuntimeInstanceMap;
	
	public ModelRefactoringWizardPage(String name)
	{
		super(name);
		
		setDescription("The refactoring requires additional parameters.");
	}

	final public void createControl(Composite parent)
	{
		Control c = doCreateControl(parent);

		setControl(c);
	}
	
	protected abstract Control doCreateControl(Composite parent);
	
	public void setRoleRuntimeInstanceMap(Map<Role, List<EObject>> roleRuntimeInstanceMap)
	{
		this.roleRuntimeInstanceMap = roleRuntimeInstanceMap;
	}
	
	protected <T extends EObject> T getFirstObjectForRole(String roleName, Class<T> type)
	{
		return RoleUtil.getFirstObjectForRole(roleName, type, roleRuntimeInstanceMap);
	}

	protected <T extends EObject> List<T> getObjectsForRole(String roleName, Class<T> type)
	{
		return RoleUtil.getObjectsForRole(roleName, type, roleRuntimeInstanceMap);
	}
}
