/**
 * 
 */
package org.emftext.refactoring.ltk;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.emftext.refactoring.interpreter.Activator;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.ui.RefactoringRecordingCommand;
import org.emftext.refactoring.ui.RefactoringUndoOperation;

/**
 * @author Jan Reimann
 *
 */
public class ModelRefactoringChange extends Change {

	private IRefactorer refactorer;
	private TransactionalEditingDomain diagramTransactionalEditingDomain;
	private ModelRefactoring modelRefactoring;
	private IEditorPart activeEditor;
	private IProgressMonitor monitor;
	
	public ModelRefactoringChange(ModelRefactoring modelRefactoring) {
		super();
		this.modelRefactoring = modelRefactoring;
		this.refactorer = modelRefactoring.getRefactorer();
		this.diagramTransactionalEditingDomain = modelRefactoring.getDiagramTransactionalEditingDomain();
		this.activeEditor = modelRefactoring.getActiveEditor();
	}

	@Override
	public Object getModifiedElement() {
		return refactorer.getOriginalModel();
	}

	@Override
	public String getName() {
		return modelRefactoring.getName();
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		// TODO Auto-generated method stub

	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		this.monitor = pm;
		ResourceSet rs = refactorer.getResource().getResourceSet();
		RefactoringRecordingCommand command = null;
		TransactionalEditingDomain domain = null;
		try {
			domain = TransactionUtil.getEditingDomain(rs);
			if(domain == null){
				domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
			}	
			CommandStack stack = domain.getCommandStack();
			command = new RefactoringRecordingCommand(domain, refactorer, activeEditor, getName());
			stack.execute(command);
			IUndoableOperation operation = new RefactoringUndoOperation(command);
			IOperationHistory history = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
			history.add(operation);
			
			IRefactoringStatus status = command.getStatus();
			statusSwitch(command, status);
		} catch (Exception e) {
			if(command != null && command.canUndo()){
				command.undo();
			}
			IRefactoringStatus status = new org.emftext.refactoring.interpreter.RefactoringStatus(IRefactoringStatus.ERROR, "Refactoring rolled back", e);
			Activator.getDefault().getLog().log(status);
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			String title = "Refactoring was rolled back";
			String message = "Refactoring rolled back because of an unforseen error. Check out the error log";
			MessageDialog.openInformation(shell, title, message);
		}
		if(domain != null && diagramTransactionalEditingDomain == null){
			domain.dispose();
		}
		return null;
	}

	
	private void statusSwitch(RefactoringRecordingCommand command, IRefactoringStatus status) {
		Shell shell;
		String title;
		String message;
		switch (status.getSeverity()) {
		case IRefactoringStatus.OK:
			System.out.println("Refactored successfull");
			break;
		case IRefactoringStatus.INFO:
			shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			title = "Information";
			message = status.getMessage();
			MessageDialog.openInformation(shell, title, message);
			if(command.canUndo()){
				command.undo();
			}
			System.out.println("Refactoring rolled back because of some infos");
			break;
		case IRefactoringStatus.WARNING:
			shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			title = "Information";
			message = status.getMessage();
			MessageDialog.openInformation(shell, title, message);
			if(command.canUndo()){
				command.undo();
			}
			System.out.println("Refactoring rolled back because of some warnings");
			break;
		case IRefactoringStatus.CANCEL:
			if(command.canUndo()){
				command.undo();
			}
			System.out.println("Refactoring rolled back because of cancelation of dialog");
			break;
		case IRefactoringStatus.ERROR:
			shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			title = "Refactoring will be rolled back";
			message = "The refactoring will be rolled back because of the following unforseen error: \n\n";
			message += status.getMessage();
			if(status.getException() != null){
				message += "\n\nCheck out the error log for further information.";
				Activator.getDefault().getLog().log(status);
			}
			MessageDialog.openInformation(shell, title, message);
			if(command.canUndo()){
				command.undo();
			}
			System.out.println("Refactoring rolled back because of an error");
			break;
		default:
			break;
		}
	}

	/**
	 * @return the refactorer
	 */
	public IRefactorer getRefactorer() {
		return refactorer;
	}

	/**
	 * @return the monitor
	 */
	public IProgressMonitor getMonitor() {
		return monitor;
	}
}
