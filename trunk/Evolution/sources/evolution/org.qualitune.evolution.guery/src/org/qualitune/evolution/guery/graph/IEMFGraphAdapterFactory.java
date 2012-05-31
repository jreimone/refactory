package org.qualitune.evolution.guery.graph;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.qualitune.evolution.guery.registry.EObjectVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;

/**
 * This interface is needed for instantiating the generic class arguments in the
 * {@link LazyEMFGraphAdapter} which are needed for the edge and vertex creation.
 * 
 * @author jreimann
 *
 */
public interface IEMFGraphAdapterFactory<Vertex extends EObjectVertex, Edge extends EReferenceEdge> {

	/**
	 * Creates a new vertex for the given {@link EObject modelElement}.
	 * @param modelElement
	 * @return
	 */
	public Vertex createVertex(EObject modelElement);
	
	/**
	 * Creates a new edge for the given {@link EReference reference}.
	 * @param reference
	 * @return
	 */
	public Edge createEdge(EObject from, EObject to, EReference reference);
	
	/**
	 * Creates a new edge for the given {@link EReference reference}.
	 * @param reference
	 * @return
	 */
	public Edge createEdge(Vertex from, Vertex to, EReference reference);
}
