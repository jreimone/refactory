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
package org.dresdenocl.refactoring;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

import tudresden.ocl20.pivot.language.ocl.BracketExpCS;
import tudresden.ocl20.pivot.language.ocl.IteratorExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.LogicalAndOperationCallExpCS;
import tudresden.ocl20.pivot.language.ocl.LogicalImpliesOperationCallExpCS;
import tudresden.ocl20.pivot.language.ocl.LogicalNotOperationCallExpCS;
import tudresden.ocl20.pivot.language.ocl.LogicalOrOperationCallExpCS;
import tudresden.ocl20.pivot.language.ocl.LogicalXorOperationCallExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.OclFactory;
import tudresden.ocl20.pivot.language.ocl.PackageDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;

public class InlineVariablePP extends AbstractRefactoringPostProcessor {
	
	private EObject constraintRoot;
	
	
	private VariableDeclarationWithInitCS selectedDeclaration;
	private NamedLiteralExpCS selectedReference;
	private LetExpCS letExpression;
	private String variableName;
	
	private OclFactory oclFactory;
	
	public InlineVariablePP() {
		oclFactory = OclFactory.eINSTANCE;
	}
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {
		System.err.println("postprocessor activated!");
		if (isFakeRun) {
			System.out.println("skipping postprocessing for fakerun");
			return Status.OK_STATUS;
		}
		selectedDeclaration = RoleUtil.getFirstObjectForRole("Selection", VariableDeclarationWithInitCS.class, roleRuntimeInstanceMap);
		selectedReference = RoleUtil.getFirstObjectForRole("Selection", NamedLiteralExpCS.class, roleRuntimeInstanceMap);
		
		IStatus refactoringStatus = Status.CANCEL_STATUS;
		
		if (selectedDeclaration != null) refactoringStatus = performSpecificTransformationForSelectedDeclaration();
		else if (selectedReference != null) refactoringStatus = performSpecificTransformationForSelectedReference();
			
		return refactoringStatus;
	}
		
	private IStatus performSpecificTransformationForSelectedReference() {
		System.out.println("variable name: "+selectedReference.getNamedElement().getName());
		EObject parent = getDefinitionParent(selectedReference);
		IStatus status = Status.CANCEL_STATUS;
		if (parent == null) {
			System.out.println(" Selected element is not a variable - refactoring aborted!");
		}
		else if (parent instanceof IteratorExpCS) {
			System.out.println(" Selected reference points to an iterator variable - inlining aborted!");
		}
		else if (parent instanceof LetExpCS) {
			System.out.println(" Selected reference points to a variable - inlining...");
			status = inlineSingleReference((LetExpCS)parent);
		}
		
		return status;
			
		}
	private IStatus inlineSingleReference(LetExpCS parent) {
		
		IStatus status = Status.CANCEL_STATUS;
		VariableDeclarationWithInitCS myvar = null;
		boolean found = false;
		boolean go = true;
		while (!found && go) {
			for (int i=0; i<parent.getVariableDeclarations().size();i++) {
				System.out.println("found "+parent.getVariableDeclarations().size()+" variable declarations.");
				VariableDeclarationWithInitCS aktvar = parent.getVariableDeclarations().get(i);
				System.out.println("name of currently checked variable: "+aktvar.getVariableName().getSimpleName());
				if (aktvar.getVariableName().getSimpleName().equals(selectedReference.getNamedElement().getName())) {
					myvar = aktvar;
					i = parent.getVariableDeclarations().size();
					found = true;
				}
			}
			//for chained let expressions the definition of the variable to inline can be located in any of them,
			//therefore now the next one in the hierarchy has to be checked
			if (!found) {
				if (getDefinitionParent(parent) instanceof LetExpCS) parent = (LetExpCS) getDefinitionParent(parent);
				else go = false;				
			}
		}
		
		if (myvar == null) {
			System.out.println(" No matching variable declaration found - refactoring aborted!");
			return Status.CANCEL_STATUS;
		}
		
		status = inlineReference(myvar.getInitialization(), selectedReference);
		return status;
	}

	private EObject getDefinitionParent(EObject child) {
		EObject parent = child.eContainer();
		if (parent instanceof PackageDeclarationCS) return null; //break condition	
		
		if (parent instanceof LetExpCS) return parent;
		if (parent instanceof IteratorExpCS) return parent;
			
		return getDefinitionParent(parent);
	}
	
	private IStatus performSpecificTransformationForSelectedDeclaration() {
		if (!(selectedDeclaration.eContainer() instanceof LetExpCS)) {
			return Status.CANCEL_STATUS;
		}
		
		letExpression = (LetExpCS) selectedDeclaration.eContainer();
		variableName = selectedDeclaration.getVariableName().getSimpleName();
		OclExpressionCS declaration = selectedDeclaration.getInitialization();
		
		
		//at first, search and replace all instances of the variable with the actual declaration
		// TODO bracket expression
		TreeIterator<EObject> iterator = letExpression.getOclExpression().eAllContents();
		while (iterator.hasNext()) {
			EObject akt = iterator.next();
			if (akt instanceof NamedLiteralExpCS) {
				NamedLiteralExpCS aktLit = (NamedLiteralExpCS) akt;
				if (aktLit.getNamedElement().getName().equals(variableName)) {
					inlineReference(declaration, aktLit);
				}
			}
		}
		
		//now delete the declaration from the if expression
		
		letExpression.getVariableDeclarations().remove(selectedDeclaration);
		
		//if there are no more variable declarations left, the let expression will be empty and has to be removed
		if (letExpression.getVariableDeclarations().size() == 0) {
//			System.out.println("removing empty let expression");
			constraintRoot = letExpression.eContainer();
			EStructuralFeature parentLink = letExpression.eContainingFeature();
			constraintRoot.eSet(parentLink, letExpression.getOclExpression());
		}
		return Status.OK_STATUS;		
	}
	
	
	private IStatus inlineReference(OclExpressionCS inlineExpression, NamedLiteralExpCS replacee) {
		IStatus status = Status.CANCEL_STATUS;
		//here we are at a place, where the variable should be integrated
		EObject container = replacee.eContainer();
		EStructuralFeature containerRef = replacee.eContainingFeature();
		
		//as a precaution for avoiding changes in meaning through weaker/stronger operator binding in the 
		//target expression, the declaration will be set in brackets before it is integrated
		
//		System.out.println(" Copying initialization...");
//		ReferenceCopier copier = new ReferenceCopier();
//		EList<EObject> copiedList = new BasicEList<EObject>();
//		EObject copiedDeclaration = copier.copy(inlineExpression);
//		copiedList.add(copiedDeclaration);
//		TreeIterator<EObject> copyListIterator = inlineExpression.eAllContents();
//		while (copyListIterator.hasNext()) {
//			copiedList.add(copier.copy(copyListIterator.next()));
//		}
//		System.out.println(" Copying references...");
//		copier.copyReferences();
		
		OclExpressionCS copiedDeclaration = EcoreUtil.copy(inlineExpression);
		
		OclExpressionCS newValue = null;
		if (copiedDeclaration instanceof BracketExpCS) {
			newValue = (BracketExpCS) copiedDeclaration;
		} else { 
			System.out.println(" Putting copied initialization within brackets...");
			if(copiedDeclaration instanceof LogicalAndOperationCallExpCS
					|| copiedDeclaration instanceof LogicalImpliesOperationCallExpCS
					|| copiedDeclaration instanceof LogicalNotOperationCallExpCS
					|| copiedDeclaration instanceof LogicalOrOperationCallExpCS
					|| copiedDeclaration instanceof LogicalXorOperationCallExpCS){
				BracketExpCS bracketExpression = oclFactory.createBracketExpCS();
				bracketExpression.setOclExpression((OclExpressionCS) copiedDeclaration);
				newValue = bracketExpression;
			} else {
				newValue = copiedDeclaration;
			}
		}
		System.out.println(" Replacing reference with copied initialization value...");
		container.eSet(containerRef, newValue);
		System.out.println(" Done...");
		status = Status.OK_STATUS;
		return status;
	}

}
