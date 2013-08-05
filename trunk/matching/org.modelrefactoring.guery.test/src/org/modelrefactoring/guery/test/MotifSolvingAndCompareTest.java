package org.modelrefactoring.guery.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import nz.ac.massey.cs.guery.ComputationMode;
import nz.ac.massey.cs.guery.GQL;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifReader;
import nz.ac.massey.cs.guery.MotifReaderException;
import nz.ac.massey.cs.guery.impl.MultiThreadedGQLImpl;
import nz.ac.massey.cs.guery.io.dsl.DefaultMotifReader;

import org.apache.commons.collections.CollectionUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.java.resource.JaMoPPUtil;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingPrinter2;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.modelrefactoring.guery.GueryFactory;
import org.modelrefactoring.guery.GueryPackage;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;
import org.modelrefactoring.guery.io.ModelMotifReader;
import org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation;
import org.modelrefactoring.guery.resource.guery.mopp.GueryResourceFactory;
import org.modelrefactoring.matching.guery.MotifInstance2RoleMappingConverter;
import org.modelrefactoring.matching.guery.RoleModel2MotifConverter;

import com.google.common.io.Files;

@RunWith(Parameterized.class)
public class MotifSolvingAndCompareTest {

	private static final String CONFIG_FILE_PATH		= "config/MotifSolvingAndCompareTest.config";
	
	private EPackage metamodel;
	private RoleModel roleModel;
	private int maxPathLength;
	private int maxResults;
	
	public MotifSolvingAndCompareTest(EPackage metamodel, RoleModel roleModel, int maxPathLength, int maxResults){
		this.metamodel = metamodel;
		this.roleModel = roleModel;
		this.maxPathLength = maxPathLength;
		this.maxResults = maxResults;
	}
	
	@Parameters
	public static Collection<Object[]> initParameterData(){
		initLanguages();
		List<Object[]> readData = new ArrayList<Object[]>();
		File configFile = new File(CONFIG_FILE_PATH);
		assertTrue("Config file " + CONFIG_FILE_PATH + " must exist", configFile.exists());
		try {
			List<String> lines = Files.readLines(configFile, Charset.defaultCharset());
			for (String line : lines) {
				if(!line.startsWith("//") && !line.trim().isEmpty()){
					String[] parts = line.split(";");
					assertTrue("There must be exactly 4 parts in each line", parts.length == 4);
					String metamodelString = parts[0].trim();
					String rolemodelString = parts[1].trim();
					String maxPathLengthString = parts[2].trim();
					String maxResultsCountString = parts[3].trim();
					EPackage metamodel = null;
					if(metamodelString.startsWith("http")){
						metamodel = (EPackage) EPackage.Registry.INSTANCE.get(metamodelString);
					} else {
						metamodel = initMetamodel(metamodelString);
					}
					assertNotNull("Metamodel " + metamodelString + " couldn't be loaded", metamodel);
					RoleModel roleModel = initRoleModel(rolemodelString);
					assertNotNull("RoleModel " + rolemodelString + " couldn't be loaded", roleModel);
					int maxPathLength = Integer.parseInt(maxPathLengthString);
					int maxResultsCount = Integer.parseInt(maxResultsCountString);
					readData.add(new Object[]{metamodel, roleModel, maxPathLength, maxResultsCount});
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue("No config data could be found in " + CONFIG_FILE_PATH, readData.size() > 0);
		return readData;
	}

	@Test
	public void testAndCompareGueryAndEMFTextParsedGUERYQuerying() {
		System.out.println();
		System.out.println("##################################");
		System.out.println("Metamodel: " + metamodel.getName());
		System.out.println("RoleModel: " + roleModel.getName());
		System.out.println("Max PathLength: " + maxPathLength);
		System.out.println("Max Results: " + maxResults);
		List<org.modelrefactoring.guery.Motif> motifs = convertRoleModel2Motifs(roleModel);
		for (org.modelrefactoring.guery.Motif motif : motifs) {
			String uriString = motif.eResource().getURI().toFileString();
			List<RoleMapping> gueryParsingRoleMappings = testMotifOnMetamodelWithGUERYParsing(uriString, metamodel.eResource(), roleModel);
			List<RoleMapping> emfTextParsingRoleMappings = testMotifOnMetamodelWithEMFTextParsing(uriString, metamodel.eResource(), roleModel);
//			File gueryParsedFile = saveRolemappings(gueryParsingRoleMappings, metamodel, "GUERY");
//			File emftextParsedFile = saveRolemappings(emfTextParsingRoleMappings, metamodel, "EMFText");
			System.out.println("GUERY count: " + gueryParsingRoleMappings.size());
//			System.out.println("all GUERY results can be found in " + JENKINS_LINK_PREFIX + gueryParsedFile.getPath());
//			System.out.println("[[ATTACHMENT|" + gueryParsedFile.getAbsolutePath() + "]]");
//			System.out.println("[[ATTACHMENT|" + gueryParsedFile.getPath() + "]]");
			System.out.println("EMFText count: " + emfTextParsingRoleMappings.size());
//			System.out.println("all EMFText results can be found in " + JENKINS_LINK_PREFIX + emftextParsedFile.getPath());
			List<String> printedGueryRoleMappings = printRoleMappings(gueryParsingRoleMappings);
			List<String> printedEMFTextRoleMappings = printRoleMappings(emfTextParsingRoleMappings);
			compare(printedGueryRoleMappings, printedEMFTextRoleMappings, metamodel, roleModel);
		}
	}

	private List<org.modelrefactoring.guery.Motif> convertRoleModel2Motifs(RoleModel roleModel) {
		RoleModel2MotifConverter converter = new RoleModel2MotifConverter(roleModel);
		MotifModel motifModel = converter.createMotifModel(maxPathLength);
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

	private static RoleModel initRoleModel(String path) {
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
	private void compare(List<String> gueryRoleMappings, List<String> emftextRoleMappings, EPackage metamodel, RoleModel roleModel) {
		assertEquals("Both result lists must have the same size", gueryRoleMappings.size(), emftextRoleMappings.size());
		Collections.sort(gueryRoleMappings, String.CASE_INSENSITIVE_ORDER);
		Collections.sort(emftextRoleMappings, String.CASE_INSENSITIVE_ORDER);
		List<String> gueryAdditionals = (List<String>) CollectionUtils.subtract(gueryRoleMappings, emftextRoleMappings);
		List<String> emftextAdditionals = (List<String>) CollectionUtils.subtract(emftextRoleMappings, gueryRoleMappings);
//		File gueryAdditionalsFile = printAndSaveAdditionals(gueryAdditionals, metamodel, roleModel, "GUERY");
//		File emftextAdditionalsFile = printAndSaveAdditionals(emftextAdditionals, metamodel, roleModel, "EMFText");
//		if(gueryAdditionals.size() > 0 || emftextAdditionals.size() > 0){
//			System.out.println("Solving of the generated motif for the role model '" + roleModel.getName() + "' for metamodel " + metamodel.getName() + " caused different results:");
//			System.out.println("additional RoleMappings solved by GUERY-parsing can be found in: " + JENKINS_LINK_PREFIX + gueryAdditionalsFile.getPath());
//			System.out.println("additional RoleMappings solved by EMFText-parsing can be found in: " + JENKINS_LINK_PREFIX + emftextAdditionalsFile.getPath());
//		}
		assertTrue("Solved role mappings are not equal: " + metamodel.getName() + ", " + roleModel.getName(), gueryAdditionals.size() == 0 && emftextAdditionals.size() == 0);
		System.out.println("Both solving results are equal --> test succeeds");
	}

	private List<RoleMapping> solveMotifOnResource(Motif<MetamodelVertex, EReferenceEdge> motif, Resource resource, final RoleModel roleModel){
		MotifInstance2RoleMappingConverter converter = new MotifInstance2RoleMappingConverter(roleModel, maxResults);
		GQL<MetamodelVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<MetamodelVertex, EReferenceEdge>(1);
		EPackageGraphAdapter graphAdapter = new EPackageGraphAdapter(resource);
		engine.query(graphAdapter, motif, converter, ComputationMode.ALL_INSTANCES);
		List<RoleMapping> foundRoleMappings = converter.getFoundRoleMappings();
		return foundRoleMappings;
	}

	private List<String> printRoleMappings(List<RoleMapping> roleMappings) {
		List<String> printedRoleMappings = new ArrayList<String>();
		for (RoleMapping roleMapping : roleMappings) {
			String printedRoleMapping = printRoleMapping(roleMapping);
			printedRoleMappings.add(printedRoleMapping);
		}
		return printedRoleMappings;
	}

	private String printRoleMapping(RoleMapping roleMapping) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		RolemappingPrinter2 printer = new RolemappingPrinter2(out, null);
		try {
			printer.print(roleMapping);
			out.close();
			return out.toString().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static EPackage initMetamodel(String path){
		File file = new File(path);
		assertTrue("File '" + path + "' doesn't exist", file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		EObject model = resource.getContents().get(0);
		assertTrue("Given model must contain an EPackage", model instanceof EPackage);
		return (EPackage) model;
	}
	
	
	private static void initLanguages(){
		EPackage.Registry.INSTANCE.put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new GueryMetaInformation().getSyntaxName(), new GueryResourceFactory());
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolestextMetaInformation().getSyntaxName(), new RolestextResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolemappingMetaInformation().getSyntaxName(), new RolemappingResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
		JaMoPPUtil.initialize();
		EPackage.Registry.INSTANCE.put(ConcretesyntaxPackage.eNS_URI, ConcretesyntaxPackage.eINSTANCE);
	}
	
	private <Vertex extends EObjectVertex> nz.ac.massey.cs.guery.Motif<Vertex, EReferenceEdge> getMotifByModel(String path){
		File file = new File(path);
		assertTrue("File '" + path + "' doesn't exist", file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		EObject model = resource.getContents().get(0);
		assertTrue("Given model must be an instance of MotifModel", model instanceof MotifModel);
		org.modelrefactoring.guery.Motif motif = ((MotifModel) model).getMotifs().get(0);
		ModelMotifReader<Vertex> reader = new ModelMotifReader<Vertex>(motif);
		nz.ac.massey.cs.guery.Motif<Vertex, EReferenceEdge> gueryMotif;
		try {
			gueryMotif = reader.read(null);
			return gueryMotif;
		} catch (MotifReaderException e) {
			e.printStackTrace();
			fail("MotifReader threw exception");
		}
		return null;
	}
	
	private <Vertex extends EObjectVertex> nz.ac.massey.cs.guery.Motif<Vertex, EReferenceEdge> getMotifByGuery(String path){
		File file = new File(path);
		assertTrue("File '" + path + "' doesn't exist", file.exists());
		try {
			FileInputStream stream = new FileInputStream(file);
			MotifReader<Vertex, EReferenceEdge> reader = new DefaultMotifReader<Vertex, EReferenceEdge>();
			nz.ac.massey.cs.guery.Motif<Vertex, EReferenceEdge> motif = reader.read(stream);
			return motif;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("File '" + path + "' wasn't found");
		} catch (MotifReaderException e) {
			e.printStackTrace();
			fail(path + " couldn't be parsed: " + e.getLocalizedMessage());
		}
		return null;
	}
}
