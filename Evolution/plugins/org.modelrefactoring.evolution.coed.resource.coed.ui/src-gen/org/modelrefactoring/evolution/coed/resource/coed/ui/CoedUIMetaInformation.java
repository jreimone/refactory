/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import org.eclipse.core.resources.IResource;

public class CoedUIMetaInformation extends org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMetaInformation {
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedHoverTextProvider getHoverTextProvider() {
		return new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedHoverTextProvider();
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ui.CoedImageProvider getImageProvider() {
		return org.modelrefactoring.evolution.coed.resource.coed.ui.CoedImageProvider.INSTANCE;
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ui.CoedColorManager createColorManager() {
		return new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.modelrefactoring.evolution.coed.resource.coed.ICoedTextRe
	 * source, org.modelrefactoring.evolution.coed.resource.coed.ui.CoedColorManager)
	 * instead.
	 */
	public org.modelrefactoring.evolution.coed.resource.coed.ui.CoedTokenScanner createTokenScanner(org.modelrefactoring.evolution.coed.resource.coed.ui.CoedColorManager colorManager) {
		return (org.modelrefactoring.evolution.coed.resource.coed.ui.CoedTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ui.ICoedTokenScanner createTokenScanner(org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource resource, org.modelrefactoring.evolution.coed.resource.coed.ui.CoedColorManager colorManager) {
		return new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedTokenScanner(resource, colorManager);
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCodeCompletionHelper createCodeCompletionHelper() {
		return new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new org.modelrefactoring.evolution.coed.resource.coed.ui.debug.CoedLineBreakpointAdapter();
	}
	
}
