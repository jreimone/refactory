package org.qualitune.evolution.ui.views;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ViewPart;

public class ImplicitDependencyView extends ViewPart {

	private class ViewerLabelProvider implements ITableLabelProvider {

		@Override
		public void addListener(ILabelProviderListener listener) {
			
		}

		@Override
		public void dispose() {
			
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if(element instanceof EObject){
				EObject modelElement = (EObject) element;
				Set<EObject> children = modelChildrenMap.get(modelElement);
				if(children != null && columnIndex == 0){ // column 1
					return labelProvider.getImage(element);
				}
				if(children == null && columnIndex == 1){ // column 2
					return labelProvider.getImage(element);
				}
			}
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof EObject){
				EObject modelElement = (EObject) element;
				Set<EObject> children = modelChildrenMap.get(modelElement);
				if(children != null && columnIndex == 0){ // column 1
					return labelProvider.getText(element);
				}
				if(children == null && columnIndex == 1){ // column 2
					return labelProvider.getText(element);
				}
				if(children != null && columnIndex == 1){ // column 2
					URI uri = EcoreUtil.getURI(modelElement);
					return uri.toString();
				}
			}
			return null;
		}
	}

	private class TreeContentProvider implements ITreeContentProvider {

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			if(modelChildrenMap != null){
				return modelChildrenMap.keySet().toArray(new EObject[]{});
			}
			return new EObject[]{};
		}

		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof EObject){
				EObject model = (EObject) parentElement;
				Set<EObject> children = modelChildrenMap.get(model);
				if(children != null){
					return children.toArray(new EObject[]{});
				}
			}
			return new Object[0];
		}

		public Object getParent(Object element) {
			if(element instanceof EObject){
				EObject model = (EObject) element;
				Set<EObject> children = modelChildrenMap.get(model);
				if(children != null){
					return model;
				} 
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
	}

	public static final String ID = "org.qualitune.evolution.ui.views.ImplicitDependencyView"; //$NON-NLS-1$
	private TreeContentProvider contentProvider;
	private CLabel label;
	private static AdapterFactoryLabelProvider labelProvider;
	private TreeViewer treeViewer;
	private Map<EObject, Set<EObject>> modelChildrenMap;

	public ImplicitDependencyView() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, true));
		{
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			GridLayout gridLayout = new GridLayout(2, false);
			composite.setLayout(gridLayout);

			{
				Label lblImplicitDependenciesFrom = new Label(composite, SWT.NONE);
				lblImplicitDependenciesFrom.setText("Implicit dependencies from model:");
			}
			{
				label = new CLabel(composite, SWT.BORDER);
				label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				label.setText("");
			}
		}
		{
			Composite treeComposite = new Composite(parent, SWT.NONE);
			treeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			TreeColumnLayout tcl_treeComposite = new TreeColumnLayout();
			treeComposite.setLayout(tcl_treeComposite);
			{
				treeViewer = new TreeViewer(treeComposite, SWT.BORDER);
				Tree tree = treeViewer.getTree();
				tree.setHeaderVisible(true);
				tree.setLinesVisible(true);
				{
					TreeColumn trclmnDependentModel = new TreeColumn(tree, SWT.NONE);
					tcl_treeComposite.setColumnData(trclmnDependentModel, new ColumnPixelData(200, true, true));
					trclmnDependentModel.setText("Dependent Model");
				}
				{
					TreeColumn trclmnDependentElement = new TreeColumn(tree, SWT.NONE);
					tcl_treeComposite.setColumnData(trclmnDependentElement, new ColumnPixelData(300, true, true));
					trclmnDependentElement.setText("Dependent Element");
				}
				treeViewer.setLabelProvider(new ViewerLabelProvider());
				contentProvider = new TreeContentProvider();
				treeViewer.setContentProvider(contentProvider);
			}
		}

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
//		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
//		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	public void updateModel(Map<EObject, Set<EObject>> modelChildrenMap, Resource resource) {
		this.modelChildrenMap = modelChildrenMap;
		label.setText(labelProvider.getText(resource));
		label.setImage(labelProvider.getImage(resource));
		treeViewer.setInput(modelChildrenMap);
		treeViewer.refresh(true);
	}

}
