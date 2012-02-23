package org.qualitune.evolution.guery.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections15.map.HashedMap;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;

/**
 * This graph is a {@link DirectedSparseMultigraph directed sparse multigraph} with a cluster extension.
 * Vertices can be annotated with an object indicating a cluster.
 * 
 * @author jreimann
 *
 * @param <Vertex> class for vertex instances which must implement {@link ClusterVertex}
 * @param <Edge> class for edge instances
 * @param <Cluster> class for cluster instances
 */
public class ClusteredDirectedSparseMultiGraph<Vertex extends ClusterVertex<Cluster>, Edge, Cluster> extends DirectedSparseMultigraph<Vertex, Edge> {

	private static final long serialVersionUID = 8547091998156585215L;

	private Map<Cluster, Collection<Vertex>> clusterMap = new HashedMap<Cluster, Collection<Vertex>>();
	
	/**
	 * Returns all vertices annotated with the given <code>cluster</code>.
	 * 
	 * @param cluster
	 * @return <code>null</code> if this graph has not yet been annotated with the given <code>cluster</code>, an empty list 
	 * if <code>cluster</code> was annotated to a set of vertices from all of which <code>cluster</code> was removed again,
	 * the collection of vertices annotated with <code>cluster</code>
	 */
	public Collection<Vertex> findCluster(Cluster cluster){
		return clusterMap.get(cluster);
	}
	
	/**
	 * Annotates the given <code>vertex</code> with the given <code>clusterIndicator</code>.
	 * Additionally {@link ClusterVertex#annotateWithCluster(Object)} is invoked to which
	 * <code>clusterIndicator</code> is delegated.
	 * 
	 * @param vertex
	 * @param clusterIndicator
	 */
	public void annotateWithCluster(Vertex vertex, Cluster clusterIndicator){
		if(!this.containsVertex(vertex)){
			return;
		}
		Collection<Vertex> cluster = clusterMap.get(clusterIndicator);
		if(cluster == null){
			cluster = new HashSet<Vertex>();
			clusterMap.put(clusterIndicator, cluster);
		}
		cluster.add(vertex);
		List<Cluster> annotatedClusters = vertex.getAnnotatedClusters();
		if(!annotatedClusters.contains(clusterIndicator)){
			vertex.annotateWithCluster(clusterIndicator);
		}
	}
	
	/**
	 * Removes the given <code>clusterIndicator</code> from the vertex.
	 * Internally, {@link ClusterVertex#removeCluster(Object)} is invoked by delegating
	 * <code>clusterIndicator</code>.
	 * 
	 * @param vertex
	 * @param clusterIndicator
	 * @return
	 */
	public boolean removeCluster(Vertex vertex, Cluster clusterIndicator){
		return vertex.removeCluster(clusterIndicator) &&
				clusterMap.get(clusterIndicator).remove(vertex);
	}
}
