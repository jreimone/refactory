/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import org.eclipse.emf.ecore.EAttribute;

/**
 * This class provides sets of values for attributes. It is used by the code
 * completion processor.
 */
public class TestpropertiesAttributeValueProvider {
	
	public Object[] getDefaultValues(EAttribute attribute) {
		String typeName = attribute.getEType().getName();
		if ("EString".equals(typeName)) {
			return new Object[] {"some" + org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesStringUtil.capitalize(attribute.getName())};
		}
		if ("EBoolean".equals(typeName)) {
			return new Object[] {Boolean.TRUE, Boolean.FALSE};
		}
		return new Object[] {attribute.getDefaultValue()};
	}
	
}
