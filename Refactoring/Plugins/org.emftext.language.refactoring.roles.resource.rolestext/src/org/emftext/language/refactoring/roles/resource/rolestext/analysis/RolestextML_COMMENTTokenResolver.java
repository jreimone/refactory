/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.language.refactoring.roles.resource.rolestext.analysis;

public class RolestextML_COMMENTTokenResolver implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver {
	
	private org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultTokenResolver defaultTokenResolver = new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultTokenResolver();
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result) {
		lexem = lexem.substring(3);
		lexem = lexem.substring(0, lexem.length() - 2);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result = "/**" + result + "*/";
		return result;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
