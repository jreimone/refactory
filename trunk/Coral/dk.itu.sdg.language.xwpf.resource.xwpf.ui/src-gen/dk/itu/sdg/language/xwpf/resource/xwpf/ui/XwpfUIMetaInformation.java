/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

public class XwpfUIMetaInformation extends dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation {
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfHoverTextProvider getHoverTextProvider() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfHoverTextProvider();
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfImageProvider getImageProvider() {
		return dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfImageProvider.INSTANCE;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager createColorManager() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource,
	 * dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager) instead.
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfTokenScanner createTokenScanner(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfTokenScanner createTokenScanner(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager colorManager) {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfTokenScanner(resource, colorManager);
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCodeCompletionHelper createCodeCompletionHelper() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCodeCompletionHelper();
	}
	
}
