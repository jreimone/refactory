/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec;

// This interface is extended by all other EMFText runtime
// API interfaces for generated components. It provides
// access to the plug-in meta information.
public interface IRefspecTextResourcePluginPart {
	
	// Returns a meta information object for the language plug-in
	// that contains this part.
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecMetaInformation getMetaInformation();
}
