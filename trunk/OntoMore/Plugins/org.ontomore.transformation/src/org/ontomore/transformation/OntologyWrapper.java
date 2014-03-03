package org.ontomore.transformation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.owl.Frame;
import org.emftext.language.owl.Ontology;
import org.emftext.language.owl.OntologyDocument;
import org.ontomore.transformation.exception.OntomoreTransformationException;

public class OntologyWrapper {

	private Ontology ontology;
	
	public OntologyWrapper(EObject ontologyModel) {
		if (!(ontologyModel instanceof OntologyDocument)) {
			throw new OntomoreTransformationException(
					"Root element of ontology model is not an OntologyDocument");
		}
		OntologyDocument ontologyDocument = (OntologyDocument) ontologyModel;
		ontology = ontologyDocument.getOntology();
	}
	
	public String getName() {
		return ontology.getUri();
	}
	
	public EList<Frame> getFrames() {
		return ontology.getFrames();
	}
}
