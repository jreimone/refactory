/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

public class TestpropertiesCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourceProvider resourceProvider;
	private org.emftext.refactoring.tests.properties.resource.testproperties.ui.ITestpropertiesBracketHandlerProvider bracketHandlerProvider;
	
	public TestpropertiesCompletionProcessor(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourceProvider resourceProvider, org.emftext.refactoring.tests.properties.resource.testproperties.ui.ITestpropertiesBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCodeCompletionHelper helper = new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCodeCompletionHelper();
		org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesProposalPostProcessor proposalPostProcessor = new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesProposalPostProcessor();
		java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal> finalProposalList = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal>();
		for (org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal proposal : finalProposalList) {
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
			org.emftext.refactoring.tests.properties.resource.testproperties.ui.ITestpropertiesBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
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
