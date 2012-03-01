/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.ui;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.qualitune.guery.GueryPackage;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class GueryProposalPostProcessor {
	
	public java.util.List<GueryCompletionProposal> process(java.util.List<GueryCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		for (GueryCompletionProposal completionProposal : proposals) {
			EStructuralFeature structuralFeature = completionProposal.getStructuralFeature();
			if(structuralFeature.getEType().equals(GueryPackage.Literals.CONSTRAINT__EXPRESSION)){
				
			}
		}
		return proposals;
	}
	
}
