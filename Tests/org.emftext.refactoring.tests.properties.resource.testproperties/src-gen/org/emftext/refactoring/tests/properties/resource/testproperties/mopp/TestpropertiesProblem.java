/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

public class TestpropertiesProblem implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem {
	
	private String message;
	private org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType type;
	private org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity severity;
	private java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> quickFixes;
	
	public TestpropertiesProblem(String message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType type, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix>emptySet());
	}
	
	public TestpropertiesProblem(String message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType type, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity severity, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public TestpropertiesProblem(String message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType type, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity severity, java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType getType() {
		return type;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
