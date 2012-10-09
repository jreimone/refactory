/**
 * 
 */
package org.qualitune.evolution.guery.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.qualitune.evolution.guery.registry.EReferenceEdge;

import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author jreimann, rhunger
 *
 */
public class EPackageGraphAdapter/*<Vertex extends EObjectVertex, Edge extends EReferenceEdge>*/ extends EMFGraphAdapter<MetamodelVertex, EReferenceEdge> {

	private Map<EObject, EClassVertex> index;
	private Map<EReference, Set<EReferenceEdge>> referenceIndex;
	private Map<EClassVertex, Collection<EReferenceEdge>> targetToSource;
	
	public EPackageGraphAdapter(Resource resource) {
		super(resource, new MetamodelGraphAdapterFactory());
	}

	@Override
	protected void initialiseGraph() {
		index = new HashMap<EObject, EClassVertex>();
		referenceIndex = new HashMap<EReference, Set<EReferenceEdge>>();
		targetToSource = new HashMap<EClassVertex, Collection<EReferenceEdge>>();
		super.initialiseGraph();
	}

	@Override
	protected void createGraph() {
		List<EObject> contents = getResource().getContents();
		for (EObject model : contents) {
			if(model instanceof EPackage){
				EPackage epackage = (EPackage) model;
				EList<EClassifier> classifiers = epackage.getEClassifiers();
				for (EClassifier classifier : classifiers) {
					if(classifier instanceof EClass){
						EClassVertex classVertex = (EClassVertex) getFactory().createVertex(classifier);
						addNode(classVertex);
					}
				}
			}
		}
		createInheritedReferences();
	}
	
	/**
	 * Loest Vererbungsproblem
	 * eingehende Referenzen der Oberklasse werden in Unterklasse geschrieben
	 */
	private void createInheritedReferences(){
		List<EObject> contents = getResource().getContents();
		for (EObject model : contents) {
			if(model instanceof EPackage){
				EPackage epackage = (EPackage) model;
				EList<EClassifier> classifiers = epackage.getEClassifiers();
				for (EClassifier classifier : classifiers) {
					if(classifier instanceof EClass){
						EClassVertex classVertexSub = (EClassVertex) getFactory().createVertex(classifier);
						EList<EClass> allSuperTypes=((EClass) classifier).getEAllSuperTypes();
						for (EClass clazz:allSuperTypes){
							EClassVertex classVertexSuper = (EClassVertex) getFactory().createVertex(clazz);
							if (targetToSource.containsKey(classVertexSuper)){
								if (!targetToSource.get(classVertexSuper).isEmpty()){
									Collection<EReferenceEdge> references=targetToSource.get(classVertexSuper);
									for (EReferenceEdge reference:references){
										EClass eclass=(EClass)reference.getStart().getModelElement();
										EClassVertex classVertexSource = (EClassVertex) getFactory().createVertex(eclass);
										EdgeType edgeType = EdgeType.DIRECTED;
										reference.setEnd(classVertexSub);
										EReferenceEdge newEdge = getFactory().createEdge(classVertexSource, classVertexSub, reference.getReference());
										getGraph().addEdge(newEdge, classVertexSource, classVertexSub, edgeType);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	protected void addNode(MetamodelVertex vertex) {
		if(vertex instanceof EClassVertex){
			EClassVertex eclassVertex = (EClassVertex) vertex;
			if(!index.containsKey(vertex.getModelElement())){
				getGraph().addVertex(eclassVertex);
				index.put(vertex.getModelElement(), eclassVertex);
				EClass eClass = eclassVertex.getEClass();
				EdgeType edgeType = EdgeType.DIRECTED;
				List<EReference> references = eClass.getEAllReferences();
				for (EReference reference : references) { //enthaelt Referenzen von EClass mit namen
					EClassifier targetClassifier = reference.getEType();
					if(targetClassifier instanceof EClass){
						EClass targetClass = (EClass) targetClassifier;
						EClassVertex targetVertex = (EClassVertex) getFactory().createVertex(targetClass);
						if(index.containsKey(targetVertex.getModelElement())){
							targetVertex = index.get(targetVertex.getModelElement()); //Testet ob targetEClass vorhanden
						} 
						EReferenceEdge newEdge = getFactory().createEdge(eclassVertex, targetVertex, reference);
						if(referenceIndex.get(reference) == null){
							getGraph().addEdge(newEdge, eclassVertex, targetVertex, edgeType);
							if (targetToSource.containsKey(targetVertex)){
								if(!targetToSource.get(targetVertex).contains(newEdge)){
									targetToSource.get(targetVertex).add(newEdge);
								}
							}
							else{
								Set<EReferenceEdge> edges = new HashSet<EReferenceEdge>();
								edges.add(newEdge);
								targetToSource.put(targetVertex, edges);
							}
							Set<EReferenceEdge> edges = new HashSet<EReferenceEdge>();
							edges.add(newEdge);
							referenceIndex.put(reference, edges);
						} else {
							Set<EReferenceEdge> edges = referenceIndex.get(reference);
							boolean found = false;
							for (EReferenceEdge edge : edges) {
								if(edge.getStart().getModelElement().equals(eClass) && edge.getEnd().getModelElement().equals(targetClass)){
									found = true;
								}
							}
							if(!found){
								edges.add(newEdge);
								getGraph().addEdge(newEdge, eclassVertex, targetVertex, edgeType);
								if (targetToSource.containsKey(targetVertex)){
									if(!targetToSource.get(targetVertex).contains(newEdge)){
										targetToSource.get(targetVertex).add(newEdge);
									}
								}
								else{
									Set<EReferenceEdge> edgesToAdd = new HashSet<EReferenceEdge>();
									edgesToAdd.add(newEdge);
									targetToSource.put(targetVertex, edgesToAdd);
								}
							}
						}
						addNode(targetVertex);
					} else {
						System.err.println(targetClassifier + " is not an EClass but an EClassifier");
					}
				}
			}
		}
	}

}
