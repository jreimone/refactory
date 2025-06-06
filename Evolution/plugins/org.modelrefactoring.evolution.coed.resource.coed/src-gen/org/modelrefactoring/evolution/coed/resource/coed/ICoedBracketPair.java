/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed;


/**
 * A simple interface to access information about bracket handling.
 */
public interface ICoedBracketPair {
	
	/**
	 * Returns the opening bracket.
	 */
	public String getOpeningBracket();
	
	/**
	 * Returns the closing bracket.
	 */
	public String getClosingBracket();
	
	/**
	 * Returns whether other bracket pairs shall be automatically closed, when used
	 * inside of this bracket pair.
	 */
	public boolean isClosingEnabledInside();
	
	/**
	 * Sets whether other bracket pairs shall be automatically closed, when used
	 * inside of this bracket pair.
	 */
	public void setClosingEnabledInside(boolean closingEnabledInside);
	
	/**
	 * Returns whether this bracket pair shall be automatically closed, when a line
	 * break is entered. If this method returns false, the closing bracket is inserted
	 * right away when the opening bracket is typed.
	 */
	public boolean isCloseAfterEnter();
	
	/**
	 * Sets whether this bracket pair shall be automatically closed, when a line break
	 * is entered. If this method returns false, the closing bracket is inserted right
	 * away when the opening bracket is typed.
	 */
	public void setCloseAfterEnter(boolean closingAfterEnter);
	
}
