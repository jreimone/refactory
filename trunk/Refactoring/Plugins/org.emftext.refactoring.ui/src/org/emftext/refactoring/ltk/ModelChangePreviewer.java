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

import org.eclipse.compare.CompareUI;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.ui.refactoring.ChangePreviewViewerInput;
import org.eclipse.ltk.ui.refactoring.IChangePreviewViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ModelChangePreviewer implements IChangePreviewViewer {

	private ViewForm control;
	private RefactoringCompareEditorInput compare;
	//	private CompareViewerPane pane;

	public void createControl(Composite parent) {
		control = new ViewForm(parent, SWT.BORDER);
		compare = new RefactoringCompareEditorInput(control);
	}

	public Control getControl() {
		return control;
	}

	public void setInput(ChangePreviewViewerInput input) {
		if(!(input.getChange() instanceof ModelRefactoringChange)){
			return;
		}
		ModelRefactoringChange change = (ModelRefactoringChange) input.getChange();
		EObject originalModel = change.getRefactorer().getOriginalModel();
		EObject fakeRefactoredModel = change.getRefactorer().getFakeRefactoredModel();
		
		compare.setOriginalModel(originalModel);
		compare.setFakeRefactoredModel(fakeRefactoredModel);
		try {
			compare.run(new NullProgressMonitor());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//		compare.getControl().pack(true);
		//		compare.getControl().setVisible(true);
		CompareUI.openCompareDialog(compare);
	}

}
