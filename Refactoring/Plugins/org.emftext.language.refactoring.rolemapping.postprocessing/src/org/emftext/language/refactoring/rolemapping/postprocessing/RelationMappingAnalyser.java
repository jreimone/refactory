/**
 * 
 */
package org.emftext.language.refactoring.rolemapping.postprocessing;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource;

/**
 * This postprocessor checks if the EReferences to which the role relation was mapped are correctly ordered as specified in the 
 * corresponding metamodel. Besides that it will be checked if the EReferences really belong to and exist
 * between the EClasses to which the roles are mapped. 
 * 
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
			EList<ConcreteMapping> concreteMappings = mapping.getRoleToMetaelement();
			for (ConcreteMapping concreteMapping : concreteMappings) {
				if(concreteMapping.getOutgoingRelationMappings().size() > 0){
					addProblem(resource
							, ERoleMappingModelProblemType.CHECK_RELATIONS_BETWEEN_ECLASSES
							, "bug 1136: check whether the mapped references are correctly ordered and belong to those classes from the mapped roles"
							, concreteMapping);
				}
			}
		}
	}

}
