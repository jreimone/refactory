/**
 * 
 */
package org.modelrefactoring.guery.graph;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;



/**
 * This GraphAdapter ignores external metaclasses and references to them.
 * 
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
			if(isInSameModelAsBaseResourceModel(modelElement)){
				return new EClassVertex((EClass) modelElement, true);
			}
		}
//		if(modelElement instanceof EPackage){
//			return new EPackageVertex((EPackage) modelElement);
//		}
//		return super.createVertex(modelElement);
		return null;
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
			} 
//			else {
//				edge = new ExternalEdge(reference);
//			}
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
