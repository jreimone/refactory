/**
 */
package org.eclipse.emf.modelSmells.smell_model.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.modelSmells.smell_model.ModelSmell;
import org.eclipse.emf.modelSmells.smell_model.Quality;
import org.eclipse.emf.modelSmells.smell_model.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 */
public class ViewImpl  extends ViewPart  implements View {
	
	private EList<ViewImpl_Quality> qualityCompositeList;
	private EList<ViewImpl_ModelSmell> modelSmellCompositeList;
	private ToolBar buttonBar;
	private ToolItem start;
	private ToolItem load;
	private TabFolder qualitySmellTab;
	private ScrolledComposite qualitiesScrolledComposite;
	private Composite qualities;
	private ScrolledComposite smellsScrolledComposite;
	private Composite smells;
	private Composite smellTreeComposite;
	private Tree smellTree;
	private FileDialog loadDialog;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */

	public ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void update() {
		
		throw new UnsupportedOperationException();
	}

	@Override
	public void createPartControl(Composite parent) {
		Device device = Display.getCurrent();
		Color white = new Color(device, 255, 255, 255);
//		Color grey = new Color(device, 155, 155, 155);
		
		GridLayout parentGrid = new GridLayout();
		parentGrid.numColumns = 1;
		parent.setLayout(parentGrid);
		
		//CoolBar
		buttonBar = new ToolBar(parent, SWT.FLAT | SWT.RIGHT);
		GridData buttonBarGridData = new GridData(GridData.END, GridData.END, true, false);
		buttonBar.setLayoutData(buttonBarGridData);
	    start = new ToolItem(buttonBar, SWT.PUSH);
	    load = new ToolItem(buttonBar, SWT.PUSH);
		Image image_start = null;
		Image image_load = null;
		//TODO relativer Pfad
    	image_start = new Image(device, ViewImpl.class.getResourceAsStream(("/org/eclipse/emf/modelSmells/smell_model/icons/start.gif")));
        image_load = new Image(device, ViewImpl.class.getResourceAsStream(("/org/eclipse/emf/modelSmells/smell_model/icons/load.gif")));
        start.setImage(image_start);
        load.setImage(image_load);
	    buttonBar.pack();
	    load.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				loadDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.NULL);
				loadDialog.setText("Load Resource");
				loadDialog.setFilterPath("C:/");
				//TODO Dateiendungen anpassen
				String[] filterExt = { "*.txt", "*.doc", ".rtf", "*.*" };
		        loadDialog.setFilterExtensions(filterExt);
				String path = loadDialog.open();
				MainImpl.getMain().setLoadedResourcePath(path);
				System.out.println(MainImpl.getMain().getLoadedResourcePath());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		EList<Quality> qualitiesList = MainImpl.getMain().getQualities();
		EList<ModelSmell> smellList = MainImpl.getMain().getModelSmells();
		
		//Qualities and Smells Tab
		qualitySmellTab = new TabFolder(parent, SWT.NULL);
		GridData qualitySmellTabGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		qualitySmellTab.setLayoutData(qualitySmellTabGridData);
		qualitySmellTab.setBackground(white);
		TabItem qualityTabItem = new TabItem(qualitySmellTab, SWT.NULL);
		qualityTabItem.setText("Qualities");
		TabItem smellTabItem = new TabItem(qualitySmellTab, SWT.NULL);
		smellTabItem.setText("Smells");
		
		//Smells
		smellsScrolledComposite = new ScrolledComposite(qualitySmellTab, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		GridData smellsCompositeGridData = new GridData(GridData.FILL, GridData.CENTER, true, true);
		smellsScrolledComposite.setLayoutData(smellsCompositeGridData);
		smellsScrolledComposite.setBackground(white);
		smellsScrolledComposite.setExpandHorizontal(true);
		smellsScrolledComposite.setExpandVertical(true);
		smells = new Composite(smellsScrolledComposite, SWT.NONE);
		smells.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		smells.setLayout(new GridLayout());
		smells.setBackground(white);
		modelSmellCompositeList = new BasicEList<ViewImpl_ModelSmell>();
		for (int i = 0; i < smellList.size(); i++){
			ViewImpl_ModelSmell temp = addModelSmell(smells, smellList.get(i).getName());
			temp.getModelSmellLabel_Name().setBackground(white);
			modelSmellCompositeList.add(temp);
		}
		
		//Qualities
		qualitiesScrolledComposite = new ScrolledComposite(qualitySmellTab, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		GridData qualitiesCompositeGridData = new GridData(GridData.FILL, GridData.CENTER, true, true);
		qualitiesScrolledComposite.setLayoutData(qualitiesCompositeGridData);
		qualitiesScrolledComposite.setBackground(white);
		qualitiesScrolledComposite.setExpandHorizontal(true);
		qualitiesScrolledComposite.setExpandVertical(true);
		qualities = new Composite(qualitiesScrolledComposite, SWT.NONE);
		qualities.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		qualities.setLayout(new GridLayout());
		Point size = new Point(0,0);
		qualityCompositeList = new BasicEList<ViewImpl_Quality>();
		for (int i = 0; i < qualitiesList.size(); i++){
			ViewImpl_Quality temp = addQuality(qualities, qualitiesList.get(i).getName(), 100);
			qualityCompositeList.add(temp);
			if (size.x < (temp.getQualityComposite().computeSize(SWT.DEFAULT, SWT.DEFAULT)).x){
				size.x = (temp.getQualityComposite().computeSize(SWT.DEFAULT, SWT.DEFAULT)).x;
			}
			size.y = size.y + (temp.getQualityComposite().computeSize(SWT.DEFAULT, SWT.DEFAULT)).y;
		}
		//TODO Qualitäten auf eine Größe bringen
		qualitiesScrolledComposite.setMinSize(size.x+10, size.y);
		qualitiesScrolledComposite.setContent(qualities);
		qualityTabItem.setControl(qualitiesScrolledComposite);
		smellTabItem.setControl(smellsScrolledComposite);
		
		//Smelltree
		//TODO Smelltree erzeugen
		smellTreeComposite = new Composite(parent, SWT.BORDER);
		GridData smellTreeGridData = new GridData(GridData.FILL, GridData.CENTER, true, true);
		smellTreeComposite.setLayoutData(smellTreeGridData);
		smellTreeComposite.setLayout(new FillLayout());
		
		smellTree = new Tree(smellTreeComposite, SWT.CHECK);
		smellTree.addTreeListener(new TreeListener() {
			
			@Override
			public void treeExpanded(TreeEvent e) {
				
			}
			
			@Override
			public void treeCollapsed(TreeEvent e) {
				
			}
		});
		
		parent.pack();
	}
	
	public void addTreeItem(String name){
		TreeItem item = new TreeItem(smellTree,SWT.NULL);
		item.setText("name");
	}
	
	private ViewImpl_Quality addQuality(Composite parent, String name, int factor){
		ViewImpl_Quality temp = new ViewImpl_Quality(parent, name, factor);
		return temp;
	}
	
	private ViewImpl_ModelSmell addModelSmell(Composite parent, String name){
		ViewImpl_ModelSmell temp = new ViewImpl_ModelSmell(parent, name);
		return temp;
	}

	@Override
	public void setFocus() {
	}
	
} //ViewImpl
