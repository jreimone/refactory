/**
 * 
 */
package org.emftext.language.refactoring.rolemapping.postprocessing;

import org.emftext.language.refactoring.rolemapping.resource.rolemapping.RolemappingEProblemType;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.util.RolemappingStringUtil;

/**
 * An enumeration of all problems that may occur in a role mapping model.
 * 
 * @author Jan Reimann
 *
 */
public enum ERoleMappingModelProblemType {
	
	NOT_ALL_ROLES_MAPPED(RolemappingEProblemType.WARNING),
	DUPLICATE_ROLE_MAPPING(RolemappingEProblemType.ERROR),
	CHECK_RELATIONS_BETWEEN_ECLASSES(RolemappingEProblemType.WARNING)
	;
	
	private RolemappingEProblemType problemType;
	
	private ERoleMappingModelProblemType(RolemappingEProblemType problemType){
		this.problemType = problemType;
	}
	
	public RolemappingEProblemType getProblemType(){
		return problemType;
	}
	
	public String getName(){
		return RolemappingStringUtil.convertAllCapsToLowerCamelCase(this.name());
	}
}
