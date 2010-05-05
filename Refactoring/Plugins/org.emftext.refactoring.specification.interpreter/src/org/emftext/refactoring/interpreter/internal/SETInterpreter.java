/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.RelationReference;
import org.emftext.language.refactoring.refactoring_specification.SET;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.TraceObject;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.roles.MultiplicityRelation;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
public class SETInterpreter {

	private Mapping mapping;

	public SETInterpreter(Mapping mapping){
		this.mapping = mapping;
	}

	
	public IRefactoringStatus interpreteSET(SET object, RefactoringInterpreterContext context) {
		SourceContext source = object.getSource();
		TargetContext target = object.getTarget();
		EObject sourceObject = null;
		Object targetObject = null;
		Role targetRole = null;
		Role sourceRole = null;
		if(source instanceof VariableReference){
			sourceObject = (EObject) context.getObjectForVariable(((VariableReference) source).getVariable());
			if(sourceObject instanceof TraceObject){
				sourceRole = ((TraceObject) sourceObject).getAppliedRole();
				sourceObject = ((TraceObject) sourceObject).getContainer();
			} else {
				sourceRole = RoleUtil.getRoleFromVariable(((VariableReference) source).getVariable());
			}
		}
		if(target instanceof VariableReference){
			//			targetObject = context.getEObjectForVariable(((VariableReference) target).getVariable());
			targetObject = context.getObjectForVariable(((VariableReference) target).getVariable());
			if(targetObject instanceof TraceObject){
				targetRole = ((TraceObject) targetObject).getAppliedRole();
				targetObject = ((TraceObject) targetObject).getContainer();
			} else {
				targetRole = RoleUtil.getRoleFromVariable(((VariableReference) target).getVariable());
			}
		}
		ConcreteMapping concreteMapping = null;
		RelationMapping relationMapping = null;
		if(target instanceof RelationReference){
			MultiplicityRelation relation = ((RelationReference) target).getRelation();
			targetRole = relation.getSource();
			EObject interpretationContext = relation.getInterpretationContext();
			if(interpretationContext instanceof Variable){
				targetObject = context.getObjectForVariable((Variable) interpretationContext);
			} else if(interpretationContext instanceof Role) {
				throw new UnsupportedOperationException("implement this case");
			}
			concreteMapping = mapping.getConcreteMappingForRole(targetRole);
			relationMapping = concreteMapping.getRelationMappingForRelation(relation);
			List<ReferenceMetaClassPair> pairs = relationMapping.getReferenceMetaClassPair();
			Object sourceObjects = null;
			if(source instanceof VariableReference){
				sourceObjects = context.getObjectForVariable(((VariableReference) source).getVariable());
				return handleTarget(targetObject, pairs, sourceObjects);
			} else {
				throw new UnsupportedOperationException("implement this case");
			}

		} else {
			concreteMapping = mapping.getConcreteMappingForRole(targetRole);
			relationMapping = concreteMapping.getRelationMappingForTargetRole(sourceRole);
			List<ReferenceMetaClassPair> referencePairs = null;
			if(relationMapping != null){
				referencePairs = relationMapping.getReferenceMetaClassPair();
			}
			return handleTarget(targetObject, referencePairs, sourceObject);
//			AbstractPathCreator pathCreator = new CreatePathCreator();
//			return pathCreator.createPath(targetObject, referencePairs, sourceObject);
		}
	}


	/**
	 * @param targetObject
	 * @param pairs
	 * @param sourceObjects
	 */
	private IRefactoringStatus handleTarget(Object targetObject, List<ReferenceMetaClassPair> pairs, Object sourceObjects) {
		if(targetObject instanceof EObject){
			AbstractPathCreator pathCreator = new SetPathCreator();
			return pathCreator.createPath((EObject) targetObject, pairs, sourceObjects, null);
		} else if(targetObject instanceof List<?>){
			@SuppressWarnings("unchecked")
			List<EObject> targetObjects = (List<EObject>) targetObject;
			List<IRefactoringStatus> stati = new LinkedList<IRefactoringStatus>();
			for (EObject eObject : targetObjects) {
				AbstractPathCreator pathCreator = new SetPathCreator();
				stati.add(pathCreator.createPath(eObject, pairs, sourceObjects, null));
			}
			for (IRefactoringStatus status : stati) {
				if(status.getSeverity() != IRefactoringStatus.OK){
					return status;
				}
			}
			return stati.get(0);
		}
		return null;
	}
}
