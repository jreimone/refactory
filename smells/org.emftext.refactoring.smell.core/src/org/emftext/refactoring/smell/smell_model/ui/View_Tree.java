package org.emftext.refactoring.smell.smell_model.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.smell.smell_model.ModelSmell;
import org.emftext.refactoring.smell.smell_model.ModelSmellResult;
import org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping;
import org.emftext.refactoring.smell.smell_model.Observer;
import org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl;


public class View_Tree implements Observer{
	
	private Composite parent;
	private Tree tree;
	private Map<TreeItem, EObject> objectItemMap;
	private Map<TreeItem, RoleMapping> roleItemMap;
	
	public View_Tree(Composite parent){
		setParent(parent);
		setTree(new Tree(parent, SWT.HIDE_SELECTION));
		ModelSmellModelImpl.getMain().register(this);
	}

	@Override
	public void update() {
		setResourceItemMap(new HashMap<TreeItem, EObject>());
		tree.setRedraw(false);
		ModelSmellResult result = ModelSmellModelImpl.getMain().getResult();
		EList<ModelSmell_Rolemapping_Mapping> rolemapping = ModelSmellModelImpl.getMain().getModelSmell_roleMapping();
		for (ModelSmell m : result.getResult().keySet()){
			TreeItem smellItem = addTreeItem(tree, m.getName() + ": " + ModelSmellModelImpl.getMain().getModelSmellDescription().get(m), SWT.NONE);
			for (EObject o : result.getResult().get(m).keySet()){
				TreeItem objectItem = addTreeItem(smellItem, o.eResource().getURIFragment(o).substring(2), SWT.UNDERLINE_LINK);
				for (ModelSmell_Rolemapping_Mapping r : rolemapping){
					if (r.getModelSmell().equals(m)){
						for (RoleMapping rm : r.getRoleMappings()){
							TreeItem roleItem = addTreeItem(objectItem, rm.getName(), SWT.NONE);
							roleItemMap.put(roleItem, rm);
						}
					}
				}
				objectItemMap.put(objectItem, o);
			}
		}
		tree.addListener(SWT.MouseDoubleClick, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				Point point = new Point(event.x, event.y);
		        TreeItem item = tree.getItem(point);
		        if (item != null && objectItemMap.containsKey(item)) {
		        	Resource resource = objectItemMap.get(item).eResource();
		        	String path = resource.getURI().devicePath();
		        	path = path.replaceAll("%20", " ");
		        	IFileStore fileStore = EFS.getLocalFileSystem().getStore(new Path(path));
		        	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		        	try {
		        		IDE.openEditorOnFileStore( page, fileStore );
		        	} catch ( PartInitException e ) {
		        		e.printStackTrace();
		        	}
		        }
		        //TODO Rolemapping auf EObject aufrufen
		        else if (item != null && roleItemMap.containsKey(item)) {
		        	
		        }
			}
		});
		tree.setRedraw(true);
		parent.setVisible(true);
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

	public Map<TreeItem, EObject> getResourceItemMap() {
		return objectItemMap;
	}

	public void setResourceItemMap(Map<TreeItem, EObject> resourceItemMap) {
		this.objectItemMap = resourceItemMap;
	}

	public Map<TreeItem, RoleMapping> getRoleItemMap() {
		return roleItemMap;
	}

	public void setRoleItemMap(Map<TreeItem, RoleMapping> roleItemMap) {
		this.roleItemMap = roleItemMap;
	}

}
