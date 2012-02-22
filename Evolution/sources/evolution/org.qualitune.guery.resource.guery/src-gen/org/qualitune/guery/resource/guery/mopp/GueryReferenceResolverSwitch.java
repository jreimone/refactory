/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

public class GueryReferenceResolverSwitch implements org.qualitune.guery.resource.guery.IGueryReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected org.qualitune.guery.resource.guery.analysis.ConnectionFromReferenceResolver connectionFromReferenceResolver = new org.qualitune.guery.resource.guery.analysis.ConnectionFromReferenceResolver();
	protected org.qualitune.guery.resource.guery.analysis.ConnectionToReferenceResolver connectionToReferenceResolver = new org.qualitune.guery.resource.guery.analysis.ConnectionToReferenceResolver();
	
	public org.qualitune.guery.resource.guery.IGueryReferenceResolver<org.qualitune.guery.Connection, org.qualitune.guery.Role> getConnectionFromReferenceResolver() {
		return getResolverChain(org.qualitune.guery.GueryPackage.eINSTANCE.getConnection_From(), connectionFromReferenceResolver);
	}
	
	public org.qualitune.guery.resource.guery.IGueryReferenceResolver<org.qualitune.guery.Connection, org.qualitune.guery.Role> getConnectionToReferenceResolver() {
		return getResolverChain(org.qualitune.guery.GueryPackage.eINSTANCE.getConnection_To(), connectionToReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		connectionFromReferenceResolver.setOptions(options);
		connectionToReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.qualitune.guery.resource.guery.IGueryReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.qualitune.guery.GueryPackage.eINSTANCE.getConnection().isInstance(container)) {
			GueryFuzzyResolveResult<org.qualitune.guery.Role> frr = new GueryFuzzyResolveResult<org.qualitune.guery.Role>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("from")) {
				connectionFromReferenceResolver.resolve(identifier, (org.qualitune.guery.Connection) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.qualitune.guery.GueryPackage.eINSTANCE.getConnection().isInstance(container)) {
			GueryFuzzyResolveResult<org.qualitune.guery.Role> frr = new GueryFuzzyResolveResult<org.qualitune.guery.Role>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("to")) {
				connectionToReferenceResolver.resolve(identifier, (org.qualitune.guery.Connection) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.qualitune.guery.resource.guery.IGueryReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.qualitune.guery.GueryPackage.eINSTANCE.getConnection_From()) {
			return getResolverChain(reference, connectionFromReferenceResolver);
		}
		if (reference == org.qualitune.guery.GueryPackage.eINSTANCE.getConnection_To()) {
			return getResolverChain(reference, connectionToReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.qualitune.guery.resource.guery.IGueryReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.qualitune.guery.resource.guery.IGueryReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.qualitune.guery.resource.guery.IGueryOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().logWarning("Found value with invalid type for option " + org.qualitune.guery.resource.guery.IGueryOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.qualitune.guery.resource.guery.IGueryReferenceResolver) {
			org.qualitune.guery.resource.guery.IGueryReferenceResolver replacingResolver = (org.qualitune.guery.resource.guery.IGueryReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.qualitune.guery.resource.guery.IGueryDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.qualitune.guery.resource.guery.IGueryDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.qualitune.guery.resource.guery.IGueryReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.qualitune.guery.resource.guery.IGueryReferenceCache) {
					org.qualitune.guery.resource.guery.IGueryReferenceResolver nextResolver = (org.qualitune.guery.resource.guery.IGueryReferenceResolver) next;
					if (nextResolver instanceof org.qualitune.guery.resource.guery.IGueryDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.qualitune.guery.resource.guery.IGueryDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.qualitune.guery.resource.guery.IGueryOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.qualitune.guery.resource.guery.IGueryDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.qualitune.guery.resource.guery.util.GueryRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.qualitune.guery.resource.guery.IGueryOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.qualitune.guery.resource.guery.IGueryDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
