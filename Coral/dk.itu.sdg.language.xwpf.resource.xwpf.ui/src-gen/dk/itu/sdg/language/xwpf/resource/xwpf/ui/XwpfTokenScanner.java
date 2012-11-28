/**
 * Copyright 2012 
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class XwpfTokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextScanner lexer;
	private dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextToken currentToken;
	private java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextToken> nextTokens;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager colorManager;
	private dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public XwpfTokenScanner(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation().createLexer();
		this.languageId = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation().getSyntaxName();
		dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfUIPlugin plugin = dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfUIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextToken>();
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
			dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
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
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle getStaticTokenStyle() {
		dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle staticStyle = null;
		String tokenName = currentToken.getName();
		String enableKey = dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.ENABLE);
		boolean enabled = store.getBoolean(enableKey);
		if (enabled) {
			String colorKey = dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.COLOR);
			org.eclipse.swt.graphics.RGB foregroundRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey);
			org.eclipse.swt.graphics.RGB backgroundRGB = null;
			boolean bold = store.getBoolean(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.BOLD));
			boolean italic = store.getBoolean(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.ITALIC));
			boolean strikethrough = store.getBoolean(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
			boolean underline = store.getBoolean(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.UNDERLINE));
			staticStyle = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
		}
		return staticStyle;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle getDynamicTokenStyle(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle staticStyle) {
		dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfDynamicTokenStyler dynamicTokenStyler = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfDynamicTokenStyler();
		dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public org.eclipse.jface.text.TextAttribute getTextAttribute(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle tokeStyle) {
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
		
		java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTaskItem> taskItems = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextToken> newItems = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextToken>();
		for (dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item (TODO if required)
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTextToken(dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item (TODO if required)
			String textAfter = text.substring(offset - charStart);
			newItems.add(new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
