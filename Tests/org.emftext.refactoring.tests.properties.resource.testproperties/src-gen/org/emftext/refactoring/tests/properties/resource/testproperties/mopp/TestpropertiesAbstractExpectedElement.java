/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class TestpropertiesAbstractExpectedElement implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesPair<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement, org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesPair<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement, org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[]>>();
	
	public TestpropertiesAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement follower, org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[] path) {
		followers.add(new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesPair<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement, org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesPair<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesExpectedElement, org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
