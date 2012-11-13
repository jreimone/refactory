package org.qualitune.evolution.cods.ui;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ModelContentProvider implements IStructuredContentProvider {
	
	private List<? extends EObject> input;
	
	public Object[] getElements(Object inputElement) {
		return input.toArray(new EObject[0]);
	}
	
	public void dispose() {
	}
	
	public void setInputModel(List<? extends EObject> input){
		this.input = input;
	}
	
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		System.out.println();
	}
}