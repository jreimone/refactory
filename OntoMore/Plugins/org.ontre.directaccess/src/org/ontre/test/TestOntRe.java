package org.ontre.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Set;

import org.junit.Test;
import org.ontre.OntRe;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class TestOntRe {

	private static OWLOntology ontology;
	private static OWLOntologyManager manager;
	private static OWLObjectProperty objectProperty;
	
	@Test
	public void testRunRefactoring() {
		OntRe ontRe = new OntRe("data/ontretest_in.owl", "data/ontretest_ref.omn");
		ontRe.run();
		testSetup();
	}
	
	private void testSetup() {
		manager = OWLManager.createOWLOntologyManager();
		loadOntology("data/ontretest_ref.omn");
	}
	
	private void loadOntology(String filePath) {
		try {
			File file = new File(filePath);
			assertTrue(file.exists());
			ontology = manager.loadOntologyFromOntologyDocument(file);
		} catch (OWLOntologyCreationException e) {
			throw new RuntimeException("Could not load ontology: ", e);
		}
	}
	
	@Test
	public void testObjectPropertyExists() {
		boolean result = false;
		for (OWLObjectProperty owlObjectProperty : ontology.getObjectPropertiesInSignature()) {
			if (owlObjectProperty.getIRI().toString().contains("hatAdresse")) {
				System.out.println("ObjectProperty found: " + owlObjectProperty);
				objectProperty = owlObjectProperty;
				result = true;
				break;
			}
		}
		if (!result) {
			fail("Could not find ObjectProperty \"hatAdresse\"");
		}
	}
	
	@Test
	public void testRange() {
		boolean result = false;
		Set<OWLClassExpression> ranges = objectProperty.getRanges(ontology);
		for (OWLClassExpression classExpression : ranges) {
			if (classExpression.toString().contains("Adresse")) {
				System.out.println("Range found: " + classExpression);
				result = true;
				break;
			}
		}
		if (!result) {
			fail("Could not find Range \"Adresse\"");
		}
	}
	
	@Test
	public void testDomain() {
		boolean result = false;
		Set<OWLClassExpression> domains = objectProperty.getDomains(ontology);
		for (OWLClassExpression classExpression : domains) {
			if (classExpression.toString().contains("Person")) {
				System.out.println("Domain found: " + classExpression);
				result = true;
				break;
			}
		}
		if (!result) {
			fail("Could not find Domain \"Person\"");
		}
	}
	
	@Test
	public void testDataPropertyRemoved() {
		boolean result = false;
		for (OWLDataProperty owlDataProperty : ontology.getDataPropertiesInSignature()) {
			if (owlDataProperty.getIRI().toString().contains("hatAdresse")) {
				result = true;
				break;
			}
		}
		if (result) {
			fail("Could still find DataProperty \"hatAdresse\"");
		}
		System.out.println("DataProperty \"hatAdresse\" apperantly removed");
	}
}
