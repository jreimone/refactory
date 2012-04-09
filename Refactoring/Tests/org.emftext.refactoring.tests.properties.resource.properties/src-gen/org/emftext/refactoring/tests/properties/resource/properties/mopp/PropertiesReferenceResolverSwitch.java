/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesReferenceResolverSwitch implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected org.emftext.refactoring.tests.properties.resource.properties.analysis.EObjectReferenceValueObjectReferenceReferenceResolver eObjectReferenceValueObjectReferenceReferenceResolver = new org.emftext.refactoring.tests.properties.resource.properties.analysis.EObjectReferenceValueObjectReferenceReferenceResolver();
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver<org.emftext.refactoring.tests.properties.EObjectReferenceValue, org.eclipse.emf.ecore.EObject> getEObjectReferenceValueObjectReferenceReferenceResolver() {
		return getResolverChain(org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue_ObjectReference(), eObjectReferenceValueObjectReferenceReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		eObjectReferenceValueObjectReferenceReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue().isInstance(container)) {
			PropertiesFuzzyResolveResult<org.eclipse.emf.ecore.EObject> frr = new PropertiesFuzzyResolveResult<org.eclipse.emf.ecore.EObject>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("objectReference")) {
				eObjectReferenceValueObjectReferenceReferenceResolver.resolve(identifier, (org.emftext.refactoring.tests.properties.EObjectReferenceValue) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue_ObjectReference()) {
			return getResolverChain(reference, eObjectReferenceValueObjectReferenceReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesRuntimeUtil().logWarning("Found value with invalid type for option " + org.emftext.refactoring.tests.properties.resource.properties.IPropertiesOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver) {
			org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver replacingResolver = (org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.emftext.refactoring.tests.properties.resource.properties.IPropertiesDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.emftext.refactoring.tests.properties.resource.properties.IPropertiesDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceCache) {
					org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver nextResolver = (org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver) next;
					if (nextResolver instanceof org.emftext.refactoring.tests.properties.resource.properties.IPropertiesDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.emftext.refactoring.tests.properties.resource.properties.IPropertiesDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.refactoring.tests.properties.resource.properties.IPropertiesOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.refactoring.tests.properties.resource.properties.IPropertiesDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.refactoring.tests.properties.resource.properties.IPropertiesOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.refactoring.tests.properties.resource.properties.IPropertiesDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
