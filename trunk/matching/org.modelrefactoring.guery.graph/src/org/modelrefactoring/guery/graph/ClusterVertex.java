package org.modelrefactoring.guery.graph;


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
	 * Returns the annotated cluster.
	 * @return
	 */
	public Cluster getAnnotatedCluster();
	
	/**
	 * Removes the annotated cluster.
	 * Note that if you use instances of this class in a {@link ClusteredDirectedSparseMultiGraph}
	 * than prefer invoking {@link ClusteredDirectedSparseMultiGraph#removeCluster(ClusterVertex, Object)}
	 * instead of this method. The method will delegate to this one. 
	 * @return <code>true</code> if this vertex was annotated with a cluster, <code>false</code> otherwise
	 */
	public boolean removeCluster();
}
