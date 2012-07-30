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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

import tudresden.ocl20.pivot.datatypes.impl.DatatypesFactoryImpl;
import tudresden.ocl20.pivot.language.ocl.BracketExpCS;
import tudresden.ocl20.pivot.language.ocl.IteratorExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.PackageDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;
import tudresden.ocl20.pivot.language.ocl.impl.OclFactoryImpl;
import tudresden.ocl20.pivot.pivotmodel.impl.PivotModelFactoryImpl;

public class InlineVariablePP extends AbstractRefactoringPostProcessor {
	
	private EObject constraintRoot;
	
	
	private VariableDeclarationWithInitCS selectedDeclaration;
	private NamedLiteralExpCS selectedReference;
	private LetExpCS myLetExp;
	String VariableName;
	
	
	OclFactoryImpl myOclFactory;
	DatatypesFactoryImpl myDataTypesFactory;
	PivotModelFactoryImpl myPivotModelFactory;
	
	public InlineVariablePP() {
		myOclFactory = new OclFactoryImpl();
		myDataTypesFactory = new DatatypesFactoryImpl();
		myPivotModelFactory = new PivotModelFactoryImpl();
	}
	
	
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier) {
		System.err.println("postprocessor activated!");
		if (isFakeRun) {
			System.out.println("skipping postprocessing for fakerun");
			return Status.OK_STATUS;
		}
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
//			System.out.println("role found with name: "+role.getName());
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			
			if (role.getName().equals("Selection")) {
				if (roleplayers.size() == 1 && (roleplayers.get(0) instanceof VariableDeclarationWithInitCS)) selectedDeclaration = (VariableDeclarationWithInitCS) roleplayers.get(0);
				else if (roleplayers.size() == 1 && (roleplayers.get(0) instanceof NamedLiteralExpCS)) selectedReference = (NamedLiteralExpCS) roleplayers.get(0);
//				System.out.println("   extract identified as: "+selection.toString());
			}
			
		}
		
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
//			System.err.println("Integrate Variable From LetExpression cannot be called from outside a LetExp!");
			return Status.CANCEL_STATUS;
		}
		
		myLetExp = (LetExpCS) selectedDeclaration.eContainer();
		VariableName = selectedDeclaration.getVariableName().getSimpleName();
		OclExpressionCS declaration = selectedDeclaration.getInitialization();
		
		
		//at first, search and replace all instances of the variable with the actual declaration
		// TODO bracket expression
		TreeIterator<EObject> myIt = myLetExp.eAllContents();
		while (myIt.hasNext()) {
			EObject akt = myIt.next();
			if (akt instanceof NamedLiteralExpCS) {
				NamedLiteralExpCS aktLit = (NamedLiteralExpCS) akt;
				if (aktLit.getNamedElement().getName().equals(VariableName)) {
					
					inlineReference(declaration, aktLit);
					
//					//here we are at a place, where the variable should be integrated
//					EObject container = aktLit.eContainer();
//					EStructuralFeature containerRef = aktLit.eContainingFeature();
//					
//					//as a precaution for avoiding changes in meaning through weaker/stronger operator binding in the 
//					//target expression, the declaration will be set in brackets before it is integrated
//					BracketExpCS myBracket = myOclFactory.createBracketExpCS();
//					
//					ReferenceCopier copier = new ReferenceCopier();
//					EList<EObject> copiedList = new BasicEList<EObject>();
//					EObject myCopiedDeclaration = copier.copy(declaration);
//					copiedList.add(myCopiedDeclaration);
//					TreeIterator<EObject> copyListIterator = declaration.eAllContents();
//					while (copyListIterator.hasNext()) {
//						copiedList.add(copier.copy(copyListIterator.next()));
//					}
//					copier.copyReferences();
//					
//					
//					Iterator<EObject> myCopyIt = copiedList.iterator();
//					while (myCopyIt.hasNext()) {
//						EObject aktcopy = myCopyIt.next();
//						if (EcoreUtil.equals(aktcopy, declaration)) {
//							myCopiedDeclaration = (OclExpressionCS) aktcopy;
//						}
//					}
//					if (myCopiedDeclaration instanceof BracketExpCS) {
//						myBracket = (BracketExpCS) myCopiedDeclaration;
//					} else { 
//						myBracket.setOclExpression((OclExpressionCS) myCopiedDeclaration);
//					}
//					container.eSet(containerRef, myBracket);
					
				}
			}
		}
		
		//now delete the declaration from the if expression
		
		myLetExp.getVariableDeclarations().remove(selectedDeclaration);
		
		//if there are no more variable declarations left, the let expression will be empty and has to be removed
		if (myLetExp.getVariableDeclarations().size() == 0) {
//			System.out.println("removing empty let expression");
			constraintRoot = myLetExp.eContainer();
			EStructuralFeature parentLink = myLetExp.eContainingFeature();
			constraintRoot.eSet(parentLink, myLetExp.getOclExpression());
		}
		
				
		return Status.OK_STATUS;		
	}
	
	
	private IStatus inlineReference(OclExpressionCS initializationValue, NamedLiteralExpCS reference) {
		IStatus status = Status.CANCEL_STATUS;
		//here we are at a place, where the variable should be integrated
		EObject container = reference.eContainer();
		EStructuralFeature containerRef = reference.eContainingFeature();
		
		//as a precaution for avoiding changes in meaning through weaker/stronger operator binding in the 
		//target expression, the declaration will be set in brackets before it is integrated
		BracketExpCS myBracket = myOclFactory.createBracketExpCS();
		
		System.out.println(" Copying initialization...");
		ReferenceCopier copier = new ReferenceCopier();
		EList<EObject> copiedList = new BasicEList<EObject>();
		EObject myCopiedDeclaration = copier.copy(initializationValue);
		copiedList.add(myCopiedDeclaration);
		TreeIterator<EObject> copyListIterator = initializationValue.eAllContents();
		while (copyListIterator.hasNext()) {
			copiedList.add(copier.copy(copyListIterator.next()));
		}
		System.out.println(" Copying references...");
		copier.copyReferences();
		
		
//		Iterator<EObject> myCopyIt = copiedList.iterator();
//		while (myCopyIt.hasNext()) {
//			EObject aktcopy = myCopyIt.next();
//			if (EcoreUtil.equals(aktcopy, initializationValue)) {
//				myCopiedDeclaration = (OclExpressionCS) aktcopy;
//			}
//		}
		if (myCopiedDeclaration instanceof BracketExpCS) {
			myBracket = (BracketExpCS) myCopiedDeclaration;
		} else { 
			System.out.println(" Putting copied initialization within brackets...");
			myBracket.setOclExpression((OclExpressionCS) myCopiedDeclaration);
		}
		System.out.println(" Replacing reference with copied initialization value...");
		container.eSet(containerRef, myBracket);
		System.out.println(" Done...");
		status = Status.OK_STATUS;
		return status;
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {
		// TODO Auto-generated method stub
		return null;
	}

}
