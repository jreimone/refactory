/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class CoedBracketInformationProvider {
	
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedBracketPair> getBracketPairs() {
		Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedBracketPair> result = new ArrayList<org.modelrefactoring.evolution.coed.resource.coed.ICoedBracketPair>();
		result.add(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedBracketPair("{", "}", true, true));
		result.add(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedBracketPair("<", ">", false, false));
		return result;
	}
	
}
