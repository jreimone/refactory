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
package org.emftext.refactoring.editorconnector.impl;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IEditorPart;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;

public class BasicEditorConnectorRegistry implements IEditorConnectorRegistry {

	public BasicEditorConnectorRegistry(){
		super();
	}

	public IEditorConnector getEditorConnectorForEditorPart(IEditorPart editorPart) {
		if(editorPart == null){
			return null; 
		}
//		IEditorConnector editorConnector = (IEditorConnector) editorPart.getAdapter(IEditorConnector.class);
		IEditorConnector editorConnector = (IEditorConnector) Platform.getAdapterManager().loadAdapter(editorPart, IEditorConnector.class.getName());
		return editorConnector;
	}
}
