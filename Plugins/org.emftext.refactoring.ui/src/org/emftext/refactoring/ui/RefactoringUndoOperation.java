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
package org.emftext.refactoring.ui;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class RefactoringUndoOperation implements IUndoableOperation {

	private static final String PLUGIN_ID = "org.emftext.refactoring.ui";
	
	private RefactoringRecordingCommand command;
	
	public RefactoringUndoOperation(RefactoringRecordingCommand command) {
		super();
		this.command = command;
	}

	public void addContext(IUndoContext context) {
	}

	public boolean canExecute() {
		return command.canExecute();
	}

	public boolean canRedo() {
		return command.canRedo();
	}

	public boolean canUndo() {
		return command.canUndo();
	}

	public void dispose() {
		command.dispose();
	}

	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// just do nothing
		return new Status(IStatus.OK
				, PLUGIN_ID
				, "Just don't execute the command because it already has been executed. This undoable operation only delegates to command.undo() and command.redo()");
	}

	public IUndoContext[] getContexts() {
		return new IUndoContext[]{IOperationHistory.GLOBAL_UNDO_CONTEXT};
	}

	public String getLabel() {
		return command.getLabel();
	}

	public boolean hasContext(IUndoContext context) {
		return context.equals(IOperationHistory.GLOBAL_UNDO_CONTEXT);
	}

	public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			command.redo();
		} catch (Exception e) {
			return new Status(IStatus.ERROR
					, PLUGIN_ID
					, "Redo of '" + getLabel() + "' had errors"
					, e);
		}
		return new Status(IStatus.OK
				, PLUGIN_ID
				, "Redo of '" + getLabel() + "' successfull");
	}

	public void removeContext(IUndoContext context) {
	}

	public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			command.undo();
		} catch (Exception e) {
			return new Status(IStatus.ERROR
					, PLUGIN_ID
					, "Undo of '" + getLabel() + "' had errors"
					, e);
		}
		return new Status(IStatus.OK
				, PLUGIN_ID
				, "Undo of '" + getLabel() + "' successfull");
	}

}
