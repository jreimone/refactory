/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.analysis;

import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver;

public class CoEvolutionDefinitionMetamodelReferenceResolver implements ICoedReferenceResolver<CoEvolutionDefinition, EPackage> {
	
	public void resolve(String identifier, CoEvolutionDefinition container, EReference reference, int position, boolean resolveFuzzy, final ICoedReferenceResolveResult<EPackage> result) {
		if(!resolveFuzzy){
			EPackage metamodel = EPackage.Registry.INSTANCE.getEPackage(identifier);
			if(metamodel != null){
				result.addMapping(identifier, metamodel);
			} else {
				result.setErrorMessage("Metamodel '" + identifier + "' not registered");
			}
		} else {
			Collection<Object> metamodels = EPackage.Registry.INSTANCE.values();
			for (Object object : metamodels) {
				if(object instanceof EPackage){
					EPackage metamodel = (EPackage) object;
					result.addMapping(metamodel.getNsURI(), metamodel);
				}
			}
		}
	}
	
	public String deResolve(EPackage metamodel, CoEvolutionDefinition container, EReference reference) {
		return metamodel.getNsURI();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
