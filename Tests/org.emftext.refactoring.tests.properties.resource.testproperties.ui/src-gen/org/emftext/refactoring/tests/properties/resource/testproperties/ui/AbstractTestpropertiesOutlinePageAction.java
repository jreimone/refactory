/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

public abstract class AbstractTestpropertiesOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewer treeViewer;
	
	public AbstractTestpropertiesOutlinePageAction(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
