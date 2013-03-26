/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

/**
 * A basic implementation of the
 * org.emftext.refactoring.tests.properties.resource.testproperties.ITestproperties
 * URIMapping interface that can map identifiers to URIs.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * org.emftext.refactoring.tests.properties.resource.testproperties.ITestproperties
 * URIMapping.
 */
public class TestpropertiesURIMapping<ReferenceType> implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesURIMapping<ReferenceType> {
	
	private org.eclipse.emf.common.util.URI uri;
	private String identifier;
	private String warning;
	
	public TestpropertiesURIMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
		super();
		this.uri = newIdentifier;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public org.eclipse.emf.common.util.URI getTargetIdentifier() {
		return uri;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
