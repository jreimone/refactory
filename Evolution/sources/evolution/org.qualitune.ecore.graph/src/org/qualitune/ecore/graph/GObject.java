/**
 * 
 */
package org.qualitune.ecore.graph;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.qualitune.ecore.graph.impl.GReference;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.MultiGraph;

/**
 * @author jreimann
 *
 */
public interface GObject extends EObject, DirectedGraph<GObject,GReference>, MultiGraph<GObject,GReference> {

	/**
	 * Returns the graph instance of the model owning this {@link GObject} or null
	 * if currently no model element represents the root graph object.
	 * @return
	 */
	public GObject gGraph();
	
//	/**
//	 * Returns the {@link EObjectGraph} element which represents the {@link Graph}
//	 * @return
//	 */
//	public EObjectGraph eObjectGraph();

	/**
	 * Look at {@link Graph#getInEdges(Object)}
	 * @return
	 */
	public List<GReference> gGetInEdges();

	/**
	 * Look at {@link Graph#getOutEdges(Object)}
	 * @return
	 */
	public List<GReference> gGetOutEdges();
	
	/**
	 * Returns all out edges representing an edge of the given {@link EReference type}.
	 * @param reference
	 * @return
	 */
	public Set<GReference> gGetOutEdgesByReference(EReference reference);
	
	/**
	 * Look at {@link Graph#getNeighbors(Object)}
	 * @return
	 */
	public List<GObject> gGetNeighbors();
	
	/**
	 * Look at {@link Graph#getIncidentEdges(Object)}
	 * @return
	 */
	public List<GReference> gGetIncidentEdges();

	/**
	 * Look at {@link Graph#getPredecessors(Object)}
	 * @return
	 */
	public List<GObject> gGetPredecessors();

	/**
	 * Look at {@link Graph#getSuccessors(Object)}
	 * @return
	 */
	public List<GObject> gGetSuccessors();

	/**
	 * Look at {@link Graph#getSuccessorCount(Object)}
	 * @return
	 */
	public int gGetSuccessorCount();

	/**
	 * Look at {@link Graph#getPredecessorCount(Object)}
	 * @return
	 */
	public int gGetPredecessorCount();

	/**
	 * Look at {@link Graph#inDegree(Object)}
	 * @return
	 */
	public int gInDegree();

	/**
	 * Look at {@link Graph#outDegree(Object)}
	 * @return
	 */
	public int gOutDegree();
}
