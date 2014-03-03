package org.corefactoring.modelregistry;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * Represents all connections between models that should be refactored together.
 * 
 * @author Erik Tittel
 */
public interface ModelRegistry {

	public static ModelRegistry INSTANCE = ModelRegistryImpl.getInstance();
	
	/**
	 * Provides the corresponding models.
	 */
	public List<EObject> getCorrespondingModels(EObject model);

	/**
	 * Registers the given models as corresponding. The association is
	 * bidirectional so the order of the given models is not important.
	 */
	public void addEntry(EObject leftModel, EObject rightModel);

	/**
	 * Removes the given entry.
	 */
	public void removeEntry(EObject leftModel, EObject rightModel);

	/**
	 * Removes all entries from the registry.
	 */
	public void clearRegistry();

}