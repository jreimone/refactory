/**
 * 
 */
package org.emftext.refactoring.util;

/**
 * @author Jan Reimann
 *
 */
public class StringUtil {

	public static String convertCamelCaseToWords(String qualifiedClassName) {
		StringBuffer sb = new StringBuffer();
		final char[] charArray = qualifiedClassName.toCharArray();
		for (int c = 0; c < charArray.length; c++) {
			char character = charArray[c];
			final boolean isEnd = c + 1 == charArray.length;
			boolean nextIsUpper = !isEnd && Character.isUpperCase(charArray[c + 1]);
			
			sb.append(character);
			if (Character.isLowerCase(character) && nextIsUpper) {
				sb.append(' ');
			} 
		}
		return sb.toString();
	}
}
