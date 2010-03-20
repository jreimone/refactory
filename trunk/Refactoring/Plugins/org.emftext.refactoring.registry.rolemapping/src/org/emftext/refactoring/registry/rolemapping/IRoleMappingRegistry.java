package org.emftext.refactoring.registry.rolemapping;

import java.util.Map;

import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.registry.rolemapping.exceptions.RoleMappingAlreadyRegistered;
import org.emftext.refactoring.registry.rolemapping.impl.BasicRoleMappingRegistry;

/**
 * Interface for the registry where {@link RoleMappingModel}s are registered to a specific metamodel.
 * 
 * @author jreimann
 *
 */
public interface IRoleMappingRegistry {

	public static final IRoleMappingRegistry INSTANCE = new BasicRoleMappingRegistry();
	
	/**
	 * Returns the {@link RoleMappingModel} registered for the given namespace URI.
	 * 
	 * @param nsUri
	 * @return
	 */
	public RoleMappingModel getRoleMappingForUri(String nsUri);
	
	/**
	 * To be invoked if a {@link RoleMappingModel} is intended to be registered at runtime. 
	 * @param roleMapping
	 */
	public void registerRoleMapping(RoleMappingModel roleMapping) throws RoleMappingAlreadyRegistered;
	
	/**
	 * Returns the {@link RoleMappingModel rolemapping} map.
	 * @return
	 */
	public Map<String, RoleMappingModel> getRoleMappingMap();
	
	/**
	 * Use this method to register a {@link IRefactoringPostProcessor postprocessor} for the given <code>roleMapping</code> and 
	 * <code>mapping</code>.
	 * 
	 * @param roleMapping
	 * @param mapping
	 * @param postProcessor
	 */
	public void registerPostProcessor(RoleMappingModel roleMapping, Mapping mapping, IRefactoringPostProcessor postProcessor);
	
	/**
	 * Returns the postprocessor registered to the metamodel, specified by the given <code>nsUri</code>, and the {@link Mapping mapping},
	 * specified by the given <code>mappingName</code>. 
	 * 
	 * @param nsUri
	 * @param mappingName
	 * @return
	 */
	public IRefactoringPostProcessor getPostProcessor(String nsUri, String mappingName);
}
