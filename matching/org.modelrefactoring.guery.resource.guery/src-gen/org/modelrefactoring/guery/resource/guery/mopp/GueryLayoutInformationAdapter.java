/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

/**
 * A GueryLayoutInformationAdapter is used to store layout information that is
 * found while parsing text files. Layout information does include all unused
 * tokens. Usually, these are whitespace characters, line breaks and comments, but
 * depending on the concrete syntax definition it can also include other tokens.
 * GueryLayoutInformationAdapters are attached to EObjects and aggregate multiple
 * LayoutInformation objects. Each of these objects contains the layout that was
 * found before a keyword, attribute or reference.
 * 
 * Since layout information is stored in EAdapters, models can be transformed and
 * modified, while still keeping the formatting of the original text document from
 * which the model was originally created.
 */
public class GueryLayoutInformationAdapter implements org.eclipse.emf.common.notify.Adapter {
	
	/**
	 * The EObject that this adapter is attached to.
	 */
	private org.eclipse.emf.common.notify.Notifier target;
	
	/**
	 * A list of LayoutInformation objects. one for each keyword, attribute and
	 * reference.
	 */
	private java.util.List<org.modelrefactoring.guery.resource.guery.mopp.GueryLayoutInformation> layoutInformations = new java.util.ArrayList<org.modelrefactoring.guery.resource.guery.mopp.GueryLayoutInformation>();
	
	/**
	 * Returns the EObject that this adapter is attached to.
	 */
	public org.eclipse.emf.common.notify.Notifier getTarget() {
		return target;
	}
	
	public boolean isAdapterForType(Object type) {
		return false;
	}
	
	public void notifyChanged(org.eclipse.emf.common.notify.Notification notification) {
	}
	
	/**
	 * Sets the EObject that this adapter is attached to.
	 */
	public void setTarget(org.eclipse.emf.common.notify.Notifier newTarget) {
		this.target = newTarget;
	}
	
	public java.util.List<org.modelrefactoring.guery.resource.guery.mopp.GueryLayoutInformation> getLayoutInformations() {
		return layoutInformations;
	}
	
	public void addLayoutInformation(org.modelrefactoring.guery.resource.guery.mopp.GueryLayoutInformation layoutInformation) {
		layoutInformations.add(layoutInformation);
	}
	
	/**
	 * Iterates over all layout informations and searches for those that refer to the
	 * given proxy object. Then, the old target of these layout informations (i.e.,
	 * the proxy) is changed to the new target. This is required, because at the time
	 * when the layout information is collected, all references point to proxy
	 * objects. But, later on these proxy objects are replaced by the objects that are
	 * referenced. To keep the layout information up to date, this replacement must be
	 * propagated to all attached layout information objects.
	 */
	public void replaceProxy(org.eclipse.emf.ecore.EObject proxy, org.eclipse.emf.ecore.EObject target) {
		for (org.modelrefactoring.guery.resource.guery.mopp.GueryLayoutInformation layoutInformation : layoutInformations) {
			layoutInformation.replaceProxy(proxy, target);
		}
	}
	
}
