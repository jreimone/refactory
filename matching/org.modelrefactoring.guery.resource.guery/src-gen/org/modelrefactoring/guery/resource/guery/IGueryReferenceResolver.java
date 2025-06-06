/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery;

/**
 * A reference resolver tries to resolve a reference to one or many model elements
 * (EObjects). It is called by the EMF proxy resolution mechanism.
 * 
 * @param <ContainerType> the type of the container that contains the reference
 * that is resolved by this resolver
 * @param <ReferenceType> the type of the reference that is resolved by this
 * resolver
 */
public interface IGueryReferenceResolver<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> extends org.modelrefactoring.guery.resource.guery.IGueryConfigurable {
	
	/**
	 * Attempts to resolve a reference string.
	 * 
	 * @param identifier The identifier for the reference.
	 * @param container The object that contains the reference.
	 * @param reference The reference that points to the target of the reference.
	 * @param position The index of the reference (if it has an upper bound greater
	 * than 1).
	 * @param resolveFuzzy If true, the resolver must return all objects, even the
	 * ones that do not match the identifier
	 * @param result an object that can be used to store the result of the resolve
	 * operation.
	 */
	public void resolve(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.modelrefactoring.guery.resource.guery.IGueryReferenceResolveResult<ReferenceType> result);
	
	/**
	 * Reverse of the resolve operation: constructs a String representing the given
	 * object.
	 * 
	 * @param element The referenced model element.
	 * @param container The object referencing the element.
	 * @param reference The reference that holds the element.
	 * 
	 * @return The identification string for the reference
	 */
	public String deResolve(ReferenceType element, ContainerType container, org.eclipse.emf.ecore.EReference reference);
	
}
