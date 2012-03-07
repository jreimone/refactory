/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class PropertiesAbstractExpectedElement implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesPair<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement, org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesContainedFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesPair<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement, org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesContainedFeature[]>>();
	
	public PropertiesAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement follower, org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesContainedFeature[] path) {
		followers.add(new org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesPair<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement, org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesPair<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesExpectedElement, org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
