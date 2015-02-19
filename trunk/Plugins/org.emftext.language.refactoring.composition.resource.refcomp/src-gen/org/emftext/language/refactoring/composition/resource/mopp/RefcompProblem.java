/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class RefcompProblem implements org.emftext.language.refactoring.composition.resource.IRefcompProblem {
	
	private String message;
	private org.emftext.language.refactoring.composition.resource.RefcompEProblemType type;
	private org.emftext.language.refactoring.composition.resource.RefcompEProblemSeverity severity;
	private Collection<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix> quickFixes;
	
	public RefcompProblem(String message, org.emftext.language.refactoring.composition.resource.RefcompEProblemType type, org.emftext.language.refactoring.composition.resource.RefcompEProblemSeverity severity) {
		this(message, type, severity, Collections.<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix>emptySet());
	}
	
	public RefcompProblem(String message, org.emftext.language.refactoring.composition.resource.RefcompEProblemType type, org.emftext.language.refactoring.composition.resource.RefcompEProblemSeverity severity, org.emftext.language.refactoring.composition.resource.IRefcompQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public RefcompProblem(String message, org.emftext.language.refactoring.composition.resource.RefcompEProblemType type, org.emftext.language.refactoring.composition.resource.RefcompEProblemSeverity severity, Collection<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.language.refactoring.composition.resource.RefcompEProblemType getType() {
		return type;
	}
	
	public org.emftext.language.refactoring.composition.resource.RefcompEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
