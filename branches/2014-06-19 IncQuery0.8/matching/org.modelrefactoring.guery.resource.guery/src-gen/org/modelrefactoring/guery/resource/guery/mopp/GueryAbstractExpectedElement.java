/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class GueryAbstractExpectedElement implements org.modelrefactoring.guery.resource.guery.IGueryExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.modelrefactoring.guery.resource.guery.util.GueryPair<org.modelrefactoring.guery.resource.guery.IGueryExpectedElement, org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[]>> followers = new java.util.LinkedHashSet<org.modelrefactoring.guery.resource.guery.util.GueryPair<org.modelrefactoring.guery.resource.guery.IGueryExpectedElement, org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[]>>();
	
	public GueryAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.modelrefactoring.guery.resource.guery.IGueryExpectedElement follower, org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[] path) {
		followers.add(new org.modelrefactoring.guery.resource.guery.util.GueryPair<org.modelrefactoring.guery.resource.guery.IGueryExpectedElement, org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.modelrefactoring.guery.resource.guery.util.GueryPair<org.modelrefactoring.guery.resource.guery.IGueryExpectedElement, org.modelrefactoring.guery.resource.guery.mopp.GueryContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
