/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.ui;

public class GueryUIMetaInformation extends org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation {
	
	public org.modelrefactoring.guery.resource.guery.IGueryHoverTextProvider getHoverTextProvider() {
		return new org.modelrefactoring.guery.resource.guery.ui.GueryHoverTextProvider();
	}
	
	public org.modelrefactoring.guery.resource.guery.ui.GueryImageProvider getImageProvider() {
		return org.modelrefactoring.guery.resource.guery.ui.GueryImageProvider.INSTANCE;
	}
	
	public org.modelrefactoring.guery.resource.guery.ui.GueryColorManager createColorManager() {
		return new org.modelrefactoring.guery.resource.guery.ui.GueryColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.modelrefactoring.guery.resource.guery.IGueryTextResource,
	 * org.modelrefactoring.guery.resource.guery.ui.GueryColorManager) instead.
	 */
	public org.modelrefactoring.guery.resource.guery.ui.GueryTokenScanner createTokenScanner(org.modelrefactoring.guery.resource.guery.ui.GueryColorManager colorManager) {
		return (org.modelrefactoring.guery.resource.guery.ui.GueryTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public org.modelrefactoring.guery.resource.guery.ui.IGueryTokenScanner createTokenScanner(org.modelrefactoring.guery.resource.guery.IGueryTextResource resource, org.modelrefactoring.guery.resource.guery.ui.GueryColorManager colorManager) {
		return new org.modelrefactoring.guery.resource.guery.ui.GueryTokenScanner(resource, colorManager);
	}
	
	public org.modelrefactoring.guery.resource.guery.ui.GueryCodeCompletionHelper createCodeCompletionHelper() {
		return new org.modelrefactoring.guery.resource.guery.ui.GueryCodeCompletionHelper();
	}
	
}
