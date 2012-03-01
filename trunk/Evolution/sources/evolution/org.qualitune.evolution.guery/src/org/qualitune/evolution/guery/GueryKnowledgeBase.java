package org.qualitune.evolution.guery;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.qualitune.evolution.guery.graph.EMFGraphAdapter;
import org.qualitune.evolution.guery.graph.EMFGraphAdapterFactory;
import org.qualitune.evolution.guery.graph.EObjectVertex;
import org.qualitune.evolution.guery.graph.EReferenceEdge;
import org.qualitune.evolution.guery.graph.IEMFGraphAdapterFactory;
import org.qualitune.evolution.registry.KnowledgeBase;

public class GueryKnowledgeBase implements KnowledgeBase {

	private EMFGraphAdapter<EObjectVertex<Resource>, EReferenceEdge, Resource> graphAdapter;
	private Resource resource;

	@Override
	public Map<EObject, Collection<EObject>> getDependencies(URI uri, ResourceSet rs) {
		
		return null;
	}

	@Override
	public void generateKnowledge(Resource resource) {
		this.resource = resource;
		IEMFGraphAdapterFactory<EObjectVertex<Resource>, EReferenceEdge> factory = new EMFGraphAdapterFactory<Resource>();
		graphAdapter = new EMFGraphAdapter<EObjectVertex<Resource>, EReferenceEdge, Resource>(resource, factory, resource);
	}
}
