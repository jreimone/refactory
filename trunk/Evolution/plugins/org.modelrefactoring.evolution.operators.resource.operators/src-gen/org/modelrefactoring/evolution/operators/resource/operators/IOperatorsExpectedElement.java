/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;

import java.util.Collection;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IOperatorsExpectedElement {
	
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
	public org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement follower, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public Collection<org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsPair<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[]>> getFollowers();
	
}
