package org.emftext.refactoring.matching;

import java.util.List;
import java.util.Set;

import nz.ac.massey.cs.guery.ComputationMode;
import nz.ac.massey.cs.guery.GQL;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifInstance;
import nz.ac.massey.cs.guery.Path;
import nz.ac.massey.cs.guery.ResultListener;
import nz.ac.massey.cs.guery.impl.MultiThreadedGQLImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.qualitune.evolution.guery.graph.EPackageGraphAdapter;
import org.qualitune.evolution.guery.graph.MetamodelVertex;
import org.qualitune.evolution.guery.registry.EObjectVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;

public class SolvingMotif {
	
	private EPackageGraphAdapter graphAdapter;
	private Resource resource;
	private Motif<MetamodelVertex, EReferenceEdge> motif;
	
	public SolvingMotif(Motif<MetamodelVertex, EReferenceEdge> motif, Resource resource){
		this.motif = motif;
		this.resource = resource;
		graphAdapter = new EPackageGraphAdapter(resource);
	}
	
	public void findMotifInstances(){
//		Motif<EObjectVertex, EReferenceEdge> motif=loadMotifs();
		ResultListener<MetamodelVertex, EReferenceEdge> listener = new ResultListener<MetamodelVertex, EReferenceEdge>(){
			private int i = 0;
			public void done() {} 
			public boolean found(MotifInstance<MetamodelVertex, EReferenceEdge> instance) { 
				// do something 
				//TODO transformation in rm
//				if (i==1){
				Set<MetamodelVertex> instances=instance.getVertices();
//				System.out.println(motif.getRoles().size());
//				for (EObjectVertex instanceTest:instances){
//					System.out.println(i+" "+instanceTest.getModelElement());
//				}
//				if (motif.getRoles().size()==instances.size()){
					analyzeMotifs(instance);
//				}
				transformToRolemapping();
//				}
				i++;
				System.out.println(i);
				return true; //TODO return instance?
			}
			public void progressMade(int progress, int total) {} 
		};
		GQL<MetamodelVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<MetamodelVertex, EReferenceEdge>();
		engine.query(graphAdapter,motif,listener,ComputationMode.ALL_INSTANCES);
	}
	
	public void analyzeMotifs(MotifInstance<MetamodelVertex,EReferenceEdge> instance){
		System.out.println("~~~~~~~~~~~~~~~~~~");
//		MotifInstance<EObjectVertex,EReferenceEdge> instance = null;
		Motif<MetamodelVertex,EReferenceEdge> motif = instance.getMotif();
		for (String vertexRole:motif.getRoles()) {
			EObjectVertex vertex = instance.getVertex(vertexRole);
			if(vertex != null){
				EObject modelElement = vertex.getModelElement();
				if(modelElement instanceof EClass){
					System.out.println(vertexRole + " -> "+ ((EClass) modelElement).getName());
				} else if (modelElement instanceof EReference) {
					System.out.println(vertexRole + " -> ERef "+ ((EReference)modelElement).getName());
				}
				else if (modelElement instanceof EPackage){
					System.out.println(vertexRole + " -> EPa "+ ((EPackage)modelElement).getName());
				}
				else{
					System.out.println(vertexRole + " -> "+ modelElement);
				}
			} else {
				System.out.println(vertexRole + " -> "+ vertex);
			}
		}
		
		for (String edgeRole:motif.getPathRoles()) {
			Path<MetamodelVertex,EReferenceEdge> path = instance.getPath(edgeRole);
			System.out.println(edgeRole + ": ");
			List<EReferenceEdge> edges = path.getEdges();
			for (EReferenceEdge edge : edges) {
				System.out.println("\t" + edge.getStart() + " --" + edge.getReference().getName() + "--> " + edge.getEnd());
			}
		}
		System.out.println("~~~~~~~~~~~~~~~~~~");
	}
	
	private void transformToRolemapping() {
		
	}

}
