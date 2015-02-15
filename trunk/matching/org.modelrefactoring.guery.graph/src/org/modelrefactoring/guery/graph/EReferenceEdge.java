package org.modelrefactoring.guery.graph;

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
	
	/**
	 * Returns whether an edge corresponds to a containment {@link EReference} from ecore.
	 * This method should be a shortcut to the following check in a motif:
	 * <code>someEdge is org.modelrefactoring.guery.graph.ContainmentEdge</code>
	 * Instead this can be used: <code>someEdge.isContainment()</code> 
	 * 
	 * @return
	 */
	public boolean isContainment(){
		return false;
	}
}
