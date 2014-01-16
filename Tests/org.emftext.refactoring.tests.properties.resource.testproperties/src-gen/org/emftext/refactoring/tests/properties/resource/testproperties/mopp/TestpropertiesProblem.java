/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class TestpropertiesProblem implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesProblem {
	
	private String message;
	private org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType type;
	private org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity severity;
	private Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> quickFixes;
	
	public TestpropertiesProblem(String message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType type, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity severity) {
		this(message, type, severity, Collections.<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix>emptySet());
	}
	
	public TestpropertiesProblem(String message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType type, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity severity, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public TestpropertiesProblem(String message, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType type, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity severity, Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix>();
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
	
	public Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
