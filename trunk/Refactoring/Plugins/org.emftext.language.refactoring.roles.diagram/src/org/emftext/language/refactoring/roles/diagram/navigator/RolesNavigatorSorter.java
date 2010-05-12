package org.emftext.language.refactoring.roles.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry;

/**
 * @generated
 */
public class RolesNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof RolesNavigatorItem) {
			RolesNavigatorItem item = (RolesNavigatorItem) element;
			return RolesVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
