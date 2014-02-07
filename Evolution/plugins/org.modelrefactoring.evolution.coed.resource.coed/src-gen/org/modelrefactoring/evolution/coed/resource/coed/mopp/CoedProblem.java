/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class CoedProblem implements org.modelrefactoring.evolution.coed.resource.coed.ICoedProblem {
	
	private String message;
	private org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType type;
	private org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity severity;
	private Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix> quickFixes;
	
	public CoedProblem(String message, org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType type, org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity severity) {
		this(message, type, severity, Collections.<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix>emptySet());
	}
	
	public CoedProblem(String message, org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType type, org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity severity, org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public CoedProblem(String message, org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType type, org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity severity, Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType getType() {
		return type;
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
