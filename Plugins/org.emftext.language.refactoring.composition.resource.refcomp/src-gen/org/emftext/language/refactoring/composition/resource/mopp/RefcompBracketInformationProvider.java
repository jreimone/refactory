/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class RefcompBracketInformationProvider {
	
	public Collection<org.emftext.language.refactoring.composition.resource.IRefcompBracketPair> getBracketPairs() {
		Collection<org.emftext.language.refactoring.composition.resource.IRefcompBracketPair> result = new ArrayList<org.emftext.language.refactoring.composition.resource.IRefcompBracketPair>();
		result.add(new org.emftext.language.refactoring.composition.resource.mopp.RefcompBracketPair("{", "}", true, true));
		result.add(new org.emftext.language.refactoring.composition.resource.mopp.RefcompBracketPair("\"", "\"", false, false));
		result.add(new org.emftext.language.refactoring.composition.resource.mopp.RefcompBracketPair("<", ">", false, false));
		return result;
	}
	
}
