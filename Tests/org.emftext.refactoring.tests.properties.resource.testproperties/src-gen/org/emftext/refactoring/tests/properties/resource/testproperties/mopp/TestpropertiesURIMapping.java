/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * org.emftext.refactoring.tests.properties.resource.testproperties.ITestproperties
 * URIMapping interface that can map identifiers to URIs.
 * </p>
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * org.emftext.refactoring.tests.properties.resource.testproperties.ITestproperties
 * URIMapping.
 */
public class TestpropertiesURIMapping<ReferenceType> implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesURIMapping<ReferenceType> {
	
	private URI uri;
	private String identifier;
	private String warning;
	
	public TestpropertiesURIMapping(String identifier, URI newIdentifier, String warning) {
		super();
		this.uri = newIdentifier;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public URI getTargetIdentifier() {
		return uri;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
