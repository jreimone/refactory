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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

import tudresden.ocl20.pivot.datatypes.DatatypesFactory;
import tudresden.ocl20.pivot.language.ocl.BodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.ContextDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.ImplicitFeatureCallCS;
import tudresden.ocl20.pivot.language.ocl.IntegerLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.NavigationCallExp;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.OclFactory;
import tudresden.ocl20.pivot.language.ocl.OperationCallBaseExpCS;
import tudresden.ocl20.pivot.language.ocl.PackageDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.PrePostOrBodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.PropertyCallBaseExpCS;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;
import tudresden.ocl20.pivot.pivotmodel.PivotModelFactory;
import tudresden.ocl20.pivot.pivotmodel.Property;

/**
 * @author Michael Muck
 *
 */
public class ExLetExpPostProcessor extends AbstractRefactoringPostProcessor {


	private OclExpressionCS extract;
	private EObject origExtractContainer;
	private SimpleNameCS variableName;
	private LetExpCS letExpression;
	private Boolean newLetExp;
	private EStructuralFeature origExtractReference;
	private EObject constraintRoot;

	private OclFactory oclFactory;
	private List<EObject> subsequentExtracts;

	public ExLetExpPostProcessor() {
		oclFactory = OclFactory.eINSTANCE;
	}


	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {

		if (isFakeRun) return Status.OK_STATUS;

		extract = RoleUtil.getFirstObjectForRole("Selection", OclExpressionCS.class, roleRuntimeInstanceMap);
		variableName = RoleUtil.getFirstObjectForRole("Nameable", SimpleNameCS.class, roleRuntimeInstanceMap);
		subsequentExtracts = new ArrayList<EObject>();
		subsequentExtracts.addAll(initialSelection);

		origExtractReference = extract.eContainmentFeature();

		performSpecificTransformation();

		return Status.OK_STATUS;
	}

	private void performSpecificTransformation() {

		//getting the root of the constraint and finding an existing or creating a new let-expression
		origExtractContainer = extract.eContainer();
		constraintRoot = origExtractContainer.eContainer();
		//		System.err.println("tempparent: "+ constraintRoot.eClass());
		while (	!(constraintRoot instanceof InvariantExpCS) && 
				!(constraintRoot instanceof PrePostOrBodyDeclarationCS)) 
		{
			constraintRoot = constraintRoot.eContainer();
		}
		System.out.println("found constraint-root as: "+constraintRoot.toString());

		letExpression = null;
		newLetExp = false;

		if (constraintRoot instanceof InvariantExpCS  && ((InvariantExpCS)constraintRoot).getOclExpression() instanceof LetExpCS) {
			InvariantExpCS inv = (InvariantExpCS)constraintRoot;
			letExpression = (LetExpCS) inv.getOclExpression();
		} else if (constraintRoot instanceof PrePostOrBodyDeclarationCS && ((PrePostOrBodyDeclarationCS)constraintRoot).getOclExpression() instanceof LetExpCS) {
			PrePostOrBodyDeclarationCS inv = (PrePostOrBodyDeclarationCS)constraintRoot;
			letExpression = (LetExpCS) inv.getOclExpression();
		} else {
			letExpression = oclFactory.createLetExpCS();
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
		if (firstContainingLetExp != null) letExpression = firstContainingLetExp;

		//creating the variable and adding the extract
		VariableDeclarationWithInitCS variableDeclaration = oclFactory.createVariableDeclarationWithInitCS();
		//		System.out.println("myvd: "+myVD.eClass());
		variableDeclaration.setVariableName(variableName);

		OclExpressionCS copy = EcoreUtil.copy(extract);
		if(subsequentExtracts.size() == 1){
			variableDeclaration.setInitialization(copy);
		} else {
			NavigationCallExp callExp = oclFactory.createNavigationCallExp();
			callExp.setSource(copy);
			for (EObject subsequentElement : subsequentExtracts) {
				if(!extract.equals(subsequentElement)){
					if(subsequentElement instanceof ImplicitFeatureCallCS){
						ImplicitFeatureCallCS featureCall = (ImplicitFeatureCallCS) subsequentElement;
						if(featureCall instanceof PropertyCallBaseExpCS){
							callExp.getNavigationOperator().add(".");
						} else if(featureCall instanceof OperationCallBaseExpCS){
							callExp.getNavigationOperator().add("->");
						}
						ImplicitFeatureCallCS featureCallCopy = EcoreUtil.copy(featureCall);
						callExp.getFeatureCalls().add(featureCallCopy);
					} else {
						break;
					}
				}
			}
			variableDeclaration.setInitialization(callExp);
			extract = callExp;
		}
		variableDeclaration.setEqual("=");

		//additionally we try to check, if there is any other occurence of the extract within the actual constraint,
		//and if there is, it will be replaced as well, but only if the selection is not an
		//integer literal

		//		if(extract instanceof IntegerLiteralExpCS) return;

		//moving the actual ocl expression from the invariant or pre/postcond body
		//to the new letexp
		if (newLetExp) {
			if (constraintRoot instanceof InvariantExpCS) {
				letExpression.setOclExpression(((InvariantExpCS)constraintRoot).getOclExpression());
				((InvariantExpCS)constraintRoot).setOclExpression(letExpression);
			} else if (constraintRoot instanceof BodyDeclarationCS) {
				letExpression.setOclExpression(((BodyDeclarationCS)constraintRoot).getOclExpression());
				((BodyDeclarationCS)constraintRoot).setOclExpression(letExpression);
			} else {
				System.err.println("constraint root is neither an InvariantExpCS nor a BodyDeclarationExpCS!!! Refactoring invalid!");
			}
		}


			TreeIterator<EObject> letIterator = letExpression.eAllContents();

			while (letIterator.hasNext()) {
				EObject nextElement = letIterator.next();
				if((nextElement instanceof OclExpressionCS) && PostProcessingHelper.isExpressionComprised((OclExpressionCS) nextElement, extract)){
					PostProcessingHelper.replaceExpression(nextElement, extract, variableName);	
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
		if (firstLocationIndex > -1) letExpression.getVariableDeclarations().add(firstLocationIndex,variableDeclaration);
		else {
			letExpression.getVariableDeclarations().add(variableDeclaration);
			System.err.println("Variable added to end of declaration list.");
		}


	}

}
