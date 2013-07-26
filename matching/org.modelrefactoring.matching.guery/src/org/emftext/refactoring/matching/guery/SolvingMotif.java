package org.emftext.refactoring.matching.guery;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import nz.ac.massey.cs.guery.ComputationMode;
import nz.ac.massey.cs.guery.GQL;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifInstance;
import nz.ac.massey.cs.guery.MotifReader;
import nz.ac.massey.cs.guery.MotifReaderException;
import nz.ac.massey.cs.guery.ResultListener;
import nz.ac.massey.cs.guery.impl.MultiThreadedGQLImpl;
import nz.ac.massey.cs.guery.io.dsl.DefaultMotifReader;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.roles.RoleModel;
import org.qualitune.evolution.guery.graph.EPackageGraphAdapter;
import org.qualitune.evolution.guery.graph.MetamodelVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;

public class SolvingMotif {

	private EPackageGraphAdapter graphAdapter;
	private Motif<MetamodelVertex, EReferenceEdge> motif;
	private ByteArrayOutputStream os;
	private static int maxResults=25;
	private RoleModel rolemodel;
	private static boolean debug=false;
	private EPackage epackage;


//	int help=0;
//	String help2="C:/Users/Robert/workspaces/grosserBeleg/org.emftext.refactoring.matching.guery/src/PL";
//	String ext=".txt";

	public SolvingMotif(Motif<MetamodelVertex, EReferenceEdge> motif, Resource resource){
		this.motif = motif;
		graphAdapter = new EPackageGraphAdapter(resource);
	}

	public SolvingMotif(Resource resource, EPackage epackage, ByteArrayOutputStream os, RoleModel rolemodel){
		this.epackage=epackage;
		this.rolemodel=rolemodel;
		graphAdapter = new EPackageGraphAdapter(resource);
		this.os=os;
		motif=loadMotif();
	}

	public void findMotifInstancesFromOutputStream(){
		ResultListener<MetamodelVertex, EReferenceEdge> listener = new ResultListener<MetamodelVertex, EReferenceEdge>(){
			private int i = 0;
			private boolean stopped=false;
			public void done() {
				if (debug){
					if (!stopped){
						System.out.println("Bin fertig!");
					}
					else{
						System.out.println("Wurde abgebrochen!");
					}
				}
			}
			public boolean found(MotifInstance<MetamodelVertex, EReferenceEdge> instance) {
				i++;
				InstanceToRoleMapping itrm=new InstanceToRoleMapping(instance, rolemodel, epackage);
//				itrm.printMotifInstance();
				itrm.transform2RoleMapping();
				if (i>maxResults){
					if (debug){
						System.out.println("Zu viele Ergebnisse, bitte einschränken");
					}
					stopped=true;
					return false;
				}
//				try {
////					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				return true;
			}
			public void progressMade(int progress, int total) {
				if (debug){
					System.out.println(progress+" von "+total+" Möglichkeiten bearbeitet");
				}
			}
		};
		GQL<MetamodelVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<MetamodelVertex, EReferenceEdge>();
		engine.query(graphAdapter,motif,listener,ComputationMode.ALL_INSTANCES);
	}

	private Motif<MetamodelVertex,EReferenceEdge> loadMotif(){
		ByteArrayInputStream in=new ByteArrayInputStream(os.toByteArray());
		MotifReader<MetamodelVertex,EReferenceEdge> reader = new DefaultMotifReader<MetamodelVertex,EReferenceEdge>();
		Motif<MetamodelVertex,EReferenceEdge> motif=null;
		try {
			motif = reader.read(in);
		} catch (MotifReaderException e) {
			e.printStackTrace();
		}
		return motif;
	}

}
