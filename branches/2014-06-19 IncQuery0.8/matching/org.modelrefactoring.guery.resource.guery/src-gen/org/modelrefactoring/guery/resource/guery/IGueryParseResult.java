/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery;

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
	public java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>> getPostParseCommands();
	
	/**
	 * Returns a map that can be used to retrieve the position of objects in the
	 * parsed text.
	 */
	public org.modelrefactoring.guery.resource.guery.IGueryLocationMap getLocationMap();
	
}
