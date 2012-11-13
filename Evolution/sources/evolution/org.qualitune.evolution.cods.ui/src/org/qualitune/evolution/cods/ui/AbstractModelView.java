/**
 * 
 */
package org.qualitune.evolution.cods.ui;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.qualitune.evolution.cods.creation.MegaModelChangeObserver;
import org.qualitune.evolution.cods.creation.MegaModelChangeSubject;
import org.qualitune.evolution.megamodel.cods.CODS;

/**
 * @author jreimann
 *
 */
public class AbstractModelView extends ViewPart implements MegaModelChangeObserver {
	private CODS megaModel;
	
	public static final String ID = "org.qualitune.evolution.cods.ui.MegaModelView"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table instanceModelTable;
	private TableViewer instanceModelTableViewer;
	private TableColumn tableColumnModelElement;
	private Composite composite;
	private ScrolledComposite scrolledComposite;
	
	private ModelContentProvider contentProvider;

	public AbstractModelView() {
		super();
		CODS cods = getMegaModel();
		List<Adapter> adapters = cods.eAdapters();
		for (Adapter adapter : adapters) {
			if(adapter instanceof MegaModelChangeSubject){
				((MegaModelChangeSubject) adapter).registerObserver(this, Notification.ADD);
				break;
			}
		}
	}

//	public EObject getObservableParent(){
//		return null;
//	}
//
//	public String getObservableParentToObservableFeatureName(){
//		return null;
//	}
//	
//	public Class<?> getObservableEClass(){
//		return null;
//	}
//	
//	public String getObservableDisplayFeatureName(){
//		return null;
//	}
	
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		
		composite = new Composite(scrolledComposite, SWT.NONE);
		scrolledComposite.setContent(composite);
		
		toolkit.adapt(scrolledComposite);
		toolkit.paintBordersFor(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		toolkit.adapt(composite);
		toolkit.paintBordersFor(composite);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		instanceModelTableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		instanceModelTable = instanceModelTableViewer.getTable();
		instanceModelTable.setLinesVisible(true);
		instanceModelTable.setHeaderVisible(true);
		toolkit.paintBordersFor(instanceModelTable);
		
		tableColumnModelElement = new TableColumn(instanceModelTable, SWT.NONE);
		tableColumnModelElement.setWidth(600);
		tableColumnModelElement.setText("Location");
		contentProvider = new ModelContentProvider();
		instanceModelTableViewer.setContentProvider(contentProvider);
		contentProvider.setInputModel(getContent2Display());
		instanceModelTableViewer.setInput(getContent2Display());
		instanceModelTableViewer.setLabelProvider(new ObservableModelLabelProvider());

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	public void dispose() {
		toolkit.dispose();
		super.dispose();
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
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	public CODS getMegaModel() {
		if(megaModel == null){
			URI createURI = URI.createURI("http://qualitune.org/megamodel.cods");
			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.getResource(createURI, true);
			megaModel = (CODS) resource.getContents().get(0);
		}
		return megaModel;
	}
	
	public List<? extends EObject> getContent2Display(){
		return null;
	}

	@Override
	public void megaModelChanged() {
		contentProvider.setInputModel(getContent2Display());
		instanceModelTableViewer.setInput(getContent2Display());
		instanceModelTableViewer.refresh();
//		instanceModelTableViewer.update(null, null);
//		instanceModelTable.update();
//		instanceModelTable.redraw();
//		instanceModelTable.pack(true);
	}
}
