package org.emftext.language.refactoring.roles.postprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.quickfixes.RenameRoleRefactoringQuickFix;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextQuickFix;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class DistinctRoleNamesAnalyser extends AbstractPostProcessor {

	private static final String DUPLICATE_ROLE_NAMES = "A role named '%1$s' has already be defined";

	private Map<String, Role> roleNameMap;

	@Override
	public void analyse(RolestextResource resource, RoleModel model) {
		EcoreUtil.resolveAll(model);
		roleNameMap = new HashMap<String, Role>();
		List<Role> roles = model.getRoles();
		for (Role role : roles) {
			Role foundRole = roleNameMap.get(role.getName());
			if(foundRole == null){
				roleNameMap.put(role.getName(), role);
			} else {
				if(!foundRole.equals(role)){
					String originalName = role.getName();
					IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);
					if(refactorer != null){
						List<EObject> selectedElement = new ArrayList<EObject>();
						selectedElement.add(foundRole);
						refactorer.setInput(selectedElement);
						List<RoleMapping> mappings = refactorer.getPossibleRoleMappings(1.0);
						for (RoleMapping roleMapping : mappings) {
							if(roleMapping.getName().toLowerCase().contains("rename")){
								//								ImageDescriptor image = IRoleMappingRegistry.INSTANCE.getImageForMapping(roleMapping);
								URI iconBundlePath = IRoleMappingRegistry.INSTANCE.getImagePathForMapping(roleMapping);
								String iconBundlePathString = null;
								if(iconBundlePath != null){
									iconBundlePathString = iconBundlePath.toString();
								}
								IRolestextQuickFix quickfix = new RenameRoleRefactoringQuickFix(roleMapping, foundRole, role, originalName, refactorer, iconBundlePathString);
								addProblem(resource
										, ERoleModelProblemType.DUPLICATE_ROLE_NAMES
										, String.format(DUPLICATE_ROLE_NAMES, foundRole.getName())
										, role
										, quickfix);
							}
						}
					} else {
						addProblem(resource
								, ERoleModelProblemType.DUPLICATE_ROLE_NAMES
								, String.format(DUPLICATE_ROLE_NAMES, foundRole.getName())
								, role);
					}
				}
			}
		}
	}

}
