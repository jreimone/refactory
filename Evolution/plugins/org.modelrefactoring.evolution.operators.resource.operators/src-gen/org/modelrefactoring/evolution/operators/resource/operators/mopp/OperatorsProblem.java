/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class OperatorsProblem implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsProblem {
	
	private String message;
	private org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType type;
	private org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemSeverity severity;
	private Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix> quickFixes;
	
	public OperatorsProblem(String message, org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType type, org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemSeverity severity) {
		this(message, type, severity, Collections.<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix>emptySet());
	}
	
	public OperatorsProblem(String message, org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType type, org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemSeverity severity, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public OperatorsProblem(String message, org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType type, org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemSeverity severity, Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType getType() {
		return type;
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
