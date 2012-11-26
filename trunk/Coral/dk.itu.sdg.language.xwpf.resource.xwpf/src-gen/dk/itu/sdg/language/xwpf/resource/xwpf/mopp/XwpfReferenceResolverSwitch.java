/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfReferenceResolverSwitch implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logWarning("Found value with invalid type for option " + dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver) {
			dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver replacingResolver = (dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver) resolverValue;
			if (replacingResolver instanceof dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceCache) {
					dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver nextResolver = (dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver) next;
					if (nextResolver instanceof dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logWarning("Found value with invalid type in value map for option " + dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfRuntimeUtil().logWarning("Found value with invalid type in value map for option " + dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
