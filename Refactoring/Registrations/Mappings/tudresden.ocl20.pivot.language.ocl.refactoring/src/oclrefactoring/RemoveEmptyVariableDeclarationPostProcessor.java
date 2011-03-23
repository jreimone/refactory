/**
 * 
 */
package oclrefactoring;

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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

import tudresden.ocl20.pivot.language.ocl.BodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.BracketExpCS;
import tudresden.ocl20.pivot.language.ocl.DefinitionExpCS;
import tudresden.ocl20.pivot.language.ocl.DefinitionExpPropertyCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.PrePostOrBodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
import tudresden.ocl20.pivot.language.ocl.TupleLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.TupleTypeCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitListCS;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.Property;

/**
 * @author Michael Muck
 *
 */
public class RemoveEmptyVariableDeclarationPostProcessor implements IRefactoringPostProcessor {
	
	private VariableDeclarationCS selected;
	String output;
	boolean isEmpty;
	
	
	
	public RemoveEmptyVariableDeclarationPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec) {
		System.out.println("Postprocessor for 'Remove Empty Variable Definition' refactoring activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			if (role.getName().equals("Selection")) {
				if (roleplayers.size()==1 && roleplayers.get(0) instanceof VariableDeclarationCS) {
					selected = (VariableDeclarationCS) roleplayers.get(0);
					System.out.println("found selected element as: "+selected);
				}
			}
		}
		
		if (selected == null) {
			System.err.println("This refactoring only works on VariableDeclarationCS expressions. \nRefactoring aborted for no VariableDeclarationCS was selected as input!");
			return Status.CANCEL_STATUS;
		}
		
		performSpecificTransformation();
		
		if (isEmpty) {
			output = new String("variable definition removed");
		} else {
			output = new String("variable definition is not empty and therefore has not been removed");
		}
		
		System.out.println(output);
		
		return Status.OK_STATUS;
	}

	private void performSpecificTransformation() {
		
		isEmpty = false;
		
		//check, what type of variableDeclaration we have
		if (selected instanceof VariableDeclarationWithInitCS) {
			if ((((VariableDeclarationWithInitCS)selected).getInitialization())==null) {
				isEmpty = true;
			}
		} else if (selected instanceof VariableDeclarationWithInitListCS) {
			VariableDeclarationWithInitListCS myvar = (VariableDeclarationWithInitListCS) selected;
			if (myvar.getVariableDeclarations() == null || myvar.getVariableDeclarations().isEmpty()) {
				isEmpty = true;
			}
		}
		else {
			isEmpty = true;
		}
		
		//here comes the actual removal
		if (isEmpty) {
			EObject parent = selected.eContainer();
			if (selected.eContainmentFeature() instanceof EList) {
				((EList)selected.eContainingFeature()).remove(selected);
			} else {
				parent.eUnset(selected.eContainingFeature());
			}
			
			
			//now, if the element from which we have removed the selection is empty, it can be removed too
			if (parent instanceof LetExpCS) {
				LetExpCS myParent = (LetExpCS) parent;
				
				//myParent.getVariableDeclarations().remove(selected);
				if (((LetExpCS) parent).getVariableDeclarations().isEmpty()) {
					EObject myParentContainer = parent.eContainer();
					if (myParentContainer instanceof InvariantExpCS) {
						((InvariantExpCS)myParentContainer).setOclExpression(myParent.getOclExpression());
					} else if (myParentContainer instanceof PrePostOrBodyDeclarationCS) {
						((PrePostOrBodyDeclarationCS)myParentContainer).setOclExpression(myParent.getOclExpression());
					}
					
				}
			} else if (parent instanceof TupleTypeCS) {
				if (((TupleTypeCS)parent).getVariableDeclarationList().getVariableDeclarations().isEmpty()) {
					parent.eContainer().eUnset(parent.eContainingFeature());
				}
			}
			else if (parent instanceof TupleLiteralExpCS) {
				if (((TupleLiteralExpCS)parent).getVariableDeclarations().getVariableDeclarations().isEmpty()) {
					parent.eContainer().eUnset(parent.eContainingFeature());
				}
			} else if (parent instanceof DefinitionExpPropertyCS) {
				if (((DefinitionExpPropertyCS)parent).getVariableDeclaration() == null) {
					parent.eContainer().eUnset(parent.eContainingFeature());
				}
			}
			
			
		}

		
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
