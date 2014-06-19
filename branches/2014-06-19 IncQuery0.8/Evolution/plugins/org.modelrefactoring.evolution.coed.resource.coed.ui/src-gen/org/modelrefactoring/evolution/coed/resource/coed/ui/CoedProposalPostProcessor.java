/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class CoedProposalPostProcessor {
	
	public List<org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCompletionProposal> process(List<org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
