package org.qualitune.evolution.guery.graph;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

public class EMFGraphAdapterFactory<Cluster> implements IEMFGraphAdapterFactory<EObjectVertex<Cluster>, EReferenceEdge> {

	@Override
	public EObjectVertex<Cluster> createVertex(EObject modelElement) {
		EObjectVertex<Cluster> vertex = new EObjectVertex<Cluster>(modelElement);
		return vertex;
	}

	@Override
	public EReferenceEdge createEdge(EObject from, EObject to, EReference reference) {
		List<EObject> referencedElements = Util.getReferencedElements(reference, from);
		assert referencedElements.contains(to);
		EReferenceEdge edge = null;
		if(reference.isContainment()){
			edge = new ContainmentEdge(reference);
		} else {
			Resource fromResource = from.eResource();
			Resource toResource = to.eResource();
			if(fromResource.equals(toResource)){
				edge = new InternalEdge(reference);
			} else {
				edge = new ExternalEdge(reference);
			}
		}
		return edge;
	}

	@Override
	public EReferenceEdge createEdge(EObjectVertex<Cluster> from, EObjectVertex<Cluster> to, EReference reference) {
		EReferenceEdge edge = createEdge(from.getModelElement(), to.getModelElement(), reference);
		edge.setStart(from);
		edge.setEnd(to);
		return edge;
	}

}
