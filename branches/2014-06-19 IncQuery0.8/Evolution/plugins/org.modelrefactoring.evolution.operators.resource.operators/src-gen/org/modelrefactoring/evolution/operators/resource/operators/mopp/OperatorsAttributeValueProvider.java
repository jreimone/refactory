/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import org.eclipse.emf.ecore.EAttribute;

/**
 * This class provides sets of values for attributes. It is used by the code
 * completion processor.
 */
public class OperatorsAttributeValueProvider {
	
	public Object[] getDefaultValues(EAttribute attribute) {
		String typeName = attribute.getEType().getName();
		if ("EString".equals(typeName)) {
			return new Object[] {"some" + org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsStringUtil.capitalize(attribute.getName())};
		}
		if ("EBoolean".equals(typeName)) {
			return new Object[] {Boolean.TRUE, Boolean.FALSE};
		}
		return new Object[] {attribute.getDefaultValue()};
	}
	
}
