/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GueryProblem implements org.modelrefactoring.guery.resource.guery.IGueryProblem {
	
	private String message;
	private org.modelrefactoring.guery.resource.guery.GueryEProblemType type;
	private org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity severity;
	private java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryQuickFix> quickFixes;
	
	public GueryProblem(String message, org.modelrefactoring.guery.resource.guery.GueryEProblemType type, org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.modelrefactoring.guery.resource.guery.IGueryQuickFix>emptySet());
	}
	
	public GueryProblem(String message, org.modelrefactoring.guery.resource.guery.GueryEProblemType type, org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity severity, org.modelrefactoring.guery.resource.guery.IGueryQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public GueryProblem(String message, org.modelrefactoring.guery.resource.guery.GueryEProblemType type, org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity severity, java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.modelrefactoring.guery.resource.guery.IGueryQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.modelrefactoring.guery.resource.guery.GueryEProblemType getType() {
		return type;
	}
	
	public org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
