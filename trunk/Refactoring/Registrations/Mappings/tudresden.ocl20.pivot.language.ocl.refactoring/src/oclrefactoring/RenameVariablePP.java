/**
 * 
 */
package oclrefactoring;

import tudresden.ocl20.pivot.language.ocl.VariableDeclarationCS;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

import tudresden.ocl20.pivot.language.ocl.BodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.DefinitionExpCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.Property;
/**
 * @author Michael Muck
 *
 */
public class RenameVariablePP implements IRefactoringPostProcessor {
	
	
	String origName;
	String newName;
	VariableDeclarationCS variableDeclaration;

	public RenameVariablePP() {
		
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {
		// TODO Auto-generated method stub
		System.out.println("--------- old postprocessor activated ------------");
		return null;
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			EObject refactoredModel, ResourceSet resourceSet,
			ChangeDescription change, RefactoringSpecification refSpec,
			List<IModelRefactoringWizardPage> customWizardPages,
			boolean isFakeRun) {
		
		System.out.println("---------------------postprocessor activated!--------------------");
		
		//extract selection, old name and new name

		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		List<EObject> mappedElements;
		for (Role role : keySet) {
			if (role.getName().equals("Selection")) {
				mappedElements = roleRuntimeInstanceMap.get(role);
				if (mappedElements != null && mappedElements.size() > 0
						&& (mappedElements.get(0) instanceof VariableDeclarationCS)) {
					variableDeclaration = (VariableDeclarationCS) mappedElements.get(0);
				}
			}
			else if (role.getName().equals("Nameable")) {
				mappedElements = roleRuntimeInstanceMap.get(role);
				if (mappedElements != null && mappedElements.size() >0 && (mappedElements.get(0)) instanceof SimpleNameCS) {
					newName = ((SimpleNameCS) mappedElements.get(0)).getSimpleName();
					
				}
			}
		}
		if (variableDeclaration == null) {
			System.err.println("No variable declaration could be found by postprocessor. Refactoring aborted.");
			return Status.OK_STATUS;
		}
		origName = variableDeclaration.getVariableName().getSimpleName();
		System.out.println("orig name: "+ origName);
		System.out.println("new name: "+ newName);
		System.out.println("var dec: "+ variableDeclaration);
		
		return Status.OK_STATUS;
	}


	
	
}
