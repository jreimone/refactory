package org.emftext.refactoring.registry.rolemodel;

import java.util.Collection;
import java.util.Map;

import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;
import org.emftext.refactoring.registry.rolemodel.impl.BasicRoleModelRegistry;

/**
 * Interface for {@link RoleModel} registries.
 * 
 * @author jreimann
 *
 */
public interface IRoleModelRegistry {

	public static IRoleModelRegistry INSTANCE = new BasicRoleModelRegistry();
	
	/**
	 * Returns the map containing the name of a {@link RoleModel} as key and the {@link RoleModel} itself as value.
	 * 
	 * @return
	 */
	public Map<String, RoleModel> getRoleModelNameMap();
	
//	/**
//	 * Returns the map containing the namespace URI of a {@link RoleModel} as key and the {@link RoleModel} itself as value.
//	 * 
//	 * @return
//	 */
//	public Map<String, RoleModel> getRoleModelUriMap();
	
	/**
	 * Returns a list of all registered {@link RoleModel}s.
	 * 
	 * @return
	 */
	public Collection<RoleModel> getAllRegisteredRoleModels();
	
	/**
	 * This method can be used to register {@link RoleModel}s at runtime. Maybe if it is currently being developed
	 * and the modeler already wants to run refactorings against this {@link RoleModel}. 
	 * 
	 * @param roleModel the {@link RoleModel} to be registered
	 * @throws RoleModelAlreadyRegisteredException if a {@link RoleModel} with the same name or namespace Uri already exists in the registry
	 */
	public void registerRoleModel(RoleModel roleModel) throws RoleModelAlreadyRegisteredException;
	
	/**
	 * Returns a {@link RoleModel} by its name.
	 * 
	 * @param name of the desired {@link RoleModel}
	 * @return the desired {@link RoleModel}
	 */
	public RoleModel getRoleModelByName(String name);
	
	/**
	 * Use this method to update an already registered role model.
	 * @param model
	 */
	public void updateRoleModel(RoleModel model);
}
