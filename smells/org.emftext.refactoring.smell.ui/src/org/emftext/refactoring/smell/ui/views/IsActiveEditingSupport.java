package org.emftext.refactoring.smell.ui.views;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.SWT;
import org.emftext.refactoring.smell.Quality;

public class IsActiveEditingSupport extends EditingSupport {

	private ColumnViewer viewer;

	public IsActiveEditingSupport(ColumnViewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new CheckboxCellEditor(null, SWT.CHECK);
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		if(element instanceof Quality){
			return ((Quality) element).isActive();
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if(element instanceof Quality && value instanceof Boolean){
			((Quality) element).setActive((Boolean) value);
			viewer.update(element, null);
		}
	}

}
