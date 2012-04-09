/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
