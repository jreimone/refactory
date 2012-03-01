package org.qualitune.evolution.guery.graph;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public abstract class Util {
	

	/**
	 * Returns all references of <code>element</code>. Including containments.
	 * @param element
	 * @return
	 */
	public static List<EReference> getAllReferences(EObject element){
		EClass metaclass = element.eClass();
		List<EReference> allReferences = metaclass.getEAllReferences();
//		List<EReference> allContainments = metaclass.getEAllContainments();
		List<EReference> references = new ArrayList<EReference>(allReferences);
//		references.removeAll(allContainments);
		return references;
	}

	/**
	 * Returns all elements referenced from <code>element</code> with the given <code>reference</code>. 
	 * @param reference
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<EObject> getReferencedElements(EReference reference, EObject element) {
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
