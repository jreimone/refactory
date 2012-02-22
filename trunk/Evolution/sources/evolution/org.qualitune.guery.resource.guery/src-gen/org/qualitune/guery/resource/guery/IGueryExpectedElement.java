/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IGueryExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(org.qualitune.guery.resource.guery.IGueryExpectedElement follower, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<org.qualitune.guery.resource.guery.util.GueryPair<org.qualitune.guery.resource.guery.IGueryExpectedElement, org.qualitune.guery.resource.guery.mopp.GueryContainedFeature[]>> getFollowers();
	
}
