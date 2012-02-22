/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class GueryAbstractExpectedElement implements org.qualitune.guery.resource.guery.IGueryExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.qualitune.guery.resource.guery.util.GueryPair<org.qualitune.guery.resource.guery.IGueryExpectedElement, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[]>> followers = new java.util.LinkedHashSet<org.qualitune.guery.resource.guery.util.GueryPair<org.qualitune.guery.resource.guery.IGueryExpectedElement, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[]>>();
	
	public GueryAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.qualitune.guery.resource.guery.IGueryExpectedElement follower, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[] path) {
		followers.add(new org.qualitune.guery.resource.guery.util.GueryPair<org.qualitune.guery.resource.guery.IGueryExpectedElement, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.qualitune.guery.resource.guery.util.GueryPair<org.qualitune.guery.resource.guery.IGueryExpectedElement, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
