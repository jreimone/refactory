package org.qualitune.evolution.registry;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * An interface for registering different knowledge bases (e.g. Prolog-based, or GUERY-based).
 * 
 * @author jreimann
 *
 */
public interface IKnowledgeBase {

	/**
	 * Generates the knowledge for the given <code>resource</code>.
	 * 
	 * @param resource
	 */
	public void generateKnowledge(Resource resource);
	
	/**
	 * Determines all the dependencies for the resource of the given <code>uri</code>. These dependencies
	 * may be explicit or implicit.
	 * 
	 * @param uri the uri for the resource to determine the dependencies for
	 * @param rs this parameter is passed to let implementers load resources with this {@link ResourceSet}
	 * @return a map containing the dependent models as keys and the dependent elements as particular value lists
	 */
	public Map<EObject, Collection<EObject>> getDependencies(URI uri, ResourceSet rs);
}
