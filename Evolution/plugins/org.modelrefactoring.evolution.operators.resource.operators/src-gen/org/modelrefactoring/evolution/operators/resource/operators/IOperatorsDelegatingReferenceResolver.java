/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;

import org.eclipse.emf.ecore.EObject;

/**
 * <p>
 * A delegating reference resolver is an extension of a normal reference resolver
 * that can be configured with another resolver that it may delegate method calls
 * to. This interface can be implemented by additional resolvers to customize
 * resolving using the load option ADDITIONAL_REFERENCE_RESOLVERS.
 * </p>
 * 
 * @see
 * org.modelrefactoring.evolution.operators.resource.operators.IOperatorsOptions
 */
public interface IOperatorsDelegatingReferenceResolver<ContainerType extends EObject, ReferenceType extends EObject> extends org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Sets the delegate for this resolver.
	 */
	public void setDelegate(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<ContainerType, ReferenceType> delegate);
	
}
