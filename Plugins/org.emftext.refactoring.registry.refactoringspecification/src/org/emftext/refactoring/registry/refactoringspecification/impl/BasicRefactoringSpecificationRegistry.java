/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.registry.refactoringspecification.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistryInitializer;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistryListener;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicRefactoringSpecificationRegistry implements IRefactoringSpecificationRegistry {

	private Map<RoleModel, RefactoringSpecification> refSpecMap;
	private Set<IRefactoringSpecificationRegistryListener> listeners;
	private IRefactoringSpecificationRegistryInitializer initializer;

	public BasicRefactoringSpecificationRegistry() {
		listeners = new HashSet<IRefactoringSpecificationRegistryListener>();
	}

	@Override
	public void setInitializer(IRefactoringSpecificationRegistryInitializer initializer) {
		this.initializer = initializer;
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
		if(refSpecMap == null){
			refSpecMap = new HashMap<RoleModel, RefactoringSpecification>();
			if(initializer != null){
				List<RefactoringSpecification> refSpecs = initializer.initialize();
				registerInitializedRefSpecs(refSpecs);
			}
		}
		return refSpecMap;
	}

	private void registerInitializedRefSpecs(List<RefactoringSpecification> refSpecs) {
		for (RefactoringSpecification refSpec : refSpecs) {
			try {
				registerRefSpec(refSpec);
			} catch (RefSpecAlreadyRegisteredException e) {
				RegistryUtil.log(e.getMessage(), IStatus.ERROR);
			}
		}
	}

	public RoleModel registerRefSpec(RefactoringSpecification refSpec) throws RefSpecAlreadyRegisteredException {
		RoleModel roleModel = refSpec.getUsedRoleModel();
		EcoreUtil.resolveAll(roleModel);
		String name = roleModel.getName();
		roleModel = IRoleModelRegistry.INSTANCE.getRoleModelByName(name);
		if (roleModel != null) {
			RefactoringSpecification registeredRefSpec = getRefSpecMap().get(roleModel);
			if (registeredRefSpec != null) {
				throw new RefSpecAlreadyRegisteredException(refSpec);
			}
			getRefSpecMap().put(roleModel, refSpec);
			for (IRefactoringSpecificationRegistryListener listener : listeners) {
				listener.refSpecAdded(refSpec);
			}
			return roleModel;
		}
		return null;
	}

	public RefactoringSpecification unregisterRefSpec(RefactoringSpecification refSpec) {
		RoleModel rolemodel = refSpec.getUsedRoleModel();
		RefactoringSpecification remove = getRefSpecMap().remove(rolemodel);
		for (IRefactoringSpecificationRegistryListener listener : listeners) {
			listener.refSpecRemoved(remove);
		}
		return remove;
	}

	@Override
	public void addRegistryListener(IRefactoringSpecificationRegistryListener listener) {
		if(listener != null){
			listeners.add(listener);
		}
	}

	@Override
	public boolean removeRegistryListener(IRefactoringSpecificationRegistryListener listener) {
		if(listener != null){
			return listeners.remove(listener);
		}
		return false;
	}
}
