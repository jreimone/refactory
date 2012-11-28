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

public class XwpfDefaultHoverTextProvider implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfHoverTextProvider {
	
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject) {
		return getHoverText(referencedObject);
	}
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		if (object == null) {
			return null;
		}
		org.eclipse.emf.ecore.EClass eClass = object.eClass();
		String label = "<strong>" + eClass.getName() + "</strong>";
		String documentation = org.eclipse.emf.ecore.util.EcoreUtil.getDocumentation(eClass);
		String documentationHTML = documentation == null ? "" : " (" + documentation +")";
		label += documentationHTML;
		for (org.eclipse.emf.ecore.EAttribute attribute : eClass.getEAllAttributes()) {
			Object value = null;
			try {
				value = object.eGet(attribute);
			} catch (Exception e) {
				// Exception in eGet, do nothing
			}
			if (value != null && value.toString() != null && !value.toString().equals("[]")) {
				label += "<br />" + attribute.getName() + ": " + object.eGet(attribute).toString();
			}
		}
		return label;
	}
	
}
