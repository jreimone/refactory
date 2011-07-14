/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

public class PropertiesQuickAssistProcessor implements org.eclipse.jface.text.quickassist.IQuickAssistProcessor {
	
	private org.emftext.refactoring.tests.properties.resource.properties.IPropertiesResourceProvider resourceProvider;
	private org.emftext.refactoring.tests.properties.resource.properties.ui.IPropertiesAnnotationModelProvider annotationModelProvider;
	
	public PropertiesQuickAssistProcessor(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesResourceProvider resourceProvider, org.emftext.refactoring.tests.properties.resource.properties.ui.IPropertiesAnnotationModelProvider annotationModelProvider) {
		super();
		this.resourceProvider = resourceProvider;
		this.annotationModelProvider = annotationModelProvider;
	}
	
	public boolean canAssist(org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext invocationContext) {
		return false;
	}
	
	public boolean canFix(org.eclipse.jface.text.source.Annotation annotation) {
		java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> quickFixes = getQuickFixes(annotation);
		return quickFixes.size() > 0;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeQuickAssistProposals(org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext invocationContext) {
		org.eclipse.jface.text.source.ISourceViewer sourceViewer = invocationContext.getSourceViewer();
		int offset = -1;
		int length = 0;
		if (invocationContext instanceof org.eclipse.jface.text.source.TextInvocationContext) {
			org.eclipse.jface.text.source.TextInvocationContext textContext = (org.eclipse.jface.text.source.TextInvocationContext) invocationContext;
			offset = textContext.getOffset();
			length = textContext.getLength();
		}
		java.util.List<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> quickFixes = getQuickFixes(sourceViewer, offset, length);
		org.eclipse.jface.text.contentassist.ICompletionProposal[] proposals = new org.eclipse.jface.text.contentassist.ICompletionProposal[quickFixes.size()];
		for (int i = 0; i < proposals.length; i++) {
			proposals[i] = createCompletionProposal(sourceViewer, quickFixes.get(i));
		}
		return proposals;
	}
	
	private org.eclipse.jface.text.contentassist.ICompletionProposal createCompletionProposal(final org.eclipse.jface.text.source.ISourceViewer sourceViewer, final org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix quickFix) {
		return new org.eclipse.jface.text.contentassist.ICompletionProposal() {
			
			public org.eclipse.swt.graphics.Point getSelection(org.eclipse.jface.text.IDocument document) {
				return null;
			}
			
			public org.eclipse.swt.graphics.Image getImage() {
				return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesUIMetaInformation().getImageProvider().getImage(quickFix.getImageKey());
			}
			
			public String getDisplayString() {
				return quickFix.getDisplayString();
			}
			
			public org.eclipse.jface.text.contentassist.IContextInformation getContextInformation() {
				return null;
			}
			
			public String getAdditionalProposalInfo() {
				return null;
			}
			
			public void apply(org.eclipse.jface.text.IDocument document) {
				String currentContent = sourceViewer.getDocument().get();
				String newContent = quickFix.apply(currentContent);
				if (newContent != null) {
					sourceViewer.getDocument().set(newContent);
				}
			}
		};
	}
	
	private java.util.List<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> getQuickFixes(org.eclipse.jface.text.source.ISourceViewer sourceViewer, int offset, int length) {
		java.util.List<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> foundFixes = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix>();
		org.eclipse.jface.text.source.IAnnotationModel model = annotationModelProvider.getAnnotationModel();
		
		if (model == null) {
			return foundFixes;
		}
		
		java.util.Iterator<?> iter = model.getAnnotationIterator();
		while (iter.hasNext()) {
			org.eclipse.jface.text.source.Annotation annotation = (org.eclipse.jface.text.source.Annotation) iter.next();
			org.eclipse.jface.text.Position position = model.getPosition(annotation);
			if (offset >= 0) {
				if (!position.overlapsWith(offset, length)) {
					continue;
				}
			}
			java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> quickFixes = getQuickFixes(annotation);
			if (quickFixes != null) {
				foundFixes.addAll(quickFixes);
			}
		}
		return foundFixes;
	}
	
	private java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> getQuickFixes(org.eclipse.jface.text.source.Annotation annotation) {
		
		java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> foundQuickFixes = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix>();
		if (annotation.isMarkedDeleted()) {
			return foundQuickFixes;
		}
		
		if (annotation instanceof org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesMarkerAnnotation) {
			org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesMarkerAnnotation markerAnnotation = (org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesMarkerAnnotation) annotation;
			org.eclipse.core.resources.IMarker marker = markerAnnotation.getMarker();
			foundQuickFixes.addAll(new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesMarkerResolutionGenerator().getQuickFixes(resourceProvider.getResource(), marker));
		}
		return foundQuickFixes;
	}
	
	public String getErrorMessage() {
		return null;
	}
	
}
