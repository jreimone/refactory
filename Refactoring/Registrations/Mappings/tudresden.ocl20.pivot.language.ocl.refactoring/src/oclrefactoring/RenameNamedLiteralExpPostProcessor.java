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
package oclrefactoring;

import tudresden.ocl20.pivot.language.ocl.VariableDeclarationCS;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

import tudresden.ocl20.pivot.language.ocl.BodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.DefinitionExpCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.IterateExpCS;
import tudresden.ocl20.pivot.language.ocl.IteratorExpCS;
import tudresden.ocl20.pivot.language.ocl.IteratorExpVariableCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.PackageDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;
import tudresden.ocl20.pivot.language.ocl.impl.IterateExpCSImpl;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.Property;
/**
 * @author Michael Muck
 *
 */
public class RenameNamedLiteralExpPostProcessor implements IRefactoringPostProcessor {
	
	
	String origName;
	String newName;
	NamedLiteralExpCS selection;
	boolean refactoringSuccessful = false;

	public RenameNamedLiteralExpPostProcessor() {
		
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {
		// TODO Auto-generated method stub
		System.out.println("--------- old postprocessor activated ------------");
		return null;
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			EObject refactoredModel, ResourceSet resourceSet,
			ChangeDescription change, RefactoringSpecification refSpec,
			List<IModelRefactoringWizardPage> customWizardPages,
			boolean isFakeRun) {
		
		if (isFakeRun) {
			System.out.println("---------------------postprocessor activated in fake mode - no processing done for now!--------------------");
			return Status.OK_STATUS;
		}
		else System.out.println("---------------------postprocessor activated in real mode!--------------------");
		
		//extract selection, old name and new name

		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		List<EObject> mappedElements;
		for (Role role : keySet) {
			if (role.getName().equals("Selection")) {
				mappedElements = roleRuntimeInstanceMap.get(role);
				if (mappedElements != null && mappedElements.size() > 0
						&& (mappedElements.get(0) instanceof NamedLiteralExpCS)) {
					selection = (NamedLiteralExpCS) mappedElements.get(0);
				}
			}
			else if (role.getName().equals("Nameable")) {
				mappedElements = roleRuntimeInstanceMap.get(role);
				if (mappedElements != null && mappedElements.size() >0 && (mappedElements.get(0)) instanceof SimpleNameCS) {
					newName = ((SimpleNameCS) mappedElements.get(0)).getSimpleName();
					
				}
			}
		}
		if (selection == null) {
			System.err.println("No variable declaration could be found by postprocessor. Refactoring aborted.");
			return Status.OK_STATUS;
		}
		origName = selection.getNamedElement().getName();
		System.out.println("orig name: "+ origName);
		System.out.println("new name: "+ newName);
		
		performPostProcessing();
		if (refactoringSuccessful) return Status.OK_STATUS;
		else return Status.CANCEL_STATUS;
	}

	private void performPostProcessing() {

		EObject parent = getDefinitionParent(selection);
		if (parent == null) refactoringSuccessful=false;
		else if (parent instanceof LetExpCS) {
			refactoringSuccessful = performRenamingForLetExp((LetExpCS)parent);
		}
		else if (parent instanceof IteratorExpCS) {
			refactoringSuccessful = performRenamingForIteratorExp((IteratorExpCS)parent);
		}
		else if (parent instanceof IterateExpCS) {
			refactoringSuccessful = performRenamingForIterateExp((IterateExpCS)parent);
		}
		
	}

	

	private boolean performRenamingForIterateExp(IterateExpCS parent) {
		if (parent.getIteratorVariable().getVariableName().getSimpleName().equals(origName)) {
			parent.getIteratorVariable().getVariableName().setSimpleName(newName);
		}

		//finding and renaming all references
		Iterator<EObject> it = parent.eAllContents();
		while (it.hasNext()) {
			EObject akt = it.next();
			if (akt instanceof NamedLiteralExpCS && ((NamedLiteralExpCS)akt).getNamedElement().getName().equals(origName)) {
				//we found a variable reference with the original name
				((NamedLiteralExpCS)akt).getNamedElement().setName(newName);
			}
		}
		return true;
	}

	private boolean performRenamingForIteratorExp(IteratorExpCS parent) {
		//finding and renaming the variable declaration
		EList<IteratorExpVariableCS> variables = parent.getIteratorVariables();
		for (int i = 0; i < variables.size(); i++) {
			IteratorExpVariableCS akt = variables.get(i);
			if (akt.getVariableName().getSimpleName().equals(origName)) {
				akt.getVariableName().setSimpleName(newName);
				i = variables.size();
			}
		}

		//finding and renaming all references
		Iterator<EObject> it = parent.eAllContents();
		while (it.hasNext()) {
			EObject akt = it.next();
			if (akt instanceof NamedLiteralExpCS && ((NamedLiteralExpCS)akt).getNamedElement().getName().equals(origName)) {
				//we found a variable reference with the original name
				((NamedLiteralExpCS)akt).getNamedElement().setName(newName);
			}
		}
		return true;
	}

	private EObject getDefinitionParent(EObject child) {
		//finding the definition of the variable in the way up the hierarchy
		EObject parent = child.eContainer();
		if (parent instanceof PackageDeclarationCS) return null; //break condition	
		
		else if (parent instanceof LetExpCS) {
			//making sure the LetExpCS really contains the variable's definition
			EList<VariableDeclarationWithInitCS> variables = ((LetExpCS) parent).getVariableDeclarations();
			for (int i = 0; i < variables.size(); i++) {
				VariableDeclarationWithInitCS akt = variables.get(i);
				if (akt.getVariableName().getSimpleName().equals(origName)) {
					return parent;
				}
			}
			//if no variable definition is found the search will continue up the hierarchy
		}
		else if (parent instanceof IteratorExpCS) {
			//finding and renaming the variable declaration
			EList<IteratorExpVariableCS> variables = ((IteratorExpCS) parent).getIteratorVariables();
			for (int i = 0; i < variables.size(); i++) {
				IteratorExpVariableCS akt = variables.get(i);
				if (akt.getVariableName().getSimpleName().equals(origName)) {
					return parent;
				}
			}
			//if no variable definition is found the search will continue up the hierarchy
		}
		else if (parent instanceof IterateExpCS && (((IterateExpCS)parent).getIteratorVariable().getVariableName().getSimpleName().equals(origName))) return parent;
			
		return getDefinitionParent(parent);
		
	}

	private boolean performRenamingForLetExp(LetExpCS parent) {
		// rename declaration
		boolean found = false;
		boolean go = true;
		while (!found && go) {
			EList<VariableDeclarationWithInitCS> variables = parent.getVariableDeclarations();
			for (int i = 0; i < variables.size(); i++) {
				VariableDeclarationWithInitCS akt = variables.get(i);
				if (akt.getVariableName().getSimpleName().equals(origName)) {
					akt.getVariableName().setSimpleName(newName);
					i = variables.size();
					found = true;
				}
			}
			//for chained let expressions the definition of the variable to rename can be located in any of them,
			//therefore now the next one in the hierarchy has to be checked
			if (!found) {
				if (getDefinitionParent(parent) instanceof LetExpCS) parent = (LetExpCS) getDefinitionParent(parent);
				else go = false;				
			}
		}
//		LetExpCS nextParent = parent;
//		while (!found && this.getDefinitionParent(nextParent) instanceof LetExpCS) {
//			nextParent = (LetExpCS) this.getDefinitionParent(parent);
//			EList<VariableDeclarationWithInitCS> nextVariables = nextParent.getVariableDeclarations();
//			for (int i = 0; i < nextVariables.size(); i++) {
//				VariableDeclarationWithInitCS akt = nextVariables.get(i);
//				if (akt.getVariableName().getSimpleName().equals(origName)) {
//					akt.getVariableName().setSimpleName(newName);
//					i = variables.size();
//					found = true;
//				}
//			}
//		}
		
		if (!found) {
			System.out.println("Refactoring could not be performed for no valid variable declaration has been found.");
			return false;
		}
		
		
		EList<IteratorExpCS> overlappingIterators = calculateOverlappingIterators(parent.getOclExpression());
		Boolean hasOverlapping = false;
		if (overlappingIterators.size() > 0) hasOverlapping = true;
		if (hasOverlapping) System.out.println("	- overlapping detected!");
		else System.out.println("	- no overlapping detected!");
		Iterator<EObject> scopeIt = parent.getOclExpression().eAllContents();
		
		
		while (scopeIt.hasNext()) {
			EObject akt = scopeIt.next();
			if (akt instanceof NamedLiteralExpCS && ((NamedLiteralExpCS)akt).getNamedElement().getName().equals(origName)) {
				//we found a variable reference with the original name
				System.out.println("	- found variable to rename");
				NamedLiteralExpCS aktRef = (NamedLiteralExpCS) akt;
				//check if it can be renamed or if it is an iterator variable that does not reference the variable to rename
				Boolean renamingOK = true;
				if (hasOverlapping) {
					renamingOK = checkIsReference(aktRef, overlappingIterators);
				}
				if (!renamingOK) System.out.println(" - variable is an iterator variable and will not be renamed");
				if (renamingOK) System.out.println("	- variable is not an iterator variable and can be renamed");
				if (renamingOK) aktRef.getNamedElement().setName(newName);
				
			}
		}		
		return true;
	}

	

	private EList<IteratorExpCS> calculateOverlappingIterators(OclExpressionCS oclExpression) {

		EList<IteratorExpCS> overlappingIterators = new BasicEList<IteratorExpCS>();
		
		Iterator<EObject> it = oclExpression.eAllContents();
		while(it.hasNext()) {
			EObject akt = it.next();
			if (akt instanceof SimpleNameCS && ((SimpleNameCS)akt).getSimpleName().equals(origName)) {
				//we found an iterator variable that has the same name like the selected variable to rename
				//this iterator variable and all its references must not be renamed!
				System.out.println("	- found an overlapping iterator variable");
				System.out.println("	- akt.econtainer is: " +akt.eContainer());
				System.out.println("	- akt.econtainer.econtainer is: "+akt.eContainer().eContainer());
				if (akt.eContainer().eContainer() instanceof IteratorExpCS) overlappingIterators.add((IteratorExpCS) akt.eContainer().eContainer());
			}
		}		
		return overlappingIterators;
	}

	//checks if the given variable is contained in one of the iterators or not
	//if it is not, it is a reference to the variable to rename and renaming would be true
	private Boolean checkIsReference(NamedLiteralExpCS aktRef, EList<IteratorExpCS> overlappingIterators) {
		
		for (int i = 0; i < overlappingIterators.size(); i++) {
			Iterator<EObject> it = overlappingIterators.get(i).eAllContents();
			while (it.hasNext()) {
				EObject akt = it.next();
				//now if one of the elements contained in the iterator is our variable, it is referencing the overlapping iterator variable
				//and not the one that should be renamed
				if (EcoreUtil.equals(akt, aktRef)) return false; 
			}
		}
		
		return true;
	}
	
}
