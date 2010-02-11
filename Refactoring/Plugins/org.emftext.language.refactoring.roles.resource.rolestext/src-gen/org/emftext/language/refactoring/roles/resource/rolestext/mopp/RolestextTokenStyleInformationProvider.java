/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextTokenStyleInformationProvider {
	
	public class TokenStyleImpl implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenStyle {
		
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
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		if ("|-|".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x00, 0x00}, true, false, false, false);
		}
		if ("->".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0xC4, 0x00}, true, false, false, false);
		}
		if ("--".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xFF, 0x00}, true, false, false, false);
		}
		if ("<>-".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xFF, 0xFF}, true, false, false, false);
		}
		if ("BOOLEAN_LITERAL".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x55}, true, false, false, false);
		}
		if ("NUMBER".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xFF}, false, true, false, false);
		}
		if ("..".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xFF}, false, true, false, false);
		}
		if ("OPTIONAL".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x05, 0xD3, 0xE0}, true, false, false, false);
		}
		if ("INPUT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x05, 0xD3, 0xE0}, true, false, false, false);
		}
		if ("RUNTIME".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x05, 0xD3, 0xE0}, true, false, false, false);
		}
		if ("TRANSITIVE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x05, 0xD3, 0xE0}, true, false, false, false);
		}
		if ("REFLEXIVE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x05, 0xD3, 0xE0}, true, false, false, false);
		}
		if ("RoleModel".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("role".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x3F, 0x80, 0x5D}, false, false, false, false);
		}
		return null;
	}
	
}
