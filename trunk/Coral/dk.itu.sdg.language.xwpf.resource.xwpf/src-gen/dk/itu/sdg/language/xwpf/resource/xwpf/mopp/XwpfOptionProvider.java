/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'dk.itu.sdg.language.xwpf.resource.xwpf.default_load_options' with the
 * difference that the options defined in this class are used even if no Eclipse
 * platform is running.
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfOptionProvider implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfOptionProvider {
	
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		return java.util.Collections.emptyMap();
	}
	
}
