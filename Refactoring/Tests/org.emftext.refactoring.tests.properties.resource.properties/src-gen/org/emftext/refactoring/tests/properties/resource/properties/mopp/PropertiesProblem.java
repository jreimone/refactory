/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesProblem implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesProblem {
	
	private java.lang.String message;
	private org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType type;
	
	public PropertiesProblem(java.lang.String message, org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType type) {
		super();
		this.message = message;
		this.type = type;
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType getType() {
		return type;
	}
	
	public java.lang.String getMessage() {
		return message;
	}
	
}
