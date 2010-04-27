package org.emftext.refactoring.editorconnector;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
	 * will be executed in context of its {@link TransactionalEditingDomain editing domain}. So if
	 * the passed editor needs it return the editing domain here. Otherwise return <code>null</code>.
	 * 
	 * @return
	 */
	public TransactionalEditingDomain getTransactionalEditingDomain();
}
