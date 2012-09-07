package dk.itu.sdg.language.coral.resource.coral.ui.actions

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection
import org.eclipse.jface.viewers.ISelection
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.ui.texteditor.TextEditorAction;

import dk.itu.sdg.language.coral.Relation;
import dk.itu.sdg.language.coral.resource.coral.ui.CoralEditor;

import dk.itu.sdg.language.coral.checker.handlers.Check


class CheckRelation extends TextEditorAction {
	
	public CheckRelation(ResourceBundle bundle, String prefix, ITextEditor editor) {
		super(bundle, prefix, editor);
	}

	@Override
	public void run() {
		def CoralEditor coralEditor = (CoralEditor)getTextEditor()
		
		def ISelection selection = coralEditor.getSelectionProvider().getSelection()

		if (selection instanceof ITextSelection) {
			def ITextSelection textSelection = (ITextSelection) selection

			def int startOffset = textSelection.getOffset()
			def elements = coralEditor.getResource().getLocationMap().getElementsAt(startOffset)
			
			for (EObject element : elements) {
				if (element instanceof Relation) {
					Relation relation = (Relation) element
					
					Check checker = new Check()
					checker.checkRelation(relation)
				}
			}
		}

		
	}

}
