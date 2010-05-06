/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.RefactoringStatus;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 */
public class REMOVEInterpreter {

	private RefactoringInterpreter refactoringInterpreter;
	private Mapping mapping;
	private RefactoringInterpreterContext context;
	private List<? extends EObject> selection;
	private Role assignedRole;
	private Object runtimeValue;

	public REMOVEInterpreter(RefactoringInterpreter refactoringInterpreter, Mapping mapping) {
		this.mapping = mapping;
		this.refactoringInterpreter = refactoringInterpreter;
	}

	public IRefactoringStatus interpreteREMOVE(REMOVE object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.context = context;
		this.selection = selection;

		RemoveModifier modifier = object.getModifier();
		List<EObject> removals = resolveRemovals(object.getRemoval());
		if (modifier != null) {
			removals = modify(modifier, removals);
		}
		remove(removals);
		return new RefactoringStatus(IRefactoringStatus.OK);
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
			TreeIterator<Object> iterator = EcoreUtil.getAllContents(removal, true);
			boolean empty = true;
			if (iterator.hasNext()) {
				empty = false;
			}
//			while (iterator.hasNext()) {
//				Object object = (Object) iterator.next();
//				empty = false;
//			}
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
//		List<EObject> removalWithoutExternalReferences = new LinkedList<EObject>();
//		for (EObject removal : removals) {
//			List<Resource> removalReferences = IndexConnectorRegistry.INSTANCE.getReferencingResources(removal);
//			Resource ownResource = removal.eResource();
//			if (ownResource != null) {
//				boolean externalReferencFound = false;
//				for (Resource resource : removalReferences) {
//					if (!resource.equals(ownResource)) {
//						externalReferencFound = true;
//						break;
//					}
//				}
//				if (!externalReferencFound) {
//					removalWithoutExternalReferences.add(removal);
//				}
//			} else {
//				removalWithoutExternalReferences.add(removal);
//			}
//		}
//		if (removalWithoutExternalReferences.size() > 0) {
//			for (EObject removal : removalWithoutExternalReferences) {
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
					Collection<Setting> references = crossReferencer.getNonNavigableInverseReferences(removal, true);
					boolean onlyContainerReference = true;
					for (Setting setting : references) {
						EObject container = removal.eContainer();
						EStructuralFeature containingFeature = removal.eContainingFeature();
						EObject referer = setting.getEObject();
						EStructuralFeature feature = setting.getEStructuralFeature();
						if (!(container.equals(referer) && containingFeature.equals(feature))) {
							System.out.println(referer + " referes to " + removal);
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
	 */
	@SuppressWarnings("unchecked")
	private List<EObject> resolveRemovals(ObjectRemoval removal) {
		List<EObject> removals = new LinkedList<EObject>();
		if (removal instanceof RoleRemoval) {
			assignedRole = ((RoleRemoval) removal).getRole();
			if (assignedRole.getModifier().contains(RoleModifier.INPUT)) {
				for (EObject eObject : selection) {
					List<Role> mappedRoles = mapping.getMappedRolesForEObject(eObject);
					if (mappedRoles != null && mappedRoles.contains(assignedRole)) {
						removals.add(eObject);
					}
				}
				runtimeValue = removals;
			} else {
				throw new UnsupportedOperationException(
						"Handle the other modifiers");
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
			Constants constant = ((ConstantsReference) removal).getReferencedConstant();
			switch (constant) {
				case INPUT:
					removals.addAll(selection);
				default:
					break;
			}
		} else if (removal instanceof CollaborationReference) {
			MultiplicityCollaboration collaboration = ((CollaborationReference) removal).getCollaboration();
			EObject interpretationContext = collaboration.getInterpretationContext();
			Object resolvedContext = resolveInterpretationContext(interpretationContext);
			if (interpretationContext instanceof Role) {
				if (resolvedContext instanceof EObject) {
					List<EObject> containedElements = collectRemovals(collaboration, (Role) interpretationContext, (EObject) resolvedContext);
					if (containedElements != null) {
						removals.addAll(containedElements);
					}
				} else if (resolvedContext instanceof List<?>) {
					List<EObject> objects = (List<EObject>) resolvedContext;
					for (EObject eObject : objects) {
						List<EObject> containedElements = collectRemovals(collaboration, (Role) interpretationContext, eObject);
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
				return RoleUtil.filterObjectsByRoles(containments, mapping, filter);
			} else {
				List<ReferenceMetaClassPair> reducedPairs = new LinkedList<ReferenceMetaClassPair>();
				for (int i = 1; i < pairs.size(); i++) {
					reducedPairs.add(pairs.get(i));
				}
				ReferenceMetaClassPair pair = pairs.get(0);
				Object newRoot = root.eGet(pair.getReference());
				if (newRoot instanceof EObject) {
					return referencesForEObject((EObject) newRoot, reducedPairs, filter);
				} else if (newRoot instanceof List<?>) {
					List<EObject> newRoots = (List<EObject>) newRoot;
					List<EObject> objectCollection = new LinkedList<EObject>();
					for (EObject eObject : newRoots) {
						objectCollection.addAll(referencesForEObject(eObject, reducedPairs, filter));
					}
					return objectCollection;
//					throw new UnsupportedOperationException(
//							"implement this case - but this shouldn't happen because here only one EObject should be returned");
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
				List<EObject> filteredSelection = RoleUtil.filterObjectsByRoles(selection, mapping, role);
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
