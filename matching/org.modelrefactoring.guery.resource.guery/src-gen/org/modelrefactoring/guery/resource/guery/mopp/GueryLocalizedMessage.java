/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GueryLocalizedMessage {
	
	public GueryLocalizedMessage(String message, int column, int line, int charStart, int charEnd) {
		super();
		this.message = message;
		this.column = column;
		this.line = line;
		this.charStart = charStart;
		this.charEnd = charEnd;
	}
	
	private String message;
	
	private int column;
	
	private int line;
	
	private int charStart;
	
	private int charEnd;
	
	public String getMessage() {
		return message;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getCharStart() {
		return charStart;
	}
	
	public int getCharEnd() {
		return charEnd;
	}
	
}
