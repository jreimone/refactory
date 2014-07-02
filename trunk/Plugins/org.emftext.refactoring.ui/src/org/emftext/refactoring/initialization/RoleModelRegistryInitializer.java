package org.emftext.refactoring.initialization;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemodel.IRoleModelExtensionPoint;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistryInitializer;
import org.emftext.refactoring.util.RegistryUtil;

/**
 * Initializes the {@link RoleModel} registry from the extension point.  
 *
 */
public class RoleModelRegistryInitializer implements IRoleModelRegistryInitializer {

	@Override
	public List<RoleModel> initialize() {
		List<RoleModel> roleModels = new LinkedList<RoleModel>();
		Map<RoleModel, IConfigurationElement> models = RegistryUtil.collectRegisteredResources(IRoleModelExtensionPoint.ID
				, IRoleModelExtensionPoint.RESOURCE_ATTRIBUTE
				, RoleModel.class);
		for (RoleModel roleModel : models.keySet()) {
			roleModels.add(roleModel);
		}
		return roleModels;
	}

}
