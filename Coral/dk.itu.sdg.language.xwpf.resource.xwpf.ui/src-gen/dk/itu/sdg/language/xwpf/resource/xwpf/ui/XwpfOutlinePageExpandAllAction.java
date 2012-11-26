/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

public class XwpfOutlinePageExpandAllAction extends dk.itu.sdg.language.xwpf.resource.xwpf.ui.AbstractXwpfOutlinePageAction {
	
	public XwpfOutlinePageExpandAllAction(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
