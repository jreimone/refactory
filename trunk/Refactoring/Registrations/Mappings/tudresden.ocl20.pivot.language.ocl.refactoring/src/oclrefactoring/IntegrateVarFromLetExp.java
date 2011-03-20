package oclrefactoring;

import java.util.Iterator;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

import tudresden.ocl20.pivot.datatypes.impl.DatatypesFactoryImpl;
import tudresden.ocl20.pivot.language.ocl.BracketExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;
import tudresden.ocl20.pivot.language.ocl.impl.OclFactoryImpl;
import tudresden.ocl20.pivot.pivotmodel.impl.PivotModelFactoryImpl;

public class IntegrateVarFromLetExp implements IRefactoringPostProcessor {
	
	private EObject constraintRoot;
	
	
	private VariableDeclarationWithInitCS selection;
	private LetExpCS myLetExp;
	String VariableName;
	
	
	OclFactoryImpl myOclFactory;
	DatatypesFactoryImpl myDataTypesFactory;
	PivotModelFactoryImpl myPivotModelFactory;
	
	
	public IntegrateVarFromLetExp() {
		myOclFactory = new OclFactoryImpl();
		myDataTypesFactory = new DatatypesFactoryImpl();
		myPivotModelFactory = new PivotModelFactoryImpl();
	}
	
	
	
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		System.err.println("postprocessor activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
//			System.out.println("role found with name: "+role.getName());
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			
			if (role.getName().equals("Selection")) {
				if (roleplayers.size() == 1) selection = (VariableDeclarationWithInitCS) roleplayers.get(0);
//				System.out.println("   extract identified as: "+selection.toString());
			}
			
		}
		
		performSpecificTransformation();
		
		return Status.OK_STATUS;
	}
	
	private IStatus performSpecificTransformation() {
		
		if (!(selection.eContainer() instanceof LetExpCS)) {
//			System.err.println("Integrate Variable From LetExpression cannot be called from outside a LetExp!");
			return Status.CANCEL_STATUS;
		}
		
		myLetExp = (LetExpCS) selection.eContainer();
		VariableName = selection.getVariableName().getSimpleName();
		OclExpressionCS declaration = selection.getInitialization();
		
		
		//at first, search and replace all instances of the variable with the actual declaration
		// TODO bracket expression
		TreeIterator<EObject> myIt = myLetExp.eAllContents();
		while (myIt.hasNext()) {
			EObject akt = myIt.next();
			if (akt instanceof NamedLiteralExpCS) {
				NamedLiteralExpCS aktLit = (NamedLiteralExpCS) akt;
				if (aktLit.getNamedElement().getName().equals(VariableName)) {
					//here we are at a place, where the variable should be integrated
					EObject container = aktLit.eContainer();
					EStructuralFeature containerRef = aktLit.eContainingFeature();
					
					//as a precaution for avoiding changes in meaning through weaker/stronger operator binding in the 
					//target expression, the declaration will be set in brackets before it is integrated
					BracketExpCS myBracket = myOclFactory.createBracketExpCS();
					
					ReferenceCopier copier = new ReferenceCopier();
					EList<EObject> copiedList = new BasicEList<EObject>();
					EObject myCopiedDeclaration = copier.copy(declaration);
					copiedList.add(myCopiedDeclaration);
					TreeIterator<EObject> copyListIterator = declaration.eAllContents();
					while (copyListIterator.hasNext()) {
						copiedList.add(copier.copy(copyListIterator.next()));
					}
					copier.copyReferences();
					
					
					Iterator<EObject> myCopyIt = copiedList.iterator();
					while (myCopyIt.hasNext()) {
						EObject aktcopy = myCopyIt.next();
						if (EcoreUtil.equals(aktcopy, declaration)) {
							myCopiedDeclaration = (OclExpressionCS) aktcopy;
						}
					}
					if (myCopiedDeclaration instanceof BracketExpCS) {
						myBracket = (BracketExpCS) myCopiedDeclaration;
					} else { 
						myBracket.setOclExpression((OclExpressionCS) myCopiedDeclaration);
					}
					container.eSet(containerRef, myBracket);
					
				}
			}
		}
		
		//now delete the declaration from the if expression
		
		myLetExp.getVariableDeclarations().remove(selection);
		
		//if there are no more variable declarations left, the let expression will be empty and has to be removed
		if (myLetExp.getVariableDeclarations().size() == 0) {
//			System.out.println("removing empty let expression");
			constraintRoot = myLetExp.eContainer();
			EStructuralFeature parentLink = myLetExp.eContainingFeature();
			constraintRoot.eSet(parentLink, myLetExp.getOclExpression());
		}
		
				
		return Status.OK_STATUS;		
	}

}
