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

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.language.refactoring.refactoring_specification.CollaborationReference;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.DISTINCT;
import org.emftext.language.refactoring.refactoring_specification.MOVE;
import org.emftext.language.refactoring.refactoring_specification.Modifier;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableAssignment;
import org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
public class MOVEInterpreter {

	private RefactoringInterpreterContext context;
	private RoleMapping mapping;
	private List<? extends EObject> selection;
	private IRefactoringInterpreter interpreter;

	public MOVEInterpreter(RoleMapping mapping, IRefactoringInterpreter interpreter) {
		super();
		this.mapping = mapping;
		this.interpreter = interpreter;
	}

	public IRefactoringStatus interpreteMOVE(MOVE object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.context = context;
		SourceContext sourceContext = object.getSource();
		Role sourceRole = null;
		List<? extends EObject> sourceObjects = null;
		if (sourceContext instanceof CollaborationReference) {
			MultiplicityCollaboration collaboration = ((CollaborationReference) sourceContext).getCollaboration();
			sourceRole = collaboration.getTarget();
			if (sourceRole.getModifier().contains(RoleModifier.INPUT)) {
				sourceObjects = selection;
			}
		} else if (sourceContext instanceof ConstantsReference) {
			if (((ConstantsReference) sourceContext).getReferencedConstant() == Constants.INPUT) {
				sourceObjects = selection;
			} else {
				throw new UnsupportedOperationException("implement me");
			}
		} else {
			throw new UnsupportedOperationException("implement me");
		}
		sourceObjects = handleMoveModifier(sourceObjects,
				object.getMoveModifier());

		TargetContext targetContext = object.getTarget();
		Role targetRole = null;
		EObject targetObject = null;
		EObject instruction = null;
		if (targetContext instanceof VariableReference) {
			Variable variable = ((VariableReference) targetContext).getVariable();
			VariableDeclarationCommand command = variable.getContainerCommand();
			if (command instanceof VariableAssignment) {
				instruction = ((VariableAssignment) command).getAssignment();
			}
			targetObject = (EObject) context.getObjectForVariable(variable);
			targetRole = RoleUtil.getRoleFromVariable(variable);
		} else if (targetContext instanceof CollaborationReference) {
			CollaborationReference reference = (CollaborationReference) targetContext;
			MultiplicityCollaboration collaboration = reference.getCollaboration();
			targetRole = collaboration.getTarget();

		}
		CollaborationMapping collaborationMapping = mapping.getConcreteMappingForRole(
				targetRole).getCollaborationMappingForTargetRole(sourceRole);
		List<ReferenceMetaClassPair> referencePairs = collaborationMapping.getReferenceMetaClassPair();
		Integer index = context.getIndexForVariable(object.getIndex());
		AbstractPathCreator pathCreator = new MovePathCreator();
		IValueProvider<?, ?> valueProvider = interpreter.getValueProviderFactory().getValueProviderForCommand(instruction);
		if (valueProvider != null) {
			valueProvider.setFakePropagationContext(pathCreator);
		}
		return pathCreator.createPath(targetObject, referencePairs,
				sourceObjects, index);
	}

	@SuppressWarnings("unchecked")
	private List<EObject> handleMoveModifier(List<? extends EObject> sourceObjects, Modifier modifier) {
		if (modifier instanceof DISTINCT) {
			Set<EObject> originals = new LinkedHashSet<EObject>();
			Set<EObject> copyList = new LinkedHashSet<EObject>();
			for (EObject object : sourceObjects) {
				List<EObject> others = new LinkedList<EObject>();
				for (EObject otherObject : sourceObjects) {
					if (!otherObject.equals(object)) {
						others.add(otherObject);
					}
				}
				Copier copier = new Copier();
				EObject copiedObject = copier.copy(object);
				for (EObject otherObject : others) {
					EObject copiedOther = copier.copy(otherObject);
					copier.copyReferences();
					if (!copyList.contains(object)
							&& EcoreUtil.equals(copiedObject, copiedOther)) {
						originals.add(object);
						copyList.add(otherObject);
					}
				}
			}
			for (EObject eObject : sourceObjects) {
				if (!originals.contains(eObject) && !copyList.contains(eObject)) {
					originals.add(eObject);
				}
			}
			for (EObject object : copyList) {
				EcoreUtil.remove(object);
			}
			return new LinkedList<EObject>(originals);
		}
		return (List<EObject>) sourceObjects;
	}
}
