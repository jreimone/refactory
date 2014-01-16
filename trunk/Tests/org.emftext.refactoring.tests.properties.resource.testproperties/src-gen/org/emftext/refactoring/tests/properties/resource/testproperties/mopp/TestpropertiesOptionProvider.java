/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'org.emftext.refactoring.tests.properties.resource.testproperties.default_load_o
 * ptions' with the difference that the options defined in this class are used
 * even if no Eclipse platform is running.
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import java.util.Collections;
import java.util.Map;

public class TestpropertiesOptionProvider implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesOptionProvider {
	
	public Map<?,?> getOptions() {
		// create a map with static option providers here
		return Collections.emptyMap();
	}
	
}
