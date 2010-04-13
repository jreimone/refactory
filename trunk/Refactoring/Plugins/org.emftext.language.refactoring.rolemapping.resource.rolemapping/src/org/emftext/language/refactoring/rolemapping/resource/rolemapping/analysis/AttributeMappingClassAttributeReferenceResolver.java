/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;

public class AttributeMappingClassAttributeReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.AttributeMapping, org.eclipse.emf.ecore.EAttribute> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.AttributeMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.EAttribute> result) {
		EObject parent = container.eContainer();
		if(!(parent instanceof ConcreteMapping)){
			result.setErrorMessage("Invalid RoleMapping Model");
			return;
		}
		ConcreteMapping mapping = (ConcreteMapping) parent;
		EClass mappedClass = mapping.getMetaclass();
		EList<EAttribute> attributes = mappedClass.getEAllAttributes();
		for (EAttribute attribute : attributes) {
			if(attribute.getName().equals(identifier)){
				result.addMapping(identifier, attribute);
				return;
			}
		}
		result.setErrorMessage("Mapped class '" + mappedClass.getName() + "' has no attribute called '" + identifier + "'");
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EAttribute element, org.emftext.language.refactoring.rolemapping.AttributeMapping container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
