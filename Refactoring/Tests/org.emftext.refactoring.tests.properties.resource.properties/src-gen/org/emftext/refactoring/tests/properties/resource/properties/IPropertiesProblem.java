/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties;

public interface IPropertiesProblem {
	public String getMessage();
	public org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemSeverity getSeverity();
	public org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType getType();
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> getQuickFixes();
}
