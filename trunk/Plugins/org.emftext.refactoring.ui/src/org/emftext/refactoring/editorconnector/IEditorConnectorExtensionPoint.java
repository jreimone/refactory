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

public interface IEditorConnectorExtensionPoint {

	public static final String ID 									= "org.emftext.refactoring.editorconnector";
	public static final String CONNECTOR_ATTRIBUTE 					= "editorconnector";
	public static final String EXTENSIONS_ATTRIBUTE					= "fileExtensions";
	public static final String EXTENSION_EDITOR_MAPPING				= "extensionToEditorMapping";
	public static final String EXTENSION_EDITOR_MAPPING_EXTENSION	= "extension";
	public static final String EXTENSION_EDITOR_MAPPING_EDITOR_ID	= "editorID";
}
