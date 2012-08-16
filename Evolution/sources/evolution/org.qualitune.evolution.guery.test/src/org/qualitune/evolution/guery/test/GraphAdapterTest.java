/**
 * 
 */
package org.qualitune.evolution.guery.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.Program;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;
import org.junit.Before;
import org.junit.Test;
import org.qualitune.evolution.guery.graph.EMFGraphAdapter;
import org.qualitune.evolution.guery.graph.EMFGraphAdapterFactory;
import org.qualitune.evolution.guery.registry.EObjectVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;

/**
 * @author jreimann
 *
 */
public class GraphAdapterTest {

	private static final String PL0_PATH = "/metamodel/pl0.ecore";
	
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
		EMFGraphAdapterFactory factory = new EMFGraphAdapterFactory();
		EMFGraphAdapter<EObjectVertex, EReferenceEdge> adapter = new EMFGraphAdapter<EObjectVertex, EReferenceEdge>(pl0MMResource, factory);
		Iterator<EObjectVertex> vertices = adapter.getVertices();
		System.out.println("~~~~~~~~~~~~~~~");
		while (vertices.hasNext()) {
			EObjectVertex vertex = (EObjectVertex) vertices.next();
			EObject element = vertex.getModelElement();
			assertTrue("Input was an EPackage, i.e. the wrapped vertex must be an EClass", element instanceof EClassifier);
			System.out.println(((EClass) element).getName());
			Iterator<EReferenceEdge> outEdges = adapter.getOutEdges(vertex);
			printEdges(outEdges, "---", "--->");
			Iterator<EReferenceEdge> inEdges = adapter.getInEdges(vertex);
			printEdges(inEdges, "<---", "---");
		}
//		int mmCount = pl0MM.getEClassifiers().size();
	}

	/**
	 * @param edges
	 */
	private void printEdges(Iterator<EReferenceEdge> edges, String startArrow, String endArrow) {
		while (edges.hasNext()) {
			EReferenceEdge edge = (EReferenceEdge) edges.next();
			EObject reference = edge.getReference();
			assertTrue("Input was an EPackage, i.e. the wrapped edge must be an EReference", reference instanceof EReference);
			EObjectVertex end = edge.getEnd();
			EObject endElement = end.getModelElement();
			assertTrue("Input was an EPackage, i.e. the wrapped vertex must be an EClass", endElement instanceof EClass);
			System.out.println("\t" + startArrow + " " + ((EReference) reference).getName() + endArrow + " " + ((EClass) endElement).getName());
		}
	}
}
