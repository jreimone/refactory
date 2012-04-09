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

	public void terminate() {
		// do nothing
	}
}
