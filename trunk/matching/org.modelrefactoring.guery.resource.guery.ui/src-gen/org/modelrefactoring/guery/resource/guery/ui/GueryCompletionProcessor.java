/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.ui;

public class GueryCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.modelrefactoring.guery.resource.guery.IGueryResourceProvider resourceProvider;
	
	public GueryCompletionProcessor(org.modelrefactoring.guery.resource.guery.IGueryResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		org.modelrefactoring.guery.resource.guery.IGueryTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		org.modelrefactoring.guery.resource.guery.ui.GueryCodeCompletionHelper helper = new org.modelrefactoring.guery.resource.guery.ui.GueryCodeCompletionHelper();
		org.modelrefactoring.guery.resource.guery.ui.GueryCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.modelrefactoring.guery.resource.guery.ui.GueryProposalPostProcessor proposalPostProcessor = new org.modelrefactoring.guery.resource.guery.ui.GueryProposalPostProcessor();
		java.util.List<org.modelrefactoring.guery.resource.guery.ui.GueryCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<org.modelrefactoring.guery.resource.guery.ui.GueryCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<org.modelrefactoring.guery.resource.guery.ui.GueryCompletionProposal> finalProposalList = new java.util.ArrayList<org.modelrefactoring.guery.resource.guery.ui.GueryCompletionProposal>();
		for (org.modelrefactoring.guery.resource.guery.ui.GueryCompletionProposal proposal : extendedProposalList) {
			if (proposal.isMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.modelrefactoring.guery.resource.guery.ui.GueryCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = (proposal.getDisplayString()==null)?proposalString:proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, displayString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
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
