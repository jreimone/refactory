/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties;

import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

/**
 * An interface used to access the result of parsing a document.
 */
public interface ITestpropertiesParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>> getPostParseCommands();
	
	/**
	 * Returns a map that can be used to retrieve the position of objects in the
	 * parsed text.
	 */
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap getLocationMap();
	
}
