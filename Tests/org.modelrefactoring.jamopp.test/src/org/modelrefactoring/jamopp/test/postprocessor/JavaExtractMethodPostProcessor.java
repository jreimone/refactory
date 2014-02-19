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
package org.modelrefactoring.jamopp.test.postprocessor;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.modifiers.Static;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.types.Void;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

public class JavaExtractMethodPostProcessor extends AbstractRefactoringPostProcessor {

	private ClassMethod newContainer;
	private ClassMethod origContainer;

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	ResourceSet resourceSet, ChangeDescription change) {
		newContainer = RoleUtil.getFirstObjectForRole("NewContainer", ClassMethod.class, roleRuntimeInstanceMap);
		origContainer = RoleUtil.getFirstObjectForRole("OrigContainer", ClassMethod.class, roleRuntimeInstanceMap);
		
		boolean result = processMethodType();
		if(!result){
			System.err.println("An error occurred");
		}
		return Status.OK_STATUS;
	}

	private Boolean processMethodType(){
		// more stuff, such as type inference for parameters, has to be done here
		Void voidType = TypesFactory.eINSTANCE.createVoid();
		newContainer.setTypeReference(voidType);
		List<AnnotationInstanceOrModifier> modifiers = origContainer.getAnnotationsAndModifiers();
		for (AnnotationInstanceOrModifier modifier : modifiers) {
			if(modifier instanceof Static){
				Static staticModifier = ModifiersFactory.eINSTANCE.createStatic();
				return newContainer.getAnnotationsAndModifiers().add(staticModifier);
			}
		}
		return true;
	}
}
