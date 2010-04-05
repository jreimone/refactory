/**
 * 
 */
package org.emftext.refactoring.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IEditorPart;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringStatus;

public class RefactoringRecordingCommand extends RecordingCommand{

	private IRefactorer refactorer;
//	private Mapping mapping;
	private boolean didErrorsOccur = false;
	private Exception exception;
	private IEditorPart activeEditor;
	private IRefactoringStatus status;
	private String label;
	
	public RefactoringRecordingCommand(TransactionalEditingDomain domain, IRefactorer refactorer, IEditorPart activeEditor, String label) {
		super(domain);
		this.refactorer = refactorer;
//		this.mapping = mapping;
		this.activeEditor = activeEditor;
		this.label = label;
	}

	@Override
	protected void doExecute() {
		try {
			InternalRefactoringAction action = new InternalRefactoringAction();
			EObject refactoredModel = action.refactorInternal(refactorer, activeEditor); 
			status = refactorer.getStatus();
			didErrorsOccur = (refactoredModel == null || status.getSeverity() != IRefactoringStatus.OK)?true:false;
		} catch (Exception e) {
			didErrorsOccur = true;
			exception = e;
			e.printStackTrace();
		}
	}

	public boolean didErrorsOccur() {
		return didErrorsOccur;
	}

	public Exception getException() {
		return exception;
	}

	/**
	 * @return the status
	 */
	public IRefactoringStatus getStatus() {
		return status;
	}

	@Override
	public String getLabel() {
		if(label != null && !"".equals(label)){
			return label;
		}
		return super.getLabel();
	}
}