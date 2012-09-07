package dk.itu.sdg.language.coral.resource.coral.ui;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;

import dk.itu.sdg.language.coral.resource.coral.ui.actions.CheckAllRelations;
import dk.itu.sdg.language.coral.resource.coral.ui.actions.CheckRelation;

public class CoralEditorExtended extends CoralEditor {

	
	public CoralEditorExtended () {
		super();
	}
	
	protected void editorContextMenuAboutToShow(IMenuManager menu) {
		
		super.editorContextMenuAboutToShow(menu);
		
		Separator seperator = new Separator("ActionGroup");
		
		menu.add(seperator);
		addAction(menu, "CheckRelation");
		addAction(menu, "CheckAllRelations");
		menu.add(seperator);
	};
	
	@Override
	public void createActions() {
		super.createActions();
		
		
		ResourceBundle resourceBundle = new ResourceBundle() {
			public java.util.Enumeration<String> getKeys() {
				java.util.List<String> keys = new java.util.ArrayList<String>(3);
				keys.add("CheckRelation");
				keys.add("CheckAllRelations");
				return java.util.Collections.enumeration(keys);
			}
			public Object handleGetObject(String key) {
				if (key.equals("CheckRelation")) return "Check Relation";
				if (key.equals("CheckAllRelations")) return "Check All Relations";
				return null;
			}
		};
		
		
		IAction checkRelation = new CheckRelation(resourceBundle, "CheckRelation", this);
		setAction("CheckRelation", checkRelation);
		
		IAction checkAllRelations = new CheckAllRelations(resourceBundle, "CheckAllRelations", this);
		setAction("CheckAllRelations", checkAllRelations);
	}

}
