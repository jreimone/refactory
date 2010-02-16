/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Relation;
import org.emftext.language.refactoring.roles.RelationModifier;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleProhibition;
import org.emftext.refactoring.roleconstraintchecker.Activator;
import org.emftext.refactoring.roleconstraintchecker.IRoleConstraintValidator;

/**
 * @author Jan Reimann
 *
 */
public class BasicRoleConstraintValidator implements IRoleConstraintValidator {

	private static final String ROLE_PROHIBITION = "Metaclass %1$s plays roles %2$s and %3$s but they have to be XOR'ed";
	private static final String ROLE_PROHIBITION_TRANSITIVE = "Metaclass %1$s plays role %2$s and metaclass %3$s plays role %4$s. " +
																"But both roles mustn't be contained in the same inheritance tree.";
	
	private RoleMappingModel mappingModel;
	
	public BasicRoleConstraintValidator(RoleMappingModel mappingModel){
		this.mappingModel = mappingModel;
		EcoreUtil.resolveAll(this.mappingModel);
		EList<Mapping> mappings = this.mappingModel.getMappings();
		for (Mapping mapping : mappings) {
			EcoreUtil.resolve(mapping, this.mappingModel);
			EcoreUtil.resolve(mapping.getMappedRoleModel(), this.mappingModel);
			EcoreUtil.resolveAll(mapping.getMappedRoleModel());
			EcoreUtil.resolveAll(mapping);
		}
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.roleconstraintchecker.IRoleConstraintValidator#validate()
	 */
	public IStatus validate() {
		EList<Mapping> mappings = mappingModel.getMappings();
		int severity = 1;
		List<IStatus> stati = new ArrayList<IStatus>();
		for (Mapping mapping : mappings) {
			List<IStatus> status = validateMapping(mapping);
			for (IStatus iStatus : status) {
				if(iStatus != null){
					if(iStatus.getSeverity() > severity){
						severity = iStatus.getSeverity();
					}
					stati.add(iStatus);
				}
			}
		}
		IStatus status = new MultiStatus(Activator.PLUGIN_ID
				, severity
				, stati.toArray(new IStatus[0])
				, "Role Constraint validation result"
				, null);
		return status;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.roleconstraintchecker.IRoleConstraintValidator#validateMapping(org.emftext.language.refactoring.rolemapping.Mapping)
	 */
	public List<IStatus> validateMapping(Mapping mapping) {
		if(!mappingModel.getMappings().contains(mapping)){
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The given mapping isn't part of the role mapping model of the validator.");
			List<IStatus> result = new ArrayList<IStatus>();
			result.add(status);
			return result;
		}
		EcoreUtil.resolveAll(mapping);
		List<IStatus> stati = new ArrayList<IStatus>();
		EList<ConcreteMapping> mappings = mapping.getRoleToMetaelement();
		for (ConcreteMapping concreteMapping : mappings) {
			Role role = concreteMapping.getRole();
			EList<Relation> outgoings = role.getOutgoing();
			for (Relation relation : outgoings) {
				if(relation instanceof RoleProhibition){
					IStatus status = validateProhibition((RoleProhibition) relation, concreteMapping.getMetaclass(), mappings);
					stati.add(status);
				}
			}
		}
		return stati;
	}
	
	private IStatus validateProhibition(RoleProhibition prohibition, EClass mappedEClass, EList<ConcreteMapping> mappings){
		IStatus status = null;
		Role sourceRole = prohibition.getSource();
		Role targetRole = prohibition.getTarget();
		EClass targetEClass = getMappedEClassByRole(mappings, targetRole);
		if(!prohibition.getModifier().contains(RelationModifier.TRANSITIVE)){
			if(mappedEClass.equals(targetEClass)){
				status = new Status(IStatus.ERROR
						, Activator.PLUGIN_ID
						, String.format(ROLE_PROHIBITION, mappedEClass.getName(), sourceRole.getName(), targetRole.getName()));
			}
		} else {
			EList<EClass> superTypes = mappedEClass.getEAllSuperTypes();
			if(superTypes.contains(targetEClass)){
				status = new Status(IStatus.ERROR
						, Activator.PLUGIN_ID
						, String.format(ROLE_PROHIBITION_TRANSITIVE, mappedEClass.getName(), sourceRole.getName(), targetEClass.getName(), targetRole.getName()));
			}
		}
		return status;
	}
	
	private static EClass getMappedEClassByRole(EList<ConcreteMapping> mappings, Role role){
		for (ConcreteMapping concreteMapping : mappings) {
			if(concreteMapping.getRole().equals(role)){
				return concreteMapping.getMetaclass();
			}
		}
		return null;
	}
}
