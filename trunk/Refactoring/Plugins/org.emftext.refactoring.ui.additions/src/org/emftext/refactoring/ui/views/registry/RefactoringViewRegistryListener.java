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
package org.emftext.refactoring.ui.views.registry;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistryListener;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistryListener;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistryListener;

/**
 * A class which listens to all the three registries:<br>
 * {@link IRoleModelRegistry}, {@link IRefactoringSpecificationRegistry}, {@link IRoleMappingRegistry}
 * 
 * @author jreimann
 *
 */
public class RefactoringViewRegistryListener implements IRoleModelRegistryListener, IRefactoringSpecificationRegistryListener, IRoleMappingRegistryListener {

	private RegistryViewContentProvider contentProvider;
	
	public RefactoringViewRegistryListener(RegistryViewContentProvider contentProvider) {
		super();
		this.contentProvider = contentProvider;
	}

	@Override
	public void roleModelRemoved(RoleModel roleModel) {
		contentProvider.remove(roleModel);
	}

	@Override
	public void roleModelAdded(RoleModel roleModel) {
		contentProvider.add(roleModel);
	}

	@Override
	public void refSpecRemoved(RefactoringSpecification refSpec) {
		contentProvider.remove(refSpec);
	}

	@Override
	public void refSpecAdded(RefactoringSpecification refSpec) {
		contentProvider.add(refSpec);
	}

	@Override
	public void roleMappingRemoved(RoleMapping roleMapping) {
		contentProvider.remove(roleMapping);
	}

	@Override
	public void roleMappingAdded(RoleMapping roleMapping) {
		contentProvider.add(roleMapping);
	}

}
