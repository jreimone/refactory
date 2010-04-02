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
		EObject targetObject = null;
		Role targetRole = null;
		Role sourceRole = null;
		if(source instanceof VariableReference){
			sourceObject = context.getEObjectForVariable(((VariableReference) source).getVariable());
			sourceRole = RoleUtil.getRoleFromVariable(((VariableReference) source).getVariable());
		}
		if(target instanceof VariableReference){
			targetObject = context.getEObjectForVariable(((VariableReference) target).getVariable());
			targetRole = RoleUtil.getRoleFromVariable(((VariableReference) target).getVariable());
		} 
		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(targetRole);
		RelationMapping relationMapping = concreteMapping.getRelationMappingForTargetRole(sourceRole);
		List<ReferenceMetaClassPair> referencePairs = null;
		if(relationMapping != null){
			referencePairs = relationMapping.getReferenceMetaClassPair();
		}
		AbstractPathCreator pathCreator = new CreatePathCreator();
		return pathCreator.createPath(targetObject, referencePairs, sourceObject);
	}
}
