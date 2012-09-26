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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

import tudresden.ocl20.pivot.datatypes.impl.DatatypesFactoryImpl;
import tudresden.ocl20.pivot.language.ocl.ClassifierContextDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.PackageDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.impl.OclFactoryImpl;
import tudresden.ocl20.pivot.pivotmodel.impl.PivotModelFactoryImpl;

/**
 * @author Michael Muck
 *
 */
public class MergeAtomicExpressionsPP extends AbstractRefactoringPostProcessor {

	
	OclFactoryImpl myOclFactory;
	DatatypesFactoryImpl myDataTypesFactory;
	PivotModelFactoryImpl myPivotModelFactory;
	private ClassifierContextDeclarationCS selection1;
	private ClassifierContextDeclarationCS selection2;
	PackageDeclarationCS myPackage;
	boolean debug = true;
	

	public MergeAtomicExpressionsPP() {

		myOclFactory = new OclFactoryImpl();
		myDataTypesFactory = new DatatypesFactoryImpl();
		myPivotModelFactory = new PivotModelFactoryImpl();
	}
	
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {

		System.err.println("Merge Constraints postprocessor activated!");
		
		if (debug && isFakeRun) return Status.OK_STATUS;
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			if (role.getName().equals("Selection")) {
				System.out.println(roleplayers.size()+" roleplayers found for role "+role.getName()+":");
				Iterator<EObject> roleplayersIt = roleplayers.iterator();
				while (roleplayersIt.hasNext()) {
					System.out.println("  "+roleplayersIt.next());
				}
				if (roleplayers.size()==2 && roleplayers.get(0) instanceof ClassifierContextDeclarationCS && roleplayers.get(1)instanceof ClassifierContextDeclarationCS) {
					selection1 = (ClassifierContextDeclarationCS) roleplayers.get(0);
					selection2 = (ClassifierContextDeclarationCS) roleplayers.get(1);
					System.out.println("found selected element 1 as: "+selection1);
					System.out.println("found selected element 2 as: "+selection2);
				}
			}
		}
		if (selection1 == null || selection2 == null) {
			System.err.println("Exactly two ClassifierContextDeclarations have to be selected. Refactoring aborted!");
			return Status.CANCEL_STATUS;
		}
		IStatus refactoringStatus = performSpecificTransformation();
		
		
		return refactoringStatus;
	}
	
	
	private IStatus performSpecificTransformation() {
		
		//check if context matches, else abort
		if (!EcoreUtil.equals(selection1.getTypeName(), selection2.getTypeName())) {
			System.err.println("Only constraints with matching context declarations can be merged!");
			return Status.CANCEL_STATUS;
		}
		//if one of the input elements does not contain invariant or definitions there is nothing to merge
		if (selection1.getInvariantsAndDefinitions().isEmpty() || selection2.getInvariantsAndDefinitions().isEmpty()) {
			System.err.println("  One of the selected input elements does not contain any invariants or definitions. Refactoring aborted.");
			return Status.CANCEL_STATUS;
		}
		
		//now merging the two invariant lists
		selection1.getInvariantsAndDefinitions().addAll(selection2.getInvariantsAndDefinitions());
		
		//remove selection2
		PostProcessingHelper myPPH = new PostProcessingHelper();
		myPPH.removeObjectFromParent(selection2);
		
		
		return Status.OK_STATUS;
	}
	

	
	
	


	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {
		// TODO Auto-generated method stub
		return null;
	}
}
