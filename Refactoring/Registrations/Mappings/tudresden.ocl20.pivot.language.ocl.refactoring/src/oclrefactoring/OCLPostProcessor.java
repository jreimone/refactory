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
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;

import tudresden.ocl20.pivot.language.ocl.LetExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
import tudresden.ocl20.pivot.language.ocl.VariableDeclarationWithInitCS;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;

public class OCLPostProcessor implements IRefactoringPostProcessor {

	private List<EObject> namedElements;
	private SimpleNameCS simpleName;
	private String originalName;

	public OCLPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		determineOriginalName(change);
		Set<Role> keySet = roleRuntimeInstanceMap.keySet();
		for (Role role : keySet) {
			if(role.getName().equals("Nameable")){
				namedElements = roleRuntimeInstanceMap.get(role);
				if(namedElements != null && namedElements.size() == 1 && (namedElements.get(0) instanceof SimpleNameCS)){
					simpleName = (SimpleNameCS) namedElements.get(0);
					performSpecificTransformation(simpleName);
				}
			}
		}
		return Status.OK_STATUS;
	}

	private void determineOriginalName(ChangeDescription change) {
		EMap<EObject,EList<FeatureChange>> objectChanges = change.getObjectChanges();
		Set<EObject> keySet = objectChanges.keySet();
		for (EObject eObject : keySet) {
			EList<FeatureChange> eList = objectChanges.get(eObject);
			for (FeatureChange featureChange : eList) {
				EList<ListChange> listChanges = featureChange.getListChanges();
				for (ListChange listChange : listChanges) {

				}
			}
		}
	}

	private void performSpecificTransformation(SimpleNameCS simpleName2) {
		VariableDeclarationWithInitCS var = (VariableDeclarationWithInitCS) simpleName2.eContainer();
		LetExpCS let = (LetExpCS) var.eContainer();
		OclExpressionCS expression = let.getOclExpression();
		TreeIterator<EObject> eAllContents = expression.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eObject = (EObject) eAllContents.next();
			if(eObject instanceof NamedLiteralExpCS){
				NamedLiteralExpCS literal = (NamedLiteralExpCS) eObject;
				NamedElement namedElement = literal.getNamedElement();
				
			}
		}
	}

}
