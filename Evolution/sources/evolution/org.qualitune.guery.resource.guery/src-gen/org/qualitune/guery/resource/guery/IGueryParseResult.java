/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IGueryParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>> getPostParseCommands();
	
}
