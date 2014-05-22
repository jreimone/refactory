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

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dresdenocl.datatypes.impl.DatatypesFactoryImpl;
import org.dresdenocl.language.ocl.ClassifierContextDeclarationCS;
import org.dresdenocl.language.ocl.InvariantOrDefinitionCS;
import org.dresdenocl.language.ocl.PackageDeclarationCS;
import org.dresdenocl.language.ocl.impl.OclFactoryImpl;
import org.dresdenocl.pivotmodel.impl.PivotModelFactoryImpl;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
public class SeparateContextClassifiersPP extends AbstractRefactoringPostProcessor {

	
	OclFactoryImpl myOclFactory;
	DatatypesFactoryImpl myDataTypesFactory;
	PivotModelFactoryImpl myPivotModelFactory;
	private ClassifierContextDeclarationCS selected;
	private int splitCount;
	PackageDeclarationCS myPackage;
	//set this to false to enable postprocessing for preview fake run
	private boolean debug = true;
	

	public SeparateContextClassifiersPP() {

		System.out.println("Initializing SeparateContextClassifiersPostProcessor...");
		
	}
	
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {

		if (debug && isFakeRun) return Status.OK_STATUS;
		System.out.println("Separate Context Classifiers postprocessor activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			if (role.getName().equals("Selection")) {
				if (roleplayers.size()==1 && roleplayers.get(0) instanceof ClassifierContextDeclarationCS) {
					selected = (ClassifierContextDeclarationCS) roleplayers.get(0);
//					System.out.println("found selected element as: "+selected);
				}
			}
		}
		if (selected == null) {
			System.err.println("No ContextDeclarationCS selected. Refactoring aborted!");
			return Status.CANCEL_STATUS;
		}
		IStatus refactoringStatus = performSpecificTransformation();
		
		if (splitCount == 0) {
			System.out.println("Constraint could not be split.");
		} else {
			System.out.println("Constraint has been split "+splitCount+" times.");
		}
		
		return refactoringStatus;
	}
	
	
	private IStatus performSpecificTransformation() {
		
		ReferenceCopier myCopier = new ReferenceCopier();
		myOclFactory = new OclFactoryImpl();
		myDataTypesFactory = new DatatypesFactoryImpl();
		myPivotModelFactory = new PivotModelFactoryImpl();
		splitCount = 0;
		
		if (selected.eContainer()instanceof PackageDeclarationCS) {
			myPackage = (PackageDeclarationCS) selected.eContainer();
//			System.out.println("found package declaration as: "+myPackage);
		} else {
//			System.err.println("package declaration not found - refactoring cancelled!");
			return Status.CANCEL_STATUS;
		}
		
		EList<InvariantOrDefinitionCS> invList = selected.getInvariantsAndDefinitions();
		
		
		ClassifierContextDeclarationCS myClassifierContextDeclarationCS = myOclFactory.createClassifierContextDeclarationCS();
		//System.out.println("created ClassifierContextDeclarationCS: "+myClassifierContextDeclarationCS);
		myClassifierContextDeclarationCS.setTypeName(EcoreUtil.copy(selected.getTypeName()));
		//System.out.println("added type to ClassifierContextDeclarationCS:"+myClassifierContextDeclarationCS.getTypeName());
		
		
//		System.out.println("Found "+invList.size()+" invariants and definitions.");
		//passesNeeded is used because the list shrinks with every element that is 
		//put in another container, so an iterator wont do the trick
		int passesNeeded = invList.size();
		for (int i=0; i<passesNeeded;i++) {
//			System.out.println("pass 1");		
//			System.out.println("invlistsize: "+invList.size());
			InvariantOrDefinitionCS akt = invList.get(0);
//			InvariantOrDefinitionCS aktCopy = (InvariantOrDefinitionCS) myCopier.copy(akt);
			ClassifierContextDeclarationCS myccd = (ClassifierContextDeclarationCS) myCopier.copy(myClassifierContextDeclarationCS);
			myccd.getInvariantsAndDefinitions().add(akt);
//			System.out.println("added elements to ClassifierContextDeclarationCS"+myccd);
//			System.out.println("    "+myccd.getInvariantsAndDefinitions().get(0));
			myPackage.getContextDeclarations().add(myccd);
//			System.out.println("added ClassifierContextDeclarationCS to package - it now contains "+myPackage.getContextDeclarations().size()+" context declarations.");
			splitCount++;		
//			System.out.println("invlistsize: "+invList.size());
		}		
		splitCount--;
		myPackage.getContextDeclarations().remove(selected);
		return Status.OK_STATUS;
	}
	

	
	
	


	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {
		// TODO Auto-generated method stub
		return null;
	}
}
