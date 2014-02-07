/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed;

import org.eclipse.emf.ecore.EObject;

/**
 * A delegating reference resolver is an extension of a normal reference resolver
 * that can be configured with another resolver that it may delegate method calls
 * to. This interface can be implemented by additional resolvers to customize
 * resolving using the load option ADDITIONAL_REFERENCE_RESOLVERS.
 * 
 * @see org.modelrefactoring.evolution.coed.resource.coed.ICoedOptions
 */
public interface ICoedDelegatingReferenceResolver<ContainerType extends EObject, ReferenceType extends EObject> extends org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Sets the delegate for this resolver.
	 */
	public void setDelegate(org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<ContainerType, ReferenceType> delegate);
	
}
