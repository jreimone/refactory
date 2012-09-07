package dk.itu.sdg.language.coral.resource.coral.ui.actions

import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.ui.texteditor.TextEditorAction;

import dk.itu.sdg.language.coral.Coral
import dk.itu.sdg.language.coral.checker.handlers.Check
import dk.itu.sdg.language.coral.resource.coral.ui.CoralEditor


class CheckAllRelations extends TextEditorAction {
	
	public CheckAllRelations() {
	}
	
	public CheckAllRelations(ResourceBundle bundle, String prefix, ITextEditor editor) {
		super(bundle, prefix, editor);
	}

	@Override
	public void run() {
		def CoralEditor coralEditor = (CoralEditor)getTextEditor()
		
		def coralModel = coralEditor.getResource().getContents().getAt(0)
		
		def relations = coralModel.getRelations()
		
		Check checker = new Check()
		checker.checkRelations(relations)		
	}

}
