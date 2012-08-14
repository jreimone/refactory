/**
 */
package org.emftext.refactoring.smell.core.ui;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.part.ViewPart;
import org.emftext.refactoring.smell.core.ModelSmell;
import org.emftext.refactoring.smell.core.Quality;
import org.emftext.refactoring.smell.core.impl.ModelSmellModelImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 */
public class View  extends ViewPart {
	
	private EList<View_Quality> qualityCompositeList;
	private EList<View_ModelSmell> modelSmellCompositeList;
	private ToolBar buttonBar;
	private ToolItem start;
	private ToolItem load;
	private Label language;
	private TabFolder qualitySmellTab;
	private ScrolledComposite qualitiesScrolledComposite;
	private Composite qualities;
	private ScrolledComposite smellsScrolledComposite;
	private Composite smells;
	private Composite smellTreeComposite;
	private View_Tree smellTree;
	private DirectoryDialog loadDialog;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */

	public View() {
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
		//Color grey = new Color(device, 205, 205, 205);
		
		GridLayout parentForm = new GridLayout();
		parent.setLayout(parentForm);
		
		//ToolBar
		buttonBar = new ToolBar(parent, SWT.FLAT | SWT.RIGHT);
		GridData buttonBarGridData = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		buttonBar.setLayoutData(buttonBarGridData);
	    start = new ToolItem(buttonBar, SWT.PUSH);
	    load = new ToolItem(buttonBar, SWT.PUSH);
		Image image_start = null;
		Image image_load = null;
    	image_start = new Image(device, View.class.getResourceAsStream(("/org/emftext/refactoring/smell/core/ui/start.gif")));
        image_load = new Image(device, View.class.getResourceAsStream(("/org/emftext/refactoring/smell/core/ui/load.gif")));
        start.setImage(image_start);
        load.setImage(image_load);
        start.setToolTipText("Start search");
        load.setToolTipText("Load resource");
	    buttonBar.pack();
	    load.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				loadDialog = new DirectoryDialog(Display.getCurrent().getActiveShell(), SWT.NULL);
				loadDialog.setText("Load Resource");
				loadDialog.setMessage("Select a directory");
				loadDialog.setFilterPath("C:/");
				String path = loadDialog.open();
				System.out.println(path);
				ModelSmellModelImpl.getMain().setLoadedResourcePath(path);
				//TODO Sprache setzen
				language.setText("");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	    start.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				ModelSmellModelImpl.getMain().calculate();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	    
	    //Language Label
	    GridData languageLabelGridData = new GridData(SWT.CENTER, SWT.TOP, true, false, 1, 1);
	    language = new Label(parent, SWT.NULL);
	    language.setText("");
	    language.setLayoutData(languageLabelGridData);
		
		EList<Quality> qualitiesList = ModelSmellModelImpl.getMain().getQualities();
		EList<ModelSmell> smellList = ModelSmellModelImpl.getMain().getModelSmells();
		
		//Qualities and Smells Tab
		qualitySmellTab = new TabFolder(parent, SWT.NULL);
		GridData qualitySmellTabGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		qualitySmellTab.setLayoutData(qualitySmellTabGridData);
		TabItem qualityTabItem = new TabItem(qualitySmellTab, SWT.NULL);
		qualityTabItem.setText("Qualities");
		TabItem smellTabItem = new TabItem(qualitySmellTab, SWT.NULL);
		smellTabItem.setText("Smells");
		qualitySmellTab.setLayout(new GridLayout());
		
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
		modelSmellCompositeList = new BasicEList<View_ModelSmell>();
		for (int i = 0; i < smellList.size(); i++){
			View_ModelSmell temp = addModelSmell(smells, smellList.get(i).getName());
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
		qualities.setBackground(white);
		qualityCompositeList = new BasicEList<View_Quality>();
		for (int i = 0; i < qualitiesList.size(); i++){
			View_Quality temp = addQuality(qualities, qualitiesList.get(i).getName(), 100);
			qualityCompositeList.add(temp);
		}
		qualitiesScrolledComposite.setContent(qualities);
		qualitiesScrolledComposite.setMinSize(qualities.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		qualityTabItem.setControl(qualitiesScrolledComposite);
		smellTabItem.setControl(smellsScrolledComposite);
		
		//Smelltree
		smellTreeComposite = new Composite(parent, SWT.BORDER);
		GridData smellTreeGridData = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1);
		smellTreeComposite.setLayoutData(smellTreeGridData);
		smellTreeComposite.setLayout(new FillLayout());
		smellTreeComposite.setVisible(false);
		
		smellTree = new View_Tree(smellTreeComposite);
		
		parent.setBackground(qualitySmellTab.getBackground());
		parent.pack();
	}
	
	private View_Quality addQuality(Composite parent, String name, int factor){
		View_Quality temp = new View_Quality(parent, name, factor);
		return temp;
	}
	
	private View_ModelSmell addModelSmell(Composite parent, String name){
		View_ModelSmell temp = new View_ModelSmell(parent, name);
		return temp;
	}

	@Override
	public void setFocus() {
	}
	
} //ViewImpl
