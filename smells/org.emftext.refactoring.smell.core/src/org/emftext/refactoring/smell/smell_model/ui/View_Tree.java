package org.emftext.refactoring.smell.smell_model.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
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
	private Map<TreeItem, EObject> objectItemMap;
	private Map<TreeItem, RoleMapping> roleItemMap;
	private EList<IMarker> marker;
	
	public View_Tree(){
		
	}
	
	public void create(Composite parent){
		setParent(parent);
		setQuickfixes(new BasicEList<IMarker>());
		setTree(new Tree(parent, SWT.HIDE_SELECTION));
		ModelSmellModelImpl.getMain().register(this);
	}

	@Override
	public void update() {
		Display.getDefault().syncExec(new Runnable() {
			
			@Override
			public void run() {
				updateTree();
			}
		});
	}
	
	private void updateTree(){
		setobjectItemMap(new HashMap<TreeItem, EObject>());
		setRoleItemMap(new HashMap<TreeItem, RoleMapping>());
		if (tree != null){
			tree.dispose();
		}
		setTree(new Tree(parent, SWT.HIDE_SELECTION));
		tree.setRedraw(false);
		if (ModelSmellModelImpl.getMain().getLoadedResource() != null){
			resource = ModelSmellModelImpl.getMain().getLoadedResource();
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
								createMarker(m.getName(), o.eResource().getURIFragment(o).substring(2), roleItem, roleItem.getParentItem());
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
		        	createRefactoringQuickfixForTreeItem(item, item.getParentItem());
		        }
			}
		});
		tree.addTreeListener(new TreeListener() {
			
			@Override
			public void treeExpanded(TreeEvent e) {
				tree.pack();
				parent.pack();
				parent.getParent().pack();
			}
			
			@Override
			public void treeCollapsed(TreeEvent e) {
				tree.pack();
				parent.pack();
				parent.getParent().pack();
			}
		});
		
		tree.setRedraw(true);
		if (tree.getItems().length == 0){
			addTreeItem(tree, "No Smells found", SWT.NONE);
		}
		tree.getItem(0).setExpanded(true);
		if (resource != null){
			openResource();
		}
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
		String path = resource.getURI().toPlatformString(true);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
    	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    	try {
    		IDE.openEditor(page, file, true);
    	} catch ( PartInitException e ) {
    		e.printStackTrace();
    	}
	}
	
	//TODO Marker erscheinen nur im Debug Modus
	private void  createMarker(final String smell, final String location, final TreeItem item, final TreeItem parentItem){
		Path path = new Path(ModelSmellModelImpl.getMain().getLoadedResource().getURI().toPlatformString(true));
		final IResource resource = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		WorkspaceJob job = new WorkspaceJob("createMarker") {
			
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor)
					throws CoreException {
				IMarker mk = null;
				try {
					for (int i = 0; i < marker.size(); i++){
						marker.get(i).delete();
					}
					marker.clear();
					mk = resource.createMarker(IMarker.PROBLEM);
					mk.setAttribute(IMarker.MESSAGE, smell);
					mk.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
					mk.setAttribute(IMarker.LOCATION, location);
					mk.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
					mk.setAttribute(IMarker.LINE_NUMBER, 0);
					System.out.println("Marker created: " + mk.getAttribute(IMarker.MESSAGE));
					marker.add(mk);
					RefactoringQuickfix rq = createRefactoringQuickfix(item, parentItem);
					ModelSmellModelImpl.getMain().putMarkerRefactoring(mk, rq);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}
	
	private RefactoringQuickfix createRefactoringQuickfix(TreeItem item, TreeItem parentItem){
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(objectItemMap.get(parentItem).eResource(), roleItemMap.get(item)); 
    	String iconKey = "";
    	RefactoringQuickfix quickfix = new RefactoringQuickfix(objectItemMap.get(parentItem), refactorer, iconKey);
    	return quickfix;
	}
	
	private void createRefactoringQuickfixForTreeItem(TreeItem item, TreeItem parentItem){
		createRefactoringQuickfix(item, parentItem).applyChanges();
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

	public EList<IMarker> getQuickfixes() {
		return marker;
	}

	public void setQuickfixes(EList<IMarker> quickfixes) {
		this.marker = quickfixes;
	}

}
