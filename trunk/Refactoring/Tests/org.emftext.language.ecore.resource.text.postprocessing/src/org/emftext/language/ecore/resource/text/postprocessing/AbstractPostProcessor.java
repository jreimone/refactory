package org.emftext.language.ecore.resource.text.postprocessing;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.ecore.resource.text.ITextEcoreQuickFix;
import org.emftext.language.ecore.resource.text.ITextEcoreResourcePostProcessor;
import org.emftext.language.ecore.resource.text.ITextEcoreResourcePostProcessorProvider;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreProblem;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResource;

public abstract class AbstractPostProcessor implements
		ITextEcoreResourcePostProcessorProvider,
		ITextEcoreResourcePostProcessor {
	
	public ITextEcoreResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void process(TextEcoreResource resource) {
		List<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if(eObject instanceof EPackage){
				analyse(resource, (EPackage) eObject);
			}
		}
	}
	
	protected void addProblem(TextEcoreResource resource, ETextEcoreProblemType problemType, String message, EObject cause){
		resource.addProblem(new TextEcoreProblem(message, problemType.getProblemType()), cause);
	}
	
	protected void addProblem(TextEcoreResource resource, ETextEcoreProblemType problemType, String message, EObject cause, ITextEcoreQuickFix quickFix){
		resource.addProblem(new TextEcoreProblem(message, problemType.getProblemType(), quickFix), cause);
	}
	
	public abstract void analyse(TextEcoreResource resource, EPackage epackage);
}
