/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.SET;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.roles.Role;

/**
 * @author Jan Reimann
 *
 */
public class SETInterpreter {

	private Mapping mapping;
	
	public SETInterpreter(Mapping mapping){
		this.mapping = mapping;
	}
	
	public Boolean interpreteSET(SET object, RefactoringInterpreterContext context) {
		SourceContext source = object.getSource();
		TargetContext target = object.getTarget();
		EObject sourceObject = null;
		EObject targetObject = null;
		Role targetRole = null;
		Role sourceRole = null;
		if(source instanceof VariableReference){
			sourceObject = context.getEObjectForVariable(((VariableReference) source).getVariable());
			sourceRole = ((VariableReference) source).getVariable().getCreateCommand().getSourceRoleReference().getRole();
		}
		if(target instanceof VariableReference){
			targetObject = context.getEObjectForVariable(((VariableReference) target).getVariable());
			targetRole = ((VariableReference) target).getVariable().getCreateCommand().getSourceRoleReference().getRole();
		} 
		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(targetRole);
		RelationMapping relationMapping = concreteMapping.getRelationMappingForTargetRole(sourceRole);
		List<ReferenceMetaClassPair> referencePairs = null;
		if(relationMapping != null){
			referencePairs = relationMapping.getReferenceMetaClassPair();
		}
		return RefactoringUtil.createPath(targetObject, referencePairs, sourceObject);
	}
}
