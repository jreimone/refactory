package org.qualitune.evolution.guery.graph;

import java.util.List;

/**
 * An interface which vertices should implement when a {@link ClusteredDirectedSparseMultiGraph} is used.
 * 
 * @author jreimann
 * @param <Cluster> the cluster class
 */
public interface ClusterVertex<Cluster> {

	/**
	 * Annotates this vertex with the given <code>cluster</code>.
	 * Note that if you use instances of this class in a {@link ClusteredDirectedSparseMultiGraph}
	 * than prefer invoking {@link ClusteredDirectedSparseMultiGraph#annotateWithCluster(ClusterVertex, Object)}
	 * instead of this method. The method will delegate to this one.
	 * @param cluster
	 */
	public void annotateWithCluster(Cluster cluster);
	
	/**
	 * Returns all annotated clusters.
	 * @return
	 */
	public List<Cluster> getAnnotatedClusters();
	
	/**
	 * Removes the given <code>cluster</code>.
	 * Note that if you use instances of this class in a {@link ClusteredDirectedSparseMultiGraph}
	 * than prefer invoking {@link ClusteredDirectedSparseMultiGraph#removeCluster(ClusterVertex, Object)}
	 * instead of this method. The method will delegate to this one. 
	 * @param cluster
	 * @return
	 */
	public boolean removeCluster(Cluster cluster);
}
