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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.CollaborationReference;
import org.emftext.language.refactoring.refactoring_specification.Context;
import org.emftext.language.refactoring.refactoring_specification.FromClause;
import org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.Instruction;
import org.emftext.language.refactoring.refactoring_specification.MOVE;
import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.ObjectReference;
import org.emftext.language.refactoring.refactoring_specification.REMOVE;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.SET;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.VariableAssignment;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.language.refactoring.specification.resource.util.AbstractRefspecInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.RefactoringStatus;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.RoleUtil;

/**
 * Interpreter for a RefactoringSpecification.
 * 
 * @author Jan Reimann
 * 
 */
public class RefactoringInterpreter extends AbstractRefspecInterpreter<IRefactoringStatus, RefactoringInterpreterContext> implements IRefactoringInterpreter {

	private RefactoringSpecification refSpec;
	private EObject model;
	// private EObject originalModel;
	private List<? extends EObject> selection;
	private RefactoringInterpreterContext context;
	// private RoleMappingModel roleMapping;
	private RoleMapping mapping;
	private IRefactoringPostProcessor postProcessor;
	private Map<Role, List<EObject>> roleRuntimeInstanceMap;
	private Map<Role, List<URI>> roleRuntimeInstanceURIMap;

	private CREATEInterpreter create;
	private SETInterpreter set;
	private MOVEInterpreter move;
	private ASSIGNInterpreter assign;
	private IndexAssignmentInterpreter indexInterpreter;
	private ObjectAssignmentInterpreter objectInterpreter;
	private REMOVEInterpreter removeInterpreter;

	private List<Resource> resourcesToSave;

	private Boolean occuredErrors = false;

	private IRefactoringStatus status;

	private IRefactoringFakeInterpreter fakeInterpreter;

	private Map<EObject, IValueProvider<?, ?>> valueProviderMap;

	public RefactoringInterpreter(IRefactoringPostProcessor postProcessor) {
		this.postProcessor = postProcessor;
		roleRuntimeInstanceMap = new LinkedHashMap<Role, List<EObject>>();
		roleRuntimeInstanceURIMap = new LinkedHashMap<Role, List<URI>>();
		resourcesToSave = new LinkedList<Resource>();
		valueProviderMap = new LinkedHashMap<EObject, IValueProvider<?, ?>>();
	}

	@Override
	public IRefactoringStatus interprete(EObject object, RefactoringInterpreterContext context) {
		EcoreUtil.resolveAll(object);
		if (object instanceof RoleReference) {
			Role role = ((RoleReference) object).getRole();
			if (containsModifierOPTIONAL(role)) {
				return new RefactoringStatus(IRefactoringStatus.OK);
			}
			FromClause from = ((RoleReference) object).getFrom();
			if (from != null) {
				ObjectReference fromReference = from.getReference();
				if (fromReference instanceof VariableReference) {
					Role variableRole = RoleUtil.getRoleFromVariable(((VariableReference) fromReference).getVariable());
					if (containsModifierOPTIONAL(variableRole)) {
						return new RefactoringStatus(IRefactoringStatus.OK);
					}
				}
			}
		} else if (object instanceof CREATE) {
			CREATE create = (CREATE) object;
			Role childRole = create.getSourceRole();
			if (containsModifierOPTIONAL(childRole)) {
				return new RefactoringStatus(IRefactoringStatus.OK);
			}
			TargetContext targetContext = create.getTargetContext();
			if (contextIsOptional(targetContext)) {
				return new RefactoringStatus(IRefactoringStatus.OK);
			}
		} else if (object instanceof ASSIGN) {
			RoleAttribute attribute = ((ASSIGN) object).getSourceAttribute();
			if (attribute != null) {
				Role sourceAttRole = attribute.getAttributeRole();
				if (containsModifierOPTIONAL(sourceAttRole)) {
					return new RefactoringStatus(IRefactoringStatus.OK);
				}
				if (attribute.getModifier().contains(RoleModifier.OPTIONAL)) {
					if (mapping.getConcreteMappingForRole(sourceAttRole).getAttributeMappingForAttribute(attribute) == null) {
						return new RefactoringStatus(IRefactoringStatus.OK);
					}
				}
			}
			attribute = ((ASSIGN) object).getTargetAttribute();
			Role targetRole = attribute.getAttributeRole();
			if (containsModifierOPTIONAL(targetRole)) {
				return new RefactoringStatus(IRefactoringStatus.OK);
			}
			if (((ASSIGN) object).getTargetAttribute().getModifier().contains(RoleModifier.OPTIONAL)) {
				if (mapping.getConcreteMappingForRole(targetRole).getAttributeMappingForAttribute(attribute) == null) {
					return new RefactoringStatus(IRefactoringStatus.OK);
				}
			}
		} else if (object instanceof SET) {
			if (sourceContextIsOptional(((SET) object).getSource())) {
				return new RefactoringStatus(IRefactoringStatus.OK);
			}
			if (contextIsOptional(((SET) object).getTarget())) {
				return new RefactoringStatus(IRefactoringStatus.OK);
			}
		} else if (object instanceof MOVE) {
			if (sourceContextIsOptional(((MOVE) object).getSource())) {
				return new RefactoringStatus(IRefactoringStatus.OK);
			}
			if (contextIsOptional(((MOVE) object).getTarget())) {
				return new RefactoringStatus(IRefactoringStatus.OK);
			}
		}
		return super.interprete(object, context);
	}

	private boolean sourceContextIsOptional(SourceContext context) {
		if (contextIsOptional(context)) {
			return true;
		}
		if (context instanceof CollaborationReference) {
			MultiplicityCollaboration collaboration = ((CollaborationReference) context).getCollaboration();
			Role role = collaboration.getSource();
			if (containsModifierOPTIONAL(role)) {
				return true;
			}
			role = collaboration.getTarget();
			if (containsModifierOPTIONAL(role)) {
				return true;
			}
		}
		return false;
	}

	private boolean contextIsOptional(Context context) {
		if (context instanceof VariableReference) {
			Role role = RoleUtil.getRoleFromVariable(((VariableReference) context).getVariable());
			if (role == null) {
				Object variableObject = this.context.getObjectForVariable(((VariableReference) context).getVariable());
				boolean optional = !(variableObject != null);
				return optional;
			}
			if (containsModifierOPTIONAL(role)) {
				return true;
			}
		}
		// else if(context instanceof RoleReference){
		// Role role = ((RoleReference) context).getRole();
		// if(containsModifierOPTIONAL(role)){return true;}
		// }
		return false;
	}

	private boolean containsModifierOPTIONAL(Role sourceAttRole) {
		if (sourceAttRole.getModifier().contains(RoleModifier.OPTIONAL)) {
			if (mapping.getEClassForRole(sourceAttRole) == null) {
				RegistryUtil.log("Role '"
						+ sourceAttRole.getName()
						+ "' is optional and not set -> instruction will not be performed", IStatus.INFO);
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactoringInterpreter#initialize
	 * (org.emftext.language.refactoring.refactoring_specification.
	 * RefactoringSpecification, org.eclipse.emf.ecore.EObject)
	 */
	public void initialize(RefactoringSpecification refSpec, RoleMapping mapping) {
		this.refSpec = refSpec;
		// this.model = model;
		// this.originalModel = model;
		this.mapping = mapping;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactoringInterpreter#interprete()
	 */
	public EObject interprete(EObject model) {
		this.model = model;
		context = new RefactoringInterpreterContext();

		create = new CREATEInterpreter(mapping);
		set = new SETInterpreter(mapping);
		move = new MOVEInterpreter(mapping, this);
		assign = new ASSIGNInterpreter(mapping, this);
		indexInterpreter = new IndexAssignmentInterpreter();
		objectInterpreter = new ObjectAssignmentInterpreter(this, mapping);
		removeInterpreter = new REMOVEInterpreter(this, mapping);
		context.setInitialContext(mapping);
		initInterpretationStack();

		List<Role> roles = RoleUtil.getAllInputRoles(mapping);
		for (Role role : roles) {
			List<EObject> roleElements = RoleUtil.filterObjectsByRoles(selection, mapping, role);
			putIntoRoleRuntimeInstanceMap(role, roleElements);
		}
		status = interprete(context);
		
		if (status.getSeverity() == IRefactoringStatus.ERROR) {
			occuredErrors = true;
		}
		return getModel();
	}

	private void initInterpretationStack() {
		TreeIterator<EObject> it = refSpec.eAllContents();
		List<Instruction> instructions = new LinkedList<Instruction>();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
			if (eObject instanceof Instruction) {
				instructions.add((Instruction) eObject);
			}
		}
		Collections.reverse(instructions);
		for (Instruction instruction : instructions) {
			addObjectToInterprete(instruction);
		}
		//For refspecs containing no instructions there will be no objects to interprete
		//this far. For the refactoring not to abort, the refspec object itself will be
		//added - its interpretation will just trigger the return of an "OK"
		if (instructions.isEmpty()) {
			addObjectToInterprete(refSpec);
		}
		
	}
	
	//For refspecs containing no instructions there will be no objects to interprete.
	//For the refactoring not to abort, the refspec object itself has been
	//added within initInterpretationStack()- its interpretation will just trigger the return of an "OK"
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification(RefactoringSpecification object, RefactoringInterpreterContext context) {
		return new RefactoringStatus(IRefactoringStatus.OK);
	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emftext.language.refactoring.specification.resource.util.
	 * AbstractRefspecInterpreter#
	 * interprete_org_emftext_language_refactoring_refactoring_005Fspecification_ASSIGN
	 * (org.emftext.language.refactoring.refactoring_specification.ASSIGN,
	 * java.lang.Object)
	 */
	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN(ASSIGN object, RefactoringInterpreterContext context) {
		// object.get
		IRefactoringStatus result = assign.interpreteASSIGN(object, context, selection);
		Role assignedRole = assign.getAssignedRole();
		Object roleRuntimeInstance = assign.getRoleRuntimeValue();
		if (assignedRole != null && roleRuntimeInstance != null) {
			putIntoRoleRuntimeInstanceMap(assignedRole, roleRuntimeInstance);
		}
		List<Resource> assignResourcesToSave = assign.getResourcesToSave();
		if (assignResourcesToSave != null) {
			resourcesToSave.addAll(assignResourcesToSave);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emftext.language.refactoring.specification.resource.util.
	 * AbstractRefspecInterpreter#
	 * interprete_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE
	 * (org.emftext.language.refactoring.refactoring_specification.CREATE,
	 * java.lang.Object)
	 */
	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_CREATE(CREATE object, RefactoringInterpreterContext context) {
		IRefactoringStatus result = create.interpreteCREATE(object, context, selection);
		Role assignedRole = create.getAssignedRole();
		Object roleRuntimeInstance = create.getRoleRuntimeInstance();
		if (assignedRole != null && roleRuntimeInstance != null) {
			putIntoRoleRuntimeInstanceMap(assignedRole, roleRuntimeInstance);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emftext.language.refactoring.specification.resource.util.
	 * AbstractRefspecInterpreter#
	 * interprete_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE
	 * (org.emftext.language.refactoring.refactoring_specification.MOVE,
	 * java.lang.Object)
	 */
	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_MOVE(MOVE object, RefactoringInterpreterContext context) {
		return move.interpreteMOVE(object, context, selection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emftext.language.refactoring.specification.resource.util.
	 * AbstractRefspecInterpreter#
	 * interprete_org_emftext_language_refactoring_refactoring_005Fspecification_SET
	 * (org.emftext.language.refactoring.refactoring_specification.SET,
	 * java.lang.Object)
	 */
	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_SET(SET object, RefactoringInterpreterContext context) {
		return set.interpreteSET(object, context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emftext.language.refactoring.specification.resource.util.
	 * AbstractRefspecInterpreter#
	 * interprete_org_emftext_language_refactoring_refactoring_005fspecification_IndexAssignmentCommand
	 * (org.emftext.language.refactoring.refactoring_specification.
	 * IndexAssignmentCommand, java.lang.Object)
	 */
	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_IndexAssignmentCommand(IndexAssignmentCommand object, RefactoringInterpreterContext context) {
		return indexInterpreter.interpreteIndexCommand(object, context, selection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emftext.language.refactoring.specification.resource.util.
	 * AbstractRefspecInterpreter#
	 * interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand
	 * (org.emftext.language.refactoring.refactoring_specification.
	 * ObjectAssignmentCommand, java.lang.Object)
	 */
	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand(ObjectAssignmentCommand object, RefactoringInterpreterContext context) {
		IRefactoringStatus result = objectInterpreter.interpreteObjectAssignmentCommand(object, context, selection);
		Role assignedRole = objectInterpreter.getAssignedRole();
		Object roleRuntimeInstance = objectInterpreter.getRoleRuntimeValue();
		if (assignedRole != null && roleRuntimeInstance != null) {
			putIntoRoleRuntimeInstanceMap(assignedRole, roleRuntimeInstance);
		}
		return result;
	}

	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_REMOVE(REMOVE object, RefactoringInterpreterContext context) {
		IRefactoringStatus result = removeInterpreter.interpreteREMOVE(object, context, selection);
		Role assignedRole = removeInterpreter.getAssignedRole();
		Object roleRuntimeInstance = removeInterpreter.getRoleRuntimeValue();
		if (assignedRole != null && roleRuntimeInstance != null) {
			putIntoRoleRuntimeInstanceMap(assignedRole, roleRuntimeInstance);
		}
		return result;
	}

	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment(VariableAssignment object, RefactoringInterpreterContext context) {
		return interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand(object.getAssignment(), context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactoringInterpreter#setInput(
	 * java.util.List)
	 */
	public void setInput(List<? extends EObject> currentSelection) {
		this.selection = currentSelection;
	}

	public EObject getModel() {
		return model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactoringInterpreter#occuredErrors
	 * ()
	 */
	public boolean didErrorsOccur() {
		return occuredErrors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactoringInterpreter#getPostProcessor
	 * ()
	 */
	public IRefactoringPostProcessor getPostProcessor() {
		return postProcessor;
	}

	@SuppressWarnings("unchecked")
	private void putIntoRoleRuntimeInstanceMap(Role role, Object object) {
		if (object instanceof EObject) {
			putEObjectIntoRoleRuntimeInstanceMap(role, (EObject) object);
		} else if (object instanceof List<?>) {
			List<EObject> objects = (List<EObject>) object;
			for (EObject eObject : objects) {
				putEObjectIntoRoleRuntimeInstanceMap(role, eObject);
			}
		}
	}

	private void putEObjectIntoRoleRuntimeInstanceMap(Role role, EObject object) {
		List<EObject> instanceList = roleRuntimeInstanceMap.get(role);
		if (instanceList == null) {
			instanceList = new LinkedList<EObject>();
			roleRuntimeInstanceMap.put(role, instanceList);
		}
		if (!instanceList.contains(object)) {
			instanceList.add((EObject) object);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emftext.refactoring.interpreter.IRefactoringInterpreter#
	 * getRoleRuntimeInstances()
	 */
	public Map<Role, List<EObject>> getRoleRuntimeInstances() {
		return roleRuntimeInstanceMap;
	}

	public Map<Role, List<URI>> getRoleRuntimeInstanceURIs() {
		return roleRuntimeInstanceURIMap;
	}

	public List<Resource> getResourcesToSave() {
		return resourcesToSave;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emftext.language.refactoring.specification.resource.util.
	 * AbstractRefspecInterpreter#continueInterpretation(java.lang.Object)
	 */
	@Override
	public boolean continueInterpretation(IRefactoringStatus result) {
		return (result.getSeverity() == IRefactoringStatus.OK);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactoringInterpreter#getStatus()
	 */
	public IRefactoringStatus getStatus() {
		return status;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		RefactoringInterpreter clone = new RefactoringInterpreter(postProcessor);
		clone.initialize(refSpec, mapping);
		return clone;
	}

	public IRefactoringFakeInterpreter getFakeInterpreter() {
		try {
			if (fakeInterpreter == null) {
				fakeInterpreter = new RefactoringFakeInterpreter((IRefactoringInterpreter) this.clone());
			}
			return fakeInterpreter;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public RoleMapping getRoleMapping() {
		return mapping;
	}

	public RefactoringSpecification getRefactoringSpecification() {
		return refSpec;
	}

	public IValueProvider<?, ?> getValueProviderForCommand(EObject command) {
		IValueProvider<?, ?> valueProvider = null;
		if (fakeInterpreter != null) {
			valueProvider = fakeInterpreter.getValueProviderForCommand(command);
		}
		if (valueProvider == null) {
			return valueProviderMap.get(command);
		}
		return valueProvider;
	}

	public void registerValueProviderForCommand(EObject command, IValueProvider<?, ?> valueProvider) {
		valueProviderMap.put(command, valueProvider);
	}

	public void setRoleRuntimeInstanceURIs(Map<Role, List<URI>> roleRuntimeInstanceURIMap) {
		this.roleRuntimeInstanceURIMap = roleRuntimeInstanceURIMap;
	}
}
