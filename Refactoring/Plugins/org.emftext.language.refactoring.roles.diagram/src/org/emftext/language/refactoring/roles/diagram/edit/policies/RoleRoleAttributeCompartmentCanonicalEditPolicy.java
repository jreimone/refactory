package org.emftext.language.refactoring.roles.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAttributeEditPart;
import org.emftext.language.refactoring.roles.diagram.part.RolesDiagramUpdater;
import org.emftext.language.refactoring.roles.diagram.part.RolesNodeDescriptor;
import org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry;

/**
 * @generated
 */
public class RoleRoleAttributeCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = RolesDiagramUpdater
				.getRoleAttributeCompartment_7001SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result.add(((RolesNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = RolesVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case RoleAttributeEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(RolesPackage.eINSTANCE
					.getRole_Attributes());
		}
		return myFeaturesToSynchronize;
	}

}
