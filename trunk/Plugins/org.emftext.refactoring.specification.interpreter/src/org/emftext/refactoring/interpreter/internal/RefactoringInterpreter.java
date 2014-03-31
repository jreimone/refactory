/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

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
import org.emftext.refactoring.interpreter.IValueProviderFactory;
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
	private RefactoringInterpreterContext context;
	private RoleMapping mapping;
	private IRefactoringPostProcessor postProcessor;

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

	private IValueProviderFactory valueProviderFactory;

	private Map<Role, List<EObject>> roleBindings;
	private Map<Role, List<URI>> roleRuntimeInstanceURIMap;

	public RefactoringInterpreter(IRefactoringPostProcessor postProcessor) {
		this.postProcessor = postProcessor;
		roleRuntimeInstanceURIMap = new HashMap<Role, List<URI>>();
		resourcesToSave = new LinkedList<Resource>();
	}

	/**
	 * Basically, this method is used to determine if optional roles have not been mapped
	 * and therefore no interpretation is needed. This method is called from {@link #interprete(EObject)}. 
	 * 
	 */
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

	public void initialize(RefactoringSpecification refSpec, RoleMapping mapping) {
		this.refSpec = refSpec;
		this.mapping = mapping;
		initInterpretationStack();
	}

	public EObject interprete(EObject model) {
		this.model = model;
		context = new RefactoringInterpreterContext();

		create = new CREATEInterpreter(mapping);
		set = new SETInterpreter(mapping);
		move = new MOVEInterpreter(mapping, this);
		assign = new ASSIGNInterpreter(mapping, this);
		indexInterpreter = new IndexAssignmentInterpreter();
		objectInterpreter = new ObjectAssignmentInterpreter(this, mapping);
		removeInterpreter = new REMOVEInterpreter(mapping);
		context.setInitialContext(mapping);

		status = interprete(context);
		
		if (status.getSeverity() == IRefactoringStatus.ERROR) {
			occuredErrors = true;
		}
		return getModel();
	}

	public void collectValueProviders() {
		Stack<EObject> stack = getInterpretationStack();
		ListIterator<EObject> iterator = stack.listIterator();
		while (iterator.hasNext()) {
			EObject instruction = iterator.next();
			if(instruction instanceof ASSIGN || instruction instanceof ObjectAssignmentInterpreter){
				getValueProviderFactory().registerValueProviderForCommand(instruction);
			}
		}
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
	
	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN(ASSIGN object, RefactoringInterpreterContext context) {
		List<EObject> boundInputElements = RoleUtil.getBoundInputElements(roleBindings);
		IRefactoringStatus result = assign.interpreteASSIGN(object, context, boundInputElements);
		Role assignedRole = assign.getAssignedRole();
		Object roleRuntimeInstance = assign.getRoleRuntimeValue();
		if (assignedRole != null && roleRuntimeInstance != null) {
			addRoleBinding(assignedRole, roleRuntimeInstance);
		}
		List<Resource> assignResourcesToSave = assign.getResourcesToSave();
		if (assignResourcesToSave != null) {
			resourcesToSave.addAll(assignResourcesToSave);
		}
		return result;
	}

	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_CREATE(CREATE object, RefactoringInterpreterContext context) {
		IRefactoringStatus result = create.interpreteCREATE(object, context);
		Role assignedRole = create.getAssignedRole();
		Object roleRuntimeInstance = create.getLocalRoleBindings();
		if (assignedRole != null && roleRuntimeInstance != null) {
			addRoleBinding(assignedRole, roleRuntimeInstance);
		}
		return result;
	}

	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_MOVE(MOVE object, RefactoringInterpreterContext context) {
		return move.interpreteMOVE(object, context, roleBindings);
	}

	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_SET(SET object, RefactoringInterpreterContext context) {
		return set.interpreteSET(object, context);
	}

	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_IndexAssignmentCommand(IndexAssignmentCommand object, RefactoringInterpreterContext context) {
		return indexInterpreter.interpreteIndexCommand(object, context, roleBindings);
	}

	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand(ObjectAssignmentCommand object, RefactoringInterpreterContext context) {
		IRefactoringStatus result = objectInterpreter.interpreteObjectAssignmentCommand(object, context, roleBindings);
		Role assignedRole = objectInterpreter.getAssignedRole();
		Object roleRuntimeInstance = objectInterpreter.getRoleRuntimeValue();
		if (assignedRole != null && roleRuntimeInstance != null) {
			addRoleBinding(assignedRole, roleRuntimeInstance);
		}
		return result;
	}

	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_REMOVE(REMOVE object, RefactoringInterpreterContext context) {
		IRefactoringStatus result = removeInterpreter.interpreteREMOVE(object, context, roleBindings);
		Role assignedRole = removeInterpreter.getAssignedRole();
		Object roleRuntimeInstance = removeInterpreter.getRoleRuntimeValue();
		if (assignedRole != null && roleRuntimeInstance != null) {
			addRoleBinding(assignedRole, roleRuntimeInstance);
		}
		return result;
	}

	@Override
	public IRefactoringStatus interprete_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment(VariableAssignment object, RefactoringInterpreterContext context) {
		return interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand(object.getAssignment(), context);
	}

	public void setRoleBindings(Map<Role, List<EObject>> roleBindings){
		this.roleBindings = roleBindings;
	}

	public EObject getModel() {
		return model;
	}

	public boolean didErrorsOccur() {
		return occuredErrors;
	}

	public IRefactoringPostProcessor getPostProcessor() {
		return postProcessor;
	}

	@SuppressWarnings("unchecked")
	private void addRoleBinding(Role role, Object object) {
		if (object instanceof EObject) {
			bindEObject(role, (EObject) object);
		} else if (object instanceof List<?>) {
			List<EObject> objects = (List<EObject>) object;
			for (EObject eObject : objects) {
				bindEObject(role, eObject);
			}
		}
	}

	private void bindEObject(Role role, EObject object) {
		List<EObject> instanceList = roleBindings.get(role);
		if (instanceList == null) {
			instanceList = new ArrayList<EObject>();
			roleBindings.put(role, instanceList);
		}
		if (!instanceList.contains(object)) {
			instanceList.add((EObject) object);
		}
	}

	public Map<Role, List<EObject>> getRoleRuntimeInstances() {
		return roleBindings;
	}

	public Map<Role, List<URI>> getRoleRuntimeInstanceURIs() {
		return roleRuntimeInstanceURIMap;
	}

	public List<Resource> getResourcesToSave() {
		return resourcesToSave;
	}

	public boolean continueInterpretation(IRefactoringStatus result) {
		return (result.getSeverity() == IRefactoringStatus.OK);
	}

	@Override
	public boolean continueInterpretation(RefactoringInterpreterContext context, IRefactoringStatus result) {
		return continueInterpretation(result);
	}

	public IRefactoringStatus getStatus() {
		return status;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		RefactoringInterpreter clone = new RefactoringInterpreter(postProcessor);
		clone.initialize(refSpec, mapping);
		clone.setValueProviderFactory(this.getValueProviderFactory());
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

	public void setRoleRuntimeInstanceURIs(Map<Role, List<URI>> roleRuntimeInstanceURIMap) {
		this.roleRuntimeInstanceURIMap = roleRuntimeInstanceURIMap;
	}

	public IValueProviderFactory getValueProviderFactory() {
		return valueProviderFactory;
	}

	public void setValueProviderFactory(IValueProviderFactory valueProviderFactory) {
		this.valueProviderFactory = valueProviderFactory;
	}
}
