/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

/**
 * A class used to initialize default preference values.
 */
public class PropertiesPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	private final static org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesAntlrTokenHelper tokenHelper = new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesAntlrTokenHelper();
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
		// Set default value for occurrences
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesPreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX, true);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesPreferenceConstants.EDITOR_DEFINITION_COLOR, "240,216,168");
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesPreferenceConstants.EDITOR_PROXY_COLOR, "212,212,212");
		
		// store.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_OVERVIEW_
		// RULER, true);
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesBracketSet bracketSet = new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesBracketSet(null);
		final java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			if (!tokenHelper.canBeUsedForSyntaxColoring(i)) {
				continue;
			}
			
			String tokenName = tokenHelper.getTokenName(tokenNames, i);
			if (tokenName == null) {
				continue;
			}
			org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
