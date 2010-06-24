/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class RolemappingBuilder implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		if(resource != null && (resource.getErrors() == null || resource.getErrors().size() == 0)){
			EObject root = resource.getContents().get(0);
			if(root instanceof RoleMappingModel){
				RoleMappingModel model = (RoleMappingModel) root;
				List<RoleMapping> mappings = model.getMappings();
				String uriString = model.getTargetMetamodel().getNsURI();
				Map<String,RoleMapping> registeredMappings = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(uriString);
				if(registeredMappings == null || registeredMappings.size() == 0){
					return true;
				} else {
					for (RoleMapping mapping : mappings) {
						RoleMapping registeredMapping = registeredMappings.get(mapping.getName());
						if(registeredMapping == null){
							return true;
						}
						if(registeredMapping.eResource().getURI().equals(resource.getURI())){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		RoleMappingModel model = (RoleMappingModel) resource.getContents().get(0);
		if((resource.getErrors() == null || resource.getErrors().size() == 0)){
			List<RoleMapping> unRegisterables = IRoleMappingRegistry.INSTANCE.registerRoleMapping(model);
			if(unRegisterables != null && unRegisterables.size() > 0){
				IRoleMappingRegistry.INSTANCE.updateMappings(unRegisterables);
			}
			resource.addWarning("This Role Mapping Model was only registered temporarily.\nYou should consider to register it as extension.", model);
		}
		return Status.OK_STATUS;
	}
	
}
