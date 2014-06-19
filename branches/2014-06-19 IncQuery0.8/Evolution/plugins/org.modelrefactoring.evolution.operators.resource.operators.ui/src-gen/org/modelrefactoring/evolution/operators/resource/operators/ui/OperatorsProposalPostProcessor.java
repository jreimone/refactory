/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class OperatorsProposalPostProcessor {
	
	public List<org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsCompletionProposal> process(List<org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
