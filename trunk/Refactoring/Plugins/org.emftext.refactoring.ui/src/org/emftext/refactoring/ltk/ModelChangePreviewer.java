package org.emftext.refactoring.ltk;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.ui.refactoring.ChangePreviewViewerInput;
import org.eclipse.ltk.ui.refactoring.IChangePreviewViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ModelChangePreviewer implements IChangePreviewViewer {

	private Composite control;
	//	private CompareViewerPane pane;

	public void createControl(Composite parent) {
		control = new Composite(parent, SWT.NONE);

		//		pane = new CompareViewerPane(control, SWT.NONE);
	}

	public Control getControl() {
		return control;
	}

	public void setInput(ChangePreviewViewerInput input) {
		if(!(input.getChange() instanceof ModelRefactoringChange)){
			return;
		}
		final ModelRefactoringChange change = (ModelRefactoringChange) input.getChange();
		CompareConfiguration config = new CompareConfiguration();
		config.setLeftEditable(false);
		config.setRightEditable(false);
		CompareEditorInput editorInput = new CompareEditorInput(config) {

			@Override
			protected Object prepareInput(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				EObject original = change.getRefactorer().getOriginalModel();
				EObject fakeRefactored = change.getRefactorer().getFakeRefactoredModel();
				Map<String, Object> options = new LinkedHashMap<String, Object>();
				options.put(MatchOptions.OPTION_DISTINCT_METAMODELS, false);
				MatchModel match = MatchService.doContentMatch(fakeRefactored, original, options);
				DiffModel diff = DiffService.doDiff(match, false);
				System.out.println(diff);
				return diff;
			}
		};
		editorInput.createContents(control);
		try {
			editorInput.run(new NullProgressMonitor());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(editorInput);
	}

}
