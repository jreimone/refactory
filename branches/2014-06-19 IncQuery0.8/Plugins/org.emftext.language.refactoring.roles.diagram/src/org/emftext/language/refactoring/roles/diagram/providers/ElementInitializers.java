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
package org.emftext.language.refactoring.roles.diagram.providers;

import org.emftext.language.refactoring.roles.Multiplicity;
import org.emftext.language.refactoring.roles.RoleAssociation;
import org.emftext.language.refactoring.roles.RoleComposition;
import org.emftext.language.refactoring.roles.RolesFactory;
import org.emftext.language.refactoring.roles.diagram.part.RolesDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public void init_RoleAssociation_4003(RoleAssociation instance) {
		try {
			Multiplicity newInstance_0_0 = RolesFactory.eINSTANCE.createMultiplicity();
			instance.setSourceMultiplicity(newInstance_0_0);
			newInstance_0_0.setLowerBound(1);
			newInstance_0_0.setUpperBound(1);

			Multiplicity newInstance_1_0 = RolesFactory.eINSTANCE.createMultiplicity();
			instance.setTargetMultiplicity(newInstance_1_0);
			newInstance_1_0.setLowerBound(1);
			newInstance_1_0.setUpperBound(1);

		} catch (RuntimeException e) {
			RolesDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_RoleComposition_4004(RoleComposition instance) {
		try {
			Multiplicity newInstance_0_0 = RolesFactory.eINSTANCE.createMultiplicity();
			instance.setSourceMultiplicity(newInstance_0_0);
			newInstance_0_0.setLowerBound(1);
			newInstance_0_0.setUpperBound(1);

			Multiplicity newInstance_1_0 = RolesFactory.eINSTANCE.createMultiplicity();
			instance.setTargetMultiplicity(newInstance_1_0);
			newInstance_1_0.setLowerBound(1);
			newInstance_1_0.setUpperBound(1);

		} catch (RuntimeException e) {
			RolesDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = RolesDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			RolesDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}

}
