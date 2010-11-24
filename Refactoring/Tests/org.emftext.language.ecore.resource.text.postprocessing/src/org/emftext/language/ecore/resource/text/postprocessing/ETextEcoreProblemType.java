package org.emftext.language.ecore.resource.text.postprocessing;

import org.emftext.language.ecore.resource.text.TextEcoreEProblemType;
import org.emftext.language.ecore.resource.text.util.TextEcoreStringUtil;

public enum ETextEcoreProblemType {
	
	SAME_ATTRIBUTES_IN_HIERARCHY(TextEcoreEProblemType.ANALYSIS_PROBLEM)
	;

	
	private TextEcoreEProblemType problemType;
	
	private ETextEcoreProblemType(TextEcoreEProblemType problemType){
		this.problemType = problemType;
	}
	
	public TextEcoreEProblemType getProblemType() {
		return problemType;
	}

	public String getName(){
		return TextEcoreStringUtil.convertAllCapsToLowerCamelCase(this.name()); 
	}
}
