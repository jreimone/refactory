package oclrefactoring;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

import tudresden.ocl20.pivot.language.ocl.BodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.BracketExpCS;
import tudresden.ocl20.pivot.language.ocl.ContextDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.DefinitionExpCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.Property;

/**
 * @author Michael Muck
 *
 */
public class RemoveAllRedundantBrackets implements IRefactoringPostProcessor {
	
	private ContextDeclarationCS selected;
	private int removedBrackets = 0;
	
	public RemoveAllRedundantBrackets() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		System.err.println("RemoveAllRedundantBrackets postprocessor activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			if (role.getName().equals("Selection")) {
				if (roleplayers.size()==1 && roleplayers.get(0) instanceof ContextDeclarationCS) {
					selected = (ContextDeclarationCS) roleplayers.get(0);
//					System.out.println("found selected element as: "+selected);
				}
			}
		}
		removedBrackets = 0;
		if (selected == null) {
			System.err.println("No ContextDeclarationCS selected. Refactoring aborted!");
			return Status.CANCEL_STATUS;
		}
		performSpecificTransformation();
		
		String out;
		if (removedBrackets == 0) {
			out = new String("No redundant brackets found!");
		} else if (removedBrackets == 1){
			out= new String(removedBrackets+" Bracket removed.");
		} else {
			out= new String(removedBrackets+" Brackets removed.");
		}
		System.out.println(out);
		
		return Status.OK_STATUS;
	}

	private void performSpecificTransformation() {
		
		EObject constraintRoot = selected;
		Boolean cleanPass = false;
		
		while (!cleanPass) {
			Boolean removed = false;
			TreeIterator<EObject> eAllContents = constraintRoot.eAllContents();
			while (eAllContents.hasNext() && !removed) {
				EObject eObject = (EObject) eAllContents.next();
				if (eObject instanceof BracketExpCS) {
					//if any redundant brackets have been removed, eAllContents will be invalid, because some elements have been removed
					//so eAllContents has to be recomputed and checked over again, thus with removed==true the iteration will break here
					//and the while-loop will be restarted for a clean re-run
					removed = removeBrackets((BracketExpCS) eObject);
				}		
			}
			//if this code is reached, all Objects have been checked for redundant brackets
			//and if removed is false then none have been found.
			//we can stop searching now
			if (removed == false) cleanPass = true;
		}
	
		
		
		
	}
	
	private boolean removeBrackets(BracketExpCS br) {
		//check, if the child from BracketExp is a BracketExp too, if so, it is redundant and can be removed
		//this is done, until the first non-Bracket-exp is found
		Boolean removedSomeBracket = false;
		Boolean childIsBracket = true;
		BracketExpCS parent = br;
		BracketExpCS child;
		
		while (childIsBracket) {
			if (parent.getOclExpression() instanceof BracketExpCS) {
				child = (BracketExpCS) parent.getOclExpression();
				parent.setOclExpression(child.getOclExpression());
				removedBrackets++;
				removedSomeBracket = true;
			} else {
				childIsBracket = false;
			}
		}
		
		//now checking, if the parent of the BracketExp is a BracketExp too, if so, it can be removed
		//this is done, until the first non-BracketExp is found
		
		Boolean parentIsBracket = true;
		BracketExpCS child2 = br;
		BracketExpCS parent2;
		
		while(parentIsBracket) {
			if (child2.eContainer() instanceof BracketExpCS) {
				parent2 = (BracketExpCS) child2.eContainer();
				parent2.setOclExpression(child2.getOclExpression());
				child2 = parent2;
				removedBrackets++;
				removedSomeBracket = true;
				
			} else {
				parentIsBracket = false;
			}
		}
		return removedSomeBracket;
	}

}
