package org.ontre;

import java.io.File;

import org.coode.owlapi.manchesterowlsyntax.ManchesterOWLSyntaxOntologyFormat;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class OntRe {

	private OWLOntologyManager manager;
	private OWLOntology ontology;
	private String targetFilePath;

	public static void main(String[] args) {
		OntRe ontre = new OntRe("data/ontretest_in.owl", "data/ontretest_ref.omn");
		ontre.run();
	}
	
	public OntRe(String sourceFilePath, String targetFilePath) {
		manager = OWLManager.createOWLOntologyManager();
		loadOntology(sourceFilePath);
		this.targetFilePath = targetFilePath;
	}

	private void loadOntology(String filePath) {
		try {
			File file = new File(filePath);
			ontology = manager.loadOntologyFromOntologyDocument(file);
		} catch (OWLOntologyCreationException e) {
			throw new RuntimeException("Could not load ontology: ", e);
		}
	}

	public void run() {
		Refactoring refactoring = new ConvertDataPropertyToObjectProperty();
		refactoring.executeRefactoring(getInputData());
		saveOntology();
	}

	private InputData getInputData() {
		InputData input = new InputData();
		input.ontology = ontology;
		input.manager = manager;
		input.inputElement = getInputElement();
		input.inputValue = "Adresse";
		return input;
	}

	private OWLEntity getInputElement() {
		for (OWLDataProperty owlDataProperty : ontology.getDataPropertiesInSignature()) {
			if (owlDataProperty.getIRI().toString().contains("hatAdresse")) {
				return owlDataProperty;
			}
		}
		throw new RuntimeException("Input element not found");
	}

	private void saveOntology() {
		try {
			OWLOntologyFormat format = manager.getOntologyFormat(ontology);
			File manSynFile = new File(targetFilePath);
			IRI manSynTargetIRI = IRI.create(manSynFile.toURI());
			ManchesterOWLSyntaxOntologyFormat manSyntaxFormat = new ManchesterOWLSyntaxOntologyFormat();
			if (format.isPrefixOWLOntologyFormat()) {
				manSyntaxFormat.copyPrefixesFrom(format.asPrefixOWLOntologyFormat());
			}
			manager.saveOntology(ontology, manSyntaxFormat, manSynTargetIRI);
		} catch (OWLOntologyStorageException e) {
			throw new RuntimeException("Could not save ontology", e);
		}
	}

}
