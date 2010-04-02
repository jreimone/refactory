/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecTokenStyleInformationProvider {
	
	public class TokenStyleImpl implements org.emftext.language.refactoring.specification.resource.IRefspecTokenStyle {
		
		private int[] color;
		private boolean bold;
		private boolean italic;
		private boolean strikethrough;
		private boolean underline;
		
		public TokenStyleImpl(int[] color, boolean bold, boolean italic, boolean striketrough, boolean underline) {
			super();
			this.color = color;
			this.bold = bold;
			this.italic = italic;
			this.strikethrough = striketrough;
			this.underline = underline;
		}
		
		public int[] getColorAsRGB() {
			return color;
		}
		
		public boolean isBold() {
			return bold;
		}
		
		public boolean isItalic() {
			return italic;
		}
		
		public boolean isStrikethrough() {
			return strikethrough;
		}
		
		public boolean isUnderline() {
			return underline;
		}
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		if ("ML_COMMENT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x80, 0x00}, false, true, false, false);
		}
		if ("REFACTORING".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("FOR".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("STEPS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("create".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("new".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("in".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("move".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("to".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("set".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("use".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("index".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("of".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("assign".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("for".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("from".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("uptree".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x50, 0xF0, 0x5C}, true, false, false, false);
		}
		if ("path".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x50, 0xF0, 0x5C}, true, false, false, false);
		}
		if ("update".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x50, 0xF0, 0x5C}, true, false, false, false);
		}
		if ("trace".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x50, 0xF0, 0x5C}, true, false, false, false);
		}
		if ("first".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x50, 0xF0, 0x5C}, true, false, false, false);
		}
		if ("last".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x50, 0xF0, 0x5C}, true, false, false, false);
		}
		if ("as".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("and".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("DOT_NOTATION".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xFF}, false, false, false, false);
		}
		if ("LOWER_IDENTIFIER".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xFF}, false, false, false, false);
		}
		if ("UPPER_IDENTIFIER".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xFF}, false, false, false, false);
		}
		if ("CONSTANTS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x80, 0x00}, true, false, false, false);
		}
		if ("at".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("object".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		return null;
	}
	
}
