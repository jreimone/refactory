/**
 * 
 */
package org.modelrefactoring.guery.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author jreimann, rhunger
 *
 */
public class EPackageGraphAdapter/*<Vertex extends EObjectVertex, Edge extends EReferenceEdge>*/ extends EMFGraphAdapter<MetamodelVertex, EReferenceEdge> {

	private Map<EClass, EClassVertex> index;
	private Map<EReference, Set<EReferenceEdge>> referenceEdgeMap;
	private Map<EClassVertex, List<EReferenceEdge>> vertex2IncomingEdges;

	private Map<EClass, Set<EClass>> subClasses;
	private EPackage metamodel;
	private List<EClass> allMetaclasses;

	public EPackageGraphAdapter(Resource resource) {
		super(resource, new MetamodelGraphAdapterFactory(resource));
		EObject model = resource.getContents().get(0);
		assert model instanceof EPackage;
		metamodel = (EPackage) model;
	}

	public EPackageGraphAdapter(EPackage metamodel) {
		this(metamodel.eResource());
	}

	@Override
	public void initialiseGraph() {
		index = new HashMap<EClass, EClassVertex>();
		referenceEdgeMap = new HashMap<EReference, Set<EReferenceEdge>>();
		vertex2IncomingEdges = new HashMap<EClassVertex, List<EReferenceEdge>>();
		subClasses = new HashMap<EClass, Set<EClass>>();
		super.initialiseGraph();
	}

	@Override
	protected void createGraph() {
		addNodesForMetamodel(metamodel);
		if(!useOnlySuperClasses()){
			createInheritedReferencesOfMetamodel();
		}
	}

	private void addNodesForMetamodel(EPackage metamodel) {
		allMetaclasses = getMetaclassesFromPackageRecursively(metamodel);
		for (EClass metaclass : allMetaclasses) {
			populateSubTypeHierarchy(metaclass);
			MetamodelVertex metaclassVertex = getFactory().createVertex(metaclass);
			if(metaclassVertex != null){
				addNode(metaclassVertex);
			}
		}
	}

	private List<EClass> getMetaclassesFromPackageRecursively(EPackage epackage){
		List<EClass> allMetaclasses = new ArrayList<EClass>();
		List<EClassifier> classifiers = epackage.getEClassifiers();
		for (EClassifier classifier : classifiers) {
			if(classifier instanceof EClass){
				allMetaclasses.add((EClass) classifier);
			}
		}
		List<EPackage> subpackages = epackage.getESubpackages();
		for (EPackage subpackage : subpackages) {
			allMetaclasses.addAll(getMetaclassesFromPackageRecursively(subpackage));
		}
		return allMetaclasses;
	}

	public boolean useOnlySuperClasses(){
		return false;
	}

	private void createInheritedReferencesOfMetamodel() {
		for (EClass metaclass : allMetaclasses) {
			EClassVertex classVertexSub = index.get(metaclass);
			List<EClass> allSuperTypes = metaclass.getEAllSuperTypes();
			for (EClass superClass:allSuperTypes){
				EClassVertex classVertexSuper = index.get(superClass);
				// inherit incoming edges
				if (vertex2IncomingEdges.containsKey(classVertexSuper)){
					List<EReferenceEdge> references = vertex2IncomingEdges.get(classVertexSuper);
					for (EReferenceEdge referenceEdge:references){
						EClass sourceClass = (EClass)referenceEdge.getStart().getModelElement();
						EClassVertex classVertexSource = index.get(sourceClass);
						EdgeType edgeType = EdgeType.DIRECTED;
						EReferenceEdge newInheritedIncomingEdge = getFactory().createEdge(classVertexSource, classVertexSub, referenceEdge.getReference());
						if(newInheritedIncomingEdge != null){
							getGraph().addEdge(newInheritedIncomingEdge, classVertexSource, classVertexSub, edgeType);
							Set<EReferenceEdge> edges = referenceEdgeMap.get(newInheritedIncomingEdge.getReference());
							if(edges == null){
								edges = new HashSet<EReferenceEdge>();
								referenceEdgeMap.put(newInheritedIncomingEdge.getReference(), edges);
							}
							edges.add(newInheritedIncomingEdge);
						}
					}
				}
			}
		}
	}

	@Override
	protected void addNode(MetamodelVertex vertex) {
		if(vertex != null && vertex instanceof EClassVertex){
			EClassVertex eclassVertex = (EClassVertex) vertex;
			if(!index.containsKey(eclassVertex.getEClass())){
				getGraph().addVertex(eclassVertex);
				index.put(eclassVertex.getEClass(), eclassVertex);
				EClass eClass = eclassVertex.getEClass();
				EdgeType edgeType = EdgeType.DIRECTED;
				List<EReference> references = eClass.getEAllReferences();
				for (EReference reference : references) { //enthaelt Referenzen von EClass mit namen
					EClass targetClass = reference.getEReferenceType();
					EClassVertex targetVertex = (EClassVertex) getFactory().createVertex(targetClass);
					if(targetVertex != null){
						if(index.containsKey(targetVertex.getEClass())){
							targetVertex = index.get(targetVertex.getEClass()); //Testet ob targetEClass vorhanden
						} 
						EReferenceEdge newEdge = getFactory().createEdge(eclassVertex, targetVertex, reference);
						if(newEdge != null){
							List<EReferenceEdge> incomingEdges = vertex2IncomingEdges.get(targetVertex);
							if(incomingEdges == null){
								incomingEdges = new ArrayList<EReferenceEdge>();
								vertex2IncomingEdges.put(targetVertex, incomingEdges);
							}
							if(referenceEdgeMap.get(reference) == null){
								getGraph().addEdge(newEdge, eclassVertex, targetVertex, edgeType);
								if(!incomingEdges.contains(newEdge)){
									incomingEdges.add(newEdge);
								}
								Set<EReferenceEdge> edges = new HashSet<EReferenceEdge>();
								referenceEdgeMap.put(reference, edges);
								edges.add(newEdge);
								//						Set<EReferenceEdge> edges = referenceEdgeMap.get(reference);
								//						if(edges == null){
								//							edges = new HashSet<EReferenceEdge>();
								//							referenceEdgeMap.put(reference, edges);
								//						}
							} else {
								Set<EReferenceEdge> edges = referenceEdgeMap.get(reference);
								boolean found = false;
								for (EReferenceEdge edge : edges) {
									if(edge.getStart().getModelElement().equals(eClass) && edge.getEnd().getModelElement().equals(targetClass)){
										found = true;
									}
								}
								if(!found){
									edges.add(newEdge);
									getGraph().addEdge(newEdge, eclassVertex, targetVertex, edgeType);
									if(!incomingEdges.contains(newEdge)){
										incomingEdges.add(newEdge);
									}
								}
							}
						}
						addNode(targetVertex);
					}
				}
			}
		}
	}

	private void populateSubTypeHierarchy(EClass subType) {
		List<EClass> allSuperTypes = subType.getEAllSuperTypes();
		for (EClass superType : allSuperTypes) {
			Set<EClass> subTypes = subClasses.get(superType);
			if(subTypes == null){
				subTypes = new HashSet<EClass>();
				subClasses.put(superType, subTypes);
			}
			subTypes.add(subType);
		}
	}

	public Map<EClass, Set<EClass>> getSubTypeHierarchy() {
		return subClasses;
	}

	public Map<EReference, Set<EReferenceEdge>> getReferenceEdgeMap() {
		return referenceEdgeMap;
	}

}
