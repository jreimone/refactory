package org.emftext.refactoring.ui;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.ui.IEditorPart;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.util.RegistryUtil;

public class SimpleGMFCommand extends AbstractCommand {

	private Mapping mapping;
	private IRefactorer refactorer;
	private IEditorPart activeEditor;
	private ChangeDescription change;
	
	public SimpleGMFCommand(Mapping mapping,IRefactorer refactorer, IEditorPart activeEditor) {
		super("Refactor " + mapping.getName());
		this.mapping = mapping;
		this.refactorer = refactorer;
		this.activeEditor = activeEditor;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		Resource model = refactorer.getResource();
		ResourceSet resourceSet = model.getResourceSet();
		ChangeRecorder recorder = new ChangeRecorder(resourceSet);
		change = null;
		
		CommandResult result = null;
		IStatus status = null;
		try {
			EObject refactoredModel = RefactoringAction.refactorInternal(refactorer, mapping, activeEditor);
			change = recorder.endRecording();
			if(refactoredModel == null){
				status = new Status(IStatus.ERROR, GMFTransactionalCommand.PLUGIN_ID, "Refactoring couldn't be executed");
				result = new CommandResult(status);
			} else {
				status = new Status(IStatus.OK, GMFTransactionalCommand.PLUGIN_ID, "Refactoring was successfull");
				result = new CommandResult(status, refactoredModel);
			}
		} catch (Exception e) {
			change = recorder.endRecording();
			// rollback
			if(change != null){
				change.apply();
			}
			RegistryUtil.log("Rollback: An error occurred while refactoring", IStatus.ERROR, e);
		}
		return result;
	}

	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor,IAdaptable info) throws ExecutionException {
		CommandResult result = null;
		IStatus status = null;
		try {
			if(change != null){
				change.applyAndReverse();
			}
			status = new Status(IStatus.OK, GMFTransactionalCommand.PLUGIN_ID, "Redo was successfull");
			result = new CommandResult(status, refactorer.getResource().getContents().get(0));
		} catch (Exception e) {
			status = new Status(IStatus.ERROR, GMFTransactionalCommand.PLUGIN_ID, "Redo couldn't be executed");
			result = new CommandResult(status);
		}		
		return result;
	}

	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor,IAdaptable info) throws ExecutionException {
		CommandResult result = null;
		IStatus status = null;
		try {
			if(change != null){
				change.applyAndReverse();
			}
			status = new Status(IStatus.OK, GMFTransactionalCommand.PLUGIN_ID, "Undo was successfull");
			result = new CommandResult(status, refactorer.getResource().getContents().get(0));
		} catch (Exception e) {
			status = new Status(IStatus.ERROR, GMFTransactionalCommand.PLUGIN_ID, "Undo couldn't be executed");
			result = new CommandResult(status);
		}		
		return result;
	}


}
