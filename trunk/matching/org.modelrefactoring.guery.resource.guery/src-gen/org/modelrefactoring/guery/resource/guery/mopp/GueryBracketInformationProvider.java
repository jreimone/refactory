/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class GueryBracketInformationProvider {
	
	public java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryBracketPair> getBracketPairs() {
		java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryBracketPair> result = new java.util.ArrayList<org.modelrefactoring.guery.resource.guery.IGueryBracketPair>();
		result.add(new org.modelrefactoring.guery.resource.guery.mopp.GueryBracketPair("(", ")", true, false));
		result.add(new org.modelrefactoring.guery.resource.guery.mopp.GueryBracketPair("[", "]", true, false));
		result.add(new org.modelrefactoring.guery.resource.guery.mopp.GueryBracketPair("\"", "\"", false, false));
		return result;
	}
	
}
