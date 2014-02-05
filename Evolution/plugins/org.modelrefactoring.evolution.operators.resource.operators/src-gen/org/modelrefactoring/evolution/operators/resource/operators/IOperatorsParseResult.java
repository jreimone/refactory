/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;

import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IOperatorsParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsCommand<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource>> getPostParseCommands();
	
	/**
	 * Returns a map that can be used to retrieve the position of objects in the
	 * parsed text.
	 */
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsLocationMap getLocationMap();
	
}
