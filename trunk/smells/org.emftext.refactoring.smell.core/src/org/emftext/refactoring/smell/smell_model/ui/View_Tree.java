package org.emftext.refactoring.smell.smell_model.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
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
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.smell.smell_model.ModelSmell;
import org.emftext.refactoring.smell.smell_model.ModelSmellResult;
import org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping;
import org.emftext.refactoring.smell.smell_model.Observer;
import org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl;
import org.emftext.refactoring.smell.smell_model.impl.RefactoringQuickfix;


public class View_Tree implements Observer{
	
	private Composite parent;
	private Tree tree;
	private Resource resource;
	private List<IMarker> quickfixes;
	private Map<TreeItem, EObject> objectItemMap;
	private Map<TreeItem, RoleMapping> roleItemMap;
	
	public View_Tree(){
		
	}
	
	public void create(Composite parent){
		setParent(parent);
		setTree(new Tree(parent, SWT.HIDE_SELECTION));
		ModelSmellModelImpl.getMain().register(this);
	}

	@Override
	public void update() {
		if (quickfixes != null){
			for(IMarker m : quickfixes){
				try {
					m.delete();
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		quickfixes = new ArrayList<IMarker>();
		setobjectItemMap(new HashMap<TreeItem, EObject>());
		setRoleItemMap(new HashMap<TreeItem, RoleMapping>());
		if (tree != null){
			tree.dispose();
		}
		setTree(new Tree(parent, SWT.HIDE_SELECTION));
		tree.setRedraw(false);
		if (ModelSmellModelImpl.getMain().getLoadedResourcePath() != null){
			URI fileURI = URI.createFileURI(ModelSmellModelImpl.getMain().getLoadedResourcePath());
			ResourceSet resourceSet = new ResourceSetImpl();
			resource = resourceSet.getResource(fileURI, true);
			ModelSmellResult result = ModelSmellModelImpl.getMain().getResult();
			EList<ModelSmell_Rolemapping_Mapping> rolemapping = ModelSmellModelImpl.getMain().getModelSmell_roleMapping();
			for (ModelSmell m : result.getResult().keySet()){
				TreeItem smellItem = addTreeItem(tree, m.getName() + ": " + ModelSmellModelImpl.getMain().getModelSmellDescription().get(m), SWT.NONE);
				for (EObject o : result.getResult().get(m).keySet()){
					TreeItem objectItem = addTreeItem(smellItem, o.eResource().getURIFragment(o).substring(2), SWT.UNDERLINE_LINK);
					boolean hasRoleMapping = false;
					for (ModelSmell_Rolemapping_Mapping r : rolemapping){
						if (r.getModelSmell().equals(m)){
							for (RoleMapping rm : r.getRoleMappings()){
								hasRoleMapping = true;
								TreeItem roleItem = addTreeItem(objectItem, "Recommended Refactoring: "+rm.getName(), SWT.NONE);
								roleItemMap.put(roleItem, rm);
								createQuickfix(m.getName());
							}
						}
					}
					if (!hasRoleMapping){
						addTreeItem(objectItem, "Recommended Refactoring: No Refactoring, this is only a hint", SWT.NONE);
					}
					objectItemMap.put(objectItem, o);
				}
			}
		}
		tree.addListener(SWT.MouseDoubleClick, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				Point point = new Point(event.x, event.y);
		        TreeItem item = tree.getItem(point);
		        if (item != null && roleItemMap.containsKey(item)){
		        	createRefactoringQuickfix(item);
		        }
			}
		});
		tree.addTreeListener(new TreeListener() {
			
			@Override
			public void treeExpanded(TreeEvent e) {
				tree.pack();
				parent.pack();
			}
			
			@Override
			public void treeCollapsed(TreeEvent e) {
				tree.pack();
				parent.pack();
			}
		});
		
		tree.setRedraw(true);
		if (tree.getItems().length == 0){
			addTreeItem(tree, "No Smells found", SWT.NONE);
		}
		tree.getItem(0).setExpanded(true);
		openResource();
		parent.setVisible(true);
		parent.layout();
		parent.pack();
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
	
	private void openResource(){
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
	
	private void createRefactoringQuickfix(TreeItem item){
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(objectItemMap.get(item.getParentItem()).eResource(), roleItemMap.get(item)); 
    	String iconKey = "";
    	RefactoringQuickfix quickfix = new RefactoringQuickfix(objectItemMap.get(item.getParentItem()), refactorer, iconKey);
    	quickfix.applyChanges();
    	ModelSmellModelImpl.getMain().calculate();
	}
	
	private void createQuickfix(String message){
		//TODO IResource festlegen
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember("");
		IMarker mk = null;
		try {
			mk = resource.createMarker(IMarker.PROBLEM);
			mk.setAttribute(IMarker.MESSAGE, message);
		    mk.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
		    quickfixes.add(mk);
		} catch (CoreException e) {
			e.printStackTrace();
		}
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

	public void setobjectItemMap(Map<TreeItem, EObject> resourceItemMap) {
		this.objectItemMap = resourceItemMap;
	}

	public Map<TreeItem, RoleMapping> getRoleItemMap() {
		return roleItemMap;
	}

	public void setRoleItemMap(Map<TreeItem, RoleMapping> roleItemMap) {
		this.roleItemMap = roleItemMap;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
