/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class TestpropertiesContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public TestpropertiesContextDependentURIFragmentFactory(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
