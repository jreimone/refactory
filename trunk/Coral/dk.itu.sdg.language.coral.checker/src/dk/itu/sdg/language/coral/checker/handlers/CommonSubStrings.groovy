package dk.itu.sdg.language.coral.checker.handlers

import dk.itu.sdg.language.coral.checker.CommonString
import dk.itu.sdg.language.coral.checker.CommonStrings
import dk.itu.sdg.language.coral.checker.CoralProperties;

/**
 * 
 * @author ropf
 *	This class returns a set of the longest common substrings of two strings.  
 */
class CommonSubStrings {

	def CommonStrings commons
	
	public CommonStrings longestSubstr(String first, String second) {
		if (first == null || second == null || first.length() == 0 || second.length() == 0) {
			return 0;
		}
	 
		def int maxLen = 0;
		def int fl = first.length();
		def int sl = second.length();
		def int[][] table = new int[fl][sl];
		
		commons = new CommonStrings() 
				
		for (int i = 0; i < fl; i++) {
			maxLen = 0
			for (int j = 0; j < sl; j++) {
				if (first.charAt(i) == second.charAt(j)) {
					
					if (i == 0 || j == 0) {
						table[i][j] = 1;
					}
					else {
						table[i][j] = table[i - 1][j - 1] + 1;
					}
					if (table[i][j] > maxLen) {
						maxLen = table[i][j]
					
						//TODO: This constant has to go to a properties file
//						def interestingCommonLength = 4//CoralProperties.coralProperties.getProperty("minimumLength")
						def interestingCommonLength = Integer.parseInt(CoralProperties.coralProperties.getProperty("minimumLength"))
						if (maxLen >= interestingCommonLength) {
							
							def c = second.substring(j - maxLen + 1, j + 1)
//							println (c.toString() + " " + i + " - " + j   + " - " + maxLen) 
							def common = new CommonString(c, i, j, maxLen)
							commons.add(common)
						}		
					}
				}
			}
		}
	
//		return maxLen;
		return commons
	}
	
	public CommonString longestSubstring(String first, String second) {
		if (first == null || second == null || first.length() == 0 || second.length() == 0) {
			return 0;
		}
	 
		def int maxLen = 0;
		def int fl = first.length();
		def int sl = second.length();
		def int[][] table = new int[fl][sl];
		
		def common
				
		for (int i = 0; i < fl; i++) {
			maxLen = 0
			for (int j = 0; j < sl; j++) {
				if (first.charAt(i) == second.charAt(j)) {
					
					if (i == 0 || j == 0) {
						table[i][j] = 1;
					}
					else {
						table[i][j] = table[i - 1][j - 1] + 1;
					}
					if (table[i][j] > maxLen) {
						maxLen = table[i][j]
					
						def c = second.substring(j - maxLen + 1, j + 1)
						common = new CommonString(c, i, j, maxLen)
					}
				}
			}
		}
		return common
	}
	
	public filterWhitespaces() {
		
		for(common in commons) {
			//TODO: implement this using a regular expression which rejects all strings that only contain \s, whitespaces
		}
	}
	
}
