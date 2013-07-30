package org.modelrefactoring.guery.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingPrinter2;
import org.emftext.language.refactoring.roles.RoleModel;
import org.junit.Ignore;
import org.junit.Test;
import org.modelrefactoring.guery.GueryFactory;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;
import org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation;
import org.modelrefactoring.matching.guery.MotifInstance2RoleMapping;
import org.modelrefactoring.matching.guery.RoleModel2Motif;

public class MotifSolvingTest extends MotifAdapterTest {
	
	public static final int THRESHOLD = 50;
	
	private static List<MotifInstance<MetamodelVertex, EReferenceEdge>> instancesGuery;
	private static List<MotifInstance<MetamodelVertex, EReferenceEdge>> instancesModel;
	
	
//	@Test
//	public void testPL0ZZZCompare(){
//		assertNotNull("No instances found for GUERY parsing", instancesGuery);
//		assertNotNull("No instances found for EMFText parsing", instancesModel);
//		compare(instancesGuery, instancesModel);
//	}
	
	@Test
	public void testSimple(){
		RoleModel roleModel = initRoleModel("rolemodels/ExtractXwithReferenceClass.rolestext");
		EPackage metamodel = getMetamodel("metamodels/EExtractXWithReferenceClass.ecore");
		List<org.modelrefactoring.guery.Motif> motifs = convertRoleModel2Motifs(roleModel);
		for (org.modelrefactoring.guery.Motif motif : motifs) {
			String uriString = motif.eResource().getURI().toFileString();
			testMotifOnMetamodelWithGUERYParsing(uriString, metamodel.eResource(), roleModel);
			testMotifOnMetamodelWithEMFTextParsing(uriString, metamodel.eResource(), roleModel);
		}
	}

	private List<org.modelrefactoring.guery.Motif> convertRoleModel2Motifs(RoleModel roleModel) {
		RoleModel2Motif converter = new RoleModel2Motif(roleModel);
		MotifModel motifModel = converter.createMotifModel(3);
		Resource roleModelResource = roleModel.eResource();
		ResourceSet rs = roleModelResource.getResourceSet();
		URI roleModelUri = roleModelResource.getURI();
		List<org.modelrefactoring.guery.Motif> returnedMotifs = new ArrayList<org.modelrefactoring.guery.Motif>();
		List<org.modelrefactoring.guery.Motif> motifs = motifModel.getMotifs();
		ArrayList<org.modelrefactoring.guery.Motif> temp = new ArrayList<org.modelrefactoring.guery.Motif>(motifs);
		for (org.modelrefactoring.guery.Motif motif : temp) {
			String gueryFileName = "queries/" + roleModelUri.lastSegment().replace("." + roleModelUri.fileExtension(), temp.indexOf(motif) + "." + new GueryMetaInformation().getSyntaxName());
			File gueryFile = new File(gueryFileName);
			if(gueryFile.exists()){
				gueryFile.delete();
			}
			URI uri = URI.createFileURI(gueryFile.getAbsolutePath());
			Resource resource = rs.createResource(uri);
			MotifModel motifModelSeparate = GueryFactory.eINSTANCE.createMotifModel();
			motifModel.getMotifs().remove(motif);
			motifModelSeparate.getMotifs().add(motif);
			returnedMotifs.add(motif);
			resource.getContents().add(motifModelSeparate);
			try {
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return returnedMotifs;
	}
	
	@Test
	@Ignore
	public void testPL0ExtractXwithReferenceClassGuery(){
		EPackage pl0MM = PL0Package.eINSTANCE;
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
		Resource pl0MMResource = pl0MM.eResource();
		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
		RoleModel roleModel = initRoleModel("rolemodels/ExtractXwithReferenceClass.rolestext");
		instancesGuery = testMotifOnMetamodelWithGUERYParsing("queries/ExtractXwithReferenceClass.guery", pl0MMResource, roleModel);
	}

	
	@Test
	@Ignore
	public void testPL0ExtractXwithReferenceClassModel(){
		EPackage pl0MM = PL0Package.eINSTANCE;
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
		Resource pl0MMResource = pl0MM.eResource();
		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
		RoleModel roleModel = initRoleModel("rolemodels/ExtractXwithReferenceClass.rolestext");
		instancesModel = testMotifOnMetamodelWithEMFTextParsing("queries/ExtractXwithReferenceClass.guery", pl0MMResource, roleModel);
	}
	
	private RoleModel initRoleModel(String path) {
		File roleModelFile = new File(path);
		URI uri = URI.createFileURI(roleModelFile.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		assertNotNull("Resource for URI '" + uri +"' mustn't be null", resource);
		EObject model = resource.getContents().get(0);
		assertTrue("Resource must contain a rolemodel", model instanceof RoleModel);
		RoleModel roleModel = (RoleModel) model;
		return roleModel;
	}
	
	private List<MotifInstance<MetamodelVertex, EReferenceEdge>> testMotifOnMetamodelWithGUERYParsing(String motifPath, Resource metamodelResource, RoleModel roleModel){
		Motif<MetamodelVertex, EReferenceEdge> motifByGuery = this.<MetamodelVertex>getMotifByGuery(motifPath);
		return solveMotifOnResource(motifByGuery, metamodelResource, roleModel);
	}
	
	private List<MotifInstance<MetamodelVertex, EReferenceEdge>> testMotifOnMetamodelWithEMFTextParsing(String motifPath, Resource metamodelResource, RoleModel roleModel){
		Motif<MetamodelVertex, EReferenceEdge> motifByModel = this.<MetamodelVertex>getMotifByModel(motifPath);
		return solveMotifOnResource(motifByModel, metamodelResource, roleModel);
	}
	
//	private void testMotifOnMetamodel(String motifPath, String metamodelPath){
//		Resource resource = getMetamodel(metamodelPath);
//		testMotifOnMetamodelWithGUERYParsing(motifPath, resource);
//	}
	
	private void compare(List<MotifInstance<MetamodelVertex, EReferenceEdge>> gueryInstances, List<MotifInstance<MetamodelVertex, EReferenceEdge>> modelInstances) {
		System.out.println("compare them");
	}

	private List<MotifInstance<MetamodelVertex, EReferenceEdge>> solveMotifOnResource(Motif<MetamodelVertex, EReferenceEdge> motif, Resource resource, final RoleModel roleModel){
		final List<MotifInstance<MetamodelVertex, EReferenceEdge>> instances = new ArrayList<MotifInstance<MetamodelVertex, EReferenceEdge>>();
		ResultListener<MetamodelVertex, EReferenceEdge> listener = new ResultListener<MetamodelVertex, EReferenceEdge>() {

			private int count = 0;
			
			@Override
			public boolean found(MotifInstance<MetamodelVertex, EReferenceEdge> instance) {
				count++;
				instances.add(instance);
				printInstance(instance, roleModel);
				if(count <= THRESHOLD){
					return true;
				}
				return false;
			}

			@Override
			public void progressMade(int progress, int total) {
				System.out.println(progress + "/" + total);
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
	
	protected void printInstance(MotifInstance<MetamodelVertex, EReferenceEdge> instance, RoleModel roleModel) {
		MotifInstance2RoleMapping conversion = new MotifInstance2RoleMapping(instance, roleModel);
		RoleMapping roleMapping = conversion.createRoleMapping();
		RolemappingPrinter2 printer = new RolemappingPrinter2(System.out, null);
//		RolemappingPrinter printer = new RolemappingPrinter(System.out, null);
		try {
			printer.print(roleMapping);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private EPackage getMetamodel(String path){
		File file = new File(path);
		assertTrue("File '" + path + "' doesn't exist", file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		EObject model = resource.getContents().get(0);
		assertTrue("Given model must contain an EPackage", model instanceof EPackage);
		return (EPackage) model;
	}
}
