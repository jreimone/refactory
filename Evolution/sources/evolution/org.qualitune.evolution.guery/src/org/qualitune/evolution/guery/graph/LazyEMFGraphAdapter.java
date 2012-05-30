package org.qualitune.evolution.guery.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import nz.ac.massey.cs.guery.AbstractGraphAdapter;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 *  CAUTION CAUTION CAUTION<br><br>
 * 
 * 	THIS CLASS IS UNFINISHED YET!!!!!<br><br>
 * 
 *  CAUTION CAUTION CAUTION<br><br>
 *  
 *  TODO jreimann: finish it when it's needed
 */
public class LazyEMFGraphAdapter<Vertex extends EObjectVertex, Edge extends EReferenceEdge> extends AbstractGraphAdapter<Vertex, Edge> {

	private EObject model;
	private IEMFGraphAdapterFactory<Vertex, Edge> factory;
	
	private Set<EObjectVertex> vertices = new LinkedHashSet<EObjectVertex>();
	private Set<EReferenceEdge> edges = new HashSet<EReferenceEdge>();
	
	public LazyEMFGraphAdapter(EObject model, IEMFGraphAdapterFactory<Vertex, Edge> factory) {
		super();
		this.model = model;
		this.factory = factory;
	}

	private Vertex addVertex(EObject element){
		Vertex vertex = factory.createVertex(element);
		if(!vertices.contains(vertex)){
			vertices.add(vertex);
		}
		return vertex;
	}
	
	private Edge addEdge(Vertex start, Vertex end, EReference reference){
		Edge edge = factory.createEdge(start, end, reference);
		edges.add(edge);
		return edge;
	}
	
	@Override
	public Iterator<Edge> getInEdges(Vertex vertex) {
		return null;
	}

	@Override
	public Iterator<Edge> getOutEdges(Vertex vertex) {
		EObject modelElement = vertex.getModelElement();
		List<EReference> allReferences = Util.getAllReferences(modelElement);
		List<Edge> outEdges = new ArrayList<Edge>();
		for (EReference reference : allReferences) {
			for (EObject referencedElement : Util.getReferencedElements(reference, modelElement)) {
				
			}
		}
		return null;
	}

	@Override
	public Vertex getStart(Edge edge) {
		return (Vertex) edge.getStart();
	}

	@Override
	public Vertex getEnd(Edge edge) {
		return (Vertex) edge.getEnd();
	}

	@Override
	public Iterator<Edge> getEdges() {
		
		return null;
	}

	@Override
	public Iterator<Vertex> getVertices() {
		final TreeIterator<EObject> allContents = model.eAllContents();
		Iterator<Vertex> it = new Iterator<Vertex>() {

			private boolean visitedModelItself = false;
			
			@Override
			public boolean hasNext() {
				return allContents.hasNext();
			}

			@Override
			public Vertex next() {
				if(!visitedModelItself){
					visitedModelItself = true;
					Vertex modelVertex = factory.createVertex(model);
					return modelVertex; 
				}
				EObject element = allContents.next();
				Vertex vertex = factory.createVertex(element);
				return vertex;
			}

			@Override
			public void remove() {
				allContents.remove();
			}
		};
		return it;
	}

	@Override
	public int getVertexCount() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This adapter doesn't support the calculation of the vertex count");
	}

	@Override
	public int getEdgeCount() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void closeIterator(Iterator<?> iterator) {
		// TODO Auto-generated method stub
		
	}
}
