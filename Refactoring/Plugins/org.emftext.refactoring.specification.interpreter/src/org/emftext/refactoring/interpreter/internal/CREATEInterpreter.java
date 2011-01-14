/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.IndexVariable;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.TraceObject;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.RefactoringStatus;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
public class CREATEInterpreter {

	private RoleMapping mapping;
	private List<? extends EObject> selection;
	private RefactoringInterpreterContext context;
	private Role assignedRole;
	private Object roleRuntimeInstance;

	public CREATEInterpreter(RoleMapping mapping){
		this.mapping = mapping;
	}

	public IRefactoringStatus interpreteCREATE(CREATE object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.selection = selection;
		this.context = context;
		Role childRole = object.getSourceRole();
		assignedRole = childRole;
		Variable sourceVar = object.getVariable();
		if(sourceVar != null){
			context.addEObjectForVariable(sourceVar);
			roleRuntimeInstance = context.getObjectForVariable(sourceVar);
		}
		TargetContext target = object.getTargetContext();
		if(target == null){
			return new RefactoringStatus(IStatus.OK);
		}
		if(target instanceof VariableReference){
			return handleCREATETargetVariable(sourceVar, context, childRole, target, object.getIndex());
		}
		return new RefactoringStatus(IRefactoringStatus.ERROR, "Couldn't create something");
	}

	private IRefactoringStatus handleCREATETargetVariable(Variable sourceVar, RefactoringInterpreterContext context, Role childRole, TargetContext target, IndexVariable index) {
		Variable targetVar = ((VariableReference) target).getVariable();
		EObject parentObject = (EObject) context.getObjectForVariable(targetVar);
		EObject childObject = (EObject) context.getObjectForVariable(sourceVar);
		CollaborationMapping collaborationMapping = null;
		if(parentObject instanceof TraceObject){
			TraceObject trace = (TraceObject) parentObject;
			parentObject = trace.getContainer();
			Role appliedContainerRole = trace.getAppliedRole();
			ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(appliedContainerRole);
			collaborationMapping = concreteMapping.getCollaborationMappingForTargetRole(childRole);
		} else {
			Role varRole = RoleUtil.getRoleFromVariable(targetVar);
			ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(varRole);
			collaborationMapping = concreteMapping.getCollaborationMappingForTargetRole(childRole);
		}
		if(collaborationMapping == null){
			Integer objectIndex = context.getIndexForVariable(index);
			AbstractPathCreator pathCreator = new CreatePathCreator();
			return pathCreator.createPath(parentObject, null, childObject, objectIndex);
		} else {
			// add with path
			Integer objectIndex = context.getIndexForVariable(index);
			AbstractPathCreator pathCreator = new CreatePathCreator();
			return pathCreator.createPath(parentObject, collaborationMapping.getReferenceMetaClassPair(), childObject, objectIndex);
		}
	}

	/**
	 * @return the assignedRole
	 */
	public Role getAssignedRole() {
		return assignedRole;
	}

	/**
	 * @return the roleRuntimeInstance
	 */
	public Object getRoleRuntimeInstance() {
		return roleRuntimeInstance;
	}
}
