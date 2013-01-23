package org.modelrefactoring.ecoretools.additions;

import org.eclipse.e4.core.contexts.Active;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.internal.e4.compatibility.CompatibilityEditor;

@SuppressWarnings("restriction")
public class ModifyFillColorHandler {

	private EcoreDiagramEditor editor;

	@CanExecute
	public boolean checkEcoreDiagramEditor(@Active MPart activePart){
		CompatibilityEditor compatibilityEditor = (CompatibilityEditor) activePart.getObject();
		IEditorPart editor = compatibilityEditor.getEditor();
		if(editor instanceof EcoreDiagramEditor){
			this.editor = (EcoreDiagramEditor) editor;
			return true;
		}
		return false;
	}
	
	@Execute
	public void fillColorsOfEClasses(@Active MPart activePart){
		final Diagram diagram = editor.getDiagram();
		TransactionalEditingDomain editingDomain = editor.getEditingDomain();
		RecordingCommand command = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				@SuppressWarnings("unchecked")
				EList<View> visibleChildren = diagram.getVisibleChildren();
				for (View child : visibleChildren) {
					if(child instanceof Node){
						Node node = (Node) child;
						FillStyle fillStyle = (FillStyle) node.getStyle(NotationPackage.Literals.FILL_STYLE);
						// white
						fillStyle.setFillColor(16777215);
					}
				}
			}
		};
		editingDomain.getCommandStack().execute(command);
	}
}
