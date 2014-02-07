/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed;

import java.util.Map;

/**
 * Implementors of this interface can be configured by a map of options (or
 * parameters).
 */
public interface ICoedConfigurable {
	
	/**
	 * Passes the options given by the map to the configurable object.
	 */
	public void setOptions(Map<?,?> options);
}
