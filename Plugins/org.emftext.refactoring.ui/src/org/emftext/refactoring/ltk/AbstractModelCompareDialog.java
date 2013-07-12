package org.emftext.refactoring.ltk;

import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.internal.CompareDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class AbstractModelCompareDialog extends CompareDialog {

	private Composite parent;
	private CompareEditorInput input;

	public AbstractModelCompareDialog(Composite parent, CompareEditorInput input) {
		super(parent.getShell(), input);
		this.parent = parent;
		this.input = input;
	}

	protected Control initializeControl(){
//		input.setContainer(new DialogCompareContainer());
		return createContents(parent);
//		return createDialogArea(parent);
	}
}
