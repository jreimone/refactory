/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;

/**
 * The CoedAutoEditStrategy extends the default auto edit strategy such that an
 * additional tab is added if a line break is entered after opening brackets which
 * are configured as <code>closeAfterEnter</code>. Also, closing brackets are
 * automatically inserted right away when opening brackets are added where
 * <code>closeAfterEnter</code> is set to <code>false</code>.
 */
public class CoedAutoEditStrategy extends DefaultIndentLineAutoEditStrategy {
	
	private org.modelrefactoring.evolution.coed.resource.coed.ui.CoedBracketSet bracketSet;
	
	public CoedAutoEditStrategy() {
		super();
		org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin plugin = org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin.getDefault();
		if (plugin != null) {
			IPreferenceStore preferenceStore = plugin.getPreferenceStore();
			bracketSet = new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedBracketSet();
			bracketSet.resetBrackets(preferenceStore);
		}
	}
	
	/**
	 * This method is only used for injecting a bracket set during tests.
	 */
	@Deprecated
	public void setBracketSet(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedBracketSet bracketSet) {
		this.bracketSet = bracketSet;
	}
	
	@Override
	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		String text = command.text;
		String textBefore = command.text;
		super.customizeDocumentCommand(document, command);
		String textAfter = command.text;
		if (textAfter.length() < textBefore.length()) {
			return;
		}
		addClosingBracketAfterEnterIfRequired(document, command, text, textBefore, textAfter);
		addClosingBracket(command);
	}
	
	protected void addClosingBracket(DocumentCommand command) {
		String insertedText = command.text;
		boolean closeInstantly = bracketSet.isCloseInstantly(insertedText);
		if (!closeInstantly) {
			return;
		}
		String closingBracket = bracketSet.getCounterpart(insertedText);
		command.text = command.text + closingBracket;
		command.shiftsCaret = false;
		command.caretOffset = command.offset + 1;
	}
	
	protected void addClosingBracketAfterEnterIfRequired(IDocument document, DocumentCommand command, String text, String textBefore, String textAfter) {
		boolean isLineBreak = isLineBreak(text);
		if (!isLineBreak) {
			return;
		}
		
		String documentText = document.get();
		String openingBracketBefore = getCloseAfterBracketBefore(documentText, command.offset);
		if (openingBracketBefore == null) {
			return;
		}
		// add additional indentation (because a line break was entered after an opening
		// bracket)
		command.text = command.text + "\t";
		String closingBracket = bracketSet.getCounterpart(openingBracketBefore);
		boolean closingBracketIsMissing = count(documentText, openingBracketBefore) != count(documentText, closingBracket);
		// add closing bracket (if required)
		if (closingBracketIsMissing) {
			command.text = command.text + textAfter;
			command.text = command.text + closingBracket;
		}
		command.shiftsCaret = false;
		command.caretOffset = command.offset + textAfter.length() + 1;
	}
	
	/**
	 * Returns the number of occurrences of 'searchString' in 'text'.
	 */
	protected int count(String text, String searchString) {
		int index = text.indexOf(searchString);
		int count = 0;
		while (index >= 0) {
			count++;
			index = text.indexOf(searchString, index + 1);
		}
		
		return count;
	}
	
	/**
	 * Searches for a bracket that must be closed when line breaks are entered and
	 * which is located right before the cursor (ignoring whitespace).
	 */
	protected String getCloseAfterBracketBefore(String text, int offset) {
		for (int i = offset - 1; i >= 0; i--) {
			char charAtI = text.charAt(i);
			String stringAtI = Character.toString(charAtI);
			if (bracketSet.isCloseAfterEnter(stringAtI)) {
				return stringAtI;
			}
			if (charAtI == ' ' || charAtI == '	') {
				continue;
			}
			break;
		}
		return null;
	}
	
	protected boolean isLineBreak(String text) {
		return "\n".equals(text) || "\r".equals(text) || "\r\n".equals(text);
	}
	
}
