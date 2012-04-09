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
package org.emftext.refactoring.indexconnector.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.indexconnector.IndexConnector;
import org.emftext.refactoring.indexconnector.IndexConnectorExtensionPoint;
import org.emftext.refactoring.indexconnector.IndexConnectorRegistry;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicIndexConnectorRegistry implements IndexConnectorRegistry {

	private List<IndexConnector> indexConnectors;

	public BasicIndexConnectorRegistry(){
		indexConnectors = new LinkedList<IndexConnector>();
		collectIndexConnectors();
	}

	private void collectIndexConnectors(){
		IConfigurationElement[] elements = RegistryUtil.collectConfigurationElements(IndexConnectorExtensionPoint.ID);
		for (IConfigurationElement element : elements) {
			try {
				IndexConnector connector = (IndexConnector) element.createExecutableExtension(IndexConnectorExtensionPoint.IMPLEMENTATION);
				registerConnector(connector);
			} catch (CoreException e) {
				RegistryUtil.log("Could not register " 
						+ element.getAttribute(IndexConnectorExtensionPoint.IMPLEMENTATION 
								+ " in IndexConnectorRegistry")
								, IStatus.ERROR
								, e);
			}
		}
	}

	public List<IndexConnector> getConnectors() {
		return indexConnectors;
	}

	public List<Resource> getReferencingResources(EObject referenceTarget) {
		// TODO hier wird schon null zurückgegeben, also befindet sich referenceTarget nicht in einer Resource
		List<Resource> referers = new LinkedList<Resource>();
		for (IndexConnector connector : getConnectors()) {
			List<Resource> connectorReferer = connector.getReferencingResources(referenceTarget);
			if(connectorReferer != null && connectorReferer.size() > 0){
				referers.addAll(connectorReferer);
			}
		}
		return referers;
	}

	public void registerConnector(IndexConnector connector) {
		indexConnectors.add(connector);
	}

}
