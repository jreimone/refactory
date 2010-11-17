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
