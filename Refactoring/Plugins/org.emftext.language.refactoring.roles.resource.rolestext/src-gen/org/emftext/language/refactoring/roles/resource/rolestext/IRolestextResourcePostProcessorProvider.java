/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext;

// Implementors of this interface can provide a post-processor
// for text resources.
public interface IRolestextResourcePostProcessorProvider {
	
	// Returns the processor that shall be called after text
	// resource are successfully parsed.
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextResourcePostProcessor getResourcePostProcessor();
}
