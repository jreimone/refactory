package org.emftext.refactoring.registry.rolemapping;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
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
	public Map<String, RoleMapping> getRoleMappingsForUri(String nsUri);
	
	/**
	 * To be invoked if a {@link RoleMappingModel} is intended to be registered at runtime.
	 * This method returns those mappings contained in the <code>roleMapping</code> which couldn't be registered
	 * because they are already registered.
	 *  
	 * @param roleMapping
	 * @return those mappings which couldn't be registered
	 */
	public List<RoleMapping> registerRoleMapping(RoleMappingModel roleMapping);
	
	/**
	 * This method updates the registered mappings with the <code>mappingsToUpdate</code>. Only corresponding
	 * mappings will be updated. As input the output from {@link IRoleMappingRegistry#registerRoleMapping(RoleMappingModel)}
	 * could serve.
	 *  
	 * @param mappingsToUpdate
	 */
	public void updateMappings(List<RoleMapping> mappingsToUpdate);
	
	/**
	 * Returns the {@link RoleMappingModel rolemapping} map.
	 * @return
	 */
	public Map<String, Map<String, RoleMapping>> getRoleMappingsMap();
	
	/**
	 * Use this method to register a {@link IRefactoringPostProcessor postprocessor} for the given <code>roleMapping</code> and 
	 * <code>mapping</code>.
	 * @param mapping
	 * @param postProcessor
	 */
	public void registerPostProcessor(RoleMapping mapping, IRefactoringPostProcessor postProcessor);
	
	/**
	 * Returns the postprocessor registered to the given {@link Mapping mapping}. 
	 * 
	 * @param metamodel
	 * @return
	 */
	public IRefactoringPostProcessor getPostProcessor(RoleMapping mapping);
	
	/**
	 * Returns an {@link ImageDescriptor image} for the given <code>mapping</code> or null of no
	 * image was registered.
	 * 
	 * @param mapping
	 * @return
	 */
	public ImageDescriptor getImageForMapping(RoleMapping mapping);
	
	/**
	 * Returns the path in the bundle for the registered icon for the given <code>mapping</code>. 
	 * @param mapping for which an icon was registered
	 * @return the path in the bundle
	 */
	public URI getImagePathForMapping(RoleMapping mapping);
}
