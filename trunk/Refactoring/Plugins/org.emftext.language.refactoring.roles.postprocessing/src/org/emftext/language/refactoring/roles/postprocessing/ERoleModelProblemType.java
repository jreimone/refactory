/**
 * 
 */
package org.emftext.language.refactoring.roles.postprocessing;

import org.emftext.language.refactoring.roles.resource.rolestext.RolestextEProblemType;
import org.emftext.language.refactoring.roles.resource.rolestext.util.RolestextStringUtil;

/**
 *  An enumeration of all problems that may occur in a role model.
 * 
 * @author Jan Reimann
 *
 */
public enum ERoleModelProblemType {
	
	ROLE_MODIFIER_ALREADY_SET(RolestextEProblemType.ERROR),
	RELATION_MODIFIER_ALREADY_SET(RolestextEProblemType.ERROR),
	INPUT_ROLE_NOT_SET(RolestextEProblemType.ERROR),
	DUPLICATE_OUTGOING_RELATION_TARGET_NAMES(RolestextEProblemType.ERROR),
	EMPTY_OUTGOING_RELATION_TARGET_NAME(RolestextEProblemType.WARNING)
	;
	
	
	private RolestextEProblemType problemType;
	
	private ERoleModelProblemType(RolestextEProblemType problemType){
		this.problemType = problemType;
	}
	
	public RolestextEProblemType getProblemType(){
		return problemType;
	}
	
	public String getName(){
		return RolestextStringUtil.convertAllCapsToLowerCamelCase(this.name());
	}
}
