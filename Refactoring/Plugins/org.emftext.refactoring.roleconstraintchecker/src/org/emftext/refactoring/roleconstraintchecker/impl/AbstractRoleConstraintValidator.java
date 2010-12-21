package org.emftext.refactoring.roleconstraintchecker.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.roleconstraintchecker.Activator;
import org.emftext.refactoring.roleconstraintchecker.IRoleConstraintValidator;

public abstract class AbstractRoleConstraintValidator implements IRoleConstraintValidator{

	public AbstractRoleConstraintValidator() {
		super();
	}

	public IStatus validate(RoleMappingModel mappingModel) {
		EList<RoleMapping> mappings = mappingModel.getMappings();
		int severity = 1;
		List<IStatus> stati = new ArrayList<IStatus>();
		for (RoleMapping mapping : mappings) {
			List<IStatus> status = validateMapping(mapping);
			for (IStatus iStatus : status) {
				if (iStatus != null) {
					if (iStatus.getSeverity() > severity) {
						severity = iStatus.getSeverity();
					}
					stati.add(iStatus);
				}
			}
		}
		IStatus status = new MultiStatus(Activator.PLUGIN_ID, severity, stati.toArray(new IStatus[0]), "Role Constraint validation result", null);
		return status;
	}

}