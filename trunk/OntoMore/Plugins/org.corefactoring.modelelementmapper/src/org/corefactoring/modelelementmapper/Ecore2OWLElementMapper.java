package org.corefactoring.modelelementmapper;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.owl.OntologyDocument;

/**
 * Place holder implementation for a mapping of Ecore elements to corresponding
 * elements in an OWL model.
 * 
 * @author Erik Tittel
 */
public class Ecore2OWLElementMapper implements ModelElementMapper {

	public EObject getCorrespondingModelElement(EObject inputElement, EObject targetModel) {
		OntologyDocument ontologyDocument = null;
		if (targetModel instanceof OntologyDocument) {
			ontologyDocument = (OntologyDocument) targetModel;
		} else {
			throw new RuntimeException(
					"The target model in the Ecore-to-OWL-Mapper should be an OntologyDocument.");
		}
		if (inputElement instanceof EClass) {
			String eClassName = ((EClass) inputElement).getName();
			return ModelElementSearcher.getClassFromOntologyDocument(eClassName, ontologyDocument);
		} else if (inputElement instanceof EReference) {
			String eReferenceName = ((EReference) inputElement).getName();
			return ModelElementSearcher.getObjectPropertyFromOntologyDocument(eReferenceName,
					ontologyDocument);
		} else if (inputElement instanceof EAttribute) {
			String eAttributeName = ((EAttribute) inputElement).getName();
			return ModelElementSearcher.getDataPropertyFromOntologyDocument(eAttributeName,
					ontologyDocument);
		} else {
			throw new RuntimeException(
					"There's no correspondence defined for this kind of input element");
		}
	}

}
