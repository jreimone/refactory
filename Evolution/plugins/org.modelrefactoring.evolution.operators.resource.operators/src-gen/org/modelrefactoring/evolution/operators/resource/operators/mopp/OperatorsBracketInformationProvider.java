/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class OperatorsBracketInformationProvider {
	
	public Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsBracketPair> getBracketPairs() {
		Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsBracketPair> result = new ArrayList<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsBracketPair>();
		result.add(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsBracketPair("<", ">", false, false));
		result.add(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsBracketPair("\"", "\"", false, false));
		return result;
	}
	
}
