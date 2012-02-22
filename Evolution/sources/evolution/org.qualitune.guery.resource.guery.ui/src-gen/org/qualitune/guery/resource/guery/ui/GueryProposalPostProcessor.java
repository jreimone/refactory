/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class GueryProposalPostProcessor {
	
	public java.util.List<org.qualitune.guery.resource.guery.ui.GueryCompletionProposal> process(java.util.List<org.qualitune.guery.resource.guery.ui.GueryCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
