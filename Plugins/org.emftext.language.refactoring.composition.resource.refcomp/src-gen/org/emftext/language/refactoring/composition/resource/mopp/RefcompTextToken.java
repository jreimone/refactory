/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;


public class RefcompTextToken implements org.emftext.language.refactoring.composition.resource.IRefcompTextToken {
	
	private String name;
	
	private String text;
	
	private int offset;
	
	private int length;
	
	private int line;
	
	private int column;
	
	private boolean canBeUsedForSyntaxHighlighting;
	
	public RefcompTextToken(String name, String text, int offset, int length, int line, int column, boolean canBeUsedForSyntaxHighlighting) {
		super();
		this.name = name;
		this.text = text;
		this.offset = offset;
		this.length = length;
		this.line = line;
		this.column = column;
		this.canBeUsedForSyntaxHighlighting = canBeUsedForSyntaxHighlighting;
	}
	
	public String getName() {
		return name;
	}
	
	public String getText() {
		return text;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getColumn() {
		return column;
	}
	
	public boolean canBeUsedForSyntaxHighlighting() {
		return canBeUsedForSyntaxHighlighting;
	}
	
}
