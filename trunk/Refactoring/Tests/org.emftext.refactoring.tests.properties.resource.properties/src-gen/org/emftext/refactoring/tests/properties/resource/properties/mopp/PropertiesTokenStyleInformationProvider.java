/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesTokenStyleInformationProvider {
	
	public class TokenStyleImpl implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenStyle {
		
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
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		if ("COMMENT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x80, 0x00}, false, true, false, false);
		}
		if ("QUOTED_91_93".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		return null;
	}
	
}
