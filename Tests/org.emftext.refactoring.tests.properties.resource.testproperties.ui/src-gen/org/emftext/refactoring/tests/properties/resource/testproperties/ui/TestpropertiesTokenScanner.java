/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class TestpropertiesTokenScanner implements org.emftext.refactoring.tests.properties.resource.testproperties.ui.ITestpropertiesTokenScanner {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextScanner lexer;
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextToken currentToken;
	private java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextToken> nextTokens;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesColorManager colorManager;
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public TestpropertiesTokenScanner(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation().createLexer();
		this.languageId = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation().getSyntaxName();
		org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesUIPlugin plugin = org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesUIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextToken>();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		boolean isOriginalToken = true;
		if (!nextTokens.isEmpty()) {
			currentToken = nextTokens.remove(0);
			isOriginalToken = false;
		} else {
			currentToken = lexer.getNextToken();
		}
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		
		if (isOriginalToken) {
			splitCurrentToken();
		}
		
		org.eclipse.jface.text.TextAttribute textAttribute = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
			if (dynamicStyle != null) {
				textAttribute = getTextAttribute(dynamicStyle);
			}
		}
		
		return new org.eclipse.jface.text.rules.Token(textAttribute);
	}
	
	public void setRange(org.eclipse.jface.text.IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (org.eclipse.jface.text.BadLocationException e) {
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
	
	public int[] convertToIntArray(org.eclipse.swt.graphics.RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return new int[] {rgb.red, rgb.green, rgb.blue};
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle getStaticTokenStyle() {
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle staticStyle = null;
		String tokenName = currentToken.getName();
		String enableKey = org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.ENABLE);
		boolean enabled = store.getBoolean(enableKey);
		if (enabled) {
			String colorKey = org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.COLOR);
			org.eclipse.swt.graphics.RGB foregroundRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey);
			org.eclipse.swt.graphics.RGB backgroundRGB = null;
			boolean bold = store.getBoolean(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.BOLD));
			boolean italic = store.getBoolean(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.ITALIC));
			boolean strikethrough = store.getBoolean(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
			boolean underline = store.getBoolean(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.UNDERLINE));
			staticStyle = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
		}
		return staticStyle;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle getDynamicTokenStyle(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle staticStyle) {
		org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesDynamicTokenStyler dynamicTokenStyler = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesDynamicTokenStyler();
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public org.eclipse.jface.text.TextAttribute getTextAttribute(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle tokeStyle) {
		int[] foregroundColorArray = tokeStyle.getColorAsRGB();
		org.eclipse.swt.graphics.Color foregroundColor = null;
		if (colorManager != null) {
			foregroundColor = colorManager.getColor(new org.eclipse.swt.graphics.RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
		}
		int[] backgroundColorArray = tokeStyle.getBackgroundColorAsRGB();
		org.eclipse.swt.graphics.Color backgroundColor = null;
		if (backgroundColorArray != null) {
			org.eclipse.swt.graphics.RGB backgroundRGB = new org.eclipse.swt.graphics.RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
			if (colorManager != null) {
				backgroundColor = colorManager.getColor(backgroundRGB);
			}
		}
		int style = org.eclipse.swt.SWT.NORMAL;
		if (tokeStyle.isBold()) {
			style = style | org.eclipse.swt.SWT.BOLD;
		}
		if (tokeStyle.isItalic()) {
			style = style | org.eclipse.swt.SWT.ITALIC;
		}
		if (tokeStyle.isStrikethrough()) {
			style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
		}
		if (tokeStyle.isUnderline()) {
			style = style | org.eclipse.jface.text.TextAttribute.UNDERLINE;
		}
		return new org.eclipse.jface.text.TextAttribute(foregroundColor, backgroundColor, style);
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
		
		java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTaskItem> taskItems = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextToken> newItems = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextToken>();
		for (org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item (TODO if required)
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTextToken(org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item (TODO if required)
			String textAfter = text.substring(offset - charStart);
			newItems.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
