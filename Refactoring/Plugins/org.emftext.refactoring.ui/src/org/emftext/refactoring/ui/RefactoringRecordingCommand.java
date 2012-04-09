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
