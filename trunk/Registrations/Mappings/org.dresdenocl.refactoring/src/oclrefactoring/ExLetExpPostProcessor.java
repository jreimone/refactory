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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

import tudresden.ocl20.pivot.datatypes.impl.DatatypesFactoryImpl;
import tudresden.ocl20.pivot.language.ocl.BodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.ContextDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.IntegerLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.PackageDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.PrePostOrBodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
import tudresden.ocl20.pivot.language.ocl.TypePathNameSimpleCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;
import tudresden.ocl20.pivot.language.ocl.impl.OclFactoryImpl;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.impl.PivotModelFactoryImpl;

/**
 * @author Michael Muck
 *
 */
public class ExLetExpPostProcessor extends AbstractRefactoringPostProcessor {
	

	private OclExpressionCS extract;
	private EObject origContainer;
	private SimpleNameCS newContainer;
	private SimpleNameCS newType;
	private LetExpCS myLetExp;
	private Boolean newLetExp;
	private EStructuralFeature origRef;
	private EObject constraintRoot;
	
	OclFactoryImpl myOclFactory;
	DatatypesFactoryImpl myDataTypesFactory;
	PivotModelFactoryImpl myPivotModelFactory;
	
	
	
	
	
	public ExLetExpPostProcessor() {
		myOclFactory = new OclFactoryImpl();
		myDataTypesFactory = new DatatypesFactoryImpl();
		myPivotModelFactory = new PivotModelFactoryImpl();
	}
	
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier) {
		
		if (isFakeRun) return Status.OK_STATUS;
//		System.err.println("postprocessor activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
//			System.out.println("role found with name: "+role.getName());
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
//			for (EObject roleplayer : roleplayers) {
//				System.out.println("   element playing this role: "+roleplayer.eClass().getName());
//				if (roleplayer instanceof SimpleNameCS) {
//					System.out.println("      assigned name for SimpleNameCS: "+((SimpleNameCS)roleplayer).getSimpleName());
//				}
//			System.out.println();
//			}
			if (role.getName().equals("Extract")) {
				if (roleplayers.size() == 1) extract = (OclExpressionCS) roleplayers.get(0);
//				origRef = extract.eContainingFeature();
				origRef = extract.eContainmentFeature();
//				System.out.println("   extract identified as: "+extract.toString());
//				System.out.println("");
//				TreeIterator<EObject> eac = extract.eAllContents();
//				while (eac.hasNext()) {
//					System.out.println("     "+eac.next());
//				}
				
			}
//			else if (role.getName().equals("OrigContainer")) {
//				if (roleplayers.size() == 1) origContainer = (OclExpressionCS) roleplayers.get(0);
//				System.out.println("   OrigContainer identified as: "+origContainer.toString());
//				System.out.println("");
//				TreeIterator<EObject> oac = origContainer.eAllContents();
//				while (oac.hasNext()) {
//					System.out.println("     "+oac.next());
//				}
				
//			}
			else if (role.getName().equals("NewContainer")) {
				if (roleplayers.size() == 1) newContainer = (SimpleNameCS) roleplayers.get(0);
//				System.out.println("   NewContainer identified as: "+newContainer.eClass());
//				System.out.println("");
//				TreeIterator<EObject> nac = newContainer.eAllContents();
//				while (nac.hasNext()) {
//					System.out.println("     "+nac.next());
//				}
				
			}
			else if (role.getName().equals("NewType")) {
				if (roleplayers.size() == 1) newType = (SimpleNameCS) roleplayers.get(0);
//				System.out.println("   NewType identified as: "+newType.eClass());
//				System.out.println("");
//				TreeIterator<EObject> ntac = newType.eAllContents();
//				while (ntac.hasNext()) {
//					System.out.println("     "+ntac.next());
//				}
				
			}
			
		}
		
		performSpecificTransformation();
		
		return Status.OK_STATUS;
	}
	
	private void performSpecificTransformation() {
		
		//getting the root of the constraint and finding an existing or creating a new let-expression
		origContainer = extract.eContainer();
		constraintRoot = origContainer.eContainer();
//		System.err.println("tempparent: "+ constraintRoot.eClass());
		while (	!(constraintRoot instanceof InvariantExpCS) && 
				!(constraintRoot instanceof PrePostOrBodyDeclarationCS)) 
		{
			constraintRoot = constraintRoot.eContainer();
		}
		System.out.println("found constraint-root as: "+constraintRoot.toString());
		
		myLetExp = null;
		newLetExp = false;
		
		if (constraintRoot instanceof InvariantExpCS  && ((InvariantExpCS)constraintRoot).getOclExpression() instanceof LetExpCS) {
			InvariantExpCS inv = (InvariantExpCS)constraintRoot;
			myLetExp = (LetExpCS) inv.getOclExpression();
		} else if (constraintRoot instanceof PrePostOrBodyDeclarationCS && ((PrePostOrBodyDeclarationCS)constraintRoot).getOclExpression() instanceof LetExpCS) {
			PrePostOrBodyDeclarationCS inv = (PrePostOrBodyDeclarationCS)constraintRoot;
			myLetExp = (LetExpCS) inv.getOclExpression();
		} else {
			myLetExp = myOclFactory.createLetExpCS();
			newLetExp = true;
		}
		
		//this variable holds the first location of the extract within the declaration list
		LetExpCS firstContainingLetExp = null;
		int firstLocationIndex = -1;
		
		//add the new VariableDeclarationWithInit to the LetExpCS
		if(!newLetExp) {
			//if the letExp already existed and the extracted value was contained inside this letExp's declaration part, 
			//the new extracted variable has to be placed in front of it, because otherwise it could not be referenced
			//it cannot simply be put at the first position of the list though since it may contain references to other 
			//variables as well
			System.out.println("LetExp already present - checking if it contains the extract.");
	
			//checking if extract was located inside letExpDeclaration
			boolean declCheckDone = false;
			EObject checkObj = extract;
			while (!declCheckDone) {
//				System.out.println("checking "+checkObj.eClass());
				EObject container = checkObj.eContainer();
//				System.out.println("its container is: "+container);
				if (container instanceof ContextDeclarationCS || container instanceof PackageDeclarationCS) {
					//break condiditon, no VariableDeclarationWithInitListCS has been found in the uptree of the extract
					//so it is not inside of a letExp declaration field, so simply exiting the check
					//System.out.println("Extract not located inside a letExp's declaration.");
					declCheckDone = true;
					
				}
				else if (container instanceof LetExpCS) {
					EList<VariableDeclarationWithInitCS> myDecList = ((LetExpCS) container).getVariableDeclarations();
//					System.out.println("Extract located inside a letExp's declaration.");
					Iterator<VariableDeclarationWithInitCS> varIt = myDecList.iterator();
					while (varIt.hasNext()) {
						VariableDeclarationWithInitCS akt = varIt.next();
						Iterator<EObject> aktit = akt.eAllContents();
						while (aktit.hasNext()) {
							EObject next = aktit.next();
							if (EcoreUtil.equals(next, extract)) {
								//the extract is located inside a letExp's declaration, so its first occurrence there has to be located
								//found a location of the extract within the vardeclist, so if its the first one found or if
								//it is located in front of the last one found the index of this occurrence has to be saved
								int aktpos = myDecList.indexOf(akt);
//								System.out.println("Found location of the extract at index "+aktpos);
								if (firstContainingLetExp == null || !(EcoreUtil.equals(firstContainingLetExp, container))) {
									//there may be more than one letExpression in the ocl expression, so the first index in the first let
									//expression has to be found
								
									//if the actual container is not matching the firstContainingLetExp, it has to be actualized,
									//because the actual one is one step up in the hierarchy than the one previously found
									firstContainingLetExp = (LetExpCS) container;
									//the index has to be reset to the new found let exp
									firstLocationIndex = aktpos;
//									System.out.println("index is now: "+firstLocationIndex);
								
								}
								//the existing firstContainingLetExp is the actual one, so only the index has to be actualized if it
								//is smaller than the previously found one
								else if (firstLocationIndex == -1 || firstLocationIndex > aktpos) {
									firstLocationIndex = aktpos;
//									System.out.println("index is now: "+firstLocationIndex);
								}
							}
						}
					}
					//going up the hierarchy because there might be further let expressions that contain the extract
					checkObj = container;
					
					//declCheckDone = true;
				}
				else {
					//if nothing was found and checking is not yet completed, turning one step up in the hierarchy
//					System.out.println("Nothing relevant found yet - continuing up the hierarchy...");
					checkObj = container;
				}
			}
		}
		//reset the letExp to insert the new variable
		if (firstContainingLetExp != null) myLetExp = firstContainingLetExp;
//		System.out.println("check done.");
		
		
		
		
		
		//creating the variable and adding the extract
		
		VariableDeclarationWithInitCS myVD = myOclFactory.createVariableDeclarationWithInitCS();
//		System.out.println("myvd: "+myVD.eClass());
		myVD.setVariableName(newContainer);
		
		
		//creating a new Type for the VariableDeclaration from the provided input name
		TypePathNameSimpleCS mytype = myOclFactory.createTypePathNameSimpleCS();
		
		Type type = myPivotModelFactory.createType();
		type.setName(newType.getSimpleName());
				
		mytype.setTypeName(type);
		myVD.setTypeName(mytype);
		myVD.setInitialization(extract);
		myVD.setEqual("=");
		
		

		
		
		
	
		

		

		
		//there needs to be a reference created replacing the extract
		NamedLiteralExpCS myReferenceLiteral = myOclFactory.createNamedLiteralExpCS();
		Property myReferenceProp = myPivotModelFactory.createProperty();
		myReferenceProp.setName(newContainer.getSimpleName());
		myReferenceLiteral.setNamedElement(myReferenceProp);
		
//		System.out.println("container of extract: "+extract.eContainer());
//		System.out.println("containing feature of extract: "+extract.eContainingFeature());
//		System.out.println("orig containing feature of extract: "+origRef);
		
		if (origRef instanceof EReferenceImpl) {
//			EReferenceImpl myref = ((EReferenceImpl)origRef);
			origContainer.eSet(origRef, myReferenceLiteral);
		}
		
		//additionally we try to check, if there is any other occurence of the extract within the actual constraint,
		//and if there is, is will be replaced as well, but only if the selection is not an
		//integer literal
		
		if(extract instanceof IntegerLiteralExpCS) return;
		
		//moving the actual ocl expression from the invariant or pre/postcond body
		//to the new letexp
		if (newLetExp) {
			if (constraintRoot instanceof InvariantExpCS) {
				myLetExp.setOclExpression(((InvariantExpCS)constraintRoot).getOclExpression());
				((InvariantExpCS)constraintRoot).setOclExpression(myLetExp);
			} else if (constraintRoot instanceof BodyDeclarationCS) {
				myLetExp.setOclExpression(((BodyDeclarationCS)constraintRoot).getOclExpression());
				((BodyDeclarationCS)constraintRoot).setOclExpression(myLetExp);
			} else {
				System.err.println("constraint root is neither an InvariantExpCS nor a BodyDeclarationExpCS!!! Refactoring invalid!");
			}
		}
		
		TreeIterator<EObject> myLetIt = myLetExp.eAllContents();
		
		while (myLetIt.hasNext()) {
			EObject akt = myLetIt.next();
			if (EcoreUtil.equals(akt, extract)) {
				
				NamedLiteralExpCS myRefLit = myOclFactory.createNamedLiteralExpCS();
				Property myRefProp = myPivotModelFactory.createProperty();
				myRefProp.setName(newContainer.getSimpleName());
				myRefLit.setNamedElement(myRefProp);			
				
				EObject aktParent = akt.eContainer();
				aktParent.eSet(akt.eContainmentFeature(), myRefLit);
			}
		}
		
//		//now, any occurrence in the variable declarations has to be found as well
//		Iterator<VariableDeclarationWithInitCS> myVarIt = myLetExp.getVariableDeclarations().iterator();
//		while (myVarIt.hasNext()) {
//			VariableDeclarationWithInitCS akt = myVarIt.next();
//			Iterator<EObject> aktvarit = akt.getInitialization().eAllContents();
//			while (aktvarit.hasNext()) {
//				EObject aktvar = aktvarit.next();
//				if (EcoreUtil.equals(aktvar, extract)) {
//					System.out.println("found a reference in the declaration part...");
//					NamedLiteralExpCS myRefLit = myOclFactory.createNamedLiteralExpCS();
//					Property myRefProp = myPivotModelFactory.createProperty();
//					myRefProp.setName(newContainer.getSimpleName());
//					myRefLit.setNamedElement(myRefProp);		
//					
//					EObject aktParent = aktvar.eContainer();
//					aktParent.eSet(aktvar.eContainmentFeature(), myRefLit);
//				}
//			}
//		}
		
		//at last the new variable will be added at the correct position in the list
		if (firstLocationIndex > -1) myLetExp.getVariableDeclarations().add(firstLocationIndex,myVD);
		else {
			myLetExp.getVariableDeclarations().add(myVD);
			System.err.println("Variable added to end of declaration list.");
		}
		
			
	}



	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {
		// TODO Auto-generated method stub
		return null;
	}
}
