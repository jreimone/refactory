/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties;

/**
 * A LocationMap maps EObjects to the position of their textual representations.
 * For each org.eclipse.emf.ecore.EObject the map contains information about the
 * line, the column, the character position where the object begins and the
 * character position where the object ends.
 */
public interface IPropertiesLocationMap {
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setLine(org.eclipse.emf.ecore.EObject element, int line);
	
	/**
	 * Returns the line where the given element starts.
	 */
	public int getLine(org.eclipse.emf.ecore.EObject element);
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setColumn(org.eclipse.emf.ecore.EObject element, int column);
	
	/**
	 * Returns the column where the given element starts.
	 */
	public int getColumn(org.eclipse.emf.ecore.EObject element);
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setCharStart(org.eclipse.emf.ecore.EObject element, int charStart);
	
	/**
	 * Returns the character position where the given element starts.
	 */
	public int getCharStart(org.eclipse.emf.ecore.EObject element);
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setCharEnd(org.eclipse.emf.ecore.EObject element, int charEnd);
	
	/**
	 * Returns the character position where the given element ends.
	 */
	public int getCharEnd(org.eclipse.emf.ecore.EObject element);
	
	/**
	 * Returns all EObjects that are located at the given offset in the text document.
	 * This method can return multiple elements, because containers include their
	 * children in the textual representation.
	 * 
	 * @param documentOffset
	 *  the offset where to search for elements
	 * 
	 * @return a list of elements located at the given offset
	 */
	public java.util.List<org.eclipse.emf.ecore.EObject> getElementsAt(int documentOffset);
	
	/**
	 * Returns all EObjects that are located between the given offsets in the text
	 * document. The method can return multiple elements.
	 * 
	 * @param startOffset
	 * @param endOffset
	 * 
	 * @return a list of elements located between the given offsets
	 */
	public java.util.List<org.eclipse.emf.ecore.EObject> getElementsBetween(int startOffset, int endOffset);
	
}
