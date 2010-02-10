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
	/**
	 * @generated
	 */
	public static void init_RoleAssociation_4003(RoleAssociation instance) {
		try {
			Multiplicity newInstance_0_0 = RolesFactory.eINSTANCE
					.createMultiplicity();
			instance.setSourceMultiplicity(newInstance_0_0);
			newInstance_0_0.setLowerBound(1);
			newInstance_0_0.setUpperBound(1);

			Multiplicity newInstance_1_0 = RolesFactory.eINSTANCE
					.createMultiplicity();
			instance.setTargetMultiplicity(newInstance_1_0);
			newInstance_1_0.setLowerBound(1);
			newInstance_1_0.setUpperBound(1);

		} catch (RuntimeException e) {
			RolesDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_RoleComposition_4004(RoleComposition instance) {
		try {
			Multiplicity newInstance_0_0 = RolesFactory.eINSTANCE
					.createMultiplicity();
			instance.setSourceMultiplicity(newInstance_0_0);
			newInstance_0_0.setLowerBound(1);
			newInstance_0_0.setUpperBound(1);

			Multiplicity newInstance_1_0 = RolesFactory.eINSTANCE
					.createMultiplicity();
			instance.setTargetMultiplicity(newInstance_1_0);
			newInstance_1_0.setLowerBound(1);
			newInstance_1_0.setUpperBound(1);

		} catch (RuntimeException e) {
			RolesDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

}
