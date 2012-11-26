/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf;

public interface IXwpfProblem {
	public String getMessage();
	public dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity getSeverity();
	public dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType getType();
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> getQuickFixes();
}
