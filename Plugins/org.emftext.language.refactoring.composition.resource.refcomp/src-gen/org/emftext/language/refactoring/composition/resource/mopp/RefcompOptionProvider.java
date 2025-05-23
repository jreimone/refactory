/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'org.emftext.language.refactoring.composition.resource.refcomp.default_load_opti
 * ons' with the difference that the options defined in this class are used even
 * if no Eclipse platform is running.
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import java.util.Collections;
import java.util.Map;

public class RefcompOptionProvider implements org.emftext.language.refactoring.composition.resource.IRefcompOptionProvider {
	
	public Map<?,?> getOptions() {
		// create a map with static option providers here
		return Collections.emptyMap();
	}
	
}
