package org.emftext.refactoring.smell.smell_model.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;
import org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl;

public class View_Quickfix implements IMarkerResolution {
	
	private String label;
    
    public View_Quickfix(String label) {
    	setLabel(label);
    }
    
    public void run(IMarker marker) {
    	ModelSmellModelImpl.getMain().getQuickfixForMarker(marker).applyChanges();
    }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}