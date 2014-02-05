/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;


/**
 * A simple interface for generic functions with one argument.
 */
public interface IOperatorsFunction1<ReturnType, ArgumentType1> {
	
	public ReturnType execute(ArgumentType1 argument1);
}
