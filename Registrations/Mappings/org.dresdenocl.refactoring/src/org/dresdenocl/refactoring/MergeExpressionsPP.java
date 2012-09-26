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

import tudresden.ocl20.pivot.datatypes.impl.DatatypesFactoryImpl;
import tudresden.ocl20.pivot.language.ocl.ClassifierContextDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.InvariantOrDefinitionCS;
import tudresden.ocl20.pivot.language.ocl.LogicalAndOperationCallExpCS;
import tudresden.ocl20.pivot.language.ocl.PackageDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.impl.OclFactoryImpl;
import tudresden.ocl20.pivot.pivotmodel.impl.PivotModelFactoryImpl;

/**
 * @author Michael Muck
 *
 */
public class MergeExpressionsPP extends AbstractRefactoringPostProcessor {

	
	OclFactoryImpl myOclFactory;
	DatatypesFactoryImpl myDataTypesFactory;
	PivotModelFactoryImpl myPivotModelFactory;
	ClassifierContextDeclarationCS selection;
	PackageDeclarationCS myPackage;
	PostProcessingHelper myPPH;
	

	public MergeExpressionsPP() {

		myOclFactory = new OclFactoryImpl();
		myDataTypesFactory = new DatatypesFactoryImpl();
		myPivotModelFactory = new PivotModelFactoryImpl();
		myPPH = new PostProcessingHelper();
	}
	
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {

		System.err.println("Merge Invariants postprocessor activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			if (role.getName().equals("Selection")) {
//				System.out.println(roleplayers.size()+" roleplayers found for role "+role.getName()+":");
//				Iterator<EObject> roleplayersIt = roleplayers.iterator();
//				while (roleplayersIt.hasNext()) {
//					System.out.println("  "+roleplayersIt.next());
//				}				
				if (roleplayers.size()==1 && roleplayers.get(0) instanceof ClassifierContextDeclarationCS) {
					selection = (ClassifierContextDeclarationCS) roleplayers.get(0);
					System.out.println("found selected element as: "+selection);
				}
			}
		}
		if (selection == null) {
			System.err.println("No ClassifierContextDeclarations has been selected. Refactoring aborted!");
			return Status.CANCEL_STATUS;
		}
		IStatus refactoringStatus = performSpecificTransformation();
		
		
		return refactoringStatus;
	}
	
	
	private IStatus performSpecificTransformation() {
		
		//if the input element does not contain invariants or definitions there is nothing to merge
		if (selection.getInvariantsAndDefinitions().isEmpty()) {
			System.err.println("The selected input element does not contain any invariants or definitions. Refactoring aborted.");
			return Status.CANCEL_STATUS;
		}
		//collecting all invariants from selection
		EList<InvariantOrDefinitionCS> invariantOrDefinitionList = selection.getInvariantsAndDefinitions();
		EList<InvariantExpCS> invariantList = new BasicEList<InvariantExpCS>();
		Iterator<InvariantOrDefinitionCS> invariantOrDefinitionListIterator = invariantOrDefinitionList.iterator();
		while (invariantOrDefinitionListIterator.hasNext()) {
			InvariantOrDefinitionCS akt = invariantOrDefinitionListIterator.next();
			if (akt instanceof InvariantExpCS) invariantList.add((InvariantExpCS) akt);
		}
		
		//since only invariants can be merged, if the selected element contains definitions, the refactoring wont work
		if (invariantList.size() != invariantOrDefinitionList.size()) {
			System.err.println("  The selections contains DefinitionExpressions, but only InvariantExpressions can be merged!");
			return Status.CANCEL_STATUS;
		}
		
		//at least 2 invariants have to be present, or there is nothing to be matched
		if(invariantList.size()<2) {
			System.err.println("There are less than 2 invariants present in the selection. No merging is possible!");
			return Status.CANCEL_STATUS;
		}
		
		//now merging the Invariants
		InvariantExpCS result = invariantList.get(0);
		for(int i=1;i<invariantList.size();i++) {
			InvariantExpCS akt = invariantList.get(i);
			LogicalAndOperationCallExpCS myAnd = myOclFactory.createLogicalAndOperationCallExpCS();
			myAnd.setOperationName("and");
			myAnd.setSource(result.getOclExpression());
			myAnd.setTarget(akt.getOclExpression());
			result.setOclExpression(myAnd);
		}
		for(int j=1;j<selection.getInvariantsAndDefinitions().size();j++) {
			selection.getInvariantsAndDefinitions().remove(j);
		}
		
		
		
		return Status.OK_STATUS;
	}
	

	
	
	


	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {
		// TODO Auto-generated method stub
		return null;
	}
}
