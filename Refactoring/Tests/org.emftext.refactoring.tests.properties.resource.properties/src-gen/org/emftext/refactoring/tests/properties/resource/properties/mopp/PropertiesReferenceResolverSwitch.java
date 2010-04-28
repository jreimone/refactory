/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesReferenceResolverSwitch implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolverSwitch {
	
	protected org.emftext.refactoring.tests.properties.resource.properties.analysis.EObjectReferenceValueObjectReferenceReferenceResolver eObjectReferenceValueObjectReferenceReferenceResolver = new org.emftext.refactoring.tests.properties.resource.properties.analysis.EObjectReferenceValueObjectReferenceReferenceResolver();
	
	public org.emftext.refactoring.tests.properties.resource.properties.analysis.EObjectReferenceValueObjectReferenceReferenceResolver getEObjectReferenceValueObjectReferenceReferenceResolver() {
		return eObjectReferenceValueObjectReferenceReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		eObjectReferenceValueObjectReferenceReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue().isInstance(container)) {
			PropertiesFuzzyResolveResult<org.eclipse.emf.ecore.EObject> frr = new PropertiesFuzzyResolveResult<org.eclipse.emf.ecore.EObject>(result);
			java.lang.String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("objectReference")) {
				eObjectReferenceValueObjectReferenceReferenceResolver.resolve(identifier, (org.emftext.refactoring.tests.properties.EObjectReferenceValue) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue_ObjectReference()) {
			return eObjectReferenceValueObjectReferenceReferenceResolver;
		}
		return null;
	}
	
}
