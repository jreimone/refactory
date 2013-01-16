/**
 */
package org.emftext.refactoring.smell.smell_model.ui;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.ViewPart;
import org.emftext.refactoring.smell.smell_model.ModelSmell;
import org.emftext.refactoring.smell.smell_model.Quality;
import org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl;


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
//	private ToolBar buttonBar;
//	private ToolItem start;
//	private ToolItem load;
	private View_Label language;
	private TabFolder qualitySmellTab;
	private ScrolledComposite qualitiesScrolledComposite;
	private Composite qualities;
	private ScrolledComposite smellsScrolledComposite;
	private Composite smells;
	private Composite smellTreeComposite;
	private View_Tree smellTree;
//	private FileDialog fileDialog;
	private Composite parentComposite;
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
		this.parentComposite = parent;
		Device device = Display.getCurrent();
		Color white = new Color(device, 255, 255, 255);
		
		GridLayout parentGridLayout = new GridLayout();
		this.parentComposite.setLayout(parentGridLayout);
	    
	    //Language Label
	    GridData languageLabelGridData = new GridData(SWT.CENTER, SWT.TOP, true, false, 1, 1);
	    language = new View_Label(this.parentComposite, SWT.NULL, "");
	    language.getLabel().setLayoutData(languageLabelGridData);
		
		EList<Quality> qualitiesList = ModelSmellModelImpl.getMain().getQualities();
		EList<ModelSmell> smellList = ModelSmellModelImpl.getMain().getModelSmells();
		
		//Qualities and Smells Tab
		qualitySmellTab = new TabFolder(this.parentComposite, SWT.NULL);
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
		smellTreeComposite = new Composite(this.parentComposite, SWT.BORDER);
		GridData smellTreeGridData = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1);
		smellTreeComposite.setLayoutData(smellTreeGridData);
		smellTreeComposite.setLayout(new FillLayout());
		smellTreeComposite.setVisible(false);
		
		smellTree = new View_Tree();
		smellTree.create(smellTreeComposite);
		
		this.parentComposite.setBackground(qualitySmellTab.getBackground());
		this.parentComposite.pack();
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
