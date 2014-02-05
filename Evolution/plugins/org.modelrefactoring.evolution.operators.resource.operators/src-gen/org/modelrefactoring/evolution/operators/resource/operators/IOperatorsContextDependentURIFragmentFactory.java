/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * An interface for factories to create instances of
 * org.modelrefactoring.evolution.operators.resource.operators.IOperatorsContextDep
 * endentURIFragment.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public interface IOperatorsContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject> {
	
	/**
	 * Create a new instance of the
	 * org.modelrefactoring.evolution.operators.resource.operators.IOperatorsContextDep
	 * endentURIFragment interface.
	 * 
	 * @param identifier the identifier that references an Object
	 * @param container the object that contains the reference
	 * @param reference the reference itself
	 * @param positionInReference the position of the identifier (if the reference is
	 * multiple)
	 * @param proxy the proxy that will be resolved later to the actual EObject
	 * 
	 * @return the new instance of
	 * org.modelrefactoring.evolution.operators.resource.operators.IOperatorsContextDep
	 * endentURIFragment
	 */
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy);
}
