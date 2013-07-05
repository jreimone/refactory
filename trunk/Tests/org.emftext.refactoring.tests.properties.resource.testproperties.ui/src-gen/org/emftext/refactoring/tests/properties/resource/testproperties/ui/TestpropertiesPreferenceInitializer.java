/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

/**
 * This class can be used to initialize default preference values.
 */
public class TestpropertiesPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	protected void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation());
	}
	
	protected void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets
		org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesBracketSet bracketSet = new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesBracketSet();
		final java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside(), bracketPair.isCloseAfterEnter());
			}
		}
		store.setDefault(languageId + org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.serialize());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation());
	}
	
	protected void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	protected void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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

