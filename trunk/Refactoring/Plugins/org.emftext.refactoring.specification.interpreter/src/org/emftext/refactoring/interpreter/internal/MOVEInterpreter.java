/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.MOVE;
import org.emftext.language.refactoring.refactoring_specification.RelationReference;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.roles.MultiplicityRelation;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
public class MOVEInterpreter {

	private RefactoringInterpreterContext context;
	private Mapping mapping;
	private List<? extends EObject> selection;
	
	public MOVEInterpreter(Mapping mapping) {
		super();
		this.mapping = mapping;
	}

	public Boolean interpreteMOVE(MOVE object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.context = context;
		SourceContext sourceContext = object.getSource();
		Role sourceRole = null;
		List<? extends EObject> sourceObjects = null;
		if(sourceContext instanceof RelationReference){
			MultiplicityRelation relation = ((RelationReference) sourceContext).getRelation();
			sourceRole = relation.getTarget();
			if(sourceRole.getModifier().contains(RoleModifier.INPUT)){
				sourceObjects = selection;
			}
		}
		
		TargetContext targetContext = object.getTarget();
		Role targetRole = null;
		EObject targetObject = null;
		if(targetContext instanceof VariableReference){
			Variable variable = ((VariableReference) targetContext).getVariable();
			targetObject = context.getEObjectForVariable(variable);
			targetRole = RoleUtil.getRoleFromVariable(variable);
		}
		RelationMapping relationMapping = mapping.getConcreteMappingForRole(targetRole).getRelationMappingForTargetRole(sourceRole);
		List<ReferenceMetaClassPair> referencePairs = relationMapping.getReferenceMetaClassPair();
		Integer index = context.getIndexForVariable(object.getIndex());
		AbstractPathCreator pathCreator = new MovePathCreator();
		return pathCreator.createPath(targetObject, referencePairs, sourceObjects, index);
	}
}
