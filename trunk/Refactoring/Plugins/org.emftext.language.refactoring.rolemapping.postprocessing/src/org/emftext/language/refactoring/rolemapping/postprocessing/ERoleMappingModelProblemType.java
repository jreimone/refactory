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
