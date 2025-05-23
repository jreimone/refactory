/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.ui;

public class GueryPropertySheetPage extends org.eclipse.ui.views.properties.PropertySheetPage implements org.eclipse.jface.viewers.ISelectionChangedListener {
	
	public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		selectionChanged(null, event.getSelection());
	}
	
	public void selectionChanged(org.eclipse.ui.IWorkbenchPart part, org.eclipse.jface.viewers.ISelection iSelection) {
		// This is a workaround for a bug in EMF (see
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=291301).Unfortunately Ed Merks
		// refuses to fix it, so we need to solve it here.
		if (iSelection instanceof org.modelrefactoring.guery.resource.guery.ui.GueryEObjectSelection) {
			final org.modelrefactoring.guery.resource.guery.ui.GueryEObjectSelection selection = (org.modelrefactoring.guery.resource.guery.ui.GueryEObjectSelection) iSelection;
			final org.eclipse.emf.ecore.EObject selectedObject = selection.getSelectedObject();
			// check whether the selected object or one of its children contains a proxy which
			// is a GenXYZClass (e.g., GenFeature, GenClass, GenPackage)
			if (containsGenProxy(selectedObject)) {
				return;
			}
		}
		if (iSelection instanceof org.eclipse.jface.viewers.IStructuredSelection) {
			org.eclipse.jface.viewers.IStructuredSelection structuredSelection = (org.eclipse.jface.viewers.IStructuredSelection) iSelection;
			java.util.Iterator<?> it = structuredSelection.iterator();
			while (it.hasNext()) {
				final Object next = it.next();
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					if (containsGenProxy((org.eclipse.emf.ecore.EObject) next)) {
						return;
					}
				}
			}
		}
		// end of workaround
		super.selectionChanged(part, iSelection);
	}
	
	private boolean containsGenProxy(org.eclipse.emf.ecore.EObject selectedObject) {
		boolean isGenProxy = isGenProxy(selectedObject);
		if (isGenProxy) {
			return true;
		}
		for (org.eclipse.emf.ecore.EObject child : selectedObject.eCrossReferences()) {
			if (isGenProxy(child)) {
				return true;
			}
		}
		for (org.eclipse.emf.ecore.EObject child : selectedObject.eContents()) {
			if (containsGenProxy(child)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isGenProxy(org.eclipse.emf.ecore.EObject selectedObject) {
		boolean isGenMetaclass = isInstanceOf("org.eclipse.emf.codegen.ecore.genmodel.GenClass", selectedObject);
		isGenMetaclass |= isInstanceOf("org.eclipse.emf.codegen.ecore.genmodel.GenFeature", selectedObject);
		isGenMetaclass |= isInstanceOf("org.eclipse.emf.codegen.ecore.genmodel.GenPackage", selectedObject);
		boolean isProxy = selectedObject.eIsProxy();
		return isGenMetaclass && isProxy;
	}
	
	private boolean isInstanceOf(String className, Object object) {
		try {
			Class<?> clazz = Class.forName(className);
			return clazz.isInstance(object);
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}
