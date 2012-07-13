/**
 */
package org.eclipse.emf.modelSmells.smell_model.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.modelSmells.smell_model.Quality;
import org.eclipse.emf.modelSmells.smell_model.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
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
	
	private CoolBar buttonBar;
	private CoolItem start;
	private CoolItem load;
	private TabFolder qualitySmellTab;
	private ScrolledComposite qualitiesComposite;
	private ScrolledComposite smellsComposite;
	private Composite smellTreeComposite;
	private Tree smellTree;
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
	public void create() {
		
		throw new UnsupportedOperationException();
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
		//TODO Layout anpassen (CoolBar zu groß)
		FillLayout fill = new FillLayout();
		fill.type = SWT.VERTICAL;
		parent.setLayout(fill);
		
		//CoolBar
		buttonBar = new CoolBar(parent, SWT.NULL);
		GridLayout gridBar = new GridLayout();
		gridBar.numColumns = 6;
		buttonBar.setLayout(gridBar);
		//TODO CoolItems mit Text / Icon versehen
		load = new CoolItem(buttonBar, SWT.NULL);
		load.setMinimumSize(100, 100);
		load.setText("Load...");
		start = new CoolItem(buttonBar, SWT.NULL);
		start.setText("Start");
		
		EList<Quality> qualitiesList = MainImpl.getMain().getQualities();
		
		//Qualities and Smells
		Device device = Display.getCurrent();
		Color white = new Color(device, 255, 255, 255);
		
		qualitySmellTab = new TabFolder(parent, SWT.NULL);
		TabItem qualityTabItem = new TabItem(qualitySmellTab, SWT.NULL);
		qualityTabItem.setText("Qualities");
		TabItem smellTabItem = new TabItem(qualitySmellTab, SWT.NULL);
		smellTabItem.setText("Smells");
		
		//TODO Smells anzeigen
		smellsComposite = new ScrolledComposite(qualitySmellTab, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		smellsComposite.setBackground(white);
		
		qualitiesComposite = new ScrolledComposite(qualitySmellTab, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		qualitiesComposite.setBackground(white);
		//TODO Layout anpassen (Qualitäten sind übereinander)
		RowLayout rowQuality = new RowLayout();
		rowQuality.type = SWT.VERTICAL;
		qualitiesComposite.setLayout(rowQuality);
		for (int i = 0; i < qualitiesList.size(); i++){
			addQuality(qualitiesComposite, qualitiesList.get(i).getName(), 100);
		}
		qualityTabItem.setControl(qualitiesComposite);
		smellTabItem.setControl(smellsComposite);
		
		//Smelltree
		smellTreeComposite = new Composite(parent, SWT.BORDER);
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
		//TODO Smelltree erzeugen

	}
	
	public void addTreeItem(String name){
		TreeItem item = new TreeItem(smellTree,SWT.NULL);
		item.setText("name");
	}
	
	public ViewImpl_Quality addQuality(Composite parent, String name, int factor){
		ViewImpl_Quality temp = new ViewImpl_Quality(parent, name, factor);
		return temp;
	}

	@Override
	public void setFocus() {
	}
	
} //ViewImpl
