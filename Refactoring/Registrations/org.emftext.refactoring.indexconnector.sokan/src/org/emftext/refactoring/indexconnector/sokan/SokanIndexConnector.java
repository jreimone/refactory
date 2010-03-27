/**
 * 
 */
package org.emftext.refactoring.indexconnector.sokan;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
		URI uri = referenceTarget.eResource().getURI();
		if(uri == null){
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
		List<Resource> referers = new LinkedList<Resource>();
		List<String> refererStrings = metaData.getMulti(InverseModelReferencesIndexer.KEY_INVERSE_REFERENCED_RESOURCES);
		for (String string : refererStrings) {
			URI refererUri = ResourceUtil.uriFrom(string);
			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.getResource(refererUri, true);
			if(resource == null){
				resource = rs.createResource(refererUri);
			}
			if(resource != null){
				referers.add(resource);
			}
		}
		return referers;
	}

}
