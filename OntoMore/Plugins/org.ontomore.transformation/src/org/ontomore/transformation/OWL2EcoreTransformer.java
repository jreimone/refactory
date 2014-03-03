package org.ontomore.transformation;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.ontomore.transformation.exception.OntomoreTransformationException;
import org.ontomore.util.ModelStorageUtil;

/**
 * Loads an OWL model from a file, triggers the transformation to Ecore,
 * and saves the result as new files.
 * 
 * @author Erik Tittel
 * 
 */
public class OWL2EcoreTransformer {

	private EObject ecoreMetamodel;
	private EObject ecoreModel;

	public void runTransformation(String fileName) throws IOException,
			OntomoreTransformationException {
		URI fileURI = URI.createFileURI(fileName);
		EObject ontologyContent = ModelStorageUtil.loadModelFromFileURI(fileURI);
		
		transformModelAndMetamodel(ontologyContent);
		
		URI metaModelURI = changeFileExtension(fileURI, "ecore");
		URI modelURI = changeFileExtension(fileURI, "xmi");
		
		ModelStorageUtil.saveModelInResource(ecoreMetamodel, metaModelURI);
		if (ecoreModel != null) {
			ModelStorageUtil.saveModelInResource(ecoreModel, modelURI);
		}
	}

	private void transformModelAndMetamodel(EObject ontologyContent)
			throws OntomoreTransformationException {
		OWL2EcoreMetaModelTransformer transformer = new OWL2EcoreMetaModelTransformer();
		transformer.transformOWL2Ecore(ontologyContent);
		ecoreMetamodel = transformer.getMetaModel();
		ecoreModel = transformer.getModel();
	}

	private URI changeFileExtension(URI fileURI, String newExtension) {
		return fileURI.trimFileExtension().appendFileExtension(newExtension);
	}

}
