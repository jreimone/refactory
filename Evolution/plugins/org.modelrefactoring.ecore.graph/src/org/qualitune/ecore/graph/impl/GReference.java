package org.qualitune.ecore.graph.impl;

import java.util.ArrayList;
import java.util.Collection;

import nz.ac.massey.cs.guery.adapters.jungalt.Edge;

import org.eclipse.emf.ecore.EReference;
import org.qualitune.ecore.graph.GObject;

/**
 * The {@link Edge} superclass for EMF-based edges wrapping a {@link EReference reference}.  
 * 
 * @author jreimann
 *
 */
public class GReference {

	private final EReference reference;
	private GObject end;
	private GObject start;

	public GReference(GObject start, GObject end, EReference reference) {
		super();
		this.reference = reference;
		this.start = start;
		this.end = end;
	}

	public EReference getReference() {
		return reference;
	}

	public GObject getStart() {
		return start;
	}
	
	public GObject getEnd() {
		return end;
	}

	public Collection<GObject> getIncidentVertices() {
		Collection<GObject> vertices = new ArrayList<GObject>();
		vertices.add(start);
		vertices.add(end);
		return vertices;
	}

	public void setEnd(GObject end) {
		this.end = end;
	}
}
