/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;


/**
 * A mapping from an identifier to an EObject.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IOperatorsElementMapping<ReferenceType> extends org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
