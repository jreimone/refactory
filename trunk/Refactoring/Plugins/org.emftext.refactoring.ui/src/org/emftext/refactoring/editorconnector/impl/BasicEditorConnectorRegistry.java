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

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.IEditorPart;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorExtensionPoint;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicEditorConnectorRegistry implements IEditorConnectorRegistry {

	private List<IEditorConnector> editorConnectors;
	private Map<IEditorPart, IEditorConnector> editorConnectorCache;
	
	public BasicEditorConnectorRegistry(){
		super();
		initialize();
	}
	
	private void initialize(){
		editorConnectors = new LinkedList<IEditorConnector>();
		editorConnectorCache = new LinkedHashMap<IEditorPart, IEditorConnector>();
		IConfigurationElement[] elements = RegistryUtil.collectConfigurationElements(IEditorConnectorExtensionPoint.ID);
		for (IConfigurationElement element : elements) {
			try {
				IEditorConnector connector = (IEditorConnector) element.createExecutableExtension(IEditorConnectorExtensionPoint.CONNECTOR_ATTRIBUTE);
				editorConnectors.add(connector);
			} catch (CoreException e) {
				// just do not register and add an error log entry
				RegistryUtil.log("Could not instantiate editor connector '" + element.getAttribute(IEditorConnectorExtensionPoint.CONNECTOR_ATTRIBUTE) + "'", IStatus.ERROR, e);
			}
		}
	}
	
	public IEditorConnector getEditorConnectorForEditorPart(IEditorPart editorPart) {
		IEditorConnector cachedConnector = editorConnectorCache.get(editorPart);
		if(cachedConnector != null){
			return cachedConnector;
		}
		for (IEditorConnector connector : editorConnectors) {
			if(connector.canHandle(editorPart)){
				editorConnectorCache.put(editorPart, connector);
				return connector;
			}
		}
		return null;
	}

}
