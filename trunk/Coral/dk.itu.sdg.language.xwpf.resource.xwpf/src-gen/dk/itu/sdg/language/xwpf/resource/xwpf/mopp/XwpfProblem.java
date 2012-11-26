/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfProblem implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfProblem {
	
	private String message;
	private dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType type;
	private dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity severity;
	private java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> quickFixes;
	
	public XwpfProblem(String message, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType type, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix>emptySet());
	}
	
	public XwpfProblem(String message, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType type, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity severity, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public XwpfProblem(String message, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType type, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity severity, java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType getType() {
		return type;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
