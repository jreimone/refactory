package org.modelrefactoring.guery.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import nz.ac.massey.cs.guery.ComputationMode;
import nz.ac.massey.cs.guery.GQL;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifInstance;
import nz.ac.massey.cs.guery.ResultListener;
import nz.ac.massey.cs.guery.impl.MultiThreadedGQLImpl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.pl0.PL0Package;
import org.junit.Test;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;

public class MotifSolvingTest extends MotifAdapterTest {
	
	public static final int THRESHOLD = 100;
	
	private static List<MotifInstance<MetamodelVertex, EReferenceEdge>> instancesGuery;
	private static List<MotifInstance<MetamodelVertex, EReferenceEdge>> instancesModel;
	
	@Test
	public void testPL0ZZZCompare(){
		assertNotNull("No instances found for GUERY parsing", instancesGuery);
		assertNotNull("No instances found for EMFText parsing", instancesModel);
		compare(instancesGuery, instancesModel);
	}
	
	@Test
	public void testPL0ExtractXwithReferenceClassGuery(){
		EPackage pl0MM = PL0Package.eINSTANCE;
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
		Resource pl0MMResource = pl0MM.eResource();
		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
		instancesGuery = testMotifOnMetamodelWithGUERYParsing("queries/ExtractXwithReferenceClass.guery", pl0MMResource);
	}
	
	@Test
	public void testPL0ExtractXwithReferenceClassModel(){
		EPackage pl0MM = PL0Package.eINSTANCE;
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
		Resource pl0MMResource = pl0MM.eResource();
		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
		instancesModel = testMotifOnMetamodelWithEMFTextParsing("queries/ExtractXwithReferenceClass.guery", pl0MMResource);
	}
	
	
	private List<MotifInstance<MetamodelVertex, EReferenceEdge>> testMotifOnMetamodelWithGUERYParsing(String motifPath, Resource metamodelResource){
		Motif<MetamodelVertex, EReferenceEdge> motifByGuery = this.<MetamodelVertex>getMotifByGuery(motifPath);
		return solveMotifOnResource(motifByGuery, metamodelResource);
	}
	
	private List<MotifInstance<MetamodelVertex, EReferenceEdge>> testMotifOnMetamodelWithEMFTextParsing(String motifPath, Resource metamodelResource){
		Motif<MetamodelVertex, EReferenceEdge> motifByModel = this.<MetamodelVertex>getMotifByModel(motifPath);
		return solveMotifOnResource(motifByModel, metamodelResource);
	}
	
	private void testMotifOnMetamodel(String motifPath, String metamodelPath){
		Resource resource = getMetamodel(metamodelPath);
		testMotifOnMetamodelWithGUERYParsing(motifPath, resource);
	}
	
	private void compare(List<MotifInstance<MetamodelVertex, EReferenceEdge>> gueryInstances, List<MotifInstance<MetamodelVertex, EReferenceEdge>> modelInstances) {
		System.out.println("compare them");
	}

	private List<MotifInstance<MetamodelVertex, EReferenceEdge>> solveMotifOnResource(Motif<MetamodelVertex, EReferenceEdge> motif, Resource resource){
		final List<MotifInstance<MetamodelVertex, EReferenceEdge>> instances = new ArrayList<MotifInstance<MetamodelVertex, EReferenceEdge>>();
		ResultListener<MetamodelVertex, EReferenceEdge> listener = new ResultListener<MetamodelVertex, EReferenceEdge>() {

			private int count = 0;
			
			@Override
			public boolean found(MotifInstance<MetamodelVertex, EReferenceEdge> instance) {
				count++;
				instances.add(instance);
				System.out.println("Found an instance: " + instance);
				if(count <= THRESHOLD){
					return true;
				}
				return false;
			}

			@Override
			public void progressMade(int progress, int total) {
				
			}

			@Override
			public void done() {
				System.out.println("done");
			}
		};
		GQL<MetamodelVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<MetamodelVertex, EReferenceEdge>(1);
		EPackageGraphAdapter graphAdapter = new EPackageGraphAdapter(resource);
		engine.query(graphAdapter, motif, listener, ComputationMode.ALL_INSTANCES);
		return instances;
	}
	
	private Resource getMetamodel(String path){
		File file = new File(path);
		assertTrue("File '" + path + "' doesn't exist", file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		EObject model = resource.getContents().get(0);
		assertTrue("Given model must contain an EPackage", model instanceof EPackage);
		return resource;
	}
}
