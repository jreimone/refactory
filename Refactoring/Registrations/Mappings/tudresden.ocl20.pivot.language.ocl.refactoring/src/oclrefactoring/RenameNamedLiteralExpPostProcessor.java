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
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

import tudresden.ocl20.pivot.language.ocl.BodyDeclarationCS;
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
public class RenameNamedLiteralExpPostProcessor extends AbstractRefactoringPostProcessor {

	private NamedLiteralExpCS selected;
	private Property newNameHolder;
	private String newName;
	private String originalName;
	
	
	public RenameNamedLiteralExpPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun) {
		System.err.println("postprocessor activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			List<EObject> roleplayers = roleRuntimeInstanceMap.get(role);
			if (role.getName().equals("Selection")) {
				if (roleplayers.size()==1 && roleplayers.get(0) instanceof NamedLiteralExpCS) {
					selected = (NamedLiteralExpCS) roleplayers.get(0);
					System.out.println("found selected element as: "+selected);
					originalName = selected.getNamedElement().getName();
					System.out.println("original name is: "+ originalName);
				}
			}
			else if(role.getName().equals("Nameable")) {
				if (roleplayers.size() == 1 && roleplayers.get(0) instanceof Property) {
					newNameHolder = (Property) roleplayers.get(0);
					newName = newNameHolder.getName();
					System.out.println("new name is: "+ newName);
				}
			}
		}
		
		performSpecificTransformation();
		
		return Status.OK_STATUS;
	}

	private void performSpecificTransformation() {
		EObject constraintRoot = selected.eContainer();
		while (	!(constraintRoot instanceof InvariantExpCS) && 
				!(constraintRoot instanceof DefinitionExpCS) && 
				!(constraintRoot instanceof BodyDeclarationCS)
		) {
			
			constraintRoot = constraintRoot.eContainer();
			
		}
		
		System.err.println("constraint root determined as: "+ constraintRoot.eClass());
		//now the actual renaming
		TreeIterator<EObject> eAllContents = constraintRoot.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eObject = (EObject) eAllContents.next();
			if (eObject instanceof NamedLiteralExpCS) {
				NamedLiteralExpCS literal = (NamedLiteralExpCS) eObject;
				NamedElement namedElement = literal.getNamedElement();
				if(namedElement.getName().equals(originalName)) {
					namedElement.setName(newName);
				}
			}
			else if (eObject instanceof SimpleNameCS) {
				SimpleNameCS simpleName = (SimpleNameCS) eObject;
				if(simpleName.getSimpleName().equals(originalName)) {
					simpleName.setSimpleName(newName);
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
