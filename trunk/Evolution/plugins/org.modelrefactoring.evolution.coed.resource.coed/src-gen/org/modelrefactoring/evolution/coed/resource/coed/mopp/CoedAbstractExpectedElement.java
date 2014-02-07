/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class CoedAbstractExpectedElement implements org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement {
	
	private EClass ruleMetaclass;
	
	private Set<org.modelrefactoring.evolution.coed.resource.coed.util.CoedPair<org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[]>> followers = new LinkedHashSet<org.modelrefactoring.evolution.coed.resource.coed.util.CoedPair<org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[]>>();
	
	public CoedAbstractExpectedElement(EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement follower, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[] path) {
		followers.add(new org.modelrefactoring.evolution.coed.resource.coed.util.CoedPair<org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[]>(follower, path));
	}
	
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.util.CoedPair<org.modelrefactoring.evolution.coed.resource.coed.ICoedExpectedElement, org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
