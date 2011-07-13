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
public class SplitExpressionAtomicPP implements IRefactoringPostProcessor {

	
	OclFactoryImpl myOclFactory;
	DatatypesFactoryImpl myDataTypesFactory;
	PivotModelFactoryImpl myPivotModelFactory;
	private ClassifierContextDeclarationCS selected;
	private int splitCount;
	private boolean splitAtomic;
	PackageDeclarationCS myPackage;
	

	public SplitExpressionAtomicPP() {

		myOclFactory = new OclFactoryImpl();
		myDataTypesFactory = new DatatypesFactoryImpl();
		myPivotModelFactory = new PivotModelFactoryImpl();
		splitCount = 0;
		splitAtomic = true;
	}
	
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change,
			RefactoringSpecification refSpec) {

		System.err.println("Split Constraint postprocessor activated!");
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
		
		if (selected.eContainer()instanceof PackageDeclarationCS) {
			myPackage = (PackageDeclarationCS) selected.eContainer();
			System.out.println("found package declaration as: "+myPackage);
		} else {
			System.err.println("package declaration not found - refactoring cancelled!");
			return Status.CANCEL_STATUS;
		}
		
		EList<InvariantOrDefinitionCS> invList = selected.getInvariantsAndDefinitions();
		Iterator<InvariantOrDefinitionCS> invListIt = invList.iterator();
		EList<InvariantExpCS> myNewInvList = new BasicEList<InvariantExpCS>();
		while(invListIt.hasNext()) {
			InvariantOrDefinitionCS invListElement = invListIt.next();
			InvariantExpCS myInv = null;
			LogicalAndOperationCallExpCS myAnd = null;
			if (invListElement instanceof InvariantExpCS) {
				myInv = (InvariantExpCS) invListElement;
				if (myInv.getOclExpression() instanceof LogicalAndOperationCallExpCS) {
					myAnd = (LogicalAndOperationCallExpCS) myInv.getOclExpression();
					myInv.setOclExpression(myAnd.getSource());
					InvariantExpCS myNewInv = myOclFactory.createInvariantExpCS();
					myNewInv.setOclExpression(myAnd.getTarget());
					myNewInvList.add(myNewInv);
					splitCount++;
				}
			}
		}
		Iterator<InvariantExpCS> myNewInvListIterator = myNewInvList.iterator();
		if (splitAtomic) {
			while (myNewInvListIterator.hasNext()) {
				InvariantExpCS aktexp = myNewInvListIterator.next();
				ClassifierContextDeclarationCS myClassifierContextDeclarationCS = myOclFactory.createClassifierContextDeclarationCS();
				myClassifierContextDeclarationCS.getInvariantsAndDefinitions().add(aktexp);
				EcoreUtil.copy(selected.getTypeName());
				myClassifierContextDeclarationCS.setTypeName(EcoreUtil.copy(selected.getTypeName()));
				myPackage.getContextDeclarations().add(myClassifierContextDeclarationCS);
			}
		} else {
			while (myNewInvListIterator.hasNext()) {
				InvariantExpCS aktexp = myNewInvListIterator.next();
				selected.getInvariantsAndDefinitions().add(aktexp);
			}
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