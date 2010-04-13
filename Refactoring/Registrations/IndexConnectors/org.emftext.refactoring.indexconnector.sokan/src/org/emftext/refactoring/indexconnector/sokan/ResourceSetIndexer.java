package org.emftext.refactoring.indexconnector.sokan;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.reuseware.sokan.ID;
import org.reuseware.sokan.IndexMetaData;
import org.reuseware.sokan.index.DependencyMap;
import org.reuseware.sokan.index.indexer.Indexer;

public class ResourceSetIndexer implements Indexer {

	public static Map<URI, ResourceSet> resourceSetMap = new LinkedHashMap<URI, ResourceSet>();
	
	public ResourceSetIndexer() {
		// TODO Auto-generated constructor stub
	}
	
	public void createIndex(URI artifactURI, IndexMetaData metaData, ResourceSet resourceSet) {
		try{
			ResourceSet uniqueRs = resourceSetMap.get(artifactURI);
			if(uniqueRs == null){
				resourceSetMap.put(artifactURI, resourceSet);
				uniqueRs = resourceSetMap.get(artifactURI);
			}
			Resource resource = uniqueRs.getResource(artifactURI, true);
			if(resource == null){
				resource = uniqueRs.createResource(artifactURI);
			}
			Map<EObject, Collection<Setting>> references = EcoreUtil.ExternalCrossReferencer.find(resource);
			if(references != null){
				for (EObject reference : references.keySet()) {
					Resource referenceResource = reference.eResource();
					URI referenceURI = referenceResource.getURI();
					if(!referenceURI.isPlatformResource()){
						referenceURI = URI.createPlatformResourceURI(referenceURI.toString(), true);
					}
					ResourceSet uniqueReferenceRs = resourceSetMap.get(referenceURI);
					if(referenceURI.isPlatformResource()){
						if(uniqueReferenceRs == null){
							uniqueRs.getResources().add(referenceResource);
							resourceSetMap.put(referenceURI, uniqueRs);
						} else {
							uniqueReferenceRs.getResources().add(resource);
							resourceSetMap.put(artifactURI, uniqueReferenceRs);
//							uniqueRs.getResources().addAll(uniqueReferenceRs.getResources());
//							resourceSetMap.put(referenceURI, uniqueRs);
						}
					}
				}
			}
		} catch (Exception e) {
			// just do nothing
			System.out.println( artifactURI + " couldn't be indexed because of the following exception: " + e.getMessage());
		}
	}

	public void getDependent(ID artifactID, DependencyMap depMap) {
		// TODO Auto-generated method stub

	}

}
