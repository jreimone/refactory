package org.emftext.refactoring.smell.smell_model.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.emftext.refactoring.smell.smell_model.Observer;
import org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl;

public class View_Label implements Observer {
	
	private Composite parent;
	private Label label;
	
	public View_Label(Composite parent, int style){
		setParent(parent);
		setLabel(new Label(parent, style));
		ModelSmellModelImpl.getMain().register(this);
	}
	
	public View_Label(Composite parent, int style, String text){
		setParent(parent);
		setLabel(new Label(parent, style));
		getLabel().setText(text);
		ModelSmellModelImpl.getMain().register(this);
	}

	@Override
	public void update() {
		Display.getDefault().syncExec(new Runnable() {
			
			@Override
			public void run() {
				getLabel().setText(ModelSmellModelImpl.getMain().getNamespace());
			}
		});
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Composite getParent() {
		return parent;
	}

	public void setParent(Composite parent) {
		this.parent = parent;
	}

}
