/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

/**
 * A class used to initialize default preference values.
 */
public class XwpfPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfBracketSet bracketSet = new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfBracketSet(null, null);
		final java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
