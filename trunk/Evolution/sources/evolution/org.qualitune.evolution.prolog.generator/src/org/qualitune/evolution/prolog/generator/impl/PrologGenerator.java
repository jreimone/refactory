package org.qualitune.evolution.prolog.generator.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.qualitune.evolution.prolog.generator.IPrologGenerator;
import org.qualitune.evolution.prolog.registry.PrologUtil;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.Theory;

public class PrologGenerator implements IPrologGenerator {

	private static final String PRED_EXPLICIT			= "explicit";
	private static final String PRED_URI				= "uri";
	private static final String PRED_ELEMENT2RESOURCE	= "elementtoresourcemapping";

	@Override
	public Theory generateTheory(EObject model) {
		Resource modelResource = model.eResource();
		TreeIterator<EObject> iterator = model.eAllContents();
		StringBuffer buffer = new StringBuffer();
		while (iterator.hasNext()) {
			EObject element = (EObject) iterator.next();
			List<EReference> references = getAllReferences(element);
			for (EReference reference : references) {
				List<EObject> referencedElements = getReferencedElements(reference, element);
				for (EObject referencedElement : referencedElements) {
					Resource otherResource = referencedElement.eResource();
					if(!otherResource.equals(modelResource)){
						URI uriElement = PrologUtil.getConsistentURI(EcoreUtil.getURI(element));
						URI uriReference = EcoreUtil.getURI(reference);
						URI uriReferencedElement = PrologUtil.getConsistentURI( EcoreUtil.getURI(referencedElement));
						String atomElement = PrologUtil.makeStringAtomic(uriElement.toString());
						String atomReference = PrologUtil.makeStringAtomic(uriReference.toString());
						String atomReferencedElement = PrologUtil.makeStringAtomic(uriReferencedElement.toString());
						buffer.append(PRED_EXPLICIT + "(" + atomElement+ ", " + atomReference + ", " + atomReferencedElement + ").\n");
						buffer.append(PRED_URI + "(" + atomElement + ", '" + PrologUtil.escapeCharacters(uriElement) + "') :- !.\n");
						buffer.append(PRED_URI + "(" + atomReference + ", '" + PrologUtil.escapeCharacters(uriReference) + "') :- !.\n");
						buffer.append(PRED_URI + "(" + atomReferencedElement + ", '" + PrologUtil.escapeCharacters(uriReferencedElement) + "') :- !.\n");
						URI modelResourceUri = PrologUtil.getConsistentURI(modelResource.getURI());
						URI otherResourceUri = PrologUtil.getConsistentURI(otherResource.getURI());
						String atomSourceModelURI = PrologUtil.makeStringAtomic(modelResourceUri.toString());
						String atomTargetModelURI = PrologUtil.makeStringAtomic(otherResourceUri.toString());
						buffer.append(PRED_ELEMENT2RESOURCE + "(" + atomElement + ", " + atomSourceModelURI + ").\n");
						buffer.append(PRED_ELEMENT2RESOURCE + "(" + atomReferencedElement + ", " + atomTargetModelURI + ").\n");
						buffer.append(PRED_URI + "(" + atomSourceModelURI + ", '" + PrologUtil.escapeCharacters(modelResourceUri) + "') :- !.\n");
						buffer.append(PRED_URI + "(" + atomTargetModelURI + ", '" + PrologUtil.escapeCharacters(otherResourceUri) + "') :- !.\n");
						buffer.append("\n");
					}
				}
			}
		}
		System.out.println(buffer.toString());
		Theory theory = null;
		try {
			theory = new Theory(buffer.toString());
		} catch (InvalidTheoryException e) {
			e.printStackTrace();
		}
		return theory;
	}

	private List<EReference> getAllReferences(EObject element){
		EClass metaclass = element.eClass();
		List<EReference> allReferences = metaclass.getEAllReferences();
		List<EReference> references = new ArrayList<EReference>(allReferences);
		return references;
	}
	
	@SuppressWarnings("unchecked")
	private List<EObject> getReferencedElements(EReference reference, EObject element) {
		List<EObject> referencedElements = new ArrayList<EObject>();
		Object object = element.eGet(reference, true);
		if(!reference.isMany()){
			referencedElements.add((EObject) object);
		} else {
			referencedElements.addAll((List<EObject>) object);
		}
		return referencedElements;
	}
}
