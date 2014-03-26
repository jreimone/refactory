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

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IEditorPart;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;

public class BasicEditorConnectorRegistry implements IEditorConnectorRegistry {

	private List<Class<IEditorConnector>> editorConnectors;
	private Map<IEditorPart, IEditorConnector> editorConnectorCache;
	private Map<IEditorPart, IEditorPart> editorEditorMappingCache;
	private Map<String, List<Class<IEditorConnector>>> fileExtensionMap;
	private Map<Class<IEditorConnector>, Map<String, String>> connectorClassToEditorIDMap;

	public BasicEditorConnectorRegistry(){
		super();
//		initialize();
	}

	public IEditorConnector getEditorConnectorForEditorPart(IEditorPart editorPart) {
		if(editorPart == null){
			return null; 
		}
//		IEditorConnector editorConnector = (IEditorConnector) editorPart.getAdapter(IEditorConnector.class);
		IEditorConnector editorConnector = (IEditorConnector) Platform.getAdapterManager().loadAdapter(editorPart, IEditorConnector.class.getName());
		return editorConnector;
	}
	
//	@SuppressWarnings("unchecked")
//	private void initialize(){
//		editorConnectors = new ArrayList<Class<IEditorConnector>>();
//		editorConnectorCache = new HashMap<IEditorPart, IEditorConnector>();
//		editorEditorMappingCache = new HashMap<IEditorPart, IEditorPart>();
//		fileExtensionMap = new HashMap<String, List<Class<IEditorConnector>>>();
//		connectorClassToEditorIDMap = new HashMap<Class<IEditorConnector>, Map<String, String>>();
//		IConfigurationElement[] elements = RegistryUtil.collectConfigurationElements(IEditorConnectorExtensionPoint.ID);
//		for (IConfigurationElement element : elements) {
//			try {
//				IEditorConnector connector = (IEditorConnector) element.createExecutableExtension(IEditorConnectorExtensionPoint.CONNECTOR_ATTRIBUTE);
//				Class<IEditorConnector> editorConnectorClass = (Class<IEditorConnector>)connector.getClass();
//				editorConnectors.add(editorConnectorClass);
//				String attribute = element.getAttribute(IEditorConnectorExtensionPoint.EXTENSIONS_ATTRIBUTE);
//				if(attribute != null){
//					String[] extensions = attribute.split(",");
//					for (String extension : extensions) {
//						extension = extension.trim();
//						List<Class<IEditorConnector>> list = fileExtensionMap.get(extension);
//						if(list == null){
//							list = new ArrayList<Class<IEditorConnector>>();
//							fileExtensionMap.put(extension, list);
//						}
//						if(!list.contains(editorConnectorClass)){
//							list.add(editorConnectorClass);
//						}
//					}
//				}
//				IConfigurationElement[] mappings = element.getChildren(IEditorConnectorExtensionPoint.EXTENSION_EDITOR_MAPPING);
//				if(mappings != null){
//					for (IConfigurationElement mappingElement : mappings) {
//						String extension = mappingElement.getAttribute(IEditorConnectorExtensionPoint.EXTENSION_EDITOR_MAPPING_EXTENSION);
//						String editorID = mappingElement.getAttribute(IEditorConnectorExtensionPoint.EXTENSION_EDITOR_MAPPING_EDITOR_ID);
//						Map<String, String> extensionToEditorID = connectorClassToEditorIDMap.get(editorConnectorClass);
//						if(extensionToEditorID == null){
//							extensionToEditorID = new HashMap<String, String>();
//							connectorClassToEditorIDMap.put(editorConnectorClass, extensionToEditorID);
//						}
//						extensionToEditorID.put(extension, editorID);
//					}
//				}
//			} catch (CoreException e) {
//				// just do not register and add an error log entry
//				RegistryUtil.log("Could not instantiate editor connector '" + element.getAttribute(IEditorConnectorExtensionPoint.CONNECTOR_ATTRIBUTE) + "'", IStatus.ERROR, e);
//			}
//		}
//	}


//	private IEditorConnector getEditorConnector(IEditorPart editorPart) {
//		IEditorConnector cachedConnector = null;
//		if(editorEditorMappingCache.get(editorPart) != null){
//			cachedConnector = editorConnectorCache.get(editorEditorMappingCache.get(editorPart));
//		} else {
//			cachedConnector = editorConnectorCache.get(editorPart);
//		}
//		if(cachedConnector != null){
//			return cachedConnector;
//		}
//		// 1. look in the specialised file extension map
//		IEditorInput editorInput = editorPart.getEditorInput();
//		if(editorInput instanceof IFileEditorInput){
//			IFileEditorInput fileEditorInput = (IFileEditorInput) editorInput;
//			String extension = fileEditorInput.getFile().getFileExtension();
//			List<Class<IEditorConnector>> list = fileExtensionMap.get(extension);
//			if(list != null && list.size() > 0){
//				for (Class<IEditorConnector> editorConnectorClass : list) {
//					IEditorConnector editorConnector = instantiateEditorConnectorClass(editorConnectorClass);
//					if(editorConnector != null && editorConnector.canHandle(editorPart)){
//						editorConnectorCache.put(editorPart, editorConnector);
//						return editorConnector;
//					}
//					// look for alternative editors
//					Map<String, String> extension2editorMap = connectorClassToEditorIDMap.get(editorConnectorClass);
//					if(extension2editorMap != null && extension2editorMap.size() > 0){
//						String editorID = extension2editorMap.get(extension);
//						IWorkbench workbench = PlatformUI.getWorkbench();
//						if(editorID != null && editorID.length() > 0 && workbench != null){
//							IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
//							if(activeWorkbenchWindow != null){
//								IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
//								try {
//									IEditorPart alternative = activePage.openEditor(fileEditorInput, editorID, false, IWorkbenchPage.MATCH_ID);
//									if(!alternative.equals(editorPart)){
//										editorEditorMappingCache.put(editorPart, alternative);
//										return getEditorConnector(alternative);
//									}
//								} catch (PartInitException e) {
//									e.printStackTrace();
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//		// 2. try registered editor connectors
//		for (Class<IEditorConnector> connectorClass : editorConnectors) {
//			IEditorConnector editorConnector = instantiateEditorConnectorClass(connectorClass);
//			if(editorConnector != null && editorConnector.canHandle(editorPart)){
//				editorConnectorCache.put(editorPart, editorConnector);
//				return editorConnector;
//			}
//		}
//		return null;
//	}
//
//	private IEditorConnector instantiateEditorConnectorClass(Class<IEditorConnector> connectorClass) {
//		IEditorConnector connector = null;
//		try {
//			connector = connectorClass.newInstance();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return connector;
//	}
}
