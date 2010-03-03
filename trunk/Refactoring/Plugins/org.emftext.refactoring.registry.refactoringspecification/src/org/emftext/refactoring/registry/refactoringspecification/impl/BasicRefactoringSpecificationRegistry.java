package org.emftext.refactoring.registry.refactoringspecification.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationExtensionPoint;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicRefactoringSpecificationRegistry implements
		IRefactoringSpecificationRegistry {

	private Map<RoleModel, RefactoringSpecification> refSpecMap;
	
	public BasicRefactoringSpecificationRegistry(){
		refSpecMap = new HashMap<RoleModel, RefactoringSpecification>();
		collectRegisteredRefSpecs();
	}
	
	public Collection<RefactoringSpecification> getAllRefSpecs() {
		return getRefSpecMap().values();
	}

	public RefactoringSpecification getRefSpec(RoleModel roleModel) {
		return getRefSpecMap().get(roleModel);
	}

	public Map<RoleModel, RefactoringSpecification> getRefSpecMap() {
		return refSpecMap;
	}

	public void registerRefSpec(RefactoringSpecification refSpec) throws RefSpecAlreadyRegisteredException{
		RoleModel roleModel = refSpec.getUsedRoleModel();
		RefactoringSpecification registeredRefSpec = getRefSpecMap().get(roleModel);
		if(registeredRefSpec != null){
			throw new RefSpecAlreadyRegisteredException(refSpec);
		}
		getRefSpecMap().put(roleModel, refSpec);
	}

	private void collectRegisteredRefSpecs(){
		List<RefactoringSpecification> models = RegistryUtil.collectRegisteredResources(IRefactoringSpecificationExtensionPoint.ID
				, IRefactoringSpecificationExtensionPoint.RESOURCE_ATTRIBUTE
				, RefactoringSpecification.class);
		for (RefactoringSpecification roleModel : models) {
			try {
				registerRefSpec(roleModel);
			} catch (RefSpecAlreadyRegisteredException e) {
				RegistryUtil.log(String.format("A RefactoringSpecification for RoleModel '%1$s' was already registered", e.getRefSpec().getUsedRoleModel().getName()), IStatus.ERROR);
			}
		}
	}
}
