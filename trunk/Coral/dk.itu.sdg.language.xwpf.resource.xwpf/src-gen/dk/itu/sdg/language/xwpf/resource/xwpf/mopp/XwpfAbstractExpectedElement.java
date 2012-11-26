/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class XwpfAbstractExpectedElement implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfPair<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[]>> followers = new java.util.LinkedHashSet<dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfPair<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[]>>();
	
	public XwpfAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement follower, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[] path) {
		followers.add(new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfPair<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfPair<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
