/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.CollaborationModifier;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleImplication;
import org.emftext.language.refactoring.roles.RoleProhibition;
import org.emftext.refactoring.roleconstraintchecker.Activator;

/**
 * @author Jan Reimann
 * 
 */
public class BasicRoleConstraintValidator extends AbstractRoleConstraintValidator {

	private static final String ROLE_CORRECT_MAPPING = "Roles are mapped correctly";
	private static final String ROLE_PROHIBITION = "Metaclass %1$s plays roles %2$s and %3$s but they have to be XOR'ed";
	private static final String ROLE_PROHIBITION_TRANSITIVE = "Metaclass %1$s plays role %2$s and metaclass %3$s plays role %4$s. "
			+ "But both roles mustn't be contained in the same inheritance tree.";
	private static final String ROLE_IMPLICATION_TRANSITIVE = "Metaclass %1$s plays role %2$s. Role %3$s must be played from a superclass of %1$s.";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.refactoring.roleconstraintchecker.IRoleConstraintValidator
	 * #validateMapping(org.emftext.language.refactoring.rolemapping.Mapping)
	 */
	public List<IStatus> validateMapping(RoleMapping mapping) {
		List<IStatus> stati = new ArrayList<IStatus>();
		EcoreUtil.resolveAll(mapping.getMappedRoleModel());
		EList<ConcreteMapping> mappings = mapping.getRoleToMetaelement();
		for (ConcreteMapping concreteMapping : mappings) {
			Role role = concreteMapping.getRole();
			EList<Collaboration> outgoings = role.getOutgoing();
			for (Collaboration collaboration : outgoings) {
				IStatus status = null;
				if (collaboration instanceof RoleProhibition) {
					status = validateProhibition((RoleProhibition) collaboration, concreteMapping.getMetaclass(), mappings);

				}
				if (collaboration instanceof RoleImplication) {
					status = validateImplication((RoleImplication) collaboration, concreteMapping.getMetaclass(), mappings);

				}
				if (status != null) {
					stati.add(status);
				}
			}
		}
		return stati;
	}

	private IStatus validateProhibition(RoleProhibition prohibition, EClass mappedEClass, EList<ConcreteMapping> mappings) {
		IStatus status = null;
		Role sourceRole = prohibition.getSource();
		Role targetRole = prohibition.getTarget();
		EClass targetEClass = getMappedEClassByRole(mappings, targetRole);
		if (!prohibition.getModifier().contains(CollaborationModifier.TRANSITIVE)) {
			if (mappedEClass.equals(targetEClass)) {
				status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, String.format(ROLE_PROHIBITION, mappedEClass.getName(), sourceRole.getName(), targetRole.getName()));
			} else {
				status = new Status(IStatus.OK, Activator.PLUGIN_ID, ROLE_CORRECT_MAPPING);
			}
		} else {
			EList<EClass> superTypesSource = mappedEClass.getEAllSuperTypes();
			EList<EClass> superTypesTarget = targetEClass.getEAllSuperTypes();
			if (superTypesSource.contains(targetEClass)
					|| superTypesTarget.contains(mappedEClass)) {
				status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, String.format(ROLE_PROHIBITION_TRANSITIVE, mappedEClass.getName(), sourceRole.getName(), targetEClass.getName(), targetRole.getName()));
			} else {
				status = new Status(IStatus.OK, Activator.PLUGIN_ID, ROLE_CORRECT_MAPPING);
			}
		}
		return status;
	}

	private IStatus validateImplication(RoleImplication implication, EClass mappedEClass, EList<ConcreteMapping> mappings) {
		IStatus status = null;
		Role sourceRole = implication.getSource();
		Role targetRole = implication.getTarget();
		EClass targetEClass = getMappedEClassByRole(mappings, targetRole);
		EList<EClass> superTypesSource = mappedEClass.getEAllSuperTypes();
		EList<EClass> superTypesTarget = targetEClass.getEAllSuperTypes();
		if (!superTypesSource.contains(targetEClass)
				&& !superTypesTarget.contains(mappedEClass)) {
			status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, String.format(ROLE_IMPLICATION_TRANSITIVE, mappedEClass.getName(), sourceRole.getName(), targetRole.getName()));
		} else {
			status = new Status(IStatus.OK, Activator.PLUGIN_ID, ROLE_CORRECT_MAPPING);
		}
		return status;
	}

	private static EClass getMappedEClassByRole(EList<ConcreteMapping> mappings, Role role) {
		for (ConcreteMapping concreteMapping : mappings) {
			if (concreteMapping.getRole().equals(role)) {
				return concreteMapping.getMetaclass();
			}
		}
		return null;
	}
}
