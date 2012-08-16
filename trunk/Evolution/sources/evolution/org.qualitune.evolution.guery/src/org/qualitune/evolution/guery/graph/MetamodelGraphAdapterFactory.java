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

	@Override
	public MetamodelVertex createVertex(EObject modelElement) {
		if(modelElement instanceof EClass){
			return new EClassVertex((EClass) modelElement);
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
}
