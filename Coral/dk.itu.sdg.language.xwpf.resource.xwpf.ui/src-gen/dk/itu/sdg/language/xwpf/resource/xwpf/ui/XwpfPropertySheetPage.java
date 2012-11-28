/**
 * Copyright 2012 
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

public class XwpfPropertySheetPage extends org.eclipse.ui.views.properties.PropertySheetPage implements org.eclipse.jface.viewers.ISelectionChangedListener {
	
	public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		selectionChanged(null, event.getSelection());
	}
	
	public void selectionChanged(org.eclipse.ui.IWorkbenchPart part, org.eclipse.jface.viewers.ISelection iSelection) {
		// This is a workaround for a bug in EMF (see
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=291301).Unfortunately Ed Merks
		// refuses to fix it, so we need to solve it here.
		if (iSelection instanceof dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfEObjectSelection) {
			final dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfEObjectSelection selection = (dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfEObjectSelection) iSelection;
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
