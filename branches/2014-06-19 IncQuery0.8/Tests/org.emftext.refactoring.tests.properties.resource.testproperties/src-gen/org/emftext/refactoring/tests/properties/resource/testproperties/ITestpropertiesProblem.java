/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties;

import java.util.Collection;

public interface ITestpropertiesProblem {
	public String getMessage();
	public org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity getSeverity();
	public org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType getType();
	public Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> getQuickFixes();
}
