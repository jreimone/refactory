/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class CoedContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements org.modelrefactoring.evolution.coed.resource.coed.ICoedContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public CoedContextDependentURIFragmentFactory(org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy) {
		
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
