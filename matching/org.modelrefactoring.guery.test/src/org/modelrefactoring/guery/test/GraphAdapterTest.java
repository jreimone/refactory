/**
 * 
 */
package org.modelrefactoring.guery.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.java.JavaPackage;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0extended.Pl0extendedPackage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelrefactoring.guery.graph.ContainmentEdge;
import org.modelrefactoring.guery.graph.EClassVertex;
import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;

/**
 * @author jreimann
 *
 */
public class GraphAdapterTest {

	//	private void initLanguages() {
	//		EPackage.Registry.INSTANCE.put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
	//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new Pl0MetaInformation().getSyntaxName(), new Pl0ResourceFactory());
	//	}


	private EPackageGraphAdapter graphAdapter;

	@SuppressWarnings("unused")
	@BeforeClass
	public static void init() {
		Registry epackageRegistry = EPackage.Registry.INSTANCE;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
	}

	@Test
	public void testInheritanceInTheMidle(){
		EPackage metamodel = getMetamodelFromFile("metamodels/InheritanceInTheMiddle.ecore");
		Resource mmResource = metamodel.eResource();
		testGraphAdapter(mmResource, metamodel);
	}

	@Test
	public void testBridge(){
		EPackage metamodel = getMetamodelFromFile("metamodels/Bridge.ecore");
		Resource mmResource = metamodel.eResource();
		testGraphAdapter(mmResource, metamodel);
	}

	@Test
	public void testPL0() {
		EPackage pl0MM = PL0Package.eINSTANCE;
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
		Resource pl0MMResource = pl0MM.eResource();
		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
		testGraphAdapter(pl0MMResource, pl0MM);
	}

	@Test
	public void testPL0Extended() {
		Pl0extendedPackage pl0MM = Pl0extendedPackage.eINSTANCE;
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
		Resource pl0MMResource = pl0MM.eResource();
		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
		testGraphAdapter(pl0MMResource, pl0MM);
	}

	@Test
	public void testMultipleInheritance(){
		EPackage metamodel = getMetamodelFromFile("metamodels/MultipleInheritance.ecore");
		Resource mmResource = metamodel.eResource();
		testGraphAdapter(mmResource, metamodel);
	}

	@Test
	public void testBridgeMultipleInheritance(){
		EPackage metamodel = getMetamodelFromFile("metamodels/BridgeMultipleInheritance.ecore");
		Resource mmResource = metamodel.eResource();
		testGraphAdapter(mmResource, metamodel);
	}

	@Test
	public void testJava() {
		assertNotNull("Java metamodel couldn't be initialised", JavaPackage.eINSTANCE);
		assertNotNull("Resource for URI '" + JavaPackage.eINSTANCE.getNsURI() +"' mustn't be null", JavaPackage.eINSTANCE.eResource());
		testGraphAdapter(JavaPackage.eINSTANCE.eResource(), JavaPackage.eINSTANCE);
	}
	
	@Test
	public void testBPMN() {
		assertNotNull("BPMN metamodel couldn't be initialised", Bpmn2Package.eINSTANCE);
		assertNotNull("Resource for URI '" + Bpmn2Package.eINSTANCE.getNsURI() +"' mustn't be null", Bpmn2Package.eINSTANCE.eResource());
		testGraphAdapter(Bpmn2Package.eINSTANCE.eResource(), Bpmn2Package.eINSTANCE);
	}

	private EPackage getMetamodelFromFile(String metamodelPath) {
		File mmFile = new File(metamodelPath);
		assertTrue("File '" + mmFile.getPath() + "' doesn't exist", mmFile.exists());
		URI uri = URI.createFileURI(mmFile.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource mmResource = rs.getResource(uri, true);
		assertTrue("Resource '" + uri.toString() + "' must contain an EPackage", mmResource.getContents().get(0) instanceof EPackage);
		EPackage metamodel = (EPackage) mmResource.getContents().get(0);
		return metamodel;
	}

	private void testGraphAdapter(Resource mmResource, EPackage metamodel){
		graphAdapter = new EPackageGraphAdapter(mmResource);
		graphAdapter.initialiseGraph();
		Iterator<MetamodelVertex> vertices = graphAdapter.getVertices();
		// 1. build up the map of the metamodel for comparison
		Map<String, EClass> metaclasses = getMetaclasses(metamodel);
		// 2. print and compare the graph with the previously created map
		System.out.println("~~~~~~~~~~~~~~~");
		System.out.println(mmResource.getURI().toString());
		System.out.println();
		Map<String, EClassVertex> vertexMetaclasses = new HashMap<String, EClassVertex>();
		while (vertices.hasNext()) {
			MetamodelVertex vertex = vertices.next();
			assertTrue("Vertex must be an " + EClassVertex.class.getSimpleName(), vertex instanceof EClassVertex);
			EClassVertex eclassVertex = (EClassVertex) vertex;
			vertexMetaclasses.put(eclassVertex.getEClass().getName(), eclassVertex);
			EObject element = vertex.getModelElement();
			assertTrue("Input was an EPackage, i.e. the wrapped vertex must be an EClass", element instanceof EClass);
			System.out.println(((EClass) element).getName());
			Iterator<EReferenceEdge> outEdges = graphAdapter.getOutEdges(vertex);
			printEdges(outEdges, "---", "-->", true, metaclasses);
			Iterator<EReferenceEdge> inEdges = graphAdapter.getInEdges(vertex);
			printEdges(inEdges, "<--", "---", false, metaclasses);
		}
		// 3. some additional comparison
		//		int eclassesCount = metaclasses.size();
		//		int vertexCount = vertexMetaclasses.size();
		compareInternalVerticesAndMetaclasses(vertexMetaclasses, metaclasses);
		//		assertEquals("The vertices must count the same as EClasses in the metamodel ", vertexCount, eclassesCount);
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

	/**
	 * @param edges
	 * @param metaclasses 
	 */
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
