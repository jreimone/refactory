/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class PropertiesContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public PropertiesContextDependentURIFragmentFactory(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
