/**
 * 
 */
package org.qualitune.evolution.guery.graph;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.qualitune.evolution.guery.registry.EReferenceEdge;



/**
 * @author jreimann
 *
 */
public class MetamodelGraphAdapterFactory extends EMFGraphAdapterFactory<MetamodelVertex>{

	public MetamodelGraphAdapterFactory(Resource resource) {
		super(resource);
	}

	@Override
	public MetamodelVertex createVertex(EObject modelElement) {
		if(modelElement instanceof EClass){
			return new EClassVertex((EClass) modelElement, isInSameModelAsBaseResourceModel(modelElement));
		}
		if(modelElement instanceof EPackage){
			return new EPackageVertex((EPackage) modelElement);
		}
		return super.createVertex(modelElement);
	}
	
	@Override
	public EReferenceEdge createEdge(EObject from, EObject to, EReference reference) {
		EReferenceEdge edge = null;
		if(reference.isContainment()){
			edge = new ContainmentEdge(reference);
		} else {
//			Resource toResource = to.eResource();
			if(isInSameModelAsBaseResourceModel(to)){
				edge = new InternalEdge(reference);
			} else {
				edge = new ExternalEdge(reference);
			}
		}
		return edge;
	}
	
	private boolean isInSameModelAsBaseResourceModel(EObject element){
		EObject parent = element.eContainer();
		EObject model = element;
		while (parent != null) {
			model = parent;
			parent = parent.eContainer();
		}
		if(model != null){
			Resource otherResource = model.eResource();
			if(getBaseResource().equals(otherResource)){
				return true;
			}
		}
		return false;
	}
}
