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
package org.emftext.refactoring.editorconnector;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

/**
 * Implement this interface to provide an editor connector handling a selection within 
 * a specific editor.
 * 
 * @author jreimann
 *
 */
public interface IEditorConnector {

	/**
	 * Returns <code>true</code> if this connector can handle the given editor. This method must always
	 * be invoked before {@link IEditorConnector#handleSelection(ISelection)} and so will in the
	 * context of contributing a context menu for model refactorings here. So implementors must
	 * save the given <code>editor</code> passed in this method for their own to then access it in
	 * {@link IEditorConnector#handleSelection(ISelection)}.
	 * 
	 * @param editor
	 * @return
	 */
	public boolean canHandle(IEditorPart editor);
	
	/**
	 * This method returns the {@link EObject}s contained in the given <code>selection</code>.
	 * If you need the editor from which the selection was provided
	 * 
	 * @param selection
	 * @return
	 */
	public List<EObject> handleSelection(ISelection selection);
	
	/**
	 * Some editors, such as GMF editors, allow changes of the underlying model only if those changes 
	 * will be executed in context of its {@link EditingDomain editing domain}. So if
	 * the passed editor needs it return the editing domain here. Otherwise return <code>null</code>.
	 * 
	 * @return
	 */
	public EditingDomain getTransactionalEditingDomain();
	
	/**
	 * The {@link EObject}s which have to be selected will be passed to this method.
	 * Implementors then have to determine if it is possible to select all passed objects
	 * or, as in text editors for example, only connected objects.
	 * 
	 * @param objectsToSelect
	 */
	public void selectEObjects(List<EObject> objectsToSelect);
	
	/**
	 * Returns the model contained in the editor passed in the {@link #canHandle(IEditorPart)} method.
	 * @return
	 */
	public EObject getModel();
	
	/**
	 * Each editor has its own mechanisms for visualising the marker line. Use this method
	 * to highlight the given <code>element</code> in the editor and set the appropriate
	 * values in the given <code>marker</code>.<br><br>
	 * An appropriate value might be, e.g.:<br><br>
	 * <code>
	 * marker.setAttribute(IMarker.CHAR_START, 3);<br>
	 * marker.setAttribute(IMarker.CHAR_END, 10);
	 * </code><br><br>
	 * This would indicate that the given <code>element</code> resides from offset 3 to 10.
	 * @param element
	 * @param marker
	 */
	public void setMarkingForEObject(EObject element, IMarker marker);
	
	/**
	 * Returns the connected editor of this editor connector.
	 * @return
	 */
	public IEditorPart getEditor();
}
