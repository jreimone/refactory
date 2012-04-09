/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.editorconnector.topcased;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.SemanticModelBridge;
import org.topcased.modeler.editor.Modeler;

public class TopcasedEditorConnector implements IEditorConnector {

	private EditingDomain editingDomain;
	private Resource resource;
	
	public TopcasedEditorConnector() {
	}

	public boolean canHandle(IEditorPart editor) {
		if(editor instanceof Modeler){
			editingDomain = ((Modeler) editor).getEditingDomain();
			return true;
		}
//		ISelection selection = editor.getEditorSite().getSelectionProvider().getSelection();
//		if(selection instanceof StructuredSelection){
//			Object first = ((StructuredSelection) selection).getFirstElement();
//			if(first != null && first instanceof EditPart){
//				Object model = ((EditPart) first).getModel();
//				if(model instanceof GraphElement){
//					SemanticModelBridge semanticModel = ((GraphElement) model).getSemanticModel();
//					if(semanticModel instanceof EMFSemanticModelBridge){
//						EObject element = ((EMFSemanticModelBridge) semanticModel).getElement();
//						resource = element.eResource();
//						ResourceSet resourceSet = resource.getResourceSet();
//						transactionalEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
//						return true;
//					}
//				}
//			}
//		}
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

	public EditingDomain getTransactionalEditingDomain() {
		return editingDomain;
	}

	public void selectEObjects(List<EObject> objectsToSelect) {
		// TODO Auto-generated method stub
		
	}

}
