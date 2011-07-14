package oclrefactoring;

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

public class OCLPostProcessor extends AbstractRefactoringPostProcessor {

	private List<EObject> namedElements;
	private SimpleNameCS simpleName;
	private String originalName;

	public OCLPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun) {
		System.err.println("postprocessor activated!");
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			if (role.getName().equals("Nameable")) {
				namedElements = roleRuntimeInstanceMap.get(role);
				if (namedElements != null && namedElements.size() > 0
						&& (namedElements.get(0) instanceof SimpleNameCS)) {
					simpleName = (SimpleNameCS) namedElements.get(0);
					if (determineOriginalName(change)) {
						performSpecificTransformation(simpleName);
					}
				}
			}
		}
		return Status.OK_STATUS;
	}

	private boolean determineOriginalName(ChangeDescription change) {
		EMap<EObject, EList<FeatureChange>> objectChanges = change.getObjectChanges();
		EList<FeatureChange> eList = objectChanges.get(simpleName);
		for (FeatureChange featureChange : eList) {
			Object value = featureChange.getValue();
			if (value instanceof String) {
				originalName = (String) value;
				System.err.println("original name determined as: "+originalName);
				return true;
			}
		}
		return false;
	}
	
	private void performSpecificTransformation(SimpleNameCS simpleName2) {
		EObject tempParent = simpleName2.eContainer();
		System.err.println("tempparent: "+ tempParent.eClass());
		while (	!(tempParent instanceof InvariantExpCS) && 
				!(tempParent instanceof DefinitionExpCS) && 
				!(tempParent instanceof BodyDeclarationCS)
		) {
			
			tempParent = tempParent.eContainer();
			System.err.println("tempparent: "+ tempParent.eClass());
		}
		//now the actual renaming
		TreeIterator<EObject> eAllContents = tempParent.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eObject = (EObject) eAllContents.next();
			if (eObject instanceof NamedLiteralExpCS) {
				NamedLiteralExpCS literal = (NamedLiteralExpCS) eObject;
				NamedElement namedElement = literal.getNamedElement();
				if(namedElement.getName().equals(originalName)) {
					namedElement.setName(simpleName2.getSimpleName());
				}
			}
			else if (eObject instanceof SimpleNameCS) {
				SimpleNameCS simpleNameEO = (SimpleNameCS) eObject;
				if(simpleNameEO.getSimpleName().equals(originalName)) {
					simpleNameEO.setSimpleName(simpleName2.getSimpleName());
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
	

//	private void performSpecificTransformation(SimpleNameCS simpleName2) {
//		//the following is just for renaming variable-definitions and their uses, so if a simpleNameCS outside a variable-definition is renamed,
//		//the following steps should not be executed!
//		if (simpleName2.eContainer() instanceof VariableDeclarationWithInitCS) {
//			VariableDeclarationWithInitCS var = (VariableDeclarationWithInitCS) simpleName2.eContainer();
//			//now, this part refers to variables inside let-expressions:
//			if(var.eContainer() instanceof LetExpCS) {
//				LetExpCS let = (LetExpCS) var.eContainer();
//				OclExpressionCS expression = let.getOclExpression();
//				TreeIterator<EObject> eAllContents = expression.eAllContents();
//				while (eAllContents.hasNext()) {
//					EObject eObject = (EObject) eAllContents.next();
//					if (eObject instanceof NamedLiteralExpCS) {
//						NamedLiteralExpCS literal = (NamedLiteralExpCS) eObject;
//						NamedElement namedElement = literal.getNamedElement();
//						if(namedElement.getName().equals(originalName)){
//							namedElement.setName(simpleName2.getSimpleName());
//						}
//					}
//				}
//			}
//		}
//	}

}
