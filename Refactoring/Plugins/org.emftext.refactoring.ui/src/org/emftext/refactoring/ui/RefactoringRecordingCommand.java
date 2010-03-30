/**
 * 
 */
package org.emftext.refactoring.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IEditorPart;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IRefactorer;

class RefactoringRecordingCommand extends RecordingCommand{

	private IRefactorer refactorer;
	private Mapping mapping;
	private Resource resource;
	private boolean didErrorsOccur = false;
	private Exception exception;
	private IEditorPart activeEditor;

	public RefactoringRecordingCommand(Resource resource,TransactionalEditingDomain domain, IRefactorer refactorer, Mapping mapping, IEditorPart activeEditor) {
		super(domain);
		this.refactorer = refactorer;
		this.mapping = mapping;
		this.resource = resource;
		this.activeEditor = activeEditor;
	}

	@Override
	protected void doExecute() {
		try {
			EObject refactoredModel = RefactoringAction.refactorInternal(refactorer, mapping, resource, activeEditor); 
			didErrorsOccur = (refactoredModel == null)?true:false;
		} catch (Exception e) {
			didErrorsOccur = true;
			exception = e;
		}
	}

	public boolean didErrorsOccur() {
		return didErrorsOccur;
	}

	public Exception getException() {
		return exception;
	}

}