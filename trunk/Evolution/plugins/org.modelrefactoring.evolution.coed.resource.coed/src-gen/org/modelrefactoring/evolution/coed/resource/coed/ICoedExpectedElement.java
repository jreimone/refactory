/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed;

import java.util.Collection;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface ICoedExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement follower, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.util.CoedPair<org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[]>> getFollowers();
	
}
