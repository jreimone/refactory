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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.emftext.refactoring.indexconnector.IndexConnector;

public class CrossReferenceIndexConnector implements IndexConnector {

	public List<Resource> getReferencingResources(EObject referenceTarget) {
		Resource res = referenceTarget.eResource();
		ResourceSet rs = res.getResourceSet();
		ECrossReferenceAdapter crossReferencer = null;
		List<Adapter> adapters = rs.eAdapters();
		for (Adapter adapter : adapters) {
			if(adapter instanceof ECrossReferenceAdapter){
				crossReferencer = (ECrossReferenceAdapter) adapter;
				break;
			}
		}
		if(crossReferencer == null){
			crossReferencer = new ECrossReferenceAdapter();
			rs.eAdapters().add(crossReferencer);
		}
		List<Resource> referers = new LinkedList<Resource>();
		Collection<Setting> referencers = crossReferencer.getInverseReferences(referenceTarget, true);
		for (Setting setting : referencers) {
			EObject referer = setting.getEObject();
			Resource resource = referer.eResource();
			if(resource.equals(res)){
				continue;
			}
			URI uri = resource.getURI();
			uri = rs.getURIConverter().normalize(uri);
			if(uri.isPlatformResource()){
//				String platformString = uri.toPlatformString(true);
				referers.add(resource);
			}
		}
		return referers;
	}

}
