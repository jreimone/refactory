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
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.analysis;

public class CollaborationTargetReferenceResolver implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextReferenceResolver<org.emftext.language.refactoring.roles.Collaboration, org.emftext.language.refactoring.roles.Role> {
	
	private org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultResolverDelegate<org.emftext.language.refactoring.roles.Collaboration, org.emftext.language.refactoring.roles.Role> delegate = new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultResolverDelegate<org.emftext.language.refactoring.roles.Collaboration, org.emftext.language.refactoring.roles.Role>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.roles.Collaboration container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.roles.resource.rolestext.IRolestextReferenceResolveResult<org.emftext.language.refactoring.roles.Role> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.refactoring.roles.Role element, org.emftext.language.refactoring.roles.Collaboration container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
