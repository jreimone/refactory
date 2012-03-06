package org.emftext.refactoring.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.IStartup;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.util.RegistryUtil;

public class StartUpRegistrations implements IStartup {

	@SuppressWarnings("unused")
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
