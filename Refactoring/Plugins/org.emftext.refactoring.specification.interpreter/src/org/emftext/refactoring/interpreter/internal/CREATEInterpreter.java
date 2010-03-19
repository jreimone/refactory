/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.IndexVariable;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.TraceObject;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.roles.Role;
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
		Role childRole = object.getSourceRole();
		Variable sourceVar = object.getVariable();
		if(sourceVar != null){
			context.addEObjectForVariable(sourceVar);
		}
		TargetContext target = object.getTargetContext();
		if(target instanceof VariableReference){
			return handleCREATETargetVariable(sourceVar, context, childRole, target, object.getIndex());
		}
		return false;
	}

	private boolean handleCREATETargetVariable(Variable sourceVar, RefactoringInterpreterContext context, Role childRole, TargetContext target, IndexVariable index) {
		Variable targetVar = ((VariableReference) target).getVariable();
		EObject parentObject = context.getEObjectForVariable(targetVar);
		EObject childObject = context.getEObjectForVariable(sourceVar);
		RelationMapping relationMapping = null;
		if(parentObject instanceof TraceObject){
			TraceObject trace = (TraceObject) parentObject;
			parentObject = trace.getContainer();
			Role appliedContainerRole = trace.getAppliedRole();
			ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(appliedContainerRole);
			relationMapping = concreteMapping.getRelationMappingForTargetRole(childRole);
		} else {
			Role varRole = RoleUtil.getRoleFromVariable(targetVar);
			ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(varRole);
			relationMapping = concreteMapping.getRelationMappingForTargetRole(childRole);
		}
		if(relationMapping == null){
			Integer objectIndex = context.getIndexForVariable(index);
			AbstractPathCreator pathCreator = new CreatePathCreator();
			return pathCreator.createPath(parentObject, null, childObject, objectIndex);
		} else {
			// add with path
			Integer objectIndex = context.getIndexForVariable(index);
			AbstractPathCreator pathCreator = new CreatePathCreator();
			return pathCreator.createPath(parentObject, relationMapping.getReferenceMetaClassPair(), childObject, objectIndex);
		}
	}
}
