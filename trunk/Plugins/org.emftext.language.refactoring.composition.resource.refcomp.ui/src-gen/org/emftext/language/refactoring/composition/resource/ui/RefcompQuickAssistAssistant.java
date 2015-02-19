/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.quickassist.IQuickAssistAssistant;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.widgets.Shell;

public class RefcompQuickAssistAssistant extends QuickAssistAssistant implements IQuickAssistAssistant {
	
	public RefcompQuickAssistAssistant(org.emftext.language.refactoring.composition.resource.IRefcompResourceProvider resourceProvider, org.emftext.language.refactoring.composition.resource.ui.IRefcompAnnotationModelProvider annotationModelProvider) {
		setQuickAssistProcessor(new org.emftext.language.refactoring.composition.resource.ui.RefcompQuickAssistProcessor(resourceProvider, annotationModelProvider));
		setInformationControlCreator(new AbstractReusableInformationControlCreator() {
			public IInformationControl doCreateInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, (IInformationPresenter) null);
			}
		});
	}
	
	public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
		return false;
	}
	
	public boolean canFix(Annotation annotation) {
		return true;
	}
	
}
