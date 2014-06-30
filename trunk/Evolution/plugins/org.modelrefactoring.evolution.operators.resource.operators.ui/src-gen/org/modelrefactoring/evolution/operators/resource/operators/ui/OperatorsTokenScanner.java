/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class OperatorsTokenScanner implements org.modelrefactoring.evolution.operators.resource.operators.ui.IOperatorsTokenScanner {
	
	private org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextScanner lexer;
	private org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextToken currentToken;
	private List<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextToken> nextTokens;
	private int offset;
	private String languageId;
	private IPreferenceStore store;
	private org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsColorManager colorManager;
	private org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource;
	
	/**
	 * <p>
	 * Creates a new OperatorsTokenScanner.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 */
	public OperatorsTokenScanner(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation().createLexer();
		this.languageId = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation().getSyntaxName();
		org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsUIPlugin plugin = org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsUIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new ArrayList<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextToken>();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public IToken nextToken() {
		boolean isOriginalToken = true;
		if (!nextTokens.isEmpty()) {
			currentToken = nextTokens.remove(0);
			isOriginalToken = false;
		} else {
			currentToken = lexer.getNextToken();
		}
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return Token.EOF;
		}
		
		if (isOriginalToken) {
			splitCurrentToken();
		}
		
		TextAttribute textAttribute = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
			if (dynamicStyle != null) {
				textAttribute = getTextAttribute(dynamicStyle);
			}
		}
		
		return new Token(textAttribute);
	}
	
	public void setRange(IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (BadLocationException e) {
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
	
	public int[] convertToIntArray(RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return new int[] {rgb.red, rgb.green, rgb.blue};
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenStyle getStaticTokenStyle() {
		String tokenName = currentToken.getName();
		String enableKey = org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.ENABLE);
		if (store == null) {
			return null;
		}
		
		boolean enabled = store.getBoolean(enableKey);
		if (!enabled) {
			return null;
		}
		
		String colorKey = org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.COLOR);
		RGB foregroundRGB = PreferenceConverter.getColor(store, colorKey);
		RGB backgroundRGB = null;
		boolean bold = store.getBoolean(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.BOLD));
		boolean italic = store.getBoolean(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.ITALIC));
		boolean strikethrough = store.getBoolean(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
		boolean underline = store.getBoolean(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.UNDERLINE));
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenStyle getDynamicTokenStyle(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenStyle staticStyle) {
		org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsDynamicTokenStyler dynamicTokenStyler = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsDynamicTokenStyler();
		dynamicTokenStyler.setOffset(offset);
		org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public TextAttribute getTextAttribute(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenStyle tokeStyle) {
		int[] foregroundColorArray = tokeStyle.getColorAsRGB();
		Color foregroundColor = null;
		if (colorManager != null) {
			foregroundColor = colorManager.getColor(new RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
		}
		int[] backgroundColorArray = tokeStyle.getBackgroundColorAsRGB();
		Color backgroundColor = null;
		if (backgroundColorArray != null) {
			RGB backgroundRGB = new RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
			if (colorManager != null) {
				backgroundColor = colorManager.getColor(backgroundRGB);
			}
		}
		int style = SWT.NORMAL;
		if (tokeStyle.isBold()) {
			style = style | SWT.BOLD;
		}
		if (tokeStyle.isItalic()) {
			style = style | SWT.ITALIC;
		}
		if (tokeStyle.isStrikethrough()) {
			style = style | TextAttribute.STRIKETHROUGH;
		}
		if (tokeStyle.isUnderline()) {
			style = style | TextAttribute.UNDERLINE;
		}
		return new TextAttribute(foregroundColor, backgroundColor, style);
	}
	
	/**
	 * Tries to split the current token if it contains task items.
	 */
	public void splitCurrentToken() {
		final String text = currentToken.getText();
		final String name = currentToken.getName();
		final int line = currentToken.getLine();
		final int charStart = currentToken.getOffset();
		final int column = currentToken.getColumn();
		
		List<org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTaskItem> taskItems = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		List<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextToken> newItems = new ArrayList<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextToken>();
		for (org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTextToken(org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item
			String textAfter = text.substring(offset - charStart);
			newItems.add(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
