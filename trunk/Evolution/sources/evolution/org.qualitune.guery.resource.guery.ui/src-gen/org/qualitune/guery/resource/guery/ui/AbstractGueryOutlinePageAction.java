/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.ui;

public abstract class AbstractGueryOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.qualitune.guery.resource.guery.ui.GueryOutlinePageTreeViewer treeViewer;
	
	public AbstractGueryOutlinePageAction(org.qualitune.guery.resource.guery.ui.GueryOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = org.qualitune.guery.resource.guery.ui.GueryImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.qualitune.guery.resource.guery.ui.GueryUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
		org.eclipse.swt.custom.BusyIndicator.showWhile(org.eclipse.swt.widgets.Display.getCurrent(), new Runnable() {
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
			org.qualitune.guery.resource.guery.ui.GueryUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.qualitune.guery.resource.guery.ui.GueryOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.qualitune.guery.resource.guery.ui.GueryOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.qualitune.guery.resource.guery.ui.GueryOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
