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

	private Map<String, RefactoringSpecification> refSpecMap;
	
	public BasicRefactoringSpecificationRegistry(){
		refSpecMap = new HashMap<String, RefactoringSpecification>();
		collectRegisteredRefSpecs();
	}
	
	public Collection<RefactoringSpecification> getAllRefSpecs() {
		return getRefSpecMap().values();
	}

	public RefactoringSpecification getRefSpec(RoleModel roleModel) {
		String name = roleModel.getName();
		return getRefSpecMap().get(name);
	}

	public Map<String, RefactoringSpecification> getRefSpecMap() {
		return refSpecMap;
	}

	public void registerRefSpec(RefactoringSpecification refSpec) throws RefSpecAlreadyRegisteredException{
		RoleModel roleModel = refSpec.getUsedRoleModel();
		String name = roleModel.getName();
		RefactoringSpecification registeredRefSpec = getRefSpecMap().get(name);
		if(registeredRefSpec != null){
			throw new RefSpecAlreadyRegisteredException(refSpec);
		}
		getRefSpecMap().put(name, refSpec);
	}

	private void collectRegisteredRefSpecs(){
		List<RefactoringSpecification> models = RegistryUtil.collectRegisteredResources(IRefactoringSpecificationExtensionPoint.ID
				, IRefactoringSpecificationExtensionPoint.RESOURCE_ATTRIBUTE
				, RefactoringSpecification.class);
		for (RefactoringSpecification roleModel : models) {
			try {
				registerRefSpec(roleModel);
			} catch (RefSpecAlreadyRegisteredException e) {
				RegistryUtil.log(e.getMessage(), IStatus.ERROR);
			}
		}
	}
}
