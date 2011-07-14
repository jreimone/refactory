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
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

import tudresden.ocl20.pivot.language.ocl.ContextDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.DefinitionExpPropertyCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.PrePostOrBodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.TupleLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.TupleTypeCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitListCS;

/**
 * @author Michael Muck
 *
 */
public class RemoveAllEmptyVariableDeclarationsPostProcessor extends AbstractRefactoringPostProcessor {
	
	int varsFound;
	private ContextDeclarationCS selected;
	private EList<VariableDeclarationWithInitCS> vars;
	private String output;
	boolean isEmpty;
	private PostProcessingHelper myPostProcessingHelper;
	
	
	
	public RemoveAllEmptyVariableDeclarationsPostProcessor() {
		varsFound = 0;
		myPostProcessingHelper = new PostProcessingHelper();
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun) {
		System.out.println("Postprocessor for 'Remove All Empty Variable Definition' refactoring activated!");
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
		
		if (selected == null) {
			return Status.CANCEL_STATUS;
		}
		getVars();
		if (varsFound > 0){
			performSpecificTransformation();
		}
		
		if (isEmpty) {
			output = new String("empty variable definitions removed");
		} else {
			output = new String("no empty variable definitions found");
		}
		
		System.out.println(output);
		
		return Status.OK_STATUS;
	}
	
	private void getVars() {
		
		vars = new BasicEList<VariableDeclarationWithInitCS>();
		varsFound = 0;

		TreeIterator<EObject> allContentsIt = selected.eAllContents();
		while (allContentsIt.hasNext()){
			EObject akt = allContentsIt.next();
			if (akt instanceof VariableDeclarationWithInitCS) {
				vars.add((VariableDeclarationWithInitCS) akt);
				varsFound++;
			} else if (akt instanceof VariableDeclarationWithInitListCS) {
				vars.addAll(((VariableDeclarationWithInitListCS)akt).getVariableDeclarations());
				varsFound = varsFound + ((VariableDeclarationWithInitListCS)akt).getVariableDeclarations().size();
			}
		}
		
		
	}

	private void performSpecificTransformation() {
		
		EObject root = myPostProcessingHelper.getConstraintRoot(vars.get(0));
		Iterator<VariableDeclarationWithInitCS> varIt = vars.iterator();
		while (varIt.hasNext()) {
			VariableDeclarationWithInitCS akt = varIt.next();
			if (akt.getInitialization() == null) {
					EObject parent = akt.eContainer();
					myPostProcessingHelper.removeObjectFromParent(akt);
				//now, if the element from which we have removed the selection is empty, it can be removed too
				if (parent instanceof LetExpCS) {
					LetExpCS myParent = (LetExpCS) parent;
					
					//	myParent.getVariableDeclarations().remove(selected);
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
				//now there could be some uses of the removed variable uses in the constraint, 
				//that need to be removed as well
				Iterator<EObject> myAllContentsIt = root.eAllContents();
//				System.out.println("removing references to "+akt);
				while (myAllContentsIt.hasNext()) {
					EObject aktObj = myAllContentsIt.next();
					if (aktObj instanceof NamedLiteralExpCS && 
							((NamedLiteralExpCS)aktObj).getNamedElement().getName().equals(akt.getVariableName())) {
						
						aktObj.eContainer().eUnset(akt.eContainingFeature());
					}
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
