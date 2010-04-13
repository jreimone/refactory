package org.emftext.refactoring.statistic.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.util.StringUtil;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class RefactoringStatisticView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.emftext.refactoring.statistic.views.RefactoringStatisticView";

	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	private AdapterFactoryLabelProvider labelProvider;

	class TreeObject implements IAdaptable {
		private EObject object;
		private TreeParent parent;

		public TreeObject(EObject object) {
			this.object = object;
		}
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}
		public TreeParent getParent() {
			return parent;
		}
		public Object getAdapter(Class key) {
			return null;
		}
		public EObject getObject() {
			return object;
		}
	}

	class TreeParent extends TreeObject {
		private List<TreeObject> children;

		public TreeParent(EObject object) {
			super(object);
			children = new ArrayList<TreeObject>();
		}
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}
		public TreeObject [] getChildren() {
			return (TreeObject [])children.toArray(new TreeObject[children.size()]);
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
	}

	class ViewContentProvider implements IStructuredContentProvider, 
	ITreeContentProvider {
		private TreeParent invisibleRoot;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot==null) {
					invisibleRoot = initialize();
				}
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}

		private TreeParent initialize() {
			TreeParent invisibleRoot = new TreeParent(null);
			Collection<RoleModel> roleModels = IRoleModelRegistry.INSTANCE.getAllRegisteredRoleModels();
			Map<String, Map<String, Mapping>> nsUriMappingsMap = IRoleMappingRegistry.INSTANCE.getRoleMappingsMap();
			Collection<Map<String, Mapping>> mappingsMap = nsUriMappingsMap.values();
			Map<RoleModel, List<Mapping>> mappings = new HashMap<RoleModel, List<Mapping>>();
			for (Map<String, Mapping> map : mappingsMap) {
				for (Mapping mapping : map.values()) {
					List<Mapping> roleModelMappings = mappings.get(mapping.getMappedRoleModel());
					if(roleModelMappings == null){
						roleModelMappings = new ArrayList<Mapping>();
						mappings.put(mapping.getMappedRoleModel(), roleModelMappings);
					}
					roleModelMappings.add(mapping);
				}
			}
			for (RoleModel roleModel : roleModels) {
				RefactoringSpecification refSpec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(roleModel);
				if(refSpec != null){
					TreeParent modelParent = new TreeParent(roleModel);
					invisibleRoot.addChild(modelParent);
					List<Mapping> roleModelMappings = mappings.get(roleModel);
					List<Mapping> uniqueMappings = new ArrayList<Mapping>();
					for (Mapping mapping : roleModelMappings) {
						if(!uniqueMappings.contains(mapping)){
							TreeObject mappingChild = new TreeObject(mapping);
							modelParent.addChild(mappingChild);
							uniqueMappings.add(mapping);
						}
					}
				}
			}
			return invisibleRoot;
		}
	}

	class ViewLabelProvider implements ITableLabelProvider{

		public Image getColumnImage(Object element, int columnIndex) {
			if(element instanceof TreeObject){
				TreeObject object = (TreeObject) element;
				EObject eObject = object.getObject();
				switch (columnIndex) {
				case 0: // Refactoring
					return labelProvider.getImage(eObject);
				case 1: // Metamodel
					if(eObject instanceof Mapping){
						EPackage metamodel = ((Mapping) eObject).getOwningMappingModel().getTargetMetamodel();
						return labelProvider.getImage(metamodel);
					}
					return null;
				default:
					return null;
				}
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof TreeObject){
				TreeObject object = (TreeObject) element;
				EObject eObject = object.getObject();
				switch (columnIndex) {
				case 0: // Refactoring
					if(eObject instanceof RoleModel){
						return StringUtil.convertCamelCaseToWords(((RoleModel) eObject).getName());
					} else if(eObject instanceof Mapping){
						return StringUtil.convertCamelCaseToWords(((Mapping) eObject).getName());
					}
					return "";
				case 1: // Metamodel
					if(eObject instanceof Mapping){
						EPackage metamodel = ((Mapping) eObject).getOwningMappingModel().getTargetMetamodel();
						return metamodel.getNsURI();
					}
					return "";
				default:
					return "";
				}
			}
			return null;
		}

		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		public void dispose() {
			// TODO Auto-generated method stub

		}

		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

	}

	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public RefactoringStatisticView() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);

		Tree tree = viewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
		column1.setWidth(200);
		column1.setText("Refactoring");
		TreeColumn column2 = new TreeColumn(tree, SWT.LEFT);
		column2.setWidth(400);
		column2.setText("Metamodel");

		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				RefactoringStatisticView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
				viewer.getControl().getShell(),
				"Refactoring Statistics",
				message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}