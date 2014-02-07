/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.analysis;

import org.eclipse.emf.ecore.EReference;

public class CoEvolutionDefinitionMetamodelReferenceResolver implements org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<org.modelrefactoring.evolution.coed.CoEvolutionDefinition, org.eclipse.emf.ecore.EPackage> {
	
	private org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedDefaultResolverDelegate<org.modelrefactoring.evolution.coed.CoEvolutionDefinition, org.eclipse.emf.ecore.EPackage> delegate = new org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedDefaultResolverDelegate<org.modelrefactoring.evolution.coed.CoEvolutionDefinition, org.eclipse.emf.ecore.EPackage>();
	
	public void resolve(String identifier, org.modelrefactoring.evolution.coed.CoEvolutionDefinition container, EReference reference, int position, boolean resolveFuzzy, final org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EPackage element, org.modelrefactoring.evolution.coed.CoEvolutionDefinition container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
