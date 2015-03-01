package org.modelrefactoring.guery.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
import org.emftext.language.java.resource.JaMoPPUtil;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.language.timedAutomata.TimedAutomataPackage;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.modelrefactoring.guery.GueryPackage;
import org.modelrefactoring.guery.graph.ContainmentEdge;
import org.modelrefactoring.guery.graph.EClassVertex;
import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;
import org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation;
import org.modelrefactoring.guery.resource.guery.mopp.GueryResourceFactory;

import com.google.common.io.Files;

@RunWith(Parameterized.class)
public class MetamodelGraphStatisticsTest extends AbstractPersistCSVFileTest {

	private static final String CONFIG_FILE_PATH		= "config/MetamodelGraphStatisticsTest.config";

	@Parameter(0)
	public EPackage metamodel;
	@Parameter(1)
	public String metamodelName;

	private EPackageGraphAdapter graphAdapter;

	@Parameters(name = "MM = {1}")
	public static Collection<Object[]> initParameterData(){
		initLanguages();
		List<Object[]> readData = new ArrayList<Object[]>();
		File configFile = new File(CONFIG_FILE_PATH);
		assertTrue("Config file " + CONFIG_FILE_PATH + " must exist", configFile.exists());
		try {
			List<String> lines = Files.readLines(configFile, Charset.defaultCharset());
			String csvFilePrefix = null;
			String[] csvFileHeader = null;
			for (String metamodelString : lines) {
				if(!metamodelString.startsWith("//") && !metamodelString.trim().isEmpty()){
					EPackage metamodel = null;
					if(metamodelString.startsWith(CSV_FILE_OPTION_PREFIX)){
						csvFilePrefix = metamodelString.replace(CSV_FILE_OPTION_PREFIX, "").trim();
					} else if(metamodelString.startsWith(CSV_FILE_OPTION_HEADER)){
						String headerString = metamodelString.replace(CSV_FILE_OPTION_HEADER, "");
						csvFileHeader = headerString.split(",");
					} else {
						if(metamodelString.startsWith("http")){
							metamodel = (EPackage) EPackage.Registry.INSTANCE.get(metamodelString);
						} else {
							metamodel = initMetamodel(metamodelString);
						}
						assertNotNull("Metamodel " + metamodelString + " couldn't be loaded", metamodel);
					}
					if(metamodel != null){
						readData.add(new Object[]{metamodel, metamodel.getName()});
					}
				}
			}
			if(csvFileHeader != null && csvFilePrefix != null){
				initCSVPrinter(csvFileHeader, csvFilePrefix);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue("No config data could be found in " + CONFIG_FILE_PATH, readData.size() > 0);
		return readData;
	}

	@Test
	public void testMetamodelStatistics(){
		graphAdapter = new EPackageGraphAdapter(metamodel);
		graphAdapter.initialiseGraph();
		Iterator<MetamodelVertex> vertices = graphAdapter.getVertices();
		// 1. build up the map of the metamodel for comparison
		Map<String, EClass> metaclasses = getMetaclasses(metamodel);
		List<EStructuralFeature> structuralFeatures = getStructuralFeatures(metaclasses.values());
		// 2. print and compare the graph with the previously created map
		System.out.println("~~~~~~~~~~~~~~~");
		System.out.println(metamodel.eResource().getURI().toString());
		System.out.println("vertices: " + graphAdapter.getVertexCount());
		System.out.println("edges: " + graphAdapter.getEdgeCount());
		
		int metaclassCount = metaclasses.size();
		int featureCount = structuralFeatures.size();
		double featuresPerClass = (double) featureCount / (double) metaclassCount;
		int vertexCount = graphAdapter.getVertexCount();
		int edgeCount = graphAdapter.getEdgeCount();
		double edgesPerVertex = (double) edgeCount / (double) vertexCount;
		try {
			// Metamodel ; MC ; SF ; SF/MC ; Vertices ; Edges ; E/V
			getCSVPrinter().printRecord(metamodelName, metaclasses.size(),structuralFeatures.size(), doubleToString(featuresPerClass),vertexCount, edgeCount, doubleToString(edgesPerVertex));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		Map<String, EClassVertex> vertexMetaclasses = new HashMap<String, EClassVertex>();
		while (vertices.hasNext()) {
			MetamodelVertex vertex = vertices.next();
			assertTrue("Vertex must be an " + EClassVertex.class.getSimpleName(), vertex instanceof EClassVertex);
			EClassVertex eclassVertex = (EClassVertex) vertex;
			vertexMetaclasses.put(eclassVertex.getEClass().getName(), eclassVertex);
			EObject element = vertex.getModelElement();
			assertTrue("Input was an EPackage, i.e. the wrapped vertex must be an EClass", element instanceof EClass);
			int inCount = eclassVertex.getInEdges().size();
			int outCount = eclassVertex.getOutEdges().size();
			if(printVertices()){
				System.out.println(((EClass) element).getName() + " (in: " + inCount+ ", out: " + outCount + ")");
			}
			if(printEdges()){
				Iterator<EReferenceEdge> outEdges = graphAdapter.getOutEdges(vertex);
				printEdges(outEdges, "---", "-->", true, metaclasses);
				Iterator<EReferenceEdge> inEdges = graphAdapter.getInEdges(vertex);
				printEdges(inEdges, "<--", "---", false, metaclasses);
			}
		}
		// 3. some additional comparison
		//		int eclassesCount = metaclasses.size();
		//		int vertexCount = vertexMetaclasses.size();
		compareInternalVerticesAndMetaclasses(vertexMetaclasses, metaclasses);
		//		assertEquals("The vertices must count the same as EClasses in the metamodel ", vertexCount, eclassesCount);
	}
	
	private Map<String, EClass> getMetaclasses(EPackage metamodel) {
		Map<String, EClass> metaclasses = new HashMap<String, EClass>();
		for (EClassifier classifier : metamodel.getEClassifiers()) {
			if(classifier instanceof EClass){
				EClass metaclass = (EClass) classifier;
				metaclasses.put(metaclass.getName(), metaclass);
			}
		}
		List<EPackage> subpackages = metamodel.getESubpackages();
		for (EPackage subpackage : subpackages) {
			metaclasses.putAll(getMetaclasses(subpackage));
		}
		return metaclasses;
	}
	
	private List<EStructuralFeature> getStructuralFeatures(Collection<EClass> metaclasses) {
		List<EStructuralFeature> structuralFeatures = new ArrayList<EStructuralFeature>();
		for (EClass metaclass : metaclasses) {
			structuralFeatures.addAll(metaclass.getEStructuralFeatures());
		}
		return structuralFeatures;
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
			rs.getResources().add(resource);
			try {
				resource.load(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
			EcoreUtil.resolveAll(resource);
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

	protected boolean printEdges() {
		return false;
	}

	protected boolean printVertices(){
		return false;
	}
	
	private void compareInternalVerticesAndMetaclasses(Map<String, EClassVertex> vertexMetaclasses, Map<String, EClass> metaclasses) {
		System.out.println("Vertex count: " + vertexMetaclasses.size() + "; Metaclasses count: " + metaclasses.size());
		assertEquals("Vertex and Metaclasses count must be equal", metaclasses.size(), vertexMetaclasses.size());
		for (String name : vertexMetaclasses.keySet()) {
			EClassVertex vertexMetaclass = vertexMetaclasses.get(name);
			if(vertexMetaclass.isInternal()){
				EClass metaclass = metaclasses.get(name);
				assertTrue("Vertex '" + name + "' not contained in the metamodel", metaclass != null);
				assertEquals("Vertex metaclass and real metaclass must be equal", metaclass, vertexMetaclass.getEClass());
			} else {
				System.out.println("Metaclass '" + name + "' is external");
			}
		}
		// now check the edges and references
		for (String className : vertexMetaclasses.keySet()) {
			EClassVertex vertex = vertexMetaclasses.get(className);
			EClass metaclass = metaclasses.get(className);
			Resource sourceResource = getResourceForEClass(metaclass);
			List<EReference> allOutgoingReferences = metaclass.getEAllReferences();
			List<EClass> targetClassesInSameResource = new ArrayList<EClass>();
			for (EReference outgoingReference : allOutgoingReferences) {
				EClass targetClass = outgoingReference.getEReferenceType();
				Resource targetResource = getResourceForEClass(targetClass);
				if(sourceResource.equals(targetResource)){
					targetClassesInSameResource.add(targetClass);
				}
				Set<EClass> targetSubtypes = graphAdapter.getSubTypeHierarchy().get(targetClass);
				if(targetSubtypes != null){
					for (EClass targetSubClass : targetSubtypes) {
						targetResource = getResourceForEClass(targetSubClass);
						if(sourceResource.equals(targetResource)){
							targetClassesInSameResource.add(targetSubClass);
						}
					}
				}
				// remove the count of target classes contained in another resource
			}
			int outgoingReferencesCount = targetClassesInSameResource.size();
			assertEquals("Outgoing reference and edge count of '" + className + "' must be equal", outgoingReferencesCount, vertex.getOutEdges().size());
		}
	}
	
	private Resource getResourceForEClass(EClass metaclass){
		EcoreUtil.resolveAll(metaclass);
		if(metaclass.eIsProxy()){
			return null;
		}
		EObject parent = metaclass.eContainer();
		EObject model = null;
		while (parent != null) {
			model = parent;
			parent = parent.eContainer();
		}
		return model.eResource();
	}
	
	private void printEdges(Iterator<EReferenceEdge> edges, String startArrow, String endArrow, boolean out, Map<String, EClass> metaclasses) {
		List<EReferenceEdge> edgeList = new ArrayList<EReferenceEdge>();
		while (edges.hasNext()) {
			EReferenceEdge referenceEdge = edges.next();
			edgeList.add(referenceEdge);
		}
		if(edgeList.size() > 0){
			EReferenceEdge edge = edgeList.get(0);
			EClass metaclass = null;
			//			Map<String, EReference> allReferences = new HashMap<String, EReference>();
			if(out && edge != null){
				EObjectVertex start = edge.getStart();
				EClass graphClass = (EClass) start.getModelElement();
				metaclass = metaclasses.get(graphClass.getName());
				//				List<EReference> eAllReferences = metaclass.getEAllReferences();
				//				for (EReference reference : eAllReferences) {
				//					allReferences.put(reference.getName(), reference);
				//				}
			}
			for (int i = 0; i < edgeList.size(); i++) {
				edge = edgeList.get(i);
				String containmentString = (edge instanceof ContainmentEdge)?"<>":" ";
				EObject reference = edge.getReference();
				assertTrue("Input was an EPackage, i.e. the wrapped edge must be an EReference", reference instanceof EReference);
				EObjectVertex vertex = out?edge.getEnd():edge.getStart();
				EObject element = vertex.getModelElement();
				assertTrue("Input was an EPackage, i.e. the wrapped vertex must be an EClass", element instanceof EClass);
				System.out.println("\t" + (out?containmentString:" ") + startArrow + " " + ((EReference) reference).getName() + " " + endArrow + (!out?containmentString:" ") + " " + ((EClass) element).getName());
			}
			if(out && metaclass != null){
				for (EReferenceEdge outEdge : edgeList) {
					EReference reference = outEdge.getReference();
					EClass targetClass = (EClass) outEdge.getEnd().getModelElement();
					EClass referenceTargetClass = reference.getEReferenceType();
					assertTrue("Class '" + targetClass.getName() + "' must be a subclass of '" + referenceTargetClass.getName() + "'", referenceTargetClass.isSuperTypeOf(targetClass));
					List<EReference> allReferences = metaclass.getEAllReferences();
					assertTrue(allReferences.contains(reference));
				}
				int edgesCount = 0;
				List<EReference> allReferences = metaclass.getEAllReferences();
				for (EReference reference : allReferences) {
					Set<EReferenceEdge> referenceEdges = graphAdapter.getReferenceEdgeMap().get(reference);
					if(referenceEdges == null){
						System.out.println("\tReference '" + reference.getName() + "' refers to the external metaclass '" + reference.getEReferenceType().getName() + "' and is omitted");
					} else {
						for (EReferenceEdge referenceEdge : referenceEdges) {
							if(((EClass) referenceEdge.getStart().getModelElement()).equals(metaclass)){
								edgesCount++;
							}
						}
					}
				}
				assertEquals("The edges must count the same as valid EReferences of '" + metaclass.getName() + "'in the metamodel ", edgesCount, edgeList.size());	
			}
		}
	}
}
