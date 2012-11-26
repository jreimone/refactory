/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

public class XwpfOutlinePageLexicalSortingAction extends dk.itu.sdg.language.xwpf.resource.xwpf.ui.AbstractXwpfOutlinePageAction {
	
	public XwpfOutlinePageLexicalSortingAction(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
