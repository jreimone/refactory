/**
 * 
 */
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
import tudresden.ocl20.pivot.language.ocl.DefinitionExpCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.Property;

/**
 * @author Michael Muck
 *
 */
public class RemoveRedundantBrackets implements IRefactoringPostProcessor {
	
	private BracketExpCS selected;
	private int removedBrackets = 0;
	
	public RemoveRedundantBrackets() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		System.err.println("postprocessor activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			if (role.getName().equals("Selection")) {
				if (roleplayers.size()==1 && roleplayers.get(0) instanceof BracketExpCS) {
					selected = (BracketExpCS) roleplayers.get(0);
					System.out.println("found selected element as: "+selected);
				}
			}
		}
		removedBrackets = 0;
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
		
		//check, if the child from BracketExp is a BracketExp too, if so, it is redundant and can be removed
		//this is done, until the first non-Bracket-exp is found
		Boolean childIsBracket = true;
		BracketExpCS parent = selected;
		BracketExpCS child;
		
		while (childIsBracket) {
			if (parent.getOclExpression() instanceof BracketExpCS) {
				child = (BracketExpCS) parent.getOclExpression();
				parent.setOclExpression(child.getOclExpression());
				removedBrackets++;
			} else {
				childIsBracket = false;
			}
		}
		
		//now checking, if the parent of the BracketExp is a BracketExp too, if so, it can be removed
		//this is done, until the first non-BracketExp is found
		
		Boolean parentIsBracket = true;
		BracketExpCS child2 = selected;
		BracketExpCS parent2;
		
		while(parentIsBracket) {
			if (child2.eContainer() instanceof BracketExpCS) {
				parent2 = (BracketExpCS) child2.eContainer();
				parent2.setOclExpression(child2.getOclExpression());
				child2 = parent2;
				removedBrackets++;
				
			} else {
				parentIsBracket = false;
			}
		}
		
	}
	
	

}
