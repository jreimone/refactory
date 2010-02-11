/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

// A factory for ContextDependentURIFragments. Given a feasible reference resolver,
// the factory returns a matching fragment that used the resolver to resolver proxy
// objects.
//
// @param <ContainerType> the type of the class containing the reference to be resolved
// @param <ReferenceType> the type of the reference to be resolved
//
public class RolestextContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.emftext.language.refactoring.roles.resource.rolestext.IRolestextReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public RolestextContextDependentURIFragmentFactory(org.emftext.language.refactoring.roles.resource.rolestext.IRolestextReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
