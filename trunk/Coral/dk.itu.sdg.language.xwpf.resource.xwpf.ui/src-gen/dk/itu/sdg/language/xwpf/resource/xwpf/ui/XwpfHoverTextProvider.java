/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

public class XwpfHoverTextProvider implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfHoverTextProvider {
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfDefaultHoverTextProvider defaultProvider = new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
