/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
	
	public static String firstLetterUpperCase(String text){
		if(text == null || "".equals(text)){
			return "";
		}
		StringBuffer sb = new StringBuffer(text);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}
	
	public static String firstLetterLowerCase(String text){
		if(text == null || "".equals(text)){
			return "";
		}
		StringBuffer sb = new StringBuffer(text);
		sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
		return sb.toString();
	}
	
	public static String convertWordsToCamelCase(String words){
		String result = words.replaceAll(" ", "");
		return firstLetterUpperCase(result);
	}
}
