package org.qualitune.evolution.prolog.registry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides useful functionality for working with Prolog.
 * 
 * @author jreimann
 *
 */
public abstract class PrologUtil {

	private static final String	REPLACEMENT	= "_";
	private static final Pattern validChar = Pattern.compile("[^a-z0-9" + REPLACEMENT + "]");
	
	/**
	 * Produces a valid Prolog atom for the given <code>string</code>. Usually all invalid characters
	 * are replaced with an underscore.
	 * 
	 * @param string
	 * @return
	 */
	public static String makeStringAtomic(String string){
		String atom = string.toLowerCase();
		Matcher matcher = validChar.matcher(atom);
		atom = matcher.replaceAll(REPLACEMENT);
		while(atom.indexOf(REPLACEMENT) == 0){
			atom = atom.substring(1);
		}
		return atom;
	}
	
	/**
	 * Prolog strings are surrounded with apostrophes ('...'). This method removes them to 
	 * produce a normal Java string.
	 * 
	 * @param string
	 * @return the given <code>string</code> without apostrophes
	 */
	public static String removeApostrophe(String string){
		String newString = string;
		if(string.startsWith("'")){
			newString = newString.substring(1);
		}
		if(string.endsWith("'")){
			newString = newString.substring(0, newString.length() - 1);
		}
		return newString;
	}
}
