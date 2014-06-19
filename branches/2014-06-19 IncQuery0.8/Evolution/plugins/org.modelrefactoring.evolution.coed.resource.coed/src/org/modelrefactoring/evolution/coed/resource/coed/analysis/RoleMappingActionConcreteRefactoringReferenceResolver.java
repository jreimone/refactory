/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.modelrefactoring.evolution.coed.RoleMappingAction;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver;

public class RoleMappingActionConcreteRefactoringReferenceResolver implements ICoedReferenceResolver<RoleMappingAction, RoleMapping> {
	
	public void resolve(String identifier, RoleMappingAction action, EReference reference, int position, boolean resolveFuzzy, final ICoedReferenceResolveResult<RoleMapping> result) {
		EPackage metamodel = action.getCoED().getMetamodel();
		if(metamodel != null){
			Map<String, RoleMapping> roleMappingsForUri = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(metamodel.getNsURI());
			if(!resolveFuzzy){
				RoleMapping roleMapping = roleMappingsForUri.get(identifier);
				if(roleMapping != null){
					result.addMapping(identifier, roleMapping);
				} else {
					result.setErrorMessage("RoleMapping '" + identifier + "' doesn't exist for metamodel " + metamodel.getNsURI());
				}
			} else {
				for (String rolemappingName : roleMappingsForUri.keySet()) {
					result.addMapping(rolemappingName, roleMappingsForUri.get(rolemappingName));
				}
			}
		}
	}
	
	public String deResolve(RoleMapping rolemapping, RoleMappingAction container, EReference reference) {
		return rolemapping.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
