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
