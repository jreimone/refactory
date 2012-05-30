package org.qualitune.evolution.guery.graph;

import org.eclipse.emf.ecore.EReference;

import nz.ac.massey.cs.guery.adapters.jungalt.Edge;

/**
 * The abstract {@link Edge} superclass for EMF-based edges wrapping a {@link EReference reference}.  
 * 
 * @author jreimann
 *
 */
public abstract class EReferenceEdge extends Edge<EObjectVertex> {

	private static final long serialVersionUID = 6893976893889977930L;

	private final EReference reference;

	public EReferenceEdge(EReference reference) {
		super();
		this.reference = reference;
	}

	public EReference getReference() {
		return reference;
	}
}
