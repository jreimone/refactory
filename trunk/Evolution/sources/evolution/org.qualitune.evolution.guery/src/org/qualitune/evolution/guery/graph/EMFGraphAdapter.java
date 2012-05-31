package org.qualitune.evolution.guery.graph;

import java.util.Iterator;
import java.util.List;

import nz.ac.massey.cs.guery.AbstractGraphAdapter;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;

public class EMFGraphAdapter<Vertex extends EObjectVertex, Edge extends EReferenceEdge> extends AbstractGraphAdapter<Vertex, Edge> {

	private IEMFGraphAdapterFactory<Vertex, Edge> factory;
	private Resource resource;
	
	private DirectedSparseMultigraph<Vertex, Edge> graph;
	
	private Vertex modelVertex;

	public EMFGraphAdapter(Resource resource, IEMFGraphAdapterFactory<Vertex, Edge> factory){
		this.resource = resource;
		this.factory = factory;
		initialiseGraph();
	}
	
	private void initialiseGraph() {
		graph = new DirectedSparseMultigraph<Vertex, Edge>();
		List<EObject> contents = resource.getContents();
		for (EObject model : contents) {
			modelVertex = factory.createVertex(model);
			graph.addVertex(modelVertex);
			TreeIterator<EObject> treeIterator = model.eAllContents();
			while (treeIterator.hasNext()) {
				EObject element = treeIterator.next();
				Vertex elementVertex = factory.createVertex(element);
				addNode(elementVertex);
			}
		}
	}

	public Vertex getRootModelVertex(){
		return modelVertex;
	}
	
	private void addNode(Vertex elementVertex) {
		if(!graph.containsVertex(elementVertex)){
			graph.addVertex(elementVertex);
			EObject element = elementVertex.getModelElement();
			EObject container = element.eContainer();
			Vertex containerVertex = factory.createVertex(container);
			if(!graph.containsVertex(containerVertex)){
				addNode(containerVertex);
			}
			EdgeType edgeType = EdgeType.DIRECTED;
			EReference containmentFeature = element.eContainmentFeature();
			assert container.eGet(containmentFeature, true).equals(element);
			Edge edge = factory.createEdge(containerVertex, elementVertex, containmentFeature);
			graph.addEdge(edge, containerVertex, elementVertex, edgeType);
			List<EReference> references = Util.getAllReferences(element);
			for (EReference reference : references) {
				List<EObject> referencedElements = Util.getReferencedElements(reference, element);
				for (EObject referencedElement : referencedElements) {
					Vertex referencedElementVertex = factory.createVertex(referencedElement);
					Edge newEdge = null;
					if(!graph.containsVertex(referencedElementVertex)){
						Resource otherResource = referencedElement.eResource();
						if(!otherResource.equals(resource)){
							graph.addVertex(referencedElementVertex);
							newEdge = factory.createEdge(element, referencedElement, reference);
							assert newEdge instanceof ExternalEdge;
						} else {
							addNode(referencedElementVertex);
						}
					}
					if(graph.findEdge(elementVertex, referencedElementVertex) == null){
						if(newEdge == null){
							newEdge = factory.createEdge(element, referencedElement, reference);
						}
						newEdge.setStart(elementVertex);
						newEdge.setEnd(referencedElementVertex);
						graph.addEdge(newEdge, elementVertex, referencedElementVertex, edgeType);
					}
				}
			}
		}
	}

	@Override
	public Iterator<Edge> getInEdges(Vertex vertex) {
		return graph.getInEdges(vertex).iterator();
	}

	@Override
	public Iterator<Edge> getOutEdges(Vertex vertex) {
		return graph.getOutEdges(vertex).iterator();
	}

	@Override
	public Vertex getStart(Edge edge) {
		return graph.getSource(edge);
	}

	@Override
	public Vertex getEnd(Edge edge) {
		return graph.getDest(edge);
	}

	@Override
	public Iterator<Edge> getEdges() {
		return graph.getEdges().iterator();
	}

	@Override
	public Iterator<Vertex> getVertices() {
		return graph.getVertices().iterator();
	}

	@Override
	public int getVertexCount() throws UnsupportedOperationException {
		return graph.getVertexCount();
	}

	@Override
	public int getEdgeCount() throws UnsupportedOperationException {
		return graph.getEdgeCount();
	}

	@Override
	public void closeIterator(Iterator<?> iterator) {
		// nothing to close
	}

	public IEMFGraphAdapterFactory<Vertex, Edge> getFactory() {
		return factory;
	}

	public DirectedSparseMultigraph<Vertex, Edge> getGraph() {
		return graph;
	}

}
