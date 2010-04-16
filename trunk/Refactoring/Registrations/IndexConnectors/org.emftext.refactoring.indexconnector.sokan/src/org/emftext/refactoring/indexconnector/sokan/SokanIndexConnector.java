/**
 * 
 */
package org.emftext.refactoring.indexconnector.sokan;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.refactoring.indexconnector.IndexConnector;
import org.reuseware.sokan.ID;
import org.reuseware.sokan.IndexMetaData;
import org.reuseware.sokan.IndexRow;
import org.reuseware.sokan.index.util.IndexUtil;
import org.reuseware.sokan.index.util.ResourceUtil;

/**
 * @author Jan Reimann
 *
 */
public class SokanIndexConnector implements IndexConnector {

	public List<Resource> getReferencingResources(EObject referenceTarget) {
		Resource targetResource = referenceTarget.eResource();
		ResourceSet resourceSet = targetResource.getResourceSet();
		URI uri = targetResource.getURI();
		if (uri == null) {
			return null;
		}
		ID refereeID = ResourceUtil.idFrom(uri);
		if(refereeID == null){
			return null;
		}
		IndexRow row = IndexUtil.INSTANCE.getIndex(refereeID);
		if(row == null){
			return null;
		}
		IndexMetaData metaData = row.getMetaData();
		List<String> refererStrings = metaData.getMulti(InverseModelReferencesIndexer.KEY_INVERSE_REFERENCED_RESOURCES);
		for (String string : refererStrings) {
			URI refererUri = ResourceUtil.uriFrom(string);
			resourceSet.getResource(refererUri, true);
		}
//		EcoreUtil.resolveAll(resourceSet);
		List<Resource> referers = new LinkedList<Resource>();
		referers.addAll(getRealTargetObjectReferer(resourceSet, referenceTarget));
		return referers;
	}

	private Set<Resource> getRealTargetObjectReferer(ResourceSet resourceSet, EObject referenceTarget){
		EcoreUtil.resolveAll(resourceSet);
		Resource targetResource = referenceTarget.eResource();
		List<Adapter> adapters = resourceSet.eAdapters();
		ECrossReferenceAdapter crossReferencer = null;
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
		Set<Resource> referers = new LinkedHashSet<Resource>();
		Collection<Setting> referencers = crossReferencer.getInverseReferences(referenceTarget, true);
		for (Setting setting : referencers) {
			EObject referer = setting.getEObject();
			Resource resource = referer.eResource();
			if(resource == null || resource.equals(targetResource)){
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
	
}
