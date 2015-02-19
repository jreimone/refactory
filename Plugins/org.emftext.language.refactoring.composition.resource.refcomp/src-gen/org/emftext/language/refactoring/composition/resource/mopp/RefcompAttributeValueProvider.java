/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import org.eclipse.emf.ecore.EAttribute;

/**
 * This class provides sets of values for attributes. It is used by the code
 * completion processor.
 */
public class RefcompAttributeValueProvider {
	
	public Object[] getDefaultValues(EAttribute attribute) {
		String typeName = attribute.getEType().getName();
		if ("EString".equals(typeName)) {
			return new Object[] {"some" + org.emftext.language.refactoring.composition.resource.util.RefcompStringUtil.capitalize(attribute.getName())};
		}
		if ("EBoolean".equals(typeName)) {
			return new Object[] {Boolean.TRUE, Boolean.FALSE};
		}
		return new Object[] {attribute.getDefaultValue()};
	}
	
}
