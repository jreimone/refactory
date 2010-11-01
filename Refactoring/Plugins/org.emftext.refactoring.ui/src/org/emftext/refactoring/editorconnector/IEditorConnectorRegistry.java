package org.emftext.refactoring.editorconnector;

import org.eclipse.ui.IEditorPart;
import org.emftext.refactoring.editorconnector.impl.BasicEditorConnectorRegistry;

/**
 * Interface and encapsulation for access to the {@link IEditorConnector} registry.
 * 
 * @author jreimann
 */
public interface IEditorConnectorRegistry {

	public static IEditorConnectorRegistry INSTANCE = new BasicEditorConnectorRegistry();
	
	/**
	 * Returns the registered {@link IEditorConnector} being able to handle (see {@link IEditorConnector#canHandle(IEditorPart)}) the given
	 * {@link IEditorPart}. 
	 * @param editorPart the <code>editorPart</code> the resulting editor connector can handle
	 * @return
	 */
	public IEditorConnector getEditorConnectorForEditorPart(IEditorPart editorPart);
	
}
