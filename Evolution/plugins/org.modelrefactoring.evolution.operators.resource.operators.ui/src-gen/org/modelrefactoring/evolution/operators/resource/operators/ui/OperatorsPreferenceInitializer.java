/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.ui;

import java.util.Collection;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This class can be used to initialize default preference values.
 */
public class OperatorsPreferenceInitializer extends AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		initializeDefaultsContentAssist();
		
		IPreferenceStore store = org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	protected void initializeDefaultBrackets() {
		IPreferenceStore store = org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation());
	}
	
	protected void initializeDefaultBrackets(IPreferenceStore store, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets
		org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsBracketSet bracketSet = new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsBracketSet();
		final Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.modelrefactoring.evolution.operators.resource.operators.IOperatorsBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside(), bracketPair.isCloseAfterEnter());
			}
		}
		store.setDefault(languageId + org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.serialize());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		IPreferenceStore store = org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation());
	}
	
	protected void initializeDefaultSyntaxHighlighting(IPreferenceStore store, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void initializeDefaultsContentAssist() {
		IPreferenceStore store = org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsUIPlugin.getDefault().getPreferenceStore();
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED_DEFAULT);
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY_DEFAULT);
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS_DEFAULT);
	}
	
	protected void setProperties(IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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

