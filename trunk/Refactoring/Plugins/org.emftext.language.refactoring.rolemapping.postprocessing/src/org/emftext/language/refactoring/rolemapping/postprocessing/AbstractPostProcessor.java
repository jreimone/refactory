/**
 * 
 */
package org.emftext.language.refactoring.rolemapping.postprocessing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingResourcePostProcessor;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingResourcePostProcessorProvider;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.RolemappingEProblemType;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingProblem;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource;

/**
 * Abstract class for all post processors for the role mapping DSL.
 * 
 * @author Jan Reimann
 *
 */
public abstract class AbstractPostProcessor implements
		IRolemappingResourcePostProcessor,
		IRolemappingResourcePostProcessorProvider {

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingResourcePostProcessor#process(org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource)
	 */
	public void process(RolemappingResource resource) {
		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if(eObject instanceof RoleMappingModel){
				analyse(resource, (RoleMappingModel) eObject);
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingResourcePostProcessorProvider#getResourcePostProcessor()
	 */
	public IRolemappingResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	protected void addProblem(RolemappingResource resource, ERoleMappingModelProblemType problemType, String message, EObject cause){
		resource.addProblem(new RolemappingProblem(message, RolemappingEProblemType.ANALYSIS_PROBLEM, problemType.getProblemSeverity()), cause);
	}
	
	public abstract void analyse(RolemappingResource resource, RoleMappingModel model);
	
}
