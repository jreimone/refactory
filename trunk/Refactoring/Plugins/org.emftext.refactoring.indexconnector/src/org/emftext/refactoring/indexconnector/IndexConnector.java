/**
 * 
 */
package org.emftext.refactoring.indexconnector;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Interface for build up a connection to an Indexer such as Sokan or EMF Index.
 * 
 * @author Jan Reimann
 *
 */
public interface IndexConnector {
	
	/**
	 * Returns a list with all {@link Resource resources} referencing the given <code>referenceTarget</code>.
	 * @param referenceTarget TODO
	 * @return
	 */
	public List<Resource> getReferencingResources(EObject referenceTarget);
}
