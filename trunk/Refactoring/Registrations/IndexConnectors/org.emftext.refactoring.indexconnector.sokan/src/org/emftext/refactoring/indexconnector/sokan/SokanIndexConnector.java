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
/**
 * 
 */
package org.emftext.refactoring.indexconnector.sokan;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.refactoring.indexconnector.IndexConnector;
import org.reuseware.sokan.ID;
import org.reuseware.sokan.IndexMetaData;
import org.reuseware.sokan.IndexRow;
import org.reuseware.sokan.index.util.IndexUtil;
import org.reuseware.sokan.index.util.ResourceUtil;

/**
 * @author Jan Reimann
 */
public class SokanIndexConnector implements IndexConnector {

	public List<Resource> getReferencingResources(EObject referenceTarget) {
		Resource targetResource = referenceTarget.eResource();
		if (targetResource == null) {
			return null;
		}
		ResourceSet resourceSet = targetResource.getResourceSet();
		URI uri = targetResource.getURI();
		if (uri == null) {
			return null;
		}
		ID refereeID = ResourceUtil.idFrom(uri);
		if (refereeID == null) {
			return null;
		}
		IndexRow row = IndexUtil.INSTANCE.getIndex(refereeID);
		if (row == null) {
			return null;
		}
		IndexMetaData metaData = row.getMetaData();
		List<String> refererStrings = metaData.getMulti(InverseModelReferencesIndexer.KEY_INVERSE_REFERENCED_RESOURCES);
		List<Resource> referringResources = new ArrayList<Resource>();
		for (String string : refererStrings) {
			URI refererUri = ResourceUtil.uriFrom(ResourceUtil.idFrom(string));
			referringResources.add(resourceSet.getResource(refererUri, true));
		}
		// Test begin
//		List<EObject> referringModels = new ArrayList<EObject>();
//		referringModels.add(EcoreUtil.getRootContainer(referenceTarget, true));
//		for (Resource resource : referringResources) {
//			for (EObject referringModel : resource.getContents()) {
//				referringModels.add(referringModel);
//			}
//		}
//		Map<EObject, Collection<Setting>> crossReferences = CrossReferencer.find(referringModels);
		// Test end
		
		// EcoreUtil.resolveAll(resourceSet);
//		List<Resource> referers = new LinkedList<Resource>();
//		referers.addAll(getRealTargetObjectReferer(resourceSet, referenceTarget));
//		return referers;
		return referringResources;
	}

//	private Set<Resource> getRealTargetObjectReferer(ResourceSet resourceSet, EObject referenceTarget) {
//		EcoreUtil.resolveAll(resourceSet);
//		Resource targetResource = referenceTarget.eResource();
//		List<Adapter> adapters = resourceSet.eAdapters();
//		ECrossReferenceAdapter crossReferencer = null;
//		for (Adapter adapter : adapters) {
//			if (adapter instanceof ECrossReferenceAdapter) {
//				crossReferencer = (ECrossReferenceAdapter) adapter;
//				break;
//			}
//		}
//		if (crossReferencer == null) {
//			crossReferencer = new ECrossReferenceAdapter();
//			resourceSet.eAdapters().add(crossReferencer);
//		}
//		Set<Resource> referers = new LinkedHashSet<Resource>();
//		Collection<Setting> referencers = crossReferencer.getInverseReferences(referenceTarget, true);
//		for (Setting setting : referencers) {
//			EObject referer = setting.getEObject();
//			Resource resource = referer.eResource();
//			if (resource == null || resource.equals(targetResource)) {
//				continue;
//			}
//			URI uri = resource.getURI();
//			uri = resourceSet.getURIConverter().normalize(uri);
//			if (uri.isPlatformResource()) {
//				referers.add(resource);
//			}
//		}
//		return referers;
//	}

}
