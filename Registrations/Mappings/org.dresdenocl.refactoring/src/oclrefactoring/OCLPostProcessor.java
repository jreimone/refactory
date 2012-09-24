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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

import tudresden.ocl20.pivot.language.ocl.IteratorExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.PackageDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
/**
 * @author Michael Muck
 *
 */
public class OCLPostProcessor implements IRefactoringPostProcessor {
	
	
	String origName;
	String newName;
	SimpleNameCS selection;
	boolean refactoringSuccessful = false;

	public OCLPostProcessor() {
		
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
						&& (mappedElements.get(0) instanceof SimpleNameCS)) {
					selection = (SimpleNameCS) mappedElements.get(0);
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
		origName = selection.getSimpleName();
		System.out.println("orig name: "+ origName);
		System.out.println("new name: "+ newName);
		
		performPostProcessing();
		if (refactoringSuccessful) return Status.OK_STATUS;
		else return Status.CANCEL_STATUS;
	}

	private void performPostProcessing() {

		EObject parent = getDefinitionParent(selection);
		if (parent instanceof LetExpCS) {
			refactoringSuccessful = performRenamingForLetExp((LetExpCS)parent);
		}
		if (parent instanceof IteratorExpCS) {
			refactoringSuccessful = performRenamingForIteratorExp((IteratorExpCS)parent);
		}
		
	}

	

	private boolean performRenamingForIteratorExp(IteratorExpCS parent) {
		selection.setSimpleName(newName);
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

		EObject parent = child.eContainer();
		if (parent instanceof PackageDeclarationCS) return null; //break condition	
		
		if (parent instanceof LetExpCS) return parent;
		if (parent instanceof IteratorExpCS) return parent;
			
		return getDefinitionParent(parent);
		
	}

	private boolean performRenamingForLetExp(LetExpCS parent) {
		// rename declaration
		selection.setSimpleName(newName);
		
		
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
					renamingOK = referencesSelection(aktRef, overlappingIterators);
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
	private Boolean referencesSelection(NamedLiteralExpCS aktRef, EList<IteratorExpCS> overlappingIterators) {
		
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
