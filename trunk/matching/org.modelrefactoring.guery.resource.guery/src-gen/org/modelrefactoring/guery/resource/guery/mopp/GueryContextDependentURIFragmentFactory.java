/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class GueryContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.modelrefactoring.guery.resource.guery.IGueryContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.modelrefactoring.guery.resource.guery.IGueryReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public GueryContextDependentURIFragmentFactory(org.modelrefactoring.guery.resource.guery.IGueryReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.modelrefactoring.guery.resource.guery.IGueryReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
