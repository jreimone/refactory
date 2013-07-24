/**
 * 
 */
package org.qualitune.evolution.guery.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;
import org.junit.Before;
import org.junit.Test;
import org.qualitune.evolution.guery.graph.ContainmentEdge;
import org.qualitune.evolution.guery.graph.EPackageGraphAdapter;
import org.qualitune.evolution.guery.graph.MetamodelVertex;
import org.qualitune.evolution.guery.registry.EObjectVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;

/**
 * @author jreimann
 *
 */
public class GraphAdapterTest {

	private EPackage pl0MM;
	private Resource pl0MMResource;
	
	@Before
	public void init(){
		initLanguages();
		initPL0MM();
	}

	private void initLanguages() {
		EPackage.Registry.INSTANCE.put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new Pl0MetaInformation().getSyntaxName(), new Pl0ResourceFactory());
	}

	private void initPL0MM() {
		pl0MM = (EPackage) EPackage.Registry.INSTANCE.get(PL0Package.eNS_URI);
		assertNotNull("PL/0 metamodel couldn't be initialised", pl0MM);
		pl0MMResource = pl0MM.eResource();
		assertNotNull("Resource for URI '" + pl0MM.getNsURI() +"' mustn't be null", pl0MMResource);
	}
	
	@Test
	public void testGraphAdapterForPL0(){
		EPackageGraphAdapter adapter = new EPackageGraphAdapter(pl0MMResource);
		Iterator<MetamodelVertex> vertices = adapter.getVertices();
		int count = 0;
		// 1. build up the map of the metamodel for comparison
		Map<String, EClass> metaclasses = new HashMap<String, EClass>();
		for (EClassifier classifier : pl0MM.getEClassifiers()) {
			if(classifier instanceof EClass){
				EClass metaclass = (EClass) classifier;
				metaclasses.put(metaclass.getName(), metaclass);
			}
		}
		// 2. print and compare the graph with the previously created map
		System.out.println("~~~~~~~~~~~~~~~");
		while (vertices.hasNext()) {
			MetamodelVertex vertex = vertices.next();
			count++;
			EObject element = vertex.getModelElement();
			assertTrue("Input was an EPackage, i.e. the wrapped vertex must be an EClass", element instanceof EClass);
			System.out.println(((EClass) element).getName());
			Iterator<EReferenceEdge> outEdges = adapter.getOutEdges(vertex);
			printEdges(outEdges, "---", "-->", true, metaclasses);
			Iterator<EReferenceEdge> inEdges = adapter.getInEdges(vertex);
			printEdges(inEdges, "<--", "---", false, metaclasses);
		}
		// 3. some additional comparison
		int eclassesCount = metaclasses.size();
//		assertTrue("The vertices must count (" + count + ") the same as EClasses in the metamodel (" + eclassesCount + ")", count == eclassesCount);
		assertEquals("The vertices must count the same as EClasses in the metamodel ", count, eclassesCount);
		
	}

	/**
	 * @param edges
	 * @param metaclasses 
	 */
	private void printEdges(Iterator<EReferenceEdge> edges, String startArrow, String endArrow, boolean out, Map<String, EClass> metaclasses) {
		EReferenceEdge edge = null;
		int count = 0;
		if(edges.hasNext()){
			edge = edges.next();
			count++;
		}
		EClass metaclass = null;
		Map<String, EReference> allReferences = new HashMap<String, EReference>();
		if(out && edge != null){
			EObjectVertex start = edge.getStart();
			EClass graphClass = (EClass) start.getModelElement();
			metaclass = metaclasses.get(graphClass.getName());
			List<EReference> eAllReferences = metaclass.getEAllReferences();
			for (EReference reference : eAllReferences) {
				allReferences.put(reference.getName(), reference);
			}
		}
		while (edge != null) {
			String containmentString = (edge instanceof ContainmentEdge)?"<>":" ";
			EObject reference = edge.getReference();
			assertTrue("Input was an EPackage, i.e. the wrapped edge must be an EReference", reference instanceof EReference);
			EObjectVertex vertex = out?edge.getEnd():edge.getStart();
			EObject element = vertex.getModelElement();
			assertTrue("Input was an EPackage, i.e. the wrapped vertex must be an EClass", element instanceof EClass);
			System.out.println("\t" + (out?containmentString:" ") + startArrow + " " + ((EReference) reference).getName() + " " + endArrow + (!out?containmentString:" ") + " " + ((EClass) element).getName());
			if(edges.hasNext()){
				edge = edges.next();
				count++;
			} else {
				edge = null;
			}
		}
		if(out && metaclass != null){
			// TODO count a reference to the target class and each subclass
			assertEquals("The edges must count the same as EReferences of '" + metaclass.getName() + "'in the metamodel ", allReferences.size(), count);	
		}
	}
}
