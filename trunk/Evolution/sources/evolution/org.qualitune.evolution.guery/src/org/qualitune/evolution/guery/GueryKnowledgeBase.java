package org.qualitune.evolution.guery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.qualitune.evolution.registry.KnowledgeBase;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

public class GueryKnowledgeBase implements KnowledgeBase {

	private static final String SEPARATOR	= "-->";
	
	private static List<Graph<EObject, String>> graphs = new ArrayList<Graph<EObject,String>>();

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
			Graph<EObject, String> graph = new DirectedSparseMultigraph<EObject, String>();
			graphs.add(graph);
			graph.addVertex(model);
			TreeIterator<EObject> treeIterator = model.eAllContents();
			while (treeIterator.hasNext()) {
				EObject element = (EObject) treeIterator.next();
				addNode(graph, element);
			}
		}
	}

	private void addNode(Graph<EObject, String> graph, EObject element) {
		if(!graph.containsVertex(element)){
			graph.addVertex(element);
			EObject container = element.eContainer();
			EdgeType edgeType = EdgeType.DIRECTED;
			URI elementUri = EcoreUtil.getURI(element);
			String edge = elementUri.toString();
			if(!graph.containsVertex(container)){
				addNode(graph, container);
			}
			graph.addEdge(edge, container, element, edgeType);
			List<EReference> references = getAllReferences(element);
			for (EReference reference : references) {
				List<EObject> referencedElements = getReferencedElements(reference, element);
				String name = reference.getName();
				for (EObject referencedElement : referencedElements) {
					if(!graph.containsVertex(referencedElement)){
						Resource otherResource = referencedElement.eResource();
						if(!otherResource.equals(resource)){
							graph.addVertex(referencedElement);
						} else {
							addNode(graph, referencedElement);
						}
					}
					int index = referencedElements.indexOf(referencedElement);
					String preEdge = graph.findEdge(container, element);
					String newEdge = preEdge + SEPARATOR + name + "[" + index + "]";
					graph.addEdge(newEdge, element, referencedElement, edgeType);
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
