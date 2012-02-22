/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.ui;

public class GueryUIMetaInformation extends org.qualitune.guery.resource.guery.mopp.GueryMetaInformation {
	
	public org.qualitune.guery.resource.guery.IGueryHoverTextProvider getHoverTextProvider() {
		return new org.qualitune.guery.resource.guery.ui.GueryHoverTextProvider();
	}
	
	public org.qualitune.guery.resource.guery.ui.GueryImageProvider getImageProvider() {
		return org.qualitune.guery.resource.guery.ui.GueryImageProvider.INSTANCE;
	}
	
	public org.qualitune.guery.resource.guery.ui.GueryColorManager createColorManager() {
		return new org.qualitune.guery.resource.guery.ui.GueryColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.qualitune.guery.resource.guery.IGueryTextResource,
	 * org.qualitune.guery.resource.guery.ui.GueryColorManager) instead.
	 */
	public org.qualitune.guery.resource.guery.ui.GueryTokenScanner createTokenScanner(org.qualitune.guery.resource.guery.ui.GueryColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.qualitune.guery.resource.guery.ui.GueryTokenScanner createTokenScanner(org.qualitune.guery.resource.guery.IGueryTextResource resource, org.qualitune.guery.resource.guery.ui.GueryColorManager colorManager) {
		return new org.qualitune.guery.resource.guery.ui.GueryTokenScanner(resource, colorManager);
	}
	
	public org.qualitune.guery.resource.guery.ui.GueryCodeCompletionHelper createCodeCompletionHelper() {
		return new org.qualitune.guery.resource.guery.ui.GueryCodeCompletionHelper();
	}
	
}
