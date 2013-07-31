package org.modelrefactoring.guery.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nz.ac.massey.cs.guery.ComputationMode;
import nz.ac.massey.cs.guery.GQL;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.impl.MultiThreadedGQLImpl;

import org.apache.commons.collections.CollectionUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingFactory;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingPrinter2;
import org.emftext.language.refactoring.roles.RoleModel;
import org.junit.Test;
import org.modelrefactoring.guery.GueryFactory;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;
import org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation;
import org.modelrefactoring.matching.guery.MotifInstance2RoleMappingConverter;
import org.modelrefactoring.matching.guery.RoleModel2MotifConverter;

public class MotifSolvingTest extends MotifAdapterTest {
	
	private static final int THRESHOLD 		= 1000;
	private static final int MAX_PATH_LENGTH	= 3;
	
	@Test
	public void testPL0ExtractXwithReferenceClass(){
		EPackage pl0MM = PL0Package.eINSTANCE;
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
		Resource pl0MMResource = pl0MM.eResource();
		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
		RoleModel roleModel = initRoleModel("rolemodels/ExtractXwithReferenceClass.rolestext");
		testGueryAndEMFTextParsing(roleModel, pl0MM);
	}
	
	@Test
	public void testSimpleMM(){
		testGueryAndEMFTextParsing("rolemodels/ExtractXwithReferenceClass.rolestext", "metamodels/EExtractXWithReferenceClass.ecore");
	}

	private void testGueryAndEMFTextParsing(String roleModelPath, String metamodelPath){
		RoleModel roleModel = initRoleModel(roleModelPath);
		EPackage metamodel = initMetamodel(metamodelPath);
		testGueryAndEMFTextParsing(roleModel, metamodel);
	}

	private void testGueryAndEMFTextParsing(RoleModel roleModel, EPackage metamodel) {
		System.out.println("##################################");
		System.out.println("Metamodel: " + metamodel.getName());
		System.out.println("RoleModel: " + roleModel.getName());
		System.out.println("Max PathLength: " + MAX_PATH_LENGTH);
		System.out.println("Max Results: " + THRESHOLD);
		List<org.modelrefactoring.guery.Motif> motifs = convertRoleModel2Motifs(roleModel);
		for (org.modelrefactoring.guery.Motif motif : motifs) {
			String uriString = motif.eResource().getURI().toFileString();
			List<RoleMapping> gueryParsingRoleMappings = testMotifOnMetamodelWithGUERYParsing(uriString, metamodel.eResource(), roleModel);
			List<RoleMapping> emfTextParsingRoleMappings = testMotifOnMetamodelWithEMFTextParsing(uriString, metamodel.eResource(), roleModel);
			saveRolemappings(gueryParsingRoleMappings, metamodel, "GUERY");
			saveRolemappings(emfTextParsingRoleMappings, metamodel, "EMFText");
			System.out.println("Results:\n");
			List<String> printedGueryRoleMappings = printRoleMappings(gueryParsingRoleMappings);
			List<String> printedEMFTextRoleMappings = printRoleMappings(emfTextParsingRoleMappings);
			System.out.println("GUERY count: " + printedGueryRoleMappings.size());
			System.out.println("EMFText count: " + printedEMFTextRoleMappings.size());
			compare(printedGueryRoleMappings, printedEMFTextRoleMappings);
		}
	}

	private void saveRolemappings(List<RoleMapping> parsedRoleMappings, EPackage metamodel, String type) {
		RoleMappingModel roleMappingModel = RolemappingFactory.eINSTANCE.createRoleMappingModel();
		roleMappingModel.setTargetMetamodel(metamodel);
		roleMappingModel.getMappings().addAll(parsedRoleMappings);
		File file = new File("rolemappings/" + metamodel.getName() + "_" + type + "." + new RolemappingMetaInformation().getSyntaxName());
		if(file.exists()){
			file.delete();
		}
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(uri);
		resource.getContents().add(roleMappingModel);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<org.modelrefactoring.guery.Motif> convertRoleModel2Motifs(RoleModel roleModel) {
		RoleModel2MotifConverter converter = new RoleModel2MotifConverter(roleModel);
		MotifModel motifModel = converter.createMotifModel(MAX_PATH_LENGTH);
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
	
	private List<RoleMapping> testMotifOnMetamodelWithGUERYParsing(String motifPath, Resource metamodelResource, RoleModel roleModel){
		Motif<MetamodelVertex, EReferenceEdge> motifByGuery = this.<MetamodelVertex>getMotifByGuery(motifPath);
		return solveMotifOnResource(motifByGuery, metamodelResource, roleModel);
	}
	
	private List<RoleMapping> testMotifOnMetamodelWithEMFTextParsing(String motifPath, Resource metamodelResource, RoleModel roleModel){
		Motif<MetamodelVertex, EReferenceEdge> motifByModel = this.<MetamodelVertex>getMotifByModel(motifPath);
		return solveMotifOnResource(motifByModel, metamodelResource, roleModel);
	}
	
	@SuppressWarnings("unchecked")
	private void compare(List<String> gueryRoleMappings, List<String> emftextRoleMappings) {
		assertEquals("Both result lists must have the same size", gueryRoleMappings.size(), emftextRoleMappings.size());
		Collections.sort(gueryRoleMappings);
		Collections.sort(emftextRoleMappings);
		ArrayList<String> gueryAdditionals = (ArrayList<String>) CollectionUtils.subtract(gueryRoleMappings, emftextRoleMappings);
		ArrayList<String> emftextAdditionals = (ArrayList<String>) CollectionUtils.subtract(emftextRoleMappings, gueryRoleMappings);
		if(gueryAdditionals.size() != 0){
			System.out.println("The following role mappings couldn't be solved by EMFText parsing:");
			for (String string : gueryAdditionals) {
				System.out.println("\n" + string);
			}
		}
		if(emftextAdditionals.size() != 0){
			System.out.println("The following role mappings couldn't be solved by GUERY parsing:");
			for (String string : emftextAdditionals) {
				System.out.println("\n" + string);
			}
		}
		assertTrue("Solved role mappings are not equal", gueryAdditionals.size() == 0 && emftextAdditionals.size() == 0);
	}

	private List<RoleMapping> solveMotifOnResource(Motif<MetamodelVertex, EReferenceEdge> motif, Resource resource, final RoleModel roleModel){
		MotifInstance2RoleMappingConverter converter = new MotifInstance2RoleMappingConverter(roleModel, THRESHOLD);
		GQL<MetamodelVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<MetamodelVertex, EReferenceEdge>(1);
		EPackageGraphAdapter graphAdapter = new EPackageGraphAdapter(resource);
		engine.query(graphAdapter, motif, converter, ComputationMode.ALL_INSTANCES);
		List<RoleMapping> foundRoleMappings = converter.getFoundRoleMappings();
		return foundRoleMappings;
	}
	
	private List<String> printRoleMappings(List<RoleMapping> roleMappings) {
		List<String> printedRoleMappings = new ArrayList<String>();
		for (RoleMapping roleMapping : roleMappings) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			RolemappingPrinter2 printer = new RolemappingPrinter2(out, null);
//			RolemappingPrinter printer = new RolemappingPrinter(out, null);
			try {
				printer.print(roleMapping);
				out.close();
				printedRoleMappings.add(out.toString().trim());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return printedRoleMappings;
	}

	private EPackage initMetamodel(String path){
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
