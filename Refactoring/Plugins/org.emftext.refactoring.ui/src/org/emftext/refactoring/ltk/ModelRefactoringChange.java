/**
 * 
 */
package org.emftext.refactoring.ltk;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.IMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.ui.IModelCompareInputProvider;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.ui.RefactoringRecordingCommand;
import org.emftext.refactoring.ui.RefactoringUndoOperation;

/**
 * @author Jan Reimann
 *
 */
public class ModelRefactoringChange extends Change implements IModelCompareInputProvider{

	private IRefactorer refactorer;
	private TransactionalEditingDomain diagramTransactionalEditingDomain;
	private ModelRefactoring modelRefactoring;
	private IEditorPart activeEditor;
	private IProgressMonitor monitor;
	
	private RefactoringRecordingCommand command;
	private IRefactoringStatus status;
	
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
		statusSwitch(false);
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return RefactoringStatus.create(status);
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		this.monitor = pm;
		ResourceSet rs = refactorer.getResource().getResourceSet();
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
			
			status = command.getStatus();
			statusSwitch(true);
//			statusSwitch(command, status);
		} catch (Exception e) {
//			if(command != null && command.canUndo()){
//				command.undo();
//			}
			e.printStackTrace();
			status = new org.emftext.refactoring.interpreter.RefactoringStatus(IRefactoringStatus.ERROR, "Refactoring rolled back", e);
//			Activator.getDefault().getLog().log(status);
//			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//			String title = "Refactoring was rolled back";
//			String message = "Refactoring rolled back because of an unforseen error. Check out the error log";
			statusSwitch(true);
			if(domain != null && diagramTransactionalEditingDomain == null){
				domain.dispose();
			}
			return null;
//			MessageDialog.openInformation(shell, title, message);
		}
		if(domain != null && diagramTransactionalEditingDomain == null){
			domain.dispose();
		}
		Change undoChange = new Change() {
			
			@Override
			public Change perform(IProgressMonitor pm) throws CoreException {
				if(command.canUndo()){
					command.undo();
				}
				return null;
			}
			
			@Override
			public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
					OperationCanceledException {
				return RefactoringStatus.create(Status.OK_STATUS);
			}
			
			@Override
			public void initializeValidationData(IProgressMonitor pm) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public String getName() {
				return "Undo " + modelRefactoring.getName();
			}
			
			@Override
			public Object getModifiedElement() {
				return null;
			}
		};
		return undoChange;
	}

	
	private void statusSwitch(boolean rollback) {
//		Shell shell;
//		String title;
		String message;
		if(status == null){
			status = new org.emftext.refactoring.interpreter.RefactoringStatus(IStatus.OK);
			return;
		}
		switch (status.getSeverity()) {
		case IRefactoringStatus.OK:
			System.out.println("Refactored successfull");
			break;
		case IRefactoringStatus.INFO:
//			shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//			title = "Information";
			message = status.getMessage();
//			MessageDialog.openInformation(shell, title, message);
			if(rollback && command.canUndo()){
				command.undo();
			}
			System.out.println("Refactoring rolled back because of some infos");
			break;
		case IRefactoringStatus.WARNING:
//			shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//			title = "Information";
			message = status.getMessage();
//			MessageDialog.openInformation(shell, title, message);
			if(rollback && command.canUndo()){
				command.undo();
			}
			System.out.println("Refactoring rolled back because of some warnings");
			break;
		case IRefactoringStatus.CANCEL:
			if(rollback && command.canUndo()){
				command.undo();
			}
			System.out.println("Refactoring rolled back because of cancelation of dialog");
			break;
		case IRefactoringStatus.ERROR:
//			shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//			title = "Refactoring will be rolled back";
			message = "The refactoring will be rolled back because of the following unforseen error: \n\n";
			message += status.getMessage();
			if(status.getException() != null){
				message += "\n\nCheck out the error log for further information.";
//				Activator.getDefault().getLog().log(status);
				ResourcesPlugin.getPlugin().getLog().log(status);
			}
			status.setMessage(message);
//			MessageDialog.openInformation(shell, title, message);
			if(rollback && command.canUndo()){
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

	public ModelCompareInput getModelCompareInput() {
		Map<String, Object> options = new LinkedHashMap<String, Object>();
		options.put(MatchOptions.OPTION_DISTINCT_METAMODELS, true);
		options.put(MatchOptions.OPTION_IGNORE_ID, true);
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, true);
		//		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		MatchModel match = null;
		try {
			EObject originalModel = refactorer.getOriginalModel();
			EObject fakeRefactoredModel = refactorer.getFakeRefactoredModel();
			IMatchEngine engine = new RefactoringMatchEngine();
			match = engine.contentMatch(originalModel, fakeRefactoredModel, options);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(match != null){
			DiffModel diff = DiffService.doDiff(match, false);
			ModelCompareInput compareInput = new ModelCompareInput(match, diff);
			
			return compareInput;
		}
		return null;
	}
}
