/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'org.emftext.refactoring.tests.properties.resource.properties.default_load_optio
 * ns' with the difference that the options defined in this class are used even if
 * no Eclipse platform is running.
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesOptionProvider implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesOptionProvider {
	
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		return java.util.Collections.emptyMap();
	}
	
}
