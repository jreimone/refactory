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
/**
 * 
 */
package org.emftext.refactoring.ltk;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.ChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.ui.RefactoringRecordingCommand;
import org.emftext.refactoring.ui.RefactoringUndoOperation;
import org.emftext.refactoring.util.RegistryUtil;

/**
 * @author Jan Reimann
 *
 */
public class ModelRefactoringChange extends Change {

	private IRefactorer refactorer;
	private EditingDomain editingDomain;
	private ModelRefactoring modelRefactoring;
	private IEditorPart activeEditor;
	private IProgressMonitor monitor;

	private RefactoringRecordingCommand command;
	private IRefactoringStatus status;

	public ModelRefactoringChange(ModelRefactoring modelRefactoring) {
		super();
		this.modelRefactoring = modelRefactoring;
		this.refactorer = modelRefactoring.getRefactorer();
		this.editingDomain = modelRefactoring.getDiagramTransactionalEditingDomain();
		this.activeEditor = modelRefactoring.getActiveEditor();
		
		//cseidl
		//Make sure the fake refactoring is performed, once the preview page is about to be displayed.
		//		doFakeRun();
	}

	@Override
	public ChangeDescriptor getDescriptor() {
		if(IRoleMappingRegistry.INSTANCE.getContributorForRoleMapping(refactorer.getRoleMapping()) == null){
			return null;
		}
		ModelRefactoringDescriptor descriptor = new ModelRefactoringDescriptor(refactorer);
		RefactoringChangeDescriptor changeDescriptor = new RefactoringChangeDescriptor(descriptor);
		return changeDescriptor;
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
			if (domain == null) {
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
		} catch (Exception e) {
			e.printStackTrace();
			status = new org.emftext.refactoring.interpreter.RefactoringStatus(IRefactoringStatus.ERROR, "Refactoring rolled back", e);
			statusSwitch(true);
			if (domain != null && editingDomain == null) {
				domain.dispose();
			}
			return null;
		}
		if (domain != null && editingDomain == null) {
			domain.dispose();
		}
		Change undoChange = new Change() {

			@Override
			public Change perform(IProgressMonitor pm) throws CoreException {
				if (command.canUndo()) {
					command.undo();
				}
				return null;
			}

			@Override
			public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
				return RefactoringStatus.create(Status.OK_STATUS);
			}

			@Override
			public void initializeValidationData(IProgressMonitor pm) {
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
		String message;
		if (status == null) {
			status = new org.emftext.refactoring.interpreter.RefactoringStatus(IStatus.OK);
			return;
		}
		switch (status.getSeverity()) {
		case IRefactoringStatus.OK:
			break;
		case IRefactoringStatus.INFO:
			message = status.getMessage();
			if (rollback && command.canUndo()) {
				command.undo();
			}
			RegistryUtil.log("Refactoring rolled back because of some infos", IStatus.INFO);
			break;
		case IRefactoringStatus.WARNING:
			message = status.getMessage();
			if (rollback && command.canUndo()) {
				command.undo();
			}
			RegistryUtil.log("Refactoring rolled back because of some warnings", IStatus.WARNING);
			break;
		case IRefactoringStatus.CANCEL:
			if (rollback && command.canUndo()) {
				command.undo();
			}
			RegistryUtil.log("Refactoring rolled back because of cancelation of dialog", IStatus.CANCEL);
			break;
		case IRefactoringStatus.ERROR:
			message = "The refactoring will be rolled back because of the following unforseen error: \n\n";
			message += status.getMessage();
			if (status.getException() != null) {
				status.getException().printStackTrace();
				message += "\n\nCheck out the error log for further information.";
				ResourcesPlugin.getPlugin().getLog().log(status);
			}
			status.setMessage(message);
			if (rollback && command.canUndo()) {
				command.undo();
			}
			RegistryUtil.log("Refactoring rolled back because of an error", IStatus.ERROR);
			break;
		default:
			break;
		}

		if (status != null && status.getSeverity() != IStatus.OK) {
			informUserAboutRefactoringStatus();
		}

	}

	//cseidl: Report the refactoring status to the user via an appropriate dialog.
	private void informUserAboutRefactoringStatus() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();

		display.syncExec(new Runnable() {
			public void run() {
				Shell shell = display.getActiveShell();
				String message = status.getMessage();

				switch (status.getSeverity()) {
				case IStatus.OK:
				case IStatus.INFO:
					MessageDialog.openInformation(shell, "Information", message);
					break;
				case IStatus.WARNING:
					MessageDialog.openWarning(shell, "Warning", message);
					break;
				case IStatus.ERROR:
					MessageDialog.openWarning(shell, "Error", message);
					break;
				}
			}
		});
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
