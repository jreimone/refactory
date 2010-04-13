package org.emftext.refactoring.indexconnector.sokan;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.emftext.refactoring.indexconnector.IndexConnector;

public class CrossReferenceIndexConnector implements IndexConnector {

	public List<Resource> getReferencingResources(EObject referenceTarget) {
		Resource targetResource = getIndexResource(referenceTarget);
		ResourceSet resourceSet = getIndexResourceSet(referenceTarget);
		ECrossReferenceAdapter crossReferencer = null;
		List<Adapter> adapters = resourceSet.eAdapters();
		for (Adapter adapter : adapters) {
			if(adapter instanceof ECrossReferenceAdapter){
				crossReferencer = (ECrossReferenceAdapter) adapter;
				break;
			}
		}
		if(crossReferencer == null){
			crossReferencer = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(crossReferencer);
		}
		List<Resource> referers = new LinkedList<Resource>();
		Collection<Setting> referencers = crossReferencer.getInverseReferences(referenceTarget, true);
		for (Setting setting : referencers) {
			EObject referer = setting.getEObject();
			Resource resource = getIndexResource(referer);
			if(resource.equals(targetResource)){
				continue;
			}
			URI uri = resource.getURI();
			uri = resourceSet.getURIConverter().normalize(uri);
			if(uri.isPlatformResource()){
				referers.add(resource);
			}
		}
		return referers;
	}

	private Resource getIndexResource(EObject modelElement){
		Resource targetResource = modelElement.eResource();
		URI targetUri = targetResource.getURI();
		ResourceSet resourceSet = ResourceSetIndexer.resourceSetMap.get(targetUri);
		if(resourceSet == null){
			return targetResource;
		}
		Resource temp = resourceSet.getResource(targetUri, true);
		resourceSet.getResources().remove(temp);
//		targetResource = resourceSet.getResource(targetUri, true);
		resourceSet.getResources().add(targetResource);
		return targetResource;
	}
	
	private ResourceSet getIndexResourceSet(EObject modelElement){
		Resource targetResource = modelElement.eResource();
		URI targetUri = targetResource.getURI();
		ResourceSet resourceSet = ResourceSetIndexer.resourceSetMap.get(targetUri);
		if(resourceSet == null){
			resourceSet = new ResourceSetImpl();
			resourceSet.getResources().add(targetResource);
		}
		return resourceSet;
	}
}
