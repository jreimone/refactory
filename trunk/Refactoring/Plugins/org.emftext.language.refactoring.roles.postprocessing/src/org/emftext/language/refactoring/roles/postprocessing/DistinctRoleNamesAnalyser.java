package org.emftext.language.refactoring.roles.postprocessing;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.quickfixes.RenameRoleRefactoringQuickFix;
import org.emftext.language.refactoring.roles.refactoring.facade.RolesRefactoringFacade;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextQuickFix;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource;
import org.emftext.refactoring.interpreter.IRefactorer;

public class DistinctRoleNamesAnalyser extends AbstractPostProcessor {

	private static final String DUPLICATE_ROLE_NAMES = "A role named '%1$s' has already be defined";

	private Map<String, Role> roleNameMap;

	@Override
	public void analyse(RolestextResource resource, RoleModel model) {
		roleNameMap = new HashMap<String, Role>();
		List<Role> roles = model.getRoles();
		for (Role role : roles) {
			Role foundRole = roleNameMap.get(role.getName());
			if (foundRole == null) {
				roleNameMap.put(role.getName(), role);
			} else {
				if (!foundRole.equals(role)) {
					List<EObject> selectedElement = new ArrayList<EObject>();
					selectedElement.add(foundRole);

					//// always the same?
					RolesRefactoringFacade facade = new RolesRefactoringFacade(resource, selectedElement);
					IRefactorer refactorer = facade.getRefactorer();
					RoleMapping roleMapping = facade.getRenameRoleModelElementMapping();
					URL iconBundlePath = facade.getRenameRoleModelElementIcon();
					if (refactorer != null) {
						IRolestextQuickFix quickfix = new RenameRoleRefactoringQuickFix(roleMapping, foundRole, refactorer, (iconBundlePath != null) ? iconBundlePath.toString()
								: null);
						addProblem(
								resource
								,
								ERoleModelProblemType.DUPLICATE_ROLE_NAMES
								,
								String.format(DUPLICATE_ROLE_NAMES,
										foundRole.getName())
								, role
								, quickfix);
					} else {
						addProblem(
								resource
								,
								ERoleModelProblemType.DUPLICATE_ROLE_NAMES
								,
								String.format(DUPLICATE_ROLE_NAMES,
										foundRole.getName())
								, role);
					}
				}
			}
		}
	}

	public void terminate() {
		// do nothing
	}
}
