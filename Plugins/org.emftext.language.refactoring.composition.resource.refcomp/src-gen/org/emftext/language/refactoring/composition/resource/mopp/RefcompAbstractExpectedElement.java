/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class RefcompAbstractExpectedElement implements org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement {
	
	private EClass ruleMetaclass;
	
	private Set<org.emftext.language.refactoring.composition.resource.util.RefcompPair<org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement, org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[]>> followers = new LinkedHashSet<org.emftext.language.refactoring.composition.resource.util.RefcompPair<org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement, org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[]>>();
	
	public RefcompAbstractExpectedElement(EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement follower, org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[] path) {
		followers.add(new org.emftext.language.refactoring.composition.resource.util.RefcompPair<org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement, org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[]>(follower, path));
	}
	
	public Collection<org.emftext.language.refactoring.composition.resource.util.RefcompPair<org.emftext.language.refactoring.composition.resource.IRefcompExpectedElement, org.emftext.language.refactoring.composition.resource.mopp.RefcompContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
