package dk.itu.sdg.language.coral.resource.coral.ui

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager
import org.eclipse.jface.action.IToolBarManager
import org.eclipse.jface.action.Separator
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.viewers.DoubleClickEvent
import org.eclipse.jface.viewers.IDoubleClickListener
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants
import org.eclipse.ui.IWorkbenchPage
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE
import org.eclipse.ui.part.ViewPart;

import dk.itu.sdg.language.coral.resource.coral.ui.model.Relation
import dk.itu.sdg.language.coral.resource.coral.ui.model.RelationModel
import dk.itu.sdg.language.coral.resource.coral.ui.providers.CoralRelationContentProvider
import dk.itu.sdg.language.coral.resource.coral.ui.providers.CoralRelationLabelProvider


class CoralRelationView extends ViewPart {

	def public static final String ID = "dk.itu.sdg.language.coral.resource.coral.ui.CoralRelationView"
	
	def private Action checkAllRelations
	def private Action refresh
	def private Action doubleClickAction
	
	
	def private TreeViewer viewer;
	
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL)
		
		def CoralRelationContentProvider contentProvider = new CoralRelationContentProvider()
		
		viewer.setContentProvider(contentProvider)
		viewer.setLabelProvider(new CoralRelationLabelProvider())
		viewer.setAutoExpandLevel(2)
		
		def RelationModel model = RelationModel.getInstance()
		model.viewer = viewer
		viewer.setInput(model)
				
		makeActions()
		hookDoubleClickAction()
		contributeToActionBars()
	}

	public void refresh() {
		viewer.setAutoExpandLevel(2)
		viewer.refresh()
	}
	
//	@Override
//	public void createPartControl(Composite parent) {
//		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL)
//		viewer.setContentProvider(CoralViewContentProvider.getInstance())
//		viewer.setLabelProvider(new CoralViewContentProvider.CoralViewLabelProvider())
//		viewer.setInput(getViewSite())
//
//		makeActions();
////		hookContextMenu();
//		hookDoubleClickAction();
//		contributeToActionBars();
//	}
	
//	private void hookContextMenu() {
//		MenuManager menuMgr = new MenuManager("#PopupMenu");
//		menuMgr.setRemoveAllWhenShown(true);
//		menuMgr.addMenuListener(new IMenuListener() {
//			public void menuAboutToShow(IMenuManager manager) {
//				SampleView.this.fillContextMenu(manager);
//			}
//		});
//		Menu menu = menuMgr.createContextMenu(viewer.getControl());
//		viewer.getControl().setMenu(menu);
//		getSite().registerContextMenu(menuMgr, viewer);
//	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(checkAllRelations);
		manager.add(new Separator());
		manager.add(refresh);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(checkAllRelations);
		manager.add(refresh);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(checkAllRelations);
		manager.add(refresh);
	}

	private void makeActions() {
		checkAllRelations = new Action() {
			public void run() {
				//TODO: get all relations from coral model and check them 
			}
		};
		checkAllRelations.setText("Check All Relations");
		checkAllRelations.setToolTipText("Check All Relations");
		checkAllRelations.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement()
				
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				IDE.openEditor(page, ((Relation)obj).leftMarker)
				IDE.openEditor(page, ((Relation)obj).rightMarker);
				
				//this.showMessage("Open Editor On... "+obj.toString())
				//TODO: open Editors for this relation
			}
		};
	
		refresh = new Action() {
			public void run() {
				viewer.refresh()
			}
		};
	
		refresh.setText("Refresh View");
		refresh.setToolTipText("Refresh View");
		refresh.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
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
			viewer.getControl().getShell(),	"Coral Relation View", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
}
