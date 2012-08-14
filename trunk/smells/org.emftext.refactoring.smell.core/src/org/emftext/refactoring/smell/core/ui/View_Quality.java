package org.emftext.refactoring.smell.core.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.emftext.refactoring.smell.core.impl.ModelSmellModelImpl;


public class View_Quality{
	
	private Composite parent;
	private String name;
	private int factor;
	private Composite qualityComposite;
	private Label qualityLabel_Name;
	private Label qualityLabel_Factor;
	private Scale qualityScale;
	
	public View_Quality(Composite parent, String name, int factor){
		this.parent = parent;
		this.name = name;
		this.factor = factor;
		createNew();
	}
	
	public void createNew(){
		qualityComposite = new Composite(parent, SWT.BORDER);
		RowLayout row = new RowLayout();
		row.center = true;
		qualityComposite.setLayout(row);
		
		qualityLabel_Name = new Label(qualityComposite, SWT.LEFT);
		RowData rowData = new RowData(130,20);
		qualityLabel_Name.setLayoutData(rowData);
		qualityLabel_Name.setText(name + ": ");
		
		qualityScale = new Scale(qualityComposite, SWT.HORIZONTAL);
		qualityScale.setSelection(factor);
		//TODO Selection = 0 -> Smells ausblenden
		qualityScale.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				qualityLabel_Factor.setText(""+qualityScale.getSelection());
				String[] temp = qualityLabel_Name.getText().split(":");
				for (int i = 0; i < ModelSmellModelImpl.getMain().getQualities().size(); i++){
					if(ModelSmellModelImpl.getMain().getQualities().get(i).getName().equals(temp[0])){
						ModelSmellModelImpl.getMain().setQualityScale(ModelSmellModelImpl.getMain().getQualities().get(i), qualityScale.getSelection()/100f);
					}
				}
			}
			
			@Override
			public void mouseDown(MouseEvent e) {	
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {				
			}
		});
		qualityScale.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.keyCode == SWT.ARROW_LEFT || e.keyCode == SWT.ARROW_RIGHT || e.keyCode == SWT.ARROW_DOWN || e.keyCode == SWT.ARROW_UP){
					qualityLabel_Factor.setText(""+qualityScale.getSelection());
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		qualityScale.addTraverseListener(new TraverseListener() {
			
			@Override
			public void keyTraversed(TraverseEvent e) {
				if(e.keyCode == SWT.ARROW_LEFT || e.keyCode == SWT.ARROW_RIGHT || e.keyCode == SWT.ARROW_DOWN || e.keyCode == SWT.ARROW_UP){
					qualityLabel_Factor.setText(""+qualityScale.getSelection());
				}
			}
		});
		
		qualityLabel_Factor = new Label(qualityComposite, SWT.CENTER);
		qualityLabel_Factor.setText("   " + factor);
		
		parent.setSize(parent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		parent.layout();
	}

	public Label getQualityLabel_Name() {
		return qualityLabel_Name;
	}

	public void setQualityLabel_Name(Label qualityText_Name) {
		this.qualityLabel_Name = qualityText_Name;
	}

	public Label getQualityLabel_Factor() {
		return qualityLabel_Factor;
	}

	public void setQualityLabel_Factor(Label qualityText_Factor) {
		this.qualityLabel_Factor = qualityText_Factor;
	}

	public Scale getQualityScale() {
		return qualityScale;
	}

	public void setQualityScale(Scale qualityScale) {
		this.qualityScale = qualityScale;
	}

	public Composite getParent() {
		return parent;
	}
	
	public boolean setParent(ScrolledComposite parent){
		try {
			this.parent = parent;
		} catch (Exception e){
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFactor() {
		return factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}
	
	public Composite getQualityComposite() {
		return qualityComposite;
	}

	public void setQualityComposite(Composite qualityComposite) {
		this.qualityComposite = qualityComposite;
	}
	
	

}
