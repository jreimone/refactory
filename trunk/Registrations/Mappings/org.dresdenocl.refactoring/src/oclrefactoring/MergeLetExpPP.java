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
package oclrefactoring;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;

public class MergeLetExpPP extends AbstractRefactoringPostProcessor {
	
	private LetExpCS selection;
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {
		System.err.println("Postprocessor for merging let expressions activated!");
		if (isFakeRun) {
			System.out.println("Skipping postprocessing for fakerun");
			return Status.OK_STATUS;
		}
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			
			if (role.getName().equals("Selection")) {
				if (roleplayers.size() == 1 && (roleplayers.get(0) instanceof LetExpCS)) selection = (LetExpCS) roleplayers.get(0);
				System.out.println("   selection identified as: "+selection.toString());
			}
			
		}
		
		IStatus refactoringStatus = Status.CANCEL_STATUS;
		
		refactoringStatus = this.performSpecificTransformation(selection);
			
		return refactoringStatus;
	}
		
	
	IStatus performSpecificTransformation(LetExpCS selection) {
		
		LetExpCS topexp = getTopLetExp(selection);
		
		while (topexp.getOclExpression() instanceof LetExpCS) {
			this.mergeLet(topexp);
		}
		
		return Status.OK_STATUS;
	}


	private void mergeLet(LetExpCS topexp) {
		
		LetExpCS child = (LetExpCS) topexp.getOclExpression();
		EList<VariableDeclarationWithInitCS> varlist = child.getVariableDeclarations();
		boolean done = false;
		while (!done) {
			if (varlist.size() > 0) {
				topexp.getVariableDeclarations().add(varlist.get(0));
			} 
			else done = true;
		}
		
		topexp.setOclExpression(child.getOclExpression());		
	}



	private LetExpCS getTopLetExp(LetExpCS child) {
		
		LetExpCS akttop = child;
		while (akttop.eContainer() instanceof LetExpCS) {
			akttop = (LetExpCS) akttop.eContainer();
		}
		return akttop;
	}
	
	
	
	
	

	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {
		// TODO Auto-generated method stub
		return null;
	}

}
