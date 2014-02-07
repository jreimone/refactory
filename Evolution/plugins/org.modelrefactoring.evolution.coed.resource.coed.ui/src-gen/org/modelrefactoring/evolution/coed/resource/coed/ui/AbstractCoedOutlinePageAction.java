/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractCoedOutlinePageAction extends Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageTreeViewer treeViewer;
	
	public AbstractCoedOutlinePageAction(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		ImageDescriptor descriptor = org.modelrefactoring.evolution.coed.resource.coed.ui.CoedImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.modelrefactoring.evolution.coed.resource.coed.ui.CoedOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
