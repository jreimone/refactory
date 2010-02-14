/**
 * 
 */
package org.emftext.language.refactoring.rolemapping.postprocessing;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource;

/**
 * @author Jan Reimann
 *
 */
public class RelationMappingAnalyser extends AbstractPostProcessor {

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.rolemapping.postprocessing.AbstractPostProcessor#analyse(org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource, org.emftext.language.refactoring.rolemapping.RoleMappingModel)
	 */
	@Override
	public void analyse(RolemappingResource resource, RoleMappingModel model) {
		EList<Mapping> mappings = model.getMappings();
		for (Mapping mapping : mappings) {
			EList<RelationMapping> relationMappings = mapping.getRelationMappings();
			if(relationMappings.size() > 0){
				addProblem(resource
						, ERoleMappingModelProblemType.CHECK_RELATIONS_BETWEEN_ECLASSES
						, "bug 16: check whether the mapped references are correctly ordered and belong to those classes from the mapped roles"
						, mapping);
			}
		}
	}

}
