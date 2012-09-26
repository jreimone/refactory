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
 * 
 */
package org.dresdenocl.refactoring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

import tudresden.ocl20.pivot.language.ocl.ClassifierContextDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.DefinitionExpOperationCS;
import tudresden.ocl20.pivot.language.ocl.DefinitionExpPropertyCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.PrePostOrBodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.TupleLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.TupleTypeCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationCS;

/**
 * @author Michael Muck
 *
 */
public class RemoveUnusedVariableDeclarationsPP extends AbstractRefactoringPostProcessor{
	
	
	int varsFound;
	private ClassifierContextDeclarationCS selected;
	private EList<VariableDeclarationCS> vars;
	private EList<VariableDeclarationCS> varsToRemove;
	int removedVars;
	private PostProcessingHelper myPostProcessingHelper;
	
	public RemoveUnusedVariableDeclarationsPP() {
		vars = new BasicEList<VariableDeclarationCS>();
		varsToRemove = new BasicEList<VariableDeclarationCS>();
		myPostProcessingHelper = new PostProcessingHelper();
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {


		System.out.println("Postprocessor for 'Remove All Unused Variable Definitions' refactoring activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			if (role.getName().equals("Selection")) {
				if (roleplayers.size()==1 && roleplayers.get(0) instanceof ClassifierContextDeclarationCS) {
					selected = (ClassifierContextDeclarationCS) roleplayers.get(0);
					System.out.println("found selected element as: "+selected);
				}
			}
		}
////prevent postprocessor from refactoring if it is a fake run for the preview
////to circumvent an error in refactory
////can be removed if this error is fixed
////////////////////////////////////////////////////////////////////////////////////
		if (isFakeRun) return Status.OK_STATUS;
////////////////////////////////////////////////////////////////////////////////////
		getAllVariables();
		System.out.println("found "+varsFound+" variables:");
		Iterator<VariableDeclarationCS> sopit = vars.iterator();
		while (sopit.hasNext()) {
			System.out.println("   "+sopit.next().getVariableName().getSimpleName());
		}
		removedVars = 0;
		if (varsFound > 0) {
			findUnusedVariables();
			if (varsToRemove.size() > 0) {
				removedVars = varsToRemove.size();
				removeUnusedVariables();
			}
		}
		
		if (removedVars > 0) {
			System.out.println(removedVars+" variables removed");
		} else {
			System.out.println("no unused variables found");
		}
		
		return Status.OK_STATUS;
	}
	
	
	
	private void getAllVariables() {
		vars = new BasicEList<VariableDeclarationCS>();
		varsFound = 0;
		Iterator<EObject> myAllContentsIt = selected.eAllContents();
		while (myAllContentsIt.hasNext()) {
			EObject akt = myAllContentsIt.next();
			if (akt instanceof LetExpCS) {
				vars.addAll(((LetExpCS) akt).getVariableDeclarations());
				varsFound += ((LetExpCS)akt).getVariableDeclarations().size();
			}
//			if (akt instanceof VariableDeclarationCS) {
//				vars.add((VariableDeclarationCS) akt);
//				varsFound++;
//			}
		}
	}
	
	private void findUnusedVariables() {
		varsToRemove = new BasicEList<VariableDeclarationCS>();
		Iterator<VariableDeclarationCS> myVarsIt = vars.iterator();
		while (myVarsIt.hasNext()) {
			VariableDeclarationCS myVar = myVarsIt.next();
			String checkName = myVar.getVariableName().getSimpleName();
			Iterator<EObject> checkIt = selected.eAllContents();
			int usesFound = 0;
			while (checkIt.hasNext()) {
				EObject checkObj = checkIt.next();
				if (checkObj instanceof NamedLiteralExpCS) {
					if (((NamedLiteralExpCS)checkObj).getNamedElement().getName().equals(checkName)) {
						usesFound++;
					}
				}
			}
			//now, if no use for the actual variable is found, the variable can be removed
			System.out.println("found "+usesFound+" references to variable "+myVar.getVariableName().getSimpleName());
			if(usesFound == 0) {
				varsToRemove.add(myVar);
			}
		}
		System.out.println("found "+varsToRemove.size()+" unused variables.");
	}
	
	//remove all unused variables named in the list
	private void removeUnusedVariables() {
		System.out.println("removing unused variables");
		Iterator<VariableDeclarationCS> myRemovalIt = varsToRemove.iterator();
		while (myRemovalIt.hasNext()) {
			VariableDeclarationCS aktRemovee = myRemovalIt.next();
			System.out.println("removing "+aktRemovee.getVariableName().getSimpleName());
			EObject parent = aktRemovee.eContainer();
			myPostProcessingHelper.removeObjectFromParent(aktRemovee);
			cleanUp(parent);
		}
	}
	
	
	//used to remove containers of removed variable declarations, if they have become empty and thus invalid
	//after the variable declarations have been removed
	private void cleanUp(EObject parent) {
		boolean cleaned = false;
		System.out.println("cleaning up "+parent);
		//now, if the element from which we have removed the selection is empty, it can be removed too
		if (parent instanceof LetExpCS) {
			LetExpCS myParent = (LetExpCS) parent;
			
			//	myParent.getVariableDeclarations().remove(selected);
			if (myParent.getVariableDeclarations().isEmpty()) {
				EObject myParentContainer = parent.eContainer();
				if (myParentContainer instanceof InvariantExpCS) {
					((InvariantExpCS)myParentContainer).setOclExpression(myParent.getOclExpression());
				} else if (myParentContainer instanceof PrePostOrBodyDeclarationCS) {
					((PrePostOrBodyDeclarationCS)myParentContainer).setOclExpression(myParent.getOclExpression());
				} else if (myParentContainer instanceof LetExpCS) {
					((LetExpCS)myParentContainer).setOclExpression(myParent.getOclExpression());
				} else if (myParentContainer instanceof DefinitionExpOperationCS) {
					((DefinitionExpOperationCS)myParentContainer).setOclExpression(myParent.getOclExpression());
				}
				cleaned = true;
				System.out.println("cleaning empty letExp");
			}
		} else if (parent instanceof TupleTypeCS) {
			if (((TupleTypeCS)parent).getVariableDeclarationList().getVariableDeclarations().isEmpty()) {
				parent.eContainer().eUnset(parent.eContainingFeature());
				cleaned = true;
			}
		}
		else if (parent instanceof TupleLiteralExpCS) {
			if (((TupleLiteralExpCS)parent).getVariableDeclarations().getVariableDeclarations().isEmpty()) {
				parent.eContainer().eUnset(parent.eContainingFeature());
				cleaned = true;
			}
		} else if (parent instanceof DefinitionExpPropertyCS) {
			if (((DefinitionExpPropertyCS)parent).getVariableDeclaration() == null) {
				parent.eContainer().eUnset(parent.eContainingFeature());
				cleaned = true;
			}
		}
		
		if (cleaned) {
			System.out.println("cleaning performed");
		} else {
			System.out.println("nothing to clean has been found");
		}
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {
		// TODO Auto-generated method stub
		return null;
	}

}
