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
package org.emftext.language.refactoring.rolemapping.postprocessing;

import org.emftext.language.refactoring.rolemapping.resource.rolemapping.RolemappingEProblemSeverity;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.util.RolemappingStringUtil;

/**
 * An enumeration of all problems that may occur in a role mapping model.
 * 
 * @author Jan Reimann
 *
 */
public enum ERoleMappingModelProblemType {
	
	NOT_ALL_ROLES_MAPPED(RolemappingEProblemSeverity.ERROR),
	NOT_ALL_ATTRIBUTES_MAPPED(RolemappingEProblemSeverity.ERROR),
	DUPLICATE_ROLE_MAPPING(RolemappingEProblemSeverity.ERROR),
	CHECK_RELATIONS_BETWEEN_ECLASSES(RolemappingEProblemSeverity.WARNING)
	;
	
	private RolemappingEProblemSeverity problemSeverity;
	
	private ERoleMappingModelProblemType(RolemappingEProblemSeverity problemSeverity){
		this.problemSeverity = problemSeverity;
	}
	
	public RolemappingEProblemSeverity getProblemSeverity(){
		return problemSeverity;
	}
	
	public String getName(){
		return RolemappingStringUtil.convertAllCapsToLowerCamelCase(this.name());
	}
}
