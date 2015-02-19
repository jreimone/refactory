/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import org.eclipse.core.resources.IResource;

public class RefcompUIMetaInformation extends org.emftext.language.refactoring.composition.resource.mopp.RefcompMetaInformation {
	
	public org.emftext.language.refactoring.composition.resource.IRefcompHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.refactoring.composition.resource.ui.RefcompHoverTextProvider();
	}
	
	public org.emftext.language.refactoring.composition.resource.ui.RefcompImageProvider getImageProvider() {
		return org.emftext.language.refactoring.composition.resource.ui.RefcompImageProvider.INSTANCE;
	}
	
	public org.emftext.language.refactoring.composition.resource.ui.RefcompColorManager createColorManager() {
		return new org.emftext.language.refactoring.composition.resource.ui.RefcompColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.language.refactoring.composition.resource.IRefcom
	 * pTextResource,
	 * org.emftext.language.refactoring.composition.resource.ui.RefcompColorManager)
	 * instead.
	 */
	public org.emftext.language.refactoring.composition.resource.ui.RefcompTokenScanner createTokenScanner(org.emftext.language.refactoring.composition.resource.ui.RefcompColorManager colorManager) {
		return (org.emftext.language.refactoring.composition.resource.ui.RefcompTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public org.emftext.language.refactoring.composition.resource.ui.IRefcompTokenScanner createTokenScanner(org.emftext.language.refactoring.composition.resource.IRefcompTextResource resource, org.emftext.language.refactoring.composition.resource.ui.RefcompColorManager colorManager) {
		return new org.emftext.language.refactoring.composition.resource.ui.RefcompTokenScanner(resource, colorManager);
	}
	
	public org.emftext.language.refactoring.composition.resource.ui.RefcompCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.refactoring.composition.resource.ui.RefcompCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new org.emftext.language.refactoring.composition.resource.ui.debug.RefcompLineBreakpointAdapter();
	}
	
}
