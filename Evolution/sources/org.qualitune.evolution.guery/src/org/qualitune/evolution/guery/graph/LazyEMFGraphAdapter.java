package org.qualitune.evolution.guery.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import nz.ac.massey.cs.guery.AbstractGraphAdapter;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.qualitune.evolution.guery.registry.EObjectVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;

/**
 *  CAUTION CAUTION CAUTION<br><br>
 * 
 * 	THIS CLASS IS UNFINISHED YET!!!!!<br><br>
 * 
 *  CAUTION CAUTION CAUTION<br><br>
 *  
 *  TODO jreimann: finish it when it's needed
 *  TODO implement getInEdges
 */
public class LazyEMFGraphAdapter<Vertex extends EObjectVertex, Edge extends EReferenceEdge> extends AbstractGraphAdapter<Vertex, Edge> {

	private EObject model;
	private IEMFGraphAdapterFactory<Vertex, Edge> factory;

	//	private Set<EObjectVertex> vertices = new LinkedHashSet<EObjectVertex>();
	//	private Set<EReferenceEdge> edges = new HashSet<EReferenceEdge>();

	public LazyEMFGraphAdapter(EObject model, IEMFGraphAdapterFactory<Vertex, Edge> factory) {
		super();
		this.model = model;
		this.factory = factory;
	}

	@Override
	public Iterator<Edge> getInEdges(Vertex vertex) {
		EObject modelElement = vertex.getModelElement();

		return null;
	}

	@Override
	public Iterator<Edge> getOutEdges(Vertex vertex) {
		EObject modelElement = vertex.getModelElement();
		List<EReference> allReferences = Util.getAllReferences(modelElement);
		List<Edge> outEdges = new ArrayList<Edge>();
		for (EReference reference : allReferences) {
			for (EObject referencedElement : Util.getReferencedElements(reference, modelElement)) {
				Edge edge = factory.createEdge(modelElement, referencedElement, reference);
				outEdges.add(edge);
			}
		}
		return outEdges.iterator();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vertex getStart(Edge edge) {
		return (Vertex) edge.getStart();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vertex getEnd(Edge edge) {
		return (Vertex) edge.getEnd();
	}

	@Override
	public Iterator<Edge> getEdges() {
		Iterator<Edge> it = new Iterator<Edge>() {

			private Set<EReferenceEdge> visitedEdges = new HashSet<EReferenceEdge>();
			private Set<EReferenceEdge> edgesOfCurrentVertex = new HashSet<EReferenceEdge>();
			private Iterator<Vertex> vertices = getVertices();
			private Vertex nextElement = null;
			private boolean hasNext = true;

			@Override
			public boolean hasNext() {
				return hasNext;
			}

			@SuppressWarnings("unchecked")
			@Override
			public Edge next() {
				Edge next = null;
				do {
					if(edgesOfCurrentVertex.size() == 0){
						if(vertices.hasNext()){
							nextElement = vertices.next();
							Collection<EReferenceEdge> inEdges = nextElement.getInEdges();
							Collection<EReferenceEdge> outEdges = nextElement.getOutEdges();
							edgesOfCurrentVertex.addAll(inEdges);
							edgesOfCurrentVertex.addAll(outEdges);
						} else {
							hasNext = false;
						}
					} 
					Iterator<EReferenceEdge> iterator = edgesOfCurrentVertex.iterator();
					if(iterator.hasNext()){
						next = (Edge) iterator.next();
						edgesOfCurrentVertex.remove(next);
					}
				} while (visitedEdges.contains(next));
				if(next != null){
					visitedEdges.add(next);
				}
				return next;
			}

			@Override
			public void remove() {
				// no remove allowed
			}

		};
		return it;
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
				// remove is not allowed --> do nothing
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
		throw new UnsupportedOperationException("This adapter doesn't support the calculation of the edge count");
	}

	@Override
	public void closeIterator(Iterator<?> iterator) {
		// TODO Auto-generated method stub

	}
}
