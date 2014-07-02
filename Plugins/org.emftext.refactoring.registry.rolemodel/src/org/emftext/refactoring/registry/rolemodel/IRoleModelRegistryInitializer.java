package org.emftext.refactoring.registry.rolemodel;

import java.util.List;

import org.emftext.language.refactoring.roles.RoleModel;

/**
 * Interface being used from the {@link IRoleModelRegistry} to initialize itself.
 * A default implementation is used when running in an Eclipse instance (Platform is running).
 * Provide an own implementation in, e.g., a testing context. 
 *
 */
public interface IRoleModelRegistryInitializer {

	/**
	 * Initializes the registry and returns the initial list of {@link RoleModel}s.
	 * 
	 * @return
	 */
	public List<RoleModel> initialize();
}
