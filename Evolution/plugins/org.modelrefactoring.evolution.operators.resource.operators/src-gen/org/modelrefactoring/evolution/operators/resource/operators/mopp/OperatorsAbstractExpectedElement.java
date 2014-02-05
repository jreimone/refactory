/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class OperatorsAbstractExpectedElement implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement {
	
	private EClass ruleMetaclass;
	
	private Set<org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsPair<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[]>> followers = new LinkedHashSet<org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsPair<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[]>>();
	
	public OperatorsAbstractExpectedElement(EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement follower, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[] path) {
		followers.add(new org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsPair<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[]>(follower, path));
	}
	
	public Collection<org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsPair<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsExpectedElement, org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
