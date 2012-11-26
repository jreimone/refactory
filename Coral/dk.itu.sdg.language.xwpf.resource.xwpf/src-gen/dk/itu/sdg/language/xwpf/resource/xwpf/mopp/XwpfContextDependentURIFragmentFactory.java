/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class XwpfContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public XwpfContextDependentURIFragmentFactory(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
