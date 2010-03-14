/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.FromClause;
import org.emftext.language.refactoring.refactoring_specification.FromOperator;
import org.emftext.language.refactoring.refactoring_specification.FromReference;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.UPTREE;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.util.ModelUtil;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
public class CREATEInterpreter {

	private Mapping mapping;
	private List<? extends EObject> selection;
	private RefactoringInterpreterContext context;
	
	public CREATEInterpreter(Mapping mapping){
		this.mapping = mapping;
	}
	
	public Boolean interpreteCREATE(CREATE object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.selection = selection;
		this.context = context;
		Role childRole = object.getSourceRoleReference().getRole();
		Variable sourceVar = object.getVarDeclaration();
		if(sourceVar != null){
			context.addEObjectForVariable(sourceVar);
		}
		TargetContext target = object.getTargetContext();
		if(target instanceof VariableReference){
			return handleCREATETargetVariable(context, childRole, target);
		}
		if(target instanceof RoleReference){
			return handleCREATETargetRole(childRole, (RoleReference) target, object.getFrom(), sourceVar);
		}
		return false;
	}
	
	private Boolean handleCREATETargetRole(Role childRole, RoleReference target, FromClause from, Variable variable) {
		if(from == null){
			EClass metaclass = mapping.getEClassForRole(childRole);
			EObject childObject = ModelUtil.create(metaclass);
			Role targetRole = target.getRole();
			if(targetRole.getModifier().contains(RoleModifier.INPUT)){
				if(selection.size() == 1){
					EObject targetObject = selection.get(0);
					ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(targetRole);
					RelationMapping relationMapping = concreteMapping.getRelationMappingForTargetRole(childRole);
					List<ReferenceMetaClassPair> referencePairs = null;
					if(relationMapping != null){
						referencePairs = relationMapping.getReferenceMetaClassPair();
					}
					return RefactoringUtil.createPath(targetObject, referencePairs, childObject);
				}
			} else {
				// TODO ask the user
			}
		} else {
			FromOperator operator = from.getOperator();
			List<? extends EObject> fromObjects = getFromReferenceObject(from);
			if(operator instanceof UPTREE){
				return handleFromOperatorUPTREE(childRole, target, fromObjects, variable);
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private boolean handleCREATETargetVariable(RefactoringInterpreterContext context, Role childRole, TargetContext target) {
		Variable targetVar = ((VariableReference) target).getVariable();
		EObject parentObject = context.getEObjectForVariable(targetVar);
		EClass childClass = mapping.getEClassForRole(childRole);
		EObject childObject = ModelUtil.create(childClass);
		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(targetVar.getCreateCommand().getSourceRoleReference().getRole());
		RelationMapping relationMapping = concreteMapping.getRelationMappingForTargetRole(childRole);
		if(relationMapping == null){
			// add directly to parent
			EClass parentClass = parentObject.eClass();
			EList<EReference> references = parentClass.getEAllReferences();
			for (EReference eReference : references) {
				if(eReference.isContainment() && eReference.getEContainingClass().equals(childClass)){
					return ((List<EObject>)parentObject.eGet(eReference)).add(childObject);
				}
			}
		} else {
			// add with path
//			EList<EReference> references = relationMapping.getReferences();
//			List<EReference> tempList = new LinkedList<EReference>();
//			for (EReference eReference : references) {
//				tempList.add(eReference);
//			}
			return RefactoringUtil.createPath(parentObject, relationMapping.getReferenceMetaClassPair(), childObject);
		}
		return false;
	}
	
	private List<? extends EObject> getFromReferenceObject(FromClause from){
		FromReference reference = from.getReference();
		if(reference instanceof ConstantsReference){
			Constants constant = ((ConstantsReference) reference).getReferencedConstant();
			switch (constant) {
			case INPUT:
				return selection;
			default:
				break;
			}
		}
		if(reference instanceof VariableReference){
			Variable variable = ((VariableReference) reference).getVariable();
			List<EObject> temp = new ArrayList<EObject>();
			temp.add(context.getEObjectForVariable(variable));
			return temp;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private Boolean handleFromOperatorUPTREE(Role childRole, RoleReference target, List<? extends EObject> fromObjects, Variable variable) {
		Role targetRole = target.getRole();
		List<?>[] rootPaths = new List<?>[fromObjects.size()];
		int i = 0;
		for (EObject eObject : fromObjects) {
			List<EObject> rootPath = ModelUtil.getPathToRoot(eObject);
			rootPaths[i] = rootPath;
			i++;
		}
		// build up uptree
		EObject targetObject = RoleUtil.getFirstCommonObjectWithRoleFromPaths(targetRole, mapping, (List<? extends EObject>[]) rootPaths);
		RelationMapping relationMapping = mapping.getConcreteMappingForRole(targetRole).getRelationMappingForTargetRole(childRole);
		EClass childClass = mapping.getEClassForRole(childRole);
		EObject childObject = null;
		if(variable != null && context.getEObjectForVariable(variable) != null){
			childObject = context.getEObjectForVariable(variable);
		} else {
			childObject = ModelUtil.create(childClass);
		}
		List<ReferenceMetaClassPair> referencePairs = null;
		if(relationMapping != null){
			referencePairs = relationMapping.getReferenceMetaClassPair();
		}
		return RefactoringUtil.createPath(targetObject, referencePairs, childObject);
	}
}
