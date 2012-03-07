package org.emftext.refactoring.registry.refactoringspecification.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationExtensionPoint;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicRefactoringSpecificationRegistry implements
IRefactoringSpecificationRegistry {

	private Map<RoleModel, RefactoringSpecification> refSpecMap;

	public BasicRefactoringSpecificationRegistry() {
		refSpecMap = new HashMap<RoleModel, RefactoringSpecification>();
		collectRegisteredRefSpecs();
	}

	public Collection<RefactoringSpecification> getAllRefSpecs() {
		return getRefSpecMap().values();
	}

	public RefactoringSpecification getRefSpec(RoleModel roleModel) {
		String name = roleModel.getName();
		roleModel = IRoleModelRegistry.INSTANCE.getRoleModelByName(name);
		if (roleModel != null) {
			return getRefSpecMap().get(roleModel);
		} else {
			return null;
		}
	}

	private Map<RoleModel, RefactoringSpecification> getRefSpecMap() {
		return refSpecMap;
	}

	public void registerRefSpec(RefactoringSpecification refSpec)
			throws RefSpecAlreadyRegisteredException {
		RoleModel roleModel = refSpec.getUsedRoleModel();
		EcoreUtil.resolveAll(roleModel);
		String name = roleModel.getName();
		roleModel = IRoleModelRegistry.INSTANCE.getRoleModelByName(name);
		if (roleModel != null) {
			RefactoringSpecification registeredRefSpec = getRefSpecMap().get(
					roleModel);
			if (registeredRefSpec != null) {
				throw new RefSpecAlreadyRegisteredException(refSpec);
			}
			getRefSpecMap().put(roleModel, refSpec);
		}
	}

	private void collectRegisteredRefSpecs() {
		Map<RefactoringSpecification, IConfigurationElement> models = RegistryUtil
				.collectRegisteredResources(
						IRefactoringSpecificationExtensionPoint.ID,
						IRefactoringSpecificationExtensionPoint.RESOURCE_ATTRIBUTE,
						RefactoringSpecification.class);
		for (RefactoringSpecification refSpec : models.keySet()) {
			try {
				registerRefSpec(refSpec);
			} catch (RefSpecAlreadyRegisteredException e) {
				RegistryUtil.log(e.getMessage(), IStatus.ERROR);
			}
		}
	}

	public void updateRefSpec(RefactoringSpecification refSpec) {
		RoleModel rolemodel = refSpec.getUsedRoleModel();
		getRefSpecMap().put(rolemodel, refSpec);
	}
}
