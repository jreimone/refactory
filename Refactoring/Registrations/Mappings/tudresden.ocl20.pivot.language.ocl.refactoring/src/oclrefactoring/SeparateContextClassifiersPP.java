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
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

import tudresden.ocl20.pivot.datatypes.impl.DatatypesFactoryImpl;
import tudresden.ocl20.pivot.language.ocl.ClassifierContextDeclarationCS;
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
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun) {

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
			InvariantOrDefinitionCS aktCopy = (InvariantOrDefinitionCS) myCopier.copy(akt);
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
