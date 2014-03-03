package org.ontre;

import java.util.Collections;
import java.util.Set;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.util.OWLEntityRemover;

public class ConvertDataPropertyToObjectProperty extends Refactoring {

	private OWLObjectProperty objectProperty;
	private OWLClass rangeClass;

	@Override
	protected void executeRefactoringSteps() {
		// create ObjectProperty and set range
		objectProperty = factory.getOWLObjectProperty(inputElement.getIRI());
		rangeClass = factory.getOWLClass(":" + inputValue, pm);
		OWLAxiom rangeAxiom = factory.getOWLObjectPropertyRangeAxiom(objectProperty, rangeClass);
		axiomsToAdd.add(rangeAxiom);
		// transfer domains
		Set<OWLClassExpression> domains = inputElement.getDomains(ontology);
		for (OWLClassExpression domain : domains) {
			OWLAxiom domainAxiom = factory.getOWLObjectPropertyDomainAxiom(objectProperty, domain);
			axiomsToAdd.add(domainAxiom);
		}
		// transfer annotations
		Set<OWLAnnotation> annotations = inputElement.getAnnotations(ontology);
		for (OWLAnnotation annoation : annotations) {
			OWLAxiom annotationAxiom = factory.getOWLAnnotationAssertionAxiom(
					objectProperty.getIRI(), annoation);
			axiomsToAdd.add(annotationAxiom);
		}
		// transfer characteristics
		Set<OWLAxiom> referencingAxioms = inputElement.getReferencingAxioms(ontology);
		for (OWLAxiom owlAxiom : referencingAxioms) {
			if (owlAxiom instanceof OWLFunctionalDataPropertyAxiom) {
				OWLFunctionalObjectPropertyAxiom functionalAxiom = factory
						.getOWLFunctionalObjectPropertyAxiom(objectProperty);
				axiomsToAdd.add(functionalAxiom);
			}
		}
		// remove DataProperty
		OWLEntityRemover remover = new OWLEntityRemover(manager, Collections.singleton(ontology));
		inputElement.accept(remover);
		changeAxioms.addAll(remover.getChanges());
	}

	@Override
	protected void dataMigration() {
		Set<OWLAxiom> referencingAxioms = inputElement.getReferencingAxioms(ontology);
		int indivCount = 0;
		for (OWLAxiom owlAxiom : referencingAxioms) {
			if (owlAxiom instanceof OWLDataPropertyAssertionAxiom) {
				OWLDataPropertyAssertionAxiom dataPropertyAssertion = (OWLDataPropertyAssertionAxiom) owlAxiom;
				OWLLiteral literal = dataPropertyAssertion.getObject();
				OWLIndividual subject = dataPropertyAssertion.getSubject();
				// create new individual and set ObjectPropertyAssertion
				OWLNamedIndividual object = factory.getOWLNamedIndividual(":GenIndiv"
						+ indivCount, pm);
				OWLObjectPropertyAssertionAxiom objectPropertyAssertion = factory
						.getOWLObjectPropertyAssertionAxiom(objectProperty, subject, object);
				axiomsToAdd.add(objectPropertyAssertion);
				// assign new individual to range class
				OWLClassAssertionAxiom classAssertion = factory.getOWLClassAssertionAxiom(
						rangeClass, object);
				axiomsToAdd.add(classAssertion);
				// put former DataProperty value in annotation
				OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(IRI
						.create("http://www.w3.org/2000/01/rdf-schema#label"));
				OWLAxiom annotationAxiom = factory.getOWLAnnotationAssertionAxiom(
						annotationProperty, object.getIRI(), literal);
				axiomsToAdd.add(annotationAxiom);
				indivCount++;
			}
		}
	}

}
