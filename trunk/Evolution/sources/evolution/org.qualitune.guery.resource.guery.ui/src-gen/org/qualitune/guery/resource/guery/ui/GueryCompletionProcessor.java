/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.ui;

public class GueryCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.qualitune.guery.resource.guery.IGueryResourceProvider resourceProvider;
	private org.qualitune.guery.resource.guery.ui.IGueryBracketHandlerProvider bracketHandlerProvider;
	
	public GueryCompletionProcessor(org.qualitune.guery.resource.guery.IGueryResourceProvider resourceProvider, org.qualitune.guery.resource.guery.ui.IGueryBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		org.qualitune.guery.resource.guery.IGueryTextResource textResource = resourceProvider.getResource();
		String content = viewer.getDocument().get();
		org.qualitune.guery.resource.guery.ui.GueryCodeCompletionHelper helper = new org.qualitune.guery.resource.guery.ui.GueryCodeCompletionHelper();
		org.qualitune.guery.resource.guery.ui.GueryCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.qualitune.guery.resource.guery.ui.GueryProposalPostProcessor proposalPostProcessor = new org.qualitune.guery.resource.guery.ui.GueryProposalPostProcessor();
		java.util.List<org.qualitune.guery.resource.guery.ui.GueryCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<org.qualitune.guery.resource.guery.ui.GueryCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<org.qualitune.guery.resource.guery.ui.GueryCompletionProposal> finalProposalList = new java.util.ArrayList<org.qualitune.guery.resource.guery.ui.GueryCompletionProposal>();
		for (org.qualitune.guery.resource.guery.ui.GueryCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.qualitune.guery.resource.guery.ui.GueryCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			org.qualitune.guery.resource.guery.ui.IGueryBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
