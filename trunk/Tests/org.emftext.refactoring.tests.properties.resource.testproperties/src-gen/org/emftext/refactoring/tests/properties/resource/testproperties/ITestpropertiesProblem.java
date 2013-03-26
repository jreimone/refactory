/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties;

public interface ITestpropertiesProblem {
	public String getMessage();
	public org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity getSeverity();
	public org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType getType();
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> getQuickFixes();
}
