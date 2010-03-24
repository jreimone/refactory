/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.Context;
import org.emftext.language.refactoring.refactoring_specification.FromClause;
import org.emftext.language.refactoring.refactoring_specification.FromReference;
import org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.Instruction;
import org.emftext.language.refactoring.refactoring_specification.MOVE;
import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RelationReference;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.SET;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.VariableAssignment;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.MultiplicityRelation;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.RoleUtil;

/**
 * Interpreter for a RefactoringSpecification.
 * 
 * @author Jan Reimann
 *
 */
public class RefactoringInterpreter extends AbstractRefspecInterpreter<Boolean, RefactoringInterpreterContext> implements IRefactoringInterpreter{

	private RefactoringSpecification refSpec;
	private EObject model;
	private EObject originalModel;
	private List<? extends EObject> selection;
	private RefactoringInterpreterContext context;
	private RoleMappingModel roleMapping;
	private Mapping mapping;
	private IRefactoringPostProcessor postProcessor;
	private Map<Role, Object> roleRuntimeInstanceMap;
	
	private CREATEInterpreter create;
	private SETInterpreter set;
	private MOVEInterpreter move;
	private ASSIGNInterpreter assign;
	private IndexAssignmentInterpreter indexInterpreter;
	private ObjectAssignmentInterpreter objectInterpreter;
	
	private Boolean occuredErrors;

	public RefactoringInterpreter(IRefactoringPostProcessor postProcessor){
		this.postProcessor = postProcessor;
		roleRuntimeInstanceMap = new LinkedHashMap<Role, Object>();
	}
	
	@Override
	public Boolean interprete(EObject object, RefactoringInterpreterContext context) {
		EcoreUtil.resolveAll(object);
		if(object instanceof RoleReference){
			Role role = ((RoleReference) object).getRole();
			if(containsModifierOPTIONAL(role)){return true;}
			FromClause from = ((RoleReference) object).getFrom();
			if(from != null){
				FromReference fromReference = from.getReference();
				if(fromReference instanceof VariableReference){
					Role variableRole = RoleUtil.getRoleFromVariable(((VariableReference) fromReference).getVariable());
					if(containsModifierOPTIONAL(variableRole)){return true;}
				}
			}
		} else if(object instanceof CREATE){
			CREATE create = (CREATE) object;
			Role childRole = create.getSourceRole();
			if(containsModifierOPTIONAL(childRole)){return true;}
			TargetContext targetContext = create.getTargetContext();
			if(contextIsOptional(targetContext)){return true;}
		} else if(object instanceof ASSIGN){
			RoleAttribute attribute = ((ASSIGN) object).getSourceAttribute();
			if(attribute != null){
				Role sourceAttRole = attribute.getAttributeRole();
				if(containsModifierOPTIONAL(sourceAttRole)){return true;}
			}
			Role targetRole = ((ASSIGN) object).getTargetAttribute().getAttributeRole();
			if(containsModifierOPTIONAL(targetRole)){return true;}
		} else if(object instanceof SET){
			if(sourceContextIsOptional(((SET) object).getSource())){return true;}
			if(contextIsOptional(((SET) object).getTarget())){return true;}
		} else if(object instanceof MOVE){
			if(sourceContextIsOptional(((MOVE) object).getSource())){return true;}
			if(contextIsOptional(((MOVE) object).getTarget())){return true;}
		}
		return super.interprete(object, context);
	}
	
	private boolean sourceContextIsOptional(SourceContext context){
		if(contextIsOptional(context)){
			return true;
		}
		if(context instanceof RelationReference){
			MultiplicityRelation relation = ((RelationReference) context).getRelation();
			Role role = relation.getSource();
			if(containsModifierOPTIONAL(role)){return true;}
			role = relation.getTarget();
			if(containsModifierOPTIONAL(role)){return true;}
		}
		return false;
	}
	
	private boolean contextIsOptional(Context context){
		if(context instanceof VariableReference){
			Role role = RoleUtil.getRoleFromVariable(((VariableReference) context).getVariable());
			if(role == null){
				boolean optional = !(this.context.getEObjectForVariable(((VariableReference) context).getVariable()) != null); 
				return optional;
			}
			if(containsModifierOPTIONAL(role)){return true;}
		} 
//		else if(context instanceof RoleReference){
//			Role role = ((RoleReference) context).getRole();
//			if(containsModifierOPTIONAL(role)){return true;}
//		}
		return false;
	}
	

	private boolean containsModifierOPTIONAL(Role sourceAttRole) {
		if(sourceAttRole.getModifier().contains(RoleModifier.OPTIONAL)){
			if(mapping.getEClassForRole(sourceAttRole) == null){
				RegistryUtil.log("Role '" + sourceAttRole.getName() + "' is optional and not set -> instruction will not be performed", IStatus.INFO);
				return true;
			}
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#initialize(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, org.eclipse.emf.ecore.EObject)
	 */
	public void initialize(RefactoringSpecification refSpec, EObject model, RoleMappingModel roleMapping, Mapping mapping) {
		this.refSpec = refSpec;
		this.model = model;
		this.originalModel = model;
		this.roleMapping = roleMapping;
		this.mapping = mapping;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#interprete()
	 */
	public EObject interprete(boolean copy) {
		context = new RefactoringInterpreterContext();
		
		create = new CREATEInterpreter(mapping);
		set = new SETInterpreter(mapping);
		move = new MOVEInterpreter(mapping);
		assign = new ASSIGNInterpreter(mapping);
		indexInterpreter = new IndexAssignmentInterpreter();
		objectInterpreter = new ObjectAssignmentInterpreter(mapping);
		
		EObject initialModel = model;
		if(copy){
			Copier copier = new Copier();
			// must be done so because refactorings always will be performed on the initial model
			// because the selection referres to the initial model 
			originalModel = copier.copy(model);
		}
		model = initialModel;
		context.setInitialContext(mapping);
		initInterpretationStack();
		
		List<Role> roles = mapping.getAllMappedRoles();
		for (Role role : roles) {
			if(role.getModifier().contains(RoleModifier.INPUT)){
				roleRuntimeInstanceMap.put(role, selection);
			}
		}
		
		occuredErrors = !interprete(context);
		return getModel();
	}	

	private void initInterpretationStack(){
		TreeIterator<EObject> it = refSpec.eAllContents();
		List<Instruction> instructions = new LinkedList<Instruction>();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
			if(eObject instanceof Instruction){
				instructions.add((Instruction) eObject);
			}
		}
		Collections.reverse(instructions);
		for (Instruction instruction : instructions) {
			addObjectToInterprete(instruction);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_ASSIGN(org.emftext.language.refactoring.refactoring_specification.ASSIGN, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN(
			ASSIGN object, RefactoringInterpreterContext context) {
		//		object.get
		Boolean result = assign.interpreteASSIGN(object, context, selection);
		Role assignedRole = assign.getAssignedRole();
		Object roleRuntimeInstance = assign.getRoleRuntimeValue();
		if(assignedRole != null && roleRuntimeInstance != null){
			roleRuntimeInstanceMap.put(assignedRole, roleRuntimeInstance);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE(org.emftext.language.refactoring.refactoring_specification.CREATE, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005fspecification_CREATE(
			CREATE object, RefactoringInterpreterContext context) {
		Boolean result = create.interpreteCREATE(object, context, selection);
		Role assignedRole = create.getAssignedRole();
		Object roleRuntimeInstance = create.getRoleRuntimeInstance();
		if(assignedRole != null && roleRuntimeInstance != null){
			roleRuntimeInstanceMap.put(assignedRole, roleRuntimeInstance);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE(org.emftext.language.refactoring.refactoring_specification.MOVE, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005fspecification_MOVE(
			MOVE object, RefactoringInterpreterContext context) {
		return move.interpreteMOVE(object, context, selection);
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005Fspecification_SET(org.emftext.language.refactoring.refactoring_specification.SET, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005fspecification_SET(
			SET object, RefactoringInterpreterContext context) {
		return set.interpreteSET(object, context);
	}
	
	

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005fspecification_IndexAssignmentCommand(org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005fspecification_IndexAssignmentCommand(
			IndexAssignmentCommand object, RefactoringInterpreterContext context) {
		return indexInterpreter.interpreteIndexCommand(object, context, selection);
	}
	
	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter#interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand(org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand, java.lang.Object)
	 */
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand(
			ObjectAssignmentCommand object,
			RefactoringInterpreterContext context) {
		Boolean result = objectInterpreter.interpreteObjectAssignmentCommand(object, context, selection);
		Role assignedRole = objectInterpreter.getAssignedRole();
		Object roleRuntimeInstance = objectInterpreter.getRoleRuntimeValue();
		if(assignedRole != null && roleRuntimeInstance != null){
			roleRuntimeInstanceMap.put(assignedRole, roleRuntimeInstance);
		}
		return result;
	}
	
	@Override
	public Boolean interprete_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment(
			VariableAssignment object, RefactoringInterpreterContext context) {
		return interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand(object.getAssignment(), context);
//		return objectInterpreter.interpreteObjectAssignmentCommand(object.getAssignment(), context, selection);
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#setInput(java.util.List)
	 */
	public void setInput(List<? extends EObject> currentSelection) {
		this.selection = currentSelection;
	}

	public EObject getModel() {
		return model;
	}

	public EObject getOriginalModel() {
		return originalModel;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#occuredErrors()
	 */
	public boolean didErrorsOccur() {
		return occuredErrors;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#getPostProcessor()
	 */
	public IRefactoringPostProcessor getPostProcessor() {
		return postProcessor;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#getRoleRuntimeInstances()
	 */
	public Map<Role, Object> getRoleRuntimeInstances() {
		return roleRuntimeInstanceMap;
	}
}
