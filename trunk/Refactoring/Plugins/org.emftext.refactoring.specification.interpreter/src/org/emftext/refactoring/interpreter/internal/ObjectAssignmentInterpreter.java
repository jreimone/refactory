/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.FromClause;
import org.emftext.language.refactoring.refactoring_specification.FromOperator;
import org.emftext.language.refactoring.refactoring_specification.FromReference;
import org.emftext.language.refactoring.refactoring_specification.IndexVariable;
import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
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
public class ObjectAssignmentInterpreter {

	private Mapping mapping;
	private List<? extends EObject> selection;
	private RefactoringInterpreterContext context;

	public ObjectAssignmentInterpreter(Mapping mapping) {
		super();
		this.mapping = mapping;
	}

	public Boolean interpreteObjectAssignmentCommand(ObjectAssignmentCommand object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.selection = selection;
		this.context = context;
		
		Variable objectVar = object.getVariable();
		EObject value = null;
		
		if(object instanceof RoleReference){
			value = handleRoleReference((RoleReference) object);
		}
		
		if(value != null){
			context.addEObjectForVariable(objectVar, value);
		}
		
		return true;
	}

	private EObject handleRoleReference(RoleReference roleRef) {
		FromClause from = roleRef.getFrom();
		FromOperator operator = from.getOperator();
		List<? extends EObject> fromObjects = getFromReferenceObject(from);
		if(operator instanceof UPTREE){
			return handleFromOperatorUPTREE(roleRef.getRole(), fromObjects);	
		}
		return null;
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
	private EObject handleFromOperatorUPTREE(Role fromRole, List<? extends EObject> fromObjects) {
		List<?>[] rootPaths = new List<?>[fromObjects.size()];
		int i = 0;
		for (EObject eObject : fromObjects) {
			List<EObject> rootPath = ModelUtil.getPathToRoot(eObject);
			rootPaths[i] = rootPath;
			i++;
		}
		// build up uptree
		return RoleUtil.getFirstCommonObjectWithRoleFromPaths(fromRole, mapping, (List<? extends EObject>[]) rootPaths);
//		RelationMapping relationMapping = mapping.getConcreteMappingForRole(targetRole).getRelationMappingForTargetRole(childRole);
//		EClass childClass = mapping.getEClassForRole(childRole);
//		EObject childObject = null;
//		if(variable != null && context.getEObjectForVariable(variable) != null){
//			childObject = context.getEObjectForVariable(variable);
//		} else {
//			childObject = ModelUtil.create(childClass);
//		}
//		List<ReferenceMetaClassPair> referencePairs = null;
//		if(relationMapping != null){
//			referencePairs = relationMapping.getReferenceMetaClassPair();
//		}
//		Integer objectIndex = context.getIndexForVariable(index);
//		AbstractPathCreator pathCreator = new CreatePathCreator();
//		return pathCreator.createPath(targetObject, referencePairs, childObject, objectIndex);
	}
}