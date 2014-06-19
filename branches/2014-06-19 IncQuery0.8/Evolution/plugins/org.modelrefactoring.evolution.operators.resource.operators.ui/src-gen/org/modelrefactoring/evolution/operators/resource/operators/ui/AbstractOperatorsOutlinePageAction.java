/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractOperatorsOutlinePageAction extends Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageTreeViewer treeViewer;
	
	public AbstractOperatorsOutlinePageAction(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		ImageDescriptor descriptor = org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
