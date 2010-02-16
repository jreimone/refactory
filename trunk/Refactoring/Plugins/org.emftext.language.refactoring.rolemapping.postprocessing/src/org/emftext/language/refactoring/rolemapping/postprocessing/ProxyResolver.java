/**
 * 
 */
package org.emftext.language.refactoring.rolemapping.postprocessing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource;
import org.emftext.language.refactoring.roles.RoleModel;

/**
 * @author Jan Reimann
 *
 */
public class ProxyResolver extends AbstractPostProcessor {

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.rolemapping.postprocessing.AbstractPostProcessor#analyse(org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource, org.emftext.language.refactoring.rolemapping.RoleMappingModel)
	 */
	@Override
	public void analyse(RolemappingResource resource, RoleMappingModel model) {
		EList<Mapping> mappings = model.getMappings();
		for (Mapping mapping : mappings) {
			RoleModel roleModel = mapping.getMappedRoleModel();
			EcoreUtil.resolveAll(roleModel);
		}
	}

}
