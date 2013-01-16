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
package org.emftext.refactoring.ui;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.IStatus;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.util.RegistryUtil;

public class StartUpRegistrations {

	@SuppressWarnings("unused")
	@PostConstruct
	public void earlyStartup() {
		// just provoke to initialize registries
		IRoleModelRegistry roleModelRegistry = IRoleModelRegistry.INSTANCE;
		RegistryUtil.log("Initialized Role Model registry on startup", IStatus.OK);
		IRefactoringSpecificationRegistry refspecRegistry = IRefactoringSpecificationRegistry.INSTANCE;
		RegistryUtil.log("Initialized Refactoring Specification registry on startup", IStatus.OK);
		IRoleMappingRegistry registry = IRoleMappingRegistry.INSTANCE;
		RegistryUtil.log("Initialized Role Mapping registry on startup", IStatus.OK);
	}
}
