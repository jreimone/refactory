/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class XwpfProposalPostProcessor {
	
	public java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCompletionProposal> process(java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
