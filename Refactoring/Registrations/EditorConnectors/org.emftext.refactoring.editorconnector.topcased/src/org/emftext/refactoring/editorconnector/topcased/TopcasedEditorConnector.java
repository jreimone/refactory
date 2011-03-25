package org.emftext.refactoring.editorconnector.topcased;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.SemanticModelBridge;

public class TopcasedEditorConnector implements IEditorConnector {

	private TransactionalEditingDomain transactionalEditingDomain;
	
	public TopcasedEditorConnector() {
	}

	public boolean canHandle(IEditorPart editor) {
		ISelection selection = editor.getEditorSite().getSelectionProvider().getSelection();
		if(selection instanceof StructuredSelection){
			Object first = ((StructuredSelection) selection).getFirstElement();
			if(first != null && first instanceof EditPart){
				Object model = ((EditPart) first).getModel();
				if(model instanceof GraphElement){
					SemanticModelBridge semanticModel = ((GraphElement) model).getSemanticModel();
					if(semanticModel instanceof EMFSemanticModelBridge){
						EObject element = ((EMFSemanticModelBridge) semanticModel).getElement();
						Resource eResource = element.eResource();
						ResourceSet resourceSet = eResource.getResourceSet();
						transactionalEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
						return true;
					}
				}
			}
		}
		return false;
	}

	public List<EObject> handleSelection(ISelection selection) {
		List<EObject> selectedElements = new LinkedList<EObject>();
		if(selection instanceof StructuredSelection){
			for (Object element : ((StructuredSelection) selection).toList()) {
				if(element instanceof EditPart){
					Object model = ((EditPart) element).getModel();
					if(model instanceof GraphElement){
						SemanticModelBridge semanticModel = ((GraphElement) model).getSemanticModel();
						if(semanticModel instanceof EMFSemanticModelBridge){
							EObject modelElement = ((EMFSemanticModelBridge) semanticModel).getElement();
							selectedElements.add(modelElement);
						}
					}
				}
			}
		}
		return selectedElements;
	}

	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return transactionalEditingDomain;
	}

	public void selectEObjects(List<EObject> objectsToSelect) {
		// TODO Auto-generated method stub
		
	}

}
