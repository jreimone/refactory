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
package org.emftext.refactoring.interpreter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * @author Jan Reimann
 *
 */
public class RefactoringStatus implements IRefactoringStatus {

	private RoleMapping mapping;
	private IStatus internalStatus;

	/**
	 * 
	 * @param severity the severity, e.g. {@link IRefactoringStatus#OK}
	 */
	public RefactoringStatus(int severity) {
		if(severity == IStatus.OK){
			internalStatus = Status.OK_STATUS;
		} else if(severity == IStatus.CANCEL){
			internalStatus = Status.CANCEL_STATUS;
		} else {
			internalStatus = new Status(severity, Activator.PLUGIN_ID, "");
		}
	}

	public RefactoringStatus(int severity, String message) {
		internalStatus = new Status(severity, Activator.PLUGIN_ID, message);
	}

	public RefactoringStatus(int severity, String message, Throwable throwable) {
		internalStatus = new Status(severity, Activator.PLUGIN_ID, message, throwable);
	}

	/**
	 * 
	 * @param mapping the mapping for which the status is produced
	 * @param severity the severity, e.g. {@link IRefactoringStatus#OK}
	 * @param message the message for the user
	 */
	public RefactoringStatus(RoleMapping mapping, int severity, String message) {
		this(severity, message);
		this.mapping = mapping;
	}

	public RefactoringStatus(RoleMapping mapping, int severity, String message, Throwable throwable) {
		this(severity, message, throwable);
		this.mapping = mapping;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringStatus#getRoleMapping()
	 */
	public RoleMapping getRoleMapping() {
		return mapping;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringStatus#getMessage()
	 */
	public String getMessage() {
		return internalStatus.getMessage();
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringStatus#getType()
	 */
	public int getSeverity() {
		return internalStatus.getSeverity();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IStatus#getChildren()
	 */
	public IStatus[] getChildren() {
		return internalStatus.getChildren();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IStatus#getCode()
	 */
	public int getCode() {
		return internalStatus.getCode();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IStatus#getException()
	 */
	public Throwable getException() {
		return internalStatus.getException();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IStatus#getPlugin()
	 */
	public String getPlugin() {
		return Activator.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IStatus#isMultiStatus()
	 */
	public boolean isMultiStatus() {
		return internalStatus.isMultiStatus();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IStatus#isOK()
	 */
	public boolean isOK() {
		return internalStatus.isOK();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IStatus#matches(int)
	 */
	public boolean matches(int severityMask) {
		return internalStatus.matches(severityMask);
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringStatus#setThrowable(java.lang.Throwable)
	 */
	public void setThrowable(Throwable throwable) {
		internalStatus = new Status(getSeverity(), getPlugin(), getMessage(), throwable);
	}

	public void setMessage(String message) {
		internalStatus = new Status(getSeverity(), getPlugin(), getCode(), message, getException());
	}
}
