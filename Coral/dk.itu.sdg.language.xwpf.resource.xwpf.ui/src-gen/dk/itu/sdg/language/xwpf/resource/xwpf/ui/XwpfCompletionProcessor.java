/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

public class XwpfCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfResourceProvider resourceProvider;
	private dk.itu.sdg.language.xwpf.resource.xwpf.ui.IXwpfBracketHandlerProvider bracketHandlerProvider;
	
	public XwpfCompletionProcessor(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfResourceProvider resourceProvider, dk.itu.sdg.language.xwpf.resource.xwpf.ui.IXwpfBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCodeCompletionHelper helper = new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCodeCompletionHelper();
		dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfProposalPostProcessor proposalPostProcessor = new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfProposalPostProcessor();
		java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCompletionProposal> finalProposalList = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCompletionProposal>();
		for (dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCompletionProposal proposal : finalProposalList) {
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
			dk.itu.sdg.language.xwpf.resource.xwpf.ui.IXwpfBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
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
