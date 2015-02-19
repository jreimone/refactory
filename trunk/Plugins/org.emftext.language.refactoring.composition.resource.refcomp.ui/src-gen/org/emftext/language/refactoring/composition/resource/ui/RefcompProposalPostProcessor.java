/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class RefcompProposalPostProcessor {
	
	public List<org.emftext.language.refactoring.composition.resource.ui.RefcompCompletionProposal> process(List<org.emftext.language.refactoring.composition.resource.ui.RefcompCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
