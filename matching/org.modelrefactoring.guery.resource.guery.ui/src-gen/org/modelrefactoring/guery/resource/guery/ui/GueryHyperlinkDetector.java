/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.ui;

/**
 * A hyperlink detector returns hyperlink if the token, where the mouse cursor
 * hovers, is a proxy.
 */
public class GueryHyperlinkDetector implements org.eclipse.jface.text.hyperlink.IHyperlinkDetector {
	
	private org.modelrefactoring.guery.resource.guery.IGueryTextResource textResource;
	
	/**
	 * Creates a hyperlink detector.
	 * 
	 * @param resource the resource to use for calculating the locations.
	 */
	public GueryHyperlinkDetector(org.eclipse.emf.ecore.resource.Resource resource) {
		textResource = (org.modelrefactoring.guery.resource.guery.IGueryTextResource) resource;
	}
	
	public org.eclipse.jface.text.hyperlink.IHyperlink[] detectHyperlinks(org.eclipse.jface.text.ITextViewer textViewer, org.eclipse.jface.text.IRegion region, boolean canShowMultipleHyperlinks) {
		org.modelrefactoring.guery.resource.guery.IGueryLocationMap locationMap = textResource.getLocationMap();
		java.util.List<org.eclipse.emf.ecore.EObject> elementsAtOffset = locationMap.getElementsAt(region.getOffset());
		org.eclipse.emf.ecore.EObject resolvedEObject = null;
		for (org.eclipse.emf.ecore.EObject eObject : elementsAtOffset) {
			if (eObject.eIsProxy()) {
				resolvedEObject = org.eclipse.emf.ecore.util.EcoreUtil.resolve(eObject, textResource);
				if (resolvedEObject == eObject) {
					continue;
				}
				int offset = locationMap.getCharStart(eObject);
				int length = locationMap.getCharEnd(eObject) - offset + 1;
				String text = null;
				try {
					text = textViewer.getDocument().get(offset, length);
				} catch (org.eclipse.jface.text.BadLocationException e) {
				}
				// we skip elements that are not contained in a resource, because we cannot jump
				// to them anyway
				if (resolvedEObject.eResource() != null) {
					org.eclipse.jface.text.hyperlink.IHyperlink hyperlink = new org.modelrefactoring.guery.resource.guery.ui.GueryHyperlink(new org.eclipse.jface.text.Region(offset, length), resolvedEObject, text);
					return new org.eclipse.jface.text.hyperlink.IHyperlink[] {hyperlink};
				}
			}
		}
		return null;
	}
	
}
