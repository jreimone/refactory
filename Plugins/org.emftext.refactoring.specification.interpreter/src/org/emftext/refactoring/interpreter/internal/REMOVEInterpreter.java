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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.CollaborationReference;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.EMPTY;
import org.emftext.language.refactoring.refactoring_specification.ObjectRemoval;
import org.emftext.language.refactoring.refactoring_specification.REMOVE;
import org.emftext.language.refactoring.refactoring_specification.RemoveModifier;
import org.emftext.language.refactoring.refactoring_specification.RoleRemoval;
import org.emftext.language.refactoring.refactoring_specification.UNUSED;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.RefactoringStatus;
import org.emftext.refactoring.interpreter.exceptions.RefSpecInterpretationException;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 */
public class REMOVEInterpreter {

	private RoleMapping mapping;
	private RefactoringInterpreterContext context;
	private Map<Role, List<EObject>> roleBindings;
	private Role assignedRole;
	private Object runtimeValue;

	public REMOVEInterpreter(RoleMapping mapping) {
		this.mapping = mapping;
	}

	public IRefactoringStatus interpreteREMOVE(REMOVE object, RefactoringInterpreterContext context, Map<Role, List<EObject>> roleBindings) {
		this.context = context;
		this.roleBindings = roleBindings;

		RemoveModifier modifier = object.getModifier();
		List<EObject> removals = null;
		try {
			removals = resolveRemovals(object.getRemoval());
			if (modifier != null) {
				removals = modify(modifier, removals);
			}
		} catch (RefSpecInterpretationException e) {
			return new RefactoringStatus(IRefactoringStatus.ERROR, "An error occurred while resolving the removals", e);
		}
		if(removals != null){
			remove(removals);
			return new RefactoringStatus(IRefactoringStatus.OK);
		}
		return new RefactoringStatus(IRefactoringStatus.WARNING, "No removals could be resolved");
	}

	/**
	 * @param removals
	 */
	private void remove(List<EObject> removals) {
		if (removals != null) {
			for (EObject removal : removals) {
				EcoreUtil.remove(removal);
			}
		}
	}

	/**
	 * @param modifier
	 * @param removals
	 * @return
	 */
	private List<EObject> modify(RemoveModifier modifier, List<EObject> removals) {
		List<EObject> filteredRemovals = new LinkedList<EObject>();
		if (modifier instanceof UNUSED) {
			filteredRemovals = interpreteUNUSED(removals);
		} else if (modifier instanceof EMPTY) {
			filteredRemovals = interpreteEMPTY(removals);
		}
		return filteredRemovals;
	}

	/**
	 * @param removals
	 * @return
	 */
	private List<EObject> interpreteEMPTY(List<EObject> removals) {
		List<EObject> emptyRemovals = new LinkedList<EObject>();
		for (EObject removal : removals) {
			TreeIterator<Object> iterator = EcoreUtil.getAllContents(removal,
					true);
			boolean empty = true;
			if (iterator.hasNext()) {
				empty = false;
			}
			if (empty) {
				emptyRemovals.add(removal);
			}
		}
		return emptyRemovals;
	}

	/**
	 * @param removals
	 * @return
	 */
	private List<EObject> interpreteUNUSED(List<EObject> removals) {
		List<EObject> unusedRemovals = new LinkedList<EObject>();
		if (removals.size() > 0) {
			for (EObject removal : removals) {
				Resource ownResource = removal.eResource();
				ECrossReferenceAdapter crossReferencer;
				if (ownResource != null) {
					crossReferencer = getCrossReferencer(ownResource);
				} else {
					crossReferencer = getCrossReferencer(EcoreUtil.getRootContainer(removal));
				}
				if (crossReferencer != null) {
					Collection<Setting> references = crossReferencer.getNonNavigableInverseReferences(
							removal, true);
					boolean onlyContainerReference = true;
					for (Setting setting : references) {
						EObject container = removal.eContainer();
						EStructuralFeature containingFeature = removal.eContainingFeature();
						EObject referer = setting.getEObject();
						EStructuralFeature feature = setting.getEStructuralFeature();
						if (!(container.equals(referer) && containingFeature.equals(feature))) {
							RegistryUtil.log(
									referer + " referes to " + removal,
									IStatus.INFO);
							onlyContainerReference = false;
							break;
						}
					}
					if (onlyContainerReference) {
						unusedRemovals.add(removal);
					}
				}
			}
		}
		return unusedRemovals;
	}

	/**
	 * @param ownResource
	 * @return
	 */
	private ECrossReferenceAdapter getCrossReferencer(Notifier ownResource) {
		if (ownResource == null) {
			return null;
		}
		List<Adapter> adapters = ownResource.eAdapters();
		ECrossReferenceAdapter crossReferencer = null;
		for (Adapter adapter : adapters) {
			if (adapter instanceof ECrossReferenceAdapter) {
				crossReferencer = (ECrossReferenceAdapter) adapter;
				break;
			}
		}
		if (crossReferencer == null) {
			crossReferencer = new ECrossReferenceAdapter();
			ownResource.eAdapters().add(crossReferencer);
		}
		return crossReferencer;
	}

	/**
	 * @param removal
	 * @return
	 * @throws RefSpecInterpretationException in case an error occurs while resolving the removals
	 */
	@SuppressWarnings("unchecked")
	private List<EObject> resolveRemovals(ObjectRemoval removal) throws RefSpecInterpretationException {
		List<EObject> removals = new LinkedList<EObject>();
		if (removal instanceof RoleRemoval) {
			assignedRole = ((RoleRemoval) removal).getRole();
			if (assignedRole.getModifier().contains(RoleModifier.INPUT)) {
				List<EObject> boundElements = roleBindings.get(assignedRole);
				for (EObject eObject : boundElements) {
					List<Role> mappedRoles = mapping.getMappedRolesForEObject(eObject);
					if (mappedRoles != null && mappedRoles.contains(assignedRole)) {
						removals.add(eObject);
					}
				}
				runtimeValue = removals;
			} else {
				throw new UnsupportedOperationException("Handle the other modifiers");
			}
		} else if (removal instanceof VariableReference) {
			Variable variable = ((VariableReference) removal).getVariable();
			Object object = context.getObjectForVariable(variable);
			if (object instanceof EObject) {
				removals.add((EObject) object);
			} else if (object instanceof List<?>) {
				removals.addAll((List<EObject>) object);
			}
		} else if (removal instanceof ConstantsReference) {
			ConstantsReference constantsReference = (ConstantsReference) removal;
			Constants constant = constantsReference.getReferencedConstant();
			switch (constant) {
			case INPUT:
				Role inputRole = RoleUtil.determineInputRole(roleBindings, constantsReference);
				if(inputRole == null){
					throw new RefSpecInterpretationException("Unique qualifier role couldn't be determined");
				} else {
					removals.addAll(roleBindings.get(inputRole));
				}
			default:
				break;
			}
		} else if (removal instanceof CollaborationReference) {
			MultiplicityCollaboration collaboration = ((CollaborationReference) removal).getCollaboration();
			EObject interpretationContext = collaboration.getInterpretationContext();
			Object resolvedContext = resolveInterpretationContext(interpretationContext);
			if (interpretationContext instanceof Role) {
				if (resolvedContext instanceof EObject) {
					List<EObject> containedElements = collectRemovals(
							collaboration, (Role) interpretationContext,
							(EObject) resolvedContext);
					if (containedElements != null) {
						removals.addAll(containedElements);
					}
				} else if (resolvedContext instanceof List<?>) {
					List<EObject> objects = (List<EObject>) resolvedContext;
					for (EObject eObject : objects) {
						List<EObject> containedElements = collectRemovals(
								collaboration, (Role) interpretationContext,
								eObject);
						if (containedElements != null) {
							removals.addAll(containedElements);
						}
					}
				}
			} else {
				throw new UnsupportedOperationException("implement this case");
			}
		}
		return removals;
	}

	/**
	 * @param collaboration
	 * @param role
	 * @param root
	 */
	private List<EObject> collectRemovals(MultiplicityCollaboration collaboration, Role role, EObject root) {
		List<EObject> removals = new LinkedList<EObject>();
		ConcreteMapping concreteMapping = mapping.getConcreteMappingForRole(role);
		CollaborationMapping collaborationMapping = concreteMapping.getCollaborationMappingForCollaboration(collaboration);
		List<ReferenceMetaClassPair> pairs = collaborationMapping.getReferenceMetaClassPair();
		Role targetRole = collaboration.getTarget();
		List<EObject> children = referencesForEObject(root, pairs, targetRole);
		if (children != null) {
			for (EObject eObject : children) {
				if (eObject != null) {
					removals.add(eObject);
				}
			}
			return removals;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private List<EObject> referencesForEObject(EObject root, List<ReferenceMetaClassPair> pairs, Role filter) {
		if (pairs == null) {
			return null;
		} else {
			if (pairs.size() == 1) {
				List<EObject> containments = new LinkedList<EObject>();
				Object children = root.eGet(pairs.get(0).getReference(), true);
				if (children instanceof EObject) {
					containments.add((EObject) children);
				} else if (children instanceof List<?>) {
					containments.addAll((List<EObject>) children);
				}
				return RoleUtil.filterObjectsByRoles(containments, mapping,
						filter);
			} else {
				List<ReferenceMetaClassPair> reducedPairs = new LinkedList<ReferenceMetaClassPair>();
				for (int i = 1; i < pairs.size(); i++) {
					reducedPairs.add(pairs.get(i));
				}
				ReferenceMetaClassPair pair = pairs.get(0);
				Object newRoot = root.eGet(pair.getReference());
				if (newRoot instanceof EObject) {
					return referencesForEObject((EObject) newRoot,
							reducedPairs, filter);
				} else if (newRoot instanceof List<?>) {
					List<EObject> newRoots = (List<EObject>) newRoot;
					List<EObject> objectCollection = new LinkedList<EObject>();
					for (EObject eObject : newRoots) {
						objectCollection.addAll(referencesForEObject(eObject,
								reducedPairs, filter));
					}
					return objectCollection;
				}
			}
		}
		return null;
	}

	private Object resolveInterpretationContext(EObject interpretationContext) {
		if (interpretationContext instanceof Variable) {
			return context.getObjectForVariable((Variable) interpretationContext);
		} else if (interpretationContext instanceof Role) {
			Role role = (Role) interpretationContext;
			if (role.getModifier().contains(RoleModifier.INPUT)) {
				List<EObject> filteredSelection = roleBindings.get(role);
				assignedRole = role;
				runtimeValue = filteredSelection;
				return filteredSelection;
			} else {
				throw new UnsupportedOperationException("implement this case");
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public Role getAssignedRole() {
		return assignedRole;
	}

	/**
	 * @return
	 */
	public Object getRoleRuntimeValue() {
		return runtimeValue;
	}

}
