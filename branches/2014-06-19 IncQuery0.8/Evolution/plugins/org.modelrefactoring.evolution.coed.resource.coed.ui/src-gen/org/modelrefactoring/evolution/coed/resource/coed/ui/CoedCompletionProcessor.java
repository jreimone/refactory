/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;

public class CoedCompletionProcessor implements IContentAssistProcessor {
	
	private org.modelrefactoring.evolution.coed.resource.coed.ICoedResourceProvider resourceProvider;
	
	public CoedCompletionProcessor(org.modelrefactoring.evolution.coed.resource.coed.ICoedResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
	}
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCodeCompletionHelper helper = new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCodeCompletionHelper();
		org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.modelrefactoring.evolution.coed.resource.coed.ui.CoedProposalPostProcessor proposalPostProcessor = new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedProposalPostProcessor();
		List<org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCompletionProposal> computedProposalList = Arrays.asList(computedProposals);
		List<org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = Collections.emptyList();
		}
		List<org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCompletionProposal> finalProposalList = new ArrayList<org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCompletionProposal>();
		for (org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCompletionProposal proposal : extendedProposalList) {
			if (proposal.isMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		ICompletionProposal[] result = new ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = (proposal.getDisplayString()==null)?proposalString:proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			Image image = proposal.getImage();
			IContextInformation info;
			info = new ContextInformation(image, displayString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			result[i++] = new CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
