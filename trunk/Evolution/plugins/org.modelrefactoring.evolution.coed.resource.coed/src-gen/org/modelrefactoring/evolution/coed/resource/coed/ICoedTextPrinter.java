/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed;

import java.io.IOException;
import org.eclipse.emf.ecore.EObject;

/**
 * Converts a tree of <code>EObject</code>s into a plain text.
 */
public interface ICoedTextPrinter extends org.modelrefactoring.evolution.coed.resource.coed.ICoedConfigurable {
	
	/**
	 * Prints the given <code>EObject</code> and its content to the underlying output
	 * stream that was passed to this printer upon creation.
	 * 
	 * @param element The element to print.
	 * 
	 * @throws IOException if printing to the underlying stream or device fails.
	 */
	public void print(EObject element) throws IOException;
	
	/**
	 * Sets the encoding used for printing.
	 */
	public void setEncoding(String encoding);
	
}
