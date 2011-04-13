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
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

import tudresden.ocl20.pivot.datatypes.impl.DatatypesFactoryImpl;
import tudresden.ocl20.pivot.language.ocl.ClassifierContextDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.ContextDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.DefinitionExpCS;
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
public class MergeConstraintsPP implements IRefactoringPostProcessor {

	
	OclFactoryImpl myOclFactory;
	DatatypesFactoryImpl myDataTypesFactory;
	PivotModelFactoryImpl myPivotModelFactory;
	private ClassifierContextDeclarationCS selection1;
	private ClassifierContextDeclarationCS selection2;
	PackageDeclarationCS myPackage;
	

	public MergeConstraintsPP() {

		myOclFactory = new OclFactoryImpl();
		myDataTypesFactory = new DatatypesFactoryImpl();
		myPivotModelFactory = new PivotModelFactoryImpl();
	}
	
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change,
			RefactoringSpecification refSpec) {

		System.err.println("Merge Constraints postprocessor activated!");
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
		//collecting all invariants from selection 1
		EList<InvariantOrDefinitionCS> selection1InvariantOrDefinitionList = selection1.getInvariantsAndDefinitions();
		EList<InvariantExpCS> selection1InvariantList = new BasicEList<InvariantExpCS>();
		Iterator<InvariantOrDefinitionCS> selection1InvariantOrDefinitionListIterator = selection1InvariantOrDefinitionList.iterator();
		while (selection1InvariantOrDefinitionListIterator.hasNext()) {
			InvariantOrDefinitionCS akt = selection1InvariantOrDefinitionListIterator.next();
			if (akt instanceof InvariantExpCS) selection1InvariantList.add((InvariantExpCS) akt);
		}
		
		//since only invariants can be merged, if the selected element contains definitions, the refactoring wont work
		if (selection1InvariantList.size() != selection1InvariantOrDefinitionList.size()) {
			System.err.println("  The selections contains DefinitionExpressions, but only InvariantExpressions can be merged!");
			return Status.CANCEL_STATUS;
		}
		
		//collecting all invariants from selection 2
		EList<InvariantOrDefinitionCS> selection2InvariantOrDefinitionList = selection2.getInvariantsAndDefinitions();
		EList<InvariantExpCS> selection2InvariantList = new BasicEList<InvariantExpCS>();
		Iterator<InvariantOrDefinitionCS> selection2InvariantOrDefinitionListIterator = selection2InvariantOrDefinitionList.iterator();
		while (selection2InvariantOrDefinitionListIterator.hasNext()) {
			InvariantOrDefinitionCS akt = selection2InvariantOrDefinitionListIterator.next();
			if (akt instanceof InvariantExpCS) selection2InvariantList.add((InvariantExpCS) akt);
		}

		//since only invariants can be merged, if the selected element contains definitions, the refactoring wont work
		if (selection2InvariantList.size() != selection2InvariantOrDefinitionList.size()) {
			System.err.println("  The selections contains DefinitionExpressions, but only InvariantExpressions can be merged!");
			return Status.CANCEL_STATUS;
		}
		
		//now merging the two invariant lists
		selection1.getInvariantsAndDefinitions().addAll(selection2InvariantList);
		
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
