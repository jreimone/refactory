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
