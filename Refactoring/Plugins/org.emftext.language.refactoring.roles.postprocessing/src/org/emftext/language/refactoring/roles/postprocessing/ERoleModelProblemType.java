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
package org.emftext.language.refactoring.roles.postprocessing;

import org.emftext.language.refactoring.roles.resource.rolestext.RolestextEProblemSeverity;
import org.emftext.language.refactoring.roles.resource.rolestext.util.RolestextStringUtil;

/**
 *  An enumeration of all problems that may occur in a role model.
 * 
 * @author Jan Reimann
 *
 */
public enum ERoleModelProblemType {
	
	ROLE_MODIFIER_ALREADY_SET(RolestextEProblemSeverity.ERROR),
	RELATION_MODIFIER_ALREADY_SET(RolestextEProblemSeverity.ERROR),
	INPUT_ROLE_NOT_SET(RolestextEProblemSeverity.ERROR),
	DUPLICATE_OUTGOING_RELATION_TARGET_NAMES(RolestextEProblemSeverity.ERROR),
	EMPTY_OUTGOING_RELATION_TARGET_NAME(RolestextEProblemSeverity.WARNING),
	DUPLICATE_ROLE_NAMES(RolestextEProblemSeverity.WARNING)
	;
	
	
	private RolestextEProblemSeverity problemSeverity;
	
	private ERoleModelProblemType(RolestextEProblemSeverity problemSeverity){
		this.problemSeverity = problemSeverity;
	}
	
	public RolestextEProblemSeverity getProblemSeverity(){
		return problemSeverity;
	}
	
	public String getName(){
		return RolestextStringUtil.convertAllCapsToLowerCamelCase(this.name());
	}
}
