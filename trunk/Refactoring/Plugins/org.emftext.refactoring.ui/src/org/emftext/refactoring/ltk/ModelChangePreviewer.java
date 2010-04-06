package org.emftext.refactoring.ltk;

import java.lang.reflect.InvocationTargetException;

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
		compare.getControl().pack(true);
		compare.getControl().setVisible(true);
		System.out.println(compare);
	}

}
