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

import org.dresdenocl.language.ocl.IteratorExpCS;
import org.dresdenocl.language.ocl.LetExpCS;
import org.dresdenocl.language.ocl.NamedElementCS;
import org.dresdenocl.language.ocl.OclExpressionCS;
import org.dresdenocl.language.ocl.PackageDeclarationCS;
import org.dresdenocl.language.ocl.SimpleNameCS;
import org.dresdenocl.language.ocl.VariableDeclarationCS;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

/**
 * @author Michael Muck
 *
 */
public class RenameVariablePP extends AbstractRefactoringPostProcessor {
	
	
	String origName;
	String newName;
	VariableDeclarationCS variableDeclaration;

	public RenameVariablePP() {
		
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			EObject refactoredModel, ResourceSet resourceSet,
			ChangeDescription change, RefactoringSpecification refSpec,
			List<IModelRefactoringWizardPage> customWizardPages,
			boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {
		
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
						&& (mappedElements.get(0) instanceof VariableDeclarationCS)) {
					variableDeclaration = (VariableDeclarationCS) mappedElements.get(0);
				}
			}
			else if (role.getName().equals("Nameable")) {
				mappedElements = roleRuntimeInstanceMap.get(role);
				if (mappedElements != null && mappedElements.size() >0 && (mappedElements.get(0)) instanceof SimpleNameCS) {
					newName = ((SimpleNameCS) mappedElements.get(0)).getSimpleName();
					
				}
			}
		}
		if (variableDeclaration == null) {
			System.err.println("No variable declaration could be found by postprocessor. Refactoring aborted.");
			return Status.OK_STATUS;
		}
		origName = variableDeclaration.getVariableName().getSimpleName();
		System.out.println("orig name: "+ origName);
		System.out.println("new name: "+ newName);
		System.out.println("var dec: "+ variableDeclaration);
		
		performPostProcessing();
		
		return Status.OK_STATUS;
	}

	private void performPostProcessing() {

		EObject parent = getDefinitionParent(variableDeclaration);
		if (parent instanceof LetExpCS) performRenamingForLetExp((LetExpCS)parent);
		
	}

	

	private EObject getDefinitionParent(EObject child) {

		EObject parent = child.eContainer();
		if (parent instanceof PackageDeclarationCS) return null; //break condition	
		
		if (parent instanceof LetExpCS) return parent;
			
		return getDefinitionParent(parent);
		
	}

	private boolean performRenamingForLetExp(LetExpCS parent) {
		// rename declaration
		variableDeclaration.getVariableName().setSimpleName(newName);
		
		
		EList<IteratorExpCS> overlappingIterators = calculateOverlappingIterators(parent.getOclExpression());
		Boolean hasOverlapping = false;
		if (overlappingIterators.size() > 0) hasOverlapping = true;
		if (hasOverlapping) System.out.println("	- overlapping detected!");
		else System.out.println("	- no overlapping detected!");
		Iterator<EObject> scopeIt = parent.getOclExpression().eAllContents();
		
		
		while (scopeIt.hasNext()) {
			EObject akt = scopeIt.next();
			if (akt instanceof NamedElementCS && ((NamedElementCS)akt).getNamedElement().getName().equals(origName)) {
				//we found a variable reference with the original name
				System.out.println("	- found variable to rename");
				NamedElementCS aktRef = (NamedElementCS) akt;
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
	private Boolean checkIsReference(NamedElementCS aktRef, EList<IteratorExpCS> overlappingIterators) {
		
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
