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
package org.emftext.refactoring.interpreter.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.util.RegistryUtil;

/**
 * @author Jan Reimann
 *
 */
public class RefactorerFactoryImpl implements RefactorerFactory {

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.RefactoringInterpreterFactory#getRefactoringInterpreter(org.eclipse.emf.common.util.URI)
	 */
	public IRefactorer getRefactorer(Resource resource, RoleMapping roleMapping) {
		IRefactorer refactorer = new Refactorer(resource, roleMapping);
		RegistryUtil.log("created Refactorer for " + resource, IStatus.INFO);
		return refactorer;
	}
}
