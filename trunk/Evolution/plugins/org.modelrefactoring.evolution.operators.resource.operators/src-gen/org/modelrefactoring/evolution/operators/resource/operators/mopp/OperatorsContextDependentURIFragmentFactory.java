/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <p>
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * </p>
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class OperatorsContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public OperatorsContextDependentURIFragmentFactory(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy) {
		
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
