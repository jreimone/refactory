package org.qualitune.evolution.prolog.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;

import alice.tuprolog.NoSolutionException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Term;

/**
 * This class provides useful means for working with Prolog.
 * 
 * @author jreimann
 *
 */
public abstract class PrologUtil {

	private static final String	REPLACEMENT	= "_";
	private static final Pattern validChar = Pattern.compile("[^a-z0-9" + REPLACEMENT + "]");
	
	private static final String ESCAPER	= "\\";
	private static Map<String, String> escapeCharacterMap;
	
	static{
		escapeCharacterMap = new HashMap<String, String>();
		escapeCharacterMap.put("'", "°°°");
	}
	
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
	 * Returns a consistent {@link URI}. That means that platform resource URIs, not having the <code>platform:/resource/</code>
	 * prefix, are prefixed.
	 * 
	 * @param uri
	 * @return
	 */
	public static URI getConsistentURI(URI uri) {
		if(!uri.isPlatformResource() && !uri.isPlatformPlugin() && !uri.hasAuthority()){
			uri = URI.createPlatformResourceURI(uri.toString(), true);
		}
		return uri;
	}
	
	/**
	 * Replaces all characters in the given <code>uri</code> which have to be escaped
	 * when being used as a Prolog string.
	 * 
	 * @param uri
	 * @return escaped string representation of the given <code>uri</code>
	 */
	public static String escapeCharacters(URI uri){
		String uriString = uri.toString();
		for (String pattern : escapeCharacterMap.keySet()) {
			String replacement = escapeCharacterMap.get(pattern);
			uriString = uriString.replaceAll(pattern, replacement);
		}
		return uriString;
	}
	
	public static String unescapeCharacters(String string){
		String uriString = string;
		Set<Entry<String,String>> entrySet = escapeCharacterMap.entrySet();
		for (Entry<String, String> entry : entrySet) {
			String pattern = entry.getValue();
			String replacement = ESCAPER + entry.getKey();
			String quote = Pattern.quote(pattern);
			uriString = uriString.replaceAll(quote, replacement);
		}
		return uriString;
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
	
	/**
	 * This method removes duplicates in the given <code>redundantList</code>.
	 * @param redundantList
	 * @return
	 */
	public static List<SolveInfo> removeDuplicates(List<SolveInfo> redundantList){
		List<SolveInfo> result = new ArrayList<SolveInfo>();
		Set<String> uniques = new HashSet<String>();
		for (SolveInfo solveInfo : redundantList) {
			try {
				Term solution = solveInfo.getSolution();
				String string = solution.toString();
				if(uniques.add(string)){
					result.add(solveInfo);
				}
			} catch (NoSolutionException e) {
//				BundleContext context = Activator.getContext();
//				Bundle bundle = context.getBundle();
//				ILog log = Platform.getLog(bundle);
//				String symbolicName = bundle.getSymbolicName();
//				log.log(new Status(IStatus.INFO, symbolicName, "No solutions"));
				// just display nothing
			}
		}
		return result;
	}
}
