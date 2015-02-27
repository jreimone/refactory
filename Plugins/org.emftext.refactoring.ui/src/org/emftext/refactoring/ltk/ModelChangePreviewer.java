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
package org.emftext.refactoring.ltk;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.compare.CompareEditorInput;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.domain.impl.EMFCompareEditingDomain;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.ltk.ui.refactoring.ChangePreviewViewerInput;
import org.eclipse.ltk.ui.refactoring.IChangePreviewViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ModelChangePreviewer implements IChangePreviewViewer {

	private Composite parent;
	private Control previewControl;

	public void createControl(Composite parent) {
		this.parent = parent;
	}

	public Control getControl() {
		return previewControl;
	}

	public void setInput(ChangePreviewViewerInput input) {
		if(!(input.getChange() instanceof ModelRefactoringChange)){
			return;
		}
		ModelRefactoringChange change = (ModelRefactoringChange) input.getChange();
		EObject originalModel = change.getRefactorer().getOriginalModel();
		EObject fakeRefactoredModel = change.getRefactorer().getFakeRefactoredModel();
	    
		EMFCompare comparator = EMFCompare.builder().build();
		// is needed for better preview - before, preview was subtractive, the other way around it us additive when new elements are created
//		DefaultComparisonScope scope = new DefaultComparisonScope(originalModel, fakeRefactoredModel, null);
		DefaultComparisonScope scope = new DefaultComparisonScope(fakeRefactoredModel, originalModel, null);
		Comparison comparison = comparator.compare(scope);
	    // the following is needed to avoid NPE at EMFCompareStructureMergeViewer.updateProblemIndication(EMFCompareStructureMergeViewer.java:1000)
	    comparison.setDiagnostic(Diagnostic.OK_INSTANCE);
		
	    // is needed for better preview - before, preview was subtractive, the other way around it us additive when new elements are created
//		ICompareEditingDomain editingDomain = EMFCompareEditingDomain.create(originalModel, fakeRefactoredModel, null);
		ICompareEditingDomain editingDomain = EMFCompareEditingDomain.create(fakeRefactoredModel, originalModel, null);
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	    CompareEditorInput compareEditorInput = new RefactoringCompareEditorInput(scope, comparison, editingDomain, adapterFactory);
	    try {
			compareEditorInput.run(new NullProgressMonitor());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	    
	    previewControl = compareEditorInput.createContents(parent);
	}

}
