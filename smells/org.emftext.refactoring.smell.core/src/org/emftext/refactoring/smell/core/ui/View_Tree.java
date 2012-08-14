package org.emftext.refactoring.smell.core.ui;

import java.net.URISyntaxException;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.emftext.refactoring.smell.core.ModelSmell;
import org.emftext.refactoring.smell.core.ModelSmellResult;
import org.emftext.refactoring.smell.core.Observer;
import org.emftext.refactoring.smell.core.impl.ModelSmellModelImpl;


public class View_Tree implements Observer{
	
	private Composite parent;
	private Tree tree;
	
	public View_Tree(Composite parent){
		setParent(parent);
		setTree(new Tree(parent, SWT.HIDE_SELECTION));
		ModelSmellModelImpl.getMain().register(this);
	}

	@Override
	public void update() {
		tree.setRedraw(false);
		ModelSmellResult result = ModelSmellModelImpl.getMain().getResult();
		for (ModelSmell m : result.getResult().keySet()){
			TreeItem smellItem = addTreeItem(tree, m.getName(), SWT.NONE);
			addTreeItem(smellItem, ModelSmellModelImpl.getMain().getModelSmellDescription().get(m), SWT.NONE);
			for (final EObject o : result.getResult().get(m).keySet()){
				TreeItem tempItem = addTreeItem(smellItem, o.eContainingFeature().getClass().getName(), SWT.UNDERLINE_LINK);
				tempItem.addListener(SWT.MouseDoubleClick, new Listener() {
					@Override
					public void handleEvent(Event event) {
						URI uri = EcoreUtil.getURI(o);
						java.net.URI javaURI = null;
						try {
							javaURI = new java.net.URI(uri.toFileString());
						} catch (URISyntaxException e) {
							e.printStackTrace();
						}
						IFileStore fileStore = EFS.getLocalFileSystem().getStore(javaURI);
					    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					    try {
					        IDE.openEditorOnFileStore( page, fileStore );
					    } catch ( PartInitException e ) {
					        e.printStackTrace();
					    }
					}
				});
			}
		}
		tree.setRedraw(true);
		parent.setVisible(true);
		tree.pack();
	}
	
	private TreeItem addTreeItem(Tree parent, String name, Integer style){
		TreeItem item = new TreeItem(parent, style);
		item.setText(name);
		return item;
	}
	
	private TreeItem addTreeItem(TreeItem parent, String name, Integer style){
		TreeItem item = new TreeItem(parent, style);
		item.setText(name);
		return item;
	}

	public Composite getParent() {
		return parent;
	}

	public void setParent(Composite parent) {
		this.parent = parent;
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

}
