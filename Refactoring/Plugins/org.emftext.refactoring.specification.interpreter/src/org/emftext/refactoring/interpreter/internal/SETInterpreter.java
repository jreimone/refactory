/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.RefactoringStatus;
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
		EObject targetObject = null;
		Role targetRole = null;
		Role sourceRole = null;
		if(source instanceof VariableReference){
			sourceObject = context.getEObjectForVariable(((VariableReference) source).getVariable());
			if(sourceObject instanceof TraceObject){
				sourceRole = ((TraceObject) sourceObject).getAppliedRole();
				sourceObject = ((TraceObject) sourceObject).getContainer();
			} else {
				sourceRole = RoleUtil.getRoleFromVariable(((VariableReference) source).getVariable());
			}
		}
		if(target instanceof VariableReference){
			targetObject = context.getEObjectForVariable(((VariableReference) target).getVariable());
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
			// TODO das passt hier bei ExtractXwithReference nicht
			targetRole = relation.getSource();
			EObject interpretationContext = relation.getInterpretationContext();
			if(interpretationContext instanceof Variable){
				targetObject = context.getEObjectForVariable((Variable) interpretationContext);
			} else if(interpretationContext instanceof Role) {
				throw new UnsupportedOperationException("implement this case");
			}
			concreteMapping = mapping.getConcreteMappingForRole(targetRole);
			relationMapping = concreteMapping.getRelationMappingForRelation(relation);
			List<ReferenceMetaClassPair> pairs = relationMapping.getReferenceMetaClassPair();
			Object sourceObjects = null;
			if(source instanceof VariableReference){
				sourceObjects = context.getObjectForVariable(((VariableReference) source).getVariable());
				AbstractPathCreator pathCreator = new SetPathCreator();
				return pathCreator.createPath(targetObject, pairs, sourceObjects, null);
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
			AbstractPathCreator pathCreator = new CreatePathCreator();
			return pathCreator.createPath(targetObject, referencePairs, sourceObject);
		}
	}
}
