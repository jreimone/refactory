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
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.domain.impl.EMFCompareEditingDomain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
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
	    Comparison comparison = comparator.compare(EMFCompare.createDefaultScope(originalModel, fakeRefactoredModel));
		
		ICompareEditingDomain editingDomain = EMFCompareEditingDomain.create(originalModel, fakeRefactoredModel, null);
		AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	    CompareEditorInput compareEditorInput = new RefactoringCompareEditorInput(comparison, editingDomain, adapterFactory);
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
