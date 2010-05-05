/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.ObjectRemoval;
import org.emftext.language.refactoring.refactoring_specification.REMOVE;
import org.emftext.language.refactoring.refactoring_specification.RemoveModifier;
import org.emftext.language.refactoring.refactoring_specification.RoleRemoval;
import org.emftext.language.refactoring.refactoring_specification.UNUSED;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.indexconnector.IndexConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.RefactoringStatus;

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
		for (EObject removal : removals) {
			EcoreUtil.remove(removal);
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
		}
		return filteredRemovals;
	}

	/**
	 * @param removals
	 * @return
	 */
	private List<EObject> interpreteUNUSED(List<EObject> removals) {
		List<EObject> unusedRemovals = new LinkedList<EObject>();
		List<EObject> removalWithoutExternalReferences = new LinkedList<EObject>();
		for (EObject removal : removals) {
			List<Resource> removalReferences = IndexConnectorRegistry.INSTANCE.getReferencingResources(removal);
			Resource ownResource = removal.eResource();
			if (ownResource != null) {
				boolean externalReferencFound = false;
				for (Resource resource : removalReferences) {
					if (!resource.equals(ownResource)) {
						externalReferencFound = true;
						break;
					}
				}
				if (!externalReferencFound) {
					removalWithoutExternalReferences.add(removal);
				}
			} else {
				removalWithoutExternalReferences.add(removal);
			}
		}
		if (removalWithoutExternalReferences.size() > 0) {
			for (EObject removal : removalWithoutExternalReferences) {
				Resource ownResource = removal.eResource();
				if (ownResource != null) {
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
					Collection<Setting> references = crossReferencer.getInverseReferences(removal, true);
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
				} else {
					unusedRemovals.add(removal);
				}
			}
		}
		return unusedRemovals;
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
		}
		return removals;
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
