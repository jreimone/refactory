/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'org.modelrefactoring.evolution.operators.resource.operators.default_load_option
 * s' with the difference that the options defined in this class are used even if
 * no Eclipse platform is running.
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.Collections;
import java.util.Map;

public class OperatorsOptionProvider implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsOptionProvider {
	
	public Map<?,?> getOptions() {
		// create a map with static option providers here
		return Collections.emptyMap();
	}
	
}
