package org.modelrefactoring.guery.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
import org.emftext.language.java.resource.JaMoPPUtil;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.language.timedAutomata.TimedAutomataPackage;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.modelrefactoring.guery.GueryPackage;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;
import org.modelrefactoring.guery.io.ModelMotifReader;
import org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation;
import org.modelrefactoring.guery.resource.guery.mopp.GueryResourceFactory;
import org.modelrefactoring.matching.guery.RoleModel2MotifConverter;

import com.google.common.base.Joiner;
import com.google.common.io.Files;

@RunWith(Parameterized.class)
public class MotifSolvingAndSaveTest {

	private static final String CONFIG_FILE_PATH		= "config/MotifSolvingAndSaveTest.config";
	//	private static final String JENKINS_LINK_PREFIX	= "http://hudson-st.inf.tu-dresden.de:8080/job/GUERY%20DSL%20and%20Tests/ws/build/artifacts/projects/org.modelrefactoring.guery.test/";

	private static CSVPrinter csvPrinter;
	private static File statisticsFile;

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
	private int vertexCount;

	private int edgeCount;

	private double edgesPerVertex;
	
	@Parameters(name = "MM = {4} | RM = {5} | MPL = {2} | MR = {3}")
	public static Collection<Object[]> initParameterData(){
		initLanguages();
		initCSVPrinter();
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

	private static void initCSVPrinter() {
		// 15 Spalten
		String[] header = new String[]{"Metamodel", "RoleModel", "MC Count", "SF Count", "SF/MC", "V Count", "E Count", "E/V", "R Count", "C Count", "C/R", "MPL", "Max Results", "Roles", "Overall time (s)", "Saving time (s)", "Query time (s)", "Found RoleMappings"};
		CSVFormat csvFormat = CSVFormat.EXCEL.withHeader(header).withDelimiter(';');
		String statisticsFilePath = "statistics/matching_" + System.currentTimeMillis() + ".csv";
		statisticsFile = new File(statisticsFilePath);
		if(statisticsFile.exists()){
			statisticsFile.delete();
		}
		FileWriter writer;
		csvPrinter = null;
		try {
			writer = new FileWriter(statisticsFile);
			csvPrinter = csvFormat.print(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void finishTest(){
		if(csvPrinter != null){
			try {
				csvPrinter.close();
				System.out.println("statistics saved at");
				System.out.println("[[ATTACHMENT|" + statisticsFile.getAbsoluteFile().getPath() + "]]");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testAndGenerateRoleMappings() {
		System.out.println();
		System.out.println("##################################");
		List<EClass> metaclasses = getMetaClasses(metamodel);
		List<EStructuralFeature> structuralFeatures = getStructuralFeatures(metaclasses);

		int metaclassCount = metaclasses.size();
		int featureCount = structuralFeatures.size();
		double featuresPerClass = (double) featureCount / (double) metaclassCount;
		System.out.println("Metamodel: " + metamodel.getName() + " (MC: " + metaclassCount + ", SF: " + featureCount + ")");
		System.out.println("Features/Metaclass: " + featuresPerClass);
		int roleCount = roleModel.getRoles().size();
		int collCount = roleModel.getCollaborations().size();
		double colPerRole = (double) collCount / (double) roleCount;
		System.out.println("RoleModel: " + roleModel.getName() + " (R: " + roleCount + ", C: " + collCount + ")");
		System.out.println("Collaborations/Role: " + colPerRole);
		System.out.println("Max PathLength: " + maxPathLength);
		System.out.println("Max Results: " + maxResults);
		List<org.modelrefactoring.guery.Motif> motifs = convertRoleModel2MotifModel().getMotifs();
		int index = 0;
		for (org.modelrefactoring.guery.Motif motif : motifs) {
			Motif<MetamodelVertex, EReferenceEdge> motifByModel = this.<MetamodelVertex>getGueryMotifByMotif(motif);
			String queriedRoles = Joiner.on(", ").join(motifByModel.getRoles());
			System.out.println("Used roles: " + queriedRoles);
			String resultFilePath = "rolemappings/" + metamodel.getName() + "_" + roleModel.getName() + "_MPL" + maxPathLength + "_XSIMPLE" + index + "." + new RolemappingMetaInformation().getSyntaxName();
			FileWriteResultListener writeResultListener = solveMotifOnResource(motifByModel, resultFilePath);
			double timeToWriteInSeconds = writeResultListener.getTimeToWriteInSeconds();
			double overallTimeInSeconds = writeResultListener.getOverallTimeInSeconds();
			double queryTime = overallTimeInSeconds - timeToWriteInSeconds;
			System.out.println("Very simple String-based saving took: " + timeToWriteInSeconds + "s");
			System.out.println("Overall time took: " + overallTimeInSeconds + "s");
			System.out.println("Querying took approximately (overall - saving): " + queryTime + "s");
			int foundRoleMappingsCount = writeResultListener.getFoundRoleMappingsCount();
			System.out.println("Found possible role mappings: " + foundRoleMappingsCount);

			// "Metamodel", "RoleModel", "MC Count", "SF Count", "SF/MC", "V Count", "E Count", "E/V", "R Count", "C Count", "C/R", "MPL", "Max Results", "Roles", "Overall time (s)", "Saving time (s)", "Query time (s)", "Found RoleMappings"
			if(csvPrinter != null){
				try {
					csvPrinter.printRecord(metamodelName, rolemodelName, metaclassCount, featureCount, doubleToString(featuresPerClass), doubleToString(vertexCount), doubleToString(edgeCount), doubleToString(edgesPerVertex), roleCount, collCount, doubleToString(colPerRole), maxPathLength, maxResults, queriedRoles, doubleToString(overallTimeInSeconds), doubleToString(timeToWriteInSeconds), doubleToString(queryTime), foundRoleMappingsCount);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			File absFile = writeResultListener.getFile();
			System.out.println("persisted role mappings:");
			System.out.println("[[ATTACHMENT|" + absFile.getPath() + "]]");
			System.out.println();
			index++;
		}
	}

	private String doubleToString(double value){
		String valueString = String.valueOf(value);
		valueString = valueString.replace(".", ",");
		return valueString;
	}
	
	private List<EStructuralFeature> getStructuralFeatures(List<EClass> metaclasses) {
		List<EStructuralFeature> structuralFeatures = new ArrayList<EStructuralFeature>();
		for (EClass metaclass : metaclasses) {
			structuralFeatures.addAll(metaclass.getEStructuralFeatures());
		}
		return structuralFeatures;
	}

	private List<EClass> getMetaClasses(EPackage epackage) {
		List<EClass> metaclasses = new ArrayList<EClass>();
		List<EClassifier> classifiers = epackage.getEClassifiers();
		for (EClassifier classifier : classifiers) {
			if(classifier instanceof EClass){
				metaclasses.add((EClass) classifier);
			}
		}
		List<EPackage> subpackages = epackage.getESubpackages();
		for (EPackage subpackage : subpackages) {
			metaclasses.addAll(getMetaClasses(subpackage));
		}
		return metaclasses;
	}

	private MotifModel convertRoleModel2MotifModel() {
		RoleModel2MotifConverter converter = new RoleModel2MotifConverter(roleModel);
		MotifModel motifModel = converter.createMotifModel(maxPathLength);
		Resource roleModelResource = roleModel.eResource();
		ResourceSet rs = roleModelResource.getResourceSet();
		String gueryFileName = "queries/" + metamodelName + "_" + rolemodelName + "_MPL" + maxPathLength + "." + new GueryMetaInformation().getSyntaxName();
		File gueryFile = new File(gueryFileName);
		if(gueryFile.exists()){
			gueryFile.delete();
		}
		URI uri = URI.createFileURI(gueryFile.getAbsolutePath());
		Resource resource = rs.createResource(uri);
		resource.getContents().add(motifModel);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//		}
		return motifModel;
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

	//	private FileWriteResultListener testMotifOnMetamodel(org.modelrefactoring.guery.Motif motif, String filePath){
	//		Motif<MetamodelVertex, EReferenceEdge> motifByModel = this.<MetamodelVertex>getGueryMotifByMotif(motif);
	//		return solveMotifOnResource(motifByModel, filePath);
	//	}


	private FileWriteResultListener solveMotifOnResource(Motif<MetamodelVertex, EReferenceEdge> motif, String filePath){
		//		int processors = Runtime.getRuntime().availableProcessors();
		int processors = 1;
		GQL<MetamodelVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<MetamodelVertex, EReferenceEdge>(processors);
		EPackageGraphAdapter graphAdapter = getGraphAdapter();
		graphAdapter.initialiseGraph();
		vertexCount = graphAdapter.getVertexCount();
		edgeCount = graphAdapter.getEdgeCount();
		edgesPerVertex = (double) edgeCount / (double) vertexCount;
		System.out.println("Vertex count: " + vertexCount);
		System.out.println("Edge count: " + edgeCount);
		System.out.println("Edges/Vertex: " + edgesPerVertex);
		FileWriteResultListener listener = new FileWriteResultListener(roleModel, maxResults, filePath);

		long start = System.currentTimeMillis();
		engine.query(graphAdapter, motif, listener, ComputationMode.ALL_INSTANCES);
		long end = System.currentTimeMillis();
		double overallTimeInSeconds = (end - start)/1000.0d;
		listener.setOverallUsedTime(overallTimeInSeconds);

		return listener;
	}

	public EPackageGraphAdapter getGraphAdapter() {
		return new EPackageGraphAdapter(metamodel);
	}


	private static EPackage initMetamodel(String path){
		File file = new File(path);
		assertTrue("File '" + path + "' doesn't exist", file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = null;
		if(path.endsWith(".text.ecore")){
			TextEcoreResourceFactory factory = new TextEcoreResourceFactory();
			resource = factory.createResource(uri);
			try {
				resource.load(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			resource = rs.getResource(uri, true);
		}
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
		EPackage.Registry.INSTANCE.put(Bpmn2Package.eNS_URI, Bpmn2Package.eINSTANCE);
		EPackage.Registry.INSTANCE.put(TimedAutomataPackage.eNS_URI, TimedAutomataPackage.eINSTANCE);
	}

	private <Vertex extends EObjectVertex> nz.ac.massey.cs.guery.Motif<Vertex, EReferenceEdge> getGueryMotifByMotif(org.modelrefactoring.guery.Motif motif){
		assertNotNull("Motif mustn't be null", motif);
		//		File file = new File(path);
		//		assertTrue("File '" + path + "' doesn't exist", file.exists());
		//		URI uri = URI.createFileURI(file.getAbsolutePath());
		//		ResourceSet rs = new ResourceSetImpl();
		//		Resource resource = rs.getResource(uri, true);
		//		EObject model = resource.getContents().get(0);
		//		assertTrue("Given model must be an instance of MotifModel", model instanceof MotifModel);
		//		org.modelrefactoring.guery.Motif motif = ((MotifModel) model).getMotifs().get(0);
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
