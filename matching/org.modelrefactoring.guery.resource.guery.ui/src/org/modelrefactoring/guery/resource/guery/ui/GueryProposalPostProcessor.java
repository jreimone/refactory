/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class GueryProposalPostProcessor {
	
	public java.util.List<org.modelrefactoring.guery.resource.guery.ui.GueryCompletionProposal> process(java.util.List<org.modelrefactoring.guery.resource.guery.ui.GueryCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
//		for (GueryCompletionProposal completionProposal : proposals) {
//			EStructuralFeature structuralFeature = completionProposal.getStructuralFeature();
//			if(structuralFeature.getEType().equals(GueryPackage.Literals.CONSTRAINT__EXPRESSION)){
//				
//			}
//		}
		return proposals;
	}
	
}
