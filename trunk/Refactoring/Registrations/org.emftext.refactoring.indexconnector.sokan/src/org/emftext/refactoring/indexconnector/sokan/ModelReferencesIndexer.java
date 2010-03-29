package org.emftext.refactoring.indexconnector.sokan;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
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

public class ModelReferencesIndexer implements Indexer {

	protected static final String INDEXER_ID = "org.emftext.refactoring.indexer.references";
	protected static final String KEY_REFERENCED_RESOURCES	= "REFERENCED_RESOURCES";

	private ResourceSet resourceSet;


	public ModelReferencesIndexer() {
		// TODO Auto-generated constructor stub
	}

	public void createIndex(URI artifactURI, IndexMetaData metaData, ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		Resource resource = null;
		try {
			resource = resourceSet.getResource(artifactURI, true);	
		} catch (Exception e) {
			return;
		}
		if(resource == null){
			return;
		}
		EList<EObject> contents = resource.getContents();
		if(contents.size() > 0){
			EObject root = contents.get(0);
			List<String> values = collectReferences(root);
			if(values != null && values.size() > 0){
				metaData.addMultiple(KEY_REFERENCED_RESOURCES, values);
			}
		}

	}

	private List<String> collectReferences(EObject referee){
		Set<String> referers = new LinkedHashSet<String>();
		Map<EObject, Collection<Setting>> references = EcoreUtil.ExternalCrossReferencer.find(referee);
		for (EObject referer : references.keySet()) {
			//			String identification = EcoreUtil.getIdentification(referer);
			Resource resource = referer.eResource();
			if(resource != null){
				URI uri = resource.getURI();
				//			if(uri.isPlatformResource()){
				uri = resourceSet.getURIConverter().normalize(uri);
				String platformString = uri.toPlatformString(true);
				if(platformString != null){
					referers.add(platformString);
				}
			}
			//			}
		}
		return Arrays.asList(referers.toArray(new String[0]));
	}


	public void getDependent(ID artifactID, DependencyMap depMap) {
		// no dependencies
	}

}
