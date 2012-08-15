package org.emftext.refactoring.matching;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import nz.ac.massey.cs.guery.ComputationMode;
import nz.ac.massey.cs.guery.GQL;
import nz.ac.massey.cs.guery.GraphAdapter;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifInstance;
import nz.ac.massey.cs.guery.MotifReader;
import nz.ac.massey.cs.guery.MotifReaderException;
import nz.ac.massey.cs.guery.Path;
import nz.ac.massey.cs.guery.ResultListener;
import nz.ac.massey.cs.guery.impl.MultiThreadedGQLImpl;
import nz.ac.massey.cs.guery.io.dsl.DefaultMotifReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.qualitune.evolution.guery.graph.EMFGraphAdapter;
import org.qualitune.evolution.guery.graph.EMFGraphAdapterFactory;
import org.qualitune.evolution.guery.graph.IEMFGraphAdapterFactory;
import org.qualitune.evolution.guery.registry.EObjectVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;
import org.qualitune.guery.GueryPackage;
import org.qualitune.guery.resource.guery.mopp.GueryResourceFactory;

public class SolvingMotif {
	
	private IEMFGraphAdapterFactory<EObjectVertex, EReferenceEdge> factory;
	private GraphAdapter<EObjectVertex, EReferenceEdge> graphAdapter;
	private Resource resource;
	private Motif<EObjectVertex, EReferenceEdge> motif;
	
	public SolvingMotif(Motif<EObjectVertex, EReferenceEdge> motif, Resource resource){
		this.motif = motif;
		this.resource = resource;
		factory = new EMFGraphAdapterFactory();
		graphAdapter = new EMFGraphAdapter<EObjectVertex, EReferenceEdge>(resource, factory);
	}
	
	public static Motif<EObjectVertex,EReferenceEdge> loadMotifs(){
		InputStream in=null;
		try {
//			in = new FileInputStream("..\\ExtractSubX.guery");
//			C:\Users\Robert\gbswt\org.emftext.refactoring.matching\ExtractSubX.guery
			in = new FileInputStream("C:\\Users\\Robert\\gbswt\\org.emftext.refactoring.matching\\ExtractSubX.guery");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		MotifReader<EObjectVertex,EReferenceEdge> reader = new DefaultMotifReader<EObjectVertex,EReferenceEdge>();
		Motif<EObjectVertex,EReferenceEdge> motif=null;
		try {
			motif = reader.read(in);
		} catch (MotifReaderException e) {
			e.printStackTrace();
		} 
		return motif;
	}
	
	
	public void findMotifInstances(){
//		Motif<EObjectVertex, EReferenceEdge> motif=loadMotifs();
		ResultListener<EObjectVertex, EReferenceEdge> listener = new ResultListener<EObjectVertex, EReferenceEdge>(){
			public void done() {} 
			public boolean found(MotifInstance<EObjectVertex, EReferenceEdge> instance) { 
				// do something 
				//TODO transformation in rm
				analyzeMotifs(instance);
				transformToRolemapping();
				System.out.println("LAalala");
				return true; //TODO return instance?
			}
			public void progressMade(int progress, int total) {} 
		};
		GQL<EObjectVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<EObjectVertex, EReferenceEdge>();
		engine.query(graphAdapter,motif,listener,ComputationMode.ALL_INSTANCES);
	}
	
	public void analyzeMotifs(MotifInstance<EObjectVertex,EReferenceEdge> instance){
//		MotifInstance<EObjectVertex,EReferenceEdge> instance = null;
		Motif<EObjectVertex,EReferenceEdge> motif = instance.getMotif();
		for (String vertexRole:motif.getRoles()) {
			EObjectVertex vertex = instance.getVertex(vertexRole);
			System.out.println(vertexRole + " -> "+ vertex);
		}
		
		for (String edgeRole:motif.getPathRoles()) {
			Path<EObjectVertex,EReferenceEdge> path = instance.getPath(edgeRole);
			java.util.List<EReferenceEdge> edges = path.getEdges();
			System.out.println(edgeRole + " -> " + edges);
		}
	}
	
	private void transformToRolemapping() {
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		loadMotifs();
//		SolvingMotif sm=new SolvingMotif(loadMotifs(), );
		
//		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
//		EPackage.Registry.INSTANCE.put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
//		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
//		extensionToFactoryMap.put("rolestext", new RolestextResourceFactory());
//		extensionToFactoryMap.put("guery", new GueryResourceFactory());
//		
////		assertTrue(sourceFile.exists());
////		System.out.println(sourceFile.getAbsolutePath());
//		URI uri = URI.createFileURI(sourceFile.getAbsolutePath());
//		ResourceSet resourceSet = new ResourceSetImpl();
//		Resource resource = resourceSet.getResource(uri, true);
//		EObject model = resource.getContents().get(0);
//		RoleModel rolemodel = (RoleModel) model;
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, 
		 new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put
		(GueryPackage.eNS_URI, 
		 GueryPackage.eINSTANCE);
		String path = "../org.emftext.language.pl0/metamodel/pl0.ecore";
		File file = new File(path);
		assertTrue(file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		Resource pl0MM = resourceSet.getResource(uri, true);
		SolvingMotif solver = new SolvingMotif(loadMotifs(), pl0MM);
		solver.findMotifInstances();
		
		
//		URI fileURI=URI.createFileURI("C:\\Users\\Robert\\gbswt\\org.emftext.refactoring.matching\\src\\org\\emftext\\refactoring\\matching\\Conversion.java");
//		Resource r=resourceSet.createResource(fileURI);
//		Resource res=resourceSet.createResource(URI.createURI(GueryPackage.eNS_URI));
//		Resource resource = resourceSet.createResource(URI.createURI("http:///My.guery"));
//		SolvingMotif sm=new SolvingMotif(loadMotifs(), r);
//		
//		sm.findMotifInstances();
	}

}
