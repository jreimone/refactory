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

public class XwpfEObjectSelection implements org.eclipse.jface.viewers.IStructuredSelection {
	
	private final org.eclipse.emf.ecore.EObject selectedObject;
	private final boolean highlighting;
	
	public XwpfEObjectSelection(org.eclipse.emf.ecore.EObject selectedObject, boolean highlighting) {
		super();
		this.selectedObject = selectedObject;
		this.highlighting = highlighting;
	}
	
	public org.eclipse.emf.ecore.EObject getSelectedObject() {
		return selectedObject;
	}
	
	public boolean doHighlighting() {
		return highlighting;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public Object getFirstElement() {
		return selectedObject;
	}
	
	public java.util.Iterator<?> iterator() {
		return new java.util.Iterator<org.eclipse.emf.ecore.EObject>() {
			
			private boolean hasNext = true;
			
			public boolean hasNext() {
				return hasNext;
			}
			
			public org.eclipse.emf.ecore.EObject next(){
				hasNext = false;
				return selectedObject;
			}
			
			public void remove() {
			}
		};
	}
	
	public int size() {
		return 1;
	}
	
	public Object[] toArray() {
		return new Object[] {selectedObject};
	}
	
	public java.util.List<?> toList() {
		java.util.ArrayList<org.eclipse.emf.ecore.EObject> list = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		list.add(selectedObject);
		return list;
	}
	
}
