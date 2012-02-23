package org.qualitune.evolution.guery.graph;

import nz.ac.massey.cs.guery.adapters.jungalt.Edge;

import org.eclipse.emf.ecore.EReference;

/**
 * An {@link Edge} instance indicating that a reference points to a model element in the same model.
 * 
 * @author jreimann
 *
 */
public class InternalEdge extends EReferenceEdge {

	private static final long serialVersionUID = 1635821782919819267L;

	public InternalEdge(EReference reference) {
		super(reference);
	}

}
