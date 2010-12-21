package org.emftext.language.refactoring.rolemapping.postprocessing;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.RolemappingEProblemType;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource;
import org.emftext.refactoring.roleconstraintchecker.IRoleConstraintValidator;
import org.emftext.refactoring.roleconstraintchecker.RoleConstraintValidatorFactory;

public class RoleConstraintAnalyser extends AbstractPostProcessor  {

	@Override
	public void analyse(RolemappingResource resource, RoleMappingModel model) {
		IRoleConstraintValidator validator = RoleConstraintValidatorFactory.eINSTANCE.createValidator();
		EList<RoleMapping> mappings = model.getMappings();
		for (RoleMapping mapping : mappings) {
			List<IStatus> stati = validator.validateMapping(mapping);
			for (IStatus status : stati) {
				switch (status.getSeverity()) {
				case IStatus.ERROR:
					resource.addError(status.getMessage(), RolemappingEProblemType.ANALYSIS_PROBLEM, mapping);
					break;
				case IStatus.WARNING:
					resource.addWarning(status.getMessage(), RolemappingEProblemType.ANALYSIS_PROBLEM, mapping);
					break;
				default:
					break;
				}
			}
		}
	}
}
