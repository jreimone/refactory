/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;

import java.util.Map;

/**
 * Implementors of this interface can be configured by a map of options (or
 * parameters).
 */
public interface IOperatorsConfigurable {
	
	/**
	 * Passes the options given by the map to the configurable object.
	 */
	public void setOptions(Map<?,?> options);
}
