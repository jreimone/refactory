/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec;

// A text parser parses a text into a tree of <code>EObject</code>s.
// It is associated with a <code>TextResource</code>.
public interface IRefspecTextParser extends org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecConfigurable {
	
	// Parses the content given to the parser and create a tree
	// of EObjects. The root of this tree is wrapped together
	// with some commands that might be executed after parsing.
	//
	// @return the result of the parse process
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecParseResult parse();
	
	// Parses the document and returns a list of expected elements.
	// Each expected element covers a range in the input stream.
	//
	// If the parser implementation can not determine expected
	// elements null can be returned.
	// This method is used by the code completion to figure out
	// which proposals can be shown to users for a given cursor
	// position.
	//
	// The class 'type' is used as start symbol.
	public java.util.List<org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource dummyResource);
	
	// Signals the parse to terminates the parsing as soon as possible.
	public void terminate();
}
