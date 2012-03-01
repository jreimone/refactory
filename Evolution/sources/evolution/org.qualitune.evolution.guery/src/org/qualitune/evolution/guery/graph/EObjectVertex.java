package org.qualitune.evolution.guery.graph;

import nz.ac.massey.cs.guery.adapters.jungalt.Vertex;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Objects;

/**
 * A {@link Vertex} instance wrapping the real {@link EObject model instance}.
 * 
 * 
 * @author jreimann
 * @param <Cluster> the type of the cluster with which the vertices can be annotated
 */
public class EObjectVertex<Cluster> extends Vertex<EReferenceEdge> implements ClusterVertex<Cluster>{

	private static final long serialVersionUID = -6542617958217341280L;

	private final EObject modelElement;
	private Cluster cluster;

	public EObjectVertex(EObject modelElement) {
		super();
		this.modelElement = modelElement;
	}

	public EObject getModelElement() {
		return modelElement;
	}

	/**
	 * This method was overridden to indicate object identity in terms of the wrapped {@link EObject modelElement}.
	 * So this method delegates to {@link EObject#equals(Object)}.
	 */
	@Override
	public final boolean equals(Object obj) {
		if(obj instanceof EObjectVertex<?>){
			EObjectVertex<?> other = (EObjectVertex<?>) obj;
			return modelElement.equals(other.modelElement);
		}
		return super.equals(obj);
	}
	
	/**
	 * This method was overridden to indicate object identity in terms of the wrapped {@link EObject modelElement}.
	 * So this method delegates to {@link EObject#hashCode()}.
	 */
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelElement == null) ? 0 : modelElement.hashCode());
		return result;
	}

	@Override
	public void annotateWithCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	@Override
	public Cluster getAnnotatedCluster() {
		return cluster;
	}

	@Override
	public boolean removeCluster() {
		Cluster previous = this.cluster;
		this.cluster = null;
		if(previous != null){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(modelElement)
				.addValue(hashCode())
				.toString();
	}
}
