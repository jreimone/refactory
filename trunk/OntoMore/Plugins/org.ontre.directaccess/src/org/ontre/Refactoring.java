package org.ontre;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;


public abstract class Refactoring {

	protected OWLDataFactory factory;
	protected PrefixManager pm;
	protected OWLOntology ontology;
	protected OWLOntologyManager manager;
	protected OWLDataProperty inputElement;
	protected String inputValue;
	protected Set<OWLAxiom> axiomsToAdd;
	protected Set<OWLOntologyChange> changeAxioms;
	
	public final void executeRefactoring(InputData input) {
		setup(input);

		executeRefactoringSteps();
		
		dataMigration();
		
		createChangeAxioms();
		applyChanges();
	}
	
	private void setup(InputData input) {
		ontology = input.ontology;
		manager = input.manager;
		factory = manager.getOWLDataFactory();
		pm = new DefaultPrefixManager(ontology.getOntologyID().getOntologyIRI().toString() + "#");
		if (input.inputElement instanceof OWLDataProperty) {
			inputElement = (OWLDataProperty) input.inputElement;
		} else {
			throw new RuntimeException("The input element must be from type OWLDataProperty");
		}
		inputValue = input.inputValue;
		axiomsToAdd = new HashSet<OWLAxiom>();
		changeAxioms = new HashSet<OWLOntologyChange>();
	}
	
	protected abstract void executeRefactoringSteps();
	
	protected void dataMigration() {
	}
	
	private void createChangeAxioms() {
		for (OWLAxiom axiom : axiomsToAdd) {
			AddAxiom addAxiom = new AddAxiom(ontology, axiom);
			changeAxioms.add(addAxiom);
		}
	}

	private void applyChanges() {
		for (OWLOntologyChange changeAxiom : changeAxioms) {
			manager.applyChange(changeAxiom);
		}
	}
}
