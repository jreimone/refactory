package org.qualitune.evolution.prolog.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.qualitune.evolution.prolog.IPrologGenerator;
import org.qualitune.evolution.prolog.registry.IPrologRegistry;
import org.qualitune.evolution.prolog.registry.PrologUtil;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;

public class PrologGenerator implements IPrologGenerator {

	private static final String PRED_EXPLICIT			= "explicit";
	private static final String PRED_URI				= "uri";
	private static final String PRED_ELEMENT2RESOURCE	= "elementtoresourcemapping";

	@Override
	public void generateTheoryAndAddToKnowledgebase(EObject model) {
		Resource modelResource = model.eResource();
		TreeIterator<EObject> iterator = model.eAllContents();
		while (iterator.hasNext()) {
			EObject element = (EObject) iterator.next();
			List<EReference> references = getAllReferences(element);
			for (EReference reference : references) {
				List<EObject> referencedElements = getReferencedElements(reference, element);
				Prolog engine = IPrologRegistry.INSTANCE.getEngine();
				for (EObject referencedElement : referencedElements) {
					EcoreUtil.resolveAll(referencedElement);
					Resource otherResource = referencedElement.eResource();
					if(otherResource != null && !otherResource.equals(modelResource)){
						List<String> clauseList = createClauseList(modelResource, element, reference, referencedElement, otherResource);
						Theory theory = createTheory(clauseList);
						try {
							engine.addTheory(theory);
						} catch (InvalidTheoryException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	private List<String> createClauseList(Resource modelResource, EObject element, EReference reference, EObject referencedElement, Resource otherResource) {
		List<String> clauseList = new ArrayList<String>();
		URI uriElement = PrologUtil.getConsistentURI(EcoreUtil.getURI(element));
		URI uriReference = EcoreUtil.getURI(reference);
		URI uriReferencedElement = PrologUtil.getConsistentURI( EcoreUtil.getURI(referencedElement));
		String atomElement = PrologUtil.makeStringAtomic(uriElement.toString());
		String atomReference = PrologUtil.makeStringAtomic(uriReference.toString());
		String atomReferencedElement = PrologUtil.makeStringAtomic(uriReferencedElement.toString());
		clauseList.add(PRED_EXPLICIT + "(" + atomElement+ ", " + atomReference + ", " + atomReferencedElement + ")");
		clauseList.add(PRED_URI + "(" + atomElement + ", '" + PrologUtil.escapeCharacters(uriElement) + "')");
		clauseList.add(PRED_URI + "(" + atomReference + ", '" + PrologUtil.escapeCharacters(uriReference) + "')");
		clauseList.add(PRED_URI + "(" + atomReferencedElement + ", '" + PrologUtil.escapeCharacters(uriReferencedElement) + "')");
		URI modelResourceUri = PrologUtil.getConsistentURI(modelResource.getURI());
		URI otherResourceUri = PrologUtil.getConsistentURI(otherResource.getURI());
		String atomSourceModelURI = PrologUtil.makeStringAtomic(modelResourceUri.toString());
		String atomTargetModelURI = PrologUtil.makeStringAtomic(otherResourceUri.toString());
		clauseList.add(PRED_ELEMENT2RESOURCE + "(" + atomElement + ", " + atomSourceModelURI + ")");
		clauseList.add(PRED_ELEMENT2RESOURCE + "(" + atomReferencedElement + ", " + atomTargetModelURI + ")");
		clauseList.add(PRED_URI + "(" + atomSourceModelURI + ", '" + PrologUtil.escapeCharacters(modelResourceUri) + "')");
		clauseList.add(PRED_URI + "(" + atomTargetModelURI + ", '" + PrologUtil.escapeCharacters(otherResourceUri) + "')");
		return clauseList;
	}

	private Theory createTheory(List<String> clauseList) {
		Theory theory = null;
		StringBuffer buffer = new StringBuffer();
		Prolog engine = IPrologRegistry.INSTANCE.getEngine();
		try {
			for (String string : clauseList) {
				String clause = string.trim();
				@SuppressWarnings("unused")
				SolveInfo result = engine.solve("retractall(" + clause + ").");
				buffer.append(clause + ".\n");
			}
			buffer.append("\n");
			theory = new Theory(buffer.toString());
		} catch (InvalidTheoryException e) {
			e.printStackTrace();
		} catch (MalformedGoalException e) {
			e.printStackTrace();
		}
//		System.out.println(buffer.toString());
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
		if(object != null){
			if(!reference.isMany()){
				referencedElements.add((EObject) object);
			} else {
				referencedElements.addAll((List<EObject>) object);
			}
		}
		return referencedElements;
	}
}
