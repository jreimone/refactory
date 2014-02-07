/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;


/**
 * The IgnoredWordsFilter can be customized to add additional words that must not
 * be marked as misspelled. To customize this class, set option
 * 'overrideIgnoredWordsFilter' to <code>false</code>.
 */
public class CoedIgnoredWordsFilter {
	
	/**
	 * Checks whether the given word must be ignored even it is misspelled.
	 */
	public boolean ignoreWord(String word) {
		// By default we ignore all keywords that are defined in the syntax
		return org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedGrammarInformationProvider.INSTANCE.getKeywords().contains(word);
	}
	
}
