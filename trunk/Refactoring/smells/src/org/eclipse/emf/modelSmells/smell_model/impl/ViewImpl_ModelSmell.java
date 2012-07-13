package org.eclipse.emf.modelSmells.smell_model.impl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ViewImpl_ModelSmell{
	
	private Composite parent;
	private String name;
	private Label modelSmellLabel_Name;

	
	public ViewImpl_ModelSmell(Composite parent, String name){
		this.parent = parent;
		this.name = name;
		createNew();
	}
	
	public void createNew(){
		modelSmellLabel_Name = new Label(parent, SWT.LEFT);
		
		modelSmellLabel_Name.setText(name);
		modelSmellLabel_Name.setEnabled(true);
		
		parent.setSize(parent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		parent.layout();
	}

	public Label getModelSmellLabel_Name() {
		return modelSmellLabel_Name;
	}

	public void setModelSmellLabel_Name(Label modelSmellLabel_Name) {
		this.modelSmellLabel_Name = modelSmellLabel_Name;
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

}
