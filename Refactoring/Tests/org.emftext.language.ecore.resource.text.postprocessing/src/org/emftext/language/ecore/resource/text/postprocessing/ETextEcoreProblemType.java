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
