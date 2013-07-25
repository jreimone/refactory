package org.qualitune.evolution.guery.graph;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.qualitune.evolution.guery.registry.EObjectVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;

public class EMFGraphAdapterFactory<Vertex extends EObjectVertex> implements IEMFGraphAdapterFactory<Vertex, EReferenceEdge> {

	private Resource resource;
	
	public EMFGraphAdapterFactory(Resource resource) {
		this.resource = resource;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vertex createVertex(EObject modelElement) {
		if(modelElement == null){
			return null;
		}
		EObjectVertex vertex = new EObjectVertex(modelElement);
		return (Vertex) vertex;
	}

	@Override
	public EReferenceEdge createEdge(EObject from, EObject to, EReference reference) {
		List<EObject> referencedElements = Util.getReferencedElements(reference, from);
		assert referencedElements.contains(to);
		EReferenceEdge edge = null;
		if(reference.isContainment()){
			edge = new ContainmentEdge(reference);
		} else {
			Resource toResource = to.eResource();
			if(resource.equals(toResource)){
				edge = new InternalEdge(reference);
			} else {
				edge = new ExternalEdge(reference);
			}
		}
		return edge;
	}

	@Override
	public EReferenceEdge createEdge(EObjectVertex from, EObjectVertex to, EReference reference) {
		EReferenceEdge edge = createEdge(from.getModelElement(), to.getModelElement(), reference);
		edge.setStart(from);
		edge.setEnd(to);
		return edge;
	}

	public Resource getBaseResource(){
		return resource;
	}
}
