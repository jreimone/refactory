package org.modelrefactoring.guery.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import nz.ac.massey.cs.guery.ComputationMode;
import nz.ac.massey.cs.guery.GQL;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifReaderException;
import nz.ac.massey.cs.guery.impl.MultiThreadedGQLImpl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.emftext.language.java.resource.JaMoPPUtil;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingFactory;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingPrinter2;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
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
public class MotifSolvingAndSaveTest {

	private static final String CONFIG_FILE_PATH		= "config/MotifSolvingAndSaveTest.config";
	private static final String JENKINS_LINK_PREFIX	= "http://hudson-st.inf.tu-dresden.de:8080/job/GUERY%20DSL%20and%20Tests/ws/build/artifacts/projects/org.modelrefactoring.guery.test/";

	@Parameter(0)
	public EPackage metamodel;
	@Parameter(1)
	public RoleModel roleModel;
	@Parameter(2)
	public int maxPathLength;
	@Parameter(3)
	public int maxResults;
	@Parameter(4)
	public String metamodelName;
	@Parameter(5)
	public String rolemodelName;

	@Parameters(name = "MM = {4} | RM = {5} | MPL = {2} | MR = {3}")
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
					readData.add(new Object[]{metamodel, roleModel, maxPathLength, maxResultsCount, metamodel.getName(), roleModel.getName()});
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue("No config data could be found in " + CONFIG_FILE_PATH, readData.size() > 0);
		return readData;
	}

	@Test
	public void testAndGenerateRoleMappings() {
		System.out.println();
		System.out.println("##################################");
		System.out.println("Metamodel: " + metamodel.getName());
		System.out.println("RoleModel: " + roleModel.getName());
		System.out.println("Max PathLength: " + maxPathLength);
		System.out.println("Max Results: " + maxResults);
		List<org.modelrefactoring.guery.Motif> motifs = convertRoleModel2Motifs();
		for (org.modelrefactoring.guery.Motif motif : motifs) {
			String uriString = motif.eResource().getURI().toFileString();
			List<RoleMapping> emfTextParsingRoleMappings = testMotifOnMetamodel(uriString, metamodel.eResource(), roleModel);
//			long start = System.currentTimeMillis();
//			File emftextParsedFile = saveRolemappings(emfTextParsingRoleMappings);
//			long end = System.currentTimeMillis();
//			double seconds = (end - start)/1000.0d;
//			System.out.println("EMF-based saving took: " + seconds + "s");
//			start = System.currentTimeMillis();
//			File simpleEmftextParsedFile = saveRoleMappingsTextBased(emfTextParsingRoleMappings);
//			end  = System.currentTimeMillis();
//			seconds = (end - start)/1000.0d;
//			System.out.println("String-based saving took: " + seconds + "s");
			long start = System.currentTimeMillis();
			File verySimpleParsedFile = saveRoleMappingsTextBasedVerySimple(emfTextParsingRoleMappings);
			long end  = System.currentTimeMillis();
			double seconds = (end - start)/1000.0d;
			System.out.println("Very simple String-based saving took: " + seconds + "s");
			System.out.println("Found possible role mappings: " + emfTextParsingRoleMappings.size());
			File absFile = verySimpleParsedFile.getAbsoluteFile();
			int count = 0;
			File temp = absFile;
			File parent = null;
			while (temp.getParentFile() != null && count <= 6) {
				parent = temp;
				temp = temp.getParentFile();
				count++;
			}
			File wsFile = parent.getAbsoluteFile();
			System.out.println("Workspace: " + wsFile.getPath());
			java.net.URI relativize = wsFile.toURI().relativize(absFile.toURI());
//			System.out.println("Workspace relative: " + relativize.toString());
//			System.out.println("all results can be found in " + JENKINS_LINK_PREFIX + verySimpleParsedFile.getPath());
			System.out.println("relative path to workspace:");
			System.out.println("[[ATTACHMENT|/" + relativize.getPath() + "]]");
			System.out.println("absolute path:");
			System.out.println("[[ATTACHMENT|" + absFile.getPath() + "]]");
		}
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

	private File saveRoleMappingsTextBased(List<RoleMapping> parsedRoleMappings){
		File file = new File("rolemappings/" + metamodel.getName() + "_" + roleModel.getName() + "_SIMPLE_" + "." + new RolemappingMetaInformation().getSyntaxName());
		if(file.exists()){
			file.delete();
		}
		try {
			FileWriter writer = new FileWriter(file, true);
			for (RoleMapping roleMapping : parsedRoleMappings) {
				String printedRoleMapping = printRoleMapping(roleMapping);
				writer.append(printedRoleMapping);
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	private File saveRoleMappingsTextBasedVerySimple(List<RoleMapping> parsedRoleMappings){
		File file = new File("rolemappings/" + metamodel.getName() + "_" + roleModel.getName() + "_MPL" + maxPathLength + "_XSIMPLE" + "." + new RolemappingMetaInformation().getSyntaxName());
		if(file.exists()){
			file.delete();
		}
		try {
			FileWriter writer = new FileWriter(file, true);
			for (RoleMapping roleMapping : parsedRoleMappings) {
				String printedRoleMapping = printRoleMappingVerySimple(roleMapping);
				writer.append(printedRoleMapping);
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	private String printRoleMappingVerySimple(RoleMapping roleMapping) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(roleMapping.getName() + "{");
		List<ConcreteMapping> concreteMappings = roleMapping.getRoleToMetaelement();
		for (ConcreteMapping concreteMapping : concreteMappings) {
			Role role = concreteMapping.getRole();
			EClass metaclass = concreteMapping.getMetaclass();
			buffer.append(role.getName() + ":=");
			List<EPackage> packagesOfMetaclass = concreteMapping.getPackagesOfMetaclass();
			for (EPackage package_ : packagesOfMetaclass) {
				buffer.append(package_.getName() + ".");
			}
			buffer.append(metaclass.getName());
			List<CollaborationMapping> collaborationMappings = concreteMapping.getCollaborationMappings();
			if(collaborationMappings.size() > 0){
				buffer.append("[");
				for (CollaborationMapping collaborationMapping : collaborationMappings) {
					MultiplicityCollaboration collaboration = collaborationMapping.getCollaboration();
					buffer.append(collaboration.getTargetName() + ":=");
					List<ReferenceMetaClassPair> referenceMetaClassPairs = collaborationMapping.getReferenceMetaClassPair();
					int size = referenceMetaClassPairs.size();
					for (ReferenceMetaClassPair referenceMetaClassPair : referenceMetaClassPairs) {
						EReference reference = referenceMetaClassPair.getReference();
						EClass metaClass2 = referenceMetaClassPair.getMetaClass();
						int indexOf = referenceMetaClassPairs.indexOf(referenceMetaClassPair);
						buffer.append(reference.getName() + (metaClass2 != null?":" + metaClass2.getName():"") + (indexOf + 1 == size?"":"->"));					
					}
					buffer.append(";");
				}
				buffer.append("]");
			}
			buffer.append(";");
		}
		buffer.append("}\n");
		return buffer.toString();
	}

	private File saveRolemappings(List<RoleMapping> parsedRoleMappings) {
		RoleMappingModel roleMappingModel = RolemappingFactory.eINSTANCE.createRoleMappingModel();
		roleMappingModel.setTargetMetamodel(metamodel);
		roleMappingModel.getMappings().addAll(parsedRoleMappings);
		RoleModel roleModel = parsedRoleMappings.get(0).getMappedRoleModel();
		File file = new File("rolemappings/" + metamodel.getName() + "_" + roleModel.getName() + "." + new RolemappingMetaInformation().getSyntaxName());
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
		return file;
	}

	private List<org.modelrefactoring.guery.Motif> convertRoleModel2Motifs() {
		RoleModel2MotifConverter converter = new RoleModel2MotifConverter(roleModel);
		MotifModel motifModel = converter.createMotifModel(maxPathLength);
		Resource roleModelResource = roleModel.eResource();
		ResourceSet rs = roleModelResource.getResourceSet();
		URI roleModelUri = roleModelResource.getURI();
		List<org.modelrefactoring.guery.Motif> returnedMotifs = new ArrayList<org.modelrefactoring.guery.Motif>();
		List<org.modelrefactoring.guery.Motif> motifs = motifModel.getMotifs();
		ArrayList<org.modelrefactoring.guery.Motif> temp = new ArrayList<org.modelrefactoring.guery.Motif>(motifs);
		for (org.modelrefactoring.guery.Motif motif : temp) {
			String gueryFileName = "queries/" + roleModelUri.lastSegment().replace("." + roleModelUri.fileExtension(), "_" + metamodelName + "_MPL" + maxPathLength + "." + new GueryMetaInformation().getSyntaxName());
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

	private List<RoleMapping> testMotifOnMetamodel(String motifPath, Resource metamodelResource, RoleModel roleModel){
		Motif<MetamodelVertex, EReferenceEdge> motifByModel = this.<MetamodelVertex>getMotifByPath(motifPath);
		return solveMotifOnResource(motifByModel, metamodelResource, roleModel);
	}


	private List<RoleMapping> solveMotifOnResource(Motif<MetamodelVertex, EReferenceEdge> motif, Resource resource, final RoleModel roleModel){
		MotifInstance2RoleMappingConverter converter = new MotifInstance2RoleMappingConverter(roleModel, maxResults);
//		int processors = Runtime.getRuntime().availableProcessors();
		int processors = 1;
		GQL<MetamodelVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<MetamodelVertex, EReferenceEdge>(processors);
		EPackageGraphAdapter graphAdapter = new EPackageGraphAdapter(resource);
		engine.query(graphAdapter, motif, converter, ComputationMode.ALL_INSTANCES);
		List<RoleMapping> foundRoleMappings = converter.getFoundRoleMappings();
		return foundRoleMappings;
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
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
	}

	private <Vertex extends EObjectVertex> nz.ac.massey.cs.guery.Motif<Vertex, EReferenceEdge> getMotifByPath(String path){
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

}
