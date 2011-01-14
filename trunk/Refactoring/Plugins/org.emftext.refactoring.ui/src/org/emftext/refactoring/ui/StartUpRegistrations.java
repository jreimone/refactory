package org.emftext.refactoring.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.IStartup;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RegistryUtil;

public class StartUpRegistrations implements IStartup {

	public void earlyStartup() {
		// just provoke to initialize registries
		@SuppressWarnings("unused")
		IRoleMappingRegistry registry = IRoleMappingRegistry.INSTANCE;
		RegistryUtil.log("Initialized Role Mapping registry on startup", IStatus.OK);
	}

}
