/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;


/**
 * The IgnoredWordsFilter can be customized to add additional words that must not
 * be marked as misspelled. To customize this class, set option
 * 'overrideIgnoredWordsFilter' to <code>false</code>.
 */
public class RefcompIgnoredWordsFilter {
	
	/**
	 * Checks whether the given word must be ignored even it is misspelled.
	 */
	public boolean ignoreWord(String word) {
		// By default we ignore all keywords that are defined in the syntax
		return org.emftext.language.refactoring.composition.resource.grammar.RefcompGrammarInformationProvider.INSTANCE.getKeywords().contains(word);
	}
	
}
