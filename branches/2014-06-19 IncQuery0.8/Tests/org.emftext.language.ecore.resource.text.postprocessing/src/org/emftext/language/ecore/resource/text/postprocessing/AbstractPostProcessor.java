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
package org.emftext.language.ecore.resource.text.postprocessing;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.ecore.resource.text.ITextEcoreQuickFix;
import org.emftext.language.ecore.resource.text.ITextEcoreResourcePostProcessor;
import org.emftext.language.ecore.resource.text.ITextEcoreResourcePostProcessorProvider;
import org.emftext.language.ecore.resource.text.TextEcoreEProblemSeverity;
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
		resource.addProblem(new TextEcoreProblem(message, problemType.getProblemType(), TextEcoreEProblemSeverity.WARNING), cause);
	}
	
	protected void addProblem(TextEcoreResource resource, ETextEcoreProblemType problemType, String message, EObject cause, ITextEcoreQuickFix quickFix){
		resource.addProblem(new TextEcoreProblem(message, problemType.getProblemType(), TextEcoreEProblemSeverity.WARNING, quickFix), cause);
	}
	
	public abstract void analyse(TextEcoreResource resource, EPackage epackage);
}
