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
package org.emftext.refactoring.roleconstraintchecker;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

/**
 * Interface for role constraint validators.
 * 
 * @author Jan Reimann
 *
 */
public interface IRoleConstraintValidator {

	/**
	 * Validates the whole RoleMappingModel
	 * @return
	 */
	public IStatus validate(RoleMappingModel mappingModel);
	
	/**
	 * Validates the given mapping
	 * @param mapping the mapping to validate
	 * @return
	 */
	public List<IStatus> validateMapping(RoleMapping mapping);
}
