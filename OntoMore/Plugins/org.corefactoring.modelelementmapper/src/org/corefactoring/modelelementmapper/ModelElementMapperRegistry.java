package org.corefactoring.modelelementmapper;

import org.eclipse.emf.ecore.EObject;
import org.ontomore.util.Direction;

/**
 * Establishes a mapping between corresponding model element at the meta level
 * M1. The concrete mapper has to be registered in advance.
 * 
 * @author Erik Tittel
 */
public interface ModelElementMapperRegistry {

	public static ModelElementMapperRegistry INSTANCE = ModelElementMapperRegistryImpl
			.getInstance();

	/**
	 * Takes an input element and returns the corresponding input element in the
	 * given target model. Fulfils the contract of a Map.put().
	 */
	public EObject getCorrespondingElement(EObject inputElement, EObject targetModel);

	public ModelElementMapper registerElementMapper(Direction direction,
			ModelElementMapper modelElementMapper);
}