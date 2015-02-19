package org.emftext.language.refactoring.composition.resource.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolveResult;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public abstract class AbstractRoleMappingResolver {

	public AbstractRoleMappingResolver() {
		super();
	}

	public void resolve(String identifier, boolean resolveFuzzy, final IRefcompReferenceResolveResult<RoleMapping> result) {
		EPackage targetMetamodel = getMetamodel();
		Map<String, RoleMapping> roleMappings = IRoleMappingRegistry.INSTANCE.getRoleMappingsForUri(targetMetamodel.getNsURI());
		if(resolveFuzzy){
			for (String roleMappingName : roleMappings.keySet()) {
				result.addMapping(roleMappingName, roleMappings.get(roleMappingName));
			}
			return;
		}
		RoleMapping roleMapping = roleMappings.get(identifier);
		if(roleMapping == null){
			result.setErrorMessage("No role mapping '" + identifier + "' registered for " + targetMetamodel.getNsURI());
			return;
		}
		EcoreUtil.resolveAll(roleMapping);
		result.addMapping(identifier, roleMapping);
	}

	protected abstract EPackage getMetamodel();

	public String deResolve(RoleMapping element) {
		return element.getName();
	}

	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}

}