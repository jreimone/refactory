package org.qualitune.evolution.prolog.registry;

/**
 * This class provides useful functionality for working with Prolog.
 * 
 * @author jreimann
 *
 */
public abstract class PrologUtil {

	/**
	 * Produces a valid Prolog atom for the given <code>st5ring</code>. Usually all invalid characters
	 * are replaced with an underscore.
	 * 
	 * @param string
	 * @return
	 */
	public static String makeStringAtomic(String string){
		String atom = string.replaceAll(":", "_");
		atom = atom.replaceAll("/", "_");
		atom = atom.replaceAll("@", "_");
		atom = atom.replaceAll("\\.", "_");
		atom = atom.replaceAll("#", "_");
		atom = atom.toLowerCase();
		while(atom.indexOf("_") == 0){
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
