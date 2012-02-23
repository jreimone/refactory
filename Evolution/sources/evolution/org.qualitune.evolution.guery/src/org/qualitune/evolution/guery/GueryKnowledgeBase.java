package org.qualitune.evolution.guery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.qualitune.evolution.guery.graph.ClusteredDirectedSparseMultiGraph;
import org.qualitune.evolution.guery.graph.EObjectVertex;
import org.qualitune.evolution.guery.graph.EReferenceEdge;
import org.qualitune.evolution.guery.graph.ExternalEdge;
import org.qualitune.evolution.guery.graph.InternalEdge;
import org.qualitune.evolution.registry.KnowledgeBase;

import edu.uci.ics.jung.graph.util.EdgeType;

public class GueryKnowledgeBase implements KnowledgeBase {

	private ClusteredDirectedSparseMultiGraph<EObjectVertex<Resource>, EReferenceEdge, Resource> graph = new ClusteredDirectedSparseMultiGraph<EObjectVertex<Resource>, EReferenceEdge, Resource>();
	private Resource resource;

	@Override
	public Map<EObject, Collection<EObject>> getDependencies(URI uri, ResourceSet rs) {
		return null;
	}

	@Override
	public void generateKnowledge(Resource resource) {
		this.resource = resource;
		List<EObject> contents = resource.getContents();
		for (EObject model : contents) {
			EObjectVertex<Resource> vertex = new EObjectVertex<Resource>(model);
			graph.addVertex(vertex);
			graph.annotateWithCluster(vertex, resource);
			TreeIterator<EObject> treeIterator = model.eAllContents();
			while (treeIterator.hasNext()) {
				EObject element = treeIterator.next();
				EObjectVertex<Resource> elementVertex = new EObjectVertex<Resource>(element);
				addNode(graph, elementVertex);
			}
		}
	}

	private void addNode(ClusteredDirectedSparseMultiGraph<EObjectVertex<Resource>, EReferenceEdge, Resource> graph, EObjectVertex<Resource> elementVertex) {
		if(!graph.containsVertex(elementVertex)){
			graph.addVertex(elementVertex);
			EObject element = elementVertex.getModelElement();
			EObject container = element.eContainer();
			EObjectVertex<Resource> containerVertex = new EObjectVertex<Resource>(container);
			EdgeType edgeType = EdgeType.DIRECTED;
			EReference containmentFeature = element.eContainmentFeature();
			assert container.eGet(containmentFeature, true).equals(element);
			InternalEdge edge = new InternalEdge(containmentFeature);
			if(!graph.containsVertex(containerVertex)){
				addNode(graph, containerVertex);
			}
			edge.setStart(containerVertex);
			edge.setEnd(elementVertex);
			graph.addEdge(edge, containerVertex, elementVertex, edgeType);
			List<EReference> references = getAllReferences(element);
			for (EReference reference : references) {
				List<EObject> referencedElements = getReferencedElements(reference, element);
				for (EObject referencedElement : referencedElements) {
					EObjectVertex<Resource> referencedElementVertex = new EObjectVertex<Resource>(referencedElement);
					EReferenceEdge newEdge = new InternalEdge(reference);
					if(!graph.containsVertex(referencedElementVertex)){
						Resource otherResource = referencedElement.eResource();
						if(!otherResource.equals(resource)){
							graph.addVertex(referencedElementVertex);
							newEdge = new ExternalEdge(reference);
						} else {
							addNode(graph, referencedElementVertex);
						}
					}
					if(graph.findEdge(elementVertex, referencedElementVertex) == null){
						newEdge.setStart(elementVertex);
						newEdge.setEnd(referencedElementVertex);
						graph.addEdge(newEdge, elementVertex, referencedElementVertex, edgeType);
					}
				}
			}
		}
	}

	private List<EReference> getAllReferences(EObject element){
		EClass metaclass = element.eClass();
		List<EReference> allReferences = metaclass.getEAllReferences();
		List<EReference> allContainments = metaclass.getEAllContainments();
		List<EReference> references = new ArrayList<EReference>(allReferences);
		references.removeAll(allContainments);
		return references;
	}

	@SuppressWarnings("unchecked")
	private List<EObject> getReferencedElements(EReference reference, EObject element) {
		List<EObject> referencedElements = new ArrayList<EObject>();
		Object object = element.eGet(reference, true);
		if(!reference.isMany()){
			referencedElements.add((EObject) object);
		} else {
			referencedElements.addAll((List<EObject>) object);
		}
		return referencedElements;
	}
}
