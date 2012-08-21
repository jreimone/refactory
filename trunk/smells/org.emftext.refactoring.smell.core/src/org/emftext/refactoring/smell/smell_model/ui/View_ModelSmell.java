package org.emftext.refactoring.smell.smell_model.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.emftext.refactoring.smell.smell_model.ModelSmell;
import org.emftext.refactoring.smell.smell_model.Observer;
import org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl;

public class View_ModelSmell implements Observer{
	
	private Composite parent;
	private String name;
	private Label modelSmellLabel_Name;

	
	public View_ModelSmell(Composite parent, String name){
		this.parent = parent;
		this.name = name;
		createNew();
	}
	
	public void createNew(){
		ModelSmellModelImpl.getMain().register(this);
		modelSmellLabel_Name = new Label(parent, SWT.LEFT);
		
		for (ModelSmell m : ModelSmellModelImpl.getMain().getModelSmellDescription().keySet()){
			if (m.getName().equals(name)){
				modelSmellLabel_Name.setText(name + ": " + ModelSmellModelImpl.getMain().getModelSmellDescription().get(m));
			}
		}
		
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

	//TODO Modelsmell ausblenden, wenn Quality = 0
	@Override
	public void update() {
		
	}

}
