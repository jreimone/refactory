package org.modelrefactoring.matching.guery;

import java.util.List;
import java.util.Set;

import nz.ac.massey.cs.guery.ComputationMode;
import nz.ac.massey.cs.guery.DefaultMotif;
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
import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;

import util.Writer2txt;
//import org.emftext.language.conference.ConferencePackage;

public class SolvingMotifWithModifiedModel {
	
	private EPackageGraphAdapter graphAdapter;
	private Resource resource;
	private Motif<MetamodelVertex, EReferenceEdge> motif;
	private boolean debug=false;
	
	int help=0;
	String help2="C:/Users/Robert/workspaces/grosserBeleg/org.modelrefactoring.matching.guery/src/PL";
	String ext=".txt";
	
	private Writer2txt w2t;
	
	public SolvingMotifWithModifiedModel(Motif<MetamodelVertex, EReferenceEdge> motif, Resource resource){
		this.motif = motif;
		this.resource = resource;
//		((PL0Package)resource.getContents().get(0)).getBody_Statements().setContainment(false);
//		if (debug){
//			System.out.println(((PL0Package)resource.getContents().get(0)).getBody_Statements().isContainment());
//		}
		graphAdapter = new EPackageGraphAdapter(resource);
	}
	
	public void findMotifInstances(){
		w2t=new Writer2txt(help2+help+ext);
		
		java.util.Date now = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss:SSS");
		String ausgabe = sdf.format(now);
		w2t.writeLine(ausgabe);
		
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
					i=analyzeMotifs(instance,i);
//					if (i==50000){
//						w2t=new Writer2txt(help2+help+ext);
//						help++;
//						i=0;
//					}
//				}
					//TODO
				transformToRolemapping();
//				}
				i++;
				if (debug){
					System.out.println(i);
				}
				return true; //TODO return instance?
			}
			public void progressMade(int progress, int total) {} 
		};
		GQL<MetamodelVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<MetamodelVertex, EReferenceEdge>();
		engine.query(graphAdapter,motif,listener,ComputationMode.ALL_INSTANCES);

		
		now = new java.util.Date();
		sdf = new java.text.SimpleDateFormat("HH:mm:ss:SSS");
		sdf.format(now);
		w2t.writeLine(ausgabe);
	}
	
	public int analyzeMotifs(MotifInstance<MetamodelVertex,EReferenceEdge> instance, int i){
		String ausgabe="";
		if (debug){
			System.out.println("~~~~~~~~~~~~~~~~~~");
		}
//		MotifInstance<EObjectVertex,EReferenceEdge> instance = null;
//		Motif<MetamodelVertex,EReferenceEdge> motif = instance.getMotif();
		DefaultMotif<MetamodelVertex,EReferenceEdge> motif = (DefaultMotif<MetamodelVertex, EReferenceEdge>) instance.getMotif();
//		RRPath<MetamodelVertex,EReferenceEdge> path1=null;
//		RRPath<MetamodelVertex,EReferenceEdge> path2=null;
		
//		for (String edgeRole:motif.getPathRoles()) {
//			if (edgeRole.equals("containerRef")){
//				path1 = (RRPath<MetamodelVertex, EReferenceEdge>) instance.getPath(edgeRole);
//				System.out.println(instance.getPath(edgeRole));
//				System.out.println(path1);
//			}
//			else{
//				if (edgeRole.equals("referer")){
//					path2 = (RRPath<MetamodelVertex, EReferenceEdge>) instance.getPath(edgeRole);
//				}
//			}
//			if ((path1.size()==0&&path2.size()!=0)||(path2.size()==0&&path1.size()!=0)){
//				return i-1;
//			}
//		}
		
		for (String vertexRole:motif.getRoles()) {
			EObjectVertex vertex = instance.getVertex(vertexRole);
			if(vertex != null){
				EObject modelElement = vertex.getModelElement();
				if(modelElement instanceof EClass){
					if (debug){
						System.out.println(vertexRole + " -> "+ ((EClass) modelElement).getName());
					}
					ausgabe=ausgabe+" "+((EClass)modelElement).getName();
				} else if (modelElement instanceof EReference) {
					if (debug){
						System.out.println(vertexRole + " -> ERef "+ ((EReference)modelElement).getName());
					}
				}
				else if (modelElement instanceof EPackage){
					if (debug){
						System.out.println(vertexRole + " -> EPa "+ ((EPackage)modelElement).getName());
					}
				}
				else{
					if(debug){
						System.out.println(vertexRole + " -> "+ modelElement);
					}
				}
			} else {
				if (debug){
					System.out.println(vertexRole + " -> "+ vertex);
				}
			}
		}
		
		for (String edgeRole:motif.getPathRoles()) {
			Path<MetamodelVertex,EReferenceEdge> path = instance.getPath(edgeRole);
			ausgabe=ausgabe+" "+edgeRole;
			if (debug){
				System.out.println(edgeRole + ": ");
			}
			List<EReferenceEdge> edges = path.getEdges();
			if (debug){
				for (EReferenceEdge edge : edges) {
					System.out.println("\t" + edge.getStart() + " --" + edge.getReference().getName() +" "+edge.getReference().isContainment()+ "--> " + edge.getEnd());
				}
			}
			ausgabe=ausgabe+"("+edges.size()+")";
		}
		w2t.writeLine(ausgabe);
		if (debug){
			System.out.println("~~~~~~~~~~~~~~~~~~");
		}
		return i;
	}
	
	private void transformToRolemapping() {
		
	}

}
