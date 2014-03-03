package org.corefactoring.modelelementmapper;

import org.eclipse.emf.ecore.EObject;

/**
 * Maps corresponding elements in different models on meta level M1.
 * 
 * @author Erik Tittel
 */
public interface ModelElementMapper {

	/**
	 * Provides to the given input element the corresponding input element in
	 * the given target model.
	 */
	EObject getCorrespondingModelElement(EObject inputElement, EObject targetModel);

}
