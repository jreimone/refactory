/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

public class RefcompEObjectSelection implements IStructuredSelection {
	
	private final EObject selectedObject;
	
	public RefcompEObjectSelection(EObject selectedObject) {
		super();
		this.selectedObject = selectedObject;
	}
	
	public EObject getSelectedObject() {
		return selectedObject;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public Object getFirstElement() {
		return selectedObject;
	}
	
	public Iterator<?> iterator() {
		return new Iterator<EObject>() {
			
			private boolean hasNext = true;
			
			public boolean hasNext() {
				return hasNext;
			}
			
			public EObject next(){
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
	
	public List<?> toList() {
		return Collections.singletonList(selectedObject);
	}
	
}
