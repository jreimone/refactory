/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.modelrefactoring.evolution.coed.MetamodelImport;
import org.modelrefactoring.evolution.coed.RoleMappingEvent;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver;

public class RoleMappingEventConcreteRefactoringReferenceResolver implements ICoedReferenceResolver<RoleMappingEvent, RoleMapping> {
	
	public void resolve(String identifier, RoleMappingEvent rolemappingEvent, EReference reference, int position, boolean resolveFuzzy, final ICoedReferenceResolveResult<RoleMapping> result) {
		MetamodelImport metamodelImport = rolemappingEvent.getMetamodelImport();
		Map<String, RoleMapping> roleMappingsForUri = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(metamodelImport.getMetamodel().getNsURI());
		if(!resolveFuzzy){
			RoleMapping roleMapping = roleMappingsForUri.get(identifier);
			if(roleMapping != null){
				result.addMapping(identifier, roleMapping);
			} else {
				result.setErrorMessage("RoleMapping '" + identifier + "' doesn't exist for metamodel " + metamodelImport.getShortcut() + ":" + metamodelImport.getMetamodel().getNsURI());
			}
		} else {
			for (String rolemappingName : roleMappingsForUri.keySet()) {
				result.addMapping(rolemappingName, roleMappingsForUri.get(rolemappingName));
			}
		}
	}
	
	public String deResolve(RoleMapping rolemapping, RoleMappingEvent container, EReference reference) {
		return rolemapping.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
