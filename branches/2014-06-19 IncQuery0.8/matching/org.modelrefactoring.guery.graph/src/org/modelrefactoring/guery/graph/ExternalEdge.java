package org.modelrefactoring.guery.graph;

import nz.ac.massey.cs.guery.adapters.jungalt.Edge;

import org.eclipse.emf.ecore.EReference;

/**
 * An {@link Edge} instance indicating that a reference points to another physical model.
 * 
 * @author jreimann
 *
 */
public class ExternalEdge extends EReferenceEdge {

	private static final long serialVersionUID = -6723842499992133238L;
	
	public ExternalEdge(EReference reference) {
		super(reference);
	}


}
