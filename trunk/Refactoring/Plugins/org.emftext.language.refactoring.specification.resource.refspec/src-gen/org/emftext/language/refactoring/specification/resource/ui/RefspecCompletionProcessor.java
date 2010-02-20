/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.ui;

public class RefspecCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.emftext.language.refactoring.specification.resource.ui.RefspecEditor editor;
	
	public RefspecCompletionProcessor(org.emftext.language.refactoring.specification.resource.ui.RefspecEditor editor) {
		this.editor = editor;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		
		org.eclipse.emf.ecore.resource.Resource resource = editor.getResource();
		org.emftext.language.refactoring.specification.resource.IRefspecTextResource textResource = (org.emftext.language.refactoring.specification.resource.IRefspecTextResource) resource;
		String content = viewer.getDocument().get();
		org.emftext.language.refactoring.specification.resource.mopp.RefspecCodeCompletionHelper helper = new org.emftext.language.refactoring.specification.resource.mopp.RefspecCodeCompletionHelper();
		org.emftext.language.refactoring.specification.resource.mopp.RefspecCompletionProposal[] proposals = helper.computeCompletionProposals(textResource, content, offset);
		
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[proposals.length];
		int i = 0;
		for (org.emftext.language.refactoring.specification.resource.mopp.RefspecCompletionProposal proposal : proposals) {
			String proposalString = proposal.getInsertString();
			String prefix = proposal.getPrefix();
			org.eclipse.jface.text.contentassist.IContextInformation info = new org.eclipse.jface.text.contentassist.ContextInformation(proposalString, proposalString);
			int begin = offset - prefix.length();
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, prefix.length(), proposalString.length(), null, proposalString, info, proposalString);
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
