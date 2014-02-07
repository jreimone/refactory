/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import java.util.Collection;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This class can be used to initialize default preference values.
 */
public class CoedPreferenceInitializer extends AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		IPreferenceStore store = org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	protected void initializeDefaultBrackets() {
		IPreferenceStore store = org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMetaInformation());
	}
	
	protected void initializeDefaultBrackets(IPreferenceStore store, org.modelrefactoring.evolution.coed.resource.coed.ICoedMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets
		org.modelrefactoring.evolution.coed.resource.coed.ui.CoedBracketSet bracketSet = new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedBracketSet();
		final Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.modelrefactoring.evolution.coed.resource.coed.ICoedBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside(), bracketPair.isCloseAfterEnter());
			}
		}
		store.setDefault(languageId + org.modelrefactoring.evolution.coed.resource.coed.ui.CoedPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.serialize());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		IPreferenceStore store = org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMetaInformation());
	}
	
	protected void initializeDefaultSyntaxHighlighting(IPreferenceStore store, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	protected void setProperties(IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.coed.resource.coed.ui.CoedSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	protected String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
	
}

