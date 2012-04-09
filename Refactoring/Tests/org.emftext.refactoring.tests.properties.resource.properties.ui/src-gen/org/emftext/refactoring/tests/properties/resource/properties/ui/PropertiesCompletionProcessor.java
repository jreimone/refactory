/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

public class PropertiesCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.emftext.refactoring.tests.properties.resource.properties.IPropertiesResourceProvider resourceProvider;
	private org.emftext.refactoring.tests.properties.resource.properties.ui.IPropertiesBracketHandlerProvider bracketHandlerProvider;
	
	public PropertiesCompletionProcessor(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesResourceProvider resourceProvider, org.emftext.refactoring.tests.properties.resource.properties.ui.IPropertiesBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource textResource = resourceProvider.getResource();
		String content = viewer.getDocument().get();
		org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCodeCompletionHelper helper = new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCodeCompletionHelper();
		org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesProposalPostProcessor proposalPostProcessor = new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesProposalPostProcessor();
		java.util.List<org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCompletionProposal> finalProposalList = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCompletionProposal>();
		for (org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCompletionProposal proposal : finalProposalList) {
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
			org.emftext.refactoring.tests.properties.resource.properties.ui.IPropertiesBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
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
